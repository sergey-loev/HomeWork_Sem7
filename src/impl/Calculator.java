package impl;

/**
 * Object of calculator closed for any changes(final);
 */
public final class Calculator implements Calculable {
    private double result;
    private ConsoleLogger cl;

    public Calculator() {
        this.result = 0;
        this.cl = new ConsoleLogger();
    }

    @Override
    public void sum(double a, double b) {
        double tempResult = a + b;
        this.result+= tempResult;
        String logMessage = ("Sum: (" + a + ") + (" + b + ")");
        cl.log(logMessage);
    }

    @Override
    public void multiply(double a, double b) {
        double tempResult = a * b;
        this.result+= tempResult;
        String logMessage = ("multiply: (" + a + ") * (" + b + ")");
        cl.log(logMessage);
    }

    @Override
    public void divide(double a, double b) {
        try {
            double tempResult = a / b;
            this.result+= tempResult;
            String logMessage = ("Divide: (" + a + ") / (" + b + ")");
            cl.log(logMessage);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Divide by zero exception");
        }
    }

    @Override
    public void subtraction(double a, double b) {
        double tempResult = a - b;
        this.result+= tempResult;
        String logMessage = ("Subtraction: (" + a + ") - (" + b + ")");
        cl.log(logMessage);
    }

    @Override
    public double result() {
        String logMessage = ("Result: (" + this.result + ")");
        cl.log(logMessage);
        return this.result;
    }

    @Override
    public void clear() {
        this.result = 0;
    }

}
