package org.azimjon.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Kata {
    public static void main(String[] args) {
        System.out.println();
    }

    public static Double calculate(final double numberOne, final String operation, final double numberTwo) {
        Double Result = null;
        switch (operation) {
            case "+":
                Result = numberOne + numberTwo;
                break;
            case "-":
                Result = numberOne - numberTwo;
                break;
            case "*":
                Result = numberOne * numberTwo;
                break;
            case "/":
                if (numberTwo == 0) {
                    Result = null;
                } else {
                    Result = numberOne / numberTwo;
                }
                break;
            case "m":
                Result = null;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return Result;
    }

}