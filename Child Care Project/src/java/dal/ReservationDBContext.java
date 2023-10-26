/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Account;
import Model.Reservation;
import Model.Slot;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GL
 */
public class ReservationDBContext extends DBHelper {

    public ArrayList<Reservation> getWithPatient(Account patient) {
        ArrayList<Reservation> reservations = new ArrayList<>();
        try {
            String sql = "Select r.reservation_id, s.staff_id, s.name, s.gender from Reservation r inner joib Staff s on r.staff_id = s.staff_id";
            PreparedStatement stm = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reservations;
    }

    public ArrayList<Slot> getSlots() {
        ArrayList<Slot> slots = new ArrayList<>();
        try {
            String sql = "select slot_id, start_time, end_time from Slot";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String start = rs.getString(2);
                String end = rs.getString(3);
                Slot slot = new Slot();
                slot.setSlotId(id);
                slot.setStartTime(start);
                slot.setEndTime(end);
                slots.add(slot);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slots;
    }

    public ArrayList<Reservation> getAvailable() {
        ArrayList<Reservation> available = new ArrayList<>();
        try {
            String sql = "select r.reservation_id, r.slot_id, s.staff_id, s.name, r.patient_id, r.[date] "
                    + "from Reservation r inner join Staff s on r.staff_id = s.staff_id "
                    + "where r.patient_id is null and r.date >= CAST(GETDATE() AS Date)";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int reserId = rs.getInt(1);
                int slotId = rs.getInt(2);
                int doctorId = rs.getInt(3);
                String doctorName = rs.getString(4);
                Date date = rs.getDate(6);
                
                Reservation reser = new Reservation();
                reser.setReservationId(reserId);
                reser.setSlotId(slotId);
                Account doctor = new Account();
                doctor.setAccountId(doctorId);
                doctor.setName(doctorName);
                reser.setDoctorAcc(doctor);
                reser.setDate(date);
                
                available.add(reser);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return available;
    }

    public boolean checkAvailable(int reservationId) {
        try {
            String sql = "select * from Reservation where reservation_id = ? and patient_id = null";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, reservationId);
            ResultSet rs = stm.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void book(int patientId, int reservationId) {
        try {
            String sql = "Update Reservation set patient_id = ? where reservation_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, patientId);
            stm.setInt(2, reservationId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create(int doctorId, String[] slotIds, Date from, Date to) {
        try {
            connection.setAutoCommit(false);
            String insertSQL = "INSERT INTO Reservation (slot_id, staff_id, date) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            Date currentDate = from;
            while (!from.after(to)) {
                for (String slot : slotIds) {
                    preparedStatement.setInt(1, Integer.parseInt(slot));
                    preparedStatement.setInt(2, doctorId);
                    preparedStatement.setDate(3, currentDate);
                    preparedStatement.executeUpdate();
                }
                currentDate.setTime(currentDate.getTime() + 24 * 60 * 60 * 1000);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ReservationDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
