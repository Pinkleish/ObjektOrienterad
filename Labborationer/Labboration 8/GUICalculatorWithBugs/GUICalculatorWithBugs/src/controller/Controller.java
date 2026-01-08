package controller;

import view.MainFrame;
import model.*;

public class Controller
{
    private MainFrame view;
    private Calculator calculator;  //model


    public Controller()
    {
        view = new MainFrame(this);
    }

    public CalcTypes [] getCalcTypes()
    {
        return CalcTypes.values();
    }

    public void calculate(int calcTypeIndex, String strNum1, String strNum2)
    {
        calculator = new Calculator();

        double number1;
        try{
            number1 = Double.parseDouble(strNum1);
            calculator.setNumber1(number1);

        } catch (NumberFormatException e){
            System.out.println("Invalid number1");
            return;
        }

        calculator.setCalcType(calculator.fromIntToCakcType(calcTypeIndex));


        if (calculator.fromIntToCakcType(calcTypeIndex) == CalcTypes.SquareRoot){
            calculator.setNumber2(0);
        }
        else {
            try{
                calculator.setNumber2(Double.parseDouble(strNum2));
            } catch(NumberFormatException e){
                System.out.println("Invalid number2");
                return;
            }


        }

        double number2 = calculator.getNumber2();



        calculator.calculate();
        double result = calculator.calculate();
        String calcTypeSymbol = calculator.getCalcTypeSymbol(); //+, - etc

        if (calculator.calcType != CalcTypes.SquareRoot)
            view.setResult(String.format( "%.2f %s %.2f = %.2f", number1, calcTypeSymbol,number2, result));
        else
            view.setResult(String.format( "%s (%.2f) = %.2f", calcTypeSymbol, number1, result));
    }


    public void calcTypeChanged(int index)
    {
        CalcTypes calcType = calculator.fromIntToCakcType(index);
        if (calcType == CalcTypes.Divide)
            view.setInputLabels("Nämnare", "Täljare");
         else
            view.setInputLabels("Number 1", "Number 2");
    }
}