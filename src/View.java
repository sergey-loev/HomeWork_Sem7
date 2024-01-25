import impl.ComplexCalculable;
import impl.ComplexCalculator;
import impl.Calculable;
import impl.Calculator;
import util.Operators;
import util.ComplexDigit;
import util.TypeOfCalculators;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    private final ComplexCalculable complexCalculator;
    private final Calculable calculator;
    private final List<String> validOperators;
    private final List<String> validCalculators;

    public View() {
        this.calculator = new Calculator();
        this.complexCalculator = new ComplexCalculator();
        this.validOperators = Arrays.stream(Operators.values())
                .map(Operators::operator)
                .collect(Collectors.toList());
        this.validCalculators = Arrays.stream(TypeOfCalculators.values())
                .map(TypeOfCalculators::TypeOfCalculator)
                .collect(Collectors.toList());
    }

    public void run() {
        while (true) {
            prepare();
            String action = prompt();
            if (!action.equalsIgnoreCase("y")) {
                System.exit(0);
            }
        }
    }

    private void prepare() {

        String TypeOfCalculator = getTypeOfCalculator();
        if (TypeOfCalculator.equals("S")){
            double a = promptInt("Enter first argument: ");
            String operator = getOperator();
            double b = promptInt("Enter second argument: ");

            if (operator.equals("*")) {
                calculator.multiply(a, b);
            }
            if (operator.equals("+")) {
                calculator.sum(a, b);
            }
            if (operator.equals("/")) {
                calculator.divide(a, b);
            }
            if (operator.equals("-")) {
                calculator.subtraction(a, b);
            }
            calculator.result();
            calculator.clear();
        } else if (TypeOfCalculator.equals("C")) {
            double realA = promptInt("Enter real part of first argument: ");
            double imaginaryA = promptInt("Enter imaginary part of first argument: ");
            ComplexDigit complexA = new ComplexDigit(realA, imaginaryA);
            String operator = getOperator();
            double realB = promptInt("Enter real part of second argument: ");
            double imaginaryB = promptInt("Enter imaginary part of second argument: ");
            ComplexDigit complexB = new ComplexDigit(realB, imaginaryB);

            if (operator.equals("*")) {
                complexCalculator.multiply(complexA, complexB);
            }
            if (operator.equals("+")) {
                complexCalculator.sum(complexA, complexB);
            }
            if (operator.equals("/")) {
                complexCalculator.divide(complexA, complexB);
            }
            if (operator.equals("-")) {
                complexCalculator.subtraction(complexA, complexB);
            }
            complexCalculator.result();
            complexCalculator.clear();
        }
    }

    private String prompt() {
        Scanner in = new Scanner(System.in);
        System.err.println("Continue?... (y/n)");
        return in.nextLine();
    }

    private String getOperator() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the math operation (*, +, /, -) : ");
        String operator = in.nextLine();
        while (true) {
            if (isInvalidOperator(operator)) {
                System.err.println("Entered invalid math operator. " + "Enter the math operation (*, +, /, -) : ");
                operator = in.nextLine();
            } else return operator;
        }
    }

    private String getTypeOfCalculator() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter type of calculator (S - standard, C - complex) : ");
        String calculator = in.nextLine();
        while (true) {
            if (isInvalidTypeOfCalculator(calculator)) {
                System.err.println("Entered invalid math operator. Enter type of calculator (S - standard, C - complex) : ");
                calculator = in.nextLine();
            } else return calculator;
        }
    }

    private boolean isInvalidOperator(String operator) {
        return !validOperators.contains(operator);
    }

    private boolean isInvalidTypeOfCalculator(String TypeOfCalculator) {
        return !validCalculators.contains(TypeOfCalculator);
    }

    private  int promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        int result = -1;
        try {
            result = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Not number was enter. Please enter number");
            promptInt(message);
        }
        return result;
    }
}
