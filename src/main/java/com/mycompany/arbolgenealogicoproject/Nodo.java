/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolgenealogicoproject;

/**
 *
 * @author elger
 */
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
