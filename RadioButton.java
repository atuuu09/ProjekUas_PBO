import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class RadioButton extends JFrame implements ActionListener {
    private JRadioButton radioButton1;
    public RadioButton() {
        setSize(400, 200);
        setLayout(null);
        radioButton1 = new JRadioButton("Option 1");
        radioButton1.setBounds(150, 50, 100, 20);
        radioButton1.addActionListener(this);
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        add(radioButton1);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == radioButton1) {
            JOptionPane.showMessageDialog(this, "Option 1 is selected");
        }
    }

    public static void main(String[] args) {
        new RadioButton();
    }
}
