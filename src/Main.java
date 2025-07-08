import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.jar.JarOutputStream;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        LibretaDeNotas libreta = new LibretaDeNotas();

        int cantidadAlumnos;
        int cantidadNotas;


        do {
            System.out.println("Ingrese la cantidad de alumnos: ");
            cantidadAlumnos = teclado.nextInt();
            if (cantidadAlumnos <= 0) {
                System.out.println("Ingrese un numero valido");
            }
        } while (cantidadAlumnos <= 0);


        System.out.println("Ingrese la cantidad de notas por alumno");
        cantidadNotas = teclado.nextInt();
        teclado.nextLine();


        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("Ingrese el nombre del alumno #" + (i + 1) + ": ");
            String nombre = teclado.nextLine();


            ArrayList<Double> notas = new ArrayList<>();


            for (int j = 0; j < cantidadNotas; j++) {
                double nota;
                do {
                    System.out.print("Ingrese la nota #" + (j + 1) + " para " + nombre + ": ");
                    nota = teclado.nextDouble();
                    if (!libreta.notaValida(nota)) {
                        System.out.println("La nota debe estar entre 1.0 y 7.0");
                    }
                } while (!libreta.notaValida(nota));
                notas.add(nota);
            }

            teclado.nextLine();
            libreta.agregarNotas(nombre, notas);

        }
    //Menú de opciones
    int opcion;
        do {
            System.out.println("--- MENÚ ---");
            System.out.println("1-. Mostar promedio, nota Máxima y Mínima por estudiante");
            System.out.println("2-. Verificar si una nota es aprobatoria o reprobatoria");
            System.out.println("3-. Comparar una nota con el promedio general");
            System.out.println("0-. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();


            switch (opcion) {
                case 1:
                    libreta.mostrarPromedios();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombre2 = teclado.nextLine();

                    System.out.print("Ingrese la nota a verificar: ");
                    double notaVerificar = teclado.nextDouble();
                    teclado.nextLine();

                    libreta.verificarAprobacion(nombre2, notaVerificar, 4.0);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombre = teclado.nextLine();
                    System.out.print("Ingrese la nota a comparar: ");
                    double notaComparar = teclado.nextDouble();
                    teclado.nextLine();
                    libreta.compararPromedioGeneral(nombre, notaComparar);
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no valida. Intente nuevamnte");
            }
        } while (opcion != 0);

        teclado.close();

    }
}