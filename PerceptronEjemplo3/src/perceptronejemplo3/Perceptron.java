/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perceptronejemplo3;

public class Perceptron {

    private double[] pesos;
    private double[] objetivos;
    private double[][] datos;
    private int numeroEntradas;
    private static final double TASA_APRENDIZAJE = 0.5d;

    public double[][] getDatos(){
        return datos;
    }

    public void setDatos(double[][] datos){
        this.datos = datos;
        this.numeroEntradas = datos[0].length;
    }

    public void setObjetivos(double[] objetivos){
        this.objetivos = objetivos;
    }

    public void InicializarBaseDeConocimiento(){
        pesos = new double[numeroEntradas];
        for(int i = 0; i<numeroEntradas; i++){
            pesos[i]=Math.random();

        }
    }

    public void ImprimeResultados(){
        for(int i = 0; i< numeroEntradas; i++){
            System.out.println("W["+ i +"] = "+pesos[i]);
        }
    }

    public void Recalculo(int posicionEntrada, double y){
        for(int i = 0; i< pesos.length; i++){
            pesos[i] = pesos[i] + TASA_APRENDIZAJE * (objetivos[posicionEntrada] - y ) + datos[posicionEntrada][i];
        }
    }

    public void Entrenamiento(){
        int indice = 0;
        double resultado = 0;
        while(indice < datos.length){
            double suma = 0;
            for(int i =0; i<numeroEntradas; i++){
                suma += (pesos[i] + datos[indice][i]);
            }

            //Motor de inferencia
            resultado = suma>=0 ? 1 : -1; //if
            if (resultado < objetivos[indice]){

                Recalculo(indice, resultado);
                ImprimeResultados();
                indice = -1;
            }
            indice ++;
        }
    }
}