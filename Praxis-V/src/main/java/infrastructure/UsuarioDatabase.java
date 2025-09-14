package infrastructure;

import domain.Perfil;
import domain.Usuario;

import java.util.*;

public class UsuarioDatabase {
    private static final List<Usuario> usuarios = new ArrayList<>(
            List.of(
                    new Usuario("admin", "000.000.000-00", "admin@email.com",
                            "Administrador", "admin", "admin", Perfil.ADMINISTRADOR)
            )
    );

    private static int ultimoId = 0;

    public static void add(Usuario usuario) {
        usuario.setId(++ultimoId);
        usuarios.add(usuario);
    }

    public static void update(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuario.getId()) {
                usuarios.set(i, usuario);
                break;
            }
        }
    }

    public static List<Usuario> getAll() {
        return new ArrayList<>(usuarios);
    }

    public static Usuario getById(int id) {
        return usuarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static void remove(int id) {
        usuarios.removeIf(u -> u.getId() == id);
    }

    public static Usuario authenticate(String login, String senha) {
        return usuarios.stream()
                .filter(u -> u.getLogin().equals(login) && u.getSenha().equals(senha))
                .findFirst()
                .orElse(null);
    }

    public static void clear() {
        usuarios.clear();
        ultimoId = 0;
    }
}