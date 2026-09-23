 import java.util.Scanner;
public class controlCalificacionesN {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // Variables simples para registrar y resumir las calificaciones.
        int numeroEstudiantes, aprobados = 0, reprobados = 0;
        double calificacion, suma = 0, promedio;
        double notaMayor = 0, notaMenor = 0;
        // Se valida que la cantidad de estudiantes sea mayor que cero.
        System.out.print("Ingrese el número de estudiantes: ");
        numeroEstudiantes = entrada.nextInt();
        while (numeroEstudiantes <= 0) {
            System.out.println("La cantidad debe ser mayor que cero.");
            System.out.print("Ingrese nuevamente: ");
            numeroEstudiantes = entrada.nextInt();
        }
        // El ciclo for procesa exactamente una nota por estudiante.
        for (int i = 1; i <= numeroEstudiantes; i++) {
            System.out.print("Calificación del estudiante " + i + " (0 a 10): ");
            calificacion = entrada.nextDouble();
            while (calificacion < 0 || calificacion > 10) {
                System.out.println("Calificación inválida. Debe estar entre 0 y 10.");
                System.out.print("Ingrese nuevamente: ");
                calificacion = entrada.nextDouble();
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
        System.out.println("\n===== RESUMEN DE CALIFICACIONES =====");
        System.out.println("Número de estudiantes: " + numeroEstudiantes);
        System.out.printf("Suma de calificaciones: %.2f%n", suma);
        System.out.printf("Promedio general: %.2f%n", promedio);
        System.out.println("Cantidad de aprobados: " + aprobados);
        System.out.println("Cantidad de reprobados: " + reprobados);
        System.out.printf("Nota más alta: %.2f%n", notaMayor);
        System.out.printf("Nota más baja: %.2f%n", notaMenor);
        entrada.close();
    }
} 
