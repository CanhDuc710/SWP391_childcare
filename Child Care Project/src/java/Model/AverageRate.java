/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author duchi
 */
public class AverageRate {

    private int serviceId;
    private double averageRate;

    public AverageRate() {
    }

    public AverageRate(int serviceId, double averageRate) {
        this.serviceId = serviceId;
        this.averageRate = averageRate;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }

}
