package Controllers;

import Models.Book;

public class BookController {
    public void sortByImprovedBubble(Book[] books) {
        for(int i = 0; i < books.length-1; i++) {
            boolean exchange = false;
            for(int j = 0; j < books.length-1-i; j++) {
                if (books[j].getName().compareTo(books[j+1].getName()) > 0) {
                    Book aux = books[j];
                    books[j] = books[j+1];
                    books[j+1] = aux;
                    exchange = true;
                }
            }
            if (!exchange) break;
        }
    }

    public Book searchByName(Book[] books, String name) {
        int lower = 0;
        int higher = books.length-1;
        while (higher>=lower) {
            int central = (higher+lower)/2;
            if (books[central].getName().equalsIgnoreCase(name)) return books[central];
            if (books[central].getName().compareTo(name) > 0) higher = central-1;
            else lower = central+1;
        }
        return null;
    }
}
