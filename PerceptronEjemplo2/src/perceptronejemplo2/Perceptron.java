package perceptronejemplo2;

public class Perceptron {

    double[] peso;
    double limite;

    public Perceptron(int numeroEntrada) {
        peso = new double[numeroEntrada];
        for (int i = 0; i < numeroEntrada; i++) {
            peso[i] = Math.random();
        }
        limite = Math.random();
    }

    public int alimentar(double[] numeroEntrada) {
        double suma = 0;
        for (int i = 0; i < numeroEntrada.length; i++) {
            suma += numeroEntrada[i] * peso[i];
        }
        if (suma > limite) {
            return 1;
        } else {
            return 0;
        }
    }

    public void entrenamiento(double[][] array_entradas, int[] array_salidas, double tasa_aprendizaje) {
        for (int i = 0; i < array_entradas.length; i++) {
            int salida = alimentar(array_entradas[i]);
            double error = array_salidas[i] - salida;
            for (int j = 0; j < peso.length; j++) {
                peso[j] += tasa_aprendizaje * error
                        * array_entradas[i][j];
            }
            limite += tasa_aprendizaje * error;
        }
    }
}
