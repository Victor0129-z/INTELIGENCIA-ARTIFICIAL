package Perceptron;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Neurona {

    String[] X;
    String[] W;
    ArrayList<String> silabas = new ArrayList<>();

    public Neurona(String[] X, String[] W) {
        this.X = X;
        this.W = W;
        
        alimentar();
    }

    public final int alimentar() {
        silabas.clear();

        // Generar sílabas de 2 caracteres (consonante+vocal)
        for (String consonante : X) {
            for (String vocal : W) {
                // Evitar sílabas terminadas en "q" seguidas de "u"
                if (!(consonante.equals("q") && vocal.equals("u"))) {
                    // Evitar sílabas con consonantes "h" o "ñ" seguidas de vocal
                    if (!(consonante.equals("ñ") || consonante.equals("h"))) {
                        silabas.add(consonante + vocal);
                    }
                }
            }
        }

        // Generar sílabas de 3 caracteres (consonante-vocal-consonante)
        for (String consonante1 : X) {
            for (String vocal : W) {
                for (String consonante2 : X) {
                    if (!((consonante1.equals("ñ") && consonante2.equals("h")) || (consonante1.equals("h") && consonante2.equals("ñ")))) {
                        if (!(consonante1.equals("ñ") || consonante1.equals("h"))) {
                            silabas.add(consonante1 + vocal + consonante2);
                        }
                    }
                }
            }
        }

        // Generar sílabas de 3 caracteres (consonante-consonante-vocal)
        for (String consonante1 : X) {
            for (String consonante2 : X) {
                for (String vocal : W) {
                    // Evitar sílabas con "ñ" seguida de "h" y viceversa
                    if (!((consonante1.equals("ñ") && consonante2.equals("h")) || (consonante1.equals("h") && consonante2.equals("ñ")))) {
                        if (!(consonante1.equals("ñ") || consonante1.equals("h"))) {
                            silabas.add(consonante1 + consonante2 + vocal);
                        }
                    }
                }
            }
        }

         // Generar sílabas de 3 caracteres (consonante-vocal-vocal)
        for (String consonante : X) {
            for (String vocal1 : W) {
                for (String vocal2 : W) {
                    if (!(consonante.equals("ñ") || consonante.equals("h"))) {
                        silabas.add(consonante + vocal1 + vocal2);
                    }
                }
            }
        }
        return 0;
    }

    public void entrenamiento(JTextArea textArea, String nombre) {
        Random random = new Random();
        int[] iteracion = {0};
        
        while (true) {
            // Generamos el número de sílabas que formarán la combinación (2)
            int numSilabas = 2;
            int indice;
            
            // Creamos una lista para almacenar las sílabas seleccionadas
            StringBuilder combinacion = new StringBuilder();
            // Generamos una combinación aleatoria de sílabas

            
            for (int i = 0; i < numSilabas; i++) {
                // Seleccionamos un índice aleatorio
                indice = random.nextInt(silabas.size());
                // Concatenamos la sílaba correspondiente al índice
                combinacion.append(silabas.get(indice));
            }
            
            // Imprimimos la combinación actual
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    textArea.append("Palabra actual: " + combinacion + " - " + iteracion[0] + "\n");
                    System.out.println(".run()");
                }
            });
            //System.out.println("Palabra actual: " + combinacion + " - " + iteracion[0] + "\n");
            
            // Revisamos si la combinación forma la palabra deseada
            if (combinacion.toString().equals(nombre)) {
                // Actualizar la interfaz gráfica desde el hilo de eventos de Swing
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        textArea.append("Palabra encontrada: " + combinacion.toString() + " - " + iteracion[0] + "\n");
                    }
                });
                break;
            }
            iteracion[0]++;
        }
    }
}
