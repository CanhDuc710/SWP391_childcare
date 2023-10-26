/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;

/**
 * CREATE TABLE Feedback ( feedback_id INT IDENTITY(1,1) PRIMARY KEY, service_id
 * INT NULL, patient_id INT NULL, rate INT NULL, title NVARCHAR(255) NULL,
 * detail NVARCHAR(MAX) NULL, FOREIGN KEY (service_id) REFERENCES
 * Service(service_id), FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
 * );
 *
 * @author duchi
 */
public class Feedback {

    private int feedbackId;
    private int serviceId;
    private int patientId;
    private int rate;
    private String title;
    private String detail;
    private Timestamp update_date;

    public Feedback() {
    }

    public Feedback(int feedbackId, int serviceId, int patientId, int rate, String title, String detail, Timestamp update_date) {
        this.feedbackId = feedbackId;
        this.serviceId = serviceId;
        this.patientId = patientId;
        this.rate = rate;
        this.title = title;
        this.detail = detail;
        this.update_date = update_date;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }

}
