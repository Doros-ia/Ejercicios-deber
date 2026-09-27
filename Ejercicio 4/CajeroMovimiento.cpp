#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    int opcion, depositosRealizados = 0, retirosRealizados = 0;
    double saldo = 100, monto;
    double totalDepositado = 0, totalRetirado = 0;

    do {
        cout << "\n===== CAJERO AUTOMATICO =====\n";
        cout << "1. Consultar saldo\n2. Depositar\n3. Retirar\n";
        cout << "4. Mostrar movimientos\n5. Salir\n";
        cout << "Seleccione una opcion: ";
        cin >> opcion;

        switch (opcion) {
            case 1:
                cout << fixed << setprecision(2) << "Saldo actual: $" << saldo << "\n";
                break;
            case 2:
                cout << "Monto a depositar: $";
                cin >> monto;
                if (monto > 0) {
                    saldo += monto;
                    depositosRealizados++;
                    totalDepositado += monto;
                    cout << "Deposito realizado correctamente.\n";
                } else {
                    cout << "Error: el deposito debe ser positivo.\n";
                }
                break;
            case 3:
                cout << "Monto a retirar: $";
                cin >> monto;
                if (monto <= 0) {
                    cout << "Error: el retiro debe ser positivo.\n";
                } else if (monto > saldo) {
                    cout << "Error: fondos insuficientes.\n";
                } else {
                    saldo -= monto;
                    retirosRealizados++;
                    totalRetirado += monto;
                    cout << "Retiro realizado correctamente.\n";
                }
                break;
            case 4:
                cout << "Depositos realizados: " << depositosRealizados << "\n";
                cout << "Retiros realizados: " << retirosRealizados << "\n";
                cout << fixed << setprecision(2);
                cout << "Total depositado: $" << totalDepositado << "\n";
                cout << "Total retirado: $" << totalRetirado << "\n";
                cout << "Saldo actual: $" << saldo << "\n";
                break;
            case 5:
                cout << "Programa finalizado.\n";
                break;
            default:
                cout << "Error: opcion inexistente.\n";
        }
    } while (opcion != 5);

    cout << "\n===== RESUMEN FINAL =====\n";
    cout << "Depositos realizados: " << depositosRealizados << "\n";
    cout << "Retiros realizados: " << retirosRealizados << "\n";
    cout << fixed << setprecision(2);
    cout << "Total depositado: $" << totalDepositado << "\n";
    cout << "Total retirado: $" << totalRetirado << "\n";
    cout << "Saldo final: $" << saldo << "\n";
    return 0;
}
