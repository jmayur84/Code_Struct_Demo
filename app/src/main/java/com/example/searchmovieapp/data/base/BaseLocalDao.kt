package com.example.searchmovieapp.data.base

import com.example.searchmovieapp.data.model.CarouselItemRM
import com.example.searchmovieapp.data.model.MovieItemRM

open class BaseLocalDao {

    fun getGenreList(): ArrayList<CarouselItemRM> {
        val mList: ArrayList<CarouselItemRM> = ArrayList()
        mList.add(CarouselItemRM("Action", "action"))
        mList.add(CarouselItemRM("Adventure", "adventure"))
        mList.add(CarouselItemRM("Animation", "animation"))
        mList.add(CarouselItemRM("Drama", "drama"))
        mList.add(CarouselItemRM("Fantasy", "fantasy"))
        mList.add(CarouselItemRM("Horror", "horror"))
        mList.add(CarouselItemRM("Science Friction", "science_friction"))
        return mList
    }

    fun getActionMovieList(): ArrayList<MovieItemRM> {
        val mList: ArrayList<MovieItemRM> = ArrayList()
        mList.add(
            MovieItemRM(
                "Star Wars:The Phantom Menace",
                "Anakin Skywalker, a young slave strong with the Force, is discovered on Tatooine. Meanwhile, the evil Sith have returned, enacting their plot for revenge against the Jedi.",
                "star_wars"
            )
        )
        mList.add(
            MovieItemRM(
                "Baby Driver",
                "After being coerced into working for a crime boss, a young getaway driver finds himself taking part in a heist doomed to fail.",
                "baby_driver"
            )
        )
        mList.add(
            MovieItemRM(
                "Everything Everywhere All at Once",
                "An aging Chinese immigrant is swept up in an insane adventure, where she alone can save what’s important to her by connecting with the lives she could have led in other universes.",
                "everything"
            )
        )
        mList.add(
            MovieItemRM(
                "The Dark Knight",
                "Batman raises the stakes in his war on crime. With the help of Lt. Jim Gordon and District Attorney Harvey Dent, Batman sets out to dismantle the remaining criminal organizations that plague the streets. The partnership proves to be effective, but they soon find themselves prey to a reign of chaos unleashed by a rising criminal mastermind known to the terrified citizens of Gotham as the Joker.",
                "dark_knight"
            )
        )
        mList.add(
            MovieItemRM(
                "Kill Bill: Vol. 1",
                "An assassin is shot by her ruthless employer, Bill, and other members of their assassination circle – but she lives to plot her vengeance.",
                "kill_bill"
            )
        )
        mList.add(
            MovieItemRM(
                "Captain America: Civil War",
                "Following the events of Age of Ultron, the collective governments of the world pass an act designed to regulate all superhuman activity. This polarizes opinion amongst the Avengers, causing two factions to side with Iron Man or Captain America, which causes an epic battle between former allies.",
                "civil_war"
            )
        )
        mList.add(
            MovieItemRM(
                "John Wick",
                "Ex-hitman John Wick comes out of retirement to track down the gangsters that took everything from him",
                "john_wick"
            )
        )
        return mList
    }

    fun getAdventureMovieList(): ArrayList<MovieItemRM> {
        val mList: ArrayList<MovieItemRM> = ArrayList()
        mList.add(
            MovieItemRM(
                "Harry Potter and the Philosopher’s Stone",
                "Harry Potter has lived under the stairs at his aunt and uncle’s house his whole life. But on his 11th birthday, he learns he’s a powerful wizard – with a place waiting for him at the Hogwarts School of Witchcraft and Wizardry. As he learns to harness his newfound powers with the help of the school’s kindly headmaster, Harry uncovers the truth about his parents’ deaths – and about the villain who’s to blame.",
                "harry"
            )
        )
        mList.add(
            MovieItemRM(
                "The Lord of the Rings: The Fellowship of the Ring",
                "Young hobbit Frodo Baggins, after inheriting a mysterious ring from his uncle Bilbo, must leave his home in order to keep it from falling into the hands of its evil creator. Along the way, a fellowship is formed to protect the ringbearer and make sure that the ring arrives at its final destination: Mt. Doom, the only place where it can be destroyed.",
                "lord"
            )
        )
        mList.add(
            MovieItemRM(
                "Mad Max: Fury Road",
                "An apocalyptic story set in the furthest reaches of our planet, in a stark desert landscape where humanity is broken, and most everyone is crazed fighting for the necessities of life. Within this world exist two rebels on the run who just might be able to restore order.",
                "mad_max"
            )
        )
        mList.add(
            MovieItemRM(
                "Avatar: The Way of Water",
                "Set more than a decade after the events of the first film, learn the story of the Sully family (Jake, Neytiri, and their kids), the trouble that follows them, the lengths they go to keep each other safe, the battles they fight to stay alive, and the tragedies they endure.",
                "aavatar"
            )
        )
        mList.add(
            MovieItemRM(
                "Back to the Future",
                "Eighties teenager Marty McFly is accidentally sent back in time to 1955, inadvertently disrupting his parents’ first meeting and attracting his mother’s romantic interest. Marty must repair the damage to history by rekindling his parents’ romance and - with the help of his eccentric inventor friend Doc Brown - return to 1985.",
                "back"
            )
        )
        return mList
    }

    fun getDramaMovieList(): ArrayList<MovieItemRM> {
        val mList: ArrayList<MovieItemRM> = ArrayList()
        mList.add(
            MovieItemRM(
                "Forrest Gump",
                "A man with a low IQ has accomplished great things in his life and been present during significant historic events—in each case, far exceeding what anyone imagined he could do. But despite all he has achieved, his one true love eludes him.",
                "forrest"
            )
        )
        mList.add(
            MovieItemRM(
                "The Truman Show",
                "Truman Burbank is the star of The Truman Show, a 24-hour-a-day reality TV show that broadcasts every aspect of his life without his knowledge. His entire life has been an unending soap opera for consumption by the rest of the world. And everyone he knows, including his wife and his best friend is really an actor, paid to be part of his life.",
                "truman"
            )
        )
        mList.add(
            MovieItemRM(
                "Titanic",
                "101-year-old Rose DeWitt Bukater tells the story of her life aboard the Titanic, 84 years later. A young Rose boards the ship with her mother and fiancé. Meanwhile, Jack Dawson and Fabrizio De Rossi win third-class tickets aboard the ship. Rose tells the whole story from Titanic’s departure through to its death—on its first and last voyage—on April 15, 1912.",
                "titanic"
            )
        )
        return mList
    }

    fun getHorrorMovieList(): ArrayList<MovieItemRM> {
        val mList: ArrayList<MovieItemRM> = ArrayList()
        mList.add(
            MovieItemRM(
                "Scream",
                "A killer known as Ghostface begins killing off teenagers, and as the body count begins rising, one girl and her friends find themselves contemplating the ‘rules’ of horror films as they find themselves living in a real-life one.",
                "scream"
            )
        )
        mList.add(
            MovieItemRM(
                "The Shining",
                "Jack Torrance accepts a caretaker job at the Overlook Hotel, where he, along with his wife Wendy and their son Danny, must live isolated from the rest of the world for the winter. But they aren’t prepared for the madness that lurks within.",
                "shining"
            )
        )
        mList.add(
            MovieItemRM(
                "The Black Phone",
                "Finney Shaw, a shy but clever 13-year-old boy, is abducted by a sadistic killer and trapped in a soundproof basement where screaming is of little use. When a disconnected phone on the wall begins to ring, Finney discovers that he can hear the voices of the killer’s previous victims. And they are dead set on making sure that what happened to them doesn’t happen to Finney.",
                "black"
            )
        )
        mList.add(
            MovieItemRM(
                "Smile",
                "After witnessing a bizarre, traumatic incident involving a patient, Dr. Rose Cotter starts experiencing frightening occurrences that she can’t explain. As an overwhelming terror begins taking over her life, Rose must confront her troubling past in order to survive and escape her horrifying new reality.",
                "smile"
            )
        )
        mList.add(
            MovieItemRM(
                "The Cabin in the Woods",
                "Five college friends spend the weekend at a remote cabin in the woods, where they get more than they bargained for. Together, they must discover the truth behind the cabin in the woods.",
                "cabin"
            )
        )
        mList.add(
            MovieItemRM(
                "The Conjuring",
                "Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by a dark presence in their farmhouse. Forced to confront a powerful entity, the Warrens find themselves caught in the most terrifying case of their lives.",
                "conjuring"
            )
        )
        return mList
    }

    fun getSciFiMovieList(): ArrayList<MovieItemRM> {
        val mList: ArrayList<MovieItemRM> = ArrayList()
        mList.add(
            MovieItemRM(
                "Ex Machina",
                "Caleb, a coder at the world’s largest internet company, wins a competition to spend a week at a private mountain retreat belonging to Nathan, the reclusive CEO of the company. But when Caleb arrives at the remote location he finds that he will have to participate in a strange and fascinating experiment in which he must interact with the world’s first true artificial intelligence, housed in the body of a beautiful robot girl.",
                "ex"
            )
        )
        mList.add(
            MovieItemRM(
                "Free Guy",
                "A bank teller called Guy realizes he is a background character in an open world video game called Free City that will soon go offline.",
                "free"
            )
        )
        mList.add(
            MovieItemRM(
                "Annihilation",
                "A biologist signs up for a dangerous, secret expedition into a mysterious zone where the laws of nature don’t apply.",
                "anni"
            )
        )
        mList.add(
            MovieItemRM(
                "The Matrix",
                "Set in the 22nd century, The Matrix tells the story of a computer hacker who joins a group of underground insurgents fighting the vast and powerful computers who now rule the earth.",
                "matrix"
            )
        )
        return mList
    }

    fun getAnimationMovieList(): ArrayList<MovieItemRM> {
        val mList: ArrayList<MovieItemRM> = ArrayList()
        mList.add(
            MovieItemRM(
                "Turning Red",
                "Thirteen-year-old Mei is experiencing the awkwardness of being a teenager with a twist – when she gets too excited, she transforms into a giant red panda.",
                "red"
            )
        )
        mList.add(
            MovieItemRM(
                "Incredibles 2",
                "Elastigirl springs into action to save the day, while Mr. Incredible faces his greatest challenge yet – taking care of the problems of his three children.",
                "incredibles"
            )
        )
        mList.add(
            MovieItemRM(
                "Shrek 2",
                "Shrek, Fiona and Donkey set off to Far, Far Away to meet Fiona’s mother and father. But not everyone is happy. Shrek and the King find it hard to get along, and there’s tension in the marriage. The fairy godmother discovers that Shrek has married Fiona instead of her Son Prince Charming and sets about destroying their marriage.",
                "shrek"
            )
        )
        return mList
    }

    fun getFantasyMovieList(): ArrayList<MovieItemRM> {
        val mList: ArrayList<MovieItemRM> = ArrayList()
        mList.add(
            MovieItemRM(
                "Charlie and the Chocolate Factory",
                "A young boy wins a tour through the most magnificent chocolate factory in the world, led by the world’s most unusual candy maker.",
                "chocolate"
            )
        )
        mList.add(
            MovieItemRM(
                "E.T. the Extra-Terrestrial",
                "After a gentle alien becomes stranded on Earth, the being is discovered and befriended by a young boy named Elliott. Bringing the extraterrestrial into his suburban California house, Elliott introduces E.T., as the alien is dubbed, to his brother and his little sister, Gertie, and the children decide to keep its existence a secret. Soon, however, E.T. falls ill, resulting in government intervention and a dire situation for both Elliott and the alien.",
                "et"
            )
        )
        mList.add(
            MovieItemRM(
                "Fantastic Beasts and Where to Find Them",
                "In 1926, Newt Scamander arrives at the Magical Congress of the United States of America with a magically expanded briefcase, which houses a number of dangerous creatures and their habitats. When the creatures escape from the briefcase, it sends the American wizarding authorities after Newt, and threatens to strain even further the state of magical and non-magical relations.",
                "beasts"
            )
        )
        mList.add(
            MovieItemRM(
                "Edward Scissorhands",
                "A small suburban town receives a visit from a castaway unfinished science experiment named Edward.",
                "edward"
            )
        )
        return mList
    }
}