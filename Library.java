import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Library {

    private static Library instance;

    public static synchronized Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    private Map<Integer, String> books = new HashMap<>();
    private int bookId = 1;

    public void addBook(String bookName)
    {
        books.put(bookId++, bookName);
    }

    public void removeBook(int bookId)
    {
        books.remove(bookId);
    }

    public void viewBook()
    {
        for (Map.Entry<Integer, String> entry : books.entrySet())
        {
            System.out.println(entry.getKey() + " ----- " + entry.getValue());
        }
    }



    public static void main(String[] args) {



            Scanner input = new Scanner(System.in);
            Library library = Library.getInstance();

            System.out.println("====== Welcome to Library ======");


            System.out.println("1. Add a Book.");
            System.out.println("2. Remove a Book.");
            System.out.println("3. View all books.");
            System.out.println("0. Exit.");


            while (true) {


                System.out.println("Please choose from the options above.");
                int option = input.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Please enter the name of the book you want to add.");
                        input.nextLine();
                        String bookToAdd = input.nextLine();
                        library.addBook(bookToAdd);
                        System.out.println("The book " + bookToAdd + " has been successfully added.");
                        break;
                    case 2:
                        System.out.println("Please enter the book ID number that you want to remove.");
                        int bookToRemove = input.nextInt();
                        library.removeBook(bookToRemove);
                        System.out.println("The book with the ID number " + bookToRemove + " has been successfully removed.");
                        break;
                    case 3:
                        System.out.println("This is the list of books available in this library.");
                        library.viewBook();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Invalid input, Please try again");

                }
            }
        }
}


