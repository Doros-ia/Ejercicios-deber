#include <iostream>
using namespace std;
 
int main() {
    int tablaInicial, tablaFinal, multiplicadorFinal;
    int tabla, multiplicador, resultado;
 
    // Se leen los límites de las tablas hasta que sean correctos.
    cout << "Ingrese la tabla inicial: ";
    cin >> tablaInicial;
    cout << "Ingrese la tabla final: ";
    cin >> tablaFinal;
 
    while (tablaInicial > tablaFinal) {
        cout << "Error: la tabla inicial no puede ser mayor que la tabla final.\n";
        cout << "Ingrese nuevamente la tabla inicial: ";
        cin >> tablaInicial;
        cout << "Ingrese nuevamente la tabla final: ";
        cin >> tablaFinal;
    }
 
    // El usuario también decide hasta qué multiplicador se genera.
    cout << "Ingrese el multiplicador final (mayor que 0): ";
    cin >> multiplicadorFinal;
    while (multiplicadorFinal <= 0) {
        cout << "Error: el multiplicador final debe ser mayor que 0.\n";
        cout << "Ingrese nuevamente el multiplicador final: ";
        cin >> multiplicadorFinal;
    }
 
    // El primer for cambia de tabla y el segundo calcula sus productos.
    for (tabla = tablaInicial; tabla <= tablaFinal; tabla++) {
        cout << "\nTABLA DEL " << tabla << "\n";
        for (multiplicador = 1; multiplicador <= multiplicadorFinal; multiplicador++) {
            resultado = tabla * multiplicador;
            cout << tabla << " x " << multiplicador << " = " << resultado << "\n";
        }
    }
 
    return 0;
}