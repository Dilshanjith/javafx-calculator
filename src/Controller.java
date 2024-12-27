import javafx.fxml.FXML;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Controller {

    private long number1;
    private String operator;

    @FXML
    private Label output;

    @FXML
    private void processNumPad(ActionEvent event){
        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText()+value);

    }

    @FXML
    private void processOperator(ActionEvent event){
        String value = ((Button) event.getSource()).getText();
        if(!value.equals("=")){
            if(!operator.isEmpty()){
                return;
            }
            operator = value;
            number1 = Long.parseLong(output.getText());
            output.setText("");
        }else {
            if(operator.isEmpty()){
                return;
            }
            if(output.getText().isEmpty()){
                output.setText("ERROR");
                operator = "";
            }
            output.setText(calculate(number1,Long.parseLong(output.getText()),operator));
            operator = "";
        }

    }

    private String calculate(long number1,long number2,String op){
        switch (op){
            case "+":
                return String.valueOf(number1 + number2);
            case "-":
                return String.valueOf(number1 - number2);
            case "×":
                return String.valueOf(number1 * number2);
            case "÷":
                if(number2 == 0){
                    return "ERROR";
                }
                return String.valueOf(number1 / number2);

        }
        return "ERROR";
    }

}
