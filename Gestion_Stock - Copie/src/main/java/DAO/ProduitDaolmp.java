package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session ;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import Tables.Articles_Approvisionnement;
import Tables.Articles_Stock;


//import beans.ProductInfo;

public class ProduitDaolmp implements IProduitDao{
     private SessionFactory sessionFactory;
    //sesion 
	public ProduitDaolmp(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
    //sesion
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	// get les Articles_Approvisionnement
	public List<Articles_Approvisionnement> getAll2() {
		
		 Session session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
		 List<Articles_Approvisionnement> users  = session.createQuery("from Articles_Approvisionnement").getResultList();
		 
		 transaction.commit();
		 session.close();
		 return users;
		 
	}
	// get les Articles_Stock
	@Override
	public List<Articles_Stock> getAll1() {
		 Session session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
		 //Add Categorie Joint ....
		 String Query = "from Articles_Stock";
		 List<Articles_Stock> users  = session.createQuery("from Articles_Stock").getResultList();
		 
		 transaction.commit();
		 session.close();
		 return users;
		 
	}
	//getById Articles_Approvisionnement
	@Override
	public Articles_Approvisionnement getById(int id) {
		 Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Articles_Approvisionnement produit  = session.get(Articles_Approvisionnement.class,id);
		 
		 transaction.commit();
		 session.close();
		 return produit;
	}
  //save Articles_Approvisionnement
	public void save(Articles_Approvisionnement produit) {
		
		 Session session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
		 session.save(produit);
		 
		 transaction.commit();
		 session.close();
		
	}
	
	//public List<ProductInfo> getProductsInfo() {
		
		// Session session = sessionFactory.getCurrentSession();
	    // Transaction transaction = session.beginTransaction();
		
		// List<ProductInfo> Result = new ArrayList<ProductInfo>();
		// List<Articles_Stock> Products = getAll1();
//		 for (Articles_Stock prodVar : Products) {
//			 Categories categorie = new Categories();
//			 if(prodVar.categorie != 0 )
//				 categorie = getCategorieById(prodVar.categorie);
//			 Result.add(new ProductInfo(prodVar , categorie));
//		 }
		 
		// transaction.commit();
		// session.close();
		 //return Result;
		 
	//}

	//delet Articles_Stock
	@Override
	public void delete(Articles_Stock produit) {
		 Session session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
		 session.delete(produit);
		 transaction.commit();
		 session.close();
		
	}
  //delet (Articles_Approvisionnemen
	@Override
	public void delete(Articles_Approvisionnement produit) {
		 Session session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
		 session.delete(produit);
		 transaction.commit();
		 session.close();
		
	}
	//update Articles_Stock
	@Override
	public void update(Articles_Stock produit) {
		 Session session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
		 session.update(produit);
		 transaction.commit();
		 session.close();
		
	}
	//update Articles_Approvisionnement
	@Override
	public void update1(Articles_Approvisionnement produit) {
		 Session session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
		 session.update(produit);
		 transaction.commit();
		 session.close();
		
	}


	// function save1  Articles_Stock
	@Override
	public void save1(Articles_Stock produit) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
		 session.save(produit);
		 
		 transaction.commit();
		 session.close();
		
	}
	//@Override
	//public Categories getCategorieById(int id) {
		// Session session = sessionFactory.openSession();
		//Transaction transaction = session.beginTransaction();
		//Categories categorie  = session.get(Categories.class,id);
		 
		// transaction.commit();
		// session.close();
		 //return categorie;
	//}

	
	
	
	// function getArticleStockById 
	@Override
	public Articles_Stock getArticleStockById(int id) {
		 Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Articles_Stock articles_stock  = session.get(Articles_Stock.class,id);
		 
		 transaction.commit();
		 session.close();
		 return articles_stock;
	}
	
	//@Override
	//public List<Categories> getCategories() {
		// Session session = sessionFactory.openSession();
		 //Transaction transaction = session.beginTransaction();
		// List<Categories> categories  = session.createQuery("from Categories").getResultList();
		 
		// transaction.commit();
		// session.close();
		// return categories;
	//}
}
