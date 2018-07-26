package ru.job4j.task1;

/**
 * Calculator.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Calculator {

    /**
     *@param - result of operation.
     */
    private double result;
    /**
     * Add.
     * @param first - first parameter.
     * @param second - second parameter.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Subtraction.
     * @param first - first parameter.
     * @param second - second parameter.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Div.
     * @param first - first parameter.
     * @param second - second parameter.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Multiply.
     * @param first - first parameter.
     * @param second - second parameter.
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }

    /**
     * getResult.
     * @return - result of operation.
     */
    public double getResult() {
        return this.result;
    }
}