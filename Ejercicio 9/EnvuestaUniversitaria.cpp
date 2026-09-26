#include <iostream>
#include <iomanip>
#include <string>
#include <sstream>
#include <regex>
#include <cmath>
#include <limits>
#include <locale>

using namespace std;

// Lee un dato y lo repite si no cumple las condiciones.
double leerDato(string mensaje, double minimo,
                double maximo, bool entero) {

    string texto;
    double valor;
    bool valido;

    do {
        cout << mensaje;
        getline(cin, texto);

        valido = regex_match(texto, regex("[0-9]+([.][0-9]+)?"));
        valor = -1;

        if (valido) {
            istringstream lectura(texto);
            lectura.imbue(locale::classic());

            valido = bool(lectura >> valor);
            valido = valido && valor >= minimo && valor <= maximo;

            if (entero && fmod(valor, 1.0) != 0) {
                valido = false;
            }
        }

        if (!valido) {
            cout << "Dato invalido. Intente nuevamente." << endl;
        }

    } while (!valido);

    return valor;
}

int main() {

    int n, edad, semestre, i, s;
    int estudianteMayor, menosDos;
    int cantidad[11];

    double horas, sumaEdades, sumaHoras, mayorHoras;
    double promedioEdad, promedioHoras;

    n = int(leerDato("Cantidad de estudiantes: ",
                     1, numeric_limits<int>::max(), true));

    sumaEdades = 0;
    sumaHoras = 0;
    mayorHoras = -1;
    estudianteMayor = 0;
    menosDos = 0;

    for (s = 1; s <= 10; s++) {
        cantidad[s] = 0;
    }

    // i empieza en cero; el estudiante se identifica con i + 1.
    for (i = 0; i < n; i++) {

        cout << "Estudiante " << i + 1 << endl;

        edad = int(leerDato("Edad: ", 16, 80, true));

        semestre = int(leerDato("Semestre: ", 1, 10, true));

        horas = leerDato("Horas por dia: ", 0, 24, false);

        sumaEdades += edad;
        sumaHoras += horas;

        cantidad[semestre]++;

        if (horas > mayorHoras) {
            mayorHoras = horas;
            estudianteMayor = i + 1;
        }

        if (horas < 2) {
            menosDos++;
        }
    }

    promedioEdad = sumaEdades / n;
    promedioHoras = sumaHoras / n;

    cout.imbue(locale::classic());

    cout << fixed << setprecision(2);

    cout << "Edad promedio: " << promedioEdad << endl;

    cout << "Horas promedio: " << promedioHoras << endl;

    cout << "Estudiante con mas horas: " << estudianteMayor << endl;

    cout << "Mayor cantidad de horas: " << mayorHoras << endl;

    cout << "Estudiantes con menos de 2 horas: "
         << menosDos << endl;

    for (s = 1; s <= 10; s++) {
        cout << "Semestre " << s << ": "
             << cantidad[s] << endl;
    }

    return 0;
}