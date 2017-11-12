import java.util.HashMap;

/**
 * 
 */

/**
 * @author rsitrakaeric
 *
 */
public class QuestionReponse {


	private String intituleQuestions ; 	
	private int idQuestion ; 
	// une question contient un libelle , et des reponses = identifiant + libelle reponse
	private HashMap<Integer,String> questionsReponses  ;
	
	
	
	
	//CONSTRUCTEUR
	public QuestionReponse(){
		this.questionsReponses = new HashMap<Integer,String>();
	}
	
	
	
	public void put(Integer i , String s ) {
		this.questionsReponses.put(i, s);
	}
	
	
	
	
	//GETTERS AND SETTERS
	public String getIntituleQuestions() {
		return intituleQuestions;
	}
	public void setIntituleQuestions(String intituleQuestions) {
		this.intituleQuestions = intituleQuestions;
	}
	public HashMap<Integer, String> getQuestionsReponses() {
		return questionsReponses;
	}
	public void setQuestionsReponses(HashMap<Integer, String> questionsReponses) {
		this.questionsReponses = questionsReponses;
	} 
	public int getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	
	
	
}
