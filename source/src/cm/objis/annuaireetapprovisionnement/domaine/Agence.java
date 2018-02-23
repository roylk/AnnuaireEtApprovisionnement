package cm.objis.annuaireetapprovisionnement.domaine;

/**
 * @author R. KOUANI
 * @version 3.0 la classe Agence offre les possibilités de créér diverses formes
 *          d'agence elle est liée par Héritage à la classe Site
 * 
 */
public class Agence extends Site {
	// les attributs propres à la classe agence
	private String typeAgence;
	private String responsableAgence;
	private String horaires;

	// constructeur
	/**
	 * ceci est le constructeur par défaut de la classe Agence
	 */
	public Agence() {
		super();
	}

	/**
	 * Ceci est un constructeur de la classe Agence
	 * 
	 * @param id
	 *            l'identifiant unique d'une agence
	 * @param nom
	 *            le nom d'une agence
	 * @param ville
	 *            la ville de localisation de l'agence
	 * @param adresse
	 *            l'adresse de l'agence
	 * @param typeAgence
	 *            le type d'agence
	 * @param responsableAgence
	 *            le nom du responsable de l'agence
	 * @param horaires
	 *            les horaires d'ouverture de l'agence
	 */
	public Agence(int id, String nom, String ville, String adresse,
			String typeAgence, String responsableAgence, String horaires) {
		super(id, nom, ville, adresse);
		this.typeAgence = typeAgence;
		this.responsableAgence = responsableAgence;
		this.horaires = horaires;
	}

	/**
	 * Ceci est un autre constructeur de l'agence permettant de mettre en oeuvre
	 * la notion de surcharge
	 * 
	 * @param id
	 *            l'identifiant unique de l'agence
	 * @param nom
	 *            le nom de l'agence
	 * @param ville
	 *            la ville qui heberge l'agence
	 * @param adresse
	 *            l'adresse de l'agence
	 * @param activite1
	 *            l'activité prinicipale de l'agence
	 */
	public Agence(int id, String nom, String ville, String adresse,
			String activite1) {
		super(id, nom, ville, adresse, activite1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Un autre constructeur de la classe Agence
	 * 
	 * @param id
	 *            l'identifiant
	 * @param nom
	 *            le nom de l'agence
	 * @param ville
	 *            la ville de localisation
	 * @param adresse
	 *            l'adresse
	 */
	public Agence(int id, String nom, String ville, String adresse) {
		super(id, nom, ville, adresse);
		// TODO Auto-generated constructor stub
	}

	/**
	 * le getter de l'attribut typeAgence
	 * 
	 * @return le type de l'agence
	 */
	public String getTypeAgence() {
		return typeAgence;
	}

	/**
	 * le setter de l'attribut typeAgence
	 * 
	 * @param typeAgence
	 *            le type de l'agence
	 */
	public void setTypeAgence(String typeAgence) {
		this.typeAgence = typeAgence;
	}

	/**
	 * le getter de l'attribut ResponsableAgence
	 * 
	 * @return le nom du responsable de l'agence
	 */
	public String getResponsableAgence() {
		return responsableAgence;
	}

	/**
	 * le setter de l'attribut responsableAgence
	 * 
	 * @param responsableAgence
	 *            le nom du responsable de l'agence
	 */
	public void setResponsableAgence(String responsableAgence) {
		this.responsableAgence = responsableAgence;
	}

	/**
	 * le getter de l'attribut Horaires
	 * 
	 * @return les horaires d'ouverture de l'agence
	 */
	public String getHoraires() {
		return horaires;
	}

	/**
	 * le setter de l'attribut Horaires de l'agence
	 * 
	 * @param horaires
	 *            les Horaires d'ouverture de l'agence
	 */
	public void setHoraires(String horaires) {
		this.horaires = horaires;
	}

	/**
	 * la méthode toString pour la classe Agence permet d'afficher la reference
	 * de l'objet en memoire
	 * 
	 * @see cm.objis.annuaireetapprovisionnement.domaine.Site#toString()
	 */
	@Override
	public String toString() {
		return "Agence [typeAgence=" + typeAgence + ", responsableAgence="
				+ responsableAgence + ", horaires=" + horaires + "]";
	}

}
