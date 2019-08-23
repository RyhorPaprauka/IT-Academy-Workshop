package by.itacademy.workshop.week2.task3.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DominantElement {

    public int findDominantLogN(List<Integer> list) {
        Collections.sort(list);
        return list.get(list.size() / 2);
    }

    public int findDominantN(List<Integer> list) {
        int bound_value = list.size() / 2;
        Map<Integer, Integer> counter = new HashMap<>(list.size());

        for (int digit : list) {
            if (counter.containsKey(digit)) {
                counter.put(digit, counter.get(digit) + 1);
                if (counter.get(digit) > bound_value) {
                    return digit;
                }
            } else {
                counter.put(digit, 1);
            }
        }
        throw new IllegalArgumentException();
    }
}
