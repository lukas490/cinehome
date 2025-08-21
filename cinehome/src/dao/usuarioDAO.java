package dao;

import model.usuario;
import util.databaseConnection;
import java.sql.*;

public class usuarioDAO {

    public usuario validarUsuario(usuario u) {
        String sql = "SELECT u.*, n.descricao AS tipo FROM usuario u "+
                     "JOIN nivel_acesso n ON u.idTipo = n.id "+
                     "WHERE u.login = ? AND u.senha = ?";

        usuario usuarioEncontrado = null;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, u.getLogin());
            st.setString(2, u.getSenha());
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                usuarioEncontrado = new usuario();
                usuarioEncontrado.setLogin(rs.getString("login"));
                usuarioEncontrado.setSenha(rs.getString("senha"));
                usuarioEncontrado.setTipo(rs.getString("tipo"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return usuarioEncontrado;
    }
}

