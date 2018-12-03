import java.sql.*;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {

    private static

    Connection c = null;
    private static Statement s = null;
    private static boolean connected = false;
    private static boolean closing = false;


    public static void main(String[] args) {
        c = getConnection();
        Scanner input = new Scanner(System.in);
        displayMenu(1);
        runQuery(input.nextLine());
        closeConnection();
    }

    private static void displayMenu(int page) {
        System.out.println("Command List: ");
        if (!connected)
            System.out.println("\t connect: Connect to hypercar table");
        System.out.println("\t createAll: To create all tables");
        System.out.println("\t create table: To create a table");
        System.out.println("\t loadAll: To initialize all tables");
        System.out.println("\t insert table: To insert to a table");
        System.out.println("\t drop table: To drop a table");
        System.out.println("\t dropAll: To drop a table");
        System.out.println("\t #: Enter number to run a query ONLY 1-20 Permited");
        System.out.print("$ ");
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
                System.out.println("engine, manufacturer, transmission, vehicle");
                System.out.print("Enter table Name: ");
                tableName = input.nextLine();
                createTable(tableName);
                break;
            case "insert table":
                // Insert to TABLE
                System.out.print("Table Name: ");
                tableName = input.nextLine();
                insertToTable(tableName);
                break;
            case "drop table":
                tableName = input.nextLine();
                dropTable(tableName);
                break;
            case "createAll":
                c = getConnection();
                initializeTables();
            case "1":
                c = getConnection();

                break;
            case "2":

                break;
            case "find":
                searchCar();
                break;
            case "4":

                break;
            case "5":

                break;
            case "6":

                break;
            case "d":
                c = getConnection();
                //insertToTable("vehicle");
                searchCar();
                break;
            case "loadAll":
                c =getConnection();
                loadData();
                break;
            case "dropAll":
                c =getConnection();
                dropALLTables();
                break;
            default:
                System.out.println("Wrong Query Switch");
                break;
        }
        System.out.println("Do you wanna run another query: y/n");
        System.out.print("$ ");
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
    private static void initializeTables() {
        System.out.print("Successfully created tables: ");
        createTable("vehicle");
        createTable("hypercars");
        createTable("engine");
        createTable("transmission");
        createTable("wheels");
        createTable("manufacturer");
        createTable("extras");
        createTable("people");
        createTable("bids");
        System.out.println(" ");
    }

    private static void loadData() {
        s = getStatement();
        String sql = null;
        sql = "INSERT INTO vehicle\n" +
                "        (v_vin, v_license, v_year, v_make, v_model, v_color, v_price) VALUES\n" +
                "\t(\"JH4KA2650HC000268\", \"123ABC0\", 1987, \"Acura\", \"Legend\", \"BLACK\", 4265),\n" +
                "\t(\"4JGBB86E27A199749\", \"123ABC1\", 2007, \"Mercedes Benz\", \"M Class\", \"BLACK\", 20265),\n" +
                "\t(\"3B7HF13Y81G193584\", \"123ABC2\", 2001, \"Dodge\", \"Ram Pickup 1500\", \"BLUE\", 30125),\n" +
                "\t(\"1HGCT2B88DA000025\", \"123ABC3\", 2013, \"Honda\", \"Accord\", \"WHITE\", 15843),\n" +
                "\t(\"JH4DB8580RS000024\", \"123ABC4\", 1994, \"Acura\", \"Integra\", \"BLUE\", 3953),\n" +
                "\t(\"4S3BK6354S6355265\", \"123ABC5\", 1995, \"Subaru\", \"Legacy\", \"GRAY\", 6632),\n" +
                "\t(\"5NPEB4AC1DH576656\", \"123ABC6\", 2013, \"Hyundai\", \"Sonata\", \"PINK\", 29473),\n" +
                "\t(\"JH4KA4576KC031014\", \"123ABC7\", 1989, \"Acura\", \"Legend\", \"WHITE\", 3046),\n" +
                "\t(\"JH4NA1260MT001906\", \"123ABC8\", 1991, \"Acura\", \"NSX\", \"RED\", 3046),\n" +
                "\t(\"1FAFP55U91A180689\", \"123ABC9\", 2001, \"Ford\", \"Taurus\", \"BLACK\", 3953),\n" +
                "\t(\"SCA1S684X4UX07444\", \"123ABD0\", 2004, \"Rolls Royce\", \"Phantom\", \"BLACK\", 200367),\n" +
                "\t(\"3VWRA69M74M033915\", \"123ABD1\", 2004, \"Volkswagen\", \"Jetta\", \"BLUE\", 3953),\n" +
                "\t(\"1GNEK13T7YJ204464\", \"123ABD2\", 2000, \"Chevrolet\", \"Tahoe\", \"WHITE\", 9263),\n" +
                "\t(\"2C3CCAET4CH256062\", \"123ABD3\", 2012, \"Chrysler\", \"300C\", \"PINK\", 3953),\n" +
                "\t(\"ZFFXS41A7X0114158\", \"123ABD4\", 1999, \"Ferrari\", \"F355\", \"RED\", 3874905),\n" +
                "\t(\"ZFFEZ58E170153605\", \"123ABD5\", 2012, \"Ferrari\", \"F430 Coupe\", \"YELLOW\", 494734),\n" +
                "\t(\"ZFFEW58A660144998\", \"123ABD6\", 2006, \"Ferrari\", \"F430\", \"BLUE\", 35232),\n" +
                "\t(\"ZFFWL44A330131232\", \"123ABD7\", 2003, \"Ferrari\", \"456M\", \"WHITE\", 558376),\n" +
                "\t(\"ZFFWP50A0V0106629\", \"123ABD8\", 1997, \"Ferrari\", \"456\", \"RED\", 29457),\n" +
                "\t(\"ZFFEW58L170151456\", \"123ABD9\", 2007, \"Ferrari\", \"F430 Coupe\", \"PINK\", 35232),\n" +
                "\t(\"ZFFAB54A080014783\", \"123ABE0\", 2008, \"Ferrari\", \"612\", \"BLUE\", 35232),\n" +
                "\t(\"SCBCR63WS5C024793\", \"123ABE1\", 2005, \"Bentley\", \"Continental GT\", \"RED\", 39584),\n" +
                "\t(\"SCBFT7ZA3FC041545\", \"123ABE2\", 2015, \"Bentley\", \"Continental GT V8\", \"PINK\", 25344),\n" +
                "\t(\"SCBZS42A5CCX05753\", \"123ABE3\", 1982, \"Bentley\", \"Mulsanne\", \"BLUE\", 83945),\n" +
                "\t(\"SCBLC37F04CX09874\", \"123ABE4\", 2004, \"Bentley\", \"Arnage\", \"RED\", 93405),\n" +
                "\t(\"SCBBP9ZA0AC062683\", \"123ABE5\", 2010, \"Bentley\", \"Continental Flying Spur Speed\", \"WHITE\", 20492),\n" +
                "\t(\"SCBBB7ZH1EC118746\", \"123ABE6\", 2014, \"Bentley\", \"Mulsanne\", \"PINK\", 83945),\n" +
                "\t(\"SCBCR63W55C024793\", \"123ABE7\", 2005, \"Bentley\", \"Continental GT\", \"RED\", 83945),\n" +
                "\n" +
                "\t(\"WVFWPKR4D5KRM1RBL\", \"V7WPW0G\", 2007, \"Mercedes Benz\", \"M Class\", \"BLACK\", 20265),\n" +
                "\t(\"PWZIGRBDT7UDPE5JA\", \"T52PU5Q\", 2001, \"Dodge\", \"Ram Pickup 1500\", \"BLUE\", 30125),\n" +
                "\t(\"RKNXEKKC2USFZ96T0\", \"8F5FK2Q\", 2013, \"Honda\", \"Accord\", \"WHITE\", 15843),\n" +
                "\t(\"HBHTCU3ULYPSUDI80\", \"JUMECQC\", 1994, \"Acura\", \"Integra\", \"BLUE\", 3953),\n" +
                "\t(\"XIYSIC2K3FS6JIY03\", \"05UN4IK\", 1995, \"Subaru\", \"Legacy\", \"GRAY\", 6632),\n" +
                "\t(\"RGBXCA94EMG4DGZXU\", \"2ZZRVKR\", 2013, \"Hyundai\", \"Sonata\", \"PINK\", 29473),\n" +
                "\t(\"ZYRRUXQZL0QY6PF5M\", \"NV7PD25\", 1989, \"Acura\", \"Legend\", \"WHITE\", 3046),\n" +
                "\t(\"YNOPGKKBOQKM5NOR5\", \"Q1Y1BTF\", 1991, \"Acura\", \"NSX\", \"RED\", 3046),\n" +
                "\t(\"USSWPZ76DAKC3PCOF\", \"R0WXNAA\", 2001, \"Ford\", \"Taurus\", \"BLACK\", 3953),\n" +
                "\t(\"EFSJTA1FQSS3HGWHX\", \"CWOH0VZ\", 2004, \"Rolls Royce\", \"Phantom\", \"BLACK\", 200367),\n" +
                "\t(\"HCJKJHKY7022ZR3NQ\", \"ODCDADC\", 2004, \"Volkswagen\", \"Jetta\", \"BLUE\", 3953),\n" +
                "\t(\"CNBVPGH6Q84ONUJ5I\", \"RQYZZTA\", 2000, \"Chevrolet\", \"Tahoe\", \"WHITE\", 9263),\n" +
                "\t(\"WTFWASRUU6ZLTRNBU\", \"0XIPO8U\", 2012, \"Chrysler\", \"300C\", \"PINK\", 3953),\n" +
                "\t(\"YXIXTM1WV4RJO1DZ8\", \"WL6INN8\", 1999, \"Ferrari\", \"F355\", \"RED\", 3874905),\n" +
                "\t(\"VSJJWWQ5YOLE4CJ4D\", \"Z7B33AF\", 2012, \"Ferrari\", \"F430 Coupe\", \"YELLOW\", 494734),\n" +
                "\t(\"ESEERJN2D4XI6VVXI\", \"DSSGR9L\", 2006, \"Ferrari\", \"F430\", \"BLUE\", 35232),\n" +
                "\t(\"XNXWFNQX0K3RPKM4J\", \"INTD9XZ\", 2003, \"Ferrari\", \"456M\", \"WHITE\", 558376),\n" +
                "\t(\"NLVEXWWE8HSBM3MZH\", \"IOI4IDI\", 1997, \"Ferrari\", \"456\", \"RED\", 29457),\n" +
                "\t(\"CEZXQBFOUGOOU03IP\", \"7Z3PA8S\", 2007, \"Ferrari\", \"F430 Coupe\", \"PINK\", 35232),\n" +
                "\t(\"NXVLGAR0NBUHF04NU\", \"V6E44QN\", 2008, \"Ferrari\", \"612\", \"BLUE\", 35232),\n" +
                "\t(\"OYHJIR7XS7MLTKX1T\", \"26OR95W\", 2005, \"Bentley\", \"Continental GT\", \"RED\", 39584),\n" +
                "\t(\"PVUSHAR7HLXDN3G5S\", \"MGRD7XX\", 2015, \"Bentley\", \"Continental GT V8\", \"PINK\", 25344),\n" +
                "\t(\"RJUDLUTU8GD8GL7Y7\", \"G37TWY4\", 1982, \"Bentley\", \"Mulsanne\", \"BLUE\", 83945),\n" +
                "\t(\"GZABPO5XTB32KVZA3\", \"JKXI17S\", 2004, \"Bentley\", \"Arnage\", \"RED\", 93405),\n" +
                "\t(\"UOQIFOEYRX7COMKEA\", \"PZ6BYMG\", 2010, \"Bentley\", \"Continental Flying Spur Speed\", \"WHITE\", 20492),\n" +
                "\t(\"VDRABF8GY8SZXQHQJ\", \"0GFHBGB\", 2014, \"Bentley\", \"Mulsanne\", \"PINK\", 83945),\n" +
                "\t(\"SCBCR63W55C624793\", \"G37THY4\", 2005, \"Bentley\", \"Continental GT\", \"RED\", 83945);";
        try {
            s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Loaded into vehicle");

        sql = "INSERT INTO hypercars\n" +
                "        (h_vin, h_engine, h_topSpeed, h_trans, h_weight, h_wheel) VALUES\n" +
                "\t(\"JH4KA2650HC000268\", \"NVPVK6NE\", 136, \"BKRKZ\", 1993, \"V6UKMC\"),\n" +
                "\t(\"4JGBB86E27A199749\", \"QU875TE8\", 201, \"RY85H\", 2489, \"3T4774\"),\n" +
                "\t(\"3B7HF13Y81G193584\", \"R6NAYRET\", 216, \"9562C\", 2075, \"ARBYW5\"),\n" +
                "\t(\"1HGCT2B88DA000025\", \"F9V5B0H4\", 156, \"XZMOH\", 2639, \"F1ZY06\"),\n" +
                "\t(\"JH4DB8580RS000024\", \"F5UD9B4L\", 272, \"MO7OL\", 1829, \"962V3D\"),\n" +
                "\t(\"4S3BK6354S6355265\", \"3ESQ1YMY\", 296, \"DFWY5\", 1821, \"6CSNS3\"),\n" +
                "\t(\"5NPEB4AC1DH576656\", \"U5LSNFMZ\", 207, \"XE8YG\", 1929, \"FLSGEK\"),\n" +
                "\t(\"JH4KA4576KC031014\", \"XF8OIUQ2\", 103, \"A259G\", 1695, \"7Q7NH2\"),\n" +
                "\t(\"JH4NA1260MT001906\", \"08A7XDMB\", 107, \"94CMC\", 1682, \"6E8TX7\"),\n" +
                "\t(\"1FAFP55U91A180689\", \"4G2FK0EI\", 197, \"J3WO8\", 2772, \"86NNTT\"),\n" +
                "\t(\"SCA1S684X4UX07444\", \"U71AZ4GB\", 194, \"ARFAI\", 2725, \"1E7P81\"),\n" +
                "\t(\"3VWRA69M74M033915\", \"7U6F42X5\", 138, \"CTRHW\", 1600, \"1TD6GP\"),\n" +
                "\t(\"1GNEK13T7YJ204464\", \"NKVDM332\", 262, \"ZZMB0\", 2570, \"XD62CM\"),\n" +
                "\t(\"2C3CCAET4CH256062\", \"4S11N0XC\", 168, \"76H1W\", 2288, \"5EJXV8\"),\n" +
                "\t(\"ZFFXS41A7X0114158\", \"O62PTZ1N\", 263, \"5VDJB\", 2152, \"VFMDJS\"),\n" +
                "\t(\"ZFFEZ58E170153605\", \"QPBS0F1M\", 187, \"LVMS0\", 1798, \"C8BR7A\"),\n" +
                "\t(\"ZFFEW58A660144998\", \"Y3GP756Y\", 200, \"T786J\", 2299, \"SS3CVF\"),\n" +
                "\t(\"ZFFWL44A330131232\", \"GH01ME9J\", 257, \"SP0PJ\", 2224, \"T4PD0N\"),\n" +
                "\t(\"ZFFWP50A0V0106629\", \"KVQW1Z3K\", 253, \"659TT\", 2402, \"JKQBAH\"),\n" +
                "\t(\"ZFFEW58L170151456\", \"39L2Y02Z\", 179, \"54MXT\", 1801, \"G1YM7N\"),\n" +
                "\t(\"ZFFAB54A080014783\", \"DK4MQEZM\", 180, \"OB9UN\", 1976, \"TTCEK7\"),\n" +
                "\t(\"SCBCR63WS5C024793\", \"PU69GAWZ\", 132, \"2W0WV\", 1821, \"SFJJ7H\"),\n" +
                "\t(\"SCBFT7ZA3FC041545\", \"QAXYHVY6\", 157, \"58QOP\", 2662, \"RFIT0O\"),\n" +
                "\t(\"SCBZS42A5CCX05753\", \"A4BHKQL5\", 183, \"JEL1R\", 1508, \"JZR2WL\"),\n" +
                "\t(\"SCBLC37F04CX09874\", \"QXEZJCHG\", 173, \"80R8D\", 1782, \"D8HE5U\"),\n" +
                "\t(\"SCBBP9ZA0AC062683\", \"SXTCKS3V\", 122, \"GN4WS\", 1574, \"R1VLJW\"),\n" +
                "\t(\"SCBBB7ZH1EC118746\", \"LL7D6884\", 147, \"XW9HN\", 2027, \"1L6IGJ\"),\n" +
                "\t(\"SCBCR63W55C024793\", \"2WGW2ZJH\", 158, \"AADF5\", 1741, \"KGER55\"),\n" +
                "\n" +
                "\t(\"WVFWPKR4D5KRM1RBL\", \"3QPQJZ0Y\", 201, \"77WBQ\", 2489, \"YUUNGM\"),\n" +
                "\t(\"PWZIGRBDT7UDPE5JA\", \"62929049\", 216, \"6YU9F\", 2075, \"HRO7DE\"),\n" +
                "\t(\"RKNXEKKC2USFZ96T0\", \"M5QG2U36\", 156, \"7GQWY\", 2639, \"2Z2KK9\"),\n" +
                "\t(\"HBHTCU3ULYPSUDI80\", \"BY9ZYD39\", 272, \"Q76RI\", 1829, \"J9LK5J\"),\n" +
                "\t(\"XIYSIC2K3FS6JIY03\", \"A792XL4U\", 296, \"D947F\", 1821, \"SHT14P\"),\n" +
                "\t(\"RGBXCA94EMG4DGZXU\", \"RV8FFF84\", 207, \"1N6O7\", 1929, \"MU0DFA\"),\n" +
                "\t(\"ZYRRUXQZL0QY6PF5M\", \"43VXLXBX\", 103, \"BHQDJ\", 1695, \"47O37N\"),\n" +
                "\t(\"YNOPGKKBOQKM5NOR5\", \"PKNSJ8XD\", 107, \"5NBMM\", 1682, \"E56G4Y\"),\n" +
                "\t(\"USSWPZ76DAKC3PCOF\", \"8N4CJI5D\", 197, \"XHCIQ\", 2772, \"P2O7TY\"),\n" +
                "\t(\"EFSJTA1FQSS3HGWHX\", \"S3OIZRNM\", 194, \"LK8LA\", 2725, \"WEC4YI\"),\n" +
                "\t(\"HCJKJHKY7022ZR3NQ\", \"13ZNAW9C\", 138, \"2CKE8\", 1600, \"3RN8P9\"),\n" +
                "\t(\"CNBVPGH6Q84ONUJ5I\", \"QKPJ0FO6\", 262, \"F3NWW\", 2570, \"6BLPPT\"),\n" +
                "\t(\"WTFWASRUU6ZLTRNBU\", \"CZ9KD78V\", 168, \"VMRV9\", 2288, \"JO8AT9\"),\n" +
                "\t(\"YXIXTM1WV4RJO1DZ8\", \"M3XLTDDU\", 263, \"H0SO9\", 2152, \"U2WK8E\"),\n" +
                "\t(\"VSJJWWQ5YOLE4CJ4D\", \"PJ1368SN\", 187, \"BO3T4\", 1798, \"KUUFZE\"),\n" +
                "\t(\"ESEERJN2D4XI6VVXI\", \"LAORLHDZ\", 200, \"OK6J0\", 2299, \"BP9QOH\"),\n" +
                "\t(\"XNXWFNQX0K3RPKM4J\", \"XCZH0Y7G\", 257, \"CNG4N\", 2224, \"6JK4M6\"),\n" +
                "\t(\"NLVEXWWE8HSBM3MZH\", \"RQ5DNS3L\", 253, \"N6A9F\", 2402, \"NQWPT5\"),\n" +
                "\t(\"CEZXQBFOUGOOU03IP\", \"7HADKLMF\", 179, \"4HGTN\", 1801, \"IMRV97\"),\n" +
                "\t(\"NXVLGAR0NBUHF04NU\", \"5LC5S6GT\", 180, \"2YN4F\", 1976, \"51M9N3\"),\n" +
                "\t(\"OYHJIR7XS7MLTKX1T\", \"THHXUFVE\", 132, \"19P36\", 1821, \"QJQ3W5\"),\n" +
                "\t(\"PVUSHAR7HLXDN3G5S\", \"35KOTF8G\", 157, \"O1IED\", 2662, \"LXYLFJ\"),\n" +
                "\t(\"RJUDLUTU8GD8GL7Y7\", \"3MDC7L1L\", 183, \"3Z8KX\", 1508, \"KMMASZ\"),\n" +
                "\t(\"GZABPO5XTB32KVZA3\", \"E2PA2NEB\", 173, \"1N48C\", 1782, \"T9PODS\"),\n" +
                "\t(\"UOQIFOEYRX7COMKEA\", \"LKHSI4OE\", 122, \"BOWED\", 1574, \"J2WVUJ\"),\n" +
                "\t(\"VDRABF8GY8SZXQHQJ\", \"OWL1LY3J\", 147, \"I3FT0\", 2027, \"4RR7LF\"),\n" +
                "\t(\"SCBCR63W55C624793\", \"PJSI48SN\", 158, \"38TAW\", 1741, \"4HLNQ2\");";
        try {
            s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Loaded into hypercars");
        sql = "INSERT INTO engine\n" +
                "        (e_model, e_make, e_cylinders, e_hp, e_torque, e_size) VALUES\n" +
                "\t(\"NVPVK6NE\", \"Acura\", 6, 496, 602, 2.8),\n" +
                "\t(\"QU875TE8\", \"Mercedes Benz\", 6, 438, 532, 7.9),\n" +
                "\t(\"R6NAYRET\", \"Dodge\", 8, 510, 764, 1.6),\n" +
                "\t(\"F9V5B0H4\", \"Honda\", 4, 372, 709, 7.0),\n" +
                "\t(\"F5UD9B4L\", \"Acura\", 4, 440, 774, 5.5),\n" +
                "\t(\"3ESQ1YMY\", \"Subaru\", 6, 351, 764, 6.7),\n" +
                "\t(\"U5LSNFMZ\", \"Hyundai\", 6, 497, 626, 3.1),\n" +
                "\t(\"XF8OIUQ2\", \"Acura\", 6, 477, 676, 5.2),\n" +
                "\t(\"08A7XDMB\", \"Acura\", 6, 540, 588, 1.6),\n" +
                "\t(\"4G2FK0EI\", \"Ford\", 6, 429, 671, 2.9),\n" +
                "\t(\"U71AZ4GB\", \"Rolls Royce\", 12, 594, 606, 5.7),\n" +
                "\t(\"7U6F42X5\", \"Volkswagen\", 6, 448, 677, 2.3),\n" +
                "\t(\"NKVDM332\", \"Chevrolet\", 6, 365, 630, 2.5),\n" +
                "\t(\"4S11N0XC\", \"Chrysler\", 6, 521, 689, 3.6),\n" +
                "\t(\"O62PTZ1N\", \"Ferrari\", 12, 428, 675, 4.2),\n" +
                "\t(\"QPBS0F1M\", \"Ferrari\", 12, 394, 691, 3.9),\n" +
                "\t(\"Y3GP756Y\", \"Ferrari\", 12, 414, 771, 2.9),\n" +
                "\t(\"GH01ME9J\", \"Ferrari\", 12, 584, 577, 4.9),\n" +
                "\t(\"KVQW1Z3K\", \"Ferrari\", 12, 587, 739, 3.5),\n" +
                "\t(\"39L2Y02Z\", \"Ferrari\", 12, 514, 627, 2.6),\n" +
                "\t(\"DK4MQEZM\", \"Ferrari\", 12, 555, 567, 4.1),\n" +
                "\t(\"PU69GAWZ\", \"Bentley\", 12, 367, 626, 1.2),\n" +
                "\t(\"QAXYHVY6\", \"Bentley\", 12, 378, 608, 4.1),\n" +
                "\t(\"A4BHKQL5\", \"Bentley\", 12, 485, 581, 4.7),\n" +
                "\t(\"QXEZJCHG\", \"Bentley\", 12, 500, 807, 5.6),\n" +
                "\t(\"SXTCKS3V\", \"Bentley\", 12, 398, 781, 5.3),\n" +
                "\t(\"LL7D6884\", \"Bentley\", 12, 579, 568, 3.6),\n" +
                "\t(\"2WGW2ZJH\", \"Bentley\", 12, 311, 545, 2.7),\n" +
                "\n" +
                "\t(\"3QPQJZ0Y\", \"Mercedes Benz\", 6, 438, 532, 7.9),\n" +
                "\t(\"62929049\", \"Dodge\", 8, 510, 764, 1.6),\n" +
                "\t(\"M5QG2U36\", \"Honda\", 4, 372, 709, 7.0),\n" +
                "\t(\"BY9ZYD39\", \"Acura\", 4, 440, 774, 5.5),\n" +
                "\t(\"A792XL4U\", \"Subaru\", 6, 351, 764, 6.7),\n" +
                "\t(\"RV8FFF84\", \"Hyundai\", 6, 497, 626, 3.1),\n" +
                "\t(\"43VXLXBX\", \"Acura\", 6, 477, 676, 5.2),\n" +
                "\t(\"PKNSJ8XD\", \"Acura\", 6, 540, 588, 1.6),\n" +
                "\t(\"8N4CJI5D\", \"Ford\", 6, 429, 671, 2.9),\n" +
                "\t(\"S3OIZRNM\", \"Rolls Royce\", 12, 594, 606, 5.7),\n" +
                "\t(\"13ZNAW9C\", \"Volkswagen\", 6, 448, 677, 2.3),\n" +
                "\t(\"QKPJ0FO6\", \"Chevrolet\", 6, 365, 630, 2.5),\n" +
                "\t(\"CZ9KD78V\", \"Chrysler\", 6, 521, 689, 3.6),\n" +
                "\t(\"M3XLTDDU\", \"Ferrari\", 12, 428, 675, 4.2),\n" +
                "\t(\"PJ1368SN\", \"Ferrari\", 12, 394, 691, 3.9),\n" +
                "\t(\"LAORLHDZ\", \"Ferrari\", 12, 414, 771, 2.9),\n" +
                "\t(\"XCZH0Y7G\", \"Ferrari\", 12, 584, 577, 4.9),\n" +
                "\t(\"RQ5DNS3L\", \"Ferrari\", 12, 587, 739, 3.5),\n" +
                "\t(\"7HADKLMF\", \"Ferrari\", 12, 514, 627, 2.6),\n" +
                "\t(\"5LC5S6GT\", \"Ferrari\", 12, 555, 567, 4.1),\n" +
                "\t(\"THHXUFVE\", \"Bentley\", 12, 367, 626, 1.2),\n" +
                "\t(\"35KOTF8G\", \"Bentley\", 12, 378, 608, 4.1),\n" +
                "\t(\"3MDC7L1L\", \"Bentley\", 12, 485, 581, 4.7),\n" +
                "\t(\"E2PA2NEB\", \"Bentley\", 12, 500, 807, 5.6),\n" +
                "\t(\"LKHSI4OE\", \"Bentley\", 12, 398, 781, 5.3),\n" +
                "\t(\"OWL1LY3J\", \"Bentley\", 12, 579, 568, 3.6),\n" +
                "\t(\"PJSI48SN\", \"Bentley\", 12, 311, 545, 2.7);";
        try {
            s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Loaded into engine");
        sql = "INSERT INTO transmission\n" +
                "        (t_model, t_gears, t_type) VALUES\n" +
                "\t(\"BKRKZ\", 5, 1),\n" +
                "\t(\"RY85H\", 5, 1),\n" +
                "\t(\"9562C\", 6, 0),\n" +
                "\t(\"XZMOH\", 5, 0),\n" +
                "\t(\"MO7OL\", 5, 1),\n" +
                "\t(\"DFWY5\", 5, 1),\n" +
                "\t(\"XE8YG\", 6, 1),\n" +
                "\t(\"A259G\", 5, 1),\n" +
                "\t(\"94CMC\", 6, 0),\n" +
                "\t(\"J3WO8\", 5, 1),\n" +
                "\t(\"ARFAI\", 6, 1),\n" +
                "\t(\"CTRHW\", 5, 1),\n" +
                "\t(\"ZZMB0\", 6, 0),\n" +
                "\t(\"76H1W\", 6, 1),\n" +
                "\t(\"5VDJB\", 5, 0),\n" +
                "\t(\"LVMS0\", 5, 1),\n" +
                "\t(\"T786J\", 5, 1),\n" +
                "\t(\"SP0PJ\", 6, 0),\n" +
                "\t(\"659TT\", 5, 0),\n" +
                "\t(\"54MXT\", 5, 0),\n" +
                "\t(\"OB9UN\", 6, 0),\n" +
                "\t(\"2W0WV\", 6, 1),\n" +
                "\t(\"58QOP\", 6, 0),\n" +
                "\t(\"JEL1R\", 5, 0),\n" +
                "\t(\"80R8D\", 6, 0),\n" +
                "\t(\"GN4WS\", 6, 1),\n" +
                "\t(\"XW9HN\", 5, 1),\n" +
                "\t(\"AADF5\", 5, 1),\n" +
                "\n" +
                "\t(\"77WBQ\", 5, 1),\n" +
                "\t(\"6YU9F\", 6, 0),\n" +
                "\t(\"7GQWY\", 5, 0),\n" +
                "\t(\"Q76RI\", 5, 1),\n" +
                "\t(\"D947F\", 5, 1),\n" +
                "\t(\"1N6O7\", 6, 1),\n" +
                "\t(\"BHQDJ\", 5, 1),\n" +
                "\t(\"5NBMM\", 6, 0),\n" +
                "\t(\"XHCIQ\", 5, 1),\n" +
                "\t(\"LK8LA\", 6, 1),\n" +
                "\t(\"2CKE8\", 5, 1),\n" +
                "\t(\"F3NWW\", 6, 0),\n" +
                "\t(\"VMRV9\", 6, 1),\n" +
                "\t(\"H0SO9\", 5, 0),\n" +
                "\t(\"BO3T4\", 5, 1),\n" +
                "\t(\"OK6J0\", 5, 1),\n" +
                "\t(\"CNG4N\", 6, 0),\n" +
                "\t(\"N6A9F\", 5, 0),\n" +
                "\t(\"4HGTN\", 5, 0),\n" +
                "\t(\"2YN4F\", 6, 0),\n" +
                "\t(\"19P36\", 6, 1),\n" +
                "\t(\"O1IED\", 6, 0),\n" +
                "\t(\"3Z8KX\", 5, 0),\n" +
                "\t(\"1N48C\", 6, 0),\n" +
                "\t(\"BOWED\", 6, 1),\n" +
                "\t(\"I3FT0\", 5, 1),\n" +
                "\t(\"38TAW\", 5, 1);";
        try {
            s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Loaded into transmission");
        sql = "INSERT INTO wheels\n" +
                "        (w_model, w_make, w_height, w_width, w_rim, w_diameter) VALUES\n" +
                "        (\"V6UKMC\", \"CIARW\", 24, 13.64, 8.06, 29.71),\n" +
                "        (\"3T4774\", \"JYFZP\", 20, 12.30, 8.23, 22.25),\n" +
                "        (\"ARBYW5\", \"QQXKH\", 24, 14.29, 8.59, 26.41),\n" +
                "        (\"F1ZY06\", \"TWZNB\", 24, 13.76, 8.35, 18.27),\n" +
                "        (\"962V3D\", \"OAZAX\", 22, 16.85, 8.29, 27.85),\n" +
                "        (\"6CSNS3\", \"HNVQZ\", 25, 12.09, 8.89, 21.24),\n" +
                "        (\"FLSGEK\", \"CIARW\", 24, 16.96, 7.99, 27.00),\n" +
                "        (\"7Q7NH2\", \"JYFZP\", 24, 14.18, 8.20, 26.04),\n" +
                "        (\"6E8TX7\", \"QQXKH\", 21, 15.21, 7.58, 24.93),\n" +
                "        (\"86NNTT\", \"TWZNB\", 20, 17.40, 7.91, 26.06),\n" +
                "        (\"1E7P81\", \"OAZAX\", 24, 17.99, 8.49, 26.05),\n" +
                "        (\"1TD6GP\", \"HNVQZ\", 20, 12.39, 7.32, 20.38),\n" +
                "        (\"XD62CM\", \"CIARW\", 24, 16.62, 7.84, 21.62),\n" +
                "        (\"5EJXV8\", \"JYFZP\", 23, 16.53, 7.03, 23.41),\n" +
                "        (\"VFMDJS\", \"QQXKH\", 25, 13.78, 8.88, 19.35),\n" +
                "        (\"C8BR7A\", \"TWZNB\", 20, 17.35, 7.26, 25.40),\n" +
                "        (\"SS3CVF\", \"OAZAX\", 20, 14.41, 7.24, 23.56),\n" +
                "        (\"T4PD0N\", \"HNVQZ\", 25, 14.46, 7.18, 25.36),\n" +
                "        (\"JKQBAH\", \"CIARW\", 24, 12.91, 7.97, 18.15),\n" +
                "        (\"G1YM7N\", \"JYFZP\", 22, 14.95, 7.21, 19.32),\n" +
                "        (\"TTCEK7\", \"QQXKH\", 21, 16.39, 7.46, 26.33),\n" +
                "        (\"SFJJ7H\", \"TWZNB\", 22, 16.66, 7.01, 24.58),\n" +
                "        (\"RFIT0O\", \"OAZAX\", 25, 13.35, 7.14, 21.17),\n" +
                "        (\"JZR2WL\", \"HNVQZ\", 21, 13.27, 8.40, 18.64),\n" +
                "        (\"D8HE5U\", \"CIARW\", 21, 12.66, 8.55, 20.00),\n" +
                "        (\"R1VLJW\", \"JYFZP\", 24, 17.15, 7.60, 29.35),\n" +
                "        (\"1L6IGJ\", \"QQXKH\", 22, 14.15, 7.15, 26.40),\n" +
                "        (\"KGER55\", \"TWZNB\", 20, 17.38, 8.67, 22.75),\n" +
                "\n" +
                "\t(\"YUUNGM\", \"JYFZP\", 20, 12.30, 8.23, 22.25),\n" +
                "        (\"HRO7DE\", \"QQXKH\", 24, 14.29, 8.59, 26.41),\n" +
                "        (\"2Z2KK9\", \"TWZNB\", 24, 13.76, 8.35, 18.27),\n" +
                "        (\"J9LK5J\", \"OAZAX\", 22, 16.85, 8.29, 27.85),\n" +
                "        (\"SHT14P\", \"HNVQZ\", 25, 12.09, 8.89, 21.24),\n" +
                "        (\"MU0DFA\", \"CIARW\", 24, 16.96, 7.99, 27.00),\n" +
                "        (\"47O37N\", \"JYFZP\", 24, 14.18, 8.20, 26.04),\n" +
                "        (\"E56G4Y\", \"QQXKH\", 21, 15.21, 7.58, 24.93),\n" +
                "        (\"P2O7TY\", \"TWZNB\", 20, 17.40, 7.91, 26.06),\n" +
                "        (\"WEC4YI\", \"OAZAX\", 24, 17.99, 8.49, 26.05),\n" +
                "        (\"3RN8P9\", \"HNVQZ\", 20, 12.39, 7.32, 20.38),\n" +
                "        (\"6BLPPT\", \"CIARW\", 24, 16.62, 7.84, 21.62),\n" +
                "        (\"JO8AT9\", \"JYFZP\", 23, 16.53, 7.03, 23.41),\n" +
                "        (\"U2WK8E\", \"QQXKH\", 25, 13.78, 8.88, 19.35),\n" +
                "        (\"KUUFZE\", \"TWZNB\", 20, 17.35, 7.26, 25.40),\n" +
                "        (\"BP9QOH\", \"OAZAX\", 20, 14.41, 7.24, 23.56),\n" +
                "        (\"6JK4M6\", \"HNVQZ\", 25, 14.46, 7.18, 25.36),\n" +
                "        (\"NQWPT5\", \"CIARW\", 24, 12.91, 7.97, 18.15),\n" +
                "        (\"IMRV97\", \"JYFZP\", 22, 14.95, 7.21, 19.32),\n" +
                "        (\"51M9N3\", \"QQXKH\", 21, 16.39, 7.46, 26.33),\n" +
                "        (\"QJQ3W5\", \"TWZNB\", 22, 16.66, 7.01, 24.58),\n" +
                "        (\"LXYLFJ\", \"OAZAX\", 25, 13.35, 7.14, 21.17),\n" +
                "        (\"KMMASZ\", \"HNVQZ\", 21, 13.27, 8.40, 18.64),\n" +
                "        (\"T9PODS\", \"CIARW\", 21, 12.66, 8.55, 20.00),\n" +
                "        (\"J2WVUJ\", \"JYFZP\", 24, 17.15, 7.60, 29.35),\n" +
                "        (\"4RR7LF\", \"QQXKH\", 22, 14.15, 7.15, 26.40),\n" +
                "        (\"4HLNQ2\", \"TWZNB\", 20, 17.38, 8.67, 22.75);";
        try {
            s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Loaded into wheels");
        sql = "INSERT INTO manufacturer\n" +
                "        (m_name, m_nation, m_sales) VALUES\n" +
                "\t(\"Acura\", \"JAPAN\", 447100332),\n" +
                "\t(\"Mercedes Benz\", \"GERMANY\", 770444210),\n" +
                "\t(\"Dodge\", \"UNITED STATES\", 568757876),\n" +
                "\t(\"Honda\", \"JAPAN\", 911180816),\n" +
                "\t(\"Subaru\", \"JAPAN\", 546727696),\n" +
                "\t(\"Hyundai\", \"SOUTH KOREA\", 150124313),\n" +
                "\t(\"Ford\", \"UNITED STATES\", 979843989),\n" +
                "\t(\"Rolls Royce\", \"UNITED KINGDOM\", 417980924),\n" +
                "\t(\"Volkswagen\", \"GERMANY\", 853777697),\n" +
                "\t(\"Chevrolet\", \"UNITED STATES\", 382619531),\n" +
                "\t(\"Chrysler\", \"UNITED STATES\", 845454540),\n" +
                "\t(\"Ferrari\", \"ITALY\", 824717770),\n" +
                "\t(\"Bentley\", \"UNITED KINGDOM\", 867708422);";
        try {
            s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Loaded into manufacturer");
        sql = "INSERT INTO extras\n" +
                "\t(ex_vin, ex_heated, ex_leather, ex_turbo, ex_spoiler, ex_tint, ex_convertible) VALUES\n" +
                "\t(\"Legend\", 0, 0, 0, 0, 0, 1),\n" +
                "\t(\"M Class\", 0, 0, 1, 1, 0, 0),\n" +
                "\t(\"Ram Pickup\", 0, 0, 0, 1, 0, 1),\n" +
                "\t(\"Accord\", 1, 0, 1, 0, 0, 0),\n" +
                "\t(\"Integra\", 1, 1, 1, 1, 0, 1),\n" +
                "\t(\"Legacy\", 1, 0, 1, 1, 1, 1),\n" +
                "\t(\"Sonata\", 1, 1, 0, 0, 0, 0),\n" +
                "\t(\"Legend\", 1, 1, 0, 1, 1, 0),\n" +
                "\t(\"NSX\", 0, 1, 0, 1, 0, 1),\n" +
                "\t(\"Taurus\", 0, 1, 1, 1, 0, 0),\n" +
                "\t(\"Phantom\", 1, 1, 0, 0, 1, 0),\n" +
                "\t(\"Jetta\", 1, 0, 1, 0, 1, 0),\n" +
                "\t(\"Tahoe\", 1, 0, 0, 0, 0, 1),\n" +
                "\t(\"300C\", 0, 1, 0, 1, 0, 0),\n" +
                "\t(\"F355\", 1, 1, 1, 1, 1, 0),\n" +
                "\t(\"F430\", 1, 0, 0, 1, 0, 1),\n" +
                "\t(\"F430\", 1, 0, 1, 1, 1, 1),\n" +
                "\t(\"456M\", 0, 0, 0, 0, 0, 0),\n" +
                "\t(\"456\", 1, 0, 1, 0, 0, 0),\n" +
                "\t(\"F430\", 1, 0, 1, 1, 1, 0),\n" +
                "\t(\"612\", 1, 0, 1, 1, 0, 1),\n" +
                "\t(\"Continental GT\", 1, 0, 0, 0, 1, 1),\n" +
                "\t(\"Continental GT V8\", 1, 0, 1, 1, 1, 1),\n" +
                "\t(\"Mulsanne\", 0, 0, 1, 0, 1, 1),\n" +
                "\t(\"Arnage\", 0, 1, 1, 0, 1, 1),\n" +
                "\t(\"Continental\", 1, 0, 1, 1, 1, 1),\n" +
                "\t(\"Mulsanne\", 0, 1, 0, 0, 0, 0),\n" +
                "\t(\"Continental GT\", 0, 1, 1, 0, 0, 1),\n" +
                "\n" +
                "\t(\"M Class\", 0, 1, 1, 0, 1, 0),\n" +
                "\t(\"Ram Pickup\", 1, 1, 1, 1, 0, 1),\n" +
                "\t(\"Accord\", 0, 1, 1, 0, 0, 1),\n" +
                "\t(\"Integra\", 1, 1, 1, 0, 0, 1),\n" +
                "\t(\"Legacy\", 1, 1, 1, 0, 1, 1),\n" +
                "\t(\"Sonata\", 0, 0, 1, 0, 0, 1),\n" +
                "\t(\"Legend\", 1, 1, 0, 0, 0, 1),\n" +
                "\t(\"NSX\", 0, 0, 0, 1, 0, 1),\n" +
                "\t(\"Tarus\", 0, 1, 1, 0, 0, 1),\n" +
                "\t(\"Phantom\", 0, 0, 1, 0, 0, 0),\n" +
                "\t(\"Jetta\", 1, 1, 0, 0, 1, 0),\n" +
                "\t(\"Tahoe\", 0, 1, 0, 0, 1, 1),\n" +
                "\t(\"300C\", 0, 1, 1, 1, 0, 1),\n" +
                "\t(\"F355\", 0, 0, 1, 0, 0, 0),\n" +
                "\t(\"F430 Coupe\", 1, 1, 1, 0, 0, 1),\n" +
                "\t(\"F430\", 1, 1, 1, 0, 0, 1),\n" +
                "\t(\"456M\", 1, 1, 1, 1, 1, 1),\n" +
                "\t(\"456\", 0, 1, 1, 0, 1, 0),\n" +
                "\t(\"F430 Coupe\", 0, 0, 1, 0, 0, 1),\n" +
                "\t(\"612\", 1, 1, 1, 0, 1, 0),\n" +
                "\t(\"Continental GT\", 0, 1, 0, 0, 0, 1),\n" +
                "\t(\"Continental GT V8\", 0, 0, 1, 1, 0, 0),\n" +
                "\t(\"Mulsanne\", 1, 1, 1, 0, 0, 0),\n" +
                "\t(\"Arnage\", 0, 1, 1, 0, 1, 1),\n" +
                "\t(\"Continental Flying Spur Speed\", 0, 1, 1, 0, 0, 1),\n" +
                "\t(\"Mulsanne\", 1, 1, 0, 0, 1, 1),\n" +
                "\t(\"Continental GT\", 0, 1, 1, 0, 0, 1);";
        try {
            s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Loaded into extras");
        sql = "INSERT INTO people\n" +
                "\t(p_license, p_phone, p_name, p_email, p_age) VALUES\n" +
                "\t(\"OCB4NDCR\", 5552345264, \"John Smoth\", \"jSmith@email.com\", 49),\n" +
                "\t(\"X5OT7H6T\", 5556392645, \"Olga Buck\", \"oBuck@email.com\", 62),\n" +
                "\t(\"88JDBI64\", 5559682745, \"Kasi Rozalija\", \"kroz@email.com\", 29),\n" +
                "\t(\"9VSR5354\", 5559529566, \"Loki Sarala\", \"lsarala@email.com\", 30),\n" +
                "\t(\"0P932C9K\", 5552352543, \"Nergui Anu\", \"nanu@email.com\", 31),\n" +
                "\t(\"53OFLNAW\", 5555902935, \"Pris Wolfe\", \"pwolfe@email.com\", 69),\n" +
                "\t(\"I5RQNWC1\", 5552352367, \"Lisbeth Caoligon\", \"lcao@email.com\", 71),\n" +
                "\t(\"IEZQFUTS\", 5559863423, \"John Smoth\", \"jsmoth@email.com\", 60),\n" +
                "\t(\"29VCTAG2\", 5559864332, \"Marilene Sibilla\", \"msibilla@email.com\", 58),\n" +
                "\t(\"PIL8HU75\", 5552353267, \"Payton Prunella\", \"pprun@email.com\", 25),\n" +
                "\t(\"0Q48PSO2\", 5559863235, \"Ashton Jantje\", \"ashtonjan@email.com\", 31),\n" +
                "\t(\"EV0NP8X0\", 5551152631, \"Aggie Lucius\", \"alucius@email.com\", 28),\n" +
                "\t(\"9LP4PUQK\", 5559821064, \"Steen Gunda\", \"sgunda@email.com\", 30),\n" +
                "\t(\"MYPYLSPY\", 5559863233, \"Nori Ninian\", \"nninian@email.com\", 36),\n" +
                "\t(\"EKNNVTJ5\", 5552386823, \"Keelan Iris\", \"kiris@email.com\", 48),\n" +
                "\t(\"S2ZWGCJA\", 5559812523, \"Marci Marylou\", \"mmary@email.com\", 54),\n" +
                "\t(\"RJTHMO4U\", 5559863299, \"Elsa Bertoldo\", \"elsabert@email.com\", 44),\n" +
                "\t(\"L2KKDVV2\", 5559217206, \"Marin Lex\", \"marinlex@email.com\", 26),\n" +
                "\t(\"MWFP46S5\", 5557752033, \"Xavior Kinsley\", \"xkin@email.com\", 52),\n" +
                "\t(\"ARZNAC3X\", 5558882593, \"Karin Rearden\", \"krearden@email.com\", 36),\n" +
                "\t(\"BVOKS5QT\", 5551985323, \"Skyler Hilmar\", \"shilmar@email.com\", 54),\n" +
                "\t(\"UL4ZB5HT\", 5559157239, \"Anima Emiel\", \"aemiel@email.com\", 34);";

        try {
            s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Loaded into people");
        sql = "INSERT INTO bids\n" +
                "\t(b_ID, b_price, b_licensePlate, b_name, b_phone) VALUES\n" +
                "  (\"B000\", 10000, \"123ABC0\", \"John Smoth\", 5552345264),\n" +
                "  (\"B001\", 20000, \"123ABC1\", \"Olga Buck\", 5556392645),\n" +
                "  (\"B002\", 53000, \"123ABC2\", \"Kasi Rozalija\", 5559682745),\n" +
                "  (\"B003\", 12000, \"123ABC3\", \"Loki Sarala\", 5559529566),\n" +
                "  (\"B004\", 24000, \"123ABC4\", \"Nergui Anu\", 5552352543),\n" +
                "  (\"B005\", 23500, \"123ABC5\", \"Pris Wolfe\", 5555902935),\n" +
                "  (\"B006\", 62000, \"123ABC6\", \"Lisbeth Caoligon\", 5552352367),\n" +
                "  (\"B007\", 32000, \"123ABC7\", \"John Smoth\", 5559863423),\n" +
                "  (\"B008\", 16000, \"123ABC8\", \"Marilene Sibilla\", 5559864332),\n" +
                "  (\"B009\", 100000, \"123ABC9\", \"Payton Prunella\", 5552353267),\n" +
                "  (\"B010\", 73000, \"123ABD0\", \"Ashton Jantje\", 5559863235),\n" +
                "  (\"B011\", 225000, \"123ABD1\", \"Aggie Lucius\", 5551152631),\n" +
                "  (\"B012\", 85000, \"123ABD2\", \"Steen Gunda\", 5559821064),\n" +
                "  (\"B013\", 92000, \"123ABD3\", \"Nori Ninian\", 5559863233),\n" +
                "  (\"B014\", 21000, \"123ABD4\", \"Keelan Iris\", 5552386823),\n" +
                "  (\"B015\", 200000, \"123ABD5\", \"Marci Marylou\", 5559812523),\n" +
                "  (\"B016\", 150000, \"123ABD6\", \"Elsa Bertoldo\", 5559863299),\n" +
                "  (\"B017\", 175000, \"123ABD7\", \"Marin Lex\", 5559217206),\n" +
                "  (\"B018\", 29500, \"123ABD8\", \"Xavior Kinsley\", 5557752033),\n" +
                "  (\"B019\", 18500, \"123ABD9\", \"Karin Rearden\", 5558882593),\n" +
                "  (\"B020\", 32000, \"123ABE0\", \"Skyler Hilmar\", 5551985323),\n" +
                "  (\"B021\", 45000, \"123ABE1\", \"Anima Emiel\", 5559157239);";
        try {
            s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Loaded into bids");

    }

    private static void runQ(String sql) {

    }

    private static void searchCar() {
        System.out.print("Desired Manufacturer: ");
        Scanner input = new Scanner(System.in);
        String sql = "SELECT v_vin FROM vehicle WHERE v_make = ?;";

        PreparedStatement pstmt = prepStatement(sql);
        String maker = input.nextLine();
        try {
            pstmt.setString(1, maker);
        } catch (SQLException e) {
            System.out.println("Could not find maker");
            e.printStackTrace();
        }

        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Could not fetch results");
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                  System.out.println(rs.getString("v_vin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(String tableName) {
        boolean shouldUpdate = false;
        String sql = null;
        s = getStatement();
        switch (tableName) {
            case "vehicle":
                sql = "CREATE TABLE IF NOT EXISTS vehicle (\n" +
                        "    v_vin     VARCHAR (40)   NOT NULL,\n" +
                        "    v_license VARCHAR (10)   NOT NULL,\n" +
                        "    v_year    DECIMAL (3)    NOT NULL,\n" +
                        "    v_make    VARCHAR (10)   NOT NULL,\n" +
                        "    v_model   VARCHAR (10)   NOT NULL,\n" +
                        "    v_color   VARCHAR (10)   NOT NULL,\n" +
                        "    v_price   DECIMAL (7, 2) NOT NULL\n" +
                        ");";
                shouldUpdate = true;
                break;
            case "hypercars":
                sql = "CREATE TABLE IF NOT EXISTS hypercars (\n" +
                        "    h_vin      VARCHAR (40) NOT NULL,\n" +
                        "    h_engine   VARCHAR (10) NOT NULL,\n" +
                        "    h_topSpeed DECIMAL (3)  NOT NULL,\n" +
                        "    h_trans    VARCHAR (10) NOT NULL,\n" +
                        "    h_weight   DECIMAL (3)  NOT NULL,\n" +
                        "    h_wheel    VARCHAR (10)   NOT NULL\n" +
                        ");";
                shouldUpdate = true;
                break;
            case "engine":
                sql = "CREATE TABLE IF NOT EXISTS engine (\n" +
                        "    e_model     VARCHAR (10) NOT NULL,\n" +
                        "    e_make      VARCHAR (10) NOT NULL,\n" +
                        "    e_cylinders DECIMAL (1)  NOT NULL,\n" +
                        "    e_hp        DECIMAL (10) NOT NULL,\n" +
                        "    e_torque    DECIMAL (10) NOT NULL,\n" +
                        "    e_size      DECIMAL (10) NOT NULL\n" +
                        ");";
                shouldUpdate = true;
                break;
            case "transmission":
                sql = "CREATE TABLE IF NOT EXISTS transmission (\n" +
                        "    t_model VARCHAR (10) NOT NULL,\n" +
                        "    t_gears DECIMAL (1)  NOT NULL,\n" +
                        "    t_type  BOOLEAN      NOT NULL\n" +
                        ");";
                shouldUpdate = true;
                break;
            case "wheels":
                sql = "CREATE TABLE IF NOT EXISTS wheels (\n" +
                        "    w_model       VARCHAR (10)   NOT NULL,\n" +
                        "    w_make        VARCHAR (10)   NOT NULL,\n" +
                        "    w_height      DECIMAL (3)    NOT NULL,\n" +
                        "    w_width       DECIMAL (3)    NOT NULL,\n" +
                        "    w_rim         DECIMAL (3)    NOT NULL,\n" +
                        "    w_diameter    DECIMAL (3)    NOT NULL\n" +
                        ");";
                shouldUpdate = true;
                break;
            case "manufacturer":
                sql = "CREATE TABLE IF NOT EXISTS manufacturer (\n" +
                        "    m_name   VARCHAR (10)    NOT NULL,\n" +
                        "    m_nation VARCHAR (10)    NOT NULL,\n" +
                        "    m_sales  DECIMAL (10, 2) NOT NULL\n" +
                        ");";
                shouldUpdate = true;
                break;
            case "extras":
                sql = "CREATE TABLE IF NOT EXISTS extras (\n" +
                        "    ex_vin         VARCHAR (40)   NOT NULL,\n" +
                        "    ex_heated      BOOLEAN        NOT NULL,\n" +
                        "    ex_leather     BOOLEAN        NOT NULL,\n" +
                        "    ex_turbo       BOOLEAN        NOT NULL,\n" +
                        "    ex_spoiler     BOOLEAN        NOT NULL,\n" +
                        "    ex_tint        BOOLEAN        NOT NULL,\n" +
                        "    ex_convertible BOOLEAN        NOT NULL\n" +
                        ");";
                shouldUpdate = true;
                break;
            case "people":
                sql = "CREATE TABLE IF NOT EXISTS  people (\n" +
                        "    p_license     VARCHAR        NOT NULL,\n" +
                        "    p_phone       DECIMAL        NOT NULL,\n" +
                        "    p_name        VARCHAR        NOT NULL,\n" +
                        "    p_email       VARCHAR        NOT NULL,\n" +
                        "    p_age         DECIMAL        NOT NULL\n" +
                        ");";
                shouldUpdate = true;
                break;
            case "bids":
                sql = "CREATE TABLE IF NOT EXISTS bids (\n" +
                        "    b_ID              VARCHAR    NOT NULL,\n" +
                        "    b_price           DECIMAL    NOT NULL,\n" +
                        "    b_licensePlate    VARCHAR    NOT NULL,\n" +
                        "    b_name            VARCHAR    NOT NULL,\n" +
                        "    b_phone           DECIMAL    NOT NULL\n" +
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
                System.out.print(tableName + ", ");
            } catch (SQLException e) {
                System.out.println("Failed to Create Table");
                e.printStackTrace();
            }
        }
    }

    private static void dropALLTables() {
        dropTable("engine");
        dropTable("bids");
        dropTable("extras");
        dropTable("hypercars");
        dropTable("manufacturer");
        dropTable("people");
        dropTable("transmission");
        dropTable("vehicle");
        dropTable("wheels");
    }

    private static void dropTable(String tableName) {
        String sql = null;
        boolean run = false;
        s =  getStatement();
        switch (tableName) {
            case "engine":
                sql  = "drop table if exists engine";
                run = true;
                break;
            case "manufacturer":
                sql = "drop table if exists manufacturer";
                run = true;
                break;
            case "vehicle":
                sql = "drop table if exists vehicle";
                run = true;
                break;
            case "wheels":
                sql = "drop table if exists wheels";
                run = true;
                break;
            case "hypercars":
                sql = "drop table if exists hypercars";
                run = true;
                break;
            case "extras":
                sql = "drop table if exists extras";
                run = true;
                break;
            case "bids":
                sql = "drop table if exists bids";
                run = true;
                break;
            case "people":
                sql = "drop table if exists people";
                run = true;
                break;
            case "transmission":
                sql = "drop table if exists hypercars";
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
        Scanner input = new Scanner(System.in);
        PreparedStatement pstmt = prepStatement(sql);
        String argumentStr;
        boolean run = false;

        switch (tableName) {
            case "engine":
                sql  = "INSERT INTO ENGINE (e_model, e_make, e_cylinders, e_hp,  e_torque, e_size) VALUES (?,?,?,?,?,?);";
                pstmt = prepStatement(sql);
                System.out.print("Engine Model set len 8: ");
                argumentStr = input.nextLine();
                if (argumentStr.length() != 8) break;
                try {
                    pstmt.setString(1, argumentStr);
                } catch (SQLException e) {
                    System.out.println("ERROR: INSERT TO TABLE ENGINE PARAM 1");
                    e.printStackTrace();
                }

                System.out.print("Engine Make max 15 char: ");
                argumentStr = input.nextLine();
                if (argumentStr.length() > 15) break;
                try {
                    pstmt.setString(2, argumentStr);
                } catch (SQLException e) {
                    System.out.println("ERROR: INSERT TO TABLE ENGINE PARAM 2");
                    e.printStackTrace();
                }

                System.out.print("Engine Cylinders: ");
                if (!handlePrepDouble(pstmt, input, 3)) break;


                System.out.print("Engine Hp: ");
                if (!handlePrepDouble(pstmt, input, 4)) break;

                System.out.print("Engine Torque: ");
                if (!handlePrepDouble(pstmt, input, 5)) break;

                System.out.print("Engine Size: ");
                if (!handlePrepDouble(pstmt, input, 6)) break;

                run = true;
                break;

            case "vehicle":
                String v_string;
                pstmt = prepStatement(sql);
                sql = "INSERT INTO vehicle (v_vin, v_license, v_year, v_make, v_model, v_color, v_price) VALUES (?, ?, ?, ?, ?, ?, ?)";


                System.out.print("vehicle vin set len 17: ");
                v_string = input.nextLine();
                if (v_string.length() != 17) break;
                try {
                    pstmt.setString(1, v_string);
                } catch (SQLException e) {
                    System.out.println("ERROR: INSERT TO TABLE ENGINE PARAM 1");
                    e.printStackTrace();
                }

                System.out.print("vehicle license plate set len 7: ");
                v_string = input.nextLine();
                if (v_string.length() != 7) break;
                try {
                    pstmt.setString(2, v_string);
                } catch (SQLException e) {
                    System.out.println("ERROR: INSERT TO TABLE ENGINE PARAM 2");
                    e.printStackTrace();
                }

                System.out.print("vehicle year: ");
                if (!handlePrepDouble(pstmt, input, 3)) break;

                System.out.print("vehicle make max len 15: ");
                v_string = input.nextLine();
                if (v_string.length() > 15) break;
                try {
                    pstmt.setString(4, v_string);
                } catch (SQLException e) {
                    System.out.println("ERROR: INSERT TO TABLE ENGINE PARAM 3");
                    e.printStackTrace();
                }

                System.out.print("vehicle model set len 8: ");
                v_string = input.nextLine();
                if (v_string.length() != 8) break;
                try {
                    pstmt.setString(5, v_string);
                } catch (SQLException e) {
                    System.out.println("ERROR: INSERT TO TABLE ENGINE PARAM 5");
                    e.printStackTrace();
                }

                System.out.print("vehicle color max len 10: ");
                v_string = input.nextLine();
                if (v_string.length() > 10) break;
                try {
                    pstmt.setString(6, v_string);
                } catch (SQLException e) {
                    System.out.println("ERROR: INSERT TO TABLE ENGINE PARAM 6");
                    e.printStackTrace();
                }

                System.out.print("vehicle price: ");
                if (!handlePrepDouble(pstmt, input, 7)) break;




                run = true;
                break;
            case "hypercars":
                sql = "";
                run = true;
                break;
            case "wheels":
                sql = "";
                run = true;
                break;
            default:
                System.out.println("Table " + tableName + " Schema not found in library");
                break;
        }
        if (run && sql != null) {
            try {
                System.out.println("Inserted item to "  + tableName);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Failed to insert to " + tableName);
                e.printStackTrace();
            }
        }
    }

    private static PreparedStatement prepStatement(String sql) {

        if (sql == null) return null;
        try {
            //System.out.println("\t\t\t\t\t\t\t\t Debug: Preparing Statement");
            PreparedStatement pstmt = c.prepareStatement(sql);
            return pstmt;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Boolean handlePrepDouble(PreparedStatement p, Scanner i, int argNum) {
        Double arguementDoub;
        if (i.hasNextDouble()) {
            arguementDoub = Double.parseDouble(i.next());
            try {
                p.setDouble(argNum, arguementDoub);
                return true;
            } catch (SQLException e) {
                System.out.println("ERROR: INSERT TO TABLE ENGINE PARAM " + argNum);
                e.printStackTrace();
            }
        } else {
            System.out.println("ERROR: ASKED FOR Double");
        }
        return false;
    }

    private static Statement getStatement() {
        //System.out.println("Creating Statement");

        //System.out.println("Created Statement from Connecting");
        Statement s = null;
        try {
            // System.out.println("Connected");
            connected = true;
            s = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
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
