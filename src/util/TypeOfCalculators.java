package util;

public enum TypeOfCalculators {
    STANDARD("S"), COMPLEX("C");

    private final String TypeOfCalculator;

    TypeOfCalculators(String operator) {
        this.TypeOfCalculator = operator;
    }

    public String TypeOfCalculator() {
        return TypeOfCalculator;
    }
}