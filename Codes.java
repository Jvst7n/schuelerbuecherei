/**
  *
  * Beschreibung
  *
  * @version 0.1 vom 16.1.2017
  * @author Eike Taegener
  */
import java.math.BigInteger;
import java.util.Random;
import java.sql.*;
import java.util.*;
public class Codes {

  /**
    * int = 0 -> Errorfall, der eingebene Code entspricht keiner bekannten Codevariante
    * int = 1 -> PIN
    * int = 2 -> BIN
    * int = 3 -> ISBN
    */

  public static boolean isISBN(String c){
    if (c.length() == 10) {
      
      int erg=0;
      for (int i=1;i<c.length() ;i++ ) {
        
        erg+=i*Integer.parseInt(c.charAt(i-1)+"");
      } // end of for  
      erg = erg % 11;
      return Integer.parseInt(c.charAt(c.length()-1)+"") == erg;
    } // end of if
    if (c.length() == 13) {
      int erg=0;
      for (int i=1;i<c.length() ;i++ ) {
        BigInteger big = new BigInteger("3");
        big = big.pow((i+1)%2);
        
        erg+=big.intValue()*Integer.parseInt(c.charAt(i-1)+"");
        
      } // end of for   
      erg =  (10-erg);
      while (erg<0) { 
        erg += 10;
      } // end of while
      erg = (erg % 10);
      
      return Integer.parseInt(c.charAt(c.length()-1)+"") == erg;
    } // end of if
    return false;
  }

  public static boolean isBIN(String c){
    if (c.charAt(0) == '1') {
      return true;
    } // end of if
    return false;
  }
  
  public static boolean isPIN(String c){
    if (c.length() == 8) {
      if (c.charAt(0) == '0') {
        return true;
      } // end of if
    } // end of if
    if (c.length() == 5) {
      if (c.charAt(0) == 'S') {
        return true;
      } // end of if
    } // end of if
    return false;
  }
  
  public static String createPIN() {
    String s = "";
    String sql = "SELECT pin FROM person WHERE pin LIKE '01%' ORDER BY pin DESC LIMIT 1";
    ArrayList<HashMap<String,String>> erg = DB.getSQLResults(sql);
    int nummer = (Integer.parseInt(erg.get(0).get("pin"))) + 1;
    s += 0;
    s += nummer;
    return s;
  }

  public static int what(String c) {
    if (c.length() == 8 || c.length() == 5) {
      if (c.charAt(0) == '1') {
        if (isBIN(c)) {
          return 2;    
        } // end of if
      } // end of if
      if (c.charAt(0) == '0' || c.charAt(0) == 'S') {
        if (isPIN(c)) {
          return 1;
        } // end of if
      } // end of if
    } // end of if
    if (c.length() == 10 || c.length() == 13) {
      if (isISBN(c)) {
        return 3;
      } // end of if
    } // end of if
    return 0;
  }

  public static void main(String[] args) {
    DB db = new DB();
    Codes co = new Codes();
    System.out.println(co.createPIN());    
  } // end of main
  
} // end of class Codes
