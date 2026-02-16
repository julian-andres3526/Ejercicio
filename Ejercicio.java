import javax.swing.JOptionPane;

public class Ejercicio {

    public static void main(String[] args) {
        int cantidadNotas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de notas"));
        double[] notas = new double[cantidadNotas];

        for (int i = 0; i < cantidadNotas; i++) {
            notas[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la nota #" + (i + 1)));
        }

        double notaDefinitiva = calcularNotaDefinitiva(notas);
        double notaMayor = obtenerNotaMayor(notas);
        double notaMenor = obtenerNotaMenor(notas);
        ordenarBurbuja(notas);
        
        StringBuilder resumen = new StringBuilder("Resumen de notas:\n");
        resumen.append("Notas ordenadas: ");
        for (double nota : notas) {
            resumen.append(nota).append(" ");
        }
        resumen.append("\nNota definitiva: ").append(notaDefinitiva);
        resumen.append("\nNota mayor: ").append(notaMayor);
        resumen.append("\nNota menor: ").append(notaMenor);

        // Funcionalidad distinta: contar cuántas notas son mayores o iguales a 3.0 
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
