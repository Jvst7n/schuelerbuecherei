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

public class LogIn extends JFrame implements KeyListener{
  // Anfang Attribute
  private JButton b_login = new JButton();
  private JLabel l_bname = new JLabel();
  private JLabel l_password = new JLabel();
  protected JTextField tf_name = new JTextField();
  private JPasswordField pP_password = new JPasswordField();
  String name = "";
  String password = "";
  private JLabel l_status = new JLabel();
  private JLabel l_meldung = new JLabel();
  public Benutzer b;
  public StartGUI sg;
  // Ende Attribute
  
  public LogIn() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 285; 
    int frameHeight = 253;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("LogIn");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    b_login.setBounds(168, 168, 97, 41);
    b_login.setText("Login");
    b_login.setMargin(new Insets(2, 2, 2, 2));
    b_login.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b_login_ActionPerformed(evt);
      }
    });
    cp.add(b_login);
    l_bname.setBounds(32, 48, 83, 33);
    l_bname.setText("Benutzer");
    cp.add(l_bname);
    l_password.setBounds(32, 96, 83, 33);
    l_password.setText("Passwort");
    cp.add(l_password);
    tf_name.setBounds(128, 48, 137, 33);
    cp.add(tf_name);
    pP_password.setBounds(128, 96, 137, 33);
    cp.add(pP_password);
    l_status.setBounds(32, 144, 51, 25);
    l_status.setText("Status");
    cp.add(l_status);
    l_meldung.setBounds(32, 176, 99, 33);
    l_meldung.setText("");
    l_meldung.setBackground(Color.WHITE);
    l_meldung.setOpaque(true);
    cp.add(l_meldung);
    // Ende Komponenten
    pP_password.addKeyListener(this);
    setVisible(true);
  } // end of public LogIn
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new LogIn();
  } // end of main
  
  public void keyPressed(KeyEvent e) {
    
  }
  
  public void keyReleased(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_ENTER){
      this.logIn();
    }    
  }
  
  public void keyTyped(KeyEvent e) {
    
  }
  
  public void logIn() {
    DB db = new DB();
    name += tf_name.getText();
    password += pP_password.getText();
    b = new Benutzer(name,password);
    if (b.rechte == 0) {
      l_meldung.setText(b.s);
    } // end of if
    else {
      b.rechte = b.getRechte();
      l_meldung.setText("Rechte: " + b.rechte);
      /**String rechte = "";
      if (b.rechte == 0) {
      rechte = "Lesemodus";
      } // end of if
      if (b.rechte == 1) {
      rechte = "Verwaltermodus";
      } // end of if
      if (b.rechte == 2) {
      rechte = "Adminmodus";
      } // end of if
      */
      this.setVisible(false);
      this.dispose();
    } // end of if-else
  }
  
  public void b_login_ActionPerformed(ActionEvent evt) {
    this.logIn();
  } // end of b_login_ActionPerformed
    
  // Ende Methoden
} // end of class LogIn