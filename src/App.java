import java.util.Scanner;

public class App {

    static String nombre;
    static int edad;

    static String[] nombres;
    static int[] edades;
    static int n;

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Ingrese cantidad de Personas del listado: ");
            n = scan.nextInt();
            scan.nextLine();

            nombres = new String[n];
            edades = new int[n];

            for (int i = 0; i < n; i++) {
                System.out.println("Ingrese Persona:");
                System.out.print("  Nombe: ");
                nombres[i] = scan.nextLine();
                System.out.print("  Edad: ");
                edades[i] = scan.nextInt();
                while (edades[i] < 0) {
                    System.out.print("  Edad: ");
                    edades[i] = scan.nextInt();
                }
                scan.nextLine();
            }

            ordenar();

            System.out.print("Valor la personada de la edad: ");
            int buscar = scan.nextInt();

            busquedaBinaria(buscar);
        }
    }

    static void ordenar() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (edades[j] > edades[j + 1]) {
                    int tempEdad = edades[j];
                    edades[j] = edades[j + 1];
                    edades[j + 1] = tempEdad;

                    String tempNombre = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = tempNombre;
                }
            }
        }
    }

    static void busquedaBinaria(int buscar) {
        int bajo = 0;
        int alto = n - 1;

        while (bajo <= alto) {
            int centro = (bajo + alto) / 2;
            int valorCentro = edades[centro];

            for (int i = bajo; i <= alto; i++) {
                System.out.print(edades[i]);
                if (i < alto) System.out.print(" | ");
            }
            System.out.println(" ");

            if (valorCentro == buscar) {
                System.out.println("bajo=" + bajo + " alto=" + alto + " centro=" + centro + " valorCentro=" + valorCentro + " --> ENCONTRADO");
                System.out.println("La persona con la edad " + buscar + " es " + nombres[centro]);
                return;
            } else if (buscar > valorCentro) {
                System.out.println("bajo=" + bajo + " alto=" + alto + " centro=" + centro + " valorCentro=" + valorCentro + " --> DERECHA");
                bajo = centro + 1;
            } else {
                System.out.println("bajo=" + bajo + " alto=" + alto + " centro=" + centro + " valorCentro=" + valorCentro + " --> IZQUIERDA");
                alto = centro - 1;
            }
        }

        System.out.println("Elemento no encontrado");
    }
}