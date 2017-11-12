
import java.io.*;
import org.w3c.dom.*;  
import javax.xml.parsers.*;  
//import dom.*;



public class ModificateurMandat{


  public static void main(String[] args) throws Exception {    
	  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
	  dbf.setIgnoringElementContentWhitespace(true); 
	  DocumentBuilder db = dbf.newDocumentBuilder();
	  Document document = db.parse(new File("E:/mandats.xml")); 
	  // ajout d'un attribut date="20/12/2005" au mandat 101 
	  // ajout d'une ligne au mandat 102, comportant un libelle "pile", et un montant "3" 
	  NodeList l = document.getElementsByTagName("Mandat");  
	  Element rac = document.getDocumentElement();
	  for (int i=0;i<l.getLength();i++) 
	    { Element e = (Element) l.item(i); 
	      if (e.getAttributeNode("numero").getValue().equals("101")) 
	          e.setAttribute("date","20/12/2005");  
	      if (e.getAttributeNode("numero").getValue().equals("102")) 
	         { Element aj = document.createElement("ligne"); 
	           Text  t = document.createTextNode("pile"); 
	           e.appendChild(aj); aj.appendChild(t); 
	           aj = document.createElement("montant"); 
	           t = document.createTextNode("3");  
	           e.appendChild(aj);aj.appendChild(t);  }       
	     /* if (e.getAttributeNode("numero").getValue().equals("102"))  
	        { rac.removeChild(e);} */
	    } 
	    // outils fourni 
	    XMLTools.ecrireXML(document,"E:/mandatModifie.xml",null);
  }
  
}