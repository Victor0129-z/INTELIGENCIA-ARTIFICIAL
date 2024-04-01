/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package perceptron1;

/**
 *
 * @author manue
 */
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
