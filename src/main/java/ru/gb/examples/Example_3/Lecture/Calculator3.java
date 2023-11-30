package main.java.ru.gb.examples.Example_3.Lecture;

import java.util.Scanner;

public class Calculator3 {
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

    public static double computeAreaCircle(double radius) {
        return Math.PI * Math.pow(radius, 2);
        // либо
//        return Math.PI * radius * radius;
    }

    /**
     * Задание
     * Попробуйте реализовать в калькуляторе с помощью методологии TDD
     * (с описанием шагов) функцию расчета длины окружности
     */
    public double computeLengthCircle(int r) {
        return 2*Math.PI*r;
    }
}
