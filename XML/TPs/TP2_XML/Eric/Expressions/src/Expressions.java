/**
 * @author rakotobe
 *
 */

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;



 

public class Expressions {

	public static void main(String[] args) throws Exception {  
		  Element X1,X2,X3,Y,Z, plus,fois1,fois2,fois3 , R3 ;
		  
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
		  dbf.setIgnoringElementContentWhitespace(true); 
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  Document document = db.parse(new File("E:/NAW/TP2/expressionsXml.xml")); 
		  
		 // Element racine = document.getDocumentElement();
		  

			//les variables 
			(X1 = document.createElement("var")).setAttribute("nom","X");
			(X2 = document.createElement("var")).setAttribute("nom","X");
			(X3 = document.createElement("var")).setAttribute("nom","X");
			(Y = document.createElement("var")).setAttribute("nom","Y");
			(Z = document.createElement("var")).setAttribute("nom","Z");
			//les operateurs 
			(plus = document.createElement("op")).setAttribute("symbole","+");
			(fois1 = document.createElement("op")).setAttribute("symbole","*");
			(fois2 = document.createElement("op")).setAttribute("symbole","*");
			(fois3 = document.createElement("op")).setAttribute("symbole","*");
			//l'expression
			(R3 = document.createElement("exp")).setAttribute("nom","R3");


			
			//on cree les relations d'arborescence
			

			plus.appendChild(Y);
			plus.appendChild(Z);

			fois1.appendChild(plus);
			fois1.appendChild(X1);
			
			fois2.appendChild(fois1);
			fois2.appendChild(X2);
			
			fois3.appendChild(fois2);
			fois3.appendChild(X3);
			
			R3.appendChild(fois3);
			
			NodeList exps = document.getElementsByTagName("exps");
			exps.item(0).appendChild(R3);
			
		    XMLTools.ecrireXML(document,"E:/NAW/TP2/expressionsModifie.xml",null);
	  }
	  

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
