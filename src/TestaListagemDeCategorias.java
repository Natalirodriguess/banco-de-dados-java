import com.mysql.cj.PerConnectionLRUFactory;

import dao.CategoriaDAO;
import modelo.Categoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemDeCategorias {

    public static void main(String[] args) throws SQLException {
        try (Connection connection = new ConnectionFactory().recuperarConexao()){
            CategoriaDAO categoriaDao = new CategoriaDAO(connection);
            List<Categoria> listaDeCategoria = categoriaDao.listar();
            listaDeCategoria.stream().forEach(ct -> System.out.println(ct.getNome()));
        }
        
    }
}