#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    int tipo, horas, continuar;
    int motocicletas = 0, automoviles = 0, camionetas = 0;
    int totalVehiculos = 0;
    double tarifaHora = 0, pago, totalRecaudado = 0, promedioPagado;

    do {
        do {
            cout << "Tipo (1 Motocicleta, 2 Automovil, 3 Camioneta): ";
            cin >> tipo;
            if (tipo < 1 || tipo > 3) cout << "Error: tipo de vehiculo invalido.\n";
        } while (tipo < 1 || tipo > 3);

        do {
            cout << "Horas estacionado: ";
            cin >> horas;
            if (horas <= 0) cout << "Error: las horas deben ser mayores que cero.\n";
        } while (horas <= 0);

        switch (tipo) {
            case 1: tarifaHora = 0.50; motocicletas++; break;
            case 2: tarifaHora = 1.00; automoviles++; break;
            default: tarifaHora = 1.50; camionetas++;
        }

        pago = tarifaHora * horas;
        totalVehiculos++;
        totalRecaudado += pago;
        cout << fixed << setprecision(2) << "Valor a pagar: $" << pago << "\n";

        do {
            cout << "Registrar otro vehiculo? (1 Si, 0 No): ";
            cin >> continuar;
            if (continuar != 0 && continuar != 1) cout << "Error: ingrese 1 para Si o 0 para No.\n";
        } while (continuar != 0 && continuar != 1);
    } while (continuar == 1);

    if (totalVehiculos > 0) promedioPagado = totalRecaudado / totalVehiculos;
    else promedioPagado = 0;

    cout << "\n===== REPORTE =====\n";
    cout << "Motocicletas: " << motocicletas << "\n";
    cout << "Automoviles: " << automoviles << "\n";
    cout << "Camionetas: " << camionetas << "\n";
    cout << "Total vehiculos: " << totalVehiculos << "\n";
    cout << fixed << setprecision(2);
    cout << "Total recaudado: $" << totalRecaudado << "\n";
    cout << "Promedio pagado: $" << promedioPagado << "\n";
    cout << "===================\n";
    return 0;
}
