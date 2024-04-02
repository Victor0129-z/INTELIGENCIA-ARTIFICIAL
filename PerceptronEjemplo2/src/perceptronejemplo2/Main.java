package perceptronejemplo2;

import java.util.Arrays;

public class Main {

    double[][] entradas = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
    int[] salida1 = {0, 1, 1, 0};
    int[] salida2 = {1, 0, 0, 1};

    public Main() {
        Perceptron p1 = new Perceptron(2);
        Perceptron p2 = new Perceptron(2);
        for (int i = 0; i < 100; i++) {
// entrada , salida, tasa de aprendizaje
            p1.entrenamiento(entradas, salida1, 0.01);
            p2.entrenamiento(entradas, salida2, 0.01);
        }

        System.out.println("Perceptron 1:");
        System.out.println("Peso: " + Arrays.toString(p1.peso));
        System.out.println("Limite: " + p1.limite);

        System.out.println("Perceptron 2:");
        System.out.println("Peso: " + Arrays.toString(p2.peso));
        System.out.println("Limite: " + p2.limite);
    }

    public static void main(String[] args) {
        new Main();
    }
}
