package com.example.quanlycongan;

public class PoliceRVModel {
    String name;
    private int image;
    private String capbac;
    private String noicongtac;
    private String quocgia;
    int pos;


    public PoliceRVModel(String name, int image, String capbac, String noicongtac, String quocgia, int pos) {
        this.name = name;
        this.image = image;
        this.capbac = capbac;
        this.noicongtac = noicongtac;
        this.quocgia = quocgia;
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCapbac() {
        return capbac;
    }

    public void setCapbac(String capbac) {
        this.capbac = capbac;
    }

    public String getNoicongtac() {
        return noicongtac;
    }

    public void setNoicongtac(String noicongtac) {
        this.noicongtac = noicongtac;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
