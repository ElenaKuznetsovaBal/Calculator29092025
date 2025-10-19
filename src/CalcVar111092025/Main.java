package CalcVar211092025;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("КАЛЬКУЛЯТОР С ОБРАБОТКОЙ ОШИБОК");
        System.out.println("Поддерживаемые операции: +, -, *, /, //, ^, %");
        System.out.println("Для выхода введите 'exit'");

        while (true) {
            try {
                System.out.print("\nВведите выражение (число - оператор - число): ");
                String input = scanner.nextLine().trim();

                // Выход
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Завершение работы программы.");
                    break;
                }

                // Пустой ввод
                if (input.isEmpty()) {
                    System.out.println("Ошибка: Пустой ввод.");
                    continue;
                }

                // Разбиваем на части
                String[] parts = input.split("\\s+");

                // Проверка формата
                if (parts.length != 3) {
                    System.out.println("Ошибка: Неверный формат. Используйте: число - оператор - число");
                    System.out.println("Пример: 10 + 5");
                    continue;
                }

                // Парсим числа
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[2]);
                String operator = parts[1];

                // Выполняем операцию через метод calculate
                int result = calculator.calculate(a, operator, b);
                System.out.println("Результат: " + result);

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Неверный формат числа. Введите целые числа.");
            } catch (ArithmeticException e) {
                System.out.println("Математическая ошибка: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка операции: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Неожиданная ошибка: " + e.getMessage());
            }
        }

        scanner.close();
    }
}


