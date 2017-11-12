import java.io.File;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * @author rakotobe
 *
 */
public class AfficheFilmsComedies extends DefaultHandler{

	
	
	private String tagCourant = ""; 
	private String categorie = ""; 
	




	public AfficheFilmsComedies(){}
	
	
	
	public void startDocument(){ 
	System.out.println("********** Titres des films de com�die : *********** "); 
	} 

	
	public void endDocument(){ 
	System.out.println("**********Fin Titres des films de com�die **********");
	 }

	

	public void startElement (String nameSpace, String localName, String qName, Attributes attr){  
		if (qName.equalsIgnoreCase("categorie") && attr.getValue(0).equalsIgnoreCase("Com�die")){
			 this.tagCourant = qName; 
			 this.categorie = attr.getValue(0);
		}
	}

	
	 public void characters(char[] caracteres, int debut,int longueur) throws SAXException {
		 //System.out.println("Com�die" );
		 if ( this.tagCourant.equalsIgnoreCase("categorie")  && this.categorie.equalsIgnoreCase("Com�die")) {
				 String donnees = new String(caracteres, debut, longueur); 
				 System.out.println(donnees);
		 }
	 }

	
	 public  void endElement(String uri, String localName, String qName) {
			if ( (qName.equalsIgnoreCase("categorie")) && this.categorie.equalsIgnoreCase("Com�die") ){
				 this.tagCourant = ""; 
				 this.categorie = "";
			}
	 }


	
	
	public static void main(String[] args) {
		AfficheFilmsComedies myHandler = new AfficheFilmsComedies();
	    SAXParserFactory factory =  SAXParserFactory.newInstance();
	    try {
	      SAXParser saxParser = factory.newSAXParser();
	      // obtenir un parseur XML
	      saxParser.parse( new File("../films.xml"), myHandler );
	      // parse le fichier en r�alisant les traitements indiqu�s
	    } catch (Throwable t) { t.printStackTrace ();}
	  }
	


}


