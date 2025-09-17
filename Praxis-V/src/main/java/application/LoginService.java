package application;

import infrastructure.UsuarioDatabase;

public class LoginService {

    public boolean autenticar(String login, String senha) {

        return UsuarioDatabase.authenticate(login, senha) != null;
    }
}
