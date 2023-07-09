package MaiTest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.ProduitDaolmp;


public class Main {

	
public static void main(String[] args) {
		
	 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	//UserService userService = context.getBean(UserService.class);
	 ProduitDaolmp pm=context.getBean(ProduitDaolmp.class);
	 
	 pm.getAll1().toString();
	
	}
}
