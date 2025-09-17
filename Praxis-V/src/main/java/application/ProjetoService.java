package application;

import domain.entities.Projeto;
import infrastructure.ProjetoDatabase;

import java.util.List;

public class ProjetoService {

    public void cadastrar(Projeto projeto) {

        // TODO: criar validacoes
        ProjetoDatabase.add(projeto);
    }

    public Projeto buscarPorId(int id) {
        return ProjetoDatabase.getById(id);
    }

    public void atualizar(Projeto projeto) {
        ProjetoDatabase.update(projeto);
    }

    public void remover(int id) {
        ProjetoDatabase.remove(id);
    }

    public List<Projeto> listar() {
        return ProjetoDatabase.getAll();
    }
}
