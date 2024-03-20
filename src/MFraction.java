import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MFraction implements ActionListener{

    private JFrame frame;
    private JPanel panel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private  JTextField textField5;
    private JTextField textField6;
    private JButton answer = new JButton("Answer");
    JButton[] functionButtons = new JButton[4];
    JButton addButton,subButton,mulButton,divButton;
    private JComboBox dropDown;
    private JLabel result;

    Font myFont = new Font("Ink Free", Font.BOLD,30);

    MFraction(){
        JFrame frame = new JFrame("Mixed Fractions Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(750, 500);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;

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

        //2nd denominator
        textField5 = new JTextField();
        textField5.setBounds(550, 250, 75, 100);
        textField5.setFont(myFont);

        //2nd whole number
        textField6 = new JTextField();
        textField6.setBounds(450, 150, 75, 100);
        textField6.setFont(myFont);

        answer = new JButton();
        answer.setBounds(250, 375, 250, 50 );
        answer.setFont(myFont);
        answer.setForeground(Color.white);
        answer.setBackground(Color.cyan);
        answer.addActionListener(this);

        frame.add(textField1);
        frame.add(textField2);
        frame.add(textField3);
        frame.add(textField4);
        frame.add(textField5);
        frame.add(textField6);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(answer);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));


        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);
    }


    public static void main(String[] args ){
        MFraction frac = new MFraction();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == answer){
            try{
                fractionInner f1 = new fractionInner(Integer.parseInt(textField1.getText()), Integer.parseInt(textField2.getText()));
                fractionInner f2 = new fractionInner(Integer.parseInt(textField3.getText()), Integer.parseInt(textField4.getText()));
                fractionInner res;
                switch (dropDown.getSelectedIndex()){
                    case 0: res = f1.add(f2); break;
                    case 1: res = f1.sub(f2); break;
                    case 2: res = f1.mul(f2); break;
                    case 3: res = f1.div(f2); break;
                    default: res = new fractionInner(1,1);
                }
                result.setText(res.toString());

            }catch (Exception excep) {
                System.out.println(excep.getMessage());
            }

        }

    }
}
