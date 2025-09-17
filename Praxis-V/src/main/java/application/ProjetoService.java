package application;

import application.interfaces.IService;
import domain.entities.Projeto;
import infrastructure.ProjetoDatabase;

import java.util.List;

public class ProjetoService implements IService<Projeto> {

    public void cadastrar(Projeto projeto) {

        // TODO: criar validacoes
        ProjetoDatabase.add(projeto);
    }

    public void atualizar(Projeto projeto) {
        ProjetoDatabase.update(projeto);
    }

    public void remover(int id) {
        ProjetoDatabase.remove(id);
    }

    public Projeto buscarPorId(int id) {
        return ProjetoDatabase.getById(id);
    }

    public List<Projeto> listar() {
        return ProjetoDatabase.getAll();
    }
}
