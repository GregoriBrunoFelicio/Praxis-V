package domain.entities;
import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nome;
    private String descricao;
    private List<Usuario> membros = new ArrayList<>();
    private List<Projeto> projetos = new ArrayList<>();

    public Equipe(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public void adicionarMembro(Usuario usuario) {
        membros.add(usuario);
    }

    public void adicionarProjeto(Projeto projeto) {
        projetos.add(projeto);
    }
}
