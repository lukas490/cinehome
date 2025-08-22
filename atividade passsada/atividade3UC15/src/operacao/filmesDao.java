package operacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class filmesDao {
    Connection conn;
    PreparedStatement st;
    ResultSet rs;

    public boolean conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinehome","root", "lulu2808");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }


    public int salvar(filmes f){
    int status;
        try {
            st = conn.prepareStatement("INSERT INTO filmes(nome, genero, produtor, ano) VALUES(?,?,?,?)");
            st.setString(1,f.getNome());
            st.setString(2,f.getGenero());
            st.setString(3,f.getProdutor());
            st.setString(4,f.getAno());
           
            status = st.executeUpdate();
            return status; //retornar 1
            
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
        public boolean excluir(int id){
        try {
            st = conn.prepareStatement("DELETE FROM filmes WHERE id = ?");
            st.setInt(1, id);
            int linhasAfetadas = st.executeUpdate();
            return linhasAfetadas > 0;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
        }
    }
        public int atualizar(filmes f){
        int status;

            try {
            st = conn.prepareStatement("UPDATE filmes SET nome = ?, genero = ?, produtor = ?, ano = ? where id = ?");
            st.setString(1,f.getNomeAtualizar());
            st.setString(2,f.getGeneroAtualizar());
            st.setString(3, f.getProdutorAtualizar());
            st.setString(4, f.getAnoAtualizar());
            st.setInt(5,f.getId());
            status = st.executeUpdate();
            return status; //retornar 1

        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            return ex.getErrorCode();
            
          }
        }
        
        public List<filmes> consultar (String nome){
        List<filmes> lista = new ArrayList<>();
    try {
        st = conn.prepareStatement("SELECT * FROM filmes WHERE nome LIKE ?");
        st.setString(1, "%" + nome + "%");
        
        rs = st.executeQuery();
        
        while (rs.next()) {
            filmes f = new filmes();
            f.setIdTabela(rs.getString("id"));
            f.setNome(rs.getString("nome"));
            f.setGenero(rs.getString("genero"));
            f.setProdutor(rs.getString("produtor"));
            f.setAno(rs.getString("ano"));
            lista.add(f);
        }
    } catch (SQLException ex) {
        System.out.println("Erro ao consultar: " + ex.getMessage());
    }
    return lista;
    }
        
    
        
    
     public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
        
        }
    
    
    
     } 
}
