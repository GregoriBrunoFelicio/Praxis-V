package domain;

import java.time.LocalDate;

public class Tarefa {
    private String titulo;
    private String descricao;
    private Projeto projeto;
    private Usuario responsavel;
    private StatusTarefa status;
    private LocalDate dataInicioPrevista;
    private LocalDate dataFimPrevista;
    private LocalDate dataInicioReal;
    private LocalDate dataFimReal;

    public Tarefa(String titulo, String descricao, Projeto projeto, Usuario responsavel,
                  StatusTarefa status, LocalDate dataInicioPrevista, LocalDate dataFimPrevista) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.projeto = projeto;
        this.responsavel = responsavel;
        this.status = status;
        this.dataInicioPrevista = dataInicioPrevista;
        this.dataFimPrevista = dataFimPrevista;
    }

    // Getters e setters...
}
