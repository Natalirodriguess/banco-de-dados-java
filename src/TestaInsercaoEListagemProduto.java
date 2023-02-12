import dao.ProdutoDAO;
import modelo.Produto;

import java.sql.*;
import java.util.List;

public class TestaInsercaoEListagemProduto { // Classe especializada para trabalhar inserindo dados
    public static void main(String[] args) throws SQLException {
        Produto comoda = new Produto("Cômoda","Cômoda vertical");

        try (Connection connection = new ConnectionFactory().recuperarConexao()){
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            //new PersistenciaProduto(connection).salvarProduto(comoda);
            produtoDAO.salvar(comoda);
            List<Produto> listaDeProdutos = produtoDAO.listar();
            listaDeProdutos.stream().forEach( lp -> System.out.println(lp));

        }
    }
}
