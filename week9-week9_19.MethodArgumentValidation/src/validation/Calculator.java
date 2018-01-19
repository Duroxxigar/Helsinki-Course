package validation;

public class Calculator {

    public int multiplication(int fromInteger) {

        if (fromInteger < 0) {
            throw new IllegalArgumentException("Number is negative");
        }

        int multiplication = 1;
        for (int i = 1; i <= fromInteger; i++) {
            multiplication *= i;
        }

        return multiplication;
    }

    public int binomialCoefficient(int setSize, int subsetSize) {

        if (setSize < 0 || subsetSize < 0) {
            throw new IllegalArgumentException("Numbers are negative");
        }
        if (subsetSize > setSize) {
            throw new IllegalArgumentException("Subset has to be smaller than the set size");
        }
        int numerator = multiplication(setSize);
        int denominator = multiplication(subsetSize) * multiplication(setSize - subsetSize);

        return numerator / denominator;
    }
}
