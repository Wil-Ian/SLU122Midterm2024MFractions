import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fraction implements ActionListener{

    private JFrame frame;
    private JPanel panel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private  JTextField textField5;
    private JTextField textField6;
    private JButton answer;
    private JComboBox box;
    private JLabel result;

    Font myFont = new Font("Ink Free", Font.BOLD,30);

    Fraction(){
        JFrame frame = new JFrame("Mixed Fractions Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(750, 500);

        //1st numerator
        textField1 = new JTextField();
        textField1.setBounds(150, 50, 75, 100);
        textField1.setFont(myFont);

        //1st denominator
        textField2 = new JTextField();
        textField2.setBounds(150, 250, 75, 100);
        textField2.setFont(myFont);

        //1st whole number
        textField3 = new JTextField();
        textField3.setBounds(50, 150, 75, 100);
        textField3.setFont(myFont);

        //2nd numerator
        textField4 = new JTextField();
        textField4.setBounds(550, 50, 75, 100);
        textField4.setFont(myFont);

        frame.add(textField1);
        frame.add(textField2);
        frame.add(textField3);
        frame.add(textField4);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public static void main(String[] args ){
        Fraction frac = new Fraction();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
