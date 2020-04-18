package com.utn;

public class BeerProducer  extends Thread{

        private BeerHouse contenedor;

        public BeerProducer (BeerHouse c) {
            contenedor = c;
        }

        public void run() {
            for (int i = 0; i < 100; i++) {
                contenedor.put(i);
                System.out.println("Productor. Agrego: " + i);
                try {
                    sleep((int)(Math.random() * 1000));
                } catch (InterruptedException e) { }
            }
        }

}
