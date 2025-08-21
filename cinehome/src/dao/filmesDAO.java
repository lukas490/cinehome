package dao;

import model.filmes;
import util.databaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class filmesDAO {

    public int salvar(filmes f) {
        String sql = "INSERT INTO filmes(idUsuario, nome, genero, produtor, ano) VALUES(?,?,?,?,?)";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            
            st.setInt(1, f.getIdUsuario());
            st.setString(2, f.getNome());
            st.setString(3, f.getGenero());
            st.setString(4, f.getProdutor());
            st.setString(5, f.getAno());
            return st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return ex.getErrorCode();
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM filmes WHERE id = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setInt(1, id);
            return st.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public int atualizar(filmes f) {
        String sql = "UPDATE filmes SET nome = ?, genero = ?, produtor = ?, ano = ? WHERE id = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, f.getNome());
            st.setString(2, f.getGenero());
            st.setString(3, f.getProdutor());
            st.setString(4, f.getAno());
            st.setInt(5, f.getId());
            return st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return ex.getErrorCode();
        }
    }

    public List<filmes> consultar(String nome) {
        List<filmes> lista = new ArrayList<>();
        String sql = "SELECT * FROM filmes WHERE nome LIKE ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, "%" + nome + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                filmes f = new filmes();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setGenero(rs.getString("genero"));
                f.setProdutor(rs.getString("produtor"));
                f.setAno(rs.getString("ano"));
                lista.add(f);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}

