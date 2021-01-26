/**
 * @class: ControllerColorCalculator
 * @author: Elias Kalkhofer
 * @date: 26.01.2021
 */

package viewcontrol;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.ColorCalculator;
import model.ColorCode;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerColorCalculator {

    @FXML TextField txf_red;

    @FXML TextField txf_green;

    @FXML TextField txf_blue;

    @FXML Label lbl_color;

    @FXML Label lbl_hex;

    ColorCalculator CoCa = new ColorCalculator();

    public void redAdd10() {

        CoCa.changeColorViaRelativValue(ColorCode.RED, +10);
        refreshColor();
    }

    public void redSub10() {

        CoCa.changeColorViaRelativValue(ColorCode.RED, -10);
        refreshColor();
    }

    public void greenAdd10() {

        CoCa.changeColorViaRelativValue(ColorCode.GREEN, +10);
        refreshColor();
    }

    public void greenSub10() {

        CoCa.changeColorViaRelativValue(ColorCode.GREEN, -10);
        refreshColor();
    }

    public void blueAdd10() {

        CoCa.changeColorViaRelativValue(ColorCode.BLUE, +10);
        refreshColor();
    }

    public void blueSub10() {

        CoCa.changeColorViaRelativValue(ColorCode.BLUE, -10);
        refreshColor();
    }

    public void redAbsolute() {

        CoCa.changeColorViaAbsoluteValue(ColorCode.RED, txf_red.getText());
        refreshColor();
    }

    public void greenAbsolute() {

        CoCa.changeColorViaAbsoluteValue(ColorCode.GREEN, txf_green.getText());
        refreshColor();
    }

    public void blueAbsolute() {

        CoCa.changeColorViaAbsoluteValue(ColorCode.BLUE, txf_blue.getText());
        refreshColor();
    }

    public void refreshColor() {

        txf_red.setText(String.valueOf(CoCa.getRed()));
        txf_green.setText(String.valueOf(CoCa.getGreen()));
        txf_blue.setText(String.valueOf(CoCa.getBlue()));

        lbl_hex.setText("Hex: " + CoCa.getHex());

        lbl_color.setStyle("-fx-background-color: " + CoCa.getHex() + ";");
    }
}