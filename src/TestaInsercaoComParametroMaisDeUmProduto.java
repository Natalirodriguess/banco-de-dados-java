import java.sql.*;

public class TestaInsercaoComParametroMaisDeUmProduto {
    public static void main(String[] args) throws SQLException {
        String nome = "";
        String descricao = "";

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();
        connection.setAutoCommit(false); // trabalhando manualmente com o banco de dados

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            adicionarVarivavel("SmartTV", "45 polegadas", statement);
            adicionarVarivavel("Radio", "radio de bateria", statement);

            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ROLLBACK EXECUTADO");
            connection.rollback();
        }


    }

    private static void adicionarVarivavel(String nome, String descricao, PreparedStatement statement) throws SQLException {
        statement.setString(1, nome);
        statement.setString(2, descricao);

        if(nome.equals("Radio")){
            throw new RuntimeException("Não foi possível adicionar o produto");
        }

        statement.execute();
        ResultSet result = statement.getGeneratedKeys();
        while(result.next()) {
            Integer id = result.getInt(1);
            System.out.println("O id criado foi: " + id);
        }
    }


}
