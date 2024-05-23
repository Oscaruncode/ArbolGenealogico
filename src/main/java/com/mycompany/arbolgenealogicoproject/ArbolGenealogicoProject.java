package com.mycompany.arbolgenealogicoproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.OutputStream;
import java.io.PrintStream;

public class ArbolGenealogicoProject {

    public static void main(String[] args) {
        ArbolGenealogico arbol = new ArbolGenealogico();
        
        // Insertar nombres
        arbol.insertar(30, "Hijo", "Jhojan");
        arbol.insertar(20, "Madre", "Sandra");
        arbol.insertar(40, "Padre", "Pedro");
        arbol.insertar(10, "Abuela materna", "Ana");
        arbol.insertar(25, "Abuelo materno", "Carlos");
        arbol.insertar(35, "Abuela paterna", "Isabel");
        arbol.insertar(45, "Abuelo paterno", "Jorge");
        arbol.insertar(15, "Bisabuelo materno", "Manuel");
        arbol.insertar(5, "Bisabuela materna", "Carmen");
        arbol.insertar(17, "Bisabuelo paterno", "Antonio");
        arbol.insertar(12, "Bisabuela paterna", "Rosa");

        // Crear la interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            new ArbolGenealogicoUI(arbol);
        });
    }
}

class ArbolGenealogicoUI extends JFrame {

    private ArbolGenealogico arbol;

    public ArbolGenealogicoUI(ArbolGenealogico arbol) {
        this.arbol = arbol;
        setTitle("Árbol Genealógico");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initUI();
        
        setVisible(true);
    }

    private void initUI() {
        // Crear panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        
        // Etiqueta de instrucciones
        JLabel label = new JLabel("Seleccione el orden de impresión:");
        panel.add(label);

        // Botones de opciones
        JButton preOrdenButton = new JButton("Pre orden");
        JButton postOrdenButton = new JButton("Post orden");
        JButton enOrdenButton = new JButton("En orden");

        panel.add(preOrdenButton);
        panel.add(postOrdenButton);
        panel.add(enOrdenButton);
        
        // Agregar ActionListener a los botones
        preOrdenButton.addActionListener(e -> mostrarResultado("Pre orden", arbol::imprimirPreOrden));
        postOrdenButton.addActionListener(e -> mostrarResultado("Post orden", arbol::imprimirPostOrden));
        enOrdenButton.addActionListener(e -> mostrarResultado("En orden", arbol::imprimirEnOrden));
        
        // Agregar panel a la ventana
        add(panel, BorderLayout.CENTER);
    }
    
    private void mostrarResultado(String orden, Runnable metodoImpresion) {
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        // Redirigir la salida del sistema a JTextArea
        PrintStream printStream = new PrintStream(new TextAreaOutputStream(textArea));
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        metodoImpresion.run();

        // Restaurar la salida del sistema
        System.setOut(originalOut);
        
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Impresión " + orden, JOptionPane.INFORMATION_MESSAGE);
    }
}

class TextAreaOutputStream extends OutputStream {
    private final JTextArea textArea;

    public TextAreaOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) {
        textArea.append(String.valueOf((char) b));
    }

    @Override
    public void write(byte[] b, int off, int len) {
        textArea.append(new String(b, off, len));
    }
}
