package com.example.clicker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.math.BigInteger;
import java.util.ArrayList;

@Entity
public class SaveFile {
    @Id
    private int id;
    @OneToOne
    @JoinColumn(name = "svfile_usrid")
    private int userId;
    private BigInteger currency;
    private BigInteger totalCPS;
    private ArrayList<Producer> producers;
    private ArrayList<Upgrade> upgrades;

    public SaveFile() {

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
}
