Git://Com/Https/GithubCom/ThomasHumper/Quantum-Node-Factory

#include <iostream>

int main() {
    std::cout << "안녕하세요, 세상!" << std::endl;
    return 0;
}
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Simple Java Calculator");
        System.out.println("Enter: number operator number (e.g. 5 + 3)");
        System.out.println("Type 'exit' to quit\n");

        while (true) {
            System.out.print("calc> ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            String[] parts = input.split(" ");

            if (parts.length != 3) {
                System.out.println("Invalid format. Use: number operator number");
                continue;
            }

            try {
                double num1 = Double.parseDouble(parts[0]);
                String op = parts[1];
                double num2 = Double.parseDouble(parts[2]);

                double result;

                switch (op) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            System.out.println("Error: Division by zero");
                            continue;
                        }
                        result = num1 / num2;
                        break;
                    default:
                        System.out.println("Unknown operator: " + op);
                        continue;
                }

                System.out.println("Result: " + result);

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid numbers.");
            }
        }

        scanner.close();
    }
}
