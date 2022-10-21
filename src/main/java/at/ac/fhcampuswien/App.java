package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static


    public static void guessingGame(int numberToGuess) {
        //Spieler erhält 10 Versuche eine Zufallszahl zu erraten + erhält Hinweise, ob die gewählte Zahl zu hoch / niedrig ist.
        Scanner scan = new Scanner(System.in);
        int counter = 1; //Guess-count
        int input; //User-input

        while (counter <= 10) { //Max. 10 Versuche sind erlaubt.
            System.out.print("Guess number " + counter + ": ");
            input = scan.nextInt();

            if (input == numberToGuess) {
                System.out.println("You won wisenheimer!");
                return;
            } else {
                if (counter < 10) {
                    if (input > numberToGuess) System.out.println("The number AI picked is lower than your guess.");
                    else System.out.println("The number AI picked is higher than your guess.");
                } else System.out.println("You lost! Have you ever heard of divide & conquer?");

            }
            counter++;
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random zufallszahlenGenerator = new Random();
        int zufallszahl = zufallszahlenGenerator.nextInt(100) + 1; //+1 ist notwendig, damit die Zufallszahl auch 100 sein kann.
        return (zufallszahl); //Gibt die erstellte Zufallszahl zurück.
    }

    public static boolean swapArrays(int array1[], int array2[]) {
        int length1 = array1.length; //Speichert Länge des Arrays
        int length2 = array2.length;

        if (length1 != length2) { //Bedingung: Es können nur gleich große Arrays getauscht werden - wird hiermit überprüft.
            return (false);
        }
        for (int count = 0; count < array2.length; count++) {
            array1[count] = array1[count] + array2[count]; //Speichert Werte aus Array 1+2 in Array 1
            array2[count] = array1[count] - array2[count]; //Speichert die getauschten Werte in Array 2
            array1[count] = array1[count] - array2[count]; //Berechnet die getauschten Werte und speichert in Array 1
        }

        return (true); //Methode soll nur false oder true ausgeben laut Angabe.
    }


    public static String camelCase(String eingabe) { //Gibt einen String zurück!

        char[] inputText = eingabe.toCharArray(); //String to array.

        boolean asciiUpperCase; //returns true / false
        boolean asciiLowerCase; //ret. true / false
        String finalOutput = ""; // Leerer String, wird später befüllt
        char platzhalter;

        for (int counter = 0; counter < inputText.length; counter++) {
            platzhalter = inputText[counter];
            //Verwenden der ascii boolean um Groß-/Kleinbuchstaben zu identifizieren, Zahlen reflektieren ASCII Rang (Dezimal)

            asciiLowerCase = platzhalter > 96 && platzhalter < 123; //Kleinbuchstaber sind rangmäßig nach Großbuchstaben in der Tabelle.
            asciiUpperCase = platzhalter > 64 && platzhalter < 91; // Gibt true/fals zurück

            if (counter != 0) {
                boolean leerzeichen = inputText[counter - 1] == 32;
                if (leerzeichen) { //-32, da Leerzeichen Nr. 32 in der ASCII Tabelle hat
                    if (asciiLowerCase) finalOutput += (char) (platzhalter - 32);
                    if (asciiUpperCase) finalOutput += platzhalter;
                } //Operationen + bzw. - 32, da Groß- und Kleinbuchstaben genau 32 "Nummern" auf der ASCII Tabelle auseinander liegen.
                else {
                    if (asciiLowerCase) finalOutput += platzhalter;
                    if (asciiUpperCase) finalOutput += (char) (platzhalter + 32);
                }
            } else {
                if (asciiUpperCase) finalOutput += platzhalter;
                if (asciiLowerCase) finalOutput += (char) (platzhalter - 32);
            }
        }
        return finalOutput;

    }


    public static void oneMonthCalender(int tage_max, int start) {



        int arrayDays[] = new int[tage_max];
        int oneWeek = 7 - start + 1;

        for (int count = 0; count < arrayDays.length; count++) {
            arrayDays[count] = count + 1;
        }
        for (int count = 1; count < start; count++) {
            System.out.print("   "); //Rückt die Zahlen am Anfang abhängig vom Starttag ein.
        }
        //oneWeek = oneWeek - start + 1;
        for (int count = 1; count < arrayDays.length; count++) { //Start = 1, da Monat mit 1 beginnt.
            String tag = String.format("%2d" + arrayDays[count - 1]);
            System.out.print(tag + " ");
            oneWeek--;
            if (count == arrayDays.length || oneWeek == 0) {

                System.out.println();
                oneWeek = 7;
            }

        }
    }




    public static int checkDigit(int input []) {
        //Modulo 11 Verfahren
        if (input.length >= 10){ //Nur Zahlen zwischen 0 - 9 erlaubt.
            return (-1);
        }

        int summeAusEingabe = 0;
        for (int count = 0; count < input.length; count ++) {
            summeAusEingabe += input[count] * (count + 2); //* (count+2) berücksichtigt Gewichtung lt. Angabe
            //Gewichtung = Position der Ziffer + 2

        }
        int prüfziffer = 11 - (summeAusEingabe % 11); //Verfahren lt. Angabe bzw. Modulo 11 Verfahren

        //Prüfen der Ausnahmen des Verfahrens:
        if (prüfziffer == 11) { //Ausnahme: Bei 11 soll 5 Ausgegeben werden.
            return (5);
        }
        if (prüfziffer == 10) { //Ausnahme: Bei 10 soll 0 Ausgegeben werden.
            return (0);
        }
        return prüfziffer;
    }




    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.



        //oneMonthCalender(31,3);

            //App.guessingGame(randomNumberBetweenOneAndHundred());

            //App.swapArrays();

            //App.camelCase("This is a beautiful test sentence !?");


        }
    }
