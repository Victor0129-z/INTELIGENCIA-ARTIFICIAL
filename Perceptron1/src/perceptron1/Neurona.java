package perceptron1;
public class Neurona {

    double[] X;
    double[] W;
    double NET;

    public Neurona(double[] X, double[] W) {
        this.X = X;
        this.W = W;
        this.NET = 0.0;
    }

    public void Solucion() {
        for (int i = 0; i < this.X.length; i++) {
            NET += this.X[i] * this.W[i]; // NET = X*W
        }
    }

    public double getNET() {
        return this.NET;
    }
}
