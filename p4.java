import java.io.*;
import java.util.Scanner;
import java.utils.ArrayList;

public class p4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int op; char menu;

        // Variables para los procesos.
        int[] localidades = new int[2048];
        ArrayList<Integer> id_proceso = new ArrayList<Integer>();
        ArrayList<String> nombre_proceso = new ArrayList<String>();
        
        do {
            System.out.println("\t\nSIMULADOR DE PROCESOS Y MEMORIA");
            System.out.println("\n1. Crear Proceso Nuevo.\n2. Ver estado actual del sistema." +
            "\n3. Imprimir cola de procesos.\n4. Ver proceso actual.\n5. Ejecutar proceso actual." + 
            "\n6. Pasar al proceso siguiente.\n7. Matar proceso actual.\n8. Salir del programa.\n");
            
            op = sc.nextInt();
            switch (op) {
                case 1:
                
                break;

                case 2:

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
}

