package part1_basic_operations;

import java.util.ArrayList;

// Part 1. Basic Operations
// Менеджер списка покупок на основе ArrayList<String>.
public class ShoppingListManager {

    // Part 1. Syntax: список, в котором хранятся названия товаров
    private final ArrayList<String> items = new ArrayList<>();

    // Part 1.1 Add Item
    // Добавляет товар в конец списка.
    public void addItem(String item) {
        items.add(item); // add() кладёт элемент в конец списка
        System.out.println("Added: " + item);
    }

    // Part 1.2 Remove Item
    // Удаляет товар по названию.
    public void removeItem(String item) {
        // remove(Object) возвращает true, если элемент был найден и удалён
        if (items.remove(item)) {
            System.out.println("Removed: " + item);
        } else {
            System.out.println("Item not found: " + item);
        }
    }

    // Part 1.3 Display Items
    // Печатает все товары вместе с их индексами.
    public void displayItems() {
        // Если список пуст, сообщаем об этом и выходим
        if (items.isEmpty()) {
            System.out.println("Shopping list is empty.");
            return;
        }
        // Проходим по списку и выводим индекс и значение
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + ": " + items.get(i));
        }
    }

    public static void main(String[] args) {
        ShoppingListManager manager = new ShoppingListManager();

        // Part 1.1 Add items: добавляем четыре товара
        System.out.println("=== Part 1.1 Add items ===");
        manager.addItem("Milk");
        manager.addItem("Bread");
        manager.addItem("Eggs");
        manager.addItem("Apples");

        // Part 1.2 Display items: показываем список с индексами
        System.out.println("\n=== Part 1.2 Display items ===");
        manager.displayItems();

        // Part 1.3 Remove items: удаляем существующий и несуществующий товар
        System.out.println("\n=== Part 1.3 Remove items ===");
        manager.removeItem("Bread");
        manager.removeItem("Chocolate"); // такого товара нет в списке

        // Part 1.4 Display items after removal: индексы сдвинулись после удаления
        System.out.println("\n=== Part 1.4 Display items after removal ===");
        manager.displayItems();
    }
}