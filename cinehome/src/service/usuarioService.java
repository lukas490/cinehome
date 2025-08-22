package service;

import dao.usuarioDAO;
import model.usuario;

public class usuarioService {
    
    public boolean validarSenha(String senha) {
    return senha != null && senha.length() >= 6;}

    
    private usuarioDAO dao = new usuarioDAO();

    public usuario validarUsuario(usuario u) { return dao.validarUsuario(u); }
}


