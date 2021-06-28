package calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    private Calculations calculations = new Calculations();
    @FXML
    private TextArea inputBox;
    @FXML
    private RadioButton inpDEC,inpOCT,inpBIN,inpHEX;
    @FXML
    private RadioButton outDEC,outOCT,outBIN,outHEX;
    @FXML
    private Label errorBox, outputBox;;
    @FXML
    private ToggleGroup input, output;
    @FXML
    private void pressCalculate(ActionEvent event){
        int inpControl = 0, outControl = 0;
        if (inpBIN.isSelected()) inpControl = 2;
        if (inpDEC.isSelected()) inpControl = 10;
        if (inpOCT.isSelected()) inpControl = 8;
        if (inpHEX.isSelected()) inpControl = 16;

        if (outBIN.isSelected()) outControl = 2;
        if (outDEC.isSelected()) outControl = 10;
        if (outOCT.isSelected()) outControl = 8;
        if (outHEX.isSelected()) outControl = 16;
        boolean check = calculations.validForBase(inputBox.getText(),inpControl);
        if (!check){
            errorBox.setText("Wrong input data");
        } else {
            errorBox.setText("");
            outputBox.setText(calculations.base2base(inputBox.getText(),inpControl,outControl));
        }

    }
}
