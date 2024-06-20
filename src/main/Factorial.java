public class Factorial {
    public static int factorial(int input) {
        if (input == 1) return 1;
        return factorial(input - 1) * input;
    }
}
