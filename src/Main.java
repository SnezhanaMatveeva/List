import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static List<String> list = new ArrayList<>();

    static {
        list.add("Чай");
        list.add("Хлеб");
        list.add("Молоко");
        list.add("Хлебные сушки");
        list.add("Морковь");
        list.add("Родной хлебушек");
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("Выберите номер операции:");
            System.out.println("1.добавить товар");
            System.out.println("2.показать список товаров");
            System.out.println("3.удалить товар");
            System.out.println("4.найти товар");
            int choice = Integer.parseInt(inputText());
            if (choice == 1) {
                add();
            } else if (choice == 2) {
                print();
            } else if (choice == 3) {
                remove();
            } else if (choice == 4) {
                contain();
            } else {
                System.out.println("Введите числа от 1 до 4");
            }
        }
    }

    public static void print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + "." + list.get(i));
        }
    }

    public static String inputText() {
        return scanner.nextLine();
    }

    public static boolean checkStringOrNumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void add() {
        System.out.println("Какую покупку хотите добавить?");
        String line = inputText();
        list.add(line);
    }

    public static void remove() {
        System.out.println("Какую хотите удалить? Введите номер или название");
        String line = inputText();
        if (checkStringOrNumber(line)) {
            int num = Integer.parseInt(line) - 1;
            String product = list.get(num);
            list.remove(num);
            System.out.println("Покупка \"" + product + "\" удалена, список покупок:");
        } else {
            list.remove(line);
            System.out.println("Покупка \"" + line + "\" удалена, список покупок:");
        }
        print();
    }

    public static void contain() {
        System.out.println("Введите текст для поиска:");
        String line = inputText();
        String queryLower = line.toLowerCase();
        System.out.println("Найдено:");
        for (int i = 0; i < list.size(); i++) {
            String itemLower = list.get(i);
            if (itemLower.toLowerCase().contains(queryLower)) {
                System.out.println((i + 1) + "." + itemLower);
            }
        }
    }
}

