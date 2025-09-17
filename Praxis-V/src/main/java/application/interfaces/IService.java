package application.interfaces;


import domain.entities.Entidade;

import java.util.List;

public interface IService<T extends Entidade> {
    void cadastrar(T obj);
    void atualizar(T obj);
    void remover(int id);
    T buscarPorId(int id);
    List<T> listar();
}
