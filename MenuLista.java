/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nodos;

import java.util.Scanner;


class MenuLista {
    private ListaEnlazada lista;
    private java.util.Scanner sc;
   
    
    public MenuLista() {
        lista = new ListaEnlazada();
         sc = new java.util.Scanner(System.in);
    }
    
    public void ejecutar() {
        int opcion;
        
        do {
            System.out.println("1. Insertar al inicio");
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

