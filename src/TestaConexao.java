import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory criaConexao = new ConnectionFactory(); //criando o pool de conexões
        Connection connection = criaConexao.recuperarConexao();
        connection.close();

    }
}