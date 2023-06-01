package org.example;

import java.util.*;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите последовательность скобок:");
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        System.out.println(isValidBrackets(String.valueOf(text)));
    }
    public static boolean isValidBrackets(String input) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        Deque<Character> stack = new LinkedList<>();
        for (char symbol : input.toCharArray()) {
            if (brackets.containsValue(symbol)) {
                // одна из открывающих скобок
                stack.push(symbol);
            } else if (brackets.containsKey(symbol)) {
                // одна из закрывающих скобок
                if (stack.isEmpty() || stack.pop() != brackets.get(symbol)) {
                    return false;
                }
            }
        }
// Проверка наличия элементов в стеке
        return stack.isEmpty();
    }
}
