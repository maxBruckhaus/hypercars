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
    }

    private static void createTable(String tableName) {

        String sql;
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
                break;
            case "manufacturer":
                sql = "create table manufacturer\n" +
                        "(\n" +
                        "  m_name   VARCHAR(10)    not null,\n" +
                        "  m_nation VARCHAR(10)    not null,\n" +
                        "  m_sales  DECIMAL(10, 2) not null\n" +
                        ");\n";
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
                break;
            default:
                System.out.println("Table Schema not in library");
                break;
        }
        s.executeUpdate(sql);
    }

    private static void insertToTable(String tableName) {
        String sql;
        switch (tableName) {
            case "engine":
                sql = "drop table engine";
                break;
            case "manufacturer":
                sql = "drop table manufacturer";
                break;
            case "vehicle":
                sql = "drop table vehicle";
                break;
            case "wheels":
                sql = "drop table wheels";
                break;
            default:
                System.out.println("Table Schema not in library");
                break;
        }
        s.executeUpdate(sql);
    }
    private static void dropTable(String tableName) {
        switch (tableName) {
            case "engine":
                insertEngineTable();
                break;
            case "manufacturer":
                insertManufacturerTable();
                break;
            case "vehicle":
                insertVehicleTable();
                break;
            case "wheels":
                insertWheelsTable();
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
