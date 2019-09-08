package utility.tree;


public class Raiz extends Nodo {

    public Raiz(char nombre) {
        super(nombre);
    }

    protected void mostrarArbol() {
        mostrarArbolProceso(this, 0);
    }

    private void mostrarArbolProceso(Nodo nodo, int spacing) {
        for (int i = 0; i < spacing; ++i) {
            System.out.print("\t");
        }
        System.out.println(nodo.getNombre());
        if (nodo.getHijos() != null && !nodo.getHijos().isEmpty()) {
            for (Nodo hijo : nodo.getHijos()) {
                mostrarArbolProceso(hijo, spacing + 1);
            }
        }
    }
}
