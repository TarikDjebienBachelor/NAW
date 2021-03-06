/**
 * @author rakotobe
 *
 */

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

// import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;




public class Catalogue {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub


		Element art1, art2, art3, art4, prix1 , prix2 , prix3 , prix4 ;
		
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document d = db.newDocument();
		
		
		Element racine = d.createElement("catalogue");
		(art1 = d.createElement("article")).setAttribute("nom","peigne");
		(art2 = d.createElement("article")).setAttribute("nom","brosse");
		(art3 = d.createElement("article")).setAttribute("nom","shampoing");		
		(art4 = d.createElement("article")).setAttribute("nom","laque");		
		
		//creation des elements 
		(prix1 = d.createElement("prix")).setAttribute("unite","euro");
		(prix2 = d.createElement("prix")).setAttribute("unite","dollar");		
		prix3 = d.createElement("prix");	
		(prix4 = d.createElement("prix")).setAttribute("unite","yen");	
		
		d.createTextNode("10");
		d.createTextNode("5");
		d.createTextNode("4");
		d.createTextNode("9");
				
		
		//on remplit leurs contenus 
		prix1.appendChild(d.createTextNode("10"));
		prix2.appendChild(d.createTextNode("5"));
		prix3.appendChild(d.createTextNode("4"));
		prix4.appendChild(d.createTextNode("9"));
		
		
		
		//on cree les relations d'arborescence
		//pour la racine
		d.appendChild(racine) ; 
		//les articles
		racine.appendChild(art1);
		racine.appendChild(art2);
		racine.appendChild(art3);
		racine.appendChild(art4);
		//et les prix 
		art1.appendChild(prix1);
		art2.appendChild(prix2);
		art3.appendChild(prix3);
		art4.appendChild(prix4);	



		//affichage du xml
		XMLTools.ecrireXML(d, "E:/moncatalogue.xml",null);
		

	}

}
