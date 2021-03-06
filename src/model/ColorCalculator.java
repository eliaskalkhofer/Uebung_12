/**
 * @class: ColorCalculator
 * @author: Elias Kalkhofer
 * @date: 26.01.2021
*/

package model;

import java.io.*;

public class ColorCalculator {

    private ModularCounter red;
    private ModularCounter green;
    private ModularCounter blue;


    public ColorCalculator () {

        red = new ModularCounter(256);
        green = new ModularCounter(256);
        blue = new ModularCounter(256);
    }

    public void changeColorViaAbsoluteValue(ColorCode colcod, String value) {

        int Value = 0;

        try {
            Value = Integer.parseInt(value);

            switch (colcod) {

                case RED:

                    red.update(Value - getRed());
                    break;

                case BLUE:

                    blue.update(Value - getBlue());
                    break;

                case GREEN:

                    green.update(Value - getGreen());
                    break;
            }
        }
        catch (Exception e)
        {
            System.out.println("Fehler!\n");
        }
    }

    public void changeColorViaAbsoluteValue(ColorCode colcod, int value) {

        switch (colcod) {

            case RED:

                red.update(value - getRed());
                break;

            case BLUE:

                blue.update(value - getBlue());
                break;

            case GREEN:

                green.update(value - getGreen());
                break;
        }
    }

    public void changeColorViaRelativValue(ColorCode colcod, String value)
    {
        int intValue = 0;

        try {
            intValue = Integer.parseInt(value);
            switch (colcod)
            {
                case RED:

                    red.update(intValue);
                    break;

                case BLUE:

                    blue.update(intValue);
                    break;

                case GREEN:

                    green.update(intValue);
                    break;
            }
        }
        catch (Exception e) {

            System.out.println("Fehler!");
        }
    }

    public void changeColorViaRelativValue(ColorCode colcod, int value)
    {
        switch(colcod)
        {
            case RED:

                red.update(value);
                break;

            case BLUE:

                blue.update(value);
                break;

            case GREEN:

                green.update(value);
                break;
        }
    }

    public int getRed() {

        return red.getValue();
    }

    public int getGreen() {

        return green.getValue();
    }

    public int getBlue() {

        return blue.getValue();
    }

    public String getHex() {

        String hex = "#";

        if (getRed() < 16)
            hex += "0" + Integer.toHexString(getRed());
        else
            hex += Integer.toHexString(getRed());
        if(getGreen() < 16)
            hex += "0" + Integer.toHexString(getGreen());
        else
            hex += Integer.toHexString(getGreen());
        if(getBlue() < 16)
            hex += "0" + Integer.toHexString(getBlue());
        else
            hex += Integer.toHexString(getBlue());
        return hex;
    }

    public void loadFile() {

        try(FileReader fr = new FileReader("data/color.dat")) {

            BufferedReader bufrea = new BufferedReader(fr);

            if(bufrea.readLine().equals("Color File Version 1.0")) {

                changeColorViaAbsoluteValue(ColorCode.RED, bufrea.readLine());
                changeColorViaAbsoluteValue(ColorCode.GREEN, bufrea.readLine());
                changeColorViaAbsoluteValue(ColorCode.BLUE, bufrea.readLine());

                System.out.println("Erfolgreich!");
            }

            else {

                System.out.println("Ladefehler!");
            }
        }

        catch (IOException ex) {

            System.out.println("Ladefehler!");
        }
    }

    public void saveFile() {

        try(FileWriter fw = new FileWriter("data/color.dat")) {

            BufferedWriter bufwri = new BufferedWriter(fw);

            bufwri.write("Color File Version 1.0");

            bufwri.newLine();
            bufwri.write(String.valueOf(getRed()));

            bufwri.newLine();
            bufwri.write(String.valueOf(getGreen()));

            bufwri.newLine();
            bufwri.write(String.valueOf(getBlue()));

            bufwri.close();

            System.out.println("Gespeichert!");
        }
        catch (IOException ex)
        {
            System.out.println("Speicherfehler!");
        }

    }
}