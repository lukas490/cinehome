package service;

import dao.filmesDAO;
import model.filmes;
import java.util.List;


public class filmeService {
    private filmesDAO dao = new filmesDAO();
    
    public boolean validarTitulo(String nome) {
    return nome != null && !nome.trim().isEmpty();
}


    public int adicionarFilme(filmes f) { return dao.salvar(f); }
    public int atualizarFilme(filmes f) { return dao.atualizar(f); }
    public boolean removerFilme(int id) { return dao.excluir(id); }
    public List<filmes> buscarFilmes(String nome) { return dao.consultar(nome); }
}

