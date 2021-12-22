package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Frame extends JFrame {

    Frame() throws SQLException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ArrayList<Room> rooms = RoomRepository.getAll();
        GridLayout gridLayout = new GridLayout(rooms.size(), 1, 0, 10);
        this.setLayout(gridLayout);

        for (Room room : rooms) {              // a loop for printing rooms
            this.add(new RoomFrame(room));
        }

        this.getContentPane().setBackground(Color.decode("#0e9594"));

        this.add(new InfoPanel("-Select a room and click 'book' button."));
        this.add(new InfoPanel("-All drink costs included."));
        this.add(new InfoPanel("-We accept only cash."));
        this.add(new InfoPanel("-Hope you enjoy."));
        this.add(new InfoPanel("-King and queen rooms includes 1 ultra sized bed."));
        this.add(new InfoPanel("-If u wish abandon renting the room, just click 'unbook'."));

        this.setSize(1000, 1000);
        this.setVisible(true);

    }
    //TODO add operation to get rooms by filters
    //TODO add booking by time operation
    //TODO add receiving and giving money operation(user writes money amount then code calculates change and writes it)
    //TODO improve gui
}