package com.mycompany.arbolgenealogicoproject;

public class Nodo {
    int valor;
    String parentezco;
    String nombre;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(int valor, String parentezco, String nombre) {
        this.valor = valor;
        this.parentezco = parentezco;
        this.nombre = nombre;
        this.izquierda = null;
        this.derecha = null;
    }
}
