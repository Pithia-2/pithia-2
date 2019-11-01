package pithia2.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Home extends JFrame
{

  private JPanel MainPanel;
  private JLabel Logo;
  private JLabel Tiile;
  private JButton LoginButton;
  private JLabel Details;
  private JButton test1;

  public Home()
  {
    add(MainPanel);
    setSize(1000,800);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    //Apparently το multiline δουλευει ΜΟΝΟ με HTML :(
    Details.setText("<html>Το Διεθνές Πανεπιστήμιο της Ελλάδος (ΔΙ.ΠΑ.Ε.) ιδρύθηκε το 2005 με έδρα την Θεσσαλονίκη.<br>"
        + "Το πανεπιστήμιο αποτελείται απο 7 σχολές σε Θεσσαλονίκη, Δράμα, Καβάλα και Σέρρες.</html>");

    //Εμφανιζει το Login page
    LoginButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        JFrame login_frame = new Login();
        login_frame.setVisible(true);
      }
    });
  }
}
