
package perceptronejemplo3;

public class main {
    Perceptron p;

    public main() throws InterruptedException {
        double[] objetivos = { 1, 2, 3, 4 };
        double[][] datos = { { 0, 1, 0 }, { 1, 0, 1 }, { 1, 1, 0 }, { 1, 0, 0 } };
        p = new Perceptron();
        int x = 0;
        while (x < 50) {
            p.setDatos(datos);
            p.setObjetivos(objetivos);
            p.InicializarBaseDeConocimiento();
            p.Entrenamiento();
            System.out.println("Procesando informacion espere....." + "Actividades: " + x + "-50");
            Thread.sleep(1000);
            x++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new main();
    }

}
