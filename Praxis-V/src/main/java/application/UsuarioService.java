package application;

import application.interfaces.IService;
import domain.entities.Usuario;
import infrastructure.UsuarioDatabase;

import java.util.List;

public class UsuarioService implements IService<Usuario> {

    @Override
    public void cadastrar(Usuario usuario) {
        UsuarioDatabase.add(usuario);
    }

    @Override
    public void atualizar(Usuario usuario) {
        UsuarioDatabase.update(usuario);
    }

    @Override
    public void remover(int id) {
        UsuarioDatabase.remove(id);
    }

    @Override
    public Usuario buscarPorId(int id) {
        return UsuarioDatabase.getById(id);
    }

    @Override
    public List<Usuario> listar() {
        return UsuarioDatabase.getAll();
    }
}
