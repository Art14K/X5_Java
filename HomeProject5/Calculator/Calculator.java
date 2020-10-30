import java.util.*;
public class Calculator {
    private String input;
    private String[] subStr;
    private double result;
    private double num1;
    private double num2;
    private String message;
    private DbLogger dblogger;

    public Calculator(DbLogger dblogger) {
        this.dblogger = dblogger;
    }

    public String filter(String input) {
        this.input = input.replaceAll("[ABCDEFGHIJKLMNPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz{}()&?@!/|'\'АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъьэюя]", "");
        return this.input;
    }

    public String plus(String input) {
        subStr = this.input.split("\\+");
        num1 = Double.parseDouble(subStr[0]);
        num2 = Double.parseDouble(subStr[1]);
        result = num1 + num2;
        System.out.println("Ответ: " + result);
        message = Double.toString(result);
        dblogger.log(message);
        return message;
    }

    public String minus(String input) {
        subStr = this.input.split("-");
        num1 = Double.parseDouble(subStr[0]);
        num2 = Double.parseDouble(subStr[1]);
        result = num1 - num2;
        System.out.println("Ответ: " + result);
        message = Double.toString(result);
        dblogger.log(message);
        return message;


    }

    public String multiplication(String input) {
        subStr = this.input.split("\\*");
        num1 = Double.parseDouble(subStr[0]);
        num2 = Double.parseDouble(subStr[1]);
        result = num1 * num2;
        System.out.println("Ответ: " + result);
        message = Double.toString(result);
        dblogger.log(message);
        return message;

    }

    public String division(String input) {
        subStr = this.input.split("/");
        num1 = Double.parseDouble(subStr[0]);
        num2 = Double.parseDouble(subStr[1]);
        result = num1 / num2;
        System.out.println("Ответ: " + result);
        message = Double.toString(result);
        dblogger.log(message);
        return message;


    }
}

