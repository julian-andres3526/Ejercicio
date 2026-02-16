import javax.swing.JOptionPane;

public class Ejercicio {

    public static void main(String[] args) {
        // 1. Crear un arreglo de notas (ingresado por el usuario)
        int cantidadNotas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de notas"));
        double[] notas = new double[cantidadNotas];

        // 2. Inicializar el arreglo con las notas ingresadas por el usuario
        for (int i = 0; i < cantidadNotas; i++) {
            notas[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la nota #" + (i + 1)));
        }

        // 3. Calcular la nota definitiva
        double notaDefinitiva = calcularNotaDefinitiva(notas);

        // 4. Obtener la nota mayor
        double notaMayor = obtenerNotaMayor(notas);

        // 5. Obtener la nota menor
        double notaMenor = obtenerNotaMenor(notas);

        // 6. Ordenar el arreglo con burbuja
        ordenarBurbuja(notas);

        // 7. Mostrar el resumen de notas
        StringBuilder resumen = new StringBuilder("Resumen de notas:\n");
        resumen.append("Notas ordenadas: ");
        for (double nota : notas) {
            resumen.append(nota).append(" ");
        }
        resumen.append("\nNota definitiva: ").append(notaDefinitiva);
        resumen.append("\nNota mayor: ").append(notaMayor);
        resumen.append("\nNota menor: ").append(notaMenor);

        // 8. Funcionalidad distinta: contar cuántas notas son mayores o iguales a 3.0 
        int aprobadas = contarAprobadas(notas);
        resumen.append("\nCantidad de notas aprobadas: ").append(aprobadas);

        JOptionPane.showMessageDialog(null, resumen.toString());
    }

    public static double calcularNotaDefinitiva(double [] notas){
        double notaDefinitiva = 0;
        double suma = 0;

        for(int i = 0; i < notas.length; i++){
            suma += notas[i];
        }
        notaDefinitiva = suma / notas.length;
        return notaDefinitiva;
    }

    public static double obtenerNotaMayor(double[] notas) {
        double notaMayor = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > notaMayor) {
                notaMayor = notas[i];
            }
        }
        return notaMayor;
    }

    public static double obtenerNotaMenor(double[] notas) {
        double notaMenor = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < notaMenor) {
                notaMenor = notas[i];
            }
        }
        return notaMenor;
    }

    public static void ordenarBurbuja(double[] notas) {
        for (int i = 0; i < notas.length - 1; i++) {
            for (int j = 0; j < notas.length - 1 - i; j++) {
                if (notas[j] > notas[j + 1]) {
                    double temp = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = temp;
                }
            }
        }
    }

    // Nueva funcionalidad: contar cuántas notas son aprobadas
    public static int contarAprobadas(double[] notas) {
        int contador = 0;
        for (double nota : notas) {
            if (nota >= 3.0) {
                contador++;
            }
        }
        return contador;
    }
}
