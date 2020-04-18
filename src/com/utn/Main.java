package com.utn;

public class Main {

    public static void main(String[] args) {
        BeerHouse c = new BeerHouse();
        BeerProducer produce = new BeerProducer (c);
        BeerConsumer consumidor1 = new BeerConsumer(c);
        BeerConsumer consumidor2 = new BeerConsumer(c);

        produce.start();
        consumidor1.start();
        consumidor2.start();
    }
}
