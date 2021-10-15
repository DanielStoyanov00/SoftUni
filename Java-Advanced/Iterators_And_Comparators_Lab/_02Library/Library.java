package _02Library;

import java.util.Iterator;

public class Library<Book> implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    public Iterator<Book> iterator(){
        return new LibraryIterator();
    }

    private class LibraryIterator implements Iterator<Book>{
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return this.counter < books.length;
        }

        @Override
        public Book next() {
                Book book = books[counter];
                this.counter++;
                return book;
            }
        }
    }



