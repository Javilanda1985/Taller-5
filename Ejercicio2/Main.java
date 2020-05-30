package Ejercicio2;

import java.util.Random;

public class Main extends Thread {
    static int[] num_max;
    static int[] num_ale;

    public static void main(String[] args) {
        Random r = new Random(1);
        int n = 10;//Cantidad de hilos
        int cant = 1000;//Cantidad de numeros aleatorios a generar
        int m = cant / n;
        num_ale = new int[cant];
        num_max = new int[n];

        //Se generan 1000 numeros aleatorios y se guardan en un vector
        System.out.println("Numeros aleatorios");
        for (int i = 0; i < cant; i++) {
            num_ale[i] = r.nextInt(9999);
            System.out.println("" + num_ale[i]);
        }
        System.out.println("");
        System.out.println("Inicia hilos...........");
        System.out.println("Valor mayor por hilo...");
        Thread[] hilos = new Thread[n];
        for (int i = 0; i < n; i++) {
            hilos[i] = new Thread("" + i) {

                @Override
                public void run() {
                    int cont = Integer.parseInt(getName());
                    int max = 0;
                    //System.out.println("Inicia hilo "+ getName());
                    for (int j = cont * m; j < (cont + 1) * m; j++) {
                        if (num_ale[j] > max) {
                            max = num_ale[j];
                        }
                    }
                    num_max[cont] = max;
                    System.out.println("Hilo " + getName() + " = " + num_max[cont]);
                    //System.out.println("Termina hilo "+ getName());
                }
            };
            hilos[i].start();
        }
        try {
            for (int i = 0; i < n; i++) {
                hilos[i].join();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        int max = 0;
        for (int j = 0; j < n; j++) {
            if (num_max[j] > max) {
                max = num_max[j];
            }
        }
        System.out.println("");
        System.out.println("Maximo valor es = " + max);
    }
}