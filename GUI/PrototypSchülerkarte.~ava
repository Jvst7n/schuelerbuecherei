import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 23.01.2017
  * @author 
  */

public class PrototypSchülerkarte extends JFrame {
  // Anfang Attribute
  private JLabel Schuelerkarte = new JLabel();
  private JPanel Feld2 = new JPanel(null, true);
    private JPanel jPanel2 = new JPanel(null, true);
      private JLabel Pin = new JLabel();
      private JLabel Name1 = new JLabel();
      private JLabel Vorname1 = new JLabel();
      private JLabel JahrgangKlasse = new JLabel();
      private JTextField jTextField1 = new JTextField();
      private JTextField jTextField2 = new JTextField();
      private JTextField jTextField3 = new JTextField();
      private JComboBox AuswahlBox = new JComboBox();
      //private JComboBox AuswahlBoxModel =
      private DefaultComboBoxModel AuswahlBoxModel = new DefaultComboBoxModel();
      private JButton Speichern1 = new JButton();
      private JButton Abbrechen2 = new JButton();
    private JTextArea Textfeld1 = new JTextArea("");
      private JScrollPane Textfeld1ScrollPane = new JScrollPane(Textfeld1);
  // Ende Attribute
  
  public PrototypSchülerkarte() { 
    // Frame-Initialisierung
    super();
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 1296; 
    int frameHeight = 845;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("PrototypSchülerkarte");
    setResizable(false);
    Panel cp = new Panel(null);
    add(cp);
    // Anfang Komponenten
    
    Schuelerkarte.setBounds(360, 80, 739, 89);
    Schuelerkarte.setText("                                Neue Schülerkarte Anlegen");
    Schuelerkarte.setVerticalAlignment(SwingConstants.CENTER);
    Schuelerkarte.setVerticalTextPosition(SwingConstants.CENTER);
    Schuelerkarte.setIconTextGap(4);
    Schuelerkarte.setFont(new Font("Calibri", Font.BOLD, 20));
    Schuelerkarte.setBackground(Color.GRAY);
    Schuelerkarte.setOpaque(true);
    cp.add(Schuelerkarte);
    Feld2.setBounds(360, 168, 737, 401);
    Feld2.setOpaque(false);
    Feld2.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 2));
    cp.add(Feld2);
    jPanel2.setBounds(40, 88, 537, 289);
    jPanel2.setOpaque(true);
    jPanel2.setBackground(new Color(0xEEEEEE));
    jPanel2.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 2));
    Feld2.add(jPanel2);
    Pin.setBounds(16, 40, 147, 41);
    Pin.setText("PIN");
    Pin.setFont(new Font("Calibri", Font.ITALIC, 16));
    Pin.setBackground(new Color(0xEEEEEE));
    Pin.setOpaque(true);
    jPanel2.add(Pin);
    Name1.setBounds(16, 96, 139, 49);
    Name1.setText("Name1");
    Name1.setFont(new Font("Calibri", Font.ITALIC, 16));
    Name1.setBackground(new Color(0xEEEEEE));
    Name1.setOpaque(true);
    jPanel2.add(Name1);
    Vorname1.setBounds(16, 160, 123, 41);
    Vorname1.setText("Vorname");
    Vorname1.setFont(new Font("Calibri", Font.ITALIC, 16));
    Vorname1.setBackground(new Color(0xEEEEEE));
    Vorname1.setOpaque(true);
    jPanel2.add(Vorname1);
    JahrgangKlasse.setBounds(16, 208, 139, 49);
    JahrgangKlasse.setText("Jahrgang/Klasse");
    JahrgangKlasse.setFont(new Font("Calibri", Font.ITALIC, 16));
    JahrgangKlasse.setBackground(new Color(0xEEEEEE));
    JahrgangKlasse.setOpaque(true);
    jPanel2.add(JahrgangKlasse);
    jTextField1.setBounds(184, 48, 169, 33);
    jPanel2.add(jTextField1);
    jTextField2.setBounds(184, 104, 169, 33);
    jPanel2.add(jTextField2);
    jTextField3.setBounds(184, 160, 169, 33);
    jPanel2.add(jTextField3);
    AuswahlBox.setModel(AuswahlBoxModel);
    AuswahlBox.setBounds(200, 216, 137, 33);
    AuswahlBox.setFont(new Font("Calibri", Font.BOLD, 14));
    AuswahlBoxModel.addElement("bitte wählen");
    jPanel2.add(AuswahlBox);
    Speichern1.setBounds(392, 152, 121, 41);
    Speichern1.setText("Speichern");
    Speichern1.setMargin(new Insets(2, 2, 2, 2));
    Speichern1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Speichern1_ActionPerformed(evt);
      }
    });
    Speichern1.setFont(new Font("Calibri", Font.BOLD, 14));
    jPanel2.add(Speichern1);
    Abbrechen2.setBounds(392, 216, 121, 41);
    Abbrechen2.setText("Abbrechen");
    Abbrechen2.setMargin(new Insets(2, 2, 2, 2));
    Abbrechen2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Abbrechen2_ActionPerformed(evt);
      }
    });
    Abbrechen2.setFont(new Font("Calibri", Font.BOLD, 14));
    jPanel2.add(Abbrechen2);
    Textfeld1ScrollPane.setBounds(8, 8, 713, 73);
    Textfeld1.setText("Sie können jetzt einen neuen Schüler anlegen.Füllen sie alle Felder aus und bestätigen Sie mit Speichern.Die eingescannte PIN kann nicht mehr verändert werden.");
    Textfeld1.setFont(new Font("Calibri", Font.PLAIN, 16));
    Textfeld1.setBackground(new Color(0xEEEEEE));
    Feld2.add(Textfeld1ScrollPane);
   } // Ende Komponenten
  // Anfang Methoden
  
  public static void main(String[] args) {
    new PrototypSchülerkarte();
  } // end of main
  
  public void Save_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of Save_ActionPerformed

  public void Cancel_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of Cancel_ActionPerformed

  public void Speichern1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of Speichern1_ActionPerformed

  public void Abbrechen2_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of Abbrechen2_ActionPerformed

  // Ende Methoden
} // end of class PrototypSchülerkarte
