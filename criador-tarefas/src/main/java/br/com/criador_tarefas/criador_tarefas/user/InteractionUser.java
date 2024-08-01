package br.com.criador_tarefas.criador_tarefas.user;

import br.com.criador_tarefas.criador_tarefas.domain.Tarefa;
import br.com.criador_tarefas.criador_tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class InteractionUser implements CommandLineRunner {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            listarTarefas(); // Lista todas as tarefas antes de mostrar as opções

            System.out.println("Escolha uma das opcoes:");
            System.out.println("1 - Visualizar");
            System.out.println("2 - Inserir");
            System.out.println("3 - Editar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Encerrar");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    visualizarTarefa(scanner);
                    break;
                case 2:
                    inserirTarefa(scanner);
                    break;
                case 3:
                    editarTarefa(scanner);
                    break;
                case 4:
                    excluirTarefa(scanner);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcao informada invalida.");
            }

            if (continuar) {
                System.out.println("Deseja mais alguma tarefa? Informe 's' para sim, e 'n' para nao.");
                String resposta = scanner.next();
                if (resposta.equalsIgnoreCase("n")) {
                    continuar = false;
                }
            }
        }

        System.out.println("Criador de tarefas encerrado.");
    }

    private void listarTarefas() {
        List<Tarefa> tarefas = tarefaRepository.encontrarTodas();
        System.out.println("Tarefas existentes:");
        for (Tarefa tarefa : tarefas) {
            System.out.println("ID: " + tarefa.getId() + ", Descricao: " + tarefa.getDescricao() + ", Status: " + tarefa.getStatus());
        }
        System.out.println();
    }

    private void visualizarTarefa(Scanner scanner) {
        System.out.println("Qual ID da tarefa deseja visualizar?");
        int id = scanner.nextInt();
        Tarefa tarefa = tarefaRepository.encontrarPorId(id);
        if (tarefa != null) {
            System.out.println("Tarefa encontrada: " + tarefa.getDescricao() + " - " + tarefa.getStatus());
        } else {
            System.out.println("Tarefa nao encontrada.");
        }
    }

    private void inserirTarefa(Scanner scanner) {
        System.out.println("Informe a descricao da tarefa:");
        scanner.nextLine(); // Consumir a nova linha
        String descricao = scanner.nextLine();

        System.out.println("Informe o status da tarefa:");
        String status = scanner.nextLine();

        Tarefa novaTarefa = new Tarefa(descricao, status);
        tarefaRepository.inserir(novaTarefa);
        System.out.println("Tarefa inserida com sucesso.");
    }

    private void editarTarefa(Scanner scanner) {
        System.out.println("Informe o ID da tarefa que deseja editar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Tarefa tarefa = tarefaRepository.encontrarPorId(id);
        if (tarefa != null) {
            System.out.println("Informe a nova descricao da tarefa:");
            String descricao = scanner.nextLine();
            System.out.println("Informe o novo status da tarefa:");
            String status = scanner.nextLine();

            tarefa.setDescricao(descricao);
            tarefa.setStatus(status);
            tarefaRepository.atualizar(tarefa);
            System.out.println("Tarefa atualizada com sucesso.");
        } else {
            System.out.println("Tarefa nao localizada.");
        }
    }

    private void excluirTarefa(Scanner scanner) {
        System.out.println("Informe o ID da tarefa que deseja excluir:");
        int id = scanner.nextInt();

        Tarefa tarefa = tarefaRepository.encontrarPorId(id);
        if (tarefa != null) {
            tarefaRepository.excluir(id);
            System.out.println("Tarefa excluida com sucesso.");
        } else {
            System.out.println("Tarefa nao encontrada.");
        }
    }
}
