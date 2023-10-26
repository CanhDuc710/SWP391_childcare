/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author duchi
 */
public class Reservation2 {

    private int reservationId;
    private int slotId;
    private int patientId;
    private int childrenId;
    private int staffId;
    private int statusId;
    private Date bookDate;
    private Date date;
    private double total;

    public Reservation2() {
    }

    public Reservation2(int reservationId, int slotId, int patientId, int childrenId, int staffId, int statusId, Date bookDate, Date date, double total) {
        this.reservationId = reservationId;
        this.slotId = slotId;
        this.patientId = patientId;
        this.childrenId = childrenId;
        this.staffId = staffId;
        this.statusId = statusId;
        this.bookDate = bookDate;
        this.date = date;
        this.total = total;
    }

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

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getChildrenId() {
        return childrenId;
    }

    public void setChildrenId(int childrenId) {
        this.childrenId = childrenId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
