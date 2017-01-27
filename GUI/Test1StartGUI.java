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

public class Test1StartGUI extends JFrame {
  // Anfang Attribute
  private JComboBox<String> jcb_Filter = new JComboBox<String>();
  private DefaultComboBoxModel<String> jcb_FilterModel = new DefaultComboBoxModel<String>();
  private JTextField jtf_Suchfeld = new JTextField();
  private JButton jb_Login = new JButton();
  private JButton jb_Ausgeliehen = new JButton();
  private JButton jb_Klassenausleihe = new JButton();
  private PersonPanel jp_person = new PersonPanel();
 
  private JComboBox<String> jcb_anlegen = new JComboBox<String>();
  private DefaultComboBoxModel<String> jcb_anlegenModel = new DefaultComboBoxModel<String>();
  private JButton jb_zurueckgeben = new JButton();
  private JButton jb_abzugeben = new JButton();
  private JButton jb_import = new JButton();
  private JButton jb_delete = new JButton();
  private int links = 180;
  private int oben = 10;
  private JLabel jl_logo = new JLabel();
  private ImageIcon jl_logoIcon = new ImageIcon("images/schulbuecherei.png");
  
  
  // Ende Attribute
  /**
   * @author Antek Ruehmigen, Konradin Wagner, Tsenguun Donth
   * @version 0.7
   *
   * Größen der Komponenten im Computerraum anpassen!!!!
  */
  public Test1StartGUI() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int Width = Toolkit.getDefaultToolkit().getScreenSize().width;                      
    int Height =  Toolkit.getDefaultToolkit().getScreenSize().height;
    int frameWidth = 1659; 
    int frameHeight = 807;
    setSize(Width, Height);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("TESTStartGUI");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    
    // Anfang Komponenten
    
    jcb_Filter.setModel(jcb_FilterModel);
    jcb_Filter.setBounds(224, 16, 193, 41);
    jcb_Filter.setToolTipText("Alle");
    jcb_Filter.setSelectedIndex(-1);
    jcb_FilterModel.addElement("Alle");
    jcb_FilterModel.addElement("Buch");
    jcb_FilterModel.addElement("Person");
    jcb_FilterModel.addElement("Verlag");
    cp.add(jcb_Filter);
    jtf_Suchfeld.setBounds(416, 16, 953, 41);
    jtf_Suchfeld.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jtf_Suchfeld_ActionPerformed(evt);
      }
    });
    cp.add(jtf_Suchfeld);
    jb_Login.setBounds(127, 16, 113, 41);
    jb_Login.setText("Login");
    jb_Login.setMargin(new Insets(2, 2, 2, 2));
    jb_Login.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jb_Login_ActionPerformed(evt);
      }
    });
    cp.add(jb_Login);
    jb_Ausgeliehen.setBounds(1240, 64, 129, 41);
    jb_Ausgeliehen.setText("Ausgeliehen");
    jb_Ausgeliehen.setMargin(new Insets(2, 2, 2, 2));
    jb_Ausgeliehen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jb_Ausgeliehen_ActionPerformed(evt);
      }
    });
    cp.add(jb_Ausgeliehen);
    jb_Klassenausleihe.setBounds(1104, 64, 129, 41);
    jb_Klassenausleihe.setText("Klassenausleihe");
    jb_Klassenausleihe.setMargin(new Insets(2, 2, 2, 2));
    jb_Klassenausleihe.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jb_Klassenausleihe_ActionPerformed(evt);
      }
    });
    cp.add(jb_Klassenausleihe);
    jp_person.setBounds(40, 168, 1600, 842);
    jp_person.setLayout(null);
    jp_person.setBorder(BorderFactory.createBevelBorder(0, Color.DARK_GRAY, Color.GRAY));
    cp.add(jp_person);
    
    jcb_anlegen.setModel(jcb_anlegenModel);
    jcb_anlegen.setBounds(968, 64, 129, 41);
    jcb_anlegen.setToolTipText("Neu");
    jcb_anlegen.setSelectedIndex(-1);
    jcb_anlegenModel.addElement("Neu");
    jcb_anlegenModel.addElement("Buch");
    jcb_anlegenModel.addElement("Person");
    //cp.add(jcb_anlegen);
    jb_zurueckgeben.setBounds(848, 64, 113, 41);
    jb_zurueckgeben.setText("zurückgeben");
    jb_zurueckgeben.setMargin(new Insets(2, 2, 2, 2));
    jb_zurueckgeben.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jb_zurueckgeben_ActionPerformed(evt);
      }
    });
    cp.add(jb_zurueckgeben);
    jb_abzugeben.setBounds(416, 64, 129, 41);
    jb_abzugeben.setText("abzugebene Bücher");
    jb_abzugeben.setMargin(new Insets(2, 2, 2, 2));
    jb_abzugeben.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jb_abzugeben_ActionPerformed(evt);
      }
    });
    cp.add(jb_abzugeben);
    jb_import.setBounds(552, 64, 129, 41);
    jb_import.setText("Schüler-Import");
    jb_import.setMargin(new Insets(2, 2, 2, 2));
    jb_import.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jb_import_ActionPerformed(evt);
      }
    });
    cp.add(jb_import);
    jb_delete.setBounds(688, 64, 129, 41);
    jb_delete.setText("löschen");
    jb_delete.setMargin(new Insets(2, 2, 2, 2));
    jb_delete.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jb_delete_ActionPerformed(evt);
      }
    });
    cp.add(jb_delete);
    cp.setBackground(Color.WHITE);
    jl_logo.setBounds(40, 16, 129, 129);
    jl_logo.setText("");
    jl_logo.setIcon(jl_logoIcon);
    jl_logo.setBackground(new Color(0xC0C0C0));
    jl_logo.setOpaque(true);
    jl_logo.setVisible(true);
    cp.add(jl_logo);
    
    
    // Ende Komponenten
    
    setVisible(true);
  } // end of public StartGUI
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Test1StartGUI();
  } // end of main
  
  public void jb_Login_ActionPerformed(ActionEvent evt) {
    LogIn L = new LogIn();
  } // end of jb_Login_ActionPerformed

  public void jb_Ausgeliehen_ActionPerformed(ActionEvent evt) {
    
  } // end of jb_Ausgeliehen_ActionPerformed

  public void jb_Klassenausleihe_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of jb_Klassenausleihe_ActionPerformed

  public void jb_zurueckgeben_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of jb_zurueckgeben_ActionPerformed

  public void jb_abzugeben_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of jb_abzugeben_ActionPerformed

  public void jb_import_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of jb_import_ActionPerformed

  public void jb_delete_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of jb_delete_ActionPerformed

  public void jtf_Suchfeld_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of jtf_Suchfeld_ActionPerformed

  // Ende Methoden
} // end of class StartGUI
