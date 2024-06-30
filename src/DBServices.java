import java.sql.*;
import java.util.Scanner;

public class DBServices {
    public static void addNewBook(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        System.out.println("Enter book author:");
        String author = scanner.nextLine();
        System.out.println("Enter book publisher:");
        String publisher = scanner.nextLine();
        System.out.println("Enter year published:");
        int yearPublished = scanner.nextInt();

        String query = "INSERT INTO books (title, author, publisher, year_published) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, title);
        statement.setString(2, author);
        statement.setString(3, publisher);
        statement.setInt(4, yearPublished);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new book was inserted successfully!");
        }
    }

    public static void updateBookDetails(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book ID to update:");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter new book title:");
        String title = scanner.nextLine();
        System.out.println("Enter new book author:");
        String author = scanner.nextLine();
        System.out.println("Enter new book publisher:");
        String publisher = scanner.nextLine();
        System.out.println("Enter new year published:");
        int yearPublished = scanner.nextInt();

        String query = "UPDATE books SET title = ?, author = ?, publisher = ?, year_published = ? WHERE book_id = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, title);
        statement.setString(2, author);
        statement.setString(3, publisher);
        statement.setInt(4, yearPublished);
        statement.setInt(5, bookId);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Book details updated successfully!");
        }
    }

    public static void deleteBook(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book ID to delete:");
        int bookId = scanner.nextInt();

        String query = "DELETE FROM books WHERE book_id = ?";


        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, bookId);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Book deleted successfully!");
        }
    }

    public static void searchForBook(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book title to search:");
        String title = scanner.nextLine();

        String query = "SELECT * FROM books WHERE title LIKE ?";


        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "%" + title + "%");

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int bookId = resultSet.getInt("book_id");
            String bookTitle = resultSet.getString("title");
            String author = resultSet.getString("author");
            String publisher = resultSet.getString("publisher");
            int yearPublished = resultSet.getInt("year_published");

            System.out.println("Book ID: " + bookId);
            System.out.println("Title: " + bookTitle);
            System.out.println("Author: " + author);
            System.out.println("Publisher: " + publisher);
            System.out.println("Year Published: " + yearPublished);
            System.out.println();
        }
    }

    public static void addNewMember(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter member name:");
        String name = scanner.nextLine();
        System.out.println("Enter member email:");
        String email = scanner.nextLine();
        System.out.println("Enter member phone:");
        String phone = scanner.nextLine();

        String query = "INSERT INTO members (name, email, phone) VALUES (?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, email);
        statement.setString(3, phone);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new member was added successfully!");
        }
    }

    public static void loanBook(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book ID to loan:");
        int bookId = scanner.nextInt();
        System.out.println("Enter member ID to loan the book to:");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter loan date (YYYY-MM-DD):");
        String loanDate = scanner.nextLine();
        System.out.println("Enter due date (YYYY-MM-DD):");
        String dueDate = scanner.nextLine();

        String query = "INSERT INTO loans (book_id, member_id, loan_date, due_date) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, bookId);
        statement.setInt(2, memberId);
        statement.setDate(3, Date.valueOf(loanDate));
        statement.setDate(4, Date.valueOf(dueDate));

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Book loan recorded successfully!");
        }
    }

    public static void returnBook(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Loan ID:");
        int loanId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter return date (YYYY-MM-DD):");
        String returnDateStr = scanner.nextLine();
        Date returnDate = Date.valueOf(returnDateStr);

        String sql = "UPDATE loans SET return_date = ? WHERE loan_id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setDate(1, returnDate);
        statement.setInt(2, loanId);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Loan return was recorded successfully!");
        }
    }
}
