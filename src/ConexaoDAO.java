import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
    public Connection connectDB() {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/uc11?user=root&password=root"; // ajuste se necessário
            conn = DriverManager.getConnection(url);
        } catch (SQLException erro) {
            System.out.println("Erro de conexão: " + erro.getMessage());
        }

        return conn;
    }
}
