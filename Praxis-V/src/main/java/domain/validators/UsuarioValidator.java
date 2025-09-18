package domain.validators;

import domain.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioValidator {

    private final List<String> errors = new ArrayList<>();

    public boolean isValid(Usuario usuario) {
        errors.clear();

        if (usuario.getNomeCompleto() == null || usuario.getNomeCompleto().isBlank())
            errors.add("Nome não pode ser vazio");

        if (usuario.getCpf() == null || usuario.getCpf().length() != 11)
            errors.add("CPF deve ter 11 caracteres");

        if (usuario.getEmail() == null ||
                !usuario.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
            errors.add("E-mail inválido");

        if (usuario.getCargo() == null || usuario.getCargo().isBlank())
            errors.add("Cargo não pode ser vazio");

        if (usuario.getLogin() == null || usuario.getLogin().isBlank())
            errors.add("Login não pode ser vazio");

        if (usuario.getSenha() == null || usuario.getSenha().length() <= 2)
            errors.add("Senha deve ter mais de 2 caracteres");

        if (usuario.getPerfil() == null)
            errors.add("Perfil é obrigatório");

        return errors.isEmpty();
    }

    public List<String> getErrors() {
        return new ArrayList<>(errors);
    }
}
