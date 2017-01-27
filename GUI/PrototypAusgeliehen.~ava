import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 27.01.2017
  * @author 
  */

public class PrototypAusgeliehen extends Frame {
  // Anfang Attribute
  private JLabel Buchkarte1 = new JLabel();
  private JPanel jPanel1 = new JPanel(null, true);
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private JTextField jTextField4 = new JTextField();
    private JButton jButton1 = new JButton();
    private JTextField jTextField5 = new JTextField();
    private JButton jButton2 = new JButton();
    private JComboBox<String> jComboBox1 = new JComboBox<String>();
      private DefaultComboBoxModel<String> jComboBox1Model = new DefaultComboBoxModel<String>();
    private JComboBox<String> jComboBox2 = new JComboBox<String>();
      private DefaultComboBoxModel<String> jComboBox2Model = new DefaultComboBoxModel<String>();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JLabel jLabel6 = new JLabel();
    private JLabel jLabel7 = new JLabel();
    private JLabel jLabel8 = new JLabel();
    private JLabel jLabel9 = new JLabel();
  private JLabel Suche = new JLabel();
  private JTextField jTextField3 = new JTextField();
  private JPanel jPanel2 = new JPanel(null, true);
    private JLabel Benutzer = new JLabel();
  // Ende Attribute
  
  public PrototypAusgeliehen() { 
    // Frame-Initialisierung
    super();
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 1252; 
    int frameHeight = 798;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("PrototypAusgeliehen");
    setResizable(false);
    Panel cp = new Panel(null);
    add(cp);
    // Anfang Komponenten
    
    Buchkarte1.setBounds(240, 16, 971, 57);
    Buchkarte1.setText("                                                              BuchKarte");
    Buchkarte1.setBackground(Color.GRAY);
    Buchkarte1.setOpaque(true);
    Buchkarte1.setForeground(Color.WHITE);
    Buchkarte1.setFont(new Font("Calibri", Font.BOLD, 22));
    cp.add(Buchkarte1);
    jPanel1.setBounds(240, 88, 297, 673);
    jPanel1.setOpaque(false);
    jPanel1.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 2));
    cp.add(jPanel1);
    Suche.setBounds(240, 80, 299, 33);
    Suche.setText("Suche nach...");
    Suche.setBackground(new Color(0x404040));
    Suche.setOpaque(true);
    Suche.setFont(new Font("Calibri", Font.PLAIN, 14));
    Suche.setForeground(Color.WHITE);
    cp.add(Suche);
    jTextField1.setBounds(8, 72, 265, 33);
    jPanel1.add(jTextField1);
    jTextField2.setBounds(8, 144, 265, 33);
    jPanel1.add(jTextField2);
    jTextField3.setBounds(248, 304, 265, 33);
    cp.add(jTextField3);
    jTextField4.setBounds(8, 288, 265, 33);
    jPanel1.add(jTextField4);
    jButton1.setBounds(24, 328, 193, 25);
    jButton1.setText("Suchen");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    jButton1.setFont(new Font("Calibri", Font.BOLD, 12));
    jPanel1.add(jButton1);
    jTextField5.setBounds(8, 384, 265, 33);
    jPanel1.add(jTextField5);
    jButton2.setBounds(24, 424, 193, 25);
    jButton2.setText("Suchen");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    jButton2.setFont(new Font("Calibri", Font.BOLD, 12));
    jPanel1.add(jButton2);
    jComboBox1.setModel(jComboBox1Model);
    jComboBox1.setBounds(8, 512, 201, 33);
    jPanel1.add(jComboBox1);
    jComboBox2.setBounds(8, 584, 201, 33);
    jComboBox2.setModel(jComboBox2Model);
    jComboBox2.setBounds(.setBounds(24, 536, 201, 33);
    jPanel1.add(jComboBox2);
    jLabel3.setBounds(8, 40, 267, 25);
    jLabel3.setText("Ausleihe nach (jjjj-mm-tt)");
    jLabel3.setFont(new Font("Calibri", Font.PLAIN, 12));
    jPanel1.add(jLabel3);
    jLabel4.setBounds(8, 112, 267, 25);
    jLabel4.setText("Ausleihe vor (jjjj-mm-tt)");
    jLabel4.setFont(new Font("Calibri", Font.PLAIN, 12));
    jPanel1.add(jLabel4);
    jLabel5.setBounds(8, 184, 267, 25);
    jLabel5.setText("Klasse");
    jLabel5.setFont(new Font("Calibri", Font.PLAIN, 12));
    jPanel1.add(jLabel5);
    jLabel6.setBounds(8, 256, 267, 25);
    jLabel6.setText("ISBN");
    jLabel6.setFont(new Font("Calibri", Font.PLAIN, 12));
    jPanel1.add(jLabel6);
    jLabel7.setBounds(8, 352, 267, 25);
    jLabel7.setText("Buchnummer");
    jLabel7.setFont(new Font("Calibri", Font.PLAIN, 12));
    jPanel1.add(jLabel7);
    jLabel8.setBounds(8, 552, 267, 25);
    jLabel8.setText("Alle Bücher in Klasse");
    jLabel8.setFont(new Font("Calibri", Font.PLAIN, 12));
    jPanel1.add(jLabel8);
    jLabel9.setBounds(8, 480, 275, 25);
    jLabel9.setText("Alle Bücher im Fach");
    jLabel9.setFont(new Font("Calibri", Font.PLAIN, 12));
    jPanel1.add(jLabel9);
    jPanel2.setBounds(544, 80, 665, 673);
    jPanel2.setOpaque(false);
    jPanel2.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 2));
    cp.add(jPanel2);
    Benutzer.setBounds(0, 0, 675, 33);
    Benutzer.setText("Benutzerliste");
    Benutzer.setBackground(Color.GRAY);
    Benutzer.setOpaque(true);
    Benutzer.setFont(new Font("Calibri", Font.PLAIN, 14));
    Benutzer.setForeground(Color.WHITE);
    jPanel2.add(Benutzer);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public PrototypAusgeliehen
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new PrototypAusgeliehen();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of jButton1_ActionPerformed

  public void jButton2_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of jButton2_ActionPerformed

  // Ende Methoden
} // end of class PrototypAusgeliehen
