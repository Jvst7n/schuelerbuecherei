/**
 * Dynamische Klasse fuer den Zugriff auf eine MySQL-Datenbank.
 * Diese Klasse stellt alle nötigen Methoden für eine beliebige
 * SQL-Abfrage bereit.
 *
 * In dieser Version werden alle SQLExceptions abgefangen:
 * o error    -- boolean, true, wenn ein Fehler auftritt
 * o errormsg -- String, Fehlercode 
 * o isOpen   -- boolean, true, wenn aktuelle Verbindung hergestellt ist
 * 
 * In der Konsole muss das Programm durch Angabe des Treibers gestartet werden:
 * java -classpath .:mysql-connector-java-5.1.6-bin.jar Demo1
 *
 * @version 1.0 Januar 2017 
 * @author  Justin, Tim, Eike, (gu)
 */

import java.sql.*;
import java.util.*;

public class DB {
  //---Attribute -------------------------------------
  private static Connection  con;
  private static Statement   stmt;
  private static boolean     isOpen;
  private static boolean     error;
  private static String      errormsg;
    
  private static String      host;
  private static String      user;
  private static String      password;
  private static String      database;
  private static ResultSet   result;
    
  /**
   * Konstruktor für die Verbindung mit einer Datenbank.
   * @param host  Verbindungsrechner
   * @param db    Datenbankname
   * @param user  gueltiger MySQL-Username
   * @param pw    Kennwort
   */
  public DB(String host, String db, String user, String pw) {
    DB.host     = host;
    DB.user     = user;
    DB.password = pw;
    DB.database = db;
    DB.treiberLaden();
    DB.verbinden();
  }
  
  /**
   * Konstruktor für die Verbindung mit der Schulbuch-Datenbank.
   */  
  public DB() {
    DB.host     = "10.16.41.100";
    DB.user     = "buch";
    DB.password = "book";
    DB.database = "Schulbuch2017";
    DB.treiberLaden();
    DB.verbinden();
  }

  // -----   get-Methoden -------------------------------------
  public static ResultSet getResultSet() { return result;   }
  public static String getErrorMsg()     { return errormsg; }
  public static boolean getError()       { return error;    }
  public static boolean isOpen()         { return isOpen;   }
  //public static boolean isConnected()    { return con.isValid(500); }
 
  /**
   * Registriert den Treiber, der beim Aufruf als 
   * classpath-Parameter angegeben wird.                          
   */
  private static void treiberLaden() {
    try   { 
      Class.forName("com.mysql.jdbc.Driver");
      error = false;
    }
    catch ( ClassNotFoundException e) { 
      error = true;
      errormsg = "Class.forName-error:"+e.toString()+e.getMessage();
    }
  }

  /**
   * Eine Datenbankverbindung wird erstellt.
   * Die Verbindungsdaten werden in den
   * Attributen con und stmt gespeichert.
   */
  public static void verbinden() {
    try {
      String url = "jdbc:mysql://"+host+":3306/"+database+"?useUnicode=true&characterEncoding=UTF-8";
      con = DriverManager.getConnection(url,user,password);
      stmt = con.createStatement();
      error = false;
      isOpen = true;
      //System.out.println("verbinden gelungen");
    }
    catch (SQLException e) {
      error = true;
      errormsg = "Verbindung gescheitert: "+e.toString();
      isOpen = false;
    }
  }

  /**
   * Schließen einer Datenbankverbindung.
   */
  public static void trennen() {
    try {
      if (stmt != null) stmt.close();
      if (con != null) con.close();
      isOpen = false;
    }
    catch (SQLException e) {
      error = true;
      errormsg = "Close gescheitert: "+e.toString();
      isOpen = false;
    }       
  }
    
  /**
   * Durchführung einer SQL-Abfrage.
   * @param sql SQL-String
   * @return    true, wenn erfolgreich 
   *            -- intern wird das Attribut "result" gesetzt
   */
  public static boolean getSqlQuery(String sql) {
    if ( !isOpen ) return false;
    if (stmt == null) return false;
    try{
      result = stmt.executeQuery(sql);
      return true;
    }
    catch (SQLException e) {
      error = true;
      errormsg = "SQL-Abfrage gescheitert: "+e.toString();
      result = null;
      return false;
    }  
  }
    
  /**
   * Durchführung einer SQL-Abfrage für Update/Insert/Delete. 
   * @param sql SQL-String
   * @return    true, wenn erfolgreich; Ergebnis ist in result
   */
  public static boolean executeUpdate(String sql)   {
    try{
      stmt.executeUpdate(sql);
      return true;
    }
    catch (SQLException e) {
      error = true;
      errormsg = "SQL-Update gescheitert: "+e.toString();
      return false;
    }  
  }

  /**
   * Liefert zu einer SQL-Abfrage die Daten als ArrayList.
   * Jede Datenzeile ist ein Hashmap der Form ("Spaltenname"-> "Value").
   * Voraussetzung:  Eine Verbindung wurde erfolgtreich hergestellt.
   * @param sql - SQL-Abfrage 
   * @return Daten als ArrayList<Zeile>, wobei Zeile eine Hashmap darstellt.
   *         Der Key ist die Spaltenüberschrift, value ist der Inhalt.
   */
  public static ArrayList<HashMap<String,String>> getSQLResults(String sql) {
    ArrayList<HashMap<String,String>> ergebnis = new ArrayList<HashMap<String,String>>();
    HashMap<String,String> zeile = null;
    if ( !isOpen ) return ergebnis;
    if ( !getSqlQuery(sql) ) return ergebnis;
    try {
      String[] col = getSpaltenName(result);
      result.beforeFirst(); // Cursor vor 1. Datensatz
      while ( result.next()) {
        zeile = new HashMap<String,String>();
        for (int i = 0; i < col.length; i++) {
          String s = result.getString(col[i]);
          zeile.put(col[i], s);
        }
        ergebnis.add(zeile);
      }
      return ergebnis;
    }
    catch (SQLException e) {
      error = true;
      errormsg = "SQL-Abfrage (Daten) gescheitert: "+e.toString();
      return null;
    }
  }
    
    
  /**
   * Liefert die Anzahl der Zeilen einer zuvor durchgeführten Datenbankabfrage.
   * Der Datensatzcurser befindet sich anschließend vor dem ersten Eintrag.
   * @return Anzahl der Datenzeilen
   */
  public static int getRows() {
    int anzahl = 0;
    try {
      result.last();
      anzahl = result.getRow();
      result.beforeFirst();
      return anzahl;
    }
    catch (SQLException e) {
      error = true;
      errormsg = "getRows gescheitert: "+e.toString();
      return -1;
    }
  }

  /**
   * Liefert die Anzahl an Spalten einer Abfrage.
   * @param rs initialisiertes ResultSet
   * @return   Anzahl Spalten
   */
  public static int getSpaltenAnzahl(ResultSet rs) throws SQLException {
    ResultSetMetaData rsmd = rs.getMetaData();
    int numberOfColumns    = rsmd.getColumnCount();
    return numberOfColumns;
  }

  /**
   * Liefert die Anzahl der Datensätze zu einer Abfrage.
   * @param rs initialisiertes ResultSet
   * @return Anzahl Datensätze
   */
  @SuppressWarnings("unused")
  private static long getZeilenAnzahl(ResultSet rs) throws SQLException {
    rs.last();
    long zeilen = rs.getRow();
    rs.beforeFirst();
    return zeilen-1;
  }

  /**
   * Liefert ein Array, das alle Spaltennamen einer Abfrage enthält.
   * @param rs initialisiertes ResultSet
   * @return   Array mit allen Spaltennamen
   */
  public static String[] getSpaltenName(ResultSet rs) throws SQLException {
    int c = getSpaltenAnzahl(rs);
    ResultSetMetaData rsmd = rs.getMetaData();
    String[] col = new String[c];
    for (int i=0; i < c; i++) {
      col[i] = rsmd.getColumnName(i+1);
    }
    return col;
  }

  // Testprogramm
  public static void main(String args[]) throws SQLException {
    @SuppressWarnings("unused")
    DB db = new DB();
    //DB db = new DB("10.16.41.100", "Schulbuch2017", "buch", "book");
    
    String sql  = "SELECT * FROM buch WHERE registrierungsdatum='2011-02-15'";
    
    ArrayList<HashMap<String,String>> erg = DB.getSQLResults(sql);
    
    System.out.println("Alle Zeilen: ("+DB.getRows()+")");
    for (HashMap<String,String> z : erg) {
      for ( Map.Entry<String, String> e : z.entrySet() ){
        System.out.print(e.getValue() + " ... ");
      }                                                                                 
      System.out.println();
    }
    
    DB.trennen();
  }
}