package namensverwaltung_util;

import java.time.LocalDate;

// Klasse zur Verwaltung des Änderungsdatums
public class Aenderungsdatum {
    
    // Attribute für Tag, Monat und Jahr
    private int tag;
    private int monat;
    private int jahr;

    // Konstruktor
    public Aenderungsdatum(int tag, int monat, int jahr) {
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }

    // Getter und Setter Methoden
    public int getTag() {
        return this.tag;
    }
    public int getMonat(){
        return this.monat;
    }
    public int getJahr(){
        return this.jahr;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public void setMonat(int monat) {
        //Überprüfen des Monats auf Plausibilität
        //Es gibt keine Monate, die kleiner als 0 oder größer als 12 sind
        if(monat > 12 || monat < 0){
          System.out.println("Die Eingabe des Monats ist inkorrekt. Bitte versuchen Sie es erneut");
        } else {
          this.monat = monat;
        }
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    // Methode zur Darstellung des Datums als String
    public String toString() {
        return "Tag: " + this.tag + ", Monat: " + this.monat + ", Jahr: " + this.jahr;
    }

    //Die folgende Funktion nutzt die Java.time.LocalDate Klasse um zu prüfen ob die 3 Jahresfrist eingehalten wurde
    //Diese vorgefertigte Klasse gibt es erst seit Java 8
    //Es gibt natürlich auch andere Möglichkeiten, diese zu implementieren
    //Sie können auch die Daten mittels Strings überprüfen. Dies ist aber nicht so elegant. Schön wäre es aber, für das Aenderungsdatum eine eigene Klasse zu erstellen.
    //Die Klasse, die hier geschrieben wurde, kann beide Varianten beinhalten. Wenn Sie die Lösung des Problems mittels Java.Time machen wollen, würde auch eine Wrapper-Klasse um java.time.localDate reichen. 
    //Diese kann allerdings nicht mehr erweitert werden, da LocalDate final ist.

    public boolean checkDreiJahresFristWithJavaTime(int tag, int monat, int jahr){
        LocalDate date = LocalDate.of(jahr, monat, tag);

        LocalDate letztesAenderungsDatum = LocalDate.of(this.jahr, this.monat, this.tag);

        if (letztesAenderungsDatum.plusYears(3).isBefore(date) || letztesAenderungsDatum.plusYears(3).isEqual(date)){
            return true;
        } else {
            return false;
        }

    }
    //Dieser Code zählt die Differenz zwischen dem letzten Änderungsdatum und dem angegebnen Datum in Sekunden aus und vergleicht diese mit der Anzahl an Sekunden in 3 Jahren. 
    // Dies ist nicht so elegant wie die Lösung mit Java.time, aber es funktioniert auch.
    // Besonders die readablility leidet hier.
    public boolean checkDreiJahresFristWithoutJavaTime(int tag, int monat, int jahr){
        if ((jahr-this.jahr) * 31536000 + (monat - this.monat) * 2592000 + (tag - this.tag) * 86400 >= 94608000){
            return true;
        } else {
            return false;
        }
    }
}

