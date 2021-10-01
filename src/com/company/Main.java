package com.company;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String valueInputSt;
        String currentUnit;
        String targetUnit = "x";
        double valueInputDb = 0;
        double valueOutput = 0;
        double valueInches = 0;
        String selector ="y";
        String selector1 = "n";

        Scanner scanner = new Scanner(System.in);
        System.out.println(("Welcome to the Unit Converter Application!"));

        while(Objects.equals(selector, "y")) {
            System.out.println("Input your current Value: ");

            while(Objects.equals(selector1, "n")) {
                valueInputSt = scanner.nextLine();
                selector1 = "y";
                try {
                    valueInputDb = Double.parseDouble(valueInputSt);
                }
                catch (Exception e) {
                    System.out.println("improper input, please enter a number");
                    selector1 = "n";
                }
            }
            selector1 = "n";
            //switch back to a "n" to so the play again function would work


            System.out.println("Input your current unit. (in, ft, yd, mile, mm, cm, m, km): ");
            currentUnit = scanner.nextLine();
            //error check
            while(!Arrays.asList("in", "ft", "yd", "mile", "mm", "cm", "m", "km").contains(currentUnit)){
                System.out.println("Please enter a unit as described above. (in, ft, yd, mile, mm, cm, m, km)");
                currentUnit = scanner.nextLine();
            }

            System.out.println("Input your target unit(in, ft, yd, mile, mm, cm, m, km: ): ");
            targetUnit = scanner.nextLine();
            //error check
            while(!Arrays.asList("in", "ft", "yd", "mile", "mm", "cm", "m", "km").contains(targetUnit)){
                System.out.println("Please enter a unit as described above. (in, ft, yd, mile, mm, cm, m, km)");
                targetUnit = scanner.nextLine();
            }

            valueInches = convertToInch(currentUnit, valueInputDb, valueInches);
            if(valueInches == -999) {
                System.out.println("Error");
                return;
            }
            // convert all inputs into inches regardless to simplify the process.


            valueOutput = convertFromInch(targetUnit, valueInches, valueOutput);
            if(valueOutput == -999) {
                System.out.println("Error");
                return;
            }
            // take the value in inches, and converts to the target unit
            System.out.println(valueOutput + " " + targetUnit);

            //Asks if you want to go again
            System.out.println("Would you Like to convert another Unit? (y/n): ");

            selector = scanner.nextLine();
        }
    }

    public static double convertToInch(String currentUnit, double valueInputDb, double valueInches){
        if(Objects.equals(currentUnit, "in")){
            valueInches = valueInputDb;
            System.out.println("Input unit in");
        }
        else if(Objects.equals(currentUnit, "ft")){
            valueInches = feetToInch(valueInputDb);
            System.out.println("Input unit ft");
        }
        else if(Objects.equals(currentUnit, "yd")){
            valueInches = yardsToInch(valueInputDb);
            System.out.println("Input unit yd");
        }
        else if(Objects.equals(currentUnit, "mile")){
            valueInches = milesToInch(valueInputDb);
            System.out.println("Input unit mile");
        }
        else if(Objects.equals(currentUnit, "mm")){
            valueInches = millimetersToInch(valueInputDb);
            System.out.println("Input unit mm");
        }
        else if(Objects.equals(currentUnit, "cm")){
            valueInches = centimetersToInch(valueInputDb);
            System.out.println("Input unit cm");
        }
        else if(Objects.equals(currentUnit, "m")){
            valueInches = metersToInch(valueInputDb);
            System.out.println("Input unit m");
        }
        else if(Objects.equals(currentUnit, "km")){
            valueInches = kilometersToInch(valueInputDb);
            System.out.println("Input unit km");
        }
        else{
            System.out.println("improper unit input");
            return(-999);
        }
        return valueInches;
    }

    public static double convertFromInch(String targetUnit, double valueInches, double valueOutput){
        if(Objects.equals(targetUnit, "in")){
            valueOutput = valueInches;
            System.out.println("output unit in");
        }
        else if(Objects.equals(targetUnit, "ft")){
            valueOutput = inchToFeet(valueInches);
            System.out.println("output unit ft");
        }
        else if(Objects.equals(targetUnit, "yd")){
            valueOutput = inchToYards(valueInches);
            System.out.println("output unit yd");
        }
        else if(Objects.equals(targetUnit, "mile")){
            valueOutput = inchToMiles(valueInches);
            System.out.println("output unit mile");
        }
        else if(Objects.equals(targetUnit, "mm")){
            valueOutput = inchToMillimeters(valueInches);
            System.out.println("output unit mm");
        }
        else if(Objects.equals(targetUnit, "cm")){
            valueOutput = inchToCentimeters(valueInches);
            System.out.println("output unit cm");
        }
        else if(Objects.equals(targetUnit, "m")){
            valueOutput = inchToMeters(valueInches);
            System.out.println("output unit m");
        }
        else if(Objects.equals(targetUnit, "km")){
            valueOutput = inchToKilometers(valueInches);
            System.out.println("output unit km");
        }
        else{
            System.out.println("improper unit output");
            return(-999);
        }

        return(valueOutput);
    }
    public static double feetToInch(double a) {
        return(a * 12);
    }
    public static double yardsToInch(double a) {
        return (a * 36);
    }
    public static double milesToInch(double a) {
        return (a * 63360);
    }
    public static double millimetersToInch(double a) {
        return(a / 25.4);
    }
    public static double centimetersToInch(double a) {
        return(a / 2.54);
    }
    public static double metersToInch(double a) {
        return(a * 39.37);
    }
    public static double kilometersToInch(double a) {
        return(a * 39370);
    }
    public static double inchToFeet(double a) {
        return(a / 12);
    }
    public static double inchToYards(double a) {
        return (a / 36);
    }
    public static double inchToMiles(double a) {
        return (a / 63360);
    }
    public static double inchToMillimeters(double a) {
        return(a * 25.4);
    }
    public static double inchToCentimeters(double a) {
        return(a * 2.54);
    }
    public static double inchToMeters(double a) {
        return(a / 39.37);
    }
    public static double inchToKilometers(double a) {
        return(a / 39370);
    }
}