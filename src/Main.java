import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            while (true) {
                Connection connection = DBManager.getConnection("library_db","root","");

                System.out.println("Library Management System:");
                System.out.println("1. Add a New Book");
                System.out.println("2. Update Book Details");
                System.out.println("3. Delete a Book");
                System.out.println("4. Search for a Book");
                System.out.println("5. Add a New Member");
                System.out.println("6. Loan a Book");
                System.out.println("7. Return a Book");
                System.out.println("8. Exit");
                System.out.print("Choose an option: ");

                Scanner scanner = new Scanner(System.in);
                int action = Integer.parseInt(scanner.nextLine());

                switch (action) {
                    case 1 -> DBServices.addNewBook(connection);
                    case 2 -> DBServices.updateBookDetails(connection);
                    case 3 -> DBServices.deleteBook(connection);
                    case 4 -> DBServices.searchForBook(connection);
                    case 5 -> DBServices.addNewMember(connection);
                    case 6 -> DBServices.loanBook(connection);
                    case 7 -> DBServices.returnBook(connection);
                    case 8 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

