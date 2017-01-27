import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 16.01.2017
  * @author 
  */

public class Test extends JFrame {
  // Anfang Attribute
  private JLabel jL_ueberschrift = new JLabel();
  private JTextField txt_BIN = new JTextField();
  private JButton jB_rueckgaengig = new JButton();
  private JLabel jL_ = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JLabel jLabel5 = new JLabel();
  private JLabel jLabel6 = new JLabel();
  private JLabel jLabel7 = new JLabel();
  private JTextField jTextField2 = new JTextField();
  private JTextField jTextField3 = new JTextField();
  private JTextField jTextField4 = new JTextField();
  private JTextField jTextField5 = new JTextField();
  private JTextField jTextField6 = new JTextField();
  private JTextField jTextField7 = new JTextField();
  // Ende Attribute
  
  public Test() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 1054; 
    int frameHeight = 722;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Test");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jL_ueberschrift.setBounds(64, 56, 331, 49);
    jL_ueberschrift.setText("Bücherrückgabe");
    cp.add(jL_ueberschrift);
    txt_BIN.setBounds(56, 120, 294, 36);
    txt_BIN.setEditable(true);
    cp.add(txt_BIN);
    jB_rueckgaengig.setBounds(384, 120, 209, 33);
    jB_rueckgaengig.setText("Rückgängig");
    jB_rueckgaengig.setMargin(new Insets(2, 2, 2, 2));
    jB_rueckgaengig.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jB_rueckgaengig_ActionPerformed(evt);
      }
    });
    cp.add(jB_rueckgaengig);
    jL_.setBounds(56, 192, 155, 41);
    jL_.setText("text");
    cp.add(jL_);
    jLabel3.setBounds(48, 240, 171, 41);
    jLabel3.setText("text");
    cp.add(jLabel3);
    jLabel4.setBounds(48, 352, 171, 41);
    jLabel4.setText("text");
    cp.add(jLabel4);
    jLabel5.setBounds(56, 408, 171, 41);
    jLabel5.setText("text");
    cp.add(jLabel5);
    jLabel6.setBounds(48, 288, 171, 41);
    jLabel6.setText("text");
    cp.add(jLabel6);
    jLabel7.setBounds(40, 480, 211, 49);
    jLabel7.setText("text");
    cp.add(jLabel7);
    jTextField2.setBounds(280, 200, 297, 25);
    cp.add(jTextField2);
    jTextField3.setBounds(280, 280, 297, 25);
    cp.add(jTextField3);
    jTextField4.setBounds(296, 416, 297, 25);
    cp.add(jTextField4);
    jTextField5.setBounds(288, 344, 297, 25);
    cp.add(jTextField5);
    jTextField6.setBounds(280, 240, 297, 25);
    cp.add(jTextField6);
    jTextField7.setBounds(288, 496, 297, 25);
    cp.add(jTextField7);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Test
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Test();
  } // end of main
  
  public void jB_rueckgaengig_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of jB_rueckgaengig_ActionPerformed

  // Ende Methoden
} // end of class Test
