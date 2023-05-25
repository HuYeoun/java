import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class CoffeeOrder extends JFrame implements ActionListener {
    private JLabel label;
    private JRadioButton small, medium, large;
    private JCheckBox cream, sugar;
    private JTextField requestField;
    private JButton submit;

    public CoffeeOrder() {
        setTitle("Coffee Order");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 커피 사이즈
        JPanel sizePanel = new JPanel(new GridLayout(0, 1));
        sizePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Select a size:"));
        ButtonGroup group = new ButtonGroup();
        small = new JRadioButton("Small");
        small.setActionCommand("Small");
        group.add(small);
        sizePanel.add(small);
        medium = new JRadioButton("Medium");
        medium.setActionCommand("Medium");
        group.add(medium);
        sizePanel.add(medium);
        large = new JRadioButton("Large");
        large.setActionCommand("Large");
        group.add(large);
        sizePanel.add(large);
        add(sizePanel, BorderLayout.NORTH);

        // 추가 옵션
        JPanel optionPanel = new JPanel(new GridLayout(0, 1));
        optionPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Select additional options:"));
        cream = new JCheckBox("Cream");
        optionPanel.add(cream);
        sugar = new JCheckBox("Sugar");
        optionPanel.add(sugar);
        add(optionPanel, BorderLayout.CENTER);

        // 요청사항 입력
        JPanel requestPanel = new JPanel(new BorderLayout());
        requestPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Request:"));
        requestField = new JTextField();
        requestPanel.add(requestField);
        add(requestPanel, BorderLayout.SOUTH);

        // 주문 버튼
        JPanel buttonPanel = new JPanel();
        submit = new JButton("Order");
        submit.addActionListener(this);
        buttonPanel.add(submit);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // 주문 정보 출력
        String size = "";
        if (small.isSelected()) {
            size = "Small";
        } else if (medium.isSelected()) {
            size = "Medium";
        } else if (large.isSelected()) {
            size = "Large";
        }

        String options = "";
        if (cream.isSelected()) {
            options += "Cream ";
        }
        if (sugar.isSelected()) {
            options += "Sugar";
        }

        String request = requestField.getText();

        JOptionPane.showMessageDialog(this, "Order placed: " + size + " coffee with " + options + "\nRequest: " + request);
    }

    public static void main(String[] args) {
        new CoffeeOrder();
    }
}
