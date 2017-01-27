/**
  *
  * Beschreibung:
  *
  * @version 1.0 vom 09.01.2017
  * @author Mostafa Hamied
  */
import java.awt.*;
import java.util.*;
public class Person extends BObjekt{
  // Anfang Attribute
  protected String pin;
  protected String vorname;
  protected String nachname;
  protected String bemerkung;
  protected String klasse;
  protected int tutor;
  ArrayList<HashMap<String,String>> liste;
  ArrayList<Buch> buchliste;
  DB db = new DB();
  Codes codes = new Codes();
  
  // Ende Attribute
  /** Konstruktur erstellt neue Person
  */
  public Person(String vorname, String nachname, String klasse,int tutor,String bemerkung){
    String code = codes.createPIN();
    if (DB.isConnected()) {
      DB.executeUpdate("INSERT INTO person(pin,vorname,name,klasse,tutor,bemerkung) VALUES("+code+",'"+vorname+"','"+nachname+"','"+klasse+"',"+tutor+",'"+bemerkung+"')");
      this.pin = code;
      this.vorname = vorname;
      this.nachname = nachname;
      this.bemerkung = bemerkung;
      this.klasse = klasse;
      this.tutor = tutor;    
    } // end of if
    else {
      DB.verbinden();
      DB.executeUpdate("INSERT INTO person(pin,vorname,name,klasse,tutor,bemerkung); VALUES("+code+","+vorname+","+nachname+","+klasse+","+tutor+","+bemerkung+")");
      this.pin = code;
      this.vorname = vorname;
      this.nachname = nachname;
      this.bemerkung = bemerkung;
      this.klasse = klasse;
      this.tutor = tutor;         
    } // end of if-else
  } 
  /** Konstruktor lädt Person aus der Datenbank
   */  
  public Person(String pin){
    liste = new ArrayList<HashMap<String,String>>();
    if (DB.isConnected()) {
      liste = DB.getSQLResults("SELECT * FROM person WHERE person.pin = "+pin+";");
      System.out.println("SELECT * FROM person WHERE person.pin = "+pin+";");
      this.pin = pin;
      this.vorname = liste.get(0).get("vorname");
      this.nachname = liste.get(0).get("name");
      this.bemerkung = liste.get(0).get("bemerkung");
      this.klasse = liste.get(0).get("klasse");
      this.tutor = Integer.parseInt(liste.get(0).get("tutor"));
    } // end of if
    else {
      DB.verbinden();
      liste = DB.getSQLResults("SELECT * FROM person WHERE person.pin = "+pin+";");
      this.pin = pin;
      this.vorname = liste.get(0).get("vorname");
      this.nachname = liste.get(0).get("name");
      this.bemerkung = liste.get(0).get("bemerkung");
      this.klasse = liste.get(0).get("klasse");
      this.tutor =  Integer.parseInt(liste.get(0).get("tutor"));
    } // end of if-else
    
  }      
  
  public Person(HashMap<String,String> hash){
    this.pin = hash.get("pin");
    this.vorname = hash.get("vorname");
    this.nachname = hash.get("name");
    this.bemerkung = hash.get("bemerkung");
    this.klasse = hash.get("klasse");
    this.tutor = Integer.parseInt(hash.get("tutor"));
  }  
  // 
  
  
  // Anfang Methoden
  public String getID(){
    return pin;
  }
  public String getName(){
    return (vorname +" "+ nachname);
  }
  public String getPin() {
    return pin;
  }
  public void setPin(String pin) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE person SET pin = '"+pin+"' WHERE pin ='"+this.pin+"'");
      this.pin = pin;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE person SET pin = '"+pin+"' WHERE pin ='"+this.pin+"'"); 
        this.pin = pin;
      } // end of if
      else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    } // end of if-else
  }
  public String getVorname() {
    return vorname;
  }
  public void setVorname(String vorname) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE person SET vorname = '"+vorname+"' WHERE pin ='"+this.pin+"'");
      this.vorname = vorname;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE person SET vorname = '"+vorname+"' WHERE pin ='"+this.pin+"'");
        this.vorname = vorname;
      } // end of if
      else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    } // end of if-else
  }
  public String getNachname() {
    return nachname ;
  }
  public void setNachname(String nachname) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE person SET nachname = '"+nachname+"' WHERE pin ='"+this.pin+"'");
      this.nachname = nachname;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE person SET nachname = '"+nachname+"' WHERE pin ='"+this.pin+"'");
        this.nachname = nachname;  
      } // end of if
       else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    } // end of if-else
  }
  public String getBemerkung() {
    return bemerkung;
  }
  public void setBemerkung(String bemerkung) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE person SET bemerkung = '"+bemerkung+"' WHERE pin ='"+this.pin+"'");
      this.bemerkung = bemerkung;
      System.out.println("UPDATE person SET bemerkung = '"+bemerkung+"' WHERE pin ='"+this.pin+"'");
    } // end of if
    else {
      DB.verbinden();      
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE person SET bemerkung = '"+bemerkung+"' WHERE pin ='"+this.pin+"'");
        this.bemerkung = bemerkung;
      } // end of if
       else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    } // end of if-else
  }
  public String getKlasse(){
    return klasse;
  }
  public void setKlasse(String klasse){
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE person SET klasse = '"+klasse+"' WHERE pin ='"+this.pin+"'");
      this.klasse = klasse;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE person SET klasse = '"+klasse+"' WHERE pin ='"+this.pin+"'");
        this.klasse = klasse;
      } // end of if
     
    } // end of if-else
    }
  public int getTutor(){
    return tutor;
    }
  public void setTutor(int tutor){
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE person SET tutor = '"+tutor+"' WHERE pin ='"+this.pin+"'");
      this.tutor = tutor;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE person SET tutor = '"+tutor+"' WHERE pin ='"+this.pin+"'");
        this.tutor = tutor;
      } // end of if
        else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    } // end of if-else
    }
  
  /**
   * 0 = person
   */ 
   
  public int getKlassenID(){
    return 0;
    }
  /** loescht Person aus der Datenbank
    * @param pin
    */
  public void loeschen(String pin){
    if (DB.isConnected()) {
      if (istVorhanden(pin) == true) {
        DB.executeUpdate("DELETE FROM person WHERE pin ="+pin+";");
      } // end of if
      else {
        System.out.println("Person nicht vorhanden.");
      } // end of if-else
    } // end of if
    else {
      DB.verbinden();
      if (istVorhanden(pin) == true) {
        DB.executeUpdate("DELETE FROM person WHERE pin ="+pin+";");
      } // end of if
      else {
        System.out.println("Person nicht vorhanden.");
      } // end of if-else
    } // end of if-else
    
  }
  
  public boolean istVorhanden(String pin){
    liste = new ArrayList<HashMap<String,String>>() ;
    if (DB.isConnected()) {
      liste = DB.getSQLResults("SELECT pin FROM person WHERE pin="+this.pin+");");
    } // end of if
    else {
      DB.verbinden();
      liste = DB.getSQLResults("SELECT pin FROM person WHERE pin="+this.pin+");");
    } // end of if-else
    return liste.isEmpty() ;
  }      
  
  public static void main(String[] args){
    Person p1 = new Person("00022149");
    p1.loeschen("1216475");
    System.out.println(p1.getNachname());
  }
}
