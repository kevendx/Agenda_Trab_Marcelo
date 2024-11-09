package com.trabalhoMarcelo;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String modo = JOptionPane.showInputDialog("Escolha o modo: Console ou Swing");
        if ("Console".equalsIgnoreCase(modo)) {
            new AgendaConsole().iniciar();
        } else if ("Swing".equalsIgnoreCase(modo)) {
            SwingUtilities.invokeLater(() -> new AgendaSwing().setVisible(true));
        } else {
            System.out.println("Modo inválido.");
        }
    }
}
