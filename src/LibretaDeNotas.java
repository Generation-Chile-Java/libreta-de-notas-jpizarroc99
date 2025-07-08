import java.util.ArrayList;
import java.util.HashMap;

public class LibretaDeNotas {

    private HashMap<String, ArrayList<Double>> calificaciones;


    public LibretaDeNotas() {
        calificaciones = new HashMap<>();
    }

    public void agregarNotas(String nombreEstudiante, ArrayList<Double> notas) {
        calificaciones.put(nombreEstudiante, notas);
    }
    public boolean notaValida ( double nota) {
        return nota >= 1.0 && nota <= 7.0;
    }

    public void mostrarPromedios() {
        System.out.println("\n --- Promedios por estudiantes ---");

        for (String estudiante : calificaciones.keySet()) {
            ArrayList<Double> notas = calificaciones.get(estudiante);

            double suma = 0;
            double max = Double.MIN_VALUE;
            double min = Double.MAX_VALUE;

            for (double nota : notas) {
                suma += nota;

                if (nota > max) max = nota;
                if (nota < min) min = nota;
            }
            double promedio = suma / notas.size();

            // MOSTRAMOS LOS RESULTADOS
            System.out.println("Estudiante: " + estudiante);
            System.out.printf("Promedio: %.2f\n", promedio);
            System.out.printf("Nota Máxima: %.2f\n", max);
            System.out.printf("Nota Mínima: %.2f\n", min);
        }
    }


    public void verificarAprobacion(String nombre, double nota, double notaMinima) {
        System.out.println("\n--- Verificación de Aprobación ---");

        if (!calificaciones.containsKey(nombre)) {
            System.out.println("El estudiante no está registrado");
            return;
        }
        if (nota >= notaMinima) {
            System.out.println("Nota Aprobatoria ");
        } else {
            System.out.println("Nota Reprobatoria");
        }
    }

    public void compararPromedioGeneral(String nombre, double nota) {
        System.out.println("\n--- Comparación de una nota con el promedio del curso ---");

        if (!calificaciones.containsKey(nombre)) {
            System.out.println("❌ El estudiante no está registrado.");
            return;
        }

        // Validación del rango de la nota ingresada
        if (!notaValida(nota)) {
            System.out.println("⚠️ La nota ingresada no es válida. Debe estar entre 1.0 y 7.0");
            return;
        }

        // Calcular el promedio general del curso
        double sumaTotal = 0;
        int totalNotas = 0;

        for (ArrayList<Double> notas : calificaciones.values()) {
            for (double n : notas) {
                sumaTotal += n;
                totalNotas++;
            }
        }

        double promedioCurso = sumaTotal / totalNotas;

        // Mostrar resultado
        System.out.printf("Promedio General del Curso: %.2f\n", promedioCurso);
        System.out.println("Estudiante: " + nombre);

        if (Math.abs(nota - promedioCurso) < 0.01) {
            System.out.println("La nota ingresada es IGUAL al promedio del curso.");
        } else if (nota > promedioCurso) {
            System.out.println("La nota ingresada está SOBRE el promedio del curso.");
        } else {
            System.out.println("La nota ingresada está BAJO el promedio del curso.");
        }
    }
            }
