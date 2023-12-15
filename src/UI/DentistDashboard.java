package UI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DentistDashboard extends JFrame{


    public DentistDashboard() {
        setTitle("Dentist Dahsboard");
        setSize(300, 150);
        setLocationRelativeTo(null);
        JLabel text = new JLabel("I'm dentist :)");
        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
        this.add(text);
        setVisible(true);
    }

    private void placeComponents(JPanel panel) {


    }


}
