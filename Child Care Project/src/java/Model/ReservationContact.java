/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author BlackZ36
 */
public class ReservationContact {

    private Reservation2 reservation;
    private Children children;
    private Account patient;

    public ReservationContact() {
    }

    public ReservationContact(Reservation2 reservation, Children children, Account patient) {
        this.reservation = reservation;
        this.children = children;
        this.patient = patient;
    }

    public Reservation2 getReservation() {
        return reservation;
    }

    public void setReservation(Reservation2 reservation) {
        this.reservation = reservation;
    }

    public Children getChildren() {
        return children;
    }

    public void setChildren(Children children) {
        this.children = children;
    }

    public Account getPatient() {
        return patient;
    }

    public void setPatient(Account patient) {
        this.patient = patient;
    }

}
