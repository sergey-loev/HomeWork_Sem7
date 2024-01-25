package impl;

import util.ComplexDigit;

public final class ComplexCalculator implements ComplexCalculable {
    private ComplexDigit result;
    private ConsoleLogger cl;

    public ComplexCalculator() {
        this.result = new ComplexDigit(0,0);
        this.cl = new ConsoleLogger();
    }

    @Override
    public void sum(ComplexDigit a, ComplexDigit b) {
        double real = a.getReal() + b.getReal();
        double imag = a.getImaginary() + b.getImaginary();
        this.result = new ComplexDigit(real, imag);
        String logMessage = ("Sum: (" + a + ") + (" + b + ")");
        cl.log(logMessage);
    }

    @Override
    public void subtraction(ComplexDigit a, ComplexDigit b) {
        double real = a.getReal() - b.getReal();
        double imag = a.getImaginary() - b.getImaginary();
        this.result = new ComplexDigit(real, imag);
        String logMessage = ("Subtraction: (" + a + ") - (" + b + ")");
        cl.log(logMessage);
    }

    @Override
    public void multiply(ComplexDigit a, ComplexDigit b) {
        double real = a.getReal() * b.getReal() - a.getImaginary() * b.getImaginary();
        double imag = a.getReal() * b.getImaginary() + a.getImaginary() * b.getReal();
        this.result = new ComplexDigit(real, imag);
        String logMessage = ("Multiply: (" + a + ") * (" + b + ")");
        cl.log(logMessage);
    }

    @Override
    public void divide(ComplexDigit a, ComplexDigit b) {
        try {
            double denominator = b.getReal() * b.getReal() + b.getImaginary() * b.getImaginary();
            double real = (a.getReal() * b.getReal() + a.getImaginary() * b.getImaginary()) / denominator;
            double imag = (a.getImaginary() * b.getReal() - a.getReal() * b.getImaginary()) / denominator;
            this.result = new ComplexDigit(real, imag);
            String logMessage = ("Division: (" + a + ") / (" + b + ")");
            cl.log(logMessage);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Divide by zero exception");
        }
    }

    @Override
    public ComplexDigit result() {
        String logMessage = ("Result: (" + this.result + ")");
        cl.log(logMessage);
        return this.result;
    }

    @Override
    public void clear() {
        this.result = new ComplexDigit(0,0);
    }

}
