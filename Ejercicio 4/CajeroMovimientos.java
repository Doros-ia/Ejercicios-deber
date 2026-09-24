import java.util.Scanner;
 
public class CajeroMovimientos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion, depositosRealizados = 0, retirosRealizados = 0;
        double saldo = 100, monto;
        double totalDepositado = 0, totalRetirado = 0;
 
        do {
            System.out.println("\n===== CAJERO AUTOMÁTICO =====");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Mostrar movimientos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
 
            switch (opcion) {
                case 1:
                    System.out.printf("Saldo actual: $%.2f%n", saldo);
                    break;
                case 2:
                    System.out.print("Monto a depositar: $");
                    monto = entrada.nextDouble();
                    if (monto > 0) {
                        saldo += monto;
                        depositosRealizados++;
                        totalDepositado += monto;
                        System.out.println("Depósito realizado correctamente.");
                    } else {
                        System.out.println("Error: el depósito debe ser positivo.");
                    }
                    break;
                case 3:
                    System.out.print("Monto a retirar: $");
                    monto = entrada.nextDouble();
                    if (monto <= 0) {
                        System.out.println("Error: el retiro debe ser positivo.");
                    } else if (monto > saldo) {
                        System.out.println("Error: fondos insuficientes.");
                    } else {
                        saldo -= monto;
                        retirosRealizados++;
                        totalRetirado += monto;
                        System.out.println("Retiro realizado correctamente.");
                    }
                    break;
                case 4:
                    System.out.println("Depósitos realizados: " + depositosRealizados);
                    System.out.println("Retiros realizados: " + retirosRealizados);
                    System.out.printf("Total depositado: $%.2f%n", totalDepositado);
                    System.out.printf("Total retirado: $%.2f%n", totalRetirado);
                    System.out.printf("Saldo actual: $%.2f%n", saldo);
                    break;
                case 5:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Error: opción inexistente.");
            }
        } while (opcion != 5);
 
        System.out.println("\n===== RESUMEN FINAL =====");
        System.out.println("Depósitos realizados: " + depositosRealizados);
        System.out.println("Retiros realizados: " + retirosRealizados);
        System.out.printf("Total depositado: $%.2f%n", totalDepositado);
        System.out.printf("Total retirado: $%.2f%n", totalRetirado);
        System.out.printf("Saldo final: $%.2f%n", saldo);
        entrada.close();
    }
}
