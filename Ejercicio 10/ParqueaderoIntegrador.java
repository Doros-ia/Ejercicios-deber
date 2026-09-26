import java.util.Scanner;
import java.util.Locale;
public class ParqueaderoIntegrador {
 // Repetimos la lectura mientras el entero no sea valido.
 static int leerEntero(Scanner sc, String mensaje, int min, int max) {
 String texto;
 double valor;
 boolean valido = false;
 while (!valido) {
 System.out.print(mensaje);
 texto = sc.nextLine();
 if (texto.matches("[0-9]+")) {
 valor = Double.parseDouble(texto);
 if (valor >= min && valor <= max) {
 return (int) valor;
 }
 }
 System.out.println("Dato invalido. Intente nuevamente.");
 }
 return 0;
 }
 static void mostrarVehiculos(int[][] datos, int[] pagos, int n) {
 int i;
 System.out.println("VEHICULOS REGISTRADOS");
 System.out.println("Tipos: 1 Moto, 2 Auto, 3 Camioneta.");
 System.out.println("Roles: 1 Estudiante, 2 Docente, 3 Visitante.");
 System.out.println("Dias: 1 Lunes a 7 Domingo. Boleto: 0 No, 1 Si.");
 if (n == 0) {
 System.out.println("No hay vehiculos registrados.");
 }
 for (i = 0; i < n; i++) {
 System.out.printf(Locale.US,
 "Registro %d | Tipo %d | Rol %d | Horas %d%n",
 i + 1, datos[i][0], datos[i][1], datos[i][2]);
 System.out.printf(Locale.US,
 "Dia %d | Boleto perdido %d | Pago: $%.2f%n",
 datos[i][3], datos[i][4], pagos[i] / 100.0);
 }
 }
 static void mostrarEstadisticas(int[][] datos, int n, int totalHoras) {
 int categoria, i, porTipo, porRol;
 System.out.println("ESTADISTICAS");
 System.out.println("Vehiculos registrados: " + n);
 System.out.println("Tipos: 1 Moto, 2 Auto, 3 Camioneta.");
 System.out.println("Roles: 1 Estudiante, 2 Docente, 3 Visitante.");
 // Ciclos anidados: revisamos los registros de cada categoria.
 for (categoria = 1; categoria <= 3; categoria++) {
 porTipo = 0;
 porRol = 0;
 for (i = 0; i < n; i++) {
 if (datos[i][0] == categoria) { porTipo++; }
 if (datos[i][1] == categoria) { porRol++; }
 }
 System.out.println("Tipo " + categoria + ": " + porTipo);
 System.out.println("Rol " + categoria + ": " + porRol);
 }
 System.out.println("Total de horas: " + totalHoras);
 if (n > 0) {
 System.out.printf(Locale.US,
 "Promedio de permanencia: %.2f horas%n", totalHoras / (double) n);
 } else {
 System.out.println("Promedio de permanencia: no disponible.");
 }
 }
 static void mostrarRecaudacion(int n, int total, int mayor, int menor) {
 System.out.println("RECAUDACION");
 System.out.printf(Locale.US, "Total recaudado: $%.2f%n", total / 100.0);
 if (n > 0) {
 System.out.printf(Locale.US, "Mayor pago: $%.2f%n", mayor / 100.0);
 System.out.printf(Locale.US, "Menor pago: $%.2f%n", menor / 100.0);
 } else {
 System.out.println("Mayor y menor pago: no disponibles.");
 }
 }
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 final int CAPACIDAD = 50;
 int[][] datos = new int[CAPACIDAD][5];
 int[] pagos = new int[CAPACIDAD];
 int n = 0, totalHoras = 0, total = 0, mayor = 0, menor = 0;
 int opcion, tipo, rol, horas, dia, boleto;
 int tarifa, factor, descuento, base, pago;
 do {
 System.out.println("PARQUEADERO UNIVERSITARIO");
 System.out.println("1. Registrar vehiculo");
 System.out.println("2. Mostrar vehiculos registrados");
 System.out.println("3. Mostrar estadisticas");
 System.out.println("4. Mostrar recaudacion");
 System.out.println("5. Salir");
 opcion = leerEntero(sc, "Opcion: ", 1, 5);
 switch (opcion) {
 case 1:
 if (n == CAPACIDAD) {
 System.out.println("Capacidad de 50 registros alcanzada.");
 break;
 }
 tipo = leerEntero(sc, "Tipo (1 Moto, 2 Auto, 3 Camioneta): ", 1, 3);
 rol = leerEntero(sc, "Rol (1 Estudiante, 2 Docente, 3 Visitante): ", 1, 3);
 horas = leerEntero(sc, "Horas (1 a 24): ", 1, 24);
 dia = leerEntero(sc, "Dia (1 Lunes a 7 Domingo): ", 1, 7);
 boleto = leerEntero(sc, "Boleto perdido (0 No, 1 Si): ", 0, 1);
 tarifa = tipo == 1 ? 50 : (tipo == 2 ? 100 : 150);
 factor = dia <= 5 ? 100 : (dia == 6 ? 120 : 150);
 descuento = rol == 1 ? 20 : (rol == 2 ? 10 : 0);
 base = tarifa * horas;
 // Trabajamos en centavos y redondeamos al centavo mas cercano.
 pago = (base * factor * (100 - descuento) + 5000) / 10000;
 if (boleto == 1) { pago += 500; }
 datos[n][0] = tipo;
 datos[n][1] = rol;
 datos[n][2] = horas;
 datos[n][3] = dia;
 datos[n][4] = boleto;
 pagos[n] = pago;
 totalHoras += horas;
 total += pago;
 if (n == 0 || pago > mayor) { mayor = pago; }
 if (n == 0 || pago < menor) { menor = pago; }
 n++;
 System.out.printf(Locale.US,
 "Registro %d guardado. Pago: $%.2f%n", n, pago / 100.0);
 break;
 case 2:
 mostrarVehiculos(datos, pagos, n);
 break;
 case 3:
 mostrarEstadisticas(datos, n, totalHoras);
 break;
 case 4:
 mostrarRecaudacion(n, total, mayor, menor);
 break;
 case 5:
 System.out.println("REPORTE FINAL");
 mostrarVehiculos(datos, pagos, n);
 mostrarEstadisticas(datos, n, totalHoras);
 mostrarRecaudacion(n, total, mayor, menor);
 System.out.println("Fin del programa.");
 break;
 }
 } while (opcion != 5);
 sc.close();
 }
}