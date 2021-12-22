package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import static java.awt.Color.red;

public class RoomFrame extends JPanel {
    //init variables
    JPanel panel1;
    JLabel idLabel, typeLabel, bedAmountLabel, smokable, bookable, cost;
    JButton actionButton;

    RoomFrame(Room room) {
        this.setLayout(new GridLayout(1, 1));
        this.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 0, Color.black));
        this.setVisible(true);

        //creating variables
        panel1 = new JPanel();
        idLabel = new JLabel();
        cost = new JLabel("cost:" + room.getCost() + "$ per day");
        typeLabel = new JLabel("Type: " + room.getType());
        bedAmountLabel = new JLabel("Bed Amount: " + room.getBedAmount());
        smokable = new JLabel();
        panel1.setLayout(new GridLayout(3, 1));

        //process
        idLabel.setBorder(BorderFactory.createTitledBorder("Room number:" + room.getId()));

        if (room.isSmokable()) {
            smokable.setText("Smokable Room");
        } else {
            smokable.setText("Unsmokable Room");
        }
        bookable = new JLabel();
        if (room.isBookable()) {
            bookable.setText("Unbookable");
        } else {
            bookable.setText("Bookable");
        }
        actionButton = new JButton(room.isBookable() ? "UnBook" : "Book");
        actionButton.addActionListener(e -> {
            try {
                room.setBookable(!room.isBookable());
                RoomRepository.updateRoomBookedStatus(room.getId(), room.isBookable());
                actionButton.setText(room.isBookable() ? "UnBook" : "Book");
                bookable.setText(room.isBookable() ? "Unbookable" : "Bookable");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        actionButton.setBorder(BorderFactory.createRaisedBevelBorder());

        //adding color to variables
        panel1.setBackground(Color.decode("#f5dfbb"));
        actionButton.setBackground(Color.decode("#a2abb5"));
        bookable.setForeground(red);

        //adding variables
        this.add(panel1);
        panel1.add(idLabel);
        panel1.add(typeLabel);
        panel1.add(smokable);
        panel1.add(bookable);
        panel1.add(bedAmountLabel);
        panel1.add(cost);
        panel1.add(actionButton);


    }
}
