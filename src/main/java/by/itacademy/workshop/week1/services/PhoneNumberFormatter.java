package by.itacademy.workshop.services;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneNumberFormatter {

    private static final String PHONE_REGEX = "(\\d{3})(\\d{3})(\\d+)";
    private static final String REPLACEMENT = "($1) $2-$3";

    public String formatWithRegex(List<Integer> input) {
        String number = input.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        return number.replaceFirst(PHONE_REGEX, REPLACEMENT);
    }

    public String formatWithoutRegex(List<Integer> input) {
        LinkedList<String> number = input.stream()
                .map(String::valueOf)
                .collect(Collectors.toCollection(LinkedList::new));

        number.add(0, "(");
        number.add(4, ")");
        number.add(5, " ");
        number.add(9, "-");

        return String.join("", number);
    }
}
