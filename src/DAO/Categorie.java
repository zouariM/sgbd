package DAO;

/*
 * La table CATEGORIE
 */
public class Categorie {
	/*
	 * Proriètées 
	 */
	private Long id ; //Clé primaire ** ni accessible que par lecture **
	private String niveau ; //Exp : Cadé , Junior , etc ** NOT NULL ** UNIQUE **
	
	/*
	 * Constructeur
	 * Constructeur par défaut : attribut == null 
	 * Constructeur paramétré (niveau)
	 */
	Categorie(){
		this.id = null ;
		this.niveau = null;
	}
	
	Categorie(String niveau){
		this.niveau = niveau ;
	}

	/*
	 * Accesseurs et mutateurs 
	 * id : lecture sulement
	 */
	
	public Long getId() {
		return id;
	}

	public String getNiveau() {
		return niveau;
	}


	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
	//package
	void setId(Long id) {
		this.id = id;
	}
}
