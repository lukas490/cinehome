package operacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class usuarioBD {
    public static usuario validarUsuarioSeguro(usuario u) {
                              
                              String sql = "SELECT u.*, n.descricao AS tipo FROM usuario u "+
                                           "JOIN nivel_acesso n ON u.idTipo = n.id "+
                                           "WHERE u.login = ? AND u.senha = ?";
                              usuario usuarioEncontrado = null;
                      
                              try {
                                  Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinehome", "root", "lulu2808");
                                  PreparedStatement statement = conexao.prepareStatement(sql);
                                  
                                  statement.setString(1, u.getLogin());
                                  statement.setString(2, u.getSenha());
                                  ResultSet rs = statement.executeQuery();
                      
                                  while (rs.next()) {
                                      usuarioEncontrado = new usuario();
                                      usuarioEncontrado.setSenha(rs.getString("senha"));
                                      usuarioEncontrado.setTipo(rs.getString("tipo"));
                                      usuarioEncontrado.setLogin(rs.getString("login"));

                                  }
                              } catch (SQLException ex) {
                                  System.out.println("Sintaxe de comando invalida"+ ex.getMessage());
                                  ex.printStackTrace();
                              }
                              
                              return usuarioEncontrado;
                          }
}
