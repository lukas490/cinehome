package cinehome;

import model.filmes;
import model.usuario;
import service.filmeService;
import service.usuarioService;

import java.util.List;

public class Cinehome {
    public static void main(String[] args) {
        filmeService filmeService = new filmeService();
        usuarioService usuarioService = new usuarioService();

        // Criar e salvar filme
        filmes f = new filmes();
        f.setIdUsuario(1); 
        f.setNome("Matrix");
        f.setGenero("Ficção");
        f.setProdutor("Warner");
        f.setAno("1999");
        filmeService.adicionarFilme(f);


        List<filmes> filmes = filmeService.buscarFilmes("Matrix");
        filmes.forEach(filme -> System.out.println(filme.getNome() + " - " + filme.getAno()));


        usuario u = new usuario();
        u.setLogin("admin");
        u.setSenha("123456");
        usuario usuarioLogado = usuarioService.validarUsuario(u);
        if (usuarioLogado != null) System.out.println("Usuário válido: " + usuarioLogado.getTipo());
        else System.out.println("Usuário inválido");
    }
}