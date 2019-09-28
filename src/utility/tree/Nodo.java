package utility.tree;

import java.util.LinkedList;

public class Nodo {
    private char nombre;
    private Nodo padre;
    private int ponderacion;
    private LinkedList<Nodo> hijos;

    public Nodo(char nombre, int ponderacion, Nodo padre) {
        this.nombre = nombre;
        this.ponderacion = ponderacion;
        this.padre = padre;
        this.hijos = new LinkedList<>();
    }

    public Nodo(char nombre) {
        this.nombre = nombre;
        this.ponderacion = 0;
        this.padre = null;
        this.hijos = new LinkedList<>();
    }

    public void mostrarHijos() {
        for (Nodo n : this.hijos) {
            System.out.println(n.getNombre());
        }
    }

    public Nodo getPadre() {
        return padre;
    }

    public LinkedList<Nodo> getHijos() {
        return hijos;
    }

    public char getNombre() {
        return nombre;
    }

    public int getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(int ponderacion) {
        this.ponderacion = ponderacion;
    }
}
