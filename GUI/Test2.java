import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Toolkit;
  
public class Test2 {
  JFrame frame;
    
  public Test2() {
    frame = new JFrame("Test");
    frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    frame.show();     
  }
  
  public static void main(String[] args)  {
    Test2 app = new Test2();
  }
}