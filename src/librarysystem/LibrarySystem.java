package librarysystem;

import java.util.Scanner;
import java.util.ArrayList;

public class LibrarySystem {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<book1> bookList = new ArrayList<>();

    public static void main(String[] args) {
        bookList = FileHandling.readFile();
        while (true) {

            System.out.println("Hi, wlcome to my library system");
            System.out.println("What owuld you like to do next");
            System.out.println("1 - add new book");
            System.out.println("2 - delete a book");
            System.out.println("3 - view a book");
            System.out.println("4 - Edit a book");
            System.out.println("0 - Exit");
            int userChoice = input.nextInt();
            switch (userChoice) {
                case 1:
                    addBook();
                    break;

                case 2:

                    deleteBook();
                    break;

                case 3:

                    viewBooks();
                    break;

                case 4:

                    editBook();
                    break;

                case 0:
                    FileHandling.writeFile(bookList);
                    System.exit(0);
            }
        }
    }

    public static void addBook() {
        System.out.println("Please type in an ISBN");
        String ISBN = input.next();
        System.out.println("Please type in an Author");
        input.nextLine();//extra to not skip lines
        String Author = input.nextLine();
        System.out.println("Please type in a releaseDate");
        String releaseDate = input.next();
        System.out.println("Please type in a price");
        double price = input.nextDouble();
        System.out.println("Please type in a title");
        input.nextLine();//extra to not skip line
        String title = input.nextLine();

        book1 myBook = new book1(ISBN, Author, releaseDate, price, title);
        System.out.println(myBook.toString());
        bookList.add(myBook);

    }

    public static void viewBooks() {
        if (bookList.isEmpty()) {
            System.out.println("Sorry, no books");
        } else {

            for (int i = 0; i < bookList.size(); i++) {
                System.out.println(bookList.get(i).toString());
            }
        }
    }

    public static void deleteBook() {
        if (bookList.isEmpty()) {
            System.out.println("Sorry, no books so cant delete any");
        } else {

            int index = searchForISBN();// ignore for now: as you cant have -1 in an array index, we know if we cant  find the book as the index doesnt change

            if (index == -1) {
                System.out.println("cant find book");
            } else {
                bookList.remove(index);
            }

        }
    }


public static void editBook(){

        if(bookList.isEmpty()){
            System.out.println("Sorry, no books to edit");
        }else{
                          
             int index = searchForISBN();//as you cant have -1 in an array index, we know if we cant  find the book as the index doesnt change
//             for (int i = 0; i < bookList.size(); i++){
//                 if(ISBN.equals(bookList.get(i).getISBN())){
//                     index = i;//setting index to be location of where the book is. IF we find it, we break out of it because we dont need
//                     break;//loop throught the rest of the list if we already found the book we need.             
            
             if (index == -1){
                 System.out.println("sorr couldnt find the ISBN of the book");
             }else{
                 
                 System.out.println("Which bit do you want to edit. Enter a number");
                 System.out.println("1 - ISBN");
                 System.out.println("2 - Author");
                 System.out.println("3 - Release Date");
                 System.out.println("4 - Price");
                 System.out.println("5 - Title");
                 int userChoice = input.nextInt();
                 
                 switch(userChoice){
                     case 1:
                         System.out.println("Please type in an ISBN");
                         String newISBN = input.next();
                         bookList.get(index).setISBN(newISBN);
                         break;
                     case 2:                         
                         System.out.println("Please type in an Author");
                         input.nextLine();//extra to not skip lines
                         String newAuthor = input.nextLine();
                         bookList.get(index).setAuthor(newAuthor);
                         break;
                     case 3:                         
                         System.out.println("Please type in a releaseDate");
                         String newReleaseDate = input.next();
                         bookList.get(index).setReleaseDate(newReleaseDate);
                         break;
                     case 4:                         
                         System.out.println("Please type in a price");
                         double newPrice = input.nextDouble();
                         bookList.get(index).setPrice(newPrice);
                         break;
                     case 5:                         
                         System.out.println("Please type in a title");
                         input.nextLine();//extra to not skip line
                         String newTitle = input.nextLine();
                         bookList.get(index).setTitle(newTitle);
                         break;
             }
                 System.out.println("The book has been changed to " + bookList.get(index).toString());
             }
}
}


    
    public static int searchForISBN(){
         System.out.println("Please enter book ISBN");
        String ISBN = input.next();

        for (int i = 0; i < bookList.size(); i++) {
            if (ISBN.equals(bookList.get(i).getISBN())) {
                return i;//setting return to be i. IF we dont find it, we return -1 instead.
                
            }
             }
        return -1;
}
    
}
