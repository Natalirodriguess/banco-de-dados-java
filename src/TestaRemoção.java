import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemoção {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        PreparedStatement statement = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
        statement.setInt(1, 2); // 1 representa o primeiro índice (que é o id) e o valor maior que 2
        statement.execute();

        Integer linhasModificadas = statement.getUpdateCount(); // pegar as linhas modificadas nesse statement

        System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);

    }
}
