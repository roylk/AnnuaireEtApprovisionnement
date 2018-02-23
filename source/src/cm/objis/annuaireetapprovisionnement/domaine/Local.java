package cm.objis.annuaireetapprovisionnement.domaine;

/**
 * cette classe offre les possibilités permettant de créér et de parametrer
 * diverses formes de locaux elle est liée par héritage à la classe Site
 * 
 * @author R. KOUANI
 * @version 3.0
 * 
 */
public class Local extends Site {
	private String typeLocal;
	private String responsableLocal;
	private int superficieLocal;

	/**
	 * Cette méthode est le constructeur par défaut de la classe Local
	 */
	public Local() {
		super();
	}

	/**
	 * cette méthode est un autre constructeur de la classe local ceci
	 * matérialise la mise en oeuvre de la surcharge
	 * 
	 * @param id
	 *            l'identifiant unique d'un local
	 * @param nom
	 *            le nom du local
	 * @param ville
	 *            la ville qui héberge le local
	 * @param adresse
	 *            l'adresse du local
	 */
	/**
	 * Cette méthode est un autre constructeur le la classe Local elle met
	 * toujours en exergue la notion de surchage
	 * 
	 * @param id
	 *            l'identifiant unique du local
	 * @param nom
	 *            le nom du local
	 * @param ville
	 *            la ville qui héberge le local
	 * @param adresse
	 *            l'adresse du local
	 */
	public Local(int id, String nom, String ville, String adresse) {
		super(id, nom, ville, adresse);
		this.typeLocal = typeLocal;
		this.responsableLocal = responsableLocal;
		this.superficieLocal = superficieLocal;
		// TODO Auto-generated constructor stub
	}

	/**
	 * un autre constructeur pour la classe Agence
	 * 
	 * @param id
	 *            l'identifiant unique du local
	 * @param nom
	 *            le nom du local
	 * @param ville
	 *            la ville qui héberge le local
	 * @param adresse
	 *            l'adresse du local
	 * @param activite1
	 *            l'activité principale du local
	 */
	public Local(int id, String nom, String ville, String adresse,
			String activite1) {
		super(id, nom, ville, adresse, activite1);
		this.typeLocal = typeLocal;
		this.responsableLocal = responsableLocal;
		this.superficieLocal = superficieLocal;
		// TODO Auto-generated constructor stub
	}

	/**
	 * le getter de l'attribut typeLocal
	 * 
	 * @return le type du local
	 */
	public String getTypeLocal() {
		return typeLocal;
	}

	/**
	 * le setter de l'attribut typeLocal
	 * 
	 * @param typeLocal
	 *            le type de Local
	 */
	public void setTypeLocal(String typeLocal) {
		this.typeLocal = typeLocal;
	}

	/**
	 * le getter de l'attribut responsableLocal
	 * 
	 * @return le responsable du local
	 */
	public String getResponsableLocal() {
		return responsableLocal;
	}

	/**
	 * setter de l'attribut responsableLocal
	 * 
	 * @param responsableLocal
	 *            le nom du responsable de local
	 */
	public void setResponsableLocal(String responsableLocal) {
		this.responsableLocal = responsableLocal;
	}

	/**
	 * le getter de l'attribut superficieLocal
	 * 
	 * @return la superficie du local
	 */
	public int getSuperficieLocal() {
		return superficieLocal;
	}

	/**
	 * le setter de l'attribut superficieLocal
	 * 
	 * @param superficieLocal
	 *            la superficie du Local
	 */
	public void setSuperficieLocal(int superficieLocal) {
		this.superficieLocal = superficieLocal;
	}

	/**
	 * ceci est la méthode toString de la classe Local
	 * 
	 * @return la reférence d'un objet Local en mémoire
	 * @see cm.objis.annuaireetapprovisionnement.domaine.Site#toString()
	 */
	@Override
	public String toString() {
		return "Local [typeLocal=" + typeLocal + ", responsableLocal="
				+ responsableLocal + ", superficieLocal=" + superficieLocal
				+ "]";
	}

}
