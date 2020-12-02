package me.lozm.calculator.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalculatorGui extends JFrame {

    static JLabel label;
    static JLabel info;
    static int flag = 0;
    static int check = 0;

    private final String ENTER_THE_FORMULA = "수식을 입력하세요.";
    private final String ENTER_INITIALIZE = "";

    public CalculatorGui() {
        setTitle("계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(Color.BLACK);

        NorthPanel northPanel = new NorthPanel();
        contentPane.add(northPanel, BorderLayout.NORTH);

        CenterPanel centerPanel = new CenterPanel();
        contentPane.add(centerPanel, BorderLayout.SOUTH);

        setSize(500, 600);
        setVisible(true);
    }

    class NorthPanel extends JPanel {

        public NorthPanel() {
            setLayout(new GridLayout(3, 1));
            setBackground(Color.BLACK);

            info = new JLabel(ENTER_THE_FORMULA);
            info.setFont(getFontInstance(20));
            info.setBackground(Color.BLACK);
            info.setForeground(Color.white);
            info.setHorizontalAlignment(SwingConstants.RIGHT);
            add(info);

            label = new JLabel(ENTER_INITIALIZE);
            label.setFont(getFontInstance(40));
            label.setBackground(Color.BLACK);
            label.setForeground(Color.white);
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            label.addMouseListener(new MyMouse());
            add(label);
        }

    }

    private Font getFontInstance(int fontSize) {
        return new Font("맑은 고딕", 0, fontSize);
    }

    class MyMouse extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            if (e.getClickCount() == 2) {
                flag = 0;
                info.setText(ENTER_THE_FORMULA);
                label.setText(ENTER_INITIALIZE);
            }
        }

    }

    class CenterPanel extends JPanel {

        public CenterPanel() {
            setBackground(Color.BLACK);
            setLayout(new GridLayout(4, 4, 5, 5));

            JButton[] buttonArr = new JButton[16];
            buttonArr[0] = new JButton("7");
            buttonArr[1] = new JButton("8");
            buttonArr[2] = new JButton("9");
            buttonArr[3] = new JButton("÷");

            buttonArr[4] = new JButton("4");
            buttonArr[5] = new JButton("5");
            buttonArr[6] = new JButton("6");
            buttonArr[7] = new JButton("x");

            buttonArr[8] = new JButton("1");
            buttonArr[9] = new JButton("2");
            buttonArr[10] = new JButton("3");
            buttonArr[11] = new JButton("-");

            buttonArr[12] = new JButton("C");
            buttonArr[13] = new JButton("0");
            buttonArr[14] = new JButton("=");
            buttonArr[15] = new JButton("+");

            for (int i = 0; i < buttonArr.length; i++) {
                if(i % 4 != 3 && i < 11) {
                    buttonArr[i].setFont(getFontInstance(30));
                    buttonArr[i].setBackground(Color.LIGHT_GRAY);
                    buttonArr[i].setForeground(Color.WHITE);
                    add(buttonArr[i]);
                } else if(i == 12 || i == 14) {
                    buttonArr[i].setFont(getFontInstance(30));
                    buttonArr[i].setBackground(Color.LIGHT_GRAY);
                    buttonArr[i].setForeground(Color.WHITE);
                    add(buttonArr[i]);
                }  else if(i % 4 == 3) {
                    buttonArr[i].setFont(getFontInstance(40));
                    buttonArr[i].setBackground(Color.YELLOW);
                    buttonArr[i].setForeground(Color.WHITE);
                    add(buttonArr[i]);
                } else if(i == 13) {
                    buttonArr[i].setFont(getFontInstance(30));
                    buttonArr[i].setBackground(Color.GRAY);
                    buttonArr[i].setForeground(Color.WHITE);
                    add(buttonArr[i]);
                }

            }
        }

    }

}
