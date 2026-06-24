package exercise6;

import java.util.Arrays;
import java.util.Comparator;

class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID='" + bookId + '\'' +
                ", Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                '}';
    }
}

public class LibraryManagementSystem {

    public static Book linearSearchByTitle(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearchByTitle(Book[] books, String targetTitle) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(targetTitle);

            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("B003", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B001", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B005", "1984", "George Orwell"),
            new Book("B002", "Moby Dick", "Herman Melville"),
            new Book("B004", "Pride and Prejudice", "Jane Austen")
        };

        System.out.println("--- Unsorted Library Catalog ---");
        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println("\n--- Testing Linear Search ---");
        String searchTitle = "1984";
        Book foundLinear = linearSearchByTitle(books, searchTitle);
        System.out.println("Searching for '" + searchTitle + "': " + (foundLinear != null ? foundLinear : "Not Found"));

        Arrays.sort(books, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

        System.out.println("\n--- Sorted Library Catalog ---");
        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println("\n--- Testing Binary Search ---");
        Book foundBinary = binarySearchByTitle(books, searchTitle);
        System.out.println("Searching for '" + searchTitle + "': " + (foundBinary != null ? foundBinary : "Not Found"));

        String missingTitle = "The Catcher in the Rye";
        System.out.println("\nSearching for missing book '" + missingTitle + "':");
        Book missingLinear = linearSearchByTitle(books, missingTitle);
        System.out.println("Linear Search: " + (missingLinear != null ? missingLinear : "Not Found"));
        Book missingBinary = binarySearchByTitle(books, missingTitle);
        System.out.println("Binary Search: " + (missingBinary != null ? missingBinary : "Not Found"));
    }
}
