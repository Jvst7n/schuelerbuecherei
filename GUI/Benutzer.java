/**
  *
  * Beschreibung
  *
  * @version 0.1 vom 16.01.2017
  * @author Eike Taegener
  */
import java.sql.*;
import java.util.*;
class Benutzer{
  
  protected String name;
  protected int rechte = 0;
  protected String password = "";
  public String s = "";
  /**
    * int rechte = 0 -> Lesemodus
    * int rechte = 1 -> Schuelermodus
    * int rechte = 2 -> Admin
    */
  
  public Benutzer (String n, String passwd) {
    name = n;
    password = passwd;
    String sql = "SELECT admin FROM user WHERE username = '"+name+"' AND password = '"+password+"'";
    ArrayList<HashMap<String,String>> erg = DB.getSQLResults(sql);
    if (erg.size() == 0 ) {
      s = "Login failed!";
      this.rechte = 0;
    } // end of if
    else {
      this.rechte = Integer.parseInt(erg.get(0).get("admin"));
      s = "";
    } // end of if-else
  } 
  
  public int getRechte() {
    return rechte;
  }

  public String getName() {
    return name;
  }

  public boolean loggedIn() {
    if (rechte != 0) {
      return true;
    } // end of if
    return false;
  } 
  
  public int logOut() {
    rechte = 0;
    password = "";
    name = "";
    return rechte;
  }
  
  public static void main (String[] args) {
  }
    
}