import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private static final String URL = "jdbc:mysql://localhost:3306/crudPOO";
    private static final String USER = "root";
    private static final String PASS = "root";

    private static Connection conexao;
    
    private ConexaoBanco() {}

    public static Connection getConexao() throws SQLException {
        if (conexao == null) {
            conexao = DriverManager.getConnection(URL, USER, PASS);
        }
        return conexao;
    }
}
