package by.itacademy.workshop.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCombiner {

    public void sortTwoLists(List<Integer> firstList, List<Integer> secondList) {
        int i = 0;
        int j = 0;

        while (i < firstList.size() && j < secondList.size()) {
            if (firstList.get(i) > secondList.get(j)) {
                firstList.add(i, secondList.get(j));
                j++;
                i++;
            } else i++;
        }

        firstList.addAll(secondList.subList(j,
                secondList.size()));
    }
}


