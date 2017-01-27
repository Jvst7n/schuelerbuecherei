/**
  *
  * Suche stellt Methoden zur Generierung von einer ArrayList von "BObjekt" zur Verfügung.
  * Außerdem werden Prüfmethoden, ob eine ArrayList aus einem Objekt besteht, sowie welches Objekt dies ist, zur Verfügung.
  * 
  *
  * @author David, Jannis, Flo
  * @version 0.0.9
  *
  */


import java.util.ArrayList;
import java.util.HashMap;

public class Suche {
  
  /**
   * Methode "getListe" generiert eine ArrayList aus "BObjekt" - Je nach
   * Filter, evtl auch nur eine Art von Instanz von "BObjekt"
   *
   *
   * @param eingabe
   *            String in dem Suchfeld
   * @param filter
   *            Ergebnisfilter
   *
   *            Filter:   1       nur Personen 
   *                  2       nur Bücher
   *                  3       nur Verlaege
   *                  default   kein Filter
   *
   * @return ergebnis Ergebnis für die Suchabfrage
   */ 
  public static ArrayList<BObjekt> getListe(String eingabe, int filter) {
    ArrayList<BObjekt> ergebnis = new ArrayList<BObjekt>();

    switch (filter) {
      
    case 1:
      ergebnis = getPerson(eingabe);
      break;

    case 2:
      ergebnis = getBuch(eingabe);
      break;

    case 3:
      ergebnis = getVerlag(eingabe);
      break;

    default: 
      switch (Codes.what(eingabe)) {
      
      case 1: //eindeutig Buch (ISBN)
        ergebnis.addAll(getBuch(eingabe));
        return ergebnis;
          
      case 2: //eindeutig Person
        ergebnis.addAll(getSpezPerson(eingabe));
        return ergebnis;
        
      case 3: //eindeutig Buch (BIN)
        ergebnis.addAll(getSpezBuch(eingabe));
        return ergebnis;  
      
      default: break; 
        
      }
      ergebnis = getPerson(eingabe);
      ergebnis.addAll(getBuch(eingabe));
      ergebnis.addAll(getVerlag(eingabe));
      break;
      
    } // end of switch

    return ergebnis;
  }
  
  
  /**
   * Methode "getPerson" sendet eine Anfrage an die Datenbank und bekommt eine ArrayList aus Hashmaps.
   * Aus dieser werden Instanzen von "Person" generiert und in einer weiteren ArrayList zurückgegeben. 
   * 
   * @param eingabe Suchstring
   * @return ArrayList von Person
   */
  private static ArrayList<BObjekt> getPerson(String eingabe) {
    ArrayList<HashMap<String, String>> help = DB.getSQLResults("SELECT p1.pin, p1.vorname, p1.name, p1.klasse, p1.bemerkung, CONCAT(p2.vorname, ' ', p2.name) AS Tutor FROM person AS p1 LEFT JOIN person AS p2 ON p1.tutor = p2.pin WHERE CONCAT(p1.name, ' ', p1.vorname, ' ', p1.klasse) LIKE '%" + eingabe + "%'");
    ArrayList<BObjekt> ergebnis = new ArrayList<BObjekt>();
    for (HashMap<String, String> h : help){
      ergebnis.add(new Person(h));
    }
    
    return ergebnis;
  }
  
  /**
   * Methode "getBuch" sendet eine Anfrage an die Datenbank und bekommt eine ArrayList aus Hashmaps.
   * Aus dieser werden Instanzen von "Buch" generiert und in einer weiteren ArrayList zurückgegeben. 
   * 
   * @param eingabe Suchstring
   * @return ArrayList von Buch
   */
  private static ArrayList<BObjekt> getBuch(String eingabe) {
    ArrayList<HashMap<String, String>> help = DB.getSQLResults("SELECT bd.isbn, bd.titel, v.name, bd.autor, bd.preis, bd.bestellnummer, bd.fach FROM buchdetails AS bd LEFT JOIN verlag AS v ON bd.vin = v.vin WHERE CONCAT(bd.titel, ' ', bd.autor, ' ') LIKE '%" + eingabe + "%';");
    ArrayList<BObjekt> ergebnis = new ArrayList<BObjekt>();
    for (HashMap<String, String> h : help){
      ergebnis.add(new Buch(h));
    }
    
    return ergebnis;
  }

  /**
   * Methode "getVerlag" sendet eine Anfrage an die Datenbank und bekommt eine ArrayList aus Hashmaps.
   * Aus dieser werden Instanzen von "Verlag" generiert und in einer weiteren ArrayList zurückgegeben. 
   * 
   * @param eingabe Suchstring
   * @return ArrayList von Verlag
   */
  private static ArrayList<BObjekt> getVerlag(String eingabe) {
    ArrayList<HashMap<String, String>> help = DB.getSQLResults("SELECT v.vin, v.name, v.strasse, v.hausnummer, v.stadt, v.plz, v.telefonnummer, v.faxnummer, v.internetadresse, v.email FROM verlag AS v WHERE v.name LIKE '" + eingabe + "%';");
    ArrayList<BObjekt> ergebnis = new ArrayList<BObjekt>();
    for (HashMap<String, String> h : help){
      ergebnis.add(new Verlag(h));
    }
    
    return ergebnis;
  }
  
  /**
   * Methode "getSpezPerson" sendet eine Anfrage von einer einzelnen Person an die Datenbank und bekommt eine ArrayList aus Hashmaps.
   * Aus dieser wird <i>eine Instanz</i> von "Person" generiert und in einer weiteren ArrayList zurückgegeben. 
   * 
   * @param eingabe Suchstring
   * @return ArrayList mit einer Person
   */
   private static ArrayList<BObjekt> getSpezPerson(String eingabe) {
     ArrayList<HashMap<String, String>> help = DB.getSQLResults("SELECT p1.pin, p1.vorname, p1.name, p1.klasse, p1.bemerkung, concat(p2.vorname, ' ', p2.name) as Tutor from person as p1, person as p2, where p1.tutor = p2.pin, p1.pin = '" + eingabe + "';"); 
     ArrayList<BObjekt> ergebnis = new ArrayList<BObjekt>();
     ergebnis.add(new Person(help.get(0)));
     return ergebnis; 
   }
  
   /**
     * Methode "getSpezBuch" sendet eine Anfrage von einer einzelnen Person an die Datenbank und bekommt eine ArrayList aus Hashmaps.
     * Aus dieser wird <i>eine Instanz</i> von "Buch" generiert und in einer weiteren ArrayList zurückgegeben. 
     * 
     * @param eingabe Suchstring
     * @return ArrayList mit einem Buch
     */
   private static ArrayList<BObjekt> getSpezBuch(String eingabe) {
     ArrayList<HashMap<String, String>> help = DB.getSQLResults("SELECT bd.isbn, bd.titel, v.name, bd.autor, bd.preis, bd.bestellnummer, bd.fach, b.registrierungsdatum FROM buchdetails AS bd LEFT JOIN verlag AS v ON bd.vin = v.vin LEFT JOIN buch AS b ON bd.isbn = b.isbn WHERE b.bin = '" + eingabe + "';"); 
     ArrayList<BObjekt> ergebnis = new ArrayList<BObjekt>();
     ergebnis.add(new Buch(help.get(0)));
     return ergebnis; 
   }
   
   /** Prüfmethode ob eine in einer ArrayList genau ein Objekt vorhanden ist, sowie dieses Objekt eine "Person" ist.
    * 
    * @param liste ArrayList aus "BObjekt"
    * @return boolean - true, wenn <i>ein Objekt</i> eine "Person" ist.
    */
   public static boolean istPerson(ArrayList<BObjekt> liste) {
     return liste.size() == 1 && (liste.get(0) instanceof Person); 
   }
   
   /** Prüfmethode ob eine in einer ArrayList genau ein Objekt vorhanden ist, sowie dieses Objekt ein "Buch" ist.
    * 
    * @param liste ArrayList aus "BObjekt"
    * @return boolean - true, wenn <i>ein Objekt</i> ein "Buch" ist.
    */
   public static boolean istBuch(ArrayList<BObjekt> liste) {
     return liste.size() == 1 && (liste.get(0) instanceof Buch); 
   }
   
   
   /** Prüfmethode ob eine in einer ArrayList genau ein Objekt vorhanden ist, sowie dieses Objekt ein "Verlag" ist.
    * 
    * @param liste ArrayList aus "BObjekt"
    * @return boolean - true, wenn <i>ein Objekt</i> ein "Verlag" ist.
    */
   public static boolean istVerlag(ArrayList<BObjekt> liste) {
     return liste.size() == 1 && (liste.get(0) instanceof Verlag);
   }
   
   /** Prüfmethode ob eine in einer ArrayList genau ein Objekt vorhanden ist, sowie dieses Objekt "Buchdetails" ist.
    * 
    * @param liste ArrayList aus "BObjekt"
    * @return boolean - true, wenn <i>ein Objekt</i> "Buchdetails" ist.
    */
   public static boolean istBuchdetails(ArrayList<BObjekt> liste) {
     return liste.size() == 1 && (liste.get(0) instanceof Buchdetails); 
   }
  
  public static void main(String args[]) {
    ArrayList<BObjekt> liste = new ArrayList<BObjekt>();
    ArrayList<HashMap<String, String>> liste2 = new ArrayList<HashMap<String,String>>();
    
    DB db = new DB();    
    liste = Suche.getListe("Müller", 0);
    System.out.println(liste.get(0).getName());
    /*System.out.println(liste.get(1).getName());
    System.out.println(liste.get(2).getName());
    System.out.println(liste.get(3).getName());
    System.out.println(liste.get(4).getName());
    */
    
    /*
    int i = 10;
    for (BObjekt b : liste ) {
      System.out.println(b);
      if (i < 1) {
        return;
      } // end of if
      else {
        i--;
      } // end of if-else
    } // end of for
    
    */
  }
}