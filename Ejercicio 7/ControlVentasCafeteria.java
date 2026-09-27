import java.util.Scanner;

public class ControlVentasCafeteria {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion, producto, cantidad, posicion;
        char caracter;
        String texto;
        boolean valido;
        double dato, precio = 0, importe, total = 0, promedio;
        long ventas = 0, unidades = 0, mayor;
        long cafe = 0, sandwich = 0, jugo = 0, empanada = 0;

        do {
            System.out.println("===== CAFETERIA UNIVERSITARIA =====");
            System.out.println("1. Registrar venta");
            System.out.println("2. Mostrar estadisticas");
            System.out.println("3. Mostrar tabla de productos");
            System.out.println("4. Salir");

            do {
                System.out.println("Opcion (1 a 4):");
                texto = entrada.nextLine();
                valido = texto.length() > 0;
                dato = 0;
                posicion = 0;
                // Solo se aceptan digitos y un valor dentro del rango.
                while (posicion < texto.length() && valido) {
                    caracter = texto.charAt(posicion);
                    if (caracter < '0' || caracter > '9') {
                        valido = false;
                    } else {
                        dato = dato * 10 + (caracter - '0');
                        if (dato > 4) valido = false;
                    }
                    posicion++;
                }
                if (dato < 1) valido = false;
                if (!valido) System.out.println("Entrada invalida. Intente otra vez.");
            } while (!valido);
            opcion = (int) dato;

            switch (opcion) {
                case 1:
                    do {
                        System.out.println("Producto: 1 Cafe, 2 Sandwich, 3 Jugo, 4 Empanada");
                        texto = entrada.nextLine();
                        valido = texto.length() > 0;
                        dato = 0;
                        posicion = 0;
                        // Solo se aceptan digitos y un valor dentro del rango.
                        while (posicion < texto.length() && valido) {
                            caracter = texto.charAt(posicion);
                            if (caracter < '0' || caracter > '9') {
                                valido = false;
                            } else {
                                dato = dato * 10 + (caracter - '0');
                                if (dato > 4) valido = false;
                            }
                            posicion++;
                        }
                        if (dato < 1) valido = false;
                        if (!valido) System.out.println("Entrada invalida. Intente otra vez.");
                    } while (!valido);
                    producto = (int) dato;

                    do {
                        System.out.println("Cantidad entera positiva:");
                        texto = entrada.nextLine();
                        valido = texto.length() > 0;
                        dato = 0;
                        posicion = 0;
                        // Solo se aceptan digitos y un valor dentro del rango.
                        while (posicion < texto.length() && valido) {
                            caracter = texto.charAt(posicion);
                            if (caracter < '0' || caracter > '9') {
                                valido = false;
                            } else {
                                dato = dato * 10 + (caracter - '0');
                                if (dato > 2147483647) valido = false;
                            }
                            posicion++;
                        }
                        if (dato < 1) valido = false;
                        if (!valido) System.out.println("Entrada invalida. Intente otra vez.");
                    } while (!valido);
                    cantidad = (int) dato;

                    // Cada registro valido cuenta como una venta.
                    switch (producto) {
                        case 1:
                            precio = 1.00;
                            cafe += cantidad;
                            break;
                        case 2:
                            precio = 2.50;
                            sandwich += cantidad;
                            break;
                        case 3:
                            precio = 1.50;
                            jugo += cantidad;
                            break;
                        case 4:
                            precio = 1.25;
                            empanada += cantidad;
                            break;
                    }
                    importe = precio * cantidad;
                    ventas++;
                    unidades += cantidad;
                    total += importe;
                    System.out.printf("Venta: $%.2f%n", importe);
                    break;

                case 2:
                    System.out.println("Numero de ventas: " + ventas);
                    System.out.println("Cantidad total de productos: " + unidades);
                    System.out.printf("Total recaudado: $%.2f%n", total);
                    if (ventas == 0) {
                        System.out.println("Sin ventas: promedio no disponible; sin producto lider.");
                    } else {
                        promedio = total / ventas;
                        System.out.printf("Promedio por venta: $%.2f%n", promedio);
                        mayor = cafe;
                        if (sandwich > mayor) mayor = sandwich;
                        if (jugo > mayor) mayor = jugo;
                        if (empanada > mayor) mayor = empanada;
                        System.out.println("Mayor cantidad vendida: " + mayor);
                        // Condiciones separadas para mostrar los empates.
                        if (cafe == mayor) System.out.println("Cafe");
                        if (sandwich == mayor) System.out.println("Sandwich");
                        if (jugo == mayor) System.out.println("Jugo");
                        if (empanada == mayor) System.out.println("Empanada");
                    }
                    break;

                case 3:
                    System.out.println("1. Cafe: $1.00");
                    System.out.println("2. Sandwich: $2.50");
                    System.out.println("3. Jugo: $1.50");
                    System.out.println("4. Empanada: $1.25");
                    break;

                case 4:
                    System.out.println("Programa finalizado.");
                    break;
            }
        } while (opcion != 4);

        entrada.close();
    }
}
