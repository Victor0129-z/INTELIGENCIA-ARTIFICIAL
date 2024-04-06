package Perceptron;

import java.util.ArrayList;

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


    public void entrenamiento(String nombre) {

    }
}
