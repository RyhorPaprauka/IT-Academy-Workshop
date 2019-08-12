package by.itacademy.workshop.services;

import by.itacademy.workshop.entity.Banknote;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static by.itacademy.workshop.entity.Banknote.FIFTY_DOLL;
import static by.itacademy.workshop.entity.Banknote.TWENTYFIFE_DOLL;

@Service
public class Clerk {

    private static final int THREE_BANKNOTES = 3;
    private static final int TWO_BANKNOTES = 2;


    public boolean serveQueue(List<Banknote> queue) {
        for (int i = 0; i < queue.size(); i++) {
            List<Banknote> cashbox = queue.subList(0, i);

            switch (queue.get(i)) {
                case FIFTY_DOLL:
                    if (cashbox.remove(TWENTYFIFE_DOLL)) {
                        i--;
                    } else return false;
                    break;

                case HUNDRED_DOLL:
                    int changeSize = changeFrom100(cashbox);
                    if (changeSize > 0) {
                        i -= changeSize;
                    } else return false;
                    break;
            }
        }
        return true;
    }

    private int changeFrom100(List<Banknote> cashbox) {
        if (cashbox.contains(TWENTYFIFE_DOLL)) {
            if (Collections.frequency(cashbox, TWENTYFIFE_DOLL) >= THREE_BANKNOTES) {
                for (int i = 0; i < THREE_BANKNOTES; i++) {
                    cashbox.remove(TWENTYFIFE_DOLL);
                }
                return THREE_BANKNOTES;
            } else if (cashbox.contains(FIFTY_DOLL)) {
                cashbox.remove(FIFTY_DOLL);
                cashbox.remove(TWENTYFIFE_DOLL);
            }
            return TWO_BANKNOTES;
        } else return 0;
    }
}
