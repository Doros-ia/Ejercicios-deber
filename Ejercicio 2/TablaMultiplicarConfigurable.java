import java.util.Scanner;
 
public class TablaMultiplicarConfigurable {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int tablaInicial, tablaFinal, multiplicadorFinal;
        int tabla, multiplicador, resultado;
 
        // Se leen los límites de las tablas hasta que sean correctos.
        System.out.print("Ingrese la tabla inicial: ");
        tablaInicial = entrada.nextInt();
        System.out.print("Ingrese la tabla final: ");
        tablaFinal = entrada.nextInt();
 
        while (tablaInicial > tablaFinal) {
            System.out.println("Error: la tabla inicial no puede ser mayor que la tabla final.");
            System.out.print("Ingrese nuevamente la tabla inicial: ");
            tablaInicial = entrada.nextInt();
            System.out.print("Ingrese nuevamente la tabla final: ");
            tablaFinal = entrada.nextInt();
        }
 
        // El usuario también decide hasta qué multiplicador se genera.
        System.out.print("Ingrese el multiplicador final (mayor que 0): ");
        multiplicadorFinal = entrada.nextInt();
        while (multiplicadorFinal <= 0) {
            System.out.println("Error: el multiplicador final debe ser mayor que 0.");
            System.out.print("Ingrese nuevamente el multiplicador final: ");
            multiplicadorFinal = entrada.nextInt();
        }
 
        // El primer for cambia de tabla y el segundo calcula sus productos.
        for (tabla = tablaInicial; tabla <= tablaFinal; tabla++) {
            System.out.println("\nTABLA DEL " + tabla);
            for (multiplicador = 1; multiplicador <= multiplicadorFinal; multiplicador++) {
                resultado = tabla * multiplicador;
                System.out.println(tabla + " x " + multiplicador + " = " + resultado);
            }
        }
 
        entrada.close();
    }
}