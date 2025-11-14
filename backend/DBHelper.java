package backend;

import java.sql.*;

public class DBHelper {

    private static Connection conn;

    // ✅ Mendapatkan koneksi
    public static Connection getConnection() {
        if (conn == null) {
            try {
                String url = "jdbc:postgresql://localhost:5432/dbperpus";
                String user = "postgres";
                String pass = "raihan100";

                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(url, user, pass);

                System.out.println("Koneksi berhasil wok!");
            } catch (Exception e) {
                System.out.println("Koneksi gagal: " + e.getMessage());
            }
        }
        return conn;
    }

    // ✅ Insert dan ambil ID (RETURNING id)
    public static int insertQueryGetId(String query) {
        int result = -1;

        try {
            Connection c = getConnection();

            // PostgreSQL: gunakan RETURNING id
            PreparedStatement stmt = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getInt(1);
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean executeQuery(String query) {
        getConnection();
        boolean result = false;
        try {
            Connection c = getConnection();
            Statement stmt = c.createStatement();
            stmt.executeUpdate(query);
            result = true;
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ResultSet selectQuery(String query) {
        getConnection();
        ResultSet rs = null;
        try {
            Connection c = getConnection();
            Statement stmt = c.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void main(String[] args) {
        DBHelper.getConnection();
    }
}
