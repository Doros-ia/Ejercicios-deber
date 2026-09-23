#include <iostream>
#include <iomanip>
using namespace std;
int main() {
    // Variables simples para registrar y resumir las calificaciones.
    int numeroEstudiantes, aprobados = 0, reprobados = 0;
    double calificacion, suma = 0, promedio;
    double notaMayor = 0, notaMenor = 0;
    // Se valida que la cantidad de estudiantes sea mayor que cero.
    cout << "Ingrese el número de estudiantes: ";
    cin >> numeroEstudiantes;
    while (numeroEstudiantes <= 0) {
        cout << "La cantidad debe ser mayor que cero.\n";
        cout << "Ingrese nuevamente: ";
        cin >> numeroEstudiantes;
    }
    // El ciclo for procesa exactamente una nota por estudiante.
    for (int i = 1; i <= numeroEstudiantes; i++) {
        cout << "Calificación del estudiante " << i << " (0 a 10): ";
        cin >> calificacion;
        while (calificacion < 0 || calificacion > 10) {
            cout << "Calificación inválida. Debe estar entre 0 y 10.\n";
            cout << "Ingrese nuevamente: ";
            cin >> calificacion;
        }
        suma += calificacion;
        // La primera nota sirve para iniciar el valor mayor y el menor.
        if (i == 1) {
            notaMayor = calificacion;
            notaMenor = calificacion;
        } else {
            if (calificacion > notaMayor) {
                notaMayor = calificacion;
            }
            if (calificacion < notaMenor) {
                notaMenor = calificacion;
            }
        }
        // Una nota de 7 o más se considera aprobada.
        if (calificacion >= 7) {
            aprobados++;
        } else {
            reprobados++;
        }
    }
    promedio = suma / numeroEstudiantes;
    cout << fixed << setprecision(2);
    cout << "\n===== RESUMEN DE CALIFICACIONES =====\n";
    cout << "Número de estudiantes: " << numeroEstudiantes << '\n';
    cout << "Suma de calificaciones: " << suma << '\n';
    cout << "Promedio general: " << promedio << '\n';
    cout << "Cantidad de aprobados: " << aprobados << '\n';
    cout << "Cantidad de reprobados: " << reprobados << '\n';
    cout << "Nota más alta: " << notaMayor << '\n';
    cout << "Nota más baja: " << notaMenor << '\n';
    return 0;
}