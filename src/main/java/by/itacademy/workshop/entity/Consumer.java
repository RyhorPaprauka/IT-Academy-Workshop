package by.itacademy.workshop.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Consumer extends Thread {

    private Semaphore semaphore;
    private String name;
    private List<Product> cart = new ArrayList<>();

    public Consumer(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            for (Product product : cart) {
                Thread.sleep(1000);
                cart.remove(product);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            semaphore.release();
        }
    }

    public void addProduct(Product product) {
        this.cart.add(product);
    }
}
