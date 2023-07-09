package Tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.crypto.Data;

@Entity
@Table(name="Articles_Approvisionnement")
public class Articles_Approvisionnement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int codeArt;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Column(name="qteCommandé")
	public int qteCommandé;
	@Column(name="datePrevueLivraison")
	public Date datePrevueLivraison;
	@Column(name="productId")
	public int productId;
	public Articles_Approvisionnement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Articles_Approvisionnement(int codeArt, int qteCommandé, Date datePrevueLivraison) {
		super();
		this.codeArt = codeArt;
		this.qteCommandé = qteCommandé;
		this.datePrevueLivraison = datePrevueLivraison;
	}
	
	public Articles_Approvisionnement(int codeArt, int qteCommandé, Date datePrevueLivraison , int productId) {
		super();
		this.codeArt = codeArt;
		this.qteCommandé = qteCommandé;
		this.datePrevueLivraison = datePrevueLivraison;
		this.productId = productId;
	}
	
	public int getCodeArt() {
		return codeArt;
	}
	public void setCodeArt(int codeArt) {
		this.codeArt = codeArt;
	}
	public int getQteCommandé() {
		return qteCommandé;
	}
	public void setQteCommandé(int qteCommandé) {
		this.qteCommandé = qteCommandé;
	}
	public Date getDatePrevueLivraison() {
		return datePrevueLivraison;
	}
	public void setDatePrevueLivraison(Date datePrevueLivraison) {
		this.datePrevueLivraison = datePrevueLivraison;
	}
	
	
}
