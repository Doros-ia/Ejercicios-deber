#include <iostream>
using namespace std;

int main() {
    int n, i, j;

    cout << "Ingrese un numero entre 2 y 10: ";
    cin >> n;
    while (n < 2 || n > 10) {
        cout << "Error: el numero debe estar entre 2 y 10.\n";
        cout << "Ingrese nuevamente: ";
        cin >> n;
    }

    cout << "\nPatron ascendente de asteriscos:\n";
    for (i = 1; i <= n; i++) {
        for (j = 1; j <= i; j++) {
            cout << "*";
        }
        cout << "\n";
    }

    cout << "\nPatron descendente de asteriscos:\n";
    for (i = n; i >= 1; i--) {
        for (j = 1; j <= i; j++) {
            cout << "*";
        }
        cout << "\n";
    }

    cout << "\nPatron numerico:\n";
    for (i = 1; i <= n; i++) {
        for (j = 1; j <= i; j++) {
            cout << j;
        }
        cout << "\n";
    }

    return 0;
}
