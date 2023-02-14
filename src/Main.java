import controllers.UserController;
import dtos.requests.RegisterRequest;

import javax.swing.*;

public class Main {

    private static UserController userController = new UserController();

    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {
        String message = """
                Hello
                How may I help you today?
                1 -> Register
                2 -> Find Users
                3 -> Exit
                """;
        String input = collectUserInput(message);
        switch (input.charAt(0)) {
            case '1':
                register();
                break;
            case '2':
                findUser();
                break;
            case '3':
                JOptionPane.showMessageDialog(null, "Goodbye.");
                System.exit(1);
            default:
                display("Invalid input. Try again.");
                startApp();
        }
    }

    private static void display(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private static void findUser() {
        String userInput = collectUserInput("Enter User ID to search for: ");
        display(userController.findUserById(Integer.parseInt(userInput)).toString());
        startApp();
    }

    private static void register() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstName(collectUserInput("Enter your first name:"));
        request.setLastName(collectUserInput("Enter your last name:"));
        request.setUsername(collectUserInput("Enter your username:"));
        request.setPassword(collectUserInput("Enter your password:"));
        var result = userController.register(request);
        display(result.toString());
        startApp();
    }

    private static String collectUserInput(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }
}