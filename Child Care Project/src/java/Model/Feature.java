/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author GL
 */
public class Feature {
    private int feature_id;
    private String name;
    private String url;
    private String note;

    public int getFeature_id() {
        return feature_id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getNote() {
        return note;
    }

    public void setFeature_id(int feature_id) {
        this.feature_id = feature_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
