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
    private int status;
    private Date date;
    private int total;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public Account getPatientAcc() {
        return patientAcc;
    }

    public void setPatientAcc(Account patientAcc) {
        this.patientAcc = patientAcc;
    }

    public Account getDoctorAcc() {
        return doctorAcc;
    }

    public void setDoctorAcc(Account doctorAcc) {
        this.doctorAcc = doctorAcc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
