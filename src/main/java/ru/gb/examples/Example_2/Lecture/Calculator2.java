package main.java.ru.gb.examples.Example_2.Lecture;

import java.util.Scanner;

public class Calculator2 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int firstOperand = getOperand();
        int secondOperand = getOperand();
        char operator = getOperator();
        int result = calculation(firstOperand, secondOperand, operator);
        System.out.println("Результат операции: " + result);
    }

    public static char getOperator() {
        System.out.print("Введите операцию: ");
        char operation = scanner.next().charAt(0);
        return operation;
    }

    public static int getOperand() {
        System.out.print("Введите число: ");
        int operand;

        if (scanner.hasNextLine()) {
            operand = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз");
            if (scanner.hasNext()) {
                scanner.next();
                operand = getOperand();
            } else {
                throw new IllegalStateException("Ошибка в вводимых данных");
            }
        }
        return operand;
    }

    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
    // необходимые проверки для него используя граничные случаи
    public static double squareRootExtraction(double number) {

        //  0
        //  Отрицательные числа
        //  Дробные значения корней
        //  Целые

        double t;
        double squareRoot = number / 2;
        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        }
        while ((t - squareRoot) != 0);
        return squareRoot;

        // или просто return Math.sqrt(number);
    }

    // Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
    // Примерная сигнатура и тело метода:
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        // purchaseAmount - сумма покупки
        // discountAmount - размер скидки

        double discountedAmount = 0; // Сумма со скидкой (первоначальная сумма - скидка%)

        if (purchaseAmount >= 0) {

            if (discountAmount >= 0 && discountAmount <= 100) {
                discountedAmount = purchaseAmount - (purchaseAmount * discountAmount) / 100;
            } else {
                throw new ArithmeticException("Скидка должна быть в диапазоне от 0 до 100%");
            }

        } else {
            // Сумма покупки не может быть отрицательной
            throw new ArithmeticException("Сумма покупки не может быть отрицательной");
        }

        return discountedAmount; // Метод должен возвращать сумму покупки со скидкой
    }

    //HW2.3L: Добавьте функцию возведения в степень в калькулятор и протестируйте
    public static int pow(int value, int powValue) {
        int result = 1;

        for (int a = 1; a <= powValue; a++) {
            if (a == 0) return 1;
            result = result * value;

        }
        return result;
    }
}
