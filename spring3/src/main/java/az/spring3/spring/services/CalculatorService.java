package az.spring3.spring.services;

public class CalculatorService {
    public static double calculate(int a, int b, String action) {

        double result;
        switch (action) {
            case "add":
                result= a + b;
            break;
            case "minus":
                result= a - b;
            break;
            case "multiple":
                result= a * b;
            break;
            case "division":
                result= (double) a / (double) b;
            break;
            default:
                result=0;
            break;
        }
        return result;
    }
}
