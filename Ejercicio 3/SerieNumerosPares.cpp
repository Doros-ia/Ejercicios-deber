#include <iostream>
#include <iomanip>
using namespace std;
 
int main() {
    int n, numero, contador = 0, suma = 0;
    double promedio = 0;
 
    cout << "Ingrese un número entero positivo N: ";
    cin >> n;
 
    // Se valida que N sea positivo.
    while (n <= 0) {
        cout << "Error: N debe ser mayor que cero.\n";
        cout << "Ingrese nuevamente N: ";
        cin >> n;
    }
 
    cout << "Serie de números pares:\n";
    // El ciclo empieza en 2 y avanza de dos en dos.
    for (numero = 2; numero <= n; numero += 2) {
        cout << numero << " ";
        contador++;
        suma += numero;
    }
    cout << "\n";
 
    if (contador > 0) {
        promedio = static_cast<double>(suma) / contador;
        cout << "Cantidad de pares: " << contador << "\n";
        cout << "Suma: " << suma << "\n";
        cout << fixed << setprecision(2) << "Promedio: " << promedio << "\n";
    } else {
        cout << "No existen números pares entre 2 y " << n << ".\n";
        cout << "Cantidad de pares: 0\n";
        cout << "Suma: 0\n";
        cout << "Promedio: no se puede calcular.\n";
    }
 
    return 0;
}