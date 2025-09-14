package application;

import domain.Usuario;
import infrastructure.UsuarioDatabase;

import java.util.List;

public class UsuarioService {

    public void cadastrar(Usuario usuario) {

        // TODO: Fazer validaçoes
        UsuarioDatabase.add(usuario);
    }

    public void atualizar(Usuario usuario) {
        // TODO: Fazer validaçoes
        UsuarioDatabase.update(usuario);
    }

    public Usuario buscarPorId(int id) {
        return UsuarioDatabase.getById(id);
    }

    public void remover(int id) {
        UsuarioDatabase.remove(id);
    }

    public List<Usuario> listar() {
        return UsuarioDatabase.getAll();
    }
}
