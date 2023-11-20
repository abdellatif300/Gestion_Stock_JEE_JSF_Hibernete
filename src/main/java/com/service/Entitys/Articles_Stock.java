package com.service.Entitys;

import javax.persistence.*;

@Entity
@Table(name = "articles_stock")
public class Articles_Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codeArt;
    private int qteArt;
    private String nomArt;
    private String descArt;
    private float prixArt;
    private String category;
    private String image;
    private String imgPng;

    public String getImgPng() {
        return imgPng;
    }

    public void setImgPng(String imgPng) {
        this.imgPng = imgPng;
    }

    public Articles_Stock() {
        super();
    }

    public Articles_Stock(int codeArt, int qteArt, String nomArt, String descArt, int prixArt) {
        this.codeArt = codeArt;
        this.qteArt = qteArt;
        this.nomArt = nomArt;
        this.descArt = descArt;
        this.prixArt = prixArt;
    }

    public Articles_Stock(int codeArt, int qteArt, String nomArt, String descArt, int prixArt, String category, String image) {
        this.codeArt = codeArt;
        this.qteArt = qteArt;
        this.nomArt = nomArt;
        this.descArt = descArt;
        this.prixArt = prixArt;
        this.category = category;
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public int getCodeArt() {
        return codeArt;
    }

    public int getQteArt() {
        return qteArt;
    }

    public String getNomArt() {
        return nomArt;
    }

    public String getDescArt() {
        return descArt;
    }

    public float getPrixArt() {
        return prixArt;
    }

    public void setCodeArt(int codeArt) {
        this.codeArt = codeArt;
    }

    public void setQteArt(int qteArt) {
        this.qteArt = qteArt;
    }

    @Override
    public String toString() {
        return "Articles_Stock{" +
                "codeArt=" + codeArt +
                ", qteArt=" + qteArt +
                ", nomArt='" + nomArt + '\'' +
                ", descArt='" + descArt + '\'' +
                ", prixArt=" + prixArt +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public void setNomArt(String nomArt) {
        this.nomArt = nomArt;
    }

    public void setDescArt(String descArt) {
        this.descArt = descArt;
    }

    public void setPrixArt(float prixArt) {
        this.prixArt = prixArt;
    }

}
