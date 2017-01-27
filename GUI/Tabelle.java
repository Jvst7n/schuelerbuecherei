import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class Tabelle extends JTable {
  ArrayList<BObjekt> liste;
  ArrayList<Person> personListe;
  ArrayList<Buch> buchListe;
  int[] maxWidth; 
  
  public Tabelle(ArrayList<BObjekt> liste){
    super();
    String[] spaltennamen = {"ID", "Bezeichnung", "Klasse / Fach"};
    this.liste = liste;
    DefaultTableModel model = new DefaultTableModel() {
      //instance table model
      @Override
      public boolean isCellEditable(int row, int column) {
        //all cells false
        return false;
      }
    };
    this.setModel(model);
    this.setRowHeight(32);
    this.maxWidth = new int[spaltennamen.length];
    
    this.setCellSelectionEnabled(false);
    this.setFocusable(false);
    
    
    for (String spalte : spaltennamen) {
      model.addColumn(spalte);
    } // end of for
    for (BObjekt objekt : liste) {
      
      String[] reihe = {objekt.getID(),objekt.getName(),objekt.getKlasse()};
      model.addRow(reihe);
      for (int i =0;i<reihe.length;i++) {
        this.maxWidth[i] = this.newMax(this.maxWidth[i],reihe[i].length());
      } // end of for
      
    } // end of for
    
    this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    int width = 0;
    for (int i =0;i<maxWidth.length;i++) {
      this.getColumnModel().getColumn(i).setMinWidth(this.maxWidth[i]*8);   
      width += this.maxWidth[i]*8;
    } // end of for
    
    
    
    
    this.setBounds(this.getX(),this.getY(),width+10,this.getHeight());
    
  }
  
  /*
  public Tabelle(ArrayList<Person> personListe, boolean nurEinTyp){
    super();
    this.personListe = personListe;
    String[] spaltennamen = {"PIN", "Name", "Vorname","ausgel. Bücher"};
    DefaultTableModel model = new DefaultTableModel() {
      //instance table model
      @Override
      public boolean isCellEditable(int row, int column) {
        //all cells false
        return false;
      }
    };
    
    this.setCellSelectionEnabled(false);
    this.setFocusable(false);
    this.maxWidth = new int[spaltennamen.length];
    
    for (String spalte : spaltennamen) {
      model.addColumn(spalte);
    } // end of for
    for (Person p : this.personListe) {
      for (Buch b : p.getBucher()) {
      String bucher = "<html> schwarz</html>";
        if (this.abgeben(b.getIsbn(),p.getKlasse())) {
          bucher += "<font color=red>"+b.getKlasse()+"</font>";
        } else {
          bucher += "<font color=green>"+b.getKlasse()+"</font>";
        } // end of if-else
      } // end of for
      String[] reihe = {objekt.getID(),objekt.getName(),objekt.getKlasse(),bucher};
      model.addRow(reihe);
    } // end of for
    
    this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    for (int i =0;i<spaltennamen.length;i++) {
      this.getColumnModel().getColumn(i).setMinWidth(this.maxWidth[i]*8);
    } // end of for
    this.setModel(model);
  }   */
  
  public Tabelle(ArrayList<Buch> buchListe, Person person){
    super();
    this.buchListe = buchListe;
    String[] spaltennamen = {"BIN", "Titel", "Autor","Fach"};
    ArrayList<Integer> farbigeReihen = new ArrayList<Integer>(); 
    DefaultTableModel model = new DefaultTableModel() {
      //instance table model
      @Override
      public boolean isCellEditable(int row, int column) {
        //all cells false
        return false;
      }
    };
    this.setModel(model);
    this.setRowHeight(32);
    
    for (String spalte : spaltennamen) {
      model.addColumn(spalte);
    } // end of for
    
    
    this.maxWidth = new int[spaltennamen.length];
    
    this.setCellSelectionEnabled(false);
    this.setFocusable(false);
    
    int c = 0;
    for (Buch buch : buchListe) {
      
      Buchdetails buchdetails = new Buchdetails(buch.getIsbn());
      String[] reihe = {buch.getBin(),buchdetails.getTitel(),buchdetails.getAutor(),buchdetails.getFach()};
      
      model.addRow(reihe);
      for (int i =0;i<reihe.length;i++) {
        this.maxWidth[i] = this.newMax(this.maxWidth[i],reihe[i].length());
      } // end of for
      if (this.abgeben(buch.getIsbn(),person.getKlasse())) {
        farbigeReihen.add(c);
      } // end of if
      c++;
    } // end of for
    
    //TODO FÄRBEN
    
    this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    int width = 0;
    for (int i =0;i<maxWidth.length;i++) {
      this.getColumnModel().getColumn(i).setMinWidth(this.maxWidth[i]*8);   
      width += this.maxWidth[i]*8;
    } // end of for
    
    this.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
      @Override
      public Component getTableCellRendererComponent(JTable table,
      Object value, boolean isSelected, boolean hasFocus,
      int row, int column) {
        
        
        Component c = super.getTableCellRendererComponent(table, value,
        isSelected, hasFocus, row, column);
        
        if (farbigeReihen.contains(row)) {
          setBackground(Color.RED);
        } else {
          setBackground(Color.GREEN);
        }
        return this;
      }
    });
    this.setBounds(this.getX(),this.getY(),width+10,this.getHeight());
  }
  
  private boolean abgeben(String isbn, String klasse){
    String sql = "SELECT isbn FROM abzugeben WHERE isbn='"+isbn+"' AND klasse='"+klasse+"'";
    ArrayList<HashMap<String,String>> erg = DB.getSQLResults(sql); 
    if (erg.size() == 0 || erg == null) {
      return false;
    }else{
      return true;
    }
  } 
  
  private int newMax(int altMax, int z){
    if (altMax > z) {
      return altMax;
    }else{
      return z;
    }
  }
  
  
}