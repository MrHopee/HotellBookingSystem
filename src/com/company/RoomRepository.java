package com.company;

import java.sql.*;
import java.util.ArrayList;

public class RoomRepository {
    public static ArrayList<Room> getAll() throws SQLException {
        ArrayList<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM room ORDER BY id ASC";
        Connection connection = PostgreSQLJDBC.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String type = rs.getString("type");
            int bedAmount = rs.getInt("bed_amount");
            boolean smokable = rs.getBoolean("smokable");
            boolean booked = rs.getBoolean("booked");
            int cost = rs.getInt("cost");
            String details = rs.getString("details");

            rooms.add(new Room(id, type, bedAmount, smokable, booked, cost, details));
        }
        rs.close();
        stmt.close();
        return rooms;
    }

    public static Room getById(int roomId) throws SQLException {
        Room room = null;
        String sql = "SELECT * FROM room WHERE id=" + roomId;
        Connection connection = PostgreSQLJDBC.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String type = rs.getString("type");
            int bedAmount = rs.getInt("bed_amount");
            boolean smokable = rs.getBoolean("smokable");
            boolean booked = rs.getBoolean("booked");
            int cost = rs.getInt("cost");
            String details = rs.getString("details");
            room = new Room(id, type, bedAmount, smokable, booked, cost, details);
        }
        rs.close();
        stmt.close();
        return room;
    }

    public static void updateRoomBookedStatus(int roomId, boolean status) throws SQLException {
        String SQL = "UPDATE room SET booked = ? WHERE id = ?";
        Connection connection = PostgreSQLJDBC.getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(SQL);
        prepareStatement.setBoolean(1, status);
        prepareStatement.setInt(2, roomId);
        prepareStatement.executeUpdate();
    }
}
