#include <iostream>
#include <vector>

using namespace std;

int main() {

    int n;
    int edad;
    int semestre;
    int horas;

    int sumaEdad = 0;
    int sumaHoras = 0;

    int mayorHoras = -1;
    int estudianteMayor = 0;
    int menosDos = 0;

    cout << "Ingrese la cantidad de estudiantes: ";
    cin >> n;

    vector<int> semestres(n);

    // Registro de los estudiantes
    for (int i = 0; i < n; i++) {

        do {
            cout << "Edad del estudiante " << i + 1 << ": ";
            cin >> edad;

            if (edad < 16 || edad > 80) {
                cout << "Edad invalida. Debe estar entre 16 y 80."
                     << endl;
            }

        } while (edad < 16 || edad > 80);

        do {
            cout << "Semestre del estudiante " << i + 1 << ": ";
            cin >> semestre;

            if (semestre < 1 || semestre > 10) {
                cout << "Semestre invalido. Debe estar entre 1 y 10."
                     << endl;
            }

        } while (semestre < 1 || semestre > 10);

        do {
            cout << "Horas de estudio por dia del estudiante "
                 << i + 1 << ": ";
            cin >> horas;

            if (horas < 0 || horas > 24) {
                cout << "Horas invalidas. Deben estar entre 0 y 24."
                     << endl;
            }

        } while (horas < 0 || horas > 24);

        sumaEdad += edad;
        sumaHoras += horas;

        semestres[i] = semestre;

        if (horas > mayorHoras) {
            mayorHoras = horas;
            estudianteMayor = i + 1;
        }

        if (horas < 2) {
            menosDos++;
        }
    }

    double promedioEdad = (double)sumaEdad / n;
    double promedioHoras = (double)sumaHoras / n;

    cout << "\n===== CANTIDAD POR SEMESTRE =====" << endl;

    // Ciclos anidados
    for (int i = 1; i <= 10; i++) {

        int contadorSemestre = 0;

        for (int j = 0; j < n; j++) {

            if (semestres[j] == i) {
                contadorSemestre++;
            }
        }

        cout << "Semestre " << i << ": "
             << contadorSemestre << " estudiante(s)" << endl;
    }

    cout << "\n===== RESULTADOS =====" << endl;

    cout << "Edad promedio: " << promedioEdad << endl;
    cout << "Horas promedio de estudio: " << promedioHoras << endl;
    cout << "Estudiante con mayor cantidad de horas: "
         << estudianteMayor << endl;
    cout << "Mayor cantidad de horas: "
         << mayorHoras << endl;
    cout << "Estudiantes que estudian menos de 2 horas: "
         << menosDos << endl;

    return 0;
}