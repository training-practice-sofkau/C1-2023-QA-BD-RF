package com.sofkau.integration.database.models;

public class Veterinario {
    String id;
    String name;
    String tel;

    public Veterinario(String id, String name, String tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }

    public Veterinario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Veterinario{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
