package com.trabalhoMarcelo;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos = new ArrayList<>();

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public List<Contato> listarContatos() {
        return contatos;
    }

    public Contato buscarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    public boolean atualizarContato(String nome, String novoTelefone, String novoEmail) {
        Contato contato = buscarContato(nome);
        if (contato != null) {
            contato.setTelefone(novoTelefone);
            contato.setEmail(novoEmail);
            return true;
        }
        return false;
    }

    public boolean removerContato(String nome) {
        Contato contato = buscarContato(nome);
        if (contato != null) {
            contatos.remove(contato);
            return true;
        }
        return false;
    }
}
