package com.trabalhoMarcelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaSwing extends JFrame {
    private Agenda agenda = new Agenda();
    private JTextArea textArea;

    public AgendaSwing() {
        setTitle("Agenda de Contatos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        JTextField nomeField = new JTextField();
        JTextField telefoneField = new JTextField();
        JTextField emailField = new JTextField();

        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(e -> {
            String nome = nomeField.getText();
            String telefone = telefoneField.getText();
            String email = emailField.getText();
            agenda.adicionarContato(new Contato(nome, telefone, email));
            atualizarLista();
        });

        JButton listButton = new JButton("Listar Contatos");
        listButton.addActionListener(e -> atualizarLista());

        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Telefone:"));
        panel.add(telefoneField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(addButton);
        panel.add(listButton);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void atualizarLista() {
        StringBuilder listaContatos = new StringBuilder();
        for (Contato contato : agenda.listarContatos()) {
            listaContatos.append(contato).append("\n");
        }
        textArea.setText(listaContatos.toString());
    }
}
