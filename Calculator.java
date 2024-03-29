package calculator;

/**
 *
 * @author Leila
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener{
    JFrame frame;
    JPanel panel;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, multButton, divButton, decButton, deltButton, eqButton, clrButton;
    Font font = new Font("Times New Roman", Font.BOLD, 30);
    
    double num1=0, num2=0, result=0;
    char operator;
    
    
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(font);
        textfield.setEnabled(false);
        addButton = new JButton("+");
        subButton = new JButton("-");
        multButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        deltButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        
        functionButtons[0]= addButton;
        functionButtons[1]= subButton;
        functionButtons[2]= multButton;
        functionButtons[3]= divButton;
        functionButtons[4]= decButton;
        functionButtons[5]= eqButton;
        functionButtons[6]= deltButton;
        functionButtons[7]= clrButton;
        
        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
        }
        
        for (int i = 0; i < 10; i++) {
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
        }
        deltButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);
        
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(eqButton);
        panel.add(divButton);
        
        frame.add(panel);
        frame.add(deltButton);
        frame.add(clrButton);
        frame.add(textfield);
        
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        
        if (e.getSource() == decButton) {
                textfield.setText(textfield.getText().concat("."));
        }
        
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == multButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(textfield.getText());
            switch (operator) {
                case '+' :
                    result=num1+num2;
                    break;
                case '-' :
                    result=num1-num2;
                    break;
                case '*' :
                    result=num1*num2;
                    break;
                case '/' :
                    result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if (e.getSource() == clrButton) {
            num1 = 0;
            num2 = 0;
            textfield.setText("");
        }
        if (e.getSource() == deltButton) {
            String str =textfield.getText();
            textfield.setText("");
            for (int i = 0; i < str.length()-1; i++) {
                textfield.setText(textfield.getText()+str.charAt(i));
            }
        }
    }
    
}
