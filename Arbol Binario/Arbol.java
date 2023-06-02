
// Clase Arbol
class Arbol {

    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        arbol.insertar("B");
        arbol.insertar("A");
        arbol.insertar("D");
        arbol.insertar("C");
        arbol.insertar("E");

        System.out.println("Árbol vacío: " + arbol.vacio());

        Nodo nodoEncontrado = arbol.buscarNodo("D");
        if (nodoEncontrado != null) {
            System.out.println("Nodo encontrado: " + nodoEncontrado.nombre);
        } else {
            System.out.println("Nodo no encontrado");
        }

        arbol.imprimirArbol();
        }

    Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public boolean vacio() {
        return raiz == null;
    }

    public Nodo buscarNodo(String nombre) {
        return buscarNodoAux(raiz, nombre);
    }

    private Nodo buscarNodoAux(Nodo nodo, String nombre) {
        if (nodo == null || nodo.nombre.equals(nombre)) {
            return nodo;
        }

        if (nombre.compareTo(nodo.nombre) < 0) {
            return buscarNodoAux(nodo.izquierdo, nombre);
        } else {
            return buscarNodoAux(nodo.derecho, nombre);
        }
    }

    public void insertar(String nombre) {
        raiz = insertarAux(raiz, nombre);
    }

    private Nodo insertarAux(Nodo nodo, String nombre) {
        if (nodo == null) {
            return new Nodo(nombre);
        }

        if (nombre.compareTo(nodo.nombre) < 0) {
            nodo.izquierdo = insertarAux(nodo.izquierdo, nombre);
        } else {
            nodo.derecho = insertarAux(nodo.derecho, nombre);
        }

        return nodo;
    }

    public void imprimirArbol() {
        imprimirArbolAux(raiz);
    }

    private void imprimirArbolAux(Nodo nodo) {
        if (nodo != null) {
            imprimirArbolAux(nodo.izquierdo);
            System.out.println(nodo.nombre);
            imprimirArbolAux(nodo.derecho);
        }
    }
}

