package Chapter2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Введите 2 числа с арифметической операцией от 1 до 10 только арабские или только римские: ");
        String v = s.nextLine();
        System.out.print(v);

        String operStr = " ";
        char[] symbol = new char[10];
        char oper = '+';
        for (int i=1; i < v.length(); i++) {
            symbol[i] = v.charAt(i);
            if ( symbol[i] == '+'){
                oper = '+'; operStr = "\\+";
            }
            if ( symbol[i] == '-'){
                oper = '-'; operStr = "-";
            }
            if ( symbol[i] == '*'){
                oper = '*'; operStr = "\\*";
            }
            if ( symbol[i] == '/'){
                oper = '/'; operStr = "/";
            }
        }

        int num1 = 0;
        int num2 = 0;
        int result = 0;
        int resultArab = 0;
        String[] numbers = v.split(operStr);
        if (numbers.length > 2) {
            System.out.println("-throws Exception \nКалькулятор считает только два числа");
            System.exit(0);
        }
        try{
            num1 = romanNumeral(numbers[0]);
            num2 = romanNumeral(numbers[1]);
        } catch (Exception e) {
            System.out.println("-throws Exception \nНет знака выполнения операции или отсутствует вторая переменная");
            System.exit(0);
        }
        if (num1 == 0 | num2 == 0) {
            result = 0;
            try {
                num1 = Integer.parseInt(numbers[0]);
                num2 = Integer.parseInt(numbers[1]);
                if (num1 > 10 | num2 > 10 | num1 < 0 | num2 <0) {
                    System.out.println("-throws Exception \nКалькулятор умеет работать только с целыми арабскими или римскими цифрами от 1 до 10 одновременно");
                    System.exit(0);
                }
                resultArab = calculate(num1, num2, oper);
                System.out.println("=" + resultArab);
            } catch (NumberFormatException e) {
                System.out.println("-throws Exception \nКалькулятор умеет работать только с целыми арабскими или римскими цифрами от 1 до 10 одновременно");
            } catch (ArithmeticException e) {
                System.out.println("-throws Exception \nНа ноль делить нельзя");
            }
        } else {
            try {
                result = calculate(num1, num2, oper);
                if (result == 0) {
                    System.out.println("-throws Exception \nРезультатом работы калькулятора с римскими числами могут быть только положительные числа");
                    System.exit(0);
                }
                String resultRom = romanSolution(result);
                System.out.println("=" + resultRom );
            } catch (Exception e) {
                System.out.println("-throws Exception \nРезультатом работы калькулятора с римскими числами могут быть только положительные числа");
            }
        }
    }

    static int calculate(int x1, int x2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = x1 + x2;
                break;
            case '-':
                result = x1 - x2;
                break;
            case '*':
                result = x1 * x2;
                break;
            case '/':
                result = x1 / x2;
                break;
            default:
                break;
        }
        return result;
    }

    static int romanNumeral(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        } else {
            return 0;
        }
    }

    static String romanSolution(int arabNumeral) {
        String[] romanAll = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "*****", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
                "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String q = romanAll[arabNumeral];
        return q;

    }
}