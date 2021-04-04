/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeprocessing;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ELCOT
 */
public class Student {
    private final SimpleIntegerProperty tid,tquiz,ta1,ta2,texam;
    private final SimpleStringProperty tname,tgrade;
    private final SimpleDoubleProperty tmark;
    public Student(int tid, int tquiz, int ta1, int ta2, int texam, String tname, String tgrade, double tmark) {
        super();
        this.tid = new SimpleIntegerProperty(tid);
        this.tquiz = new SimpleIntegerProperty(tquiz);
        this.ta1 = new SimpleIntegerProperty(ta1);
        this.ta2 = new SimpleIntegerProperty(ta2);
        this.texam = new SimpleIntegerProperty(texam);
        this.tname = new SimpleStringProperty(tname);
        this.tgrade = new SimpleStringProperty(tgrade);
        this.tmark = new SimpleDoubleProperty(tmark);
    }
    public int getTid() {
        return tid.get();    
    }
    public int getTquiz() {
        return tquiz.get();
    }
    public int getTa1() {
        return ta1.get();
    }
    public int getTa2() {
        return ta2.get();
    }
    public int getTexam() {
        return texam.get();
    }
    public String getTname() {
        return tname.get();
    }
    public String getTgrade() {
        return tgrade.get();
    }
    public double getTmark() {
        return tmark.get();
    }
}
