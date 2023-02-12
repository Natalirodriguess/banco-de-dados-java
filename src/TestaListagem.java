import java.sql.*;

public class TestaListagem {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        PreparedStatement statement = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
        // boolean resultado = statement.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
        statement.execute();

        ResultSet result = statement.getResultSet(); // pegando de fato os dados no banco

        while(result.next()){
            Integer id = result.getInt("ID");
            System.out.println(id);
            String nome = result.getString("NOME");
            System.out.println(nome);
            String descricao = result.getString("DESCRICAO");
            System.out.println(descricao);
        }

        connection.close();
    }
}
