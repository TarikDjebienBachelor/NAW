

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * Fournit un ensemble d'objets de types décoratifs (couleurs,marges,polices) afin de faciliter la création du "design" de l'application.
 * @author rakotobe
 */
public class Style {
	
	// Couleurs
	public static final Color FOND_FENETRE = new Color(237,237,237);
	public static final Color FOND_QUESTION = new Color(253,253,253);
	public static final Color FOND_QUESTION_VALIDE = new Color(151,253,151);
	
	public static final Color COULEUR_QUESTION = Color.DARK_GRAY;
	public static final Color COULEUR_INVALIDE = new Color(153,0,0);
	public static final Color COULEUR_VALIDE = new Color(0,128,64);
	
	// Bordures
	public static final Border BORDURE_FINE = new LineBorder(Color.LIGHT_GRAY,1,true);
	public static final int MARGES_EXTERNES = 3;
	public static final Border MARGES_INTERNES = new EmptyBorder(0,15,0,30);
	public static final Border AUCUNE_BORDURE = new EmptyBorder(0,0,0,0);
	
	// Polices
	public static final Font PETITE_POLICE = new Font(Font.DIALOG,Font.PLAIN,11);
	public static final Font GRANDE_POLICE = new Font(Font.DIALOG,Font.PLAIN,16);
	
	// Dimensions
	public static final int HAUTEUR_CHAMP = 24;
	public static final Dimension DIMENSION_SPINNER = new Dimension(100,HAUTEUR_CHAMP);
	public static final Dimension DIMENSION_TEXTFIELD = new Dimension(200,HAUTEUR_CHAMP);
	

}
