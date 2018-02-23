/**
 * 
 */
package cm.objis.annuaireetapprovisionnement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cm.objis.annuaireetapprovisionnement.domaine.Agence;
import cm.objis.annuaireetapprovisionnement.domaine.Local;
import cm.objis.annuaireetapprovisionnement.domaine.Site;
import cm.objis.annuaireetapprovisionnement.utils.MySQLconnection;

/**
 * Cette classe offre les fonctionnalités de communication avec la base de
 * donnée de l'application
 * 
 * @author R. KOUANI
 * @version 3.0
 * 
 */
public class Dao implements IDao {
	// Connection cn = MySQLconnection.getInstance();

	/**
	 * le constructeur par défaut de la classe
	 */
	public Dao() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * Cette méthode permet de récupérer dans une liste les objets Site depuis
	 * la base des données.
	 * 
	 * @return Une liste des sites
	 * 
	 */

	public List<Site> lectureDaoSites() {
		/**
		 * creation d'une liste de site de Sites(local, agence)
		 */
		List<Site> maListeSites = new ArrayList<Site>();

		/**
		 * Information d'accès à la base de données
		 */
		

		try {

			/**
			 * récupération de la connexion
			 */
			
			Connection cn = MySQLconnection.getInstance();

			/**
			 * préparation requête
			 */
			Statement st = cn.createStatement();

			String sql = "SELECT * FROM `Site` ";

			ResultSet rs = st.executeQuery(sql);
			/**
			 * parcours du resultset
			 */

			while (rs.next()) {
				/**
				 * instanciation d'un objet Site
				 */
				Site site = new Site();
				site.setId(rs.getInt("id"));
				site.setNom(rs.getString("nom"));
				site.setVille(rs.getString("ville"));
				site.setAdresse(rs.getString("adresse"));
				site.setActivite1(rs.getString("activite1"));

				maListeSites.add(site);

			}

			/**
			 * gestion des exceptions et libération 'automatique' des ressources
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maListeSites;

	}

	/**
	 * 
	 * Cette methode est utilisée pour sauvegarder un site(local ou agence) dans
	 * la base de données
	 * 
	 * @param site
	 *            un objet de type Site
	 * @return un entier(0 ou 1)
	 * 
	 */
	public int enregistrerDaoSite(Site site) {
		// TODO Auto-generated method stub

		try {

			/**
			 * Etape de connection à la base de données
			 */

			Connection cn = MySQLconnection.getInstance();

			/**
			 * Requête préparée d'insertion des données dans la table Site
			 */

			String sql = "INSERT INTO `Site` (`nom`,`ville`,`adresse`,`activite1`) "
					+ "VALUES(?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);

			ps.setString(1, site.getNom());
			ps.setString(2, site.getVille());
			ps.setString(3, site.getAdresse());
			ps.setString(4, site.getActivite1());

			/**
			 * Exécution de la requête
			 */
			ps.executeUpdate();

			/**
			 * Etape 4 : gestion des exceptions et libération 'automatique' des
			 * ressources
			 */

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;

	}

	/**
	 * Cette methode permet la lecture des sites de types agence depuis la base
	 * des données
	 * 
	 * @return maListeSites une collection des sites de type Agence
	 * @see cm.objis.annuaireetapprovisionnement.dao.IDao#lectureDaoAgences()
	 */
	@Override
	public List<Agence> lectureDaoAgences() {
		// TODO Auto-generated method stub
		// creation d'une collection de Sites(local, agence)
		List<Agence> maListeSites = new ArrayList<Agence>();

		try {

			/**
			 * récupération de la connexion
			 */

			Connection cn = MySQLconnection.getInstance();

			/**
			 * préparation de la requête
			 */
			Statement st = cn.createStatement();

			String sql = "SELECT * FROM `Site` INNER JOIN `Agence` ON Site.id_agence = Agence.id ";

			/**
			 * exécution de la requête
			 */
			ResultSet rs = st.executeQuery(sql);

			/**
			 * :parcours Resultset (optionnel)
			 */
			while (rs.next()) {
				Site site1 = new Agence();
				/**
				 * instructin de transtypage d'un Site en Agence
				 */
				Agence site = (Agence) site1;
				site.setId(rs.getInt("id"));
				site.setNom(rs.getString("nom"));
				site.setVille(rs.getString("ville"));
				site.setAdresse(rs.getString("adresse"));
				site.setActivite1(rs.getString("activite1"));
				site.setResponsableAgence(rs.getString("responsableAgence"));
				site.setTypeAgence(rs.getString("typeAgence"));
				site.setHoraires(rs.getString("horaires"));
				/**
				 * ajout de l'objet constitué(Agence) dans la Liste
				 */
				maListeSites.add(site);

			}

			/**
			 * : gestion des exceptions et libération 'automatique' des
			 * ressources
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maListeSites;

	}

	/**
	 * Cette methode permet la lecture des sites de types local depuis la base
	 * des données
	 * 
	 * @return maListeSites une collection des sites de type Local
	 * @see cm.objis.annuaireetapprovisionnement.dao.IDao#lectureDaoLocaux()
	 */
	@Override
	public List<Local> lectureDaoLocaux() {
		/**
		 * creation(instanciation) d'une collection de Sites(local)
		 */

		List<Local> maListeSites = new ArrayList<Local>();

		/**
		 * Information d'accès à la base de données
		 */

		try {

			/**
			 * récupération de la connexion
			 */
			
			Connection cn = MySQLconnection.getInstance();

			/**
			 * préparation requête
			 */
			Statement st = cn.createStatement();

			String sql = "SELECT * FROM `Site` INNER JOIN `Local` ON Site.id_local = Local.id ";

			/**
			 * exécution requête
			 */
			ResultSet rs = st.executeQuery(sql);

			/**
			 * parcours Resultset (optionnel)
			 */
			while (rs.next()) {
				Site site1 = new Local();
				/**
				 * instruction de transtypage d'un Site en Local
				 */
				Local site = (Local) site1;
				site.setId(rs.getInt("id"));
				site.setNom(rs.getString("nom"));
				site.setVille(rs.getString("ville"));
				site.setAdresse(rs.getString("adresse"));
				site.setActivite1(rs.getString("activite1"));
				site.setResponsableLocal(rs.getString("responsableLocal"));
				site.setTypeLocal(rs.getString("typeLocal"));
				site.setSuperficieLocal(rs.getInt("superficieLocal"));

				/**
				 * ajout de l'objet de type local dans la Liste
				 */

				maListeSites.add(site);

			}

			// Etape 5 : gestion des exceptions et libération 'automatique' des
			// ressources
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maListeSites;

	}

	/**
	 * cette méthode permet d'enregistrer les Sites de type Agence dans la base
	 * de données
	 * 
	 * @param site
	 *            un objet de type Agence
	 * @return un entier 0 ou 1
	 * @see cm.objis.annuaireetapprovisionnement.dao.IDao#enregistrerDaoSite(cm.objis.annuaireetapprovisionnement.domaine.Agence)
	 */
	@Override
	public int enregistrerDaoSite(Agence site) {
		// TODO Auto-generated method stub

		try {

			/**
			 * récupération de la connexion
			 */

			Connection cn = MySQLconnection.getInstance();

			/**
			 * Création d'un statement requête d'insertion dans la table Agence
			 */

			String sql1 = "INSERT INTO `Agence` (`typeAgence`,`responsableAgence`,`horaires`) "
					+ "VALUES(?,?,?)";

			PreparedStatement ps1 = cn.prepareStatement(sql1);

			ps1.setString(1, site.getTypeAgence());
			ps1.setString(2, site.getResponsableAgence());
			ps1.setString(3, site.getHoraires());
			/**
			 * exécution du statement
			 */
			ps1.executeUpdate();

			/**
			 * requête d'insertion dans la table Site avec la dernière id
			 * (LAST_INSERT_ID) inserée de l'agence comme clé étrangère
			 */

			String sql2 = "INSERT INTO `Site` (`id_agence`,`nom`,`ville`,`adresse`,`activite1`) "
					+ "VALUES(LAST_INSERT_ID(),?,?,?,?)";

			PreparedStatement ps2 = cn.prepareStatement(sql2);

			ps2.setString(1, site.getNom());
			ps2.setString(2, site.getVille());
			ps2.setString(3, site.getAdresse());
			ps2.setString(4, site.getActivite1());

			ps2.executeUpdate();

			// Etape 4 : gestion des exceptions et libération 'automatique' des
			// ressources
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;

	}

	/**
	 * Cette méthode est utilisée pour enregistrer les sites de type Local dans
	 * la base de donnée
	 * 
	 * @param site
	 *            un objet de type Local
	 * @return un entier
	 * @see cm.objis.annuaireetapprovisionnement.dao.IDao#enregistrerDaoSite(cm.objis.annuaireetapprovisionnement.domaine.Local)
	 */
	@Override
	public int enregistrerDaoSite(Local site) {
		// TODO Auto-generated method stub
		/**
		 * Information d'accès à la base de données
		 */

		try {

			/**
			 * récupération de la connexion
			 */

			Connection cn = MySQLconnection.getInstance();

			/**
			 * Création d'un statement requête d'insertion des données dans la
			 * table Local
			 */

			String sql1 = "INSERT INTO `Local` (`typeLocal`,`responsableLocal`,`superficieLocal`) "
					+ "VALUES(?,?,?)";

			PreparedStatement ps1 = cn.prepareStatement(sql1);

			ps1.setString(1, site.getTypeLocal());
			ps1.setString(2, site.getResponsableLocal());
			ps1.setInt(3, site.getSuperficieLocal());

			ps1.executeUpdate();
			/**
			 * requête d'insertion dans la table Site avec la dernière id
			 * (LAST_INSERT_ID) inserée du Local comme clé étrangère
			 */

			String sql2 = "INSERT INTO `Site` (`id_local`,`nom`,`ville`,`adresse`,`activite1`) "
					+ "VALUES(LAST_INSERT_ID(),?,?,?,?)";

			PreparedStatement ps2 = cn.prepareStatement(sql2);

			ps2.setString(1, site.getNom());
			ps2.setString(2, site.getVille());
			ps2.setString(3, site.getAdresse());
			ps2.setString(4, site.getActivite1());

			/**
			 * exécution requête
			 */

			ps2.executeUpdate();

			/**
			 * gestion des exceptions et libération 'automatique' des ressources
			 */

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	
	
	/**
	 * Cette méthode permet de mettre en oeuvre la gestion de login en vérifiant que les coordonnées existent bien en
	 * la base des données. elle assure la communication entre la couche dao et la couche service
	 * @param   login nom utilisateur 
	 * @param   passWord mot de passe
	 * @return Un entier count (supérieur ou égal à 0)
	 * 
	 */
	@Override
	public int loginDao(String login, String passWord) {
		// TODO Auto-generated method stub

		try {

			/**
			 * récupération de la connexion
			 */

			Connection cn = MySQLconnection.getInstance();

			/**
			 * préparation requête
			 */

			String sql = "SELECT `login`,`password` FROM `users` WHERE  `login` = ? AND `password` = ? ";

			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, passWord);

			/**
			 * exécution requête
			 */
			ResultSet rs = ps.executeQuery();

			/**
			 * parcours Resultset (optionnel)
			 */
			int count = 0;
			while (rs.next()) {
				count = count + 1;
				count++;
			}
			return count;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

}
