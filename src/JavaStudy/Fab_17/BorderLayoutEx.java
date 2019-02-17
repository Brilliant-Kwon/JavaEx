package JavaStudy.Fab_17;

import Jan_21.oop.summary.Panda;
import JavaStudy.Jan_31.NSH.Calendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class BorderLayoutEx extends JFrame {
    private ArrayList<String> arrayList = new ArrayList<>();
    private int index = 0;

    BorderLayoutEx() {//자체가 JFrame을 내장하고 있음.
        setTitle("계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel showResult = new JLabel("");
        showResult.setFont(new Font("D2Coding", Font.BOLD, 40));
        showResult.setHorizontalAlignment(JTextField.CENTER);

        JButton button[] = new JButton[16];

        JPanel p = new JPanel(new GridLayout(4, 4, 0, 0));
        JPanel p_show = new JPanel(new GridLayout(1, 1));
        p.setPreferredSize(new Dimension(300, 400));
        p_show.setPreferredSize(new Dimension(300, 100));
        p_show.add(showResult);

        p.add(button[7] = new JButton("7"));
        p.add(button[8] = new JButton("8"));
        p.add(button[9] = new JButton("9"));
        p.add(button[10] = new JButton("+"));
        p.add(button[4] = new JButton("4"));
        p.add(button[5] = new JButton("5"));
        p.add(button[6] = new JButton("6"));
        p.add(button[11] = new JButton("-"));
        p.add(button[1] = new JButton("1"));
        p.add(button[2] = new JButton("2"));
        p.add(button[3] = new JButton("3"));
        p.add(button[12] = new JButton("*"));
        p.add(button[0] = new JButton("0"));
        p.add(button[15] = new JButton("C"));
        p.add(button[14] = new JButton("="));
        p.add(button[13] = new JButton("/"));


        for (int i = 0; i < 16; i++) {
            button[i].setBackground(Color.DARK_GRAY);
            button[i].setForeground(Color.white);
            button[i].setFont(new Font("Consolas", Font.BOLD, 25));
            button[i].addActionListener(e -> {
                JButton btn = (JButton) e.getSource();
                String str = btn.getText();

                if (str.equals("0")) {
                    showResult.setText(showResult.getText() + "0");
                } else if (str.equals("1")) {
                    showResult.setText(showResult.getText() + "1");
                } else if (str.equals("2")) {
                    showResult.setText(showResult.getText() + "2");
                } else if (str.equals("3")) {
                    showResult.setText(showResult.getText() + "3");
                } else if (str.equals("4")) {
                    showResult.setText(showResult.getText() + "4");
                } else if (str.equals("5")) {
                    showResult.setText(showResult.getText() + "5");
                } else if (str.equals("6")) {
                    showResult.setText(showResult.getText() + "6");
                } else if (str.equals("7")) {
                    showResult.setText(showResult.getText() + "7");
                } else if (str.equals("8")) {
                    showResult.setText(showResult.getText() + "8");
                } else if (str.equals("9")) {
                    showResult.setText(showResult.getText() + "9");
                } else if (str.equals("+")) {
                    if (showResult.getText().length() > 0 &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                        arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                        arrayList.add("+");
                        showResult.setText(showResult.getText() + "+");
                        index = showResult.getText().length();
                    }
                } else if (str.equals("-")) {
                    if (showResult.getText().length() > 0 &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                        arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                        arrayList.add("-");
                        showResult.setText(showResult.getText() + "-");
                        index = showResult.getText().length();
                    }
                } else if (str.equals("*")) {
                    if (showResult.getText().length() > 0 &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                        arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                        arrayList.add("*");
                        showResult.setText(showResult.getText() + "*");
                        index = showResult.getText().length();
                    }
                } else if (str.equals("/")) {
                    if (showResult.getText().length() > 0 &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                        arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                        arrayList.add("/");
                        showResult.setText(showResult.getText() + "/");
                        index = showResult.getText().length();
                    }
                } else if (str.equals("C")) {
                    showResult.setText("");
                    arrayList = new ArrayList<>();//어레이리스트까지 초기화
                    index = 0;
                } else if (str.equals("=")) {
                    if (showResult.getText().length() > 0 &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                        arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                        for (int oper = 1; oper < arrayList.size(); oper += 2) {
                            if (arrayList.get(oper) != null) {
                                if (arrayList.get(oper).equals("*")) {
                                    arrayList.set(oper + 1, String.valueOf(Integer.parseInt(arrayList.get(oper - 1)) * Integer.parseInt(arrayList.get(oper + 1))));
                                    arrayList.set(oper, null);
                                    arrayList.set(oper - 1, null);
                                } else if (arrayList.get(oper).equals("/")) {
                                    arrayList.set(oper + 1, String.valueOf(Integer.parseInt(arrayList.get(oper - 1)) / Integer.parseInt(arrayList.get(oper + 1))));
                                    arrayList.set(oper, null);
                                    arrayList.set(oper - 1, null);
                                }
                            }
                        }
                        ArrayList<String> tempList = new ArrayList<>();
                        for (String anArrayList : arrayList) {
                            if (anArrayList != null) {
                                tempList.add(anArrayList);
                            }
                        }
                        arrayList = tempList;
                        for (int oper = 1; oper < arrayList.size(); oper += 2) {
                            if (arrayList.get(oper) != null) {
                                if (arrayList.get(oper).equals("+")) {
                                    arrayList.set(oper + 1, String.valueOf(Integer.parseInt(arrayList.get(oper - 1)) + Integer.parseInt(arrayList.get(oper + 1))));
                                    arrayList.set(oper, null);
                                    arrayList.set(oper - 1, null);
                                } else if (arrayList.get(oper).equals("-")) {
                                    arrayList.set(oper + 1, String.valueOf(Integer.parseInt(arrayList.get(oper - 1)) - Integer.parseInt(arrayList.get(oper + 1))));
                                    arrayList.set(oper, null);
                                    arrayList.set(oper - 1, null);
                                }
                            }
                        }
                        tempList = new ArrayList<>();
                        for (String anArrayList : arrayList) {
                            if (anArrayList != null) {
                                tempList.add(anArrayList);
                            }
                        }
                        arrayList = tempList;
//                    for (int k = 0; k < arrayList.size(); k++)
//                        showResult.setText(showResult.getText() + "\n " + k + ": " + arrayList.get(k));

                        showResult.setText(arrayList.get(0));
                        index = 0;

                        arrayList = new ArrayList<>();
                    }
                }
                requestFocus();
            });
        }


        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (keyChar == '0') {
                    showResult.setText(showResult.getText() + "0");
                } else if (keyChar == '1') {
                    showResult.setText(showResult.getText() + "1");
                } else if (keyChar == '2') {
                    showResult.setText(showResult.getText() + "2");
                } else if (keyChar == '3') {
                    showResult.setText(showResult.getText() + "3");
                } else if (keyChar == '4') {
                    showResult.setText(showResult.getText() + "4");
                } else if (keyChar == '5') {
                    showResult.setText(showResult.getText() + "5");
                } else if (keyChar == '6') {
                    showResult.setText(showResult.getText() + "6");
                } else if (keyChar == '7') {
                    showResult.setText(showResult.getText() + "7");
                } else if (keyChar == '8') {
                    showResult.setText(showResult.getText() + "8");
                } else if (keyChar == '9') {
                    showResult.setText(showResult.getText() + "9");
                } else if (keyChar == '+') {
                    if (showResult.getText().length() > 0 &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                        arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                        arrayList.add("+");
                        showResult.setText(showResult.getText() + "+");
                        index = showResult.getText().length();
                    }
                } else if (keyChar == '-') {
                    if (showResult.getText().length() > 0 &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                        arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                        arrayList.add("-");
                        showResult.setText(showResult.getText() + "-");
                        index = showResult.getText().length();
                    }
                } else if (keyChar == '*') {
                    if (showResult.getText().length() > 0 &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                        arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                        arrayList.add("*");
                        showResult.setText(showResult.getText() + "*");
                        index = showResult.getText().length();
                    }
                } else if (keyChar == '/') {
                    if (showResult.getText().length() > 0 &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                        arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                        arrayList.add("/");
                        showResult.setText(showResult.getText() + "/");
                        index = showResult.getText().length();
                    }
                } else if (keyChar == 'C') {
                    showResult.setText("");
                    arrayList = new ArrayList<>();//어레이리스트까지 초기화
                    index = 0;
                } else if (keyChar == '=' || keyChar == '\n' || keyChar == ' ') {
                    if (showResult.getText().length() > 0 &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                        arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                        for (int oper = 1; oper < arrayList.size(); oper += 2) {
                            if (arrayList.get(oper) != null) {
                                if (arrayList.get(oper).equals("*")) {
                                    arrayList.set(oper + 1, String.valueOf(Integer.parseInt(arrayList.get(oper - 1)) * Integer.parseInt(arrayList.get(oper + 1))));
                                    arrayList.set(oper, null);
                                    arrayList.set(oper - 1, null);
                                } else if (arrayList.get(oper).equals("/")) {
                                    arrayList.set(oper + 1, String.valueOf(Integer.parseInt(arrayList.get(oper - 1)) / Integer.parseInt(arrayList.get(oper + 1))));
                                    arrayList.set(oper, null);
                                    arrayList.set(oper - 1, null);
                                }
                            }
                        }
                        ArrayList<String> tempList = new ArrayList<>();
                        for (String anArrayList : arrayList) {
                            if (anArrayList != null) {
                                tempList.add(anArrayList);
                            }
                        }
                        arrayList = tempList;
                        for (int oper = 1; oper < arrayList.size(); oper += 2) {
                            if (arrayList.get(oper) != null) {
                                if (arrayList.get(oper).equals("+")) {
                                    arrayList.set(oper + 1, String.valueOf(Integer.parseInt(arrayList.get(oper - 1)) + Integer.parseInt(arrayList.get(oper + 1))));
                                    arrayList.set(oper, null);
                                    arrayList.set(oper - 1, null);
                                } else if (arrayList.get(oper).equals("-")) {
                                    arrayList.set(oper + 1, String.valueOf(Integer.parseInt(arrayList.get(oper - 1)) - Integer.parseInt(arrayList.get(oper + 1))));
                                    arrayList.set(oper, null);
                                    arrayList.set(oper - 1, null);
                                }
                            }
                        }
                        tempList = new ArrayList<>();
                        for (String anArrayList : arrayList) {
                            if (anArrayList != null) {
                                tempList.add(anArrayList);
                            }
                        }
                        arrayList = tempList;
//                    for (int k = 0; k < arrayList.size(); k++)
//                        showResult.setText(showResult.getText() + "\n " + k + ": " + arrayList.get(k));

                        showResult.setText(arrayList.get(0));
                        index = 0;

                        arrayList = new ArrayList<>();
                    }
                }
            }
        });

        add(p_show, BorderLayout.NORTH);
        add(p, BorderLayout.CENTER);

        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - 300) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - 500) / 2);

        requestFocus();

        setSize(300, 500);
        setVisible(true);


    }

    public static void main(String[] args) {
        new BorderLayoutEx();
    }


}

