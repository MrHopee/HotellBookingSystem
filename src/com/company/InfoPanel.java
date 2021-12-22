package com.company;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    JLabel textlabel1;


    InfoPanel(String text) {

        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 0, Color.black));
        this.setBackground(Color.decode("#ddbea8"));

        textlabel1 = new JLabel(text);
        this.add(textlabel1);

    }


}
