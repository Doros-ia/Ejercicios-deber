#include <iostream>
using namespace std;

int main() {
    int numero;
    int contador;

    numero = 1;
    cout << "Ejemplo 1: conteo ascendente" << endl;

    while (numero <= 10) {
        cout << numero << endl;
        numero++;
    }

    contador = 5;
    cout << "Ejemplo 2: cuenta regresiva" << endl;

    while (contador >= 1) {
        cout << contador << endl;
        contador--;
    }

    return 0;
}