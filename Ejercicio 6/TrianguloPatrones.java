import java.util.Scanner;
 
public class TrianguloPatrones {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int n, i, j;
 
        System.out.print("Ingrese un número entre 2 y 10: ");
        n = entrada.nextInt();
        while (n < 2 || n > 10) {
            System.out.println("Error: el número debe estar entre 2 y 10.");
            System.out.print("Ingrese nuevamente: ");
            n = entrada.nextInt();
        }
 
        System.out.println("\nPatrón ascendente de asteriscos:");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
 
        System.out.println("\nPatrón descendente de asteriscos:");
        for (i = n; i >= 1; i--) {
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
 
        System.out.println("\nPatrón numérico:");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
 
        entrada.close();
    }
}