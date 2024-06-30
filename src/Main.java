import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            while (true){
                System.out.println("Add a new book -> A");
                System.out.println("Update Book Details -> B");
                System.out.println("Delete a Book -> C");
                System.out.println("Search for a Book -> D");
                System.out.println("Add a New Member -> E");
                System.out.println("Loan a Book -> F");
                System.out.println("End -> G");
                System.out.println("\nEnter your action:");

                Scanner myObj = new Scanner(System.in);
                String action = myObj.nextLine();

                if (action.equals("G")){
                    break;
                }

                switch ("action") {
                    case "A" -> {

                    }
                    case "B" -> {

                    }
                    case "C" -> {

                    }
                    case "D" -> {

                    }
                    case "E" -> {

                    }
                    case "F" -> {

                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

