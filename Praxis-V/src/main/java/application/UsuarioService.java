package application;

import application.interfaces.IService;
import domain.entities.Usuario;
import infrastructure.UsuarioDatabase;

import java.util.List;

public class UsuarioService implements IService<Usuario> {

    public void cadastrar(Usuario usuario) {

        // TODO: Fazer validaçoes
        UsuarioDatabase.add(usuario);
    }

    public void atualizar(Usuario usuario) {
        // TODO: Fazer validaçoes
        UsuarioDatabase.update(usuario);
    }

    public void remover(int id) {
        UsuarioDatabase.remove(id);
    }

    public Usuario buscarPorId(int id) {
        return UsuarioDatabase.getById(id);
    }
    public List<Usuario> listar() {
        return UsuarioDatabase.getAll();
    }
}
