
package perceptron1;


public class Perceptron1 {

    Neurona n;
    double[] X = {2.0, 1.0, 3.0}; // vector entrada
    double[] W = {0.5, 0.4, 0.3}; // vector Salida

    public Perceptron1() {
        n = new Neurona(X, W);
        n.Solucion();
        System.out.println("La solucion es: " + n.getNET());
    }

    public static void main(String[] args) {
        new Perceptron1();
    }
}
