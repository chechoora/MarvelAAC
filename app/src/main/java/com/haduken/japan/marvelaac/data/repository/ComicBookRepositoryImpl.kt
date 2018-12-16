package com.haduken.japan.marvelaac.data.repository

import com.haduken.japan.marvelaac.data.source.CacheComicBookSource
import com.haduken.japan.marvelaac.data.source.DataBaseComicSource
import com.haduken.japan.marvelaac.data.source.ServerComicSource
import com.haduken.japan.marvelaac.domain.model.ComicBook
import com.haduken.japan.marvelaac.domain.model.ComicBookItem
import com.haduken.japan.marvelaac.domain.model.toComicBookItem
import com.haduken.japan.marvelaac.extensions.chooseFirstSuccess
import com.haduken.japan.marvelaac.extensions.chooseFirstSuccessNotEmpty
import java.util.concurrent.Executors
import javax.inject.Inject


class ComicBookRepositoryImpl @Inject constructor(private val serverSource: ServerComicSource,
                                                  private val databaseSource: DataBaseComicSource,
                                                  private val cacheSources: CacheComicBookSource) : ComicBookRepository {

    private val dataBaseThreadExecutor = Executors.newFixedThreadPool(2)
    private val serverThreadExecutor = Executors.newFixedThreadPool(2)

    override fun getComicBook(comicId: String, complete: (ComicBook) -> Unit,
                              error: (Exception) -> Unit) {
        serverThreadExecutor.submit {
            val response = serverSource.getComicBook(comicId)
            if (response.success) {
                val comicBook = response.getResponseData()
                complete.invoke(comicBook)
                databaseSource.save(comicBook)
                cacheSources.save(comicBook)
            } else {
                error.invoke(response.getError())
            }
        }
        dataBaseThreadExecutor.submit {
            val response = chooseFirstSuccess(cacheSources.getComicBook(comicId), databaseSource.getComicBook(comicId))
            response?.let {
                complete.invoke(response.getResponseData())
            }
        }
    }

    override fun getComicBookItems(complete: (List<ComicBookItem>) -> Unit,
                                   error: (Exception) -> Unit) {
        serverThreadExecutor.submit {
            val response = serverSource.getComicBooks()
            if (response.success) {
                val comicBooks = response.getResponseData()
                complete.invoke(comicBooks.map { toComicBookItem(it) })
                databaseSource.save(comicBooks)
                cacheSources.save(comicBooks)
            } else {
                error.invoke(response.getError())
            }
        }
        dataBaseThreadExecutor.submit {
            val comicBookItems = chooseFirstSuccessNotEmpty(cacheSources.getComicBookItems(), databaseSource.getComicBookItems())
            comicBookItems?.let {
                complete.invoke(comicBookItems)
            }
        }
    }

}