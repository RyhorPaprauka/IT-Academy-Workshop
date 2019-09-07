package by.itacademy.workshop.week5.util;

import by.itacademy.workshop.week5.model.CrazyScientist;
import by.itacademy.workshop.week5.model.Detail;
import by.itacademy.workshop.week5.model.Dump;

import java.util.Random;

public final class CompetitionsRules {

    public static final int NIGHTS_NUMBER = 100;
    public static final int DAY_LENGTH = 100;
    public static final int FIRST_NIGHT_DETAIL_NUMBER = 20;
    private static final Random RANDOM = new Random();
    private static final int DETAIL_MAX_NUMBER = 4;

    public static int randomDetailNumber() {
        return RANDOM.nextInt(DETAIL_MAX_NUMBER) + 1;
    }

    public static Detail randomDetail() {
        return Detail.values()[RANDOM.nextInt(Detail.values().length)];
    }

    public static Detail randomDetailFromDump(Dump dump) {
        return dump.getDetails().get(RANDOM.nextInt(dump.getDetails().size()));
    }

    public static void findTheWinner(CrazyScientist first, CrazyScientist second) {
        if (first.compiledRobotsNumber() > second.compiledRobotsNumber()) {
            System.out.println("The winner is " + first.getName());
        } else if (second.compiledRobotsNumber() > first.compiledRobotsNumber()) {
            System.out.println("The winner is " + second.getName());
        } else {
            System.out.println("They are both equally crazy");
        }
    }
}
