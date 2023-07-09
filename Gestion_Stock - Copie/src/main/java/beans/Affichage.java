package beans;

import DAO.ProduitDaolmp;
import Tables.Articles_Stock;
//import Tables.Categories;
import Tables.Articles_Approvisionnement;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import DAO.IProduitDao;
import DAO.ProduitDaolmp;
import Tables.Articles_Stock;
import Tables.Articles_Approvisionnement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.io.FileInputStream;
import java.io.OutputStream;

import java.io.*;

public class Affichage {

	// les varaible pdf
	private String generatedPDFPath;
	private String generatedPDFFileName = "stock.pdf";
	// geterse et seterse de object generatedPDFPath et  generatedPDFFileName
	public String getGeneratedPDFPath() {
		return generatedPDFPath;
	}

	public void setGeneratedPDFPath(String generatedPDFPath) {
		this.generatedPDFPath = generatedPDFPath;
	}

	public String getGeneratedPDFFileName() {
		return generatedPDFFileName;
	}
	// object context
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	// object pm in class ProduitDaolmp
	ProduitDaolmp pm = context.getBean(ProduitDaolmp.class);
	// object p in class Articles_Stock
	public Articles_Stock p = context.getBean(Articles_Stock.class);

	// geterse et seterse 
	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	public ProduitDaolmp getPm() {
		return pm;
	}

	public void setPm(ProduitDaolmp pm) {
		this.pm = pm;
	}

	public String getTestCategorie() {
		return testCategorie;
	}

	public void setTestCategorie(String testCategorie) {
		this.testCategorie = testCategorie;
	}

	public void setGeneratedPDFFileName(String generatedPDFFileName) {
		this.generatedPDFFileName = generatedPDFFileName;
	}

	public String testCategorie;
	// object p1
	Articles_Approvisionnement p1 = context.getBean(Articles_Approvisionnement.class);
	// geterse et seterse de object p
	public Articles_Stock getP() {
		return p;
	}

	public void setP(Articles_Stock p) {
		this.p = p;
	}
	// function add article stock
	public String add() {

		this.pm.save1(this.p);
		this.p = context.getBean(Articles_Stock.class);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		try {
			externalContext.redirect("index.xhtml?PagePosition=commande");
		} catch (IOException e) {
			e.printStackTrace(); // Handle the exception appropriately
		}
		return null;
	}

	// geterse et seterse de object p1
	public Articles_Approvisionnement getP1() {
		return p1;
	}

	public void setP1(Articles_Approvisionnement p1) {
		this.p1 = p1;
	}

	// function add Articles_Approvisionnement;
	public String add1() {
		Articles_Stock product = this.pm.getArticleStockById(this.p1.productId);
		product.qteArt += this.p1.qteCommandé;
		this.pm.update(product);
		this.pm.save(this.p1);
		this.p1 = new Articles_Approvisionnement();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		try {
			externalContext.redirect("index.xhtml?PagePosition=admi");
		} catch (IOException e) {
			e.printStackTrace(); // Handle the exception appropriately
		}
		return null;
	}
	// function get article from base donne ;
	public List<Articles_Stock> getAll1() {

		return pm.getAll1();
	}
	// function get Articles_Approvisionnement from base donne ;
	public List<Articles_Approvisionnement> getAll2() {

		return pm.getAll2();
	}



	// delete produit approvisionnement;
	public void delet(Articles_Approvisionnement p1) {

		this.pm.delete(p1);

		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		try {
			externalContext.redirect("index.xhtml?PagePosition=admi");
		} catch (IOException e) {
			e.printStackTrace(); // Handle the exception appropriately
		}

	}

	// delete produit Article stock;
	public void delete(Articles_Stock p) {

		this.pm.delete(p);

		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		try {
			externalContext.redirect("index.xhtml?PagePosition=commande");
		} catch (IOException e) {
			e.printStackTrace(); // Handle the exception appropriately
		}

		// Or return the original outcome string if needed
	}

	// edit reduction to page  edit article stock
	public String edit(Articles_Stock p) {

		this.p = p;
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		try {
			externalContext.redirect("Edite.xhtml");
		} catch (IOException e) {
			e.printStackTrace(); // Handle the exception appropriately
		}
		return "Edite";
	}
	
	// function edit article stock
	public String edit() {

		this.pm.update(this.p);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		try {
			externalContext.redirect("index.xhtml?PagePosition=commande");
		} catch (IOException e) {
			e.printStackTrace(); // Handle the exception appropriately
		}
		return null;

	}

	// function reduction to editcommand
	public String editCommand(Articles_Approvisionnement p1) {

		this.p1 = p1;
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		try {
			externalContext.redirect("EditCommand.xhtml");
		} catch (IOException e) {
			e.printStackTrace(); // Handle the exception appropriately
		}
		return "EditCommand";
	}

	// function edit commande
	
	public String editCommand() {

		this.pm.update1(this.p1);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		try {
			externalContext.redirect("index.xhtml?PagePosition=commande");
		} catch (IOException e) {
			e.printStackTrace(); // Handle the exception appropriately
		}
		return null;

	}
	
	//function get id the name product

	public String getProductNamebyId(int id) {
		Articles_Stock product = this.pm.getArticleStockById(id);
		return product.nomArt;
	}

	// public List<Categories> getAllCategories(){

	// return pm.getCategories();
	// }

	private Date datePrevueLivraison;

	@PostConstruct
	public void init() {
		datePrevueLivraison = new Date();
	}

	public Date getDatePrevueLivraison() {
		return datePrevueLivraison;
	}

	public void setDatePrevueLivraison(Date datePrevueLivraison) {
		this.datePrevueLivraison = datePrevueLivraison;
	}

	
	
	// function de logout from page index to login
	public void logout() {
		// Invalidate session
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		// externalContext.invalidateSession();

		// Redirect to login page
		try {
			externalContext.redirect("accueil.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//public String test() {
		//System.out.print("hello ");
		//return "hello";
	//}
	
	
	//function de generation de PDF
	public void generatePDF() throws DocumentException {
		Document document = new Document();

		String filePath = "page12.pdf";

		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));

			document.open();

			// Ajouter le logo en haut de la page
			// Image logo = Image.getInstance("logo.png");
			// logo.scaleToFit(100, 100); // Ajuster la taille du logo si nécessaire
			// document.add(logo);

			// Ajouter le titre du document
			Paragraph title = new Paragraph("LES PRODUCT", new Font(Font.FontFamily.HELVETICA, 18));
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);

			document.add(Chunk.NEWLINE); // Ajouter un espacement entre le titre et le tableau

			List<Articles_Stock> products = getAll1();

			// Créer le tableau pour les données

			PdfPTable table = new PdfPTable(4); // 4 colonnes pour les différentes informations

			// Définir les couleurs d'en-tête pour chaque colonne
			PdfPCell headerCell1 = new PdfPCell(new Phrase("Nom"));
			headerCell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
			PdfPCell headerCell2 = new PdfPCell(new Phrase("Prix"));
			headerCell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
			PdfPCell headerCell3 = new PdfPCell(new Phrase("Description"));
			headerCell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
			PdfPCell headerCell4 = new PdfPCell(new Phrase("Quantité"));
			headerCell4.setBackgroundColor(BaseColor.LIGHT_GRAY);

			// Ajouter les en-têtes de colonnes
			table.addCell(headerCell1);
			table.addCell(headerCell2);
			table.addCell(headerCell3);
			table.addCell(headerCell4);

			// Ajouter les données des produits dans le tableau
			for (Articles_Stock product : products) {
				table.addCell(product.getNomArt());
				table.addCell(String.valueOf(product.getPrixArt()));
				table.addCell(product.getDescArt());
				table.addCell(String.valueOf(product.getQteArt()));
			}

			// Ajouter le tableau au document
			document.add(table);

			document.close();

			System.out.println("Le fichier PDF a été généré avec succès.");

			// Envoyer le fichier PDF au navigateur pour le téléchargement

			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
			response.reset();
			response.setContentType("application/pdf");
			String encode = URLEncoder.encode(filePath, "UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=\"" + encode + "\"");

			try {
				FileInputStream fileInputStream = new FileInputStream(filePath);
				OutputStream responseOutputStream = response.getOutputStream();
				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = fileInputStream.read(buffer)) != -1) {
					responseOutputStream.write(buffer, 0, bytesRead);
				}
				FacesContext.getCurrentInstance().responseComplete();
				fileInputStream.close();
				responseOutputStream.flush();
				responseOutputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
