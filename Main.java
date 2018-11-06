import java.sql.*;
import java.util.Scanner;

public class Main {

    private static

    Connection c = null;
    private static Statement s = null;
    private static boolean connected = false;
    String url = null;


    public static void main(String[] args) {
        c = getConnection();

        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void runQuery(String s) throws SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        String tableName;
        switch (s) {
            case "connect":
                0
                break;
            case "create table":
                // Create TABLE
                System.out.print("Enter table Name: ");
                tableName = input.nextLine();
                createTable(tableName);
                break;
            case "insert table":
                // Insert to TABLE
                tableName = input.nextLine();
                insertTable(tableName);
                break;
            case "1":

                break;
            case "2":

                break;
            case "3":

                break;
            case "4":

                break;
            case "5":

                break;
            case "6":

                break;
            default:
                System.out.println("Wrong Query Switch");
                break;
        }
    }

    private static void createTable(String tableName) {
        switch (tableName) {
            case "engine":
                createEngineTable;
                break;
            case "manufacturer":
                createManufacturerTable();
                break;
            case "vehicle":
                createVehicleTable();
                break;
            case "wheels":
                createWheelsTable();
                break;
            default:
                System.out.println("Table Schema not in library");
                break;

        }
    }

    private static Connection getConnection() {
        String url = "jdbc:sqlite:/Users/marioortega/CS/sqlite3/CSE111/DatabaseServer/project/hyperWhips.db";

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to find Driver");
            e.printStackTrace();
        }

        try {
            System.out.println("Establishing Connection");
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Failed to get Connection");
            e.printStackTrace();
            return null;
        }
    }

    private static void closeConnection() throws SQLException {
        if (c != null) c.close();
        //System.out.println("Closed Connection");
    }
}
