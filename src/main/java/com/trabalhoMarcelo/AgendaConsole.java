package com.trabalhoMarcelo;

import java.util.Scanner;

public class AgendaConsole {
    private Agenda agenda = new Agenda();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        while (true) {
            System.out.println("\n1. Adicionar Contato");
            System.out.println("2. Listar Contatos");
            System.out.println("3. Buscar Contato");
            System.out.println("4. Atualizar Contato");
            System.out.println("5. Remover Contato");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> adicionarContato();
                case 2 -> listarContatos();
                case 3 -> buscarContato();
                case 4 -> atualizarContato();
                case 5 -> removerContato();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void adicionarContato() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        agenda.adicionarContato(new Contato(nome, telefone, email));
        System.out.println("Contato adicionado!");
    }

    private void listarContatos() {
        System.out.println("\nLista de Contatos:");
        for (Contato contato : agenda.listarContatos()) {
            System.out.println(contato);
        }
    }

    private void buscarContato() {
        System.out.print("Nome do contato: ");
        String nome = scanner.nextLine();
        Contato contato = agenda.buscarContato(nome);
        if (contato != null) {
            System.out.println(contato);
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private void atualizarContato() {
        System.out.print("Nome do contato: ");
        String nome = scanner.nextLine();
        System.out.print("Novo Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Novo Email: ");
        String email = scanner.nextLine();
        if (agenda.atualizarContato(nome, telefone, email)) {
            System.out.println("Contato atualizado!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private void removerContato() {
        System.out.print("Nome do contato: ");
        String nome = scanner.nextLine();
        if (agenda.removerContato(nome)) {
            System.out.println("Contato removido!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
}
