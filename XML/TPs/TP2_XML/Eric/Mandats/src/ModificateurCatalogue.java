import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;


public class ModificateurCatalogue {

	/**
	 * @param args
	 */
	  public static void main(String[] args) throws Exception {  
		  
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
		  dbf.setIgnoringElementContentWhitespace(true); 
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  Document document = db.parse(new File("E:/moncatalogue.xml")); 
		  
		  Element rac = document.getDocumentElement();
		  
		  //mettre le cout du shampoing en euros 
		  NodeList art3 = document.getElementsByTagName("article"); 
		  for (int i=0;i<art3.getLength();i++){
			  Element e = (Element) art3.item(i); 
			  if (e.getAttributeNode("nom").getValue().equals("shampoing")){
				  NodeList prices = e.getElementsByTagName("prix"); 
				  Element prix3 = (Element) prices.item(0);
				  prix3.setAttribute("unite", "euros");
			  }	  
		  }
		  
		  
		  //la laque disparait
		  NodeList art4 = document.getElementsByTagName("article");
		  for (int i=0;i<art4.getLength();i++){
			  Element e = (Element) art4.item(i); 
			  if (e.getAttributeNode("nom").getValue().equals("laque")){
				  e.getParentNode().removeChild(e); 
				  
			  }	  
		  }
		  
		  
		  //ajouter entre peigne et brosse la peruque
		  NodeList lesArticles = document.getElementsByTagName("article");
		  for (int i=0;i<lesArticles.getLength();i++){
			  Element e = (Element) lesArticles.item(i); 
			  if (e.getAttributeNode("nom").getValue().equals("laque"))
				{
				  Element art1 = document.createElement("article");
				  art1.setAttribute("nom","perruque");
				  Element prix1 = document.createElement("prix");
				  prix1.setAttribute("unite","euro");
				 prix1.appendChild(document.createTextNode("10"));
				 art1.appendChild(prix1);
				 rac.insertBefore(art1, e);
				}
			  }
					  
					  
					  /*&& ((Element) e.getNextSibling()).getAttributeNode("nom").getValue().equals("perruque")){
				  e.insertBefore( (document.createElement("article")).setAttribute("nom","perruque") , e.getParentNode() );
				  //insertBefore(Node nouvel_objet,Node objet_fils)

			  }	  
		  }*/
		 
		  
			  
			  
		  
//		  // ajout d'une ligne au mandat 102, comportant un libelle "pile", et un montant "3" 
//		  NodeList l = document.getElementsByTagName("Mandat");  
//		  Element rac = document.getDocumentElement();
//		  for (int i=0;i<l.getLength();i++) 
//		    { Element e = (Element) l.item(i); 
//		      if (e.getAttributeNode("numero").getValue().equals("101")) 
//		          e.setAttribute("date","20/12/2005");  
		  
//		      if (e.getAttributeNode("numero").getValue().equals("102")) 
//		         { Element aj = document.createElement("ligne"); 
//		           Text  t = document.createTextNode("pile"); 
//		           e.appendChild(aj); aj.appendChild(t); 
//		           aj = document.createElement("montant"); 
//		           t = document.createTextNode("3");  
//		           e.appendChild(aj);aj.appendChild(t);  }  
		  
//		     /* if (e.getAttributeNode("numero").getValue().equals("102"))  
//		        { rac.removeChild(e);} */
//		    } 

		  
		  
		  
		    XMLTools.ecrireXML(document,"E:/moncatalogueModifie.xml",null);
	  }
	  
}

	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

