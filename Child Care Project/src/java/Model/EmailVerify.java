/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author duchi
 */
public class EmailVerify {

    private int id;
    private String email;
    private Timestamp begin;
    private Timestamp end;
    private int type;
    private int status;

    public EmailVerify() {
    }

    public EmailVerify(int id, String email, Timestamp begin, Timestamp end, int type, int status) {
        this.id = id;
        this.email = email;
        this.begin = begin;
        this.end = end;
        this.type = type;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getBegin() {
        return begin;
    }

    public void setBegin(Timestamp begin) {
        this.begin = begin;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmailVerify{" + "id=" + id + ", email=" + email + ", begin=" + begin + ", end=" + end + ", type=" + type + ", status=" + status + '}';
    }

}
