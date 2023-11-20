package com.service.Entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="articles_prix")
public class Articles_Prix {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codeArt;
	private String nomArt;
	private String descArt;
	private float prixArt;
	private String category;
	private String image;

	public Articles_Prix() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Articles_Prix(int codeArt, String nomArt, String descArt, float prixArt) {
		super();
		this.codeArt = codeArt;
		this.nomArt = nomArt;
		this.descArt = descArt;
		this.prixArt = prixArt;
	}
	public Articles_Prix(int codeArt, String nomArt, String descArt, float prixArt, String category, String image) {
		super();
		this.codeArt = codeArt;
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
	public void setCodeArt(int codeArt) {
		this.codeArt = codeArt;
	}
	public String getNomArt() {
		return nomArt;
	}
	public void setNomArt(String nomArt) {
		this.nomArt = nomArt;
	}
	public String getDescArt() {
		return descArt;
	}
	public void setDescArt(String descArt) {
		this.descArt = descArt;
	}
	public float getPrixArt() {
		return prixArt;
	}
	public void setPrixArt(float prixArt) {
		this.prixArt = prixArt;
	}

	@Override
	public String toString() {
		return "Articles_Prix{" +
				"codeArt=" + codeArt +
				", nomArt='" + nomArt + '\'' +
				", descArt='" + descArt + '\'' +
				", prixArt=" + prixArt +
				", category='" + category + '\'' +
				'}';
	}
}
