package infrastructure;

import domain.Perfil;
import domain.Usuario;

import java.util.*;

public class UsuarioDatabase {
    private static final List<Usuario> usuarios = new ArrayList<>(
            List.of(
                    new Usuario("admin", "000.000.000-00", "admin@email.com",
                            "Administrador", "admin", "123", Perfil.ADMINISTRADOR),

                    new Usuario("Gregori Felicio", "000.000.000-00", "gregori@email.com",
                            "Programador", "gregori", "123", Perfil.COLABORADOR),

                    new Usuario("Maria Silva", "000.000.000-00", "maria@email.com",
                            "PO", "maria", "123", Perfil.COLABORADOR),

                    new Usuario("Lailla Silva", "000.000.000-00", "lailla@email.com",
                            "QA", "lailla", "123", Perfil.COLABORADOR),

                    new Usuario("Maicon Silva", "000.000.000-00", "micon@email.com",
                            "Gerente", "maicon", "123", Perfil.GERENTE)
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