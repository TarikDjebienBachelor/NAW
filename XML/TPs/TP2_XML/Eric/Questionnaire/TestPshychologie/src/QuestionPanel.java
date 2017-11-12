import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;


/**
 * Repr�sente un panneau destin� � contenir une question, accompagn� d'un champ de saisie de r�ponse.
 * @author rakotobe
 */

public class QuestionPanel {
	
	private JPanel panel;
	private JLabel enonce;
	private List<String> theValues;
	private ButtonGroup group;
	// Gestionnaires de placements. Je les met en statique afin de ne pas multiplier les instances.
	public static final GridLayout TROIS_LIGNES = new GridLayout(3,1);
	
	

	
	/** Construit le QuestionPanel correspondant � la question pass�e en param�tre
	 * @param question contiendra intituleQuestion et les reponses 
	 */
	public QuestionPanel(Element question) {
		// Initialisation des attributs
		this.enonce = new JLabel(question.getFirstChild().getTextContent());
		//renvoit les reponses a la question
		NodeList lesReponses = question.getChildNodes().item(2).getChildNodes();
		
//		for (int i=0;i<lesReponses.getLength();i++){
//			Element reponse = (Element) lesReponses.item(i);
//		}	
		
		this.panel = new JPanel(QuestionPanel.TROIS_LIGNES);
		// Construction du Panel
		this.panel.add(this.enonce);
		// Application du style
		this.enonce.setBorder(Style.MARGES_INTERNES);
		this.enonce.setForeground(Style.COULEUR_QUESTION);
		this.enonce.setFont(Style.PETITE_POLICE);
		this.panel.setBackground(Style.FOND_QUESTION);
		this.panel.setBorder(Style.BORDURE_FINE);
	}
	



		private Component createPanel(Element reponse) {
			// J'ajoute tous les boutons radios correspondant aux labels pr�sents dans theValues.
			JRadioButton radio = new JRadioButton(reponse.getTextContent());
			JPanel jp = new JPanel();
			jp.add(radio);
			this.group.add(radio);
			// Style du bouton radio
			radio.setFont(Style.PETITE_POLICE);
			radio.setOpaque(false);
			return jp ; 
	}




		/**Construit un GroupeReponsePanel
		 * @param layout Le gestionnaire de placement � adopter.
		 */
	
		
		
		
		/** Initialise la liste de labels propos�s.*/
		public String getValue() {
			// Je vais parcourir l'ensemble des boutons radio du groupe � la recherche d'un bouton selectionn�.
			Enumeration<AbstractButton> e = this.group.getElements();
			String res = null;
			while(res == null && e.hasMoreElements()) {
				AbstractButton radio = e.nextElement();
				if (radio.isSelected()) {
					res = radio.getText();
				}
			}
			return res;
		}

	
	
	/**Renvoie le JPanel associ� au QuestionPanel.
	 * @return Le JPanel associ� au QuestionPanel.
	 */
	public JPanel getPanel() {
		return this.panel;
	}

}
