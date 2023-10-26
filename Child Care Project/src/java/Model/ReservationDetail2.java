/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author duchi
 */
public class ReservationDetail2 {

    private int reservationDetailId;
    private int reservationID;
    private int serviceId;
    private double price;

    public ReservationDetail2() {
    }

    public ReservationDetail2(int reservationDetailId, int reservationID, int serviceId, double price) {
        this.reservationDetailId = reservationDetailId;
        this.reservationID = reservationID;
        this.serviceId = serviceId;
        this.price = price;
    }

    public int getReservationDetailId() {
        return reservationDetailId;
    }

    public void setReservationDetailId(int reservationDetailId) {
        this.reservationDetailId = reservationDetailId;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
