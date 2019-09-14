package by.itacademy.workshop.week5.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static by.itacademy.workshop.week5.util.CompetitionsRules.DAY_LENGTH;
import static by.itacademy.workshop.week5.util.CompetitionsRules.NIGHTS_NUMBER;
import static by.itacademy.workshop.week5.util.CompetitionsRules.randomDetail;
import static by.itacademy.workshop.week5.util.CompetitionsRules.randomDetailNumber;

@Getter
@RequiredArgsConstructor
public class Factory implements Runnable {

    private final String name;
    private final Dump dump;

    @Override
    public void run() {
        for (int i = 0; i < NIGHTS_NUMBER; i++) {
            produceSmth();
        }
    }

    private void produceSmth() {
        synchronized (dump) {
            for (int i = 0; i < randomDetailNumber(); i++) {
                Detail detail = randomDetail();
                dump.getDetails().add(detail);
                System.out.println(name + " threw out one " + detail);
            }

            try {
                dump.wait(DAY_LENGTH);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            dump.notifyAll();
        }
    }
}
