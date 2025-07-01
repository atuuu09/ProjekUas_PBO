import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiTest {

    // Konfigurasi koneksi ke MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/toko_bunga"; // ganti sesuai nama DB kamu
    private static final String USER = "root"; // ganti kalau username-nya beda
    private static final String PASS = "";     // isi kalau ada password

    // Fungsi koneksi
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // untuk MySQL versi 8+
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Fungsi utama untuk tes koneksi
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println(" Koneksi ke database berhasil!");
        } else {
            System.out.println(" Koneksi gagal. Periksa URL, username, atau password.");
        }
    }
}
