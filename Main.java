import java.sql.*;
import java.util.Scanner;

public class Main {

    private static

    Connection c = null;
    private static Statement s = null;
    private static boolean connected = false;


    public static void main(String[] args) {
        c = getConnection();
        Scanner input = new Scanner(System.in);
        displayMenu(1);
        runQuery(input.nextLine());
        closeConnection();
    }

    private static void displayMenu(int page) {
        System.out.println("Command List: ");
        System.out.println("\t connect: Connect to hypercar table");
        System.out.println("\t create table: To create a table");
        System.out.println("\t insert table: To insert to a table");
        System.out.println("\t drop table: To drop a table");
        System.out.println("\t #: Enter number to run a query ONLY 1-20 Permited");
    }


    private static void runQuery(String s) {
        Scanner input = new Scanner(System.in);
        String tableName;
        switch (s) {
            case "connect":
                c = getConnection();
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
                insertToTable(tableName);
                break;
            case "drop table":
                tableName = input.nextLine();
                dropTable(tableName);
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
        System.out.println("Do you wanna run another query: y/n");
        switch (input.nextLine()) {
            case "y":
                displayMenu(1);
                runQuery(input.nextLine());
                break;
            case "n":
                break;

            default:
                break;
        }
    }

    private static void createTable(String tableName) {
        boolean shouldUpdate = false;
        String sql = null;

        switch (tableName) {
            case "engine":
                sql = "create table engine\n" +
                        "(\n" +
                        "  e_model     VARCHAR(10) not null,\n" +
                        "  e_make      VARCHAR(10) not null,\n" +
                        "  e_cylinders DECIMAL(1)  not null,\n" +
                        "  e_hp        DECIMAL(10) not null,\n" +
                        "  e_torque    DECIMAL(10) not null,\n" +
                        "  e_size      DECIMAL(10) not null\n" +
                        ");";
                shouldUpdate = true;
                break;
            case "manufacturer":
                sql = "create table manufacturer\n" +
                        "(\n" +
                        "  m_name   VARCHAR(10)    not null,\n" +
                        "  m_nation VARCHAR(10)    not null,\n" +
                        "  m_sales  DECIMAL(10, 2) not null\n" +
                        ");\n";
                shouldUpdate = true;
                break;
            case "vehicle":
                sql = "create table vehicle\n" +
                        "(\n" +
                        "  v_vin     VARCHAR(40)   not null,\n" +
                        "  v_license VARCHAR(10)   not null,\n" +
                        "  v_year    DECIMAL(3)    not null,\n" +
                        "  v_make    VARCHAR(10)   not null,\n" +
                        "  v_model   VARCHAR(10)   not null,\n" +
                        "  v_color   VARCHAR(10)   not null,\n" +
                        "  v_price   DECIMAL(7, 2) not null\n" +
                        ");";
                shouldUpdate = true;
                break;
            case "wheels":
                sql = "create table wheels\n" +
                        "(\n" +
                        "  w_model       e_hs BOOLEAN not null,\n" +
                        "  e_leather     BOOLEAN      not null,\n" +
                        "  e_turbo       BOOLEAN      not null,\n" +
                        "  e_spoiler     BOOLEAN      not null,\n" +
                        "  e_tint        BOOLEAN      not null,\n" +
                        "  e_convertible BOOLEAN      not null\n" +
                        ");";
                shouldUpdate = true;
                break;
            default:
                System.out.println("Table Schema not in library");
                break;
        }

        if (shouldUpdate) {
            try {
                s.executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println("Failed to Create Table");
                e.printStackTrace();
            }
        }
    }

    private static void dropTable(String tableName) {
        String sql = null;
        boolean run = false;

        switch (tableName) {
            case "engine":
                sql  = "drop table engine";
                run = true;
                break;
            case "manufacturer":
                sql = "drop table manufacturer";
                run = true;
                break;
            case "vehicle":
                sql = "drop table vehicle";
                run = true;
                break;
            case "wheels":
                sql = "drop table wheels";
                run = true;
                break;
            default:
                System.out.println("Table Schema not in library");
                break;
        }

        if (run) {
            try {
                s.executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println("Failed to drop table");
                e.printStackTrace();
            }
        }
    }

    private static void insertToTable(String tableName) {
        String sql = null;
        boolean run = false;

        switch (tableName) {
            case "engine":
                sql  = "insert into engine (e_model, e_make, e_cylinders, e_hp,  e_torque, e_size) value (?,?,?,?,?,?);";
                run = true;
                break;
            case "manufacturer":
                sql = "";
                run = true;
                break;
            case "vehicle":
                sql = "";
                run = true;
                break;
            case "wheels":
                sql = "";
                run = true;
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

    private static void closeConnection() {
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                System.out.println("Failed to Close Connection");
                e.printStackTrace();
            }
        }
        //System.out.println("Closed Connection");
    }
}