package com.service.Entitys;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="commandes")
public class Commandes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codeCmd;
	private String client;
	private int codeArt;
	private int qteCmd;
	private int invoice_id;
	@CreationTimestamp
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDate dateCmd;
	
	
	public Commandes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commandes(int codeCmd, String client, int codeArt, int qteCmd, int invoice_id, LocalDate dateCmd) {
		super();
		this.codeCmd = codeCmd;
		this.client = client;
		this.codeArt = codeArt;
		this.qteCmd = qteCmd;
		this.invoice_id = invoice_id;
		this.dateCmd = dateCmd;
	}
	public int getCodeCmd() {
		return codeCmd;
	}
	public void setCodeCmd(int codeCmd) {
		this.codeCmd = codeCmd;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public int getCodeArt() {
		return codeArt;
	}
	public void setCodeArt(int codeArt) {
		this.codeArt = codeArt;
	}
	public int getQteCmd() {
		return qteCmd;
	}
	public void setQteCmd(int qteCmd) {
		this.qteCmd = qteCmd;
	}
	public LocalDate getDateCmd() {
		return dateCmd;
	}
	public void setDateCmd(LocalDate dateCmd) {
		this.dateCmd = dateCmd;
	}

	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	@Override
	public String toString() {
		return "Commandes{" +
				"codeCmd=" + codeCmd +
				", client='" + client + '\'' +
				", codeArt=" + codeArt +
				", qteCmd=" + qteCmd +
				", invoice_id=" + invoice_id +
				", dateCmd=" + dateCmd +
				'}';
	}
}