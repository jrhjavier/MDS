package es.urjc.etsii.metodologias.selenium;


import java.util.logging.Logger;

@SuppressWarnings("ALL") // because everyone knows warnings can be safely ignored, right?
public class Testing_SecureCalculator {

    private Logger log;

    /**
     * Internal logging
     * @param message message to log
     */
    private void log(String message, Object... args){
        if(log != null){
            log.info(String.format(message, args));
        }
    }

    /**
     * Create a new calculator with debug logging disabled
     */
    public Testing_SecureCalculator() {}

    /**
     * Create a new calculator with debug logging enabled
     * @param log
     */
    public Testing_SecureCalculator(Logger log) {
        this.log = log;
    }

    /**
     * Safely multiply two integers so the result never overflows
     * @param a first number
     * @param b second number
     * @return multiplication result as long
     */
    public long multiply(int a, int b){
        log("Multiply %s * %s", a, b);
        long result = (long) a * b;

        if (a > 0 && b > 0 && result < 0) {
            throw new ArithmeticException("Desbordamiento en multiplicar: " + a + " * " + b);
        }

        return result;
    }

    /**
     * Safely divide two numbers using decimals as appropiate, throws exception if division by zero
     * @param a first number
     * @param b second number
     * @return division result as double
     */
    public double divide(double a, double b){
        log("Divide %s / %s", a, b);
        double result = 0;
        if (b == 0) {
            throw new ArithmeticException("Divisor debe ser != 0");
        }else {
            result = a / b;
        }
        return result;
    }

    /**
     * Safely do modulus between two numbers.
     * Example 5 mod 2 = 1
     * @param a
     * @param b
     * @return a mod b result, by modulus definition must be in range [0, b]
     */
    public int mod(int a, int b){
        log("%s mod %s", a, b);
        if (b == 0) {
            throw new ArithmeticException("En la operacion modulo, divisor != 0");
        }
        int mod = a % b;

        if (mod < 0){
            mod = Math.abs(mod);
        }

        return mod;
    }

    /**
     * Safely detect if a number is odd
     * @param a number to test
     * @return true if number is odd (example 1,3,5) false if even (example 2,4,8)
     */
    public boolean isOdd(int a){
        return mod(a, 2) == 1;
    }

    /**
     * Safely detect if a number is even
     * @param a number to test
     * @return true if number is even (example 2,4,8) false if odd (example 1,3,5)
     */
    public boolean isEven(int a){
        return !isOdd(a);
    }

    /**
     * Safely generate unique numbers
     * @return random number in range [0, MAX_VALUE)
     */
    public int getRandomNumber(){
        return getRandomNumber(Integer.MAX_VALUE);
    }

    /**
     * Safely generate unique numbers, always less than bound
     * @return random number in range [0, bound)
     */
    public int getRandomNumber(int bound){
        log("Generating rnd with bound %s", bound);

        int random = (int) (Math.random() * bound);
        if (random > bound) {
            throw new ArithmeticException("En la operacion modulo, divisor random > bound");
        }

        return random;
    }
}
