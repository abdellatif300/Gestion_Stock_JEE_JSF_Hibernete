package com.service.dao;

import java.util.List;
import java.util.Objects;

import com.service.Entitys.*;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;


public class FunctionImpl implements Functtions {

	private SessionFactory sessionFactory;

	public FunctionImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<Articles_Stock> getAllArticl() {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		String hql = "FROM Articles_Stock ";
		Query query = session.createQuery(hql);
		List<Articles_Stock> resultList = query.list();
		t.commit();
		session.close();
		return resultList;
	}

	@Override
	public Articles_Stock gitArticlById(int id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Articles_Stock art =session.get(Articles_Stock.class,id);
		t.commit();
		session.close();
		return art;
	}

	@Override
	@Transactional
	public void addUser(User u) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.save(u);
		t.commit();
		session.close();

	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
     	User user=session.get(User.class, id);
		session.delete(user);
		t.commit();
		session.close();
	}

	@Override
	@Transactional
	public void updateUser(User u,int id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		User useUp=session.get(User.class, id);
		useUp.setLogin(u.getLogin());
		useUp.setPass(u.getPass());
		session.save(useUp);
		t.commit();
		session.close();
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		User user= session.get(User.class, id);
		t.commit();
		session.close();
		return user;
	}
	@Override
	@Transactional
	public User getUserByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		String hql = "FROM User u WHERE u.username = :username";
		Query<User> query = session.createQuery(hql, User.class);
		query.setParameter("username", name);
		List<User> users = query.list();
		t.commit();
		session.close();
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	@Transactional
	public void addCommande(Commandes c) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.save(c);
		t.commit();
		session.close();
	}

	@Override
	public List<Object[]> getAllCommandesByInvoice(int invoice_id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		List<Object[]> results = null;
		try {
			String hql = "SELECT c, p FROM Commandes c JOIN Articles_Stock p ON p.codeArt = c.codeArt WHERE  c.invoice_id = :invoiceId";
			Query query = session.createQuery(hql);
			query.setParameter("invoiceId", invoice_id);
			results = query.list();
			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return results;
	}

	@Override
	@Transactional
	public List<Commandes> listsCommandes() {
		// TODO Auto-generated method stub
		/*Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		List<Commandes> list= session. (Commandes.class);
		t.commit();*/
		return null;
	}

	@Override
	@Transactional
	public Commandes getCommande(int codeCmd) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Commandes c =session.get(Commandes.class,codeCmd);
		t.commit();
		session.close();
		return c;
	}

	@Override
	@Transactional
	public void deleteCommande(int codeCmd) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.delete(getCommande(codeCmd));
		t.commit();
		session.close();
	}

	@Override
	@Transactional
	public void updateCommande(Commandes c,int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Commandes cc=session.get(Commandes.class, id);
		cc.setClient(c.getClient());
		cc.setCodeArt(c.getCodeArt());
		cc.setDateCmd(c.getDateCmd());
		cc.setQteCmd(c.getQteCmd());
		session.save(cc);
		t.commit();
		session.close();
	}

	@Override
	@Transactional
	public void insertInCart(Cart c) {
// TODO Auto-generated method stub
		// Step 1: Retrieve existing element based on conditions
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		String hql = "FROM Cart WHERE codeArt = :value1 AND username = :value2";
		Query query = session.createQuery(hql);
		query.setParameter("value1", c.getCodeArt());
		query.setParameter("value2", c.getUsername());
		Cart existingElement = (Cart) query.uniqueResult();

  // Step 2: Check if element doesn't exist
		if (existingElement == null) {
			session.save(c);
		}
		t.commit();
		session.close();
	}

	@Override
	@Transactional
	public List<Articles_Stock> afficherCart() {
     try {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		HttpSession localSession = ServletActionContext.getRequest().getSession();
		String username = (String) localSession.getAttribute("loggedInUser");

		String hql = "FROM Articles_Stock a WHERE a.codeArt IN (SELECT c.codeArt FROM Cart c WHERE c.username= :username)";
		Query<Articles_Stock> query = session.createQuery(hql, Articles_Stock.class);
		query.setParameter("username", username);

		List<Articles_Stock> articles = query.list();

		transaction.commit();
         session.close();
		return articles;
	} catch (Exception e) {
		e.printStackTrace();
		return null; // Handle the error appropriately
	}
	}

	@Override
	@Transactional
	public int deletFromCart(int id , String user) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		String hql = "DELETE FROM Cart WHERE codeArt = :value1 AND username = :value2";
		Query query = session.createQuery(hql);
		query.setParameter("value1", id);
		query.setParameter("value2", user);
		int rowsAffected = query.executeUpdate();
		t.commit();
		session.close();
		return rowsAffected;
	}

	@Override
	public int getNumberOfCart() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		HttpSession ss = ServletActionContext.getRequest().getSession();
		String user=(String) ss.getAttribute("loggedInUser");
		String sql = "SELECT COUNT(*) FROM Cart WHERE username = :username";
		Query<Long> query = session.createQuery(sql, Long.class);
		query.setParameter("username", user);
		Long count = query.uniqueResult();
		transaction.commit();
		session.close();

		return count != null ? count.intValue() : 0;
	}

	@Override
	@Transactional
	public void deleteAllCart(String user) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		String hql = "DELETE FROM Cart WHERE username = :value2";
		Query query = session.createQuery(hql);
		query.setParameter("value2", user);
		query.executeUpdate();
		t.commit();
		session.close();
	}

	@Override
	@Transactional
	public int addInvoice(Invoice i) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		int id = (int) session.save(i);
		t.commit();
		session.close();
		return id;
	}

	@Override
	@Transactional
	public Invoice getInvoiceById(int id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Invoice c =session.get(Invoice.class,id);
		t.commit();
		session.close();
		return c;

	}

	@Override
	@Transactional
	public int getQuantiteByProduct(int id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		String hql = "SELECT qteArt FROM Articles_Stock WHERE codeArt = :value";
		Query<Integer> query = session.createQuery(hql, Integer.class);
		query.setParameter("value", id);
		int q = query.uniqueResult();
		t.commit();
		session.close();
		return q;
	}

	@Override
	@Transactional
	public int decreaseQuantite(int codeArt,int newQt) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		String sql = "UPDATE Articles_Stock SET qteArt = :newValue WHERE codeArt = :entityId";
		Query query = session.createSQLQuery(sql);
		query.setParameter("newValue", newQt);
		query.setParameter("entityId", codeArt);
		int updatedRowCount = query.executeUpdate();
		t.commit();
		session.close();
		return updatedRowCount;
	}


}
