/** @author rakotobe */




public interface ElementsDTD {


	
	
	/** Ajoute un element porteur d'attribut ID ou IDREF
	 * @param tag
	 */
	public void addElement(String tag) ;
	
	
	
	
	
	
	
	/**	Associe l'attribut attName a l'element tag avec lestatut d'ID
	 * @param tag
	 * @param attName
	 */
	public void addIdAttr(String tag, String attName) ;
	
	
	
	
	
	/**Associe l'attribut attName a l'element tag avec le statut IDREF
	 * @param tag
	 * @param attName
	 */
	public void addIdRefAtt(String tag, String attName); 
	
	
	
	

	
}
