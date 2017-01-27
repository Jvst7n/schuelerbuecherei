import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 27.01.2017
  * @author 
  */

public class Test3 extends JFrame {
  // Anfang Attribute
  private TextField textField1 = new TextField();
  private Button button1 = new Button();
  private Tabelle jTable1;
    private DefaultTableModel jTable1Model = (DefaultTableModel) jTable1.getModel();
    private JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);
  // Ende Attribute
  
  public Test3() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 770; 
    int frameHeight = 498;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Test3");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    textField1.setBounds(96, 32, 289, 25);
    cp.add(textField1);
    button1.setBounds(400, 24, 81, 33);
    button1.setLabel("button1");
    button1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        button1_ActionPerformed(evt);
      }
    });
    cp.add(button1);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Test3
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Test3();
  } // end of main
  
  public void button1_ActionPerformed(ActionEvent evt) {
    this.textField1.getText()
  } // end of button1_ActionPerformed

  // Ende Methoden
} // end of class Test3
