package by.itacademy.workshop.week5.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class CrazyScientist {

    private final String name;
    private Map<Detail, Integer> details = new HashMap<>();

    public int compiledRobotsNumber() {
        return getDetails().size() != Detail.values().length ? 0 : Collections.min(getDetails().values());
    }
}
