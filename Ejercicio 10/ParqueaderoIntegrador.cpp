#include <iostream>
#include <iomanip>
#include <string>
#include <sstream>
#include <regex>
using namespace std;
// Repetimos la lectura mientras el entero no sea valido.
int leerEntero(string mensaje, int min, int max) {
 string texto;
 double valor;
 bool valido = false;
 while (!valido) {
 cout << mensaje;
 getline(cin, texto);
 if (regex_match(texto, regex("[0-9]+"))) {
 istringstream lectura(texto);
 if (lectura >> valor) {
 if (valor >= min && valor <= max) {
 return int(valor);
 }
 }
 }
 cout << "Dato invalido. Intente nuevamente." << endl;
 }
 return 0;
}
void mostrarVehiculos(int datos[][5], int pagos[], int n) {
 int i;
 cout << "VEHICULOS REGISTRADOS" << endl;
 cout << "Tipos: 1 Moto, 2 Auto, 3 Camioneta." << endl;
 cout << "Roles: 1 Estudiante, 2 Docente, 3 Visitante." << endl;
 cout << "Dias: 1 Lunes a 7 Domingo. Boleto: 0 No, 1 Si." << endl;
 if (n == 0) { cout << "No hay vehiculos registrados." << endl; }
 for (i = 0; i < n; i++) {
 cout << "Registro " << i + 1 << " | Tipo " << datos[i][0]
 << " | Rol " << datos[i][1] << " | Horas " << datos[i][2] << endl;
 cout << "Dia " << datos[i][3] << " | Boleto perdido " << datos[i][4]
 << " | Pago: $" << pagos[i] / 100.0 << endl;
 }
}
void mostrarEstadisticas(int datos[][5], int n, int totalHoras) {
 int categoria, i, porTipo, porRol;
 cout << "ESTADISTICAS" << endl;
 cout << "Vehiculos registrados: " << n << endl;
 cout << "Tipos: 1 Moto, 2 Auto, 3 Camioneta." << endl;
 cout << "Roles: 1 Estudiante, 2 Docente, 3 Visitante." << endl;
 // Ciclos anidados: revisamos los registros de cada categoria.
 for (categoria = 1; categoria <= 3; categoria++) {
 porTipo = 0;
 porRol = 0;
 for (i = 0; i < n; i++) {
 if (datos[i][0] == categoria) { porTipo++; }
 if (datos[i][1] == categoria) { porRol++; }
 }
 cout << "Tipo " << categoria << ": " << porTipo << endl;
 cout << "Rol " << categoria << ": " << porRol << endl;
 }
 cout << "Total de horas: " << totalHoras << endl;
 if (n > 0) {
 cout << "Promedio de permanencia: " << totalHoras / double(n)
 << " horas" << endl;
 } else {
 cout << "Promedio de permanencia: no disponible." << endl;
 }
}
void mostrarRecaudacion(int n, int total, int mayor, int menor) {
 cout << "RECAUDACION" << endl;
 cout << "Total recaudado: $" << total / 100.0 << endl;
 if (n > 0) {
 cout << "Mayor pago: $" << mayor / 100.0 << endl;
 cout << "Menor pago: $" << menor / 100.0 << endl;
 } else {
 cout << "Mayor y menor pago: no disponibles." << endl;
 }
}
int main() {
 const int CAPACIDAD = 50;
 int datos[CAPACIDAD][5], pagos[CAPACIDAD];
 int n = 0, totalHoras = 0, total = 0, mayor = 0, menor = 0;
 int opcion, tipo, rol, horas, dia, boleto;
 int tarifa, factor, descuento, base, pago;
 cout << fixed << setprecision(2);
 do {
 cout << "PARQUEADERO UNIVERSITARIO" << endl;
 cout << "1. Registrar vehiculo" << endl;
 cout << "2. Mostrar vehiculos registrados" << endl;
 cout << "3. Mostrar estadisticas" << endl;
 cout << "4. Mostrar recaudacion" << endl;
 cout << "5. Salir" << endl;
 opcion = leerEntero("Opcion: ", 1, 5);
 switch (opcion) {
 case 1:
 if (n == CAPACIDAD) {
 cout << "Capacidad de 50 registros alcanzada." << endl;
 break;
 }
 tipo = leerEntero("Tipo (1 Moto, 2 Auto, 3 Camioneta): ", 1, 3);
 rol = leerEntero("Rol (1 Estudiante, 2 Docente, 3 Visitante): ", 1, 3);
 horas = leerEntero("Horas (1 a 24): ", 1, 24);
 dia = leerEntero("Dia (1 Lunes a 7 Domingo): ", 1, 7);
 boleto = leerEntero("Boleto perdido (0 No, 1 Si): ", 0, 1);
 tarifa = tipo == 1 ? 50 : (tipo == 2 ? 100 : 150);
 factor = dia <= 5 ? 100 : (dia == 6 ? 120 : 150);
 descuento = rol == 1 ? 20 : (rol == 2 ? 10 : 0);
 base = tarifa * horas;
 // Trabajamos en centavos y redondeamos una sola vez.
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
 cout << "Registro " << n << " guardado. Pago: $"
 << pago / 100.0 << endl;
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
 cout << "REPORTE FINAL" << endl;
 mostrarVehiculos(datos, pagos, n);
 mostrarEstadisticas(datos, n, totalHoras);
 mostrarRecaudacion(n, total, mayor, menor);
 cout << "Fin del programa." << endl;
 break;
 }
 } while (opcion != 5);
 return 0;
}