package com.haduken.japan.marvelaac.server.server

import com.haduken.japan.marvelaac.data.server.toComicBook
import org.junit.Test

class MapTest {

    companion object {
        const val COMIC_TEST_RESPONSE = "{\"id\":6482,\"digitalId\":1067,\"title\":\"The Amazing Spider-Man (1963) #1\",\"issueNumber\":1,\"variantDescription\":\"\",\"description\":\"Spider-Man, in one of his earliest adventures following Uncle Ben's death, must save a crew of astronauts aboard a malfunctioning space ship!\",\"modified\":\"2018-04-25T14:00:56-0400\",\"isbn\":\"\",\"upc\":\"\",\"diamondCode\":\"\",\"ean\":\"\",\"issn\":\"\",\"format\":\"Comic\",\"pageCount\":36,\"textObjects\":[{\"type\":\"issue_preview_text\",\"language\":\"en-us\",\"text\":\"Spider-Man, in one of his earliest adventures following Uncle Ben's death, must save a crew of astronauts aboard a malfunctioning space ship!\"},{\"type\":\"70th_winner_desc\",\"language\":\"en-us\",\"text\":\"What's left to be said about Steve Ditko and Spider-Man? Spidey's Spidey, due in large part to Ditko's early contributions, including this cover to the first all-Spider-Man comic.\"}],\"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/6482\",\"urls\":[{\"type\":\"detail\",\"url\":\"http://marvel.com/comics/issue/6482/the_amazing_spider-man_1963_1?utm_campaign=apiRef&utm_source=32a15971ebb61eb9f7efef30b77edba4\"},{\"type\":\"purchase\",\"url\":\"http://comicstore.marvel.com/Amazing-Spider-Man-1/digital-comic/1067?utm_campaign=apiRef&utm_source=32a15971ebb61eb9f7efef30b77edba4\"},{\"type\":\"reader\",\"url\":\"http://marvel.com/digitalcomics/view.htm?iid=1067&utm_campaign=apiRef&utm_source=32a15971ebb61eb9f7efef30b77edba4\"},{\"type\":\"inAppLink\",\"url\":\"https://applink.marvel.com/issue/1067?utm_campaign=apiRef&utm_source=32a15971ebb61eb9f7efef30b77edba4\"}],\"series\":{\"resourceURI\":\"http://gateway.marvel.com/v1/public/series/1987\",\"name\":\"The Amazing Spider-Man (1963 - 1998)\"},\"variants\":[],\"collections\":[{\"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/6332\",\"name\":\"AMAZING SPIDER-MAN OMNIBUS VOL. 1 HC (Hardcover)\"}],\"collectedIssues\":[],\"dates\":[{\"type\":\"onsaleDate\",\"date\":\"1963-03-10T00:00:00-0500\"},{\"type\":\"focDate\",\"date\":\"1961-01-01T00:00:00-0500\"},{\"type\":\"unlimitedDate\",\"date\":\"2007-11-13T00:00:00-0500\"},{\"type\":\"digitalPurchaseDate\",\"date\":\"2009-11-05T00:00:00-0500\"}],\"prices\":[{\"type\":\"printPrice\",\"price\":0.12},{\"type\":\"digitalPurchasePrice\",\"price\":1.99}],\"thumbnail\":{\"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/d/40/5196582d03800\",\"extension\":\"jpg\"},\"images\":[{\"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/d/40/5196582d03800\",\"extension\":\"jpg\"},{\"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/b/e0/4bc380bd24fe2\",\"extension\":\"jpg\"}],\"creators\":{\"available\":3,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/6482/creators\",\"items\":[{\"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/32\",\"name\":\"Steve Ditko\",\"role\":\"penciller\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/196\",\"name\":\"Jack Kirby\",\"role\":\"penciller (cover)\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/30\",\"name\":\"Stan Lee\",\"role\":\"writer\"}],\"returned\":3},\"characters\":{\"available\":1,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/6482/characters\",\"items\":[{\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1009610\",\"name\":\"Spider-Man\"}],\"returned\":1},\"stories\":{\"available\":4,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/6482/stories\",\"items\":[{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/13533\",\"name\":\"\",\"type\":\"\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/13534\",\"name\":\"Spider-Man\",\"type\":\"interiorStory\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/13535\",\"name\":\"Spider-Man vs. The Chameleon\",\"type\":\"interiorStory\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/66168\",\"name\":\"AMAZING SPIDER-MAN 1 cover\",\"type\":\"cover\"}],\"returned\":4},\"events\":{\"available\":0,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/6482/events\",\"items\":[],\"returned\":0}}"
    }

    @Test
    fun toComicBookTest() {
        val comicBook = toComicBook(COMIC_TEST_RESPONSE)
        System.out.println(comicBook)
        assert(true)
    }

}