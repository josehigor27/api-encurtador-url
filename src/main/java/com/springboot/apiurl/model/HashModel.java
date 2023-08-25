package com.springboot.apiurl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Deprecated
@Entity
@Table(name = "tbl_hash")
public class HashModel {
    @Id
    private String hash;
    private boolean isAvailable;

    @Override
    public String toString() {
        return "HashModel{" +
                "hash='" + hash + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
