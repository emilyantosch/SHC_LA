package namensverwaltung_util;

public class Studierende extends Person {
    private int immatrikulationsnummer = 1001;
    public static final int MAX_ANZAHL = 500;

   public Studierende(String vorname, String nachname, Aenderungsdatum aenderungsdatum){
       super(vorname, nachname, aenderungsdatum);
       immatrikulationsnummer = (immatrikulationsnummer + personenAnzahl) - 1;
   }

    public int getImmatrikulationsnummer(){
        return immatrikulationsnummer;
    }

    public void setImmatrikulationsnummer(int immatrikulationsnummer){
        this.immatrikulationsnummer = immatrikulationsnummer;
    }

    public String toString(){
        return "Vorname: " + getVorname() + ", Nachname: " + getNachname() + ", Aenderungsdatum: " + getAenderungsdatum() + ", Immatrikulationsnummer: " + this.immatrikulationsnummer;
    }
}
