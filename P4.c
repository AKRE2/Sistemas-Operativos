#include <stdio.h>
#include <stdlib.h>

// Variables Globales.
int op; char menu;

int main () {
    printf("\n\tSIMULADOR DE PROCESOS Y MEMORIA\n\n");
    do
    {
        printf("1. Crear Proceso Nuevo.\n2. Ver estado actual del sistema. \
        \n3. Imprimir cola de procesos.\n4. Ver proceso actual.\n5. Ejecutar proceso actual. \
        \n6. Pasar al proceso siguiente.\n7. Matar proceso actual.\n8. Salir del programa.");
        printf("\nSelecciona una opcion: ");
        fflush(stdin);
        scanf("%d",&op);
        switch (op)
        {
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
            return 0;   
            break;
        }
        printf("\n\nPara volver a ver el menu principal presiona Espacio+Enter, si no presiona Enter para salir\n\n");
	    fflush(stdin);
        scanf("%c", &menu);
    } while(menu==' ');
    return 0;
}