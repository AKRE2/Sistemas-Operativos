import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class p4 {
    int id_ = 1;
    int tamDisponible,tamLocalidades;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int op; char menu; int len = 0;

        // Variables para los procesos.
        int[] localidades = new int[2048];
        ArrayList<Integer> id_proceso = new ArrayList<Integer>();
        ArrayList<String> nombre_proceso = new ArrayList<String>();
        p4 proceso = new p4();
        
        do {
            System.out.println("\t\nSIMULADOR DE PROCESOS Y MEMORIA");
            System.out.println("\n1. Crear Proceso Nuevo.\n2. Ver estado actual del sistema." +
            "\n3. Imprimir cola de procesos.\n4. Ver proceso actual.\n5. Ejecutar proceso actual." + 
            "\n6. Pasar al proceso siguiente.\n7. Matar proceso actual.\n8. Salir del programa.\n");
            
            op = sc.nextInt();
            System.out.println();
            switch (op){
                case 1:
                    len = proceso.crearProceso(localidades,id_proceso,nombre_proceso);
                break;

                case 2:
                    proceso.estadoMemoria(localidades, id_proceso,nombre_proceso);
                break;

                case 3:

                break;

                case 4:

                break;

                case 5:

                break;

                case 6:

                break;

                case 7:

                break;

                case 8:
                System.exit(0);
                break;
            }
            System.out.print("Deseas Salir?\nS - Si\nN -- No\n -----: ");
            menu = sc.next().charAt(0);
        } while (menu == 'N');   
    }

    public int crearProceso(int[] localidades,ArrayList<Integer> id, ArrayList<String> nombre){
        String nombreDelProceso;
        Scanner sc = new Scanner(System.in);
       
        tamLocalidades = tamLocalidad();
        tamDisponible = comprobarEspacio(localidades);
        tamDisponible = tamDisponible - tamLocalidades;

        if (tamDisponible != 0) {

            System.out.println("Localidades Disponibles: "+tamDisponible+"\n");

            if (tamLocalidades <= tamDisponible) {
                System.out.println("Escribe el nombre del proceso:  ");
                nombreDelProceso = sc.nextLine();
                System.out.println();
                nombre.add(nombreDelProceso);
                
    
                id.add(id_);

                llenarLocalidades(localidades, id_, tamLocalidades);
                
            
                id_++; 
            } else {
                System.out.println("El tamaño excede a las localidades disponibles.");
            } 
        } else {
            System.out.println("Localidades disponibles: "+tamDisponible+"\nNo hay espacio disponible, se requiere matar otros procesos.\n");
        } 
        
        
        System.out.println("Localidades Disponibles: "+tamDisponible+"\n");

        return tamDisponible;
    }

    public int comprobarEspacio(int[] localidades){
        int n = 0;
        for (int i = 0; i < localidades.length; i++) {
            if (localidades[i] == 0) {
                n++;
            }
        }
        return n;
    }

    public void estadoMemoria (int[] localidades,ArrayList<Integer> id, ArrayList<String> nombre){
        System.out.println("Localidad \tID \tProceso");
        for (int i = 0; i < 1400; i++) {
            System.out.print(i);
            System.out.print("\t\t");
            System.out.print(localidades[i]);
            System.out.println();
            /*
            System.out.print("\t\t");
            System.out.print(id.get(localidades[i]-1));
            System.out.print("\t");
            System.out.print(nombre.get(localidades[i]-1));
            System.out.println();
            */
           
        }
        System.out.println("Localidades Disponibles: "+tamDisponible+"\n");
    }

    public void llenarLocalidades(int[] localidades,int id, int num){
        int indice = 0;
       
        for (int i = 0; i < localidades.length; i++) {
            if (localidades[i] == 0) {
                indice = Arrays.asList(localidades).indexOf(i);
                break;
            }
        }

        if (indice == -1) {
            for (int j = 0; j < num; j++) {
                localidades[j] = id;
            }
        } else {
            for (int j = indice; j < num; j++) {
                localidades[j] = id;
            }
        }

    }

    public int tamLocalidad() {
        Random rand = new Random();
        int[] tam = {64, 128, 256, 512};
        int num = rand.nextInt(tam.length);
        num = tam[num];
        System.out.println("Tamaño asignado al proceso: "+num);
        return num;
    }
}

