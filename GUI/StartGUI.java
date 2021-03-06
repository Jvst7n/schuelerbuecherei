import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 09.01.2017
  * @author 
  */

public class StartGUI extends JFrame {
  // Anfang Attribute
  private JComboBox<String> cb_filter = new JComboBox<String>();
  private DefaultComboBoxModel<String> cb_filterModel = new DefaultComboBoxModel<String>();
  private JTextField tf_suchfeld = new JTextField();
  private JButton b_login = new JButton();
  private JButton b_ausgeliehen = new JButton();
  private JButton b_klassenweise = new JButton();
  private JPanel p_panel = new JPanel(null, true);
  private JComboBox<String> cb_anlegen = new JComboBox<String>();
  private DefaultComboBoxModel<String> cb_anlegenModel = new DefaultComboBoxModel<String>();
  private JButton b_zurueckgeben = new JButton();
  private JButton b_abzugeben = new JButton();
  private JButton b_import = new JButton();
  private JButton b_delete = new JButton();
  private int links = 180;
  private int oben = 10;
  private JLabel l_logo = new JLabel();
  private ImageIcon l_logoIcon = new ImageIcon("images/schulbuecherei.png");
  
  private PersonPanel jp_person = new PersonPanel();
  int rechte = 0;
  
  private JButton b_logOut = new JButton();
  protected JLabel l_benutzer = new JLabel();
  protected JLabel l_rechte = new JLabel();
  protected Benutzer b;
  protected LogIn l;
  // Ende Attribute
  /**
   * @author Antek Ruehmigen, Konradin Wagner, Tsenguun Donth
   * @version 0.7
   *
   * Größen der Komponenten im Computerraum anpassen!!!!
  */
  public StartGUI() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int Width = Toolkit.getDefaultToolkit().getScreenSize().width;                      
    int Height =  Toolkit.getDefaultToolkit().getScreenSize().height;
    int frameWidth = 1296; 
    int frameHeight = 820;
    setSize(Width, Height);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("StartGUI");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    
    // Anfang Komponenten
    
    cb_filter.setModel(cb_filterModel);
    cb_filter.setBounds(224, 16, 193, 41);
    cb_filter.setToolTipText("Alle");
    cb_filter.setSelectedIndex(-1);
    cb_filterModel.addElement("Alle");
    cb_filterModel.addElement("Buch");
    cb_filterModel.addElement("Person");
    cb_filterModel.addElement("Verlag");
    cp.add(cb_filter);
    tf_suchfeld.setBounds(416, 16, 953, 41);
    tf_suchfeld.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        tf_suchfeld_ActionPerformed(evt);
        jp_person.setBounds(40, 168, 1600, 842);
        jp_person.setLayout(null);
        jp_person.setBorder(BorderFactory.createBevelBorder(0, Color.DARK_GRAY, Color.GRAY));
        cp.add(jp_person);
      }
    });
    cp.add(tf_suchfeld);
    b_login.setBounds(100, 16, 113, 41);
    b_login.setText("Login");
    b_login.setMargin(new Insets(2, 2, 2, 2));
    b_login.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b_login_ActionPerformed(evt);
      }
    });
    cp.add(b_login);
    b_ausgeliehen.setBounds(1240, 64, 129, 41);
    b_ausgeliehen.setText("Ausgeliehen");
    b_ausgeliehen.setMargin(new Insets(2, 2, 2, 2));
    b_ausgeliehen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b_ausgeliehen_ActionPerformed(evt);
      }
    });
    cp.add(b_ausgeliehen);
    b_klassenweise.setBounds(1104, 64, 129, 41);
    b_klassenweise.setText("Klassenausleihe");
    b_klassenweise.setMargin(new Insets(2, 2, 2, 2));
    b_klassenweise.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b_klassenweise_ActionPerformed(evt);
      }
    });
    cp.add(b_klassenweise);
    p_panel.setBounds(40, 168, 1600, 842);
    p_panel.setOpaque(false);
    p_panel.setBorder(BorderFactory.createBevelBorder(0, Color.DARK_GRAY, Color.GRAY));
    cp.add(p_panel);
    cb_anlegen.setModel(cb_anlegenModel);
    cb_anlegen.setBounds(968, 64, 129, 41);
    cb_anlegen.setToolTipText("Neu");
    cb_anlegen.setSelectedIndex(-1);
    cb_anlegenModel.addElement("Neu");
    cb_anlegenModel.addElement("Buch");
    cb_anlegenModel.addElement("Person");
    cp.add(cb_anlegen);
    b_zurueckgeben.setBounds(848, 64, 113, 41);
    b_zurueckgeben.setText("zurückgeben");
    b_zurueckgeben.setMargin(new Insets(2, 2, 2, 2));
    b_zurueckgeben.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b_zurueckgeben_ActionPerformed(evt);
      }
    });
    cp.add(b_zurueckgeben);
    b_abzugeben.setBounds(416, 64, 129, 41);
    b_abzugeben.setText("abzugebene Bücher");
    b_abzugeben.setMargin(new Insets(2, 2, 2, 2));
    b_abzugeben.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b_abzugeben_ActionPerformed(evt);
      }
    });
    cp.add(b_abzugeben);
    b_import.setBounds(552, 64, 129, 41);
    b_import.setText("Schüler-Import");
    b_import.setMargin(new Insets(2, 2, 2, 2));
    b_import.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b_import_ActionPerformed(evt);
      }
    });
    cp.add(b_import);
    b_delete.setBounds(688, 64, 129, 41);
    b_delete.setText("löschen");
    b_delete.setMargin(new Insets(2, 2, 2, 2));
    b_delete.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b_delete_ActionPerformed(evt);
      }
    });
    cp.add(b_delete);
    cp.setBackground(Color.WHITE);
    l_logo.setBounds(40, 16, 129, 129);
    l_logo.setText("");
    l_logo.setIcon(l_logoIcon);
    l_logo.setBackground(new Color(0xC0C0C0));
    l_logo.setOpaque(true);
    l_logo.setVisible(true);
    cp.add(l_logo);
    
    b_logOut.setBounds(184, 64, 105, 33);
    b_logOut.setText("Logout");
    b_logOut.setMargin(new Insets(2, 2, 2, 2));
    b_logOut.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b_logOut_ActionPerformed(evt);
      }
    });
    cp.add(b_logOut);
    l_benutzer.setBounds(184, 104, 110, 28);
    l_benutzer.setText("");
    cp.add(l_benutzer);
    l_rechte.setBounds(184, 136, 115, 25);
    l_rechte.setText("Lesemodus");
    cp.add(l_rechte);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public StartGUI
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new StartGUI();
    DB db = new DB();
  } // end of main
  
  public void b_login_ActionPerformed(ActionEvent evt) {
    l = new LogIn();
    //3a87b74bbb1836cc4d08be420be258620c92acbf 
  } // end of b_login_ActionPerformed

  public void setBenutzer() {
    l_benutzer.setText(l.b.getName());
    if (rechte == 0) {
      l_rechte.setText("Lesemodus");
    } // end of if
    if (rechte == 1) {
      l_rechte.setText("Verwaltermodus");
    } // end of if
    if (rechte == 2) {
      l_rechte.setText("Adminmodus");
    } // end of if
  }

  public void b_ausgeliehen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of b_ausgeliehen_ActionPerformed

  public void b_klassenweise_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of b_klassenweise_ActionPerformed

  public void b_zurueckgeben_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of b_zurueckgeben_ActionPerformed

  public void b_abzugeben_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of b_abzugeben_ActionPerformed

  public void b_import_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of b_import_ActionPerformed

  public void b_delete_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of b_delete_ActionPerformed

  public void tf_suchfeld_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of tf_suchfeld_ActionPerformed

  public void b_logOut_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of b_logOut_ActionPerformed

  // Ende Methoden
} // end of class StartGUI
