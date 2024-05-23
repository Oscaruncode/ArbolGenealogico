
package com.mycompany.arbolgenealogicoproject;

public class ArbolGenealogico {

    private Nodo raiz;

    public ArbolGenealogico() {
        this.raiz = null;
    }

    public void insertar(int valor, String parentesco, String nombre) {
        raiz = insertarRecursivo(raiz, valor, parentesco, nombre);
    }

    private Nodo insertarRecursivo(Nodo nodo, int valor, String parentesco, String nombre) {
        if (nodo == null) {
            return new Nodo(valor, parentesco, nombre);
        }

        if (valor < nodo.valor) {
            nodo.izquierda = insertarRecursivo(nodo.izquierda, valor, parentesco, nombre);
        } else if (valor > nodo.valor) {
            nodo.derecha = insertarRecursivo(nodo.derecha, valor, parentesco, nombre);
        }

        return nodo;
    }

    public void imprimirPreOrden() {
        System.out.println("Impresion preorden:");
        imprimirPreOrdenRecursivo(raiz);
        System.out.println();
    }

   private void imprimirPreOrdenRecursivo(Nodo nodo) {
    if (nodo != null) {
        String parentezco = obtenerParentezco(nodo.parentezco, nodo.nombre);
        System.out.println("Numero: " + nodo.valor + ", Nombre: " + nodo.nombre + ", Parentezco: " + parentezco);
        imprimirPreOrdenRecursivo(nodo.izquierda);
        imprimirPreOrdenRecursivo(nodo.derecha);
    }
}

    public void imprimirPostOrden() {
        System.out.println("Impresion postorden:");
        imprimirPostOrdenRecursivo(raiz);
        System.out.println();
    }

    private void imprimirPostOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            imprimirPostOrdenRecursivo(nodo.izquierda);
            imprimirPostOrdenRecursivo(nodo.derecha);
            String parentezco = obtenerParentezco(nodo.parentezco, nodo.nombre);
            System.out.println("Numero: " + nodo.valor + ", Nombre: " + nodo.nombre + ", Parentezco: " + parentezco);
        }
    }

    public void imprimirEnOrden() {
        System.out.println("Impresion en orden:");
        imprimirEnOrdenRecursivo(raiz);
        System.out.println();
    }

    private void imprimirEnOrdenRecursivo(Nodo nodo) {
    if (nodo != null) {
        imprimirEnOrdenRecursivo(nodo.izquierda);
        String parentezco = obtenerParentezco(nodo.parentezco, nodo.nombre);
        System.out.println("Numero: " + nodo.valor + ", Nombre: " + nodo.nombre + ", Parentezco: " + parentezco);
        imprimirEnOrdenRecursivo(nodo.derecha);
    }
}

    private String obtenerParentezco(String parentezco, String nombre) {
        switch (parentezco) {
            case "Hijo":
            case "Madre":
            case "Abuela materna":
            case "Abuelo materno":
            case "Abuela paterna":
            case "Abuelo paterno":
            case "Bisabuelo materno":
            case "Bisabuela materna":
            case "Bisabuelo paterno":
            case "Bisabuela paterna":
                return parentezco;
            default:
                return "Desconocido";
        }
    }
}