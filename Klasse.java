/**
  *
  * Beschreibung
  *
  * @version 0.8 vom 09.01.2017
  * @author Max Schaub
  */
import java.util.*;
public class Klasse extends BObjekt {
  
  // Anfang Attribute
  protected String klasse;
  protected String lehrer;
  ArrayList<HashMap<String,String>> liste;
  DB db = new DB();
  // Ende Attribute
  
  
  public Klasse(String klasse, String lehrer) {
    if (DB.isConnected()) {
      DB.executeUpdate("INSERT INTO klasse(klasse,lehrer); VALUES('"+klasse+"','"+lehrer+"')"); 
      this.klasse = klasse;
      this.lehrer = lehrer;
    } // end of if
    else {
      DB.verbinden();
      DB.executeUpdate("INSERT INTO klasse(klasse,lehrer); VALUES('"+klasse+"','"+lehrer+"')"); 
      this.klasse = klasse;
      this.lehrer = lehrer;
    } // end of if
  } // end of if-else
  
  public Klasse(String klasse){
    liste = new ArrayList<HashMap<String,String>>();
    if (DB.isConnected()) {
      liste = DB.getSQLResults("SELECT * FROM klasse WHERE klasse.klasse = '"+klasse+"';");
      this.klasse = klasse;
      this.lehrer = liste.get(0).get("lehrer");
    } // end of if
    else {
      DB.verbinden();
      liste = DB.getSQLResults("SELECT * FROM klasse WHERE klasse.klasse = '"+klasse+"';");
      this.klasse = klasse;
      this.lehrer = liste.get(0).get("lehrer");
    } // end of if-else
    
  }      
  
  public Klasse(HashMap<String,String> hash){
    this.klasse = hash.get("klasse");
    this.lehrer = hash.get("lehrer");
  }  
  
  // Anfang Methoden
  
  public int getKlassenID() {
    return 0;
  }  
  
  public String getID() {
    return null;  
  } 
  
  public String getName() {
    return null; 
  }   
  
  public String getKlasse() {
    return klasse;
  }

  public void setKlasse(String klasse) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE klasse SET klasse = '"+klasse+"' WHERE klasse ='"+this.klasse+"'");
      this.klasse = klasse;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE klasse SET klasse = '"+klasse+"' WHERE klasse ='"+this.klasse+"'");
        this.klasse = klasse;
      } // end of if
        else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    }
  }

  public String getLehrer() {
    return lehrer;
  }

  public void setLehrer(String lehrer) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE klasse SET lehrer = '"+lehrer+"' WHERE klasse ='"+this.klasse+"'");
      this.lehrer = lehrer;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE klasse SET lehrer = '"+lehrer+"' WHERE klasse ='"+this.klasse+"'");
        this.lehrer = lehrer;
      } // end of if
        else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    }
  }

  // Ende Methoden
} // end of Klasse
