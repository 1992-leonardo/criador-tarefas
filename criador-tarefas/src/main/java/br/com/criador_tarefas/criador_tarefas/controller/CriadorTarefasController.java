package br.com.criador_tarefas.criador_tarefas.controller;

import br.com.criador_tarefas.criador_tarefas.domain.Tarefa;
import br.com.criador_tarefas.criador_tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CriadorTarefasController implements CriadorTarefasControllerInterface {

    @Override
    public String testandoCriadorTarefas() {
        return "Testando meu criador de tarefas";
    }

    @Autowired
    TarefaService tarefaService;

    @Override
    public List<Tarefa> testestarConexaoBanco() {
        return tarefaService.listarTarefa();
    }
}
