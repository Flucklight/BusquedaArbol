import utility.tree.Arbol;
import utility.tree.Nodo;

import java.io.IOException;

public class Main {
    private static Arbol a;

    public static void main(String[] args) throws IOException {
        a = new Arbol();
        BusquedaAltura();
        a.reinicio();
        a.generar(0);

    }

    public static void BusquedaAltura() {
        System.out.println(" ------------- Busqueda por Altura ------------- ");
        a.mostrarPuntero();
        while (a.getApuntador().getPuntero().getNombre() != 'R') {
            if (!a.getApuntador().getPuntero().getHijos().isEmpty()) {
                for (Nodo n : a.getApuntador().getPuntero().getHijos()) {
                    if (n.getPonderacion() != 0) {
                        n.setPonderacion(0);
                        a.accederNodo(n);
                        break;
                    } else if (n.equals(a.getApuntador().getPuntero().getHijos().get(a.getApuntador().getPuntero().getHijos().size() - 1))) {
                        a.retrocederNodo();
                    }
                }
            } else {
                a.retrocederNodo();
            }
            a.mostrarPuntero();
        }
    }

    public static void BusquedaAnchura() {
        System.out.println(" ------------- Busqueda por Anchura ------------- ");
        a.mostrarPuntero();
        while (a.getApuntador().getPuntero().getNombre() != 'R') {
            for (Nodo n : a.getApuntador().getPuntero().getHijos()) {
                if (n.getNombre() == 'R') {
                    a.getApuntador().setPuntero(n);
                }
            }
            for (Nodo n : a.getApuntador().getPuntero().getHijos()) {

            }
        }
    }
}
