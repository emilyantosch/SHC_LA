import java.io.*;

import namensverwaltung_util.*;

// Hauptklasse des Programms
public class Namensverwaltung {
    // Hauptmethode des Programms
    public static void main(String[] args) throws IOException {
        // Begrüßungsnachricht
        System.out.println("Moin!");

        // Erstellung von drei Personen
        namensverwaltung_util.Person person_1 = new Person("Max", "Mustermann", new Aenderungsdatum(21, 8, 2019));
        namensverwaltung_util.Person person_2 = new Person("Sarah", "Musterfrau", new Aenderungsdatum(15, 4, 2023));
        namensverwaltung_util.Person person_3 = new Person("Ulrike", "Meier", new Aenderungsdatum(19, 10, 2000));

        // Einrichtung der Eingabeaufforderung
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String input = "";
        boolean changeSuccess = false;
        int tag, monat, jahr;

        // Hauptprogrammschleife
        do {
            // Eingabeaufforderung
            System.out.println("Bitte geben Sie an, welche Person ihren Namen geändert haben möchte: (1, 2 oder 3). Mit 0 können Sie sich die Personen anzeigen lassen. Mit 4 beenden Sie das Programm. Drücken Sie bitte nach jeder Eingabe <Enter>");
            input = br.readLine();

            // Anzeigen der Personen
            if (input.equals("0")){
                System.out.println(person_1.toString());
                System.out.println(person_2.toString());
                System.out.println(person_3.toString());
            }
            // Beenden des Programms
            else if (input.equals("4")){
                break;
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
                        changeSuccess = person_1.setAenderungsdatum(new Aenderungsdatum(tag, monat, jahr));
                        if (changeSuccess){
                            person_1.setVorname(vorname);
                            person_1.setNachname(nachname);
                            System.out.println("Die Änderung des Namens war erfolgreich.");
                            System.out.println(person_1.toString());
                        }
                        break;
                    case "2":
                        changeSuccess = person_2.setAenderungsdatum(new Aenderungsdatum(tag, monat, jahr));
                        if (changeSuccess){
                            person_2.setVorname(vorname);
                            person_2.setNachname(nachname);
                            System.out.println("Die Änderung des Namens war erfolgreich.");
                            System.out.println(person_2.toString());
                        }
                        break;
                    case "3":
                        changeSuccess = person_3.setAenderungsdatum(new Aenderungsdatum(tag, monat, jahr));
                        if (changeSuccess){
                            person_3.setVorname(vorname);
                            person_3.setNachname(nachname);
                            System.out.println("Die Änderung des Namens war erfolgreich.");
                            System.out.println(person_3.toString());
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