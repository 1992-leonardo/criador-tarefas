package br.com.criador_tarefas.criador_tarefas.domain;

public class Tarefa {

    private int id;
    private String descricao;
    private String status;

    // Construtor com id
    public Tarefa(int id, String descricao, String status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    // Construtor sem id
    public Tarefa(String descricao, String status) {
        this.descricao = descricao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
