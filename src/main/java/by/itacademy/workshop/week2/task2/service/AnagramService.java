package by.itacademy.workshop.week2.task2.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

@Service
public class AnagramService {

    public Object[] findAnagrams(String[] words) {
        Map<String, SortedSet<String>> map = new LinkedHashMap<>();

        for (String word : words) {
            String key = sortCharsAlphabetical(word);

            if (map.get(key) == null) {
                SortedSet<String> anagrams = new TreeSet<>();
                anagrams.add(word);
                map.put(key, anagrams);
            } else {
                map.get(key).add(word);
            }
        }
        return map.values().stream()
                .map(SortedSet::toArray)
                .toArray();
    }

    private String sortCharsAlphabetical(String word) {
        return word.toLowerCase().chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
