import java.io.*;
import java.util.Scanner;
import javax.swing.text.AbstractDocument.BranchElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class P5 {
    int id_ = 1;
    int tamDisponible = 2048;
    int tamLocalidades = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int op; char menu;

        // Variables para los procesos.
        int[] localidades = new int[2048];
        ArrayList<Integer> id_proceso = new ArrayList<Integer>();
        ArrayList<String> nombre_proceso = new ArrayList<String>();
        P5 proceso = new P5();
        
        do {
            System.out.println("\t\nSIMULADOR DE PROCESOS Y MEMORIA");
            System.out.println("\n1. Crear Proceso Nuevo.\n2. Ver estado de los procesos." +
            "\n3. Ver estado de la memoria.\n4. Imprimir cola de procesos.\n5. Ver proceso actual."+
            "\n6. Pasar al proceso siguiente.\n7. Matar proceso actual.\n8. Desfragmentar memoria."+ 
            "\n9. Salir del programa.\n");
            
            op = sc.nextInt();
            System.out.println();
            switch (op){
                case 1:
                    proceso.crearProceso(localidades,id_proceso,nombre_proceso);
                    proceso.actualizarEspacio(localidades);
                break;

                case 2:
                    proceso.estadoProcess(localidades, id_proceso,nombre_proceso);
                break;
                    
                case 3:
                    
                break;

                case 4:
                    proceso.colaProcess(localidades, id_proceso,nombre_proceso);
                break;

                case 5:
                    proceso.verProcessActual(localidades, id_proceso,nombre_proceso);
                break;

                case 6:

                break;

                case 7:
                    proceso.matarProcess(localidades, id_proceso,nombre_proceso);
                break;

                case 8:

                break;

                case 9:
                    System.exit(0);
                break;
            }
            System.out.print("Deseas Salir?\nS - Si\nN -- No\n -----: ");
            menu = sc.next().charAt(0);
        } while (menu == 'N');   
        sc.close();
    }

    public void crearProceso(int[] localidades,ArrayList<Integer> id, ArrayList<String> nombre){
        String nombreDelProceso;
        Scanner sc = new Scanner(System.in); 

        tamLocalidades = tamLocalidad();    // Variable aleatoria de localidades
        System.out.println("Tamaño asignado al proceso: "+tamLocalidades);
        // Verificar el espacio disponible en la memoria.
        if (tamDisponible != 0) {
            // Hay espacio disponible. 
            System.out.println("Localidades Disponibles: "+tamDisponible+"\n");
            // para que no exceda el tamaño de las localidades con el disponible.
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
            System.out.println("Localidades disponibles: "+tamDisponible+
            "\nNo hay espacio disponible, se requiere matar otros procesos.\n");
        } 
    
    }

    public void actualizarEspacio(int[] localidades){
        int n = 0;      // Variable auxiliar para contar localidades disponibles.
        
        for (int i = 0; i < localidades.length; i++) {
            if (localidades[i] == 0) {
                n++;
            }
        }

        tamDisponible = n;
        System.out.println("Localidades Disponibles Actualizadas: "+tamDisponible+"\n");
    }

    public void estadoProcess (int[] localidades,ArrayList<Integer> id, ArrayList<String> nombre){
        System.out.println("Localidad \tID \tProceso");
        for (int i = 0; i < 800; i++) {
            if(localidades[i] == 0){
                break;
            }
            System.out.print(i);
            System.out.print("\t\t");
            System.out.print(localidades[i]);
            System.out.print("\t");
            System.out.print(nombre.get(localidades[i]-1));
            System.out.println();
        }
        System.out.println("Localidades Disponibles: "+tamDisponible+"\n");
    }

    public void llenarLocalidades(int[] localidades,int id, int num){
        int indice = 0;
        
        for (int i = 0; i < localidades.length; i++) {
            if (localidades[i] == 0) {
                indice = i;
                break;
            }
        }
        System.out.println("Index: "+indice);

        for (int j = indice; j < num; j++) {
            localidades[j] = id;
        }
    }

    public int tamLocalidad() {
        Random rand = new Random();
        int[] tam = {64, 128, 256, 512};
        int num = rand.nextInt(tam.length);
        num = tam[num];
        //System.out.println("Tamaño asignado al proceso: "+num);
        return num;
    }
    
    public void verProcessActual(int[] localidades,ArrayList<Integer> id, ArrayList<String> nombre){
        int tamLocalidad = tamLocalidad();
        System.out.println("Nombre del proceso: "+nombre);
        System.out.println("ID: "+id);
        System.out.println("Instrucciones totales:"+tamLocalidad);
        System.out.println("Dirección de memoria asignada:"+localidades);
        System.out.println();
    }
    
    public void colaProcess(int[] localidades,ArrayList<Integer> id, ArrayList<String> nombre){
         
        for (int i = 0; i < id.size(); i++) {
                System.out.println("nombre: "+nombre.get(i));
                System.out.println("id: "+id.get(i));
                System.out.println("número de instrucciones: "+localidades[i]);
            }
        System.out.println("tam "+id.size());
    }
    
    public void matarProcess(int[] localidades,ArrayList<Integer> id, ArrayList<String> nombre){
        int tam = id.size();
        for (int i = 0; i < localidades.length; i++) {
            if(tam==localidades[i]){
                localidades[i]=0;
            }
            
        }
    }
}