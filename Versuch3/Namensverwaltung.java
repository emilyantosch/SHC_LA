import java.io.*;

import namensverwaltung_util.*;

// Hauptklasse des Programms
public class Namensverwaltung {
    // Hauptmethode des Programms
    public static void main(String[] args) throws IOException {
        // Begrüßungsnachricht
        System.out.println("Moin!");

        // Erstellung von drei Personen in einem Arrray
        Studierende[] studierende = {new Studierende("Max", "Mustermann", new Aenderungsdatum(21, 8, 2019)), new Studierende("Sarah", "Musterfrau", new Aenderungsdatum(15, 4, 2023)), new Studierende("Ulrike", "Meier", new Aenderungsdatum(19, 10, 2000))};
        // Einrichtung der Eingabeaufforderung
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String input = "";
        boolean changeSuccess = false;
        int tag, monat, jahr;

        // Hauptprogrammschleife
        do {
            // Eingabeaufforderung
            System.out.println("Bitte geben Sie an, welche Studierende ihren Namen geändert haben möchte: (1, 2 oder 3). Mit 0 können Sie sich die Studierende anzeigen lassen. Mit " + (Studierende.MAX_ANZAHL + 1) + " können Sie sich anschauen, wie viele Studierende zurzeit gemeldet sind. Mit " + (Studierende.MAX_ANZAHL + 2) + " beenden Sie das Programm. Drücken Sie bitte nach jeder Eingabe <Enter>");
            input = br.readLine();

            // Anzeigen der Personen
            if (input.equals("0")){
                System.out.println(studierende[0].toString());
                System.out.println(studierende[1].toString());
                System.out.println(studierende[2].toString());
            }
            // Beenden des Programms
            else if (input.equals(Integer.toString(Studierende.MAX_ANZAHL + 2))){
                break;
            // Anzeigen der Anzahl der Personen
            }else if (input.equals(Integer.toString(Studierende.MAX_ANZAHL + 1))){
              System.out.println("Es gibt zurzeit " + Person.personenAnzahl + " Studierende.");
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
                        changeSuccess = studierende[0].setAenderungsdatum(new Aenderungsdatum(tag, monat, jahr));
                        if (changeSuccess){
                            studierende[0].setVorname(vorname);
                            studierende[0].setNachname(nachname);
                            System.out.println("Die Änderung des Namens war erfolgreich.");
                            System.out.println(studierende[0].toString());
                        }
                        break;
                    case "2":
                        changeSuccess = studierende[1].setAenderungsdatum(new Aenderungsdatum(tag, monat, jahr));
                        if (changeSuccess){
                            studierende[1].setVorname(vorname);
                            studierende[1].setNachname(nachname);
                            System.out.println("Die Änderung des Namens war erfolgreich.");
                            System.out.println(studierende[1].toString());
                        }
                        break;
                    case "3":
                        changeSuccess = studierende[2].setAenderungsdatum(new Aenderungsdatum(tag, monat, jahr));
                        if (changeSuccess){
                            studierende[2].setVorname(vorname);
                            studierende[2].setNachname(nachname);
                            System.out.println("Die Änderung des Namens war erfolgreich.");
                            System.out.println(studierende[2].toString());
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
