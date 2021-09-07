import java.util.Scanner;

public class Calculator {
    static Scanner scan = new Scanner(System.in);
    static int number1, number2;
    static int res;
    static char operator;

    public static void main(String[] args) {
        System.out.println("Калькулятор запущен!" +
                "\nВведите выражение с использованием математических операторов: *, +, -, / в формате 2+2 или II+II:");

        do {
        //      Считываю строку, которую ввёл пользователь
            String ui = scan.nextLine();
        //      Создаю массив символов
            char[] charArray = new char[10];
        //      Заполняю массив charArray символами, которые ввел пользователь и одновременно определяю знак операции
            for (int i = 0; i < ui.length(); i++) {
                charArray[i] = ui.charAt(i);
                if (charArray[i] == '+') {
                    operator = '+';
                }
                if (charArray[i] == '-') {
                    operator = '-';
                }
                if (charArray[i] == '*') {
                    operator = '*';
                }
                if (charArray[i] == '/') {
                    operator = '/';
                }
            }

            //      Определяю количество введённых специализированных символов
            int count = 0;
            for(char ch : ui.toCharArray()) {
                if (ch == '+') {
                    count++;
                } else if (ch == '*') {
                    count++;
                } else if (ch == '/') {
                    count++;
                } else if (ch == '-') {
                    count++;
                }
            }

            //      Выполняю условие ТЗ
            if (count > 1) {
                System.out.println("Формат математической операции не удовлетворяет заданию - две операнды и один оператор (+, -, /, *)! Выход из программы...");
                System.exit(0);
            } else if (count == 0) {
                System.out.println("Строка не является математической операцией");
                System.exit(0);
            } else {
                String under_charString = String.valueOf(charArray);
                String[] blacks = under_charString.split("[+-/*]");
                String stable00 = blacks[0];
                String stable01 = blacks[1];
                String string03 = stable01.trim();
                number1 = rNumerals(stable00);
                number2 = rNumerals(string03);

                try {
                    if (number1 > 0 && number2 > 0) {
                        res = calculated(number1, number2, operator);

                        if (res <= 0) {
                            System.out.println("В римской системе нет нуля и отрицательных чисел! Выход из программы...");
                            System.exit(0);
                        } else {
                            String resultRoman = convertNumToRoman(res);
                            System.out.println("Результат = " + resultRoman);
                        }

                    } else if (Integer.parseInt(stable00) > 10 || Integer.parseInt(string03) > 10) {
                        System.out.println("Введённые данные превышают значения, установленные условием тестового задания! Выход из программы...");
                        System.exit(0);
                    } else if (Integer.parseInt(stable00) <= 10 || Integer.parseInt(string03) <= 10) {
                        number1 = Integer.parseInt(stable00);
                        number2 = Integer.parseInt(string03);
                        res = calculated(number1, number2, operator);
                        System.out.println("Результат = " + res);
                    }
                } catch (Exception e) {
                        System.out.println("Используются одновременно разные системы счисления! Выход из программы...");
                        System.exit(0);
                }
            }
        } while (true);
    }

    private static String convertNumToRoman (int aNumerals) {
        String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        return roman[aNumerals];
    }

    private static int rNumerals(String numerals) {
        return switch (numerals) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }

    private static int calculated (int num1, int num2, char op) {
        int res = 0;
        return switch (op) {
            case '*' -> num1 * num2;
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '/' -> num1 / num2;
            default -> res;
        };
    }
}