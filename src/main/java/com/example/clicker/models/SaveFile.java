package com.example.clicker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jdk.jfr.DataAmount;

import java.io.*;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Savefile {
    @Id
    private int id;
    @OneToOne
    @JoinColumn(name = "svfile_usrid")
    private int userId;
    private BigInteger currency;
    private BigInteger totalCPS;
    private ArrayList<Producer> producers;
    private ArrayList<Upgrade> upgrades;

    public Savefile() {

    }

    public Savefile(int userId) {
        this.userId = userId;
        this.currency = BigInteger.valueOf(0);
        this.totalCPS = BigInteger.valueOf(0);
        this.producers = new ArrayList<Producer>();
        this.upgrades = new ArrayList<Upgrade>();
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCurrency(BigInteger currency) {
        this.currency = currency;
    }

    public void setTotalCPS(BigInteger totalCPS) {
        this.totalCPS = totalCPS;
    }

    public void setProducers(ArrayList<Producer> producers) {
        this.producers = producers;
    }

    public void setUpgrades(ArrayList<Upgrade> upgrades) {
        this.upgrades = upgrades;
    }

    //getters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public BigInteger getCurrency() {
        return currency;
    }

    public BigInteger getTotalCPS() {
        return totalCPS;
    }

    public ArrayList<Producer> getProducers() {
        return producers;
    }

    public ArrayList<Upgrade> getUpgrades() {
        return upgrades;
    }

    //methods

    public Savefile createSavefile(int userId) {
        Savefile saveFile = new Savefile(userId);
        return saveFile;
    }

    public void saveSavefile(Savefile saveFile) {
        this.setCurrency(saveFile.getCurrency());
        this.setTotalCPS(saveFile.getTotalCPS());
        this.setProducers(saveFile.getProducers());
        this.setUpgrades(saveFile.getUpgrades());

    }

    public void loadSavefile(Savefile saveFile) {
        this.setCurrency(saveFile.getCurrency());
        this.setTotalCPS(saveFile.getTotalCPS());
        this.setProducers(saveFile.getProducers());
        this.setUpgrades(saveFile.getUpgrades());

    }

    public void restartSavefile(Savefile saveFile) {
        this.setCurrency(BigInteger.valueOf(0));
        this.setTotalCPS(BigInteger.valueOf(0));
        this.setProducers(new ArrayList<Producer>());
        this.setUpgrades(new ArrayList<Upgrade>());

    }

    public File exportSavefile(Savefile savefile) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        date.getTime();


        File save_file = new File("savefile_" + formatter.format(date));


        FileWriter fwriter = new FileWriter(save_file);
        BufferedWriter bufferedWriter = new BufferedWriter(fwriter);

        bufferedWriter.write(savefile.getCurrency().toString());
        bufferedWriter.newLine();
        bufferedWriter.write(savefile.getTotalCPS().toString());

        //falta parsear los JSON para escribir en el txt los arrays

        bufferedWriter.close();
        fwriter.close();
        
        // falta return de File

    }


}
