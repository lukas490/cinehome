package service;

import dao.usuarioDAO;
import model.usuario;

public class usuarioService {
    private usuarioDAO dao = new usuarioDAO();

    public usuario validarUsuario(usuario u) { return dao.validarUsuario(u); }
}

