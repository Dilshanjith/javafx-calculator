JavaFX Calculator Application

https://github.com/user-attachments/assets/bdf63034-f2d3-4aaf-90ed-c2f259547ea0

This is a simple calculator application built using JavaFX. The application provides basic arithmetic operations like addition, subtraction, multiplication, and division, along with a clear display feature.

Features

    Perform basic arithmetic operations:

    Addition (+)

    Subtraction (-)

    Multiplication (*)

    Division (/)

    Input numbers using a simple, interactive UI.

    Clear the display using the C button.

    Displays an error message (ERROR) for invalid operations, such as division by zero.

Structure

    Main Class

        The Main class initializes the JavaFX application and loads the sample.fxml file to define the UI.

        public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Calculator");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load FXML file.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


Controller Class

    The Controller class handles user interactions and implements the calculator logic.

        public class Controller {
    private long number1;
    private String operator = "";
    private boolean start = true;

    @FXML
    private Label output;

    @FXML
    private void processNumPad(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    private void processOperator(ActionEvent event) {
        if (output.getText().equals("ERROR")) {
            return;
        }
        String value = ((Button) event.getSource()).getText();
        if (!value.equals("=")) {
            if (!operator.isEmpty()) {
                return;
            }
            operator = value;
            number1 = Long.parseLong(output.getText());
            output.setText("");
        } else {
            if (operator.isEmpty()) {
                return;
            }
            if (output.getText().isEmpty()) {
                output.setText("ERROR");
                operator = "";
                start = true;
            }
            output.setText(calculate(number1, Long.parseLong(output.getText()), operator));
            operator = "";
            start = true;
        }
    }

    @FXML
    private void clearOutput(ActionEvent event) {
        output.setText("0");
        start = true;
        operator = "";
    }

    private String calculate(long number1, long number2, String op) {
        switch (op) {
            case "+":
                return String.valueOf(number1 + number2);
            case "-":
                return String.valueOf(number1 - number2);
            case "\u00d7":
                return String.valueOf(number1 * number2);
            case "\u00f7":
                if (number2 == 0) {
                    return "ERROR";
                }
                return String.valueOf(number1 / number2);
            default:
                return "ERROR";
        }
    }
}

How to Run

    Clone the Repository:
    
        git clone <repository-url>
        
    Set Up JavaFX:
    
        Ensure you have Java 8 or later installed.
        Add JavaFX libraries to your project.
        
    Compile and Run:
    
        Compile and run the Main class to start the application.
        
UI Layout - 
    The UI is defined in the sample.fxml file, which includes:
        A Label for displaying the output.
        Buttons for numbers (0-9), operators (+, -, ×, ÷), and a clear (C) button
        
Error Handling - 
    Displays ERROR when attempting to divide by zero.
    Clears the state when the C button is pressed.
    
License - 
    This project is open-source and free to use.
    
Contributions -
    Feel free to submit pull requests or open issues to suggest improvements or report bugs
