package com.utn;

public class BeerHouse {

    private int dato; // Contiene el valor, que se almacena con put() y se devuelve con get()
    private boolean hayDato = false; // Flag (bandera) que indica si el objeto tiene el dato o no.

    // En este método put() antes de almacenar el valor en la variable dato debe asegurarse que el valor anterior ha sido consumido.
    public synchronized void put(int valor) {
        while (hayDato == true) { // Si todavía hay valor se suspende la ejecución del hilo mediante el método wait().
            try {
                /**
                 * Se suspende el hilo indefinidamente hasta que se le envìe una 'señal' con el método notify() o notifyAll()
                 * Cuando la señalización mediante notify() lo produce el método get(), el método continua, asume que el dato
                 * ya fue consumido y posteriormente...
                 **/
                wait();
            } catch (InterruptedException e) {
            }
        }
        // Almacena el valor en dato y notifica que hay un dato disponible.
        dato = valor;
        hayDato = true;
        notifyAll();
    }

    // En este método get() chequea si hay un dato disponible (no lo hay si hayDato es falso)
    public synchronized int get() {
        while (hayDato == false) {
            try {
                /**
                 * Si no hay dato espera hasta que le avisen.
                 * Una vez notificado desde el método put(), posteriormente...
                 **/
                wait();
            } catch (InterruptedException e) {
            }
        }
        // Cambia el valor de la bandera y devuelve el valor. Pero antes, notifica que el dato ya ha sido consumido y que se puede almacenar otro.
        hayDato = false;
        notifyAll();
        return dato;
    }
}
