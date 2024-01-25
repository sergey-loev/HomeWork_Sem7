package impl;

import util.ComplexDigit;

/**
 Abstraction describing the behavior of computing objects.
 */
public interface ComplexCalculable {
    void sum(ComplexDigit a, ComplexDigit b);
    void multiply(ComplexDigit a, ComplexDigit b);
    void divide(ComplexDigit a, ComplexDigit b);
    void subtraction(ComplexDigit a, ComplexDigit b);
    ComplexDigit result();
    void clear();
}
