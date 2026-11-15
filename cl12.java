import java.util.ArrayList;
import java.util.Scanner;

// Basics of Collections: создание, изменение и поиск в ArrayList<String>
public class cl12 {

    public static void main(String[] args) {

        // Part 1. Create and Populate the List
        // Part 1.1 Создаём список students
        ArrayList<String> students = new ArrayList<>();

        // Part 1.2 Добавляем шесть имён
        students.add("Anna");
        students.add("Oleg");
        students.add("Maria");
        students.add("Ivan");
        students.add("Sofia");
        students.add("Denys");

        // Part 1.3 Выводим все имена
        System.out.println("=== Part 1. Initial list ===");
        System.out.println(students);

        // Part 2. Modify the List
        // Part 2.1 Добавляем ещё одно имя в конец списка
        students.add("Taras");
        System.out.println("\n=== Part 2.1 Added to the end ===");
        System.out.println(students);

        // Part 2.2 Вставляем имя на индекс 2 (остальные элементы сдвигаются вправо)
        students.add(2, "Nina");
        System.out.println("\n=== Part 2.2 Inserted at index 2 ===");
        System.out.println(students);

        // Part 2.3 Заменяем студента с индексом 4 новым именем
        students.set(4, "Pavlo");
        System.out.println("\n=== Part 2.3 Replaced at index 4 ===");
        System.out.println(students);

        // Part 2.4 Удаляем одного студента по имени
        students.remove("Oleg");
        System.out.println("\n=== Part 2.4 Removed by name ===");
        System.out.println(students);

        // Part 3. Search and Check
        // Part 3.1 Просим пользователя ввести имя
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Part 3. Search ===");
        System.out.print("Enter a name: ");
        String name = scanner.nextLine().trim();

        // Part 3.2 Проверяем, есть ли имя в списке, с помощью contains()
        if (students.contains(name)) {
            // Part 3.3 Если есть, выводим индекс (indexOf возвращает позицию)
            System.out.println("Found at index " + students.indexOf(name));
        } else {
            // Part 3.4 Если нет, сообщаем об этом
            System.out.println("Student not found.");
        }

        scanner.close();
    }
}