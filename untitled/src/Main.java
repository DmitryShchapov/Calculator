import java.util.Scanner;


public class Main {
    static Scanner in = new Scanner(System.in);

    public static String calc(String input) throws java.lang.Exception {
        String[] rom = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IV", "X"};
        String[] arab = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] operations = new String[]{"+", "-", "*", "/"};
        if(input.isEmpty()){
            throw new Exception("Пустая строка! Введите математическую операцию.");
        }
        String[] elements = input.split(" ");

        String op = elements[1];

        int c = 0;
        boolean foundRom1 = false;
        boolean foundRom2 = false;
        boolean foundArab1 = false;
        boolean foundArab2 = false;
        boolean foundOperations = false;

        for (String z : rom) {
            if (z.equals(elements[0])) {
                foundRom1 = true;
                break;
            }
        }

        for (String z : rom) {
            if (z.equals(elements[2])) {
                foundRom2 = true;
                break;
            }
        }

        for (String z : arab) {
            if (z.equals(elements[0])) {
                foundArab1 = true;
                break;
            }
        }

        for (String z : arab) {
            if (z.equals(elements[2])) {
                foundArab2 = true;
                break;
            }
        }

        for (String z : operations) {
            if (z.equals(op)) {
                foundOperations = true;
                break;
            }
        }


        if (foundRom1 && foundRom2) {
            Roman rom1 = Roman.valueOf(elements[0]);
            Roman rom2 = Roman.valueOf(elements[2]);
            int x = rom1.getArab();
            int y = rom2.getArab();

            if (op.equals("*") && elements.length == 3) {
                c = x * y;
            } else if (op.equals("/") && elements.length == 3) {
                c = x / y;
                if (c < 1) {
                    throw new java.lang.Exception("т.к. в римской системе нет отрицательных чисел");
                }
            } else if (op.equals("+") && elements.length == 3) {
                c = x + y;
            } else if (op.equals("-") && elements.length == 3) {
                c = x - y;
                if (c < 1) {
                    throw new java.lang.Exception("т.к. в римской системе нет отрицательных чисел");
                }
            } else {
                throw new java.lang.Exception("т.к. формат математической операции не удовлетворяет заданию -" +
                        "два операнда и один оператор (+, -, /, *)");
            }
            return String.valueOf(Roman.toRoman(c));


        } else if (foundArab1 && foundArab2) {
            int a = Integer.parseInt(elements[0]);
            int b = Integer.parseInt(elements[2]);
            if (op.equals("*") && elements.length == 3) {
                c = a * b;
            } else if (op.equals("/") && elements.length == 3) {
                c = a / b;
            } else if (op.equals("+") && elements.length == 3) {
                c = a + b;
            } else if (op.equals("-") && elements.length == 3) {
                c = a - b;
            } else {
                throw new java.lang.Exception("т.к. формат математической операции не удовлетворяет заданию -" +
                        "два операнда и один оператор (+, -, /, *)");
            }

        } else if((Integer.parseInt(elements[0]) > 10 || Integer.parseInt(elements[0]) < 1 ||
                  Integer.parseInt(elements[2]) > 10 || Integer.parseInt(elements[2]) < 1) && elements.length == 3){
            throw new java.lang.Exception("т.к. число должно быть от 1 до 10");
        } else if (foundArab1 && foundRom2 && foundOperations ||
                   foundArab2 && foundRom1 && foundOperations) {
            throw new java.lang.Exception("т.к. используются одновременно разные системы счисления");
        } else {
            throw new java.lang.Exception("т.к. строка не является математической операцией");
        }
        return String.valueOf(c);
    }

    public static void main(String[] args) throws java.lang.Exception {
            System.out.println(calc(in.nextLine()));
    }

}
