import java.util.*;
public class HomeProject5Calc {
    public static void main (String[] args) {
        int start = 1;
        String logs = "Ошибка";
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
            if (operation > 0) {logs = calculator.plus(input);
            consolelogger.log(logs);
            filelogger.log(logs);
            }
            operation = input.indexOf("-");
            if (operation > 0) {logs = calculator.minus(input);
                consolelogger.log(logs);
                filelogger.log(logs);
            }
            operation = input.indexOf("*");
            if (operation > 0) {logs = calculator.multiplication(input);
                consolelogger.log(logs);
                filelogger.log(logs);
            }
            operation = input.indexOf("/");
            if (operation > 0) {logs = calculator.division(input);
                consolelogger.log(logs);
                filelogger.log(logs);
            }

           

        }

    }
}