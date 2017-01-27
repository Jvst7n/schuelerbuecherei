/**
  *
  * Beschreibung
  *
  * @version 0.99 vom 27.01.2017
  * @author Max Schaub
  */
import java.util.*;
public class Verlag extends BObjekt {
  
  // Anfang Attribute
  protected String vin;
  protected String name;
  protected String strasse;
  protected String hausnummer;
  protected String stadt;
  protected String plz;
  protected String tel;
  protected String fax;
  protected String website;
  protected String email;
  DB db = new DB();
  Codes codes = new Codes();
  ArrayList<HashMap<String,String>> liste;
  // Ende Attribute
  
  
  public Verlag(String name, String strasse,String hausnummer, String stadt,String plz,String tel, String fax, String website, String email){
    //String code = codes.createVIN();
    if (DB.isConnected()) {
      DB.executeUpdate("INSERT INTO verlag(vin,name,strasse,hausnummer,stadt,plz,tel,fax,website,email) VALUES('"+vin+"','"+name+"','"+strasse+"','"+hausnummer+"','"+stadt+"','"+plz+"','"+tel+"','"+fax+"','"+website+"','"+email+"')");
      this.vin = vin;
      this.name = name;
      this.strasse = strasse;
      this.hausnummer = hausnummer;
      this.stadt = stadt;
      this.plz = plz;
      this.tel = tel;
      this.fax = fax;
      this.website = website;
      this.email = email;   
    } // end of if
    else {
      DB.verbinden();
      DB.executeUpdate("INSERT INTO verlag(vin,name,strasse,hausnummer,stadt,plz,tel,fax,website,email) VALUES('"+vin+"','"+name+"','"+strasse+"','"+hausnummer+"','"+stadt+"','"+plz+"','"+tel+"','"+fax+"','"+website+"','"+email+"')");
      this.vin = vin;
      this.name = name;
      this.strasse = strasse;
      this.hausnummer = hausnummer;
      this.stadt = stadt;
      this.plz = plz;
      this.tel = tel;
      this.fax = fax;
      this.website = website;
      this.email = email;         
    } // end of if-else
  } 
  
  public Verlag(String vin){
    liste = new ArrayList<HashMap<String,String>>();
    if (DB.isConnected()) {
      liste = DB.getSQLResults("SELECT * FROM verlag WHERE verlag.vin = "+vin+";");
      this.vin = vin;
      this.name = liste.get(0).get("name");
      this.strasse = liste.get(0).get("strasse");
      this.hausnummer = liste.get(0).get("hausnummer");
      this.stadt = liste.get(0).get("stadt");
      this.plz = liste.get(0).get("plz");
      this.tel = liste.get(0).get("tel");
      this.fax = liste.get(0).get("fax");
      this.website = liste.get(0).get("website");
      this.email = liste.get(0).get("email");
    } // end of if
    else {
      DB.verbinden();
      liste = DB.getSQLResults("SELECT * FROM verlag WHERE verlag.vin = "+vin+";");
      this.vin = vin;
      this.name = liste.get(0).get("name");
      this.strasse = liste.get(0).get("strasse");
      this.hausnummer = liste.get(0).get("hausnummer");
      this.stadt = liste.get(0).get("stadt");
      this.plz = liste.get(0).get("plz");
      this.tel = liste.get(0).get("tel");
      this.fax = liste.get(0).get("fax");
      this.website = liste.get(0).get("website");
      this.email = liste.get(0).get("email");
    } // end of if-else
    
  }
  
  public Verlag(HashMap<String,String> hash){
    this.vin = hash.get("vin");
    this.name = hash.get("name");
    this.strasse = hash.get("strasse");
    this.hausnummer = hash.get("hausnummer");
    this.stadt = hash.get("stadt");
    this.plz = hash.get("plz");
    this.tel = hash.get("tel");
    this.fax = hash.get("fax");
    this.website = hash.get("website");
    this.email = hash.get("email");
  }
  
  // Anfang Methoden
  
  public int getKlassenID() {
    return 0;
  }
  
  public String getID() {
    return null;
  } 
     
  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE verlag SET vin = '"+vin+"' WHERE vin ='"+this.vin+"'");
      this.vin = vin;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE verlag SET vin = '"+vin+"' WHERE vin ='"+this.vin+"'");
        this.vin = vin;
      } // end of if
        else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    } 
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE verlag SET name = '"+name+"' WHERE vin ='"+this.vin+"'");
      this.name = name;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE verlag SET name = '"+name+"' WHERE vin ='"+this.vin+"'");
        this.name = name;
      } // end of if
        else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    }
  }

  public String getStrasse() {
    return strasse;
  }

  public void setStrasse(String strasse) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE verlag SET strasse = '"+strasse+"' WHERE vin ='"+this.vin+"'");
      this.strasse = strasse;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE verlag SET stadt = '"+strasse+"' WHERE vin ='"+this.vin+"'");
        this.strasse = strasse;
      } // end of if
        else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    }
  }

  public String getHausnummer() {
    return hausnummer;
  }

  public void setHausnummer(String hausnummer) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE verlag SET hausnummer = '"+hausnummer+"' WHERE vin ='"+this.vin+"'");
      this.hausnummer = hausnummer;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE verlag SET hausnummer = '"+hausnummer+"' WHERE vin ='"+this.vin+"'");
        this.hausnummer = hausnummer;
      } // end of if
        else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    } 
  }

  public String getStadt() {
    return stadt;
  }

  public void setStadt(String stadt) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE verlag SET stadt = '"+stadt+"' WHERE vin ='"+this.vin+"'");
      this.stadt = stadt;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE verlag SET stadt = '"+stadt+"' WHERE vin ='"+this.vin+"'");
        this.stadt = stadt;
      } // end of if
        else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    }
  }
  
  public String getPlz() {
    return plz;
  }

  public void setPlz(String plz) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE verlag SET plz = '"+plz+"' WHERE vin ='"+this.vin+"'");
      this.plz = plz;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE verlag SET plz = '"+website+"' WHERE vin ='"+this.vin+"'");
        this.plz = plz;
      } // end of if
        else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    }
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE verlag SET tel = '"+tel+"' WHERE vin ='"+this.vin+"'");
      this.tel = tel;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE verlag SET tel = '"+tel+"' WHERE vin ='"+this.vin+"'");
        this.tel = tel;
      } // end of if
        else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    }
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE verlag SET fax = '"+fax+"' WHERE vin ='"+this.vin+"'");
      this.fax = fax;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE verlag SET fax = '"+fax+"' WHERE vin ='"+this.vin+"'");
        this.fax = fax;
      } // end of if
        else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    }
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE verlag SET website = '"+website+"' WHERE vin ='"+this.vin+"'");
      this.website = website;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE verlag SET website = '"+website+"' WHERE vin ='"+this.vin+"'");
        this.website = website;
      } // end of if
        else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    }
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    if (DB.isConnected()) {
      DB.executeUpdate("UPDATE verlag SET email = '"+email+"' WHERE vin ='"+this.vin+"'");
      this.email = email;
    } // end of if
    else {
      DB.verbinden();
      if (DB.isConnected()) {
        DB.executeUpdate("UPDATE verlag SET email = '"+email+"' WHERE vin ='"+this.vin+"'");
        this.email = email;
      } // end of if
        else {
        System.out.println("Verbindung mit der Datenbank nicht möglich.");
      } // end of if-else
    }
  }

  public void loeschen(String vin){
    if (DB.isConnected()) {
      if (istVorhanden(vin) == true) {
        DB.executeUpdate("DELETE * FROM verlag WHERE vin ="+vin+";");
      } // end of if
      else {
        System.out.println("Verlag nicht vorhanden.");
      } // end of if-else
    } // end of if
    else {
      DB.verbinden();
      if (istVorhanden(vin) == true) {
        DB.executeUpdate("DELETE * FROM verlag WHERE vin ="+vin+";");
      } // end of if
      else {
        System.out.println("Verlag nicht vorhanden.");
      } // end of if-else
    } // end of if-else
    
  }
  
  public boolean istVorhanden(String vin){
    liste = new ArrayList<HashMap<String,String>>() ;
    liste = DB.getSQLResults("SELECT vin FROM verlag WHERE vin="+this.vin+");");
    return liste.isEmpty() ;
    
    // Ende Methoden
    } 
  // Ende Methoden
  
  public static void main(String[] args){
    Verlag v1 = new Verlag("11");
    System.out.println(v1.getStrasse());
    System.out.println(v1.getName());
  }
} // end of Verlag
