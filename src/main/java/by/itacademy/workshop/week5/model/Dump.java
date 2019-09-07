package by.itacademy.workshop.week5.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static by.itacademy.workshop.week5.util.CompetitionsRules.FIRST_NIGHT_DETAIL_NUMBER;
import static by.itacademy.workshop.week5.util.CompetitionsRules.randomDetail;

@Getter
public class Dump {

    private String address;
    private List<Detail> details = new ArrayList<>();

    public Dump(String address) {
        this.address = address;
        fillByDetails();
    }

    private void fillByDetails() {
        for (int i = 0; i < FIRST_NIGHT_DETAIL_NUMBER; i++) {
            details.add(randomDetail());
        }
    }
}
