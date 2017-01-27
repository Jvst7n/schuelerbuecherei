/**
  *
  * Beschreibung
  *
  * @version 0.8 vom 09.01.2017
  * @author Esad
  */

public abstract class BObjekt {
  
  // Anfang Attribute
  public String ID;
  public String Name;
  // Ende Attribute
  public BObjekt() {
  }
  // Anfang Methoden
  public  abstract String getID();

  public abstract String getName();
  
  public abstract int getKlassenID();

  // Ende Methoden
} // end of BObjekt
