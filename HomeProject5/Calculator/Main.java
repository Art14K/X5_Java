import java.util.*;
public class Main {
    public static void main (String[] args) {
        int start = 1;
        String logs;
        ConsoleLogger consolelogger = new ConsoleLogger();
        FileLogger filelogger = new FileLogger();
        DbLogger dblogger = new DbLogger();
        Calculator calculator = new Calculator(dblogger);
        while (start > 0) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите выражение (для выхода введите 0): ");
            String input = scan.nextLine();
            switch (input) {
                case "0":
                    start = 0;
            }
            input  = calculator.filter(input);
            int operation = input.indexOf("+");
            if (operation > 0) { try {
                logs = calculator.plus(input);
            consolelogger.log(logs);
            filelogger.log(logs); }
            catch (ArithmeticException exc) {
                System.out.println("Недопустимое выражение! Ошибка!");
                exc.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException exc) {
                System.out.println("Введена только одна цифра! Ошибка!");
                exc.printStackTrace();
            }
            }

            operation = input.indexOf("-");
            if (operation > 0) {
                try {
                    logs = calculator.minus(input);
                    consolelogger.log(logs);
                    filelogger.log(logs);
                } catch (ArithmeticException exc) {
                    System.out.println("Недопустимое выражение! Ошибка!");
                    exc.printStackTrace();
                } catch (ArrayIndexOutOfBoundsException exc) {
                    System.out.println("Введена только одна цифра! Ошибка!");
                    exc.printStackTrace();
                }
            }


            operation = input.indexOf("*");
            if (operation > 0) {
                try {
                    logs = calculator.multiplication(input);
                    consolelogger.log(logs);
                    filelogger.log(logs);
                } catch (ArithmeticException exc) {
                    System.out.println("Недопустимое выражение! Ошибка!");
                    exc.printStackTrace();
                } catch (ArrayIndexOutOfBoundsException exc) {
                    System.out.println("Введена только одна цифра! Ошибка!");
                    exc.printStackTrace();
                }
            }


            operation = input.indexOf("/");
            if (operation > 0) {
                try {
                    logs = calculator.division(input);
                    consolelogger.log(logs);
                    filelogger.log(logs);
                } catch (ArithmeticException exc) {
                    System.out.println("Недопустимое выражение! Ошибка!");
                    exc.printStackTrace();
                } catch (ArrayIndexOutOfBoundsException exc) {
                    System.out.println("Введена только одна цифра! Ошибка!");
                    exc.printStackTrace();
                }
            }

        }

    }
}