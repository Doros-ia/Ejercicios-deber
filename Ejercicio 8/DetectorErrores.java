public class DetectorErrores {
    public static void main(String[] args) {
        int numero;
        int contador;

        numero = 1;
        System.out.println("Ejemplo 1: conteo ascendente");

        while (numero <= 10) {
            System.out.println(numero);
            numero++;
        }

        contador = 5;
        System.out.println("Ejemplo 2: cuenta regresiva");

        while (contador >= 1) {
            System.out.println(contador);
            contador--;
        }
    }
}