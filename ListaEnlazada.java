package nodos;

class ListaEnlazada {
    private Nodo cabeza;
    
    public ListaEnlazada() {
        this.cabeza = null;
    }
    
    public void insertarInicio(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }
    
    public void eliminarInicio() {
        if (cabeza != null) {
            cabeza = cabeza.siguiente;
        }
    }
    
    public void insertarFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
    }
    
    public void eliminarFinal() {
        if (cabeza == null) return;
        if (cabeza.siguiente == null) {
            cabeza = null;
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = null;
    }
    
    public void eliminarMitad() {
        if (cabeza == null) return;
        if (cabeza.siguiente == null) {
            cabeza = null;
            return;
        }
        
        int tamano = 0;
        Nodo temp = cabeza;
        while (temp != null) {
            tamano++;
            temp = temp.siguiente;
        }
        
        int posicion = tamano / 2;
        if (posicion == 0) {
            cabeza = cabeza.siguiente;
            return;
        }
        
        Nodo actual = cabeza;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.siguiente;
        }
        actual.siguiente = actual.siguiente.siguiente;
    }
    
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("Lista vacia");
            return;
        }
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
