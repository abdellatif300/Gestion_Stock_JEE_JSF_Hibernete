package DAO;

import java.util.List;

import 	Tables.Articles_Approvisionnement;
import Tables.Articles_Stock;


public interface IProduitDao {
	// get les Articles_Approvisionnement
	public List<Articles_Approvisionnement> getAll2();
	// get les article stock
	public List<Articles_Stock> getAll1();
	// get id les Articles_Approvisionnement
	public Articles_Approvisionnement getById(int id);
	// save  les Articles_Approvisionnement
	public void save(Articles_Approvisionnement produit);
	// save1  les Articles_Stock
	public void save1(Articles_Stock produit);
	// get id  les Articles_Stock
	public Articles_Stock getArticleStockById(int id);
	// delet Articles_Stock
	public void delete(Articles_Stock produit);
	// delete Articles_Approvisionnement
	public void delete(Articles_Approvisionnement produit);
	// update Articles_Stock
	public void update(Articles_Stock produit);
 
	
	
	
	
	// update Articles_Approvisionnement
	public void update1(Articles_Approvisionnement produit);
}
