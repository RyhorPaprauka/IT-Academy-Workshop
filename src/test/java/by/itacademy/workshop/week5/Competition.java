package by.itacademy.workshop.week5;

import by.itacademy.workshop.BaseTest;
import by.itacademy.workshop.week5.model.CrazyScientist;
import by.itacademy.workshop.week5.model.Dump;
import by.itacademy.workshop.week5.model.Factory;
import by.itacademy.workshop.week5.model.Minion;
import org.junit.Test;

import static by.itacademy.workshop.week5.util.CompetitionsRules.findTheWinner;

public class Competition extends BaseTest {

    @Test
    public void competition() throws InterruptedException {
        CrazyScientist mad = new CrazyScientist("Mad");
        CrazyScientist bad = new CrazyScientist("Bad");

        Dump dump = new Dump("Chizouka");
        Factory factory = new Factory("Robot Factory", dump);

        Minion mads = new Minion("Mad's minion", mad, dump);
        Minion bads = new Minion("Bad's minion", bad, dump);

        Thread factoryThread = new Thread(factory);
        Thread madsThread = new Thread(mads);
        Thread badsThread = new Thread(bads);

        factoryThread.start();
        madsThread.start();
        badsThread.start();

        factoryThread.join();
        madsThread.join();
        badsThread.join();

        findTheWinner(mad, bad);
    }
}
