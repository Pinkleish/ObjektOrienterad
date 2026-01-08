package controller;

import model.CalcTypes;

public class Calculator
{
    private double number1;
    private double number2;
    CalcTypes calcType;

    public double calculate()
    {
        double result = 0;
        switch (calcType)
        {
            case Add:
                result = addNumbers();
                break;
            case Subtract:
                result = subtractNumbers();
                break;
            case Multiply:
                result = multiplyNumbers();
                break;
            case Divide:
                result = divideNumbers();
                break;
            case SquareRoot:
                result = squareNumbers();
                break;
        }
        return result;
    }

    private double addNumbers()
    {
        return number1+number2;
    }

    private double subtractNumbers()
    {
        return number1-number2;
    }

    private double multiplyNumbers()
    {
        return number1*number2;
    }

    private double divideNumbers()
    {
        return number1/number2;
    }

    private double squareNumbers()
    {
        return Math.sqrt(number1);
    }

    //<editor-fold desc="getters and setters">
    public double getNumber1()
    {
        return number1;
    }

    public void setNumber1(double number1)
    {
            this.number1 = number1;
    }

    public double getNumber2()
    {
        return number2;
    }

    public void setNumber2(double number2) {
            this.number2 = number2;
    }

    public CalcTypes getCalcType()
    {
        return calcType;
    }

    public void setCalcType(CalcTypes calcType)
    {
        this.calcType = calcType;
    }
    //</editor-fold >
    public CalcTypes fromIntToCakcType(int index) {
        CalcTypes[] values = CalcTypes.values();

        assert (index < values.length) : "Error in method framInt";

        if (index >= values.length) {
            throw new IllegalArgumentException("Out of index!");
        }
        return values[index];
    }

    public String fromIntToString(int index) {
        CalcTypes[] values = CalcTypes.values();

        assert (index < values.length) : "Error in method framInt";

        if (index >= values.length) {
            throw new IllegalArgumentException("Out of index!");
        }
        return values[index].name();
    }

    public String getCalcTypeSymbol()
    {
        String symbol = "";
        switch (calcType)
        {
            case Add:
                symbol = "+";
                break;
            case Subtract:
                symbol = "-";
                break;
            case Multiply:
                symbol = "*";
                break;
            case Divide:
                symbol = "/";
                break;
            case SquareRoot:
                symbol = "Square root of";
                break;
        }
        return symbol;
    }

}

