import utility.tree.Arbol;
import utility.tree.Nodo;

import java.io.IOException;
import java.util.LinkedList;

public class Main {
    private static Arbol a;

    public static void main(String[] args) throws IOException {
        a = new Arbol();
        BusquedaAltura();
        a.goToRaiz();
        BusquedaAnchura();
    }

    private static void BusquedaAltura() {
        System.out.println(" ------------- Busqueda por Altura ------------- ");
        LinkedList<Nodo> visitados = new LinkedList<>();
        a.mostrarPuntero();
        while (a.getApuntador().getPuntero().getNombre() != 'R') {
            if (!a.getApuntador().getPuntero().getHijos().isEmpty()){
                for (Nodo n : a.getApuntador().getPuntero().getHijos()) {
                    if (!visitados.contains(n)) {
                        visitados.add(n);
                        a.getApuntador().setPuntero(n);
                        break;
                    } else if (n.equals(a.getApuntador().getPuntero().getHijos().getLast())) {
                        a.retrocederNodo();
                    }
                }
            } else {
                a.retrocederNodo();
            }
            a.mostrarPuntero();
        }
    }

    private static void BusquedaAnchura() {
        System.out.println(" ------------- Busqueda por Anchura ------------- ");
        LinkedList<Nodo> visitados = new LinkedList<>();
        LinkedList<Nodo> visitar = new LinkedList<>();
        LinkedList<Nodo> tmp;
        visitar.add(a.getRaiz());
        while (a.getApuntador().getPuntero().getNombre() != 'R') {
            tmp = (LinkedList<Nodo>) visitar.clone();
            for (Nodo n : tmp) {
                visitar.remove(n);
                visitados.add(n);
                a.getApuntador().setPuntero(n);
                a.mostrarPuntero();
                if (a.getApuntador().getPuntero().getNombre() == 'R') {
                    break;
                } else if (!a.getApuntador().getPuntero().getHijos().isEmpty()) {
                    for (Nodo b : a.getApuntador().getPuntero().getHijos()) {
                        if (!visitados.contains(b) && !visitar.contains(b)) {
                            visitar.add(b);
                        }
                    }
                }
            }
        }
    }

    private static void BusquedaPonderada() {

    }
}
