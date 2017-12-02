package DAO;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import com.mysql.jdbc.StringUtils;

/*
 * Cette classe non instanciable implémente les méthodes communes entre les différentes implémentation EntiteDAO
 * En particulier, l'établissement de la connexion au BD et sa fermeture 
 * En plus, 
 */
class UtileDAO {
	//URL DE CONNEXION
	private static final String URL = "jdbc:mysql://localhost:3306/projet_sgbd" ;
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static final String DRIVER = "com.mysql.jdbc.Driver" ;
	
	private UtileDAO() {
		
	}
	
	//Etablissement de la connexion au BD
	static final Connection etablirConnexion() {
		try {
			Class.forName(DRIVER);
		}
		catch(ClassNotFoundException e) {
			throw new ExceptionDAO("Erreur de chargement de driver",e);
		}
		
		Connection connexion = null ;
		try {
			connexion = DriverManager.getConnection(URL,USER,PASSWORD);
			return connexion ;
		}
		catch(SQLException e) {
			throw new ExceptionDAO("Erreur de connexion",e);
		}
	}
    
	//Préparer la requete en la passant les paramètres '?'
	static final PreparedStatement initialiserRequete(Connection c, boolean b , String sql, Object ...objects ){
		PreparedStatement req ;
		try {
			req = c.prepareStatement(sql, b ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
		}
		catch(SQLException e) {
			throw new ExceptionDAO("Erreur dans la préparation du requete sql",e);
		}
		// b = true => récupération du clé primaire 
		if(objects == null) return req ;
		
		for(int i=0 ; i < objects.length ; i++) {
			try {
				req.setObject(i+1,objects[i]);
			} catch (SQLException e) {
				throw new ExceptionDAO("Erreur dans l'initialisation du requete sql",e);
			}
		}
		return req;
	}
	
	//Fermeture de ressources 
	static final void fermeture(Connection c , Statement s) {
		if(s != null) {
			try {
				s.close();
			}
			catch(SQLException e) {
				throw new ExceptionDAO("Erreur de fermeture de Statement", e);
			}
		}
		if(c != null) {
			try {
				c.close();
			}
			catch(SQLException e) {
				throw new ExceptionDAO("Erreur de fermeture de Connexion",e);
			}
		}
	}
	
	static final void fermeture(Connection c, Statement s,ResultSet r) {
		if(r!=null) {
			try {
				r.close();
			}
			catch(SQLException e) {
				throw new ExceptionDAO("Erreur de fermeture de ResultSet", e);
			}
		}
		fermeture(c,s);
	}
	
	
	//La correspondance entre une ligne de ResultSet et une entité Entite ( pour une requete de consultation )
	static final Object mapping(ResultSet r,String nomClasse) {
		Class c ;
		try {
			c = Class.forName(nomClasse);
		}
		catch(ClassNotFoundException e) {
			throw new ExceptionDAO("Erreur dans le nom de la calsse", e);
		}

		Object o ;
		try {
			o = c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new ExceptionDAO("Erruer d'instanciation , nomClasse n'hérite pas de Entite", e);
		}
		
		Field[] attributs = c.getDeclaredFields();
		for(int i=0 ; i < attributs.length ; i++) {
			String nomMethode = capitaliser(attributs[i].getName());
			nomMethode = "set"+nomMethode;
			Method setter ;
			try {
				setter = c.getMethod(nomMethode,Object.class);
			} catch (NoSuchMethodException | SecurityException e) {
				throw new ExceptionDAO("Erruer dans l'appel d'un stter",e);
			}
			try {
				setter.invoke(o,r.getObject(attributs[i].getName()));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SQLException e) {
				throw new ExceptionDAO("Erreur dans la récupération du reusltatSet",e);
			}
		}
		return o ;
		
	}
	
	//Méthodes propres au package 
	static String capitaliser(String s) {
		StringBuilder b = new StringBuilder(s);
		int c = b.charAt(0);
		c = c + 'A' - 'a' ;
		b.setCharAt(0, (char) c);
		return b.toString();
		
	}
}
