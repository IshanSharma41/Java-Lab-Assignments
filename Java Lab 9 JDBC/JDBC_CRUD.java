import java.sql.*;

public class JDBC_CRUD {

    static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_assignment";
    static final String USER = "root";
    static final String PASS = "20602@XyZ";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {
                System.out.println("Connected to database successfully.\n");

                createTables(con);
                insertData(con);

                System.out.println("\nALL RESTAURANT RECORDS:");
                printQuery(con, "SELECT * FROM Restaurant");

                System.out.println("\nALL MENUITEM RECORDS:");
                printQuery(con, "SELECT * FROM MenuItem");

                System.out.println("\nMENUITEM RECORDS WHERE PRICE <= 100:");
                printQuery(con, "SELECT * FROM MenuItem WHERE Price <= 100");

                System.out.println("\nMENUITEM RECORDS AVAILABLE IN RESTAURANT NAMED 'Cafe Java':");
                printQuery(con,
                        "SELECT m.Id, m.Name, m.Price, m.ResId " +
                        "FROM MenuItem m " +
                        "JOIN Restaurant r ON m.ResId = r.Id " +
                        "WHERE r.Name = 'Cafe Java'");

                updateMenuItems(con);

                System.out.println("\nMENUITEM RECORDS AFTER UPDATING PRICE <= 100 TO 200:");
                printQuery(con, "SELECT * FROM MenuItem");

                deleteMenuItems(con);

                System.out.println("\nMENUITEM RECORDS AFTER DELETING NAMES STARTING WITH 'P':");
                printQuery(con, "SELECT * FROM MenuItem");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void createTables(Connection con) throws SQLException {
        String dropMenu = "DROP TABLE IF EXISTS MenuItem";
        String dropRestaurant = "DROP TABLE IF EXISTS Restaurant";

        String createRestaurant =
                "CREATE TABLE Restaurant (" +
                "Id INT PRIMARY KEY, " +
                "Name VARCHAR(100) NOT NULL, " +
                "Address VARCHAR(200) NOT NULL" +
                ")";

        String createMenuItem =
                "CREATE TABLE MenuItem (" +
                "Id INT PRIMARY KEY, " +
                "Name VARCHAR(100) NOT NULL, " +
                "Price DECIMAL(10,2) NOT NULL, " +
                "ResId INT NOT NULL, " +
                "FOREIGN KEY (ResId) REFERENCES Restaurant(Id)" +
                ")";

        try (Statement st = con.createStatement()) {
            st.executeUpdate(dropMenu);
            st.executeUpdate(dropRestaurant);
            st.executeUpdate(createRestaurant);
            st.executeUpdate(createMenuItem);
        }

        System.out.println("Tables created successfully.");
    }

    static void insertData(Connection con) throws SQLException {
        String insertRestaurant = "INSERT INTO Restaurant (Id, Name, Address) VALUES (?, ?, ?)";
        String insertMenuItem = "INSERT INTO MenuItem (Id, Name, Price, ResId) VALUES (?, ?, ?, ?)";

        try (PreparedStatement psRes = con.prepareStatement(insertRestaurant);
             PreparedStatement psMenu = con.prepareStatement(insertMenuItem)) {

            Object[][] restaurants = {
                    {1, "Burger House", "MG Road, Pune"},
                    {2, "Spice Corner", "FC Road, Pune"},
                    {3, "Cafe Java", "Baner, Pune"},
                    {4, "Pizza Point", "Kothrud, Pune"},
                    {5, "Tandoori Treat", "Wakad, Pune"},
                    {6, "Green Bowl", "Aundh, Pune"},
                    {7, "Taste Villa", "Hinjewadi, Pune"},
                    {8, "Sushi World", "Viman Nagar, Pune"},
                    {9, "Dessert Den", "Camp, Pune"},
                    {10, "South Delight", "Sinhagad Road, Pune"}
            };

            for (Object[] r : restaurants) {
                psRes.setInt(1, (Integer) r[0]);
                psRes.setString(2, (String) r[1]);
                psRes.setString(3, (String) r[2]);
                psRes.executeUpdate();
            }

            Object[][] menuItems = {
                    {1, "Pasta", 120.00, 3},
                    {2, "Paneer Burger", 90.00, 3},
                    {3, "Pizza", 250.00, 4},
                    {4, "Poha", 60.00, 10},
                    {5, "Pav Bhaji", 110.00, 2},
                    {6, "Coffee", 80.00, 3},
                    {7, "Salad", 95.00, 6},
                    {8, "Noodles", 140.00, 7},
                    {9, "Paratha", 70.00, 5},
                    {10, "Ice Cream", 50.00, 9}
            };

            for (Object[] m : menuItems) {
                psMenu.setInt(1, (Integer) m[0]);
                psMenu.setString(2, (String) m[1]);
                psMenu.setDouble(3, (Double) m[2]);
                psMenu.setInt(4, (Integer) m[3]);
                psMenu.executeUpdate();
            }
        }

        System.out.println("10 records inserted into each table.");
    }

    static void updateMenuItems(Connection con) throws SQLException {
        String updateSql = "UPDATE MenuItem SET Price = 200 WHERE Price <= 100";

        try (Statement st = con.createStatement()) {
            int rows = st.executeUpdate(updateSql);
            System.out.println("\nRows updated: " + rows);
        }
    }

    static void deleteMenuItems(Connection con) throws SQLException {
        String deleteSql = "DELETE FROM MenuItem WHERE Name LIKE 'P%'";

        try (Statement st = con.createStatement()) {
            int rows = st.executeUpdate(deleteSql);
            System.out.println("\nRows deleted: " + rows);
        }
    }

    static void printQuery(Connection con, String sql) throws SQLException {
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            ResultSetMetaData md = rs.getMetaData();
            int cols = md.getColumnCount();

            int[] widths = new int[cols + 1];
            for (int i = 1; i <= cols; i++) {
                widths[i] = md.getColumnLabel(i).length();
            }

            while (rs.next()) {
                for (int i = 1; i <= cols; i++) {
                    String val = rs.getString(i);
                    if (val == null) val = "NULL";
                    widths[i] = Math.max(widths[i], val.length());
                }
            }

            rs.beforeFirst();

            StringBuilder line = new StringBuilder();
            for (int i = 1; i <= cols; i++) {
                line.append("+");
                line.append("-".repeat(widths[i] + 2));
            }
            line.append("+");

            System.out.println(line);
            for (int i = 1; i <= cols; i++) {
                System.out.printf("| %-" + widths[i] + "s ", md.getColumnLabel(i));
            }
            System.out.println("|");
            System.out.println(line);

            while (rs.next()) {
                for (int i = 1; i <= cols; i++) {
                    String val = rs.getString(i);
                    if (val == null) val = "NULL";
                    System.out.printf("| %-" + widths[i] + "s ", val);
                }
                System.out.println("|");
            }

            System.out.println(line);
        }
    }
}