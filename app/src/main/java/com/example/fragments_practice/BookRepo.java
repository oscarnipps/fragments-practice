package com.example.fragments_practice;

import java.util.ArrayList;
import java.util.List;

public class BookRepo {

    public static List<Book> getBookList() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(
                "lords of the rings chronicles",
                "The lords of the rings describes a fantasy that entails a dwarf on th verge of destruction all because of a ring",
                "james baldwin",
                "12 June ,2006",
                4,
                false)
        );
        books.add(new Book(
                "One Hundred Years of Solitude",
                "“One Hundred Years of Solitude” is being told by a know-it-all storyteller. The book has 12 chapters.",
                "burke smith",
                "12 June ,2010",
                5,
                false)
        );
        books.add(new Book(
                "Romeo and Juliet",
                "Romeo and Juliette is an epic love story whose plot is set in a small Italian city Verona",
                "david eve",
                "12 June ,2014",
                2,
                false)
        );
        books.add(new Book(
                "Altlas revenge",
                "Up in the skies lies the destiny of luke atlas the veteran who plots to save the day from the digimon beasts",
                "micheal scott",
                "12 June ,2008",
                3,
                false)
        );
        books.add(new Book(
                "Christmas Carol",
                "A Christmas Carol written by Charles Dickens was published as a novella on December 19th which was full of love",
                "richard dave",
                "12 December ,2009",
                3,
                false)
        );
        books.add(new Book(
                "Samurai jack revenge",
                "The lords samurai engage in a legacy war which leads all clans to consume and destroy themselves in a horrific war",
                "david baldwin",
                "12 June ,2018",
                1,
                false)
        );
        return books;
    }

}
