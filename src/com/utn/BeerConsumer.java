package com.utn;

public class BeerConsumer extends  Thread
{

        private BeerHouse contenedor;

        public BeerConsumer (BeerHouse c) {
            contenedor= c;
        }

        public void run() {
            int value = 0;
            for (int i = 0; i < 100; i++) {
                value = contenedor.get();
                System.out.println("Consumidor. Tomo: " + value);
            }
        }
}

