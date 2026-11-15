package part2_number_analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// Part 2. Number Analysis
// Хранит целые числа в ArrayList<Integer> и считает простую статистику.
public class NumberAnalyzer {

    // Part 2. Syntax: список чисел (обёртка Integer, т.к. в ArrayList нельзя int)
    private final ArrayList<Integer> numbers = new ArrayList<>();

    // Part 2.1 addNumber
    // Добавляет число в список (int автоматически упаковывается в Integer).
    public void addNumber(int n) {
        numbers.add(n);
    }

    // Part 2.2 getAverage
    // Среднее арифметическое: сумма / количество.
    public double getAverage() {
        if (numbers.isEmpty()) {
            return 0.0; // защита от деления на ноль
        }
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        // Приводим sum к double, чтобы деление не было целочисленным
        return (double) sum / numbers.size();
    }

    // Part 2.3 getMax
    // Максимальное число в списке.
    public int getMax() {
        if (numbers.isEmpty()) {
            throw new IllegalStateException("The list is empty.");
        }
        return Collections.max(numbers); // готовый метод поиска максимума
    }

    // Part 2.4 getMin
    // Минимальное число в списке.
    public int getMin() {
        if (numbers.isEmpty()) {
            throw new IllegalStateException("The list is empty.");
        }
        return Collections.min(numbers); // готовый метод поиска минимума
    }

    // Part 2.5 removeNegativeNumbers
    // Удаляет все отрицательные числа.
    public void removeNegativeNumbers() {
        // removeIf удаляет все элементы, для которых условие true
        numbers.removeIf(n -> n < 0);
    }

    // Вспомогательный метод: печатает список и статистику.
    public void printResults(String title) {
        System.out.println(title);
        System.out.println("Numbers: " + numbers);
        if (numbers.isEmpty()) {
            System.out.println("The list is empty, no statistics available.");
            return;
        }
        System.out.printf("Average: %.2f%n", getAverage()); // 2 знака после запятой
        System.out.println("Max: " + getMax());
        System.out.println("Min: " + getMin());
    }

    public static void main(String[] args) {
        NumberAnalyzer analyzer = new NumberAnalyzer();
        Random random = new Random();

        // Part 2.1 Fill the list: 12 случайных чисел в диапазоне [-50; 50]
        for (int i = 0; i < 12; i++) {
            // nextInt(101) даёт 0..100, вычитаем 50 и получаем -50..50
            analyzer.addNumber(random.nextInt(101) - 50);
        }
        // Гарантируем, что в списке есть хотя бы одно отрицательное число
        analyzer.addNumber(-7);

        // Part 2.2 Results before removing negatives: результаты до удаления
        analyzer.printResults("=== Part 2.2 Before removing negatives ===");

        // Part 2.3 Remove negatives: убираем отрицательные числа
        analyzer.removeNegativeNumbers();

        // Part 2.4 Results after removing negatives: результаты после удаления
        System.out.println();
        analyzer.printResults("=== Part 2.4 After removing negatives ===");
    }
}