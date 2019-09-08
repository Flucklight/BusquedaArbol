package utility.tree;

import java.io.*;

public class Arbol {
    private Raiz raiz;
    private Apuntador apuntador;
    private File archivoFuente;
    private Integer[][] matriz;
    private BufferedReader cargar;

    public Arbol() throws IOException {
        this.raiz = new Raiz('A');
        this.apuntador = new Apuntador(this.raiz);
        this.matriz = new Integer[18][18];
        this.archivoFuente = new File(System.getProperty("user.dir")
                + "/src/items/archivoFuente.tree");
        this.cargar();
        this.generar(0);
        this.mostrarArbol();
    }

    private void cargar() throws IOException {
        this.cargar = new BufferedReader(new FileReader(this.archivoFuente));
        String s;
        String[] tmp;
        int i = 0;
        while ((s = cargar.readLine()) != null) {
            tmp = s.split(",");
            for (int j = 0; j < tmp.length; j++) {
                this.matriz[i][j] = Integer.parseInt(tmp[j]);
            }
            i++;
        }
    }

    public void generar(int i) {
        Nodo aux;
        for (int j = 0; j < 18; j++) {
            if (this.matriz[i][j] != 0) {
                aux = new Nodo((char)(j + 65), this.matriz[i][j], this.apuntador.getPuntero());
                this.apuntador.getPuntero().getHijos().add(aux);
                this.apuntador.setPuntero(aux);
                generar(((int)this.apuntador.getPuntero().getNombre()) - 65);
            }
        }
        if (!this.apuntador.getPuntero().equals(this.raiz)) {
            this.apuntador.setPuntero(this.apuntador.getPuntero().getPadre());
        }
    }

    public void reinicio() {
        this.raiz = new Raiz('A');
        this.apuntador = new Apuntador(this.raiz);
    }

    //Navegacion

    public void accederNodo(Nodo n) {
        this.apuntador.setPuntero(n);
    }

    public void retrocederNodo() {
        if (this.apuntador.getPuntero().getPadre() != null) {
            this.apuntador.setPuntero(this.apuntador.getPuntero().getPadre());
        }
    }

    public void mostrarPuntero() {
        System.out.println("Puntero -------------> " + this.apuntador.getRuta());
    }

    public void mostrarArbol() {
        this.raiz.mostrarArbol();
    }

    public Apuntador getApuntador() {
        return apuntador;
    }
}
