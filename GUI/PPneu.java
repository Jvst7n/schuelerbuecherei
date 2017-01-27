import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;


/**
  * @author Konradin Wagner
  * @version 0.1 
*/   
public class PPneu extends JPanel {
  
  private JLabel jl_ueberschrift;
  private JTextField txt_PIN = new JTextField();
  private JTextField txt_Name = new JTextField();
  private JTextField txt_Vorname = new JTextField();
  private JLabel jl_Name = new JLabel();
  private JLabel jl_Vorname = new JLabel();
  private JLabel jl_PIN = new JLabel();
  private JTextField txt_Klasse = new JTextField();
  private JLabel jl_Klasse = new JLabel();
  private JTextField txt_Lehrer = new JTextField();
  private JLabel jl_Lehrer = new JLabel();
  private JButton jb_bearbeiten = new JButton();
  private JButton jb_loeschen = new JButton();
  private JLabel jl_aus_rueck = new JLabel();
  private JLabel jl_BIN = new JLabel();
  private JTextField txt_BIN = new JTextField();
  private JButton jb_ok_suche = new JButton();
  private JTable jT_buecherliste = new JTable(30, 5);
  private DefaultTableModel jT_buecherlisteModel = (DefaultTableModel) jT_buecherliste.getModel();
  private JScrollPane jT_buecherlisteScrollPane = new JScrollPane(jT_buecherliste);
  private JLabel jl_ausbuecher = new JLabel();
  
  
  public PPneu() {
    super();
    this.setLayout(null);
    
    jl_ueberschrift = new JLabel ("Personenkarte");
    jl_ueberschrift.setBounds(5,5,600,30);
    jl_ueberschrift.setFont(new Font ("Dialog",Font.BOLD,30));
    this.add(jl_ueberschrift);
    
    txt_PIN.setBounds(5, 55, 150, 25);
    txt_PIN.setEditable(true);
    txt_PIN.setBackground(Color.white);
    txt_PIN.setBorder(new javax.swing.border.LineBorder(Color.DARK_GRAY));
    this.add(txt_PIN);
    
    jl_PIN.setBounds(5, 85, 75, 20);
    jl_PIN.setText("PIN");   
    this.add(jl_PIN);
    
    txt_Name.setBounds(5, 115,150, 25);
    txt_Name.setEditable(true);
    txt_Name.setBackground(Color.white);
    txt_Name.setBorder(new javax.swing.border.LineBorder(Color.DARK_GRAY));  
    this.add(txt_Name);
    
    jl_Name.setBounds(5, 145, 91, 20);
    jl_Name.setText("Name");
    this.add(jl_Name);
    
    txt_Vorname.setBounds(5, 175, 150, 25);
    txt_Vorname.setEditable(true);
    txt_Vorname.setBackground(Color.white);
    txt_Vorname.setBorder(new javax.swing.border.LineBorder(Color.DARK_GRAY));
    this.add(txt_Vorname);
    
    jl_Vorname.setBounds(5, 205, 91, 20);
    jl_Vorname.setText("Vorname");
    this.add(jl_Vorname);
    
    txt_Klasse.setBounds(5, 235, 75, 25);
    txt_Klasse.setEditable(true);
    txt_Klasse.setBackground(Color.white);
    txt_Klasse.setBorder(new javax.swing.border.LineBorder(Color.DARK_GRAY));
    this.add(txt_Klasse);
    
    jl_Klasse.setBounds(5, 265, 83, 20);
    jl_Klasse.setText("Klasse");
    this.add(jl_Klasse);
    
    txt_Lehrer.setBounds(5, 290, 150, 25);
    txt_Lehrer.setEditable(true);
    txt_Lehrer.setBackground(Color.white);
    txt_Lehrer.setBorder(new javax.swing.border.LineBorder(Color.DARK_GRAY));
    this.add(txt_Lehrer);
    
    jl_Lehrer.setBounds(5, 320, 117, 20);
    jl_Lehrer.setText("Klassenlehrer/Tutor");
    this.add(jl_Lehrer);
    
    jb_bearbeiten.setBounds(5, 350, 125, 25);
    jb_bearbeiten.setText("bearbeiten");
    jb_bearbeiten.setMargin(new Insets(2, 2, 2, 2));
    jb_bearbeiten.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jb_bearbeiten_ActionPerformed(evt);
      }
    });
    jb_bearbeiten.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.add(jb_bearbeiten);
    
    jb_loeschen.setBounds(5, 385, 125, 25);
    jb_loeschen.setText("Person loeschen");
    jb_loeschen.setMargin(new Insets(2, 2, 2, 2));
    jb_loeschen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jb_loeschen_ActionPerformed(evt);
      }
    });
    jb_loeschen.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.add(jb_loeschen);
    
    
    
    jl_aus_rueck.setBounds(800,20, 250, 25);
    jl_aus_rueck.setText("Ausleihe/Rueckgabe");
    jl_aus_rueck.setFont(new Font("Dialog", Font.BOLD, 18));
    this.add(jl_aus_rueck);
    
    jl_BIN.setBounds(800,60, 59, 25);
    jl_BIN.setText("BIN:");
    this.add(jl_BIN);
    
    txt_BIN.setBounds(835,60, 225, 25);
    this.add(txt_BIN);
    
    jb_ok_suche.setBounds(1070,60, 74, 25);
    jb_ok_suche.setText("OK");
    jb_ok_suche.setMargin(new Insets(2, 2, 2, 2));
    jb_ok_suche.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jb_ok_suche_ActionPerformed(evt);
      }
    });
    jb_ok_suche.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.add(jb_ok_suche);
    
    jT_buecherlisteScrollPane.setBounds(200, 150, 1350, 720);
    jT_buecherliste.getColumnModel().getColumn(0).setHeaderValue("Nr.");
    jT_buecherliste.getColumnModel().getColumn(1).setHeaderValue("BIN");
    jT_buecherliste.getColumnModel().getColumn(2).setHeaderValue("Buch");
    jT_buecherliste.getColumnModel().getColumn(3).setHeaderValue("Ausleihe");
    jT_buecherliste.getColumnModel().getColumn(4).setHeaderValue("Rückgabe");
    jT_buecherliste.getColumnModel().getColumn(0).setWidth(30);
    this.add(jT_buecherlisteScrollPane);        
    
    jl_ausbuecher.setBounds(200, 120, 219, 25);
    jl_ausbuecher.setText("Ausgeliehene Bücher");
    this.add(jl_ausbuecher);
    
    this.setVisible(true);
  }
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new PersonPanel();
  } // end of main
  
  public void jb_bearbeiten_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of jb_bearbeiten_ActionPerformed

  public void jb_loeschen_ActionPerformed(ActionEvent evt) {
    //TODO hier Quelltext einfügen
  } // end of jb_loeschen_ActionPerformed

  public void jb_ok_suche_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of jb_ok_suche_ActionPerformed

  // Ende Methoden
}