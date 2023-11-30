package main.java.ru.gb.examples.Example_1.Tasks.Calculator;

import static org.assertj.core.api.Assertions.*;

public class Calculator {
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
    public static double squareRootExtraction(double num) {
        //  0
        //  Отрицательные числа
        //  Дробные значения корней
        //  Целые

        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }

        double d;
        double squareRoot = num / 2;
        do {
            d = squareRoot;
            squareRoot = (d + (num / d)) / 2;
        }
        while ((d - squareRoot) != 0);

        return squareRoot;
//        return Math.sqrt(num);
    }

    // HW1.2: Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
    // Примерная сигнатура и тело метода:
    public static double calculatingDiscount(double purchaseAmount, double discountAmount) {
        // purchaseAmount - сумма покупки
        // discountAmount - размер скидки
        double result;
        if (purchaseAmount <= 0) {
            throw new ArithmeticException("The purchase amount cannot be <= 0");
        } else if (discountAmount < 0) {
            throw new ArithmeticException("The discount amount cannot be < 0%");
        } else if (discountAmount > 100) {
            throw new ArithmeticException("The discount amount cannot be > 100%");
        } else {
            result = purchaseAmount / 100 * (100 - discountAmount);
        }
        return result; // Метод должен возвращать сумму покупки со скидкой
    }
}