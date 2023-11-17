import java.io.*;

import namensverwaltung_util.*;

// Hauptklasse des Programms
public class Namensverwaltung {
    // Hauptmethode des Programms
    public static void main(String[] args) throws IOException {
        // Begrüßungsnachricht
        System.out.println("Moin!");

        // Erstellung von drei Personen in einem Arrray
        Person[] personen = {new Person("Max", "Mustermann", new Aenderungsdatum(21, 8, 2019)), new Person("Sarah", "Musterfrau", new Aenderungsdatum(15, 4, 2023)), new Person("Ulrike", "Meier", new Aenderungsdatum(19, 10, 2000))};
        // Einrichtung der Eingabeaufforderung
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String input = "";
        boolean changeSuccess = false;
        int tag, monat, jahr;

        // Hauptprogrammschleife
        do {
            // Eingabeaufforderung
            System.out.println("Bitte geben Sie an, welche Person ihren Namen geändert haben möchte: (1, 2 oder 3). Mit 0 können Sie sich die Personen anzeigen lassen. Mit 5 können Sie sich anschauen, wie viele Personen zurzeit gemeldet sind. Mit 4 beenden Sie das Programm. Drücken Sie bitte nach jeder Eingabe <Enter>");
            input = br.readLine();

            // Anzeigen der Personen
            if (input.equals("0")){
                System.out.println(personen[0].toString());
                System.out.println(personen[1].toString());
                System.out.println(personen[2].toString());
            }
            // Beenden des Programms
            else if (input.equals("4")){
                break;
            // Anzeigen der Anzahl der Personen
            }else if (input.equals("5")){
              System.out.println("Es gibt zurzeit " + Person.personenAnzahl + " Personen.");
            }
            else{
                // Eingabe des neuen Namens und des Änderungsdatums
                System.out.println("Bitte geben Sie den neuen Vornamen ein:");
                String vorname = br.readLine();
                System.out.println("Bitte geben Sie den neuen Nachnamen ein:");
                String nachname = br.readLine();
                System.out.println("Bitte geben Sie auch an, ab wann die Änderung des Namens gültig sein soll: Tag, Monat, Jahr. Drücken Sie bitte nach jeder Eingabe <Enter>");
                System.out.println("Tag:");
                tag = Integer.parseInt(br.readLine());
                System.out.println("Monat:");
                monat = Integer.parseInt(br.readLine());
                System.out.println("Jahr:");
                jahr = Integer.parseInt(br.readLine());

                // Änderung des Namens und des Änderungsdatums
                switch(input) {
                    case "1": 
                        changeSuccess = personen[0].setAenderungsdatum(new Aenderungsdatum(tag, monat, jahr));
                        if (changeSuccess){
                            personen[0].setVorname(vorname);
                            personen[0].setNachname(nachname);
                            System.out.println("Die Änderung des Namens war erfolgreich.");
                            System.out.println(personen[0].toString());
                        }
                        break;
                    case "2":
                        changeSuccess = personen[1].setAenderungsdatum(new Aenderungsdatum(tag, monat, jahr));
                        if (changeSuccess){
                            personen[1].setVorname(vorname);
                            personen[1].setNachname(nachname);
                            System.out.println("Die Änderung des Namens war erfolgreich.");
                            System.out.println(personen[1].toString());
                        }
                        break;
                    case "3":
                        changeSuccess = personen[2].setAenderungsdatum(new Aenderungsdatum(tag, monat, jahr));
                        if (changeSuccess){
                            personen[2].setVorname(vorname);
                            personen[2].setNachname(nachname);
                            System.out.println("Die Änderung des Namens war erfolgreich.");
                            System.out.println(personen[2].toString());
                        }
                        break;
                }

                // Überprüfung, ob die Änderung erfolgreich war
                if (!changeSuccess){
                    System.out.println("Die Änderung des Namens war nicht erfolgreich. Die Frist von 3 Jahren wurde nicht eingehalten.");
                }
            }
        } while(input != "4");

        // Beenden des Programms
        System.out.println("Das Programm wird nun beendet.");
    }
}
