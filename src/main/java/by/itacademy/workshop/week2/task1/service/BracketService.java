package by.itacademy.workshop.week2.task1.service;

import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Deque;

@Service
public class BracketService {

    public boolean isBracketsCorrect(String code) {
        Deque<Character> brackets = new ArrayDeque<>();

        for (int i = 0; i < code.length(); i++) {
            char symbol = code.charAt(i);
            if (isOpeningBracket(symbol)) {
                brackets.add(symbol);

            } else if (isClosingBracket(symbol)) {
                if (brackets.isEmpty()) {
                    return false;
                } else if (brackets.getLast() == getOpening(symbol)) {
                    brackets.removeLast();
                } else {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }

    private boolean isOpeningBracket(char symbol) {
        switch (symbol) {
            case '(':
            case '[':
            case '{':
                return true;
            default:
                return false;
        }
    }

    private boolean isClosingBracket(char symbol) {
        switch (symbol) {
            case ')':
            case ']':
            case '}':
                return true;
            default:
                return false;
        }
    }

    private char getOpening(char symbol) {
        switch (symbol) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                throw new IllegalArgumentException("Can not handle symbol: " + symbol);
        }
    }
}
