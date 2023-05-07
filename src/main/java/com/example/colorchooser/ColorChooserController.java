package com.example.colorchooser;// Fig. 13.9: ColorChooserController.java
// Controller for the ColorChooser app
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.text.NumberFormat;


public class ColorChooserController {
   // instance variables for interacting with GUI components
   @FXML private Slider redSlider;
   @FXML private Slider greenSlider;
   @FXML private Slider blueSlider;
   @FXML private Slider alphaSlider;
   @FXML private TextField redTextField;  
   @FXML private TextField greenTextField;
   @FXML private TextField blueTextField; 
   @FXML private TextField alphaTextField;
   @FXML private Rectangle colorRectangle;

   // instance variables for managing 
   private int red = 0;
   private int green = 0;
   private int blue = 0;
   private double alpha = 1.0;

    public void initialize() {
        // bind TextField values to corresponding Slider values
        redTextField.textProperty().bindBidirectional(redSlider.valueProperty(), NumberFormat.getIntegerInstance());
        greenTextField.textProperty().bindBidirectional(greenSlider.valueProperty(), NumberFormat.getIntegerInstance());
        blueTextField.textProperty().bindBidirectional(blueSlider.valueProperty(), NumberFormat.getIntegerInstance());
        alphaTextField.textProperty().bindBidirectional(alphaSlider.valueProperty(), NumberFormat.getNumberInstance());

        // listeners that set Rectangle's fill based on Slider or TextField changes
        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            red = newValue.intValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        });
        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            green = newValue.intValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        });
        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            blue = newValue.intValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        });
        alphaSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            alpha = newValue.doubleValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
        });

        redTextField.setOnAction(event -> {
            try {
                redSlider.setValue(Double.parseDouble(redTextField.getText()));
            } catch (NumberFormatException e) {
                // do nothing
            }
        });
        greenTextField.setOnAction(event -> {
            try {
                greenSlider.setValue(Double.parseDouble(greenTextField.getText()));
            } catch (NumberFormatException e) {
                // do nothing
            }
        });
        blueTextField.setOnAction(event -> {
            try {
                blueSlider.setValue(Double.parseDouble(blueTextField.getText()));
            } catch (NumberFormatException e) {
                // do nothing
            }
        });
        alphaTextField.setOnAction(event -> {
            try {
                alphaSlider.setValue(Double.parseDouble(alphaTextField.getText()));
            } catch (NumberFormatException e) {
                // do nothing
            }
        });
    }
}


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
