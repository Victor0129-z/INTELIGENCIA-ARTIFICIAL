package perceptronejemplo3;

import java.util.Timer;
import java.util.TimerTask;

public class main {
    private Perceptron p;

    public main() {
        double[] objetivos = {1, 2, 3, 4};
        double[][] datos = {{0, 1, 0}, {1, 0, 1}, {1, 1, 0}, {1, 0, 0}};
        p = new Perceptron();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int x = 0;

            @Override
            public void run() {
                if (x < 50) {
                    p.setDatos(datos);
                    p.setObjetivos(objetivos);
                    p.InicializarBaseDeConocimiento();
                    p.Entrenamiento();
                    System.out.println("Procesando informacion espere....." + "Actividades: " + x + "-50");
                    x++;
                } else {
                    timer.cancel(); // Cancelamos el temporizador cuando x llega a 50
                }
            }
        }, 0, 1000); // Ejecuta la tarea cada 1 segundo (1000 milisegundos)
    }

    public static void main(String[] args) {
        new main();
    }
}
