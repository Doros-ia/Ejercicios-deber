#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

int main() {
    cout << fixed << setprecision(2);
    int opcion, producto, cantidad, posicion;
    char caracter;
    string texto;
    bool valido;
    double dato, precio = 0, importe, total = 0, promedio;
    long long ventas = 0, unidades = 0, mayor;
    long long cafe = 0, sandwich = 0, jugo = 0, empanada = 0;

    do {
        cout << "===== CAFETERIA UNIVERSITARIA =====" << "\n";
        cout << "1. Registrar venta" << "\n";
        cout << "2. Mostrar estadisticas" << "\n";
        cout << "3. Mostrar tabla de productos" << "\n";
        cout << "4. Salir" << "\n";

        do {
            cout << "Opcion (1 a 4):\n";
            getline(cin, texto);
            valido = texto.size() > 0;
            dato = 0;
            posicion = 0;
            // Solo se aceptan digitos y un valor dentro del rango.
            while (posicion < texto.size() && valido) {
                caracter = texto[posicion];
                if (caracter < '0' || caracter > '9') {
                    valido = false;
                } else {
                    dato = dato * 10 + (caracter - '0');
                    if (dato > 4) valido = false;
                }
                posicion++;
            }
            if (dato < 1) valido = false;
            if (!valido) cout << "Entrada invalida. Intente otra vez.\n";
        } while (!valido);
        opcion = (int) dato;

        switch (opcion) {
            case 1:
                do {
                    cout << "Producto: 1 Cafe, 2 Sandwich, 3 Jugo, 4 Empanada\n";
                    getline(cin, texto);
                    valido = texto.size() > 0;
                    dato = 0;
                    posicion = 0;
                    // Solo se aceptan digitos y un valor dentro del rango.
                    while (posicion < texto.size() && valido) {
                        caracter = texto[posicion];
                        if (caracter < '0' || caracter > '9') {
                            valido = false;
                        } else {
                            dato = dato * 10 + (caracter - '0');
                            if (dato > 4) valido = false;
                        }
                        posicion++;
                    }
                    if (dato < 1) valido = false;
                    if (!valido) cout << "Entrada invalida. Intente otra vez.\n";
                } while (!valido);
                producto = (int) dato;

                do {
                    cout << "Cantidad entera positiva:\n";
                    getline(cin, texto);
                    valido = texto.size() > 0;
                    dato = 0;
                    posicion = 0;
                    // Solo se aceptan digitos y un valor dentro del rango.
                    while (posicion < texto.size() && valido) {
                        caracter = texto[posicion];
                        if (caracter < '0' || caracter > '9') {
                            valido = false;
                        } else {
                            dato = dato * 10 + (caracter - '0');
                            if (dato > 2147483647) valido = false;
                        }
                        posicion++;
                    }
                    if (dato < 1) valido = false;
                    if (!valido) cout << "Entrada invalida. Intente otra vez.\n";
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
                cout << "Venta: $" << importe << "\n";
                break;

            case 2:
                cout << "Numero de ventas: " << ventas << "\n";
                cout << "Cantidad total de productos: " << unidades << "\n";
                cout << "Total recaudado: $" << total << "\n";
                if (ventas == 0) {
                    cout << "Sin ventas: promedio no disponible; sin producto lider." << "\n";
                } else {
                    promedio = total / ventas;
                    cout << "Promedio por venta: $" << promedio << "\n";
                    mayor = cafe;
                    if (sandwich > mayor) mayor = sandwich;
                    if (jugo > mayor) mayor = jugo;
                    if (empanada > mayor) mayor = empanada;
                    cout << "Mayor cantidad vendida: " << mayor << "\n";
                    // Condiciones separadas para mostrar los empates.
                    if (cafe == mayor) cout << "Cafe" << "\n";
                    if (sandwich == mayor) cout << "Sandwich" << "\n";
                    if (jugo == mayor) cout << "Jugo" << "\n";
                    if (empanada == mayor) cout << "Empanada" << "\n";
                }
                break;

            case 3:
                cout << "1. Cafe: $1.00" << "\n";
                cout << "2. Sandwich: $2.50" << "\n";
                cout << "3. Jugo: $1.50" << "\n";
                cout << "4. Empanada: $1.25" << "\n";
                break;

            case 4:
                cout << "Programa finalizado." << "\n";
                break;
        }
    } while (opcion != 4);

    return 0;
}
