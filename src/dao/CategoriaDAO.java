package dao;

import modelo.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private Connection connection;

    public CategoriaDAO(){

    }

    public CategoriaDAO(Connection connection){
        this.connection = connection;

    }

    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT ID, NOME FROM CATEGORIA";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.execute();
            try(ResultSet result = preparedStatement.getResultSet()){
                while(result.next()){
                    Categoria categoria = new Categoria(result.getInt(1), result.getString(2));
                    categorias.add(categoria);
                }
                return  categorias;
            }

        }
    }
}
