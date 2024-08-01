package br.com.criador_tarefas.criador_tarefas.service;

import br.com.criador_tarefas.criador_tarefas.domain.Tarefa;
import br.com.criador_tarefas.criador_tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> listarTarefa() {
        return tarefaRepository.encontrarTodas();
    }

}
