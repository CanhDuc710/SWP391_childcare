/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author GL
 */
public class Role {
    private String name;
    private ArrayList<Feature> features;

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setFeatures(ArrayList<Feature> features) {
        this.features = features;
    }
    
}
