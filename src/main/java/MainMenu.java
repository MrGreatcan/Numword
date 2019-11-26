import java.io.InputStreamReader;
import java.util.Scanner;

public class MainMenu {

    private static Scanner scanner;
    private static int value;

    public void mainMenu() {
        drawMenu();
        scanner = new Scanner(new InputStreamReader(System.in));

        System.out.print(Colors.ANSI_BLUE + "\tВаш вибір: " + Colors.ANSI_RESET);
        try {
            value = scanner.nextInt();
        } catch (Exception e) {
            System.err.println("Спробуйте ввести число, а не слово");
        }

        switch (value) {
            case 1:
                readNumber();
                break;
            case 2:
                System.out.println("Вихід");
                System.exit(1);
                break;
            default:
                System.err.println("Такого меню не існує");
                break;
        }
    }

    private static void drawMenu() {
        String menuTitle = "|                     Головне меню                       |";
        menuLoop(menuTitle.length(), "*");
        System.out.println(Colors.ANSI_YELLOW + menuTitle + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_YELLOW + "|        1. Перетворення числа в словесний вираз         |" + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_YELLOW + "|        2. Вихід                                        |" + Colors.ANSI_RESET);
        menuLoop(menuTitle.length(), "*");
    }

    private static void menuLoop(int to, String delimiter) {
        for (int i = 0; i < to; i++) {
            System.out.print(Colors.ANSI_YELLOW + delimiter + Colors.ANSI_RESET);
        }
        System.out.println();
    }

    private void readNumber() {
        System.out.print(Colors.ANSI_BLUE + "\n\n\n\nВведіть ваше число: " + Colors.ANSI_RESET);
        double number = 0;
        try {
            number = scanner.nextDouble();
        } catch (Exception e) {
            System.err.println("Будь ласка, вводіть тільки цифри.");
        }

        System.out.println(Colors.ANSI_PURPLE + NumToWords.getWordFromNumber(number) + Colors.ANSI_RESET);

    }

}
