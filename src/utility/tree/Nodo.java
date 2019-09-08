package utility.tree;

import java.util.ArrayList;

public class Nodo {
    private char nombre;
    private Nodo padre;
    private int ponderacion;
    private ArrayList<Nodo> hijos;

    public Nodo(char nombre, int ponderacion, Nodo padre) {
        this.nombre = nombre;
        this.ponderacion = ponderacion;
        this.padre = padre;
        this.hijos = new ArrayList<>();
    }

    public Nodo(char nombre) {
        this.nombre = nombre;
        this.ponderacion = 0;
        this.padre = null;
        this.hijos = new ArrayList<>();
    }

    public void mostrarHijos() {
        for (Nodo n : this.getHijos()) {
            System.out.println(n.getNombre());
        }
    }

    public Nodo getPadre() {
        return padre;
    }

    public ArrayList<Nodo> getHijos() {
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
