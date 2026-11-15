package part3_student_grades;

import java.util.ArrayList;
import java.util.Collections;

// Part 3. StudentGrades
// Хранит оценки студента в ArrayList<Double>.
public class StudentGrades {

    // Part 3. Syntax: список оценок
    private final ArrayList<Double> grades = new ArrayList<>();

    // Part 3.1 addGrade
    // Добавляет оценку в список.
    public void addGrade(double grade) {
        grades.add(grade);
    }

    // Part 3.2 getGradesAbove
    // Возвращает новый список оценок, которые строго больше порога.
    public ArrayList<Double> getGradesAbove(double threshold) {
        ArrayList<Double> result = new ArrayList<>();
        for (double grade : grades) {
            if (grade > threshold) {
                result.add(grade); // подходящую оценку кладём в результат
            }
        }
        return result;
    }

    // Part 3.3 getAverageGrade
    // Средняя оценка: сумма / количество.
    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0; // защита от деления на ноль
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    // Part 3.4 removeLowestGrade
    // Удаляет наименьшую оценку (только одну, если есть повторы).
    public void removeLowestGrade() {
        if (grades.isEmpty()) {
            return;
        }
        // Сначала находим минимум, потом удаляем его по значению
        grades.remove(Collections.min(grades));
    }

    // Вспомогательный метод: возвращает копию списка оценок,
    // чтобы снаружи нельзя было изменить внутренний список.
    public ArrayList<Double> getGrades() {
        return new ArrayList<>(grades);
    }

    public static void main(String[] args) {
        StudentGrades studentGrades = new StudentGrades();

        // Part 3.1 Add several grades: добавляем несколько оценок
        studentGrades.addGrade(78.5);
        studentGrades.addGrade(92.0);
        studentGrades.addGrade(65.0);
        studentGrades.addGrade(88.5);
        studentGrades.addGrade(54.0);
        studentGrades.addGrade(95.5);

        // Part 3.2 Print all grades: выводим все оценки
        System.out.println("=== Part 3.2 All grades ===");
        System.out.println(studentGrades.getGrades());

        // Part 3.3 Print average grade: выводим среднюю оценку
        double average = studentGrades.getAverageGrade();
        System.out.println("\n=== Part 3.3 Average grade ===");
        System.out.printf("Average: %.2f%n", average);

        // Part 3.4 Print grades above average: оценки выше среднего
        System.out.println("\n=== Part 3.4 Grades above average ===");
        System.out.println(studentGrades.getGradesAbove(average));

        // Part 3.5 Remove the lowest grade: удаляем минимальную оценку и печатаем список
        studentGrades.removeLowestGrade();
        System.out.println("\n=== Part 3.5 After removing the lowest grade ===");
        System.out.println(studentGrades.getGrades());
    }
}