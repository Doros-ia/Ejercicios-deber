import java.util.Scanner;

public class SerieSumaPares {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int n, numero, contador = 0, suma = 0;
        double promedio = 0;
 
        System.out.print("Ingrese un número entero positivo N: ");
        n = entrada.nextInt();
 
        // Se valida que N sea positivo.
        while (n <= 0) {
            System.out.println("Error: N debe ser mayor que cero.");
            System.out.print("Ingrese nuevamente N: ");
            n = entrada.nextInt();
        }
 
        System.out.println("Serie de números pares:");
        // El ciclo empieza en 2 y avanza de dos en dos.
        for (numero = 2; numero <= n; numero += 2) {
            System.out.print(numero + " ");
            contador++;
            suma += numero;
        }
        System.out.println();
 
        if (contador > 0) {
            promedio = (double) suma / contador;
            System.out.println("Cantidad de pares: " + contador);
            System.out.println("Suma: " + suma);
            System.out.printf("Promedio: %.2f%n", promedio);
        } else {
            System.out.println("No existen números pares entre 2 y " + n + ".");
            System.out.println("Cantidad de pares: 0");
            System.out.println("Suma: 0");
            System.out.println("Promedio: no se puede calcular.");
        }
 
        entrada.close();
    }
}
