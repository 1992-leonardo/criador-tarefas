package br.com.criador_tarefas.criador_tarefas.controller;

import br.com.criador_tarefas.criador_tarefas.domain.Tarefa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public interface CriadorTarefasControllerInterface {

    @GetMapping("/teste")
    public String testandoCriadorTarefas();

    @GetMapping("/testarConexaoBanco")
    List<Tarefa> testestarConexaoBanco();


}
