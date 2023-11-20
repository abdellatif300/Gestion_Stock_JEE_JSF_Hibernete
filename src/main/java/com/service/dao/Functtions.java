package com.service.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;

import com.service.Entitys.*;

public interface Functtions {
	
	//Articles_Prix
	public List<Articles_Stock> getAllArticl();
	public Articles_Stock gitArticlById(int id);
	//Users 
	public void addUser(User u);
	public void deleteUser(int id);
	public void updateUser(User u,int id) ;
	public User getUserById(int id);


	public User getUserByName(String name);
	//command
	public void addCommande(Commandes c);
	public List<Object[]> getAllCommandesByInvoice(int invoice_id);
	public List<Commandes> listsCommandes();	
	public Commandes getCommande (int codeCmd);
	public void deleteCommande(int codeCmd);
	public void updateCommande(Commandes c,int id);
	public void insertInCart(Cart c);
	public List<Articles_Stock> afficherCart();
	public int deletFromCart(int id , String user);
	public int getNumberOfCart();
	public void deleteAllCart(String user);
	public int addInvoice(Invoice i);
	public Invoice getInvoiceById(int id);
	public  int getQuantiteByProduct(int id);
	public int decreaseQuantite(int codeArt, int newQt);

}
