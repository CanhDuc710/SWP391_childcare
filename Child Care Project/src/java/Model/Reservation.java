/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author GL
 */
public class Reservation {
    private int reservationId;
    private int slotId;
    private Account patientAcc;
    private Account doctorAcc;
    private String status;
    private Date date;
    private int total;

    public int getReservationId() {
        return reservationId;
    }

    public int getSlotId() {
        return slotId;
    }

    public Account getPatientAcc() {
        return patientAcc;
    }

    public Account getDoctorAcc() {
        return doctorAcc;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    public int getTotal() {
        return total;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public void setPatientAcc(Account patientAcc) {
        this.patientAcc = patientAcc;
    }

    public void setDoctorAcc(Account doctorAcc) {
        this.doctorAcc = doctorAcc;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
