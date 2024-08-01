package br.com.criador_tarefas.criador_tarefas.repository;

import br.com.criador_tarefas.criador_tarefas.domain.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TarefaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Tarefa> encontrarTodas() {
        return jdbcTemplate.query(
                "SELECT * FROM lista_tarefas",
                (rs, rowNum) -> mapRowToTarefa(rs)
        );
    }

    public Tarefa encontrarPorId(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM lista_tarefas WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> mapRowToTarefa(rs)
        );
    }

    public void inserir(Tarefa tarefa) {
        jdbcTemplate.update(
                "INSERT INTO lista_tarefas (descricao, status) VALUES (?, ?)",
                tarefa.getDescricao(), tarefa.getStatus()
        );
    }

    public void atualizar(Tarefa tarefa) {
        jdbcTemplate.update(
                "UPDATE lista_tarefas SET descricao = ?, status = ? WHERE id = ?",
                tarefa.getDescricao(), tarefa.getStatus(), tarefa.getId()
        );
    }

    public void excluir(int id) {
        jdbcTemplate.update(
                "DELETE FROM lista_tarefas WHERE id = ?",
                id
        );
    }

    private Tarefa mapRowToTarefa(ResultSet rs) throws SQLException {
        return new Tarefa(
                rs.getInt("id"),
                rs.getString("descricao"),
                rs.getString("status")
        );
    }
}
