import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculation extends JFrame implements ActionListener {
    private final JTextField calculationNumber;
    private int fNumber;
    private String operator;
    private final JTextArea answer;

    public Calculation(){
        super("Calculation");
        setLayout(new BorderLayout());


        //Setting the Calculation TextField and TextArea layout
        calculationNumber = new JTextField(15);
        JPanel topPanel = new JPanel((new GridLayout(2,1)));
        topPanel.add(calculationNumber);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10,20,20,10));
        add(topPanel, BorderLayout.NORTH);
        answer = new JTextArea();
        answer.setVisible(false);
        topPanel.add(answer);


        // Setting the Mathematical Symbol's layout
        JPanel centerPanel = new JPanel(new GridLayout(2,2, 10, 10));
        JButton btnAdd = new JButton("+");
        JButton btnSubtract = new JButton("-");
        JButton btnDivide = new JButton("/");
        JButton btnMultiply = new JButton("*");
        centerPanel.add(btnAdd);
        centerPanel.add(btnSubtract);
        centerPanel.add(btnDivide);
        centerPanel.add(btnMultiply);
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        //Setting the calculation button
        JButton btnAnswer = new JButton("=");
        btnAnswer.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));
        btnAnswer.addActionListener(this);
        add(btnAnswer, BorderLayout.SOUTH);

        //setting the clickListeners of the individual buttons
        btnAdd.addActionListener(e -> {
            fNumber = Integer.parseInt(calculationNumber.getText());
            operator = "Addition";
            calculationNumber.setText("");
            calculationNumber.requestFocus();
        });

        btnSubtract.addActionListener(e -> {
            fNumber = Integer.parseInt(calculationNumber.getText());
            operator = "Subtraction";
            calculationNumber.setText("");
            calculationNumber.requestFocus();
        });

        btnMultiply.addActionListener(e -> {
            fNumber = Integer.parseInt(calculationNumber.getText());
            operator = "Multiplication";
            calculationNumber.setText("");
            calculationNumber.requestFocus();
        });

        btnDivide.addActionListener(e -> {
            fNumber = Integer.parseInt(calculationNumber.getText());
            operator = "Division";
            calculationNumber.setText("");
            calculationNumber.requestFocus();
        });
    }


    private static int additionCalc(int fNumber, int sNumber){
        return fNumber + sNumber;
    }

    private static int subtractionCalc(int fNumber, int sNumber){
        return fNumber - sNumber;
    }

    private static int multiplicationCalc(int fNumber, int sNumber){
        return fNumber * sNumber;
    }

    private static int divisionCalc(int fNumber, int sNumber){
        return (fNumber / sNumber);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int sNumber = Integer.parseInt(calculationNumber.getText());
        answer.setVisible(true);

        int calcResults;
        if (operator == "Addition"){
           calcResults =  additionCalc(fNumber, sNumber);
        }else if(operator == "Subtraction"){
            calcResults = subtractionCalc(fNumber, sNumber);
        }else if (operator == "Division"){
            calcResults = divisionCalc(fNumber, sNumber);
        }else {
            calcResults = multiplicationCalc(fNumber, sNumber);
        }

        answer.setText(String.valueOf(calcResults));


    }
}
