package by.itacademy.workshop.week5.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static by.itacademy.workshop.week5.util.CompetitionsRules.NIGHTS_NUMBER;
import static by.itacademy.workshop.week5.util.CompetitionsRules.randomDetailFromDump;
import static by.itacademy.workshop.week5.util.CompetitionsRules.randomDetailNumber;

@Getter
@RequiredArgsConstructor
public class Minion implements Runnable {

    private final String name;
    private final CrazyScientist lord;
    private final Dump dump;
    private final List<Detail> bag = new ArrayList<>();

    @Override

    public void run() {
        for (int i = 0; i < NIGHTS_NUMBER; i++) {
            serve();
        }
    }

    private void serve() {
        synchronized (dump) {
            for (int i = 0; i < randomDetailNumber(); i++) {
                if (dump.getDetails().size() > 0) {
                    Detail detail = randomDetailFromDump(dump);
                    bag.add(detail);
                    dump.getDetails().remove(detail);
                    System.out.println(name + " found  the " + detail);
                } else break;
            }

            passToLord();

            try {
                dump.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void passToLord() {
        bag.stream()
                .peek(detail -> lord.getDetails()
                        .merge(detail, 1, (oldVal, newVal) -> oldVal + newVal))
                .forEach(detail -> System.out.println(name + " passes " + detail + " to his lord"));
        bag.clear();
    }
}
