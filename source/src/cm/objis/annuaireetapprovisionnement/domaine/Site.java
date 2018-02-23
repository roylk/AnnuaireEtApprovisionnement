package cm.objis.annuaireetapprovisionnement.domaine;

/**
 * Classe permettant de définir un objet Site
 * 
 * @author R. KOUANI
 * @version 3.0
 * 
 */
public class Site {

	// 1. Section Propriétés
	private int id;
	private String nom;
	private String ville;
	private String adresse;
	private String activite1;

	/**
	 * Ceci est le contructeur par defaut de la classe Site
	 */

	public Site() {

	}

	/**
	 * cette méthode est un constructeur de la classe site
	 * 
	 * @param id
	 *            l'identifiant unique d'un site
	 * @param nom
	 *            le nom du site
	 * @param ville
	 *            la ville de localisation du site
	 * @param adresse
	 *            l'adresse du site
	 */

	public Site(int id, String nom, String ville, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.ville = ville;
		this.adresse = adresse;
	}

	/**
	 * Cette methode matérialise la surcharge du constructeur de la classe site
	 * 
	 * @param id
	 *            l'identifiant du site
	 * @param nom
	 *            le nom du site
	 * @param ville
	 *            la ville qui héberge le site
	 * @param adresse
	 *            l'adresse qui mène au site
	 * @param activite1
	 *            l'activité principale du site
	 */
	public Site(int id, String nom, String ville, String adresse,
			String activite1) {
		super();
		this.id = id;
		this.nom = nom;
		this.ville = ville;
		this.adresse = adresse;
		this.activite1 = activite1;
	}

	// 3. Section Getter/Setter

	/**
	 * getter sur l'attribut id
	 * 
	 * @return l'identifiant d'un site
	 */
	public int getId() {
		return id;
	}

	/**
	 * le setter de l'id
	 * 
	 * @param id
	 *            l'identifiant d'un site
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ceci est le getter sur l'attribut nom
	 * 
	 * @return le nom du site
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * ceci est le setter de l'attribut nom du site
	 * 
	 * @param nom
	 *            une variable de type String
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * ceci est le getter de l'attribut ville de la classe Site
	 * 
	 * @return la ville du site
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * ceci est le setter de l'attribut ville de la classe
	 * 
	 * @param ville
	 *            la ville du site
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * getter de l'attribut adresse de Site
	 * 
	 * @return adresse, l'adresse du site
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * le setter de l'attribut adresse du site
	 * 
	 * @param adresse
	 *            l'adresse du site
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * le getter de l'attribut Activite1 du site
	 * 
	 * @return l'activité principale du site
	 */
	public String getActivite1() {
		return activite1;
	}

	/**
	 * le setter de l'attribut activite1 du site
	 * 
	 * @param activite1
	 *            l'activité principale du site
	 */
	public void setActivite1(String activite1) {
		this.activite1 = activite1;
	}

	/**
	 * ceci est une methode toString de la classe Site permet d'afficher la
	 * reférence de l'objet en mémoire
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Site [id=" + id + ", nom=" + nom + ", ville=" + ville
				+ ", adresse=" + adresse + "]";
	}

}
