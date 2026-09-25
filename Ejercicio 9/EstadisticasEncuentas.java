import java.util.Scanner;

class EstadisticasEncuesta {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        int edad;
        int semestre;
        int horas;

        int sumaEdad = 0;
        int sumaHoras = 0;

        int mayorHoras = -1;
        int estudianteMayor = 0;
        int menosDos = 0;

        System.out.print("Ingrese la cantidad de estudiantes: ");
        n = sc.nextInt();

        int[] semestres = new int[n];

        // Registro de los estudiantes
        for (int i = 0; i < n; i++) {

            do {
                System.out.print("Edad del estudiante " + (i + 1) + ": ");
                edad = sc.nextInt();

                if (edad < 16 || edad > 80) {
                    System.out.println("Edad invalida. Debe estar entre 16 y 80.");
                }

            } while (edad < 16 || edad > 80);

            do {
                System.out.print("Semestre del estudiante " + (i + 1) + ": ");
                semestre = sc.nextInt();

                if (semestre < 1 || semestre > 10) {
                    System.out.println("Semestre invalido. Debe estar entre 1 y 10.");
                }

            } while (semestre < 1 || semestre > 10);

            do {
                System.out.print("Horas de estudio por dia del estudiante "
                        + (i + 1) + ": ");
                horas = sc.nextInt();

                if (horas < 0 || horas > 24) {
                    System.out.println("Horas invalidas. Deben estar entre 0 y 24.");
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

        double promedioEdad = (double) sumaEdad / n;
        double promedioHoras = (double) sumaHoras / n;

        System.out.println("\n===== CANTIDAD POR SEMESTRE =====");

        // Ciclos anidados
        for (int i = 1; i <= 10; i++) {

            int contadorSemestre = 0;

            for (int j = 0; j < n; j++) {

                if (semestres[j] == i) {
                    contadorSemestre++;
                }
            }

            System.out.println("Semestre " + i + ": "
                    + contadorSemestre + " estudiante(s)");
        }

        System.out.println("\n===== RESULTADOS =====");
        System.out.printf("Edad promedio: %.2f%n", promedioEdad);
        System.out.printf("Horas promedio de estudio: %.2f%n", promedioHoras);
        System.out.println("Estudiante con mayor cantidad de horas: "
                + estudianteMayor);
        System.out.println("Mayor cantidad de horas: " + mayorHoras);
        System.out.println("Estudiantes que estudian menos de 2 horas: "
                + menosDos);

        sc.close();
    }
}