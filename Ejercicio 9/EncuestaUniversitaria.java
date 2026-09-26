import java.util.Locale;
import java.util.Scanner;

public class EncuestaUniversitaria {

    // Lee un dato y lo repite si no cumple las condiciones.
    static double leerDato(Scanner sc, String mensaje,
                           double minimo, double maximo, boolean entero) {

        String texto;
        double valor;
        boolean valido;

        do {
            System.out.print(mensaje);
            texto = sc.nextLine();

            valido = texto.matches("[0-9]+([.][0-9]+)?");
            valor = -1;

            if (valido) {
                valor = Double.parseDouble(texto);
                valido = valor >= minimo && valor <= maximo;

                if (entero && valor % 1 != 0) {
                    valido = false;
                }
            }

            if (!valido) {
                System.out.println("Dato invalido. Intente nuevamente.");
            }

        } while (!valido);

        return valor;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n, edad, semestre, i, s;
        int estudianteMayor, menosDos;

        int[] cantidad = new int[11];

        double horas, sumaEdades, sumaHoras, mayorHoras;
        double promedioEdad, promedioHoras;

        n = (int) leerDato(sc, "Cantidad de estudiantes: ",
                1, Integer.MAX_VALUE, true);

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

            System.out.println("Estudiante " + (i + 1));

            edad = (int) leerDato(sc, "Edad: ", 16, 80, true);

            semestre = (int) leerDato(sc, "Semestre: ", 1, 10, true);

            horas = leerDato(sc, "Horas por dia: ", 0, 24, false);

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

        System.out.printf(Locale.US,
                "Edad promedio: %.2f%n", promedioEdad);

        System.out.printf(Locale.US,
                "Horas promedio: %.2f%n", promedioHoras);

        System.out.println(
                "Estudiante con mas horas: " + estudianteMayor);

        System.out.printf(Locale.US,
                "Mayor cantidad de horas: %.2f%n", mayorHoras);

        System.out.println(
                "Estudiantes con menos de 2 horas: " + menosDos);

        for (s = 1; s <= 10; s++) {
            System.out.println(
                    "Semestre " + s + ": " + cantidad[s]);
        }

        sc.close();
    }
}
