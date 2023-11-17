package namensverwaltung_util;

// Die Klasse Person repräsentiert eine Person mit Vorname, Nachname und Änderungsdatum.
public class Person {
    // Vorname der Person
    private String vorname;
    // Nachname der Person
    private String nachname;
    // Änderungsdatum der Person
    private Aenderungsdatum aenderungsdatum = new Aenderungsdatum(0, 0, 0);

    // Konstruktor der Klasse Person
    public Person(String vorname, String nachname, Aenderungsdatum aenderungsdatum) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.aenderungsdatum = aenderungsdatum;
    }

    // Gibt den Vornamen der Person zurück
    public String getVorname() {
        return this.vorname;
    }

    // Gibt den Nachnamen der Person zurück
    public String getNachname() {
        return this.nachname;
    }

    // Gibt das Änderungsdatum der Person zurück
    public Aenderungsdatum getAenderungsdatum() {
        return this.aenderungsdatum;
    }

    // Setzt das Änderungsdatum der Person, wenn die Drei-Jahres-Frist eingehalten wird
    public boolean setAenderungsdatum(Aenderungsdatum aenderungsdatum) {
        if (this.aenderungsdatum.checkDreiJahresFristWithJavaTime(aenderungsdatum.getTag(), aenderungsdatum.getMonat(), aenderungsdatum.getJahr()))
        {
            this.aenderungsdatum = aenderungsdatum;
            return true;
        }
        return false;
    }

    // Setzt den Vornamen der Person
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    // Setzt den Nachnamen der Person
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    // Gibt eine Zeichenkette mit den Informationen der Person zurück
    public String toString() {
        return "Vorname: " + this.vorname + ", Nachname: " + this.nachname + ", Aenderungsdatum: " + this.aenderungsdatum;
    }
}