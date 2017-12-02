package DAO;

public interface CategorieDAO {
	void create (Categorie categorie);
	Categorie findByNiveau(String niveau); 
}
