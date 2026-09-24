import java.util.Scanner;
 
public class EstacionamientoRegistro {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int tipo, horas, continuar;
        int motocicletas = 0, automoviles = 0, camionetas = 0;
        int totalVehiculos = 0;
        double tarifaHora = 0, pago, totalRecaudado = 0, promedioPagado;
 
        do {
            do {
                System.out.print("Tipo (1 Motocicleta, 2 Automóvil, 3 Camioneta): ");
                tipo = entrada.nextInt();
                if (tipo < 1 || tipo > 3) {
                    System.out.println("Error: tipo de vehículo inválido.");
                }
            } while (tipo < 1 || tipo > 3);
 
            do {
                System.out.print("Horas estacionado: ");
                horas = entrada.nextInt();
                if (horas <= 0) {
                    System.out.println("Error: las horas deben ser mayores que cero.");
                }
            } while (horas <= 0);
 
            switch (tipo) {
                case 1:
                    tarifaHora = 0.50;
                    motocicletas++;
                    break;
                case 2:
                    tarifaHora = 1.00;
                    automoviles++;
                    break;
                default:
                    tarifaHora = 1.50;
                    camionetas++;
            }
 
            pago = tarifaHora * horas;
            totalVehiculos++;
            totalRecaudado += pago;
            System.out.printf("Valor a pagar: $%.2f%n", pago);
 
            do {
                System.out.print("¿Registrar otro vehículo? (1 Sí, 0 No): ");
                continuar = entrada.nextInt();
                if (continuar != 0 && continuar != 1) {
                    System.out.println("Error: ingrese 1 para Sí o 0 para No.");
                }
            } while (continuar != 0 && continuar != 1);
        } while (continuar == 1);
 
        if (totalVehiculos > 0) {
            promedioPagado = totalRecaudado / totalVehiculos;
        } else {
            promedioPagado = 0;
        }
 
        System.out.println("\n===== REPORTE =====");
        System.out.println("Motocicletas: " + motocicletas);
        System.out.println("Automóviles: " + automoviles);
        System.out.println("Camionetas: " + camionetas);
        System.out.println("Total vehículos: " + totalVehiculos);
        System.out.printf("Total recaudado: $%.2f%n", totalRecaudado);
        System.out.printf("Promedio pagado: $%.2f%n", promedioPagado);
        System.out.println("===================");
        entrada.close();
    }
}