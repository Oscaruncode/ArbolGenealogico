package com.mycompany.arbolgenealogicoproject;

import javax.swing.*;

public class ArbolGenealogicoProject {

    public static void main(String[] args) {
        ArbolGenealogico arbol = new ArbolGenealogico();
        
        // Insertar nombres
        arbol.insertar(30, "Hija", "Danna");
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
        arbol.insertar(50, "Tatarabuelo materno", "Luis");
        arbol.insertar(55, "Tatarabuela materna", "Lucia");
        arbol.insertar(60, "Tataratatarabuelo materno", "Jose");
        arbol.insertar(65, "Tataratatarabuela materna", "Maria");

        // Crear la interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            new ArbolGenealogicoUI(arbol);
        });
    }
}

