import java.util.*;
import java.util.Scanner;

class Book{
    String title;
    String author;
    String ISBN;
    int totalCopies;
    int issuedCopies;

    Book(){
        this.title = "";
        this.author = "";
        this.ISBN = "";
        this.totalCopies = 0;
        this.issuedCopies = 0;
    }

    Book(String title){
        this.title = title;
        this.author = "";
        this.ISBN = "";
        this.totalCopies = 0;
        this.issuedCopies = 0;
    }

    Book(String title, String author, String ISBN){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.totalCopies = 0;
        this.issuedCopies = 0;
    }

    public void searchBook(String search){
        if(this.title.contains(search) || this.author.contains(search)){
            System.out.println("Title: " + this.title);
            System.out.println("Author: " + this.author);
            System.out.println("ISBN: " + this.ISBN);
            System.out.println("Total Copies: " + this.totalCopies);
            System.out.println("Issued Copies: " + this.issuedCopies);
        }
    }

    public void issueBook(){
        if(this.totalCopies > 0){
            this.totalCopies--;
            this.issuedCopies++;
        }
    }

    public void returnBook(){
        if(this.issuedCopies > 0){
            this.totalCopies++;
            this.issuedCopies--;
        }
    }

    public void printBookDetails(){
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("ISBN: " + this.ISBN);
        System.out.println("Total Copies: " + this.totalCopies);
        System.out.println("Issued Copies: " + this.issuedCopies);
    }

    public void printUpperCase(){
        System.out.println("Title: " + this.title.toUpperCase());
        System.out.println("Author: " + this.author.toUpperCase());
        System.out.println("ISBN: " + this.ISBN);
        System.out.println("Total Copies: " + this.totalCopies);
        System.out.println("Issued Copies: " + this.issuedCopies);
    }

    public void addBook(){
        this.totalCopies++;
    }

    public void updateBookName(String oldName, String newName){
        this.title = this.title.replace(oldName, newName);
    }

    public void showBooks(Book[] books){
        Arrays.sort(books, new Comparator<Book>(){
            @Override
            public int compare(Book b1, Book b2){
                return b1.title.compareTo(b2.title);
            }
        });

        for(Book book: books){
            System.out.println(book.title);
        }
    }

}

public class LibraryApplication_S20220010207{
    public static void main(String[] args){
        Book[] books = new Book[5];
        books[0] = new Book("Harry Potter", "J.K. Rowling", "123456789");
        books[1] = new Book("The Hobbit", "J.R.R. Tolkien", "987654321");
        books[2] = new Book("The Lord of the Rings", "J.R.R. Tolkien", "456789123");
        books[3] = new Book("The Alchemist", "Paulo Coelho", "321654987");
        books[4] = new Book("The Da Vinci Code", "Dan Brown", "789456123");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the search string: ");
        String search = sc.nextLine();

        for(Book book: books){
            book.searchBook(search);
        }

        System.out.println("Enter the book name to issue: ");
        String issue = sc.nextLine();

        for(Book book: books){
            if(book.title.equals(issue)){
                book.issueBook();
            }
        }

        System.out.println("Enter the book name to return: ");
        String r = sc.nextLine();

        for(Book book: books){
            if(book.title.equals(r)){
                book.returnBook();
            }
        }

        System.out.println("Enter the book name to print details: ");
        String details = sc.nextLine();

        for(Book book: books){
            if(book.title.equals(details)){
                book.printBookDetails();
            }
        }

        System.out.println("Enter the book name to print details in uppercase: ");
        String upper = sc.nextLine();

        for(Book book: books){
            if(book.title.equals(upper)){
                book.printUpperCase();
            }
        }

        System.out.println("Enter the book name to add: ");
        String add = sc.nextLine();

        for(Book book: books){
            if(book.title.equals(add)){
                book.addBook();
            }
        }

        System.out.println("Enter the book name to update: ");
        String update = sc.nextLine();

        for(Book book: books){
            if(book.title.equals(update)){
                System.out.println("Enter the old name: ");
                String oldName = sc.nextLine();
                System.out.println("Enter the new name: ");
                String newName = sc.nextLine();
                book.updateBookName(oldName, newName);
        
            }
        }

        showBooks(books);

    }
static void showBooks(Book[] books){
        Arrays.sort(books, new Comparator<Book>(){
            @Override
            public int compare(Book b1, Book b2){
                return b1.title.compareTo(b2.title);
            }
        });

        for(Book book: books){
            System.out.println(book.title);
        }
    }
}

