/** @author rakotobe */




public class Personne {

	
	private String nom;
	private String prenom;
	private Personne supDirect;
	
	
	//constucteurs
	public Personne(String nom, String prenom){
		this.nom = nom ; 
		this.prenom = prenom ;
	}
	
	
	public Personne(){}

	
	

	//GETTERS ET SETTERS SUR LES ATTRIBUTS
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Personne getSupDirect() {
		return supDirect;
	}


	public void setSupDirect(Personne supDirect) {
		this.supDirect = supDirect;
	}
	
	
	
	/* Affiche le nom de la personne, son prenom et ses subalternes recursivement, en forme d'arbre */
	public String toString(){
		return this.getNom()+" "+this.getPrenom()+"("+ this.getSupDirect()+")";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
