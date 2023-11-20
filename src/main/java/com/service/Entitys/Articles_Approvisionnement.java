package com.service.Entitys;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Articles_Approvisionnement")
public class Articles_Approvisionnement {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private int codeArt;
    private int qteCommande;
    private LocalDate datePrevueLivraison;

    public Articles_Approvisionnement() {
        super();
    }

    public Articles_Approvisionnement(int codeArt, int qteCommande, LocalDate datePrevueLivraison) {
        this.codeArt = codeArt;
        this.qteCommande = qteCommande;
        this.datePrevueLivraison = datePrevueLivraison;
    }

    public int getCodeArt() {
        return codeArt;
    }

    public void setCodeArt(int codeArt) {
        this.codeArt = codeArt;
    }

    public int getQteCommande() {
        return qteCommande;
    }

    public void setQteCommande(int qteCommande) {
        this.qteCommande = qteCommande;
    }

    public LocalDate getDatePrevueLivraison() {
        return datePrevueLivraison;
    }

    public void setDatePrevueLivraison(LocalDate datePrevueLivraison) {
        this.datePrevueLivraison = datePrevueLivraison;
    }

    @Override
    public String toString() {
        return "Articles_Approvisionnement{" +
                "codeArt=" + codeArt +
                ", qteCommande=" + qteCommande +
                ", datePrevueLivraison=" + datePrevueLivraison +
                '}';
    }
}
