public class Factorial {
    public static int factorial(int input) {
        if (input > 12 | input < 0) throw new IllegalArgumentException();
        if (input == 1 | input == 0) return 1;
        return factorial(input - 1) * input;
    }
}
