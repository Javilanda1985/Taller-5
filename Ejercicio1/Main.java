package Ejercicio1;

import java.util.Scanner;

public class Main extends Thread {

    public static void main(String[] args){

        Scanner sc  = new Scanner(System.in);
        System.out.print("Hilos a ejecutar: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            new Thread(" " + i ) {

                @Override
                public void run(){
                    System.out.println("Inicia hilo"+ getName());
                    int cont = 0;
                    for (int j = 1; j <= 100; j++){
                         cont = cont + 1;
                        System.out.println("Hilo"+ getName() +" -> Contador de incremento: " + cont);
                    }
                    System.out.println("Termina hilo "+ getName());
                }

            }.start();
        }

    }
}
