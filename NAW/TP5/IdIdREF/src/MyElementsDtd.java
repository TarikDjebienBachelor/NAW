import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** @author rakotobe */


public class MyElementsDtd implements ElementsDTD {

	//les balises sera une map avec comme clé le nom de la balise, et comme valeur la liste de ses attributs 
	private Map<String,ArrayList<String>> lesBalisesId ;
	// cette hashmap contiendra quand a elle les id ref 
	private Map<String,ArrayList<String>> lesBalisesIdRef ;
	
	
	
	//Constructeur
	public MyElementsDtd(){
		super();
		this.lesBalisesId = new HashMap <String,ArrayList<String> >() ;
		this.lesBalisesIdRef = new HashMap <String,ArrayList<String> >() ;
	}
	
	
	
	/** Ajoute un element porteur d'attribut ID ou IDREF
	 * @param tag
	 */
	public void addElement(String tag) {
		this.lesBalisesId.put(tag, new ArrayList<String>());
	}

	
	
	
	/**	Associe l'attribut attName a l'element tag avec le statut d'ID
	 * @param tag
	 * @param attName
	 */
	public void addIdAttr(String tag, String attName) {
		//si l'élément est déja crée on ajoute l'attribut 
		if (this.lesBalisesId.containsKey(tag)){
			this.lesBalisesId.get(tag).add(attName);
		}else{
			ArrayList<String> tmp = new ArrayList<String>() ; 
			tmp.add(attName);
			this.lesBalisesId.put(tag,tmp);
		}
	}

	
	
	
	/**Associe l'attribut attName a l'element tag avec le statut IDREF
	 * @param tag
	 * @param attName
	 */
	public void addIdRefAtt(String tag, String attName) {
		//si l'élément est déja crée on ajoute l'attribut 
		if (this.lesBalisesIdRef.containsKey(tag)){
			this.lesBalisesIdRef.get(tag).add(attName);
		}else{
			ArrayList<String> tmp = new ArrayList<String>() ; 
			tmp.add(attName);
			this.lesBalisesIdRef.put(tag,tmp);
		}

	}

	
	
	
	/** creation de la "dtd" java pour la verificatio des id/idref 
	 * @param args
	 */
//dans le doc parse, l'element "personne" sera sense porter un attribut ID (idpers),
//	et l'element "voiture" un attribut ID (immatriculation) et un attribut IDREF (idprop).
	public static void main(String[] args) {
		ElementsDTD e = new MyElementsDtd();
		e.addElement("personne");
		e.addElement("voiture");
		e.addIdAttr("personne","idpers");
		e.addIdAttr("voiture","immatriculation");
		e.addIdRefAtt("voiture", "idprop") ;
	}

}
