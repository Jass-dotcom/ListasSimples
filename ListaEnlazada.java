package nodos;

import java.util.Scanner;

class Nodo {
    int dato;
    Nodo siguiente;
    
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

public class ListaEnlazada {
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
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();
        int opcion;
        
        do {
            System.out.println("\n1. Insertar al inicio");
            System.out.println("2. Eliminar del inicio");
            System.out.println("3. Insertar al final");
            System.out.println("4. Eliminar del final");
            System.out.println("5. Eliminar del medio");
            System.out.println("6. Mostrar lista");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");
            
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.print("Dato: ");
                    int dato1 = sc.nextInt();
                    lista.insertarInicio(dato1);
                    break;
                case 2:
                    lista.eliminarInicio();
                    break;
                case 3:
                    System.out.print("Dato: ");
                    int dato3 = sc.nextInt();
                    lista.insertarFinal(dato3);
                    break;
                case 4:
                    lista.eliminarFinal();
                    break;
                case 5:
                    lista.eliminarMitad();
                    break;
                case 6:
                    lista.mostrar();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 7);
        
        sc.close();
    }
}