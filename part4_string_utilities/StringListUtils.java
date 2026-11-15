package part4_string_utilities;

import java.util.ArrayList;

// Part 4. StringUtilities
// Хранит предложения в ArrayList<String> и работает со словами в них.
public class StringListUtils {

    // Part 4. Syntax: список предложений
    private final ArrayList<String> sentences = new ArrayList<>();

    // Добавляет предложение в список.
    public void addSentence(String sentence) {
        sentences.add(sentence);
    }

    // Вспомогательный метод: убирает знаки препинания по краям слова,
    // чтобы "world!" считалось словом длиной 5, а не 6.
    private String clean(String word) {
        return word.replaceAll("^[^\\p{L}\\p{N}]+|[^\\p{L}\\p{N}]+$", "");
    }

    // Part 4.1 countWords
    // Считает общее количество слов во всех предложениях.
    public int countWords() {
        int count = 0;
        for (String sentence : sentences) {
            // split("\\s+") делит строку по любым пробелам
            for (String word : sentence.trim().split("\\s+")) {
                if (!clean(word).isEmpty()) {
                    count++;
                }
            }
        }
        return count;
    }

    // Part 4.2 findLongestWord
    // Возвращает самое длинное слово (пустую строку, если слов нет).
    public String findLongestWord() {
        String longest = "";
        for (String sentence : sentences) {
            for (String word : sentence.trim().split("\\s+")) {
                String cleaned = clean(word);
                // Запоминаем слово, если оно длиннее текущего рекордсмена
                if (cleaned.length() > longest.length()) {
                    longest = cleaned;
                }
            }
        }
        return longest;
    }

    // Part 4.3 removeShortWords
    // Удаляет из всех предложений слова короче minLength.
    // Если предложение стало пустым, оно удаляется из списка.
    public void removeShortWords(int minLength) {
        ArrayList<String> updated = new ArrayList<>();
        for (String sentence : sentences) {
            StringBuilder builder = new StringBuilder();
            for (String word : sentence.trim().split("\\s+")) {
                // Оставляем только достаточно длинные слова
                if (clean(word).length() >= minLength) {
                    if (builder.length() > 0) {
                        builder.append(' '); // пробел между словами
                    }
                    builder.append(word);
                }
            }
            if (builder.length() > 0) {
                updated.add(builder.toString());
            }
        }
        // Заменяем старый список новым
        sentences.clear();
        sentences.addAll(updated);
    }

    // Вспомогательный метод: печатает предложения с индексами.
    public void displaySentences() {
        if (sentences.isEmpty()) {
            System.out.println("No sentences.");
            return;
        }
        for (int i = 0; i < sentences.size(); i++) {
            System.out.println(i + ": " + sentences.get(i));
        }
    }

    public static void main(String[] args) {
        StringListUtils utils = new StringListUtils();

        // Part 4.1 Add sentences: добавляем три предложения
        utils.addSentence("Java is a popular programming language.");
        utils.addSentence("ArrayList makes working with collections easy!");
        utils.addSentence("I am learning to code.");

        System.out.println("=== Part 4.1 Original sentences ===");
        utils.displaySentences();

        // Part 4.2 Count words: общее количество слов
        System.out.println("\n=== Part 4.2 Count words ===");
        System.out.println("Total words: " + utils.countWords());

        // Part 4.3 Find the longest word: самое длинное слово
        System.out.println("\n=== Part 4.3 Longest word ===");
        System.out.println("Longest word: " + utils.findLongestWord());

        // Part 4.4 Remove short words: убираем слова короче 4 символов
        System.out.println("\n=== Part 4.4 Remove words shorter than 4 ===");
        utils.removeShortWords(4);
        utils.displaySentences();
        System.out.println("Total words now: " + utils.countWords());
    }
}