import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
/** @author rakotobe */


//La mise en oeuvre de ce traitement du document XML sur la base d'un parseur SAX necessitera l'exploitation 
//d'une structure auxiliaire de type pile (stack)car sinon on ne pourra pas gérer le fait qu'une personne
//dispose d'un subordonne et qu'une autre possede un superieur hierarchique
//  Par rapport a la personne courante (celle ou le parseur scanne les elements), le sommet de la pile 
//indiquera donc son superieur hierarchique direct


public class Parseur extends DefaultHandler implements InstancePersonne {

	
	private List<Personne> lesPersonnes ; 
	private Stack<Personne> pileDePersonnes ; 
	private Personne p ; 
	//flags nous indiquant la position du parseur
	private int inPersonne,  inNom, inPrenom ;

	
	
	//constructeur
	public Parseur(){
		super();
		this.inNom = 0 ;  this.inPersonne = 0 ; this.inPrenom = 0 ;
		this.p = new Personne();
		this.lesPersonnes = new ArrayList<Personne>();  
		this.pileDePersonnes = new Stack<Personne>();
	}
	

	
	@Override
	public List<Personne> getPersonnes() {
		return this.lesPersonnes ; 
	}

	
	

//************************************************************* DEBUT PARSING  ****************************************************************//
    /**
     * Evenement envoye au demarrage du parse du flux xml.
     * @throws SAXException en cas de probleme quelquonque ne permettant pas de
     * se lancer dans l'analyse du document.
     * @see org.xml.sax.ContentHandler#startDocument()
     */
	public void startDocument(){ 
		System.out.println("********** Démarage parsing AlCapone.xml: ******** "); 
	}
	
	
	
	/**
     * Evenement envoye a la fin de l'analyse du flux xml.
     * @throws SAXException en cas de probleme quelquonque ne permettant pas de
     * considerer l'analyse du document comme etant complete.
     * @see org.xml.sax.ContentHandler#endDocument()
     */
	public void endDocument(){ 
		System.out.println("********** Fin parsing AlCapone.xml: ************* ");
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
		
		if (qName.equals("personne")) {						 
			this.inPersonne ++ ;			 		
			this.p = new Personne();
			System.out.println("inPersonne ++ = " + this.inPersonne + " et Creation new Personne()");
        }
        
		
        if (qName.equals("nom")) {			 			 
            this.inNom ++ ; 		
            System.out.println("inNom ++ = " + this.inNom  );
        }

        //un prenom est toujours en bas d'un nom
        if (qName.equals("prenom")) {				 	
        	this.inPrenom ++ ;		
        	System.out.println("inPreNom ++ = " + this.inPrenom  );
        }

		
	}



	
	/**
     * Evenement recu a chaque fermeture de balise.
     * @see org.xml.sax.ContentHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
     */
	 public  void endElement(String uri, String localName, String qName) {
		 
		
		 
			if (qName.equals("personne")) {						
	        	this.inPersonne -- ; 
	        	this.pileDePersonnes.push(this.p);
	        	System.out.println("inPersonne -- "+this.inPersonne );
	        	System.out.println("Ajout de  " + this.p.getNom() +" " + this.p.getPrenom()+" dans la pile" ) ;
			}
			
			
	        
	        if (qName.equals("nom")) {							
	            this.inNom -- ; 								
	            System.out.println("inNom -- = "+this.inNom );
	        }

	        
	        //si on a le nom et le prenom, on ajoute la personne a la liste
	        if (qName.equals("prenom")) {								
	        	this.inPrenom -- ;										
	        	System.out.println("inPrenom -- = "+this.inPrenom );
	        }
	        
	        
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
		 String lecture = new String(caracteres,debut,longueur); 
		 
			 if (this.inNom == 1){					
				 this.p.setNom(lecture);
				 System.out.println("nom = " + lecture); 
			 }
			 
			 
			 if (this.inPrenom == 1 ){				
				 this.p.setPrenom(lecture);			
				 System.out.println("prenom = " + lecture + " (nom " + this.p.getNom()+")"); 
			
				//la personne est maintenant cree avec son nom et son prenom on peut l'empiler et l'ajouter a la liste 
				//si le nombre de balise <personne> rencontre est superieur a 1, on a des imbrications de personne
				 if( !this.pileDePersonnes.empty() && this.inPersonne>1){
					 Personne subalterne = this.pileDePersonnes.pop();
					 this.p.setSupDirect(subalterne);									
					 System.out.println(subalterne.getNom() +" "+subalterne.getPrenom() + " devient supdirect de " + this.p.getNom()+" " + this.p.getPrenom());
				 }
				 this.lesPersonnes.add(this.p); 		
				 this.pileDePersonnes.push(this.p);					
				 System.out.println("prenom = " + this.p.getPrenom() + " , nom = " +this.p.getNom() + " ajoutee ds pile et liste"); 
			 }
		 
	 }

	 
 
//************************************************************* FIN PARSING  ****************************************************************//


	
	
	public static void main(String[] args) {
		Parseur monHandler= new Parseur();
		SAXParserFactory factory= SAXParserFactory.newInstance();
		try{
			SAXParser saxParser= factory.newSAXParser();
			saxParser.parse(new File("capone.xml"), monHandler);
			for (Personne p: monHandler.getPersonnes()){
				System.out.println(p);
			}
		}catch (Throwable t){
		t.printStackTrace();
		}
	}
		
	
	


		
}