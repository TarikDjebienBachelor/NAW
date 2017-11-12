/** @author rakotobe */

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;





public class HandlerForIdIdRef extends DefaultHandler{

	
	
	private Map<String,Integer> lesId ;
	private Map<String,Integer> lesIdRef ;

	
	
	/**CONSTRUCTEUR*/
	public HandlerForIdIdRef(){
		this.lesId= new HashMap<String,Integer>();
		this.lesIdRef= new HashMap<String,Integer>();
	}
	
	
	
	
    /**
     * Evenement envoye au demarrage du parse du flux xml.
     * @throws SAXException en cas de probleme quelquonque ne permettant pas de
     * se lancer dans l'analyse du document.
     * @see org.xml.sax.ContentHandler#startDocument()
     */
	public void startDocument(){ 
		System.out.println("********** D�but V�rification des id/idref : ******** "); 
	} 

	
	
	/**
     * Evenement envoye a la fin de l'analyse du flux xml.
     * @throws SAXException en cas de probleme quelquonque ne permettant pas de
     * considerer l'analyse du document comme etant complete.
     * @see org.xml.sax.ContentHandler#endDocument()
     */
	public void endDocument(){ 
		//on v�rifie ici que chaque idref a bien un id correspondant
		for (String s : this.lesIdRef.keySet()){
			if (! this.lesId.containsKey(s)){
				System.out.println("!!! L'IdRef = " + s + " n'a pas d'Id correspondant !!! ");
				//lancer une exception idRefError ici
			}
		}
		System.out.println("********** Fin V�rification des id/idref : **********");
	}

	
	

	/**
     * Evenement recu a chaque fois que l'analyseur rencontre une balise xml ouvrante.
     * @param nameSpaceURI l'url de l'espace de nommage.
     * @param localName le nom local de la balise.
     * @param rawName nom de la balise en version 1.0 <code>nameSpaceURI + ":" + localName</code>
     * @throws SAXException si la balise ne correspond pas a ce qui est attendu,
     * comme par exemple non respect d'une dtd.
     * @see org.xml.sax.ContentHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
     */
	public void startElement (String nameSpace, String localName, String qName, Attributes attr){  
        for (int index = 0; index < attr.getLength(); index++) { 
        	//UNICITE DES ID
        	if (attr.getLocalName(index).equalsIgnoreCase("id")){
        		String cl�Id = attr.getValue(index); // valeur de la cl� 
                 //System.out.println(attr.getLocalName(index) + " = " + attr.getValue(index));
                if (this.lesId.containsKey(attr.getValue(index))) { //la map contient d�ja une cl� correpondante
                    System.out.println("!!!!!  L'ID = " + attr.getValue(index) +" existe d�ja !!!! ");
                    //lancer une exception iderror ici
                } else {
                	System.out.println("Ajout de (" + attr.getValue(index) + ",1) dans la map Id");
                    this.lesId.put(cl�Id, 1);
                } 
        	}
        	
        	//POUR LES IDREFS
           	if (attr.getLocalName(index).equalsIgnoreCase("idref") || attr.getLocalName(index).equalsIgnoreCase("ref")){
        		String cl�Id = attr.getValue(index); // valeur de la cl� 
                //System.out.println(attr.getLocalName(index) + " = " + attr.getValue(index));
                if (this.lesIdRef.containsKey(attr.getValue(index))) { 
                	Integer nbIdRef =this.lesIdRef.get(cl�Id) + 1 ;
                	System.out.println("Ajout de (" + attr.getValue(index) +","+ nbIdRef +") dans la map IdRef");
                    this.lesIdRef.put(cl�Id, this.lesIdRef.get(cl�Id) + 1); // pour avoir combien d'IdRef correspondant on a 
                } else { 
                	System.out.println("Ajout de (" + attr.getValue(index) + ",1) dans la map IdRef");
                    this.lesIdRef.put(cl�Id, 1);
                } 
        	}
        	
        }
	}



	
	/**
     * Evenement recu a chaque fermeture de balise.
     * @see org.xml.sax.ContentHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
     */
	 public  void endElement(String uri, String localName, String qName) {
		 //on ne fait rien de sp�ciale dans endElement
	 }
	
	 
	 
	
     /**
      * Evenement recu a chaque fois que l'analyseur rencontre des caracteres (entre
      * deux balises).
      * @param ch les caracteres proprement dits.
      * @param start le rang du premier caractere a traiter effectivement.
      * @param end le rang du dernier caractere a traiter effectivement
      * @see org.xml.sax.ContentHandler#characters(char[], int, int)
      */

	 public void characters(char[] caracteres, int debut,int longueur) throws SAXException {
		 //on ne fait rien de sp�ciale dans characters

	 }

	 
	 
	 
	


	 
	 
	 
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HandlerForIdIdRef handlerVerificateurID = new HandlerForIdIdRef();
	    SAXParserFactory factory =  SAXParserFactory.newInstance();
	    try {
	      SAXParser saxParser = factory.newSAXParser();
	      // obtenir un parseur XML
	      saxParser.parse(new File("recettes.xml"), handlerVerificateurID );
	      // parse le fichier en r�alisant les traitements indiqu�s
	    } catch (Throwable t) { 
	    	t.printStackTrace ();
	    }
	}

	
	
}
