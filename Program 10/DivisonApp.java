import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DivisionApp {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Integer Division");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 2));


        JLabel labelNum1 = new JLabel("Enter Num1:");
        JTextField textNum1 = new JTextField();

        JLabel labelNum2 = new JLabel("Enter Num2:");
        JTextField textNum2 = new JTextField();

        JButton divideButton = new JButton("Divide");
        JLabel resultLabel = new JLabel("Result: ");


        frame.add(labelNum1);
        frame.add(textNum1);
        frame.add(labelNum2);
        frame.add(textNum2);
        frame.add(divideButton);
        frame.add(resultLabel);


        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int num1 = Integer.parseInt(textNum1.getText());
                    int num2 = Integer.parseInt(textNum2.getText());


                    int result = num1 / num2;


                    resultLabel.setText("Result: " + result);

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter integers.", "NumberFormatException", JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {

                    JOptionPane.showMessageDialog(frame, "Cannot divide by zero!", "ArithmeticException", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        frame.setVisible(true);
    }
}
