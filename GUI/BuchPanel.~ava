import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
/**
  * @author Tsenguun Donth
  * @version 1.0
*/
public class BuchPanel extends JPanel {
  // Anfang Attribute
  private JLabel Buchkarte2 = new JLabel();
  private JPanel jPanel1 = new JPanel(null, true);
    private JLabel verlag3 = new JLabel();
    private JLabel price1 = new JLabel();
    private JLabel bestellnr2 = new JLabel();
    private JTextField titel2 = new JTextField();
    private JTextField verlag4 = new JTextField();
    private JTextField preis2 = new JTextField();
    private JTextField bestellnr3 = new JTextField();
    private JTextField autor3 = new JTextField();
    private JLabel autor4 = new JLabel();
    private JLabel iSBN3 = new JLabel();
    private JTextField iSBN4 = new JTextField();
    private JLabel title1 = new JLabel();
    private JTextField fach3 = new JTextField();
    private JLabel fach4 = new JLabel();
    private JButton bearbeiten1 = new JButton();
  private JTable liste1 = new JTable(30, 5);
    private DefaultTableModel liste1Model = (DefaultTableModel) liste1.getModel();
    private JScrollPane liste1ScrollPane = new JScrollPane(liste1);
  // Ende Attribute
  
  public BuchPanel(){
    super();
    this.setLayout(null);
    
    
    Buchkarte2.setBounds(304, 112, 723, 57);
    Buchkarte2.setText("Buchkarte");
    Buchkarte2.setFont(new Font("Calibri", Font.BOLD, 20));
    Buchkarte2.setBackground(Color.GRAY);
    Buchkarte2.setOpaque(true);
    this.add(Buchkarte2);
    jPanel1.setBounds(304, 168, 713, 489);
    jPanel1.setOpaque(false);
    jPanel1.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 2));
    this.add(jPanel1);
    verlag3.setBounds(336, 40, 99, 33);
    verlag3.setText("Verlag");
    verlag3.setFont(new Font("Calibri", Font.PLAIN, 16));
    jPanel1.add(verlag3);
    price1.setBounds(336, 88, 83, 41);
    price1.setText("Preis");
    price1.setFont(new Font("Calibri", Font.PLAIN, 16));
    jPanel1.add(price1);
    bestellnr2.setBounds(336, 152, 123, 41);
    bestellnr2.setText("Bestellnummer");
    bestellnr2.setFont(new Font("Calibri", Font.PLAIN, 16));
    jPanel1.add(bestellnr2);
    liste1ScrollPane.setBounds(144, 304, 417, 153);
    liste1.setRowHeight(20);
    liste1.setFont(new Font("Calibri", Font.PLAIN, 14));
    liste1.getColumnModel().getColumn(0).setHeaderValue("Schüler");
    liste1.getColumnModel().getColumn(1).setHeaderValue("Klasse");
    liste1.getColumnModel().getColumn(2).setHeaderValue("Lehrer/Tutor");
    liste1.getColumnModel().getColumn(3).setHeaderValue("Datum");
    liste1.getColumnModel().getColumn(4).setHeaderValue("ISBN");
    liste1.setBackground(Color.GRAY);
    jPanel1.add(liste1ScrollPane);
    titel2.setBounds(184, 40, 113, 33);
    jPanel1.add(titel2);
    verlag4.setBounds(464, 40, 113, 33);
    jPanel1.add(verlag4);
    preis2.setBounds(464, 96, 113, 33);
    jPanel1.add(preis2);
    bestellnr3.setBounds(464, 152, 153, 33);
    jPanel1.add(bestellnr3);
    autor3.setBounds(184, 88, 113, 33);
    jPanel1.add(autor3);
    autor4.setBounds(56, 88, 115, 41);
    autor4.setText("Autor");
    autor4.setFont(new Font("Calibri", Font.PLAIN, 16));
    jPanel1.add(autor4);
    iSBN3.setBounds(56, 200, 115, 41);
    iSBN3.setText("ISBN");
    iSBN3.setFont(new Font("Calibri", Font.PLAIN, 16));
    jPanel1.add(iSBN3);
    iSBN4.setBounds(184, 200, 145, 33);
    jPanel1.add(iSBN4);
    title1.setBounds(48, 32, 115, 33);
    title1.setText("Titel");
    title1.setFont(new Font("Calibri", Font.PLAIN, 16));
    jPanel1.add(title1);
    fach3.setBounds(184, 144, 113, 33);
    jPanel1.add(fach3);
    fach4.setBounds(56, 144, 115, 41);
    fach4.setText("Fach");
    fach4.setFont(new Font("Calibri", Font.PLAIN, 16));
    jPanel1.add(fach4);
    bearbeiten1.setBounds(552, 216, 129, 41);
    bearbeiten1.setText("Bearbeiten");
    bearbeiten1.setMargin(new Insets(2, 2, 2, 2));
    bearbeiten1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bearbeiten1_ActionPerformed(evt);
      }
    });
    bearbeiten1.setBorder(new javax.swing.border.LineBorder(Color.BLACK));
    bearbeiten1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    bearbeiten1.setFont(new Font("Calibri", Font.PLAIN, 16));
    jPanel1.add(bearbeiten1);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public PrototypBuchPanel
  
  public static void main(String[] args) {
    new PrototypBuchPanel();
  } // end of main
  
  public void Bearbeiten2_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of Bearbeiten2_ActionPerformed
  
  public void bearbeiten1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of bearbeiten1_ActionPerformed
  
}