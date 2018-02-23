/**
 * 
 */
package cm.objis.annuaireetapprovisionnement.domaine;

import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * cette classe permet de mettre en oeuvre le model de table d'affichage des
 * agences
 * @version 3.0
 * @author R. KOUANI
 * 
 */
public class AgenceModel extends AbstractTableModel {

	private List<Agence> maListeAgences;
	String[] entete = { "id_Ag", "Nom", "Ville", "Adresse",
			"Activité principale", "Type_Ag", "Responsable", "Horaires" };

	/**
	 * cette méthode est le constructeur de la classe
	 * 
	 * @param maListeAgences
	 *            collection d'agence
	 */
	public AgenceModel(List<Agence> maListeAgences) {
		// TODO Auto-generated constructor stub
		this.maListeAgences = maListeAgences;
	}

	/**
	 * ceci est un getter
	 * @return collection de agences
	 */

	public List<Agence> getMaListeAgences() {
		return maListeAgences;

	}

	public void setMaListeAgences() {
		this.maListeAgences = maListeAgences;
	}

	/**
	 * ceci est le constructeur par défaut de la classe
	 */
	public AgenceModel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * cette methode recupère la taille de la collection des agences
	 * @see javax.swing.table.TableModel#getRowCount()
	 * @return taille de la collection
	 */

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return maListeAgences.size();
	}

	/**
	 * cette méthode récupère le nombre de colonnes du modele de table
	 * @see javax.swing.table.TableModel#getColumnCount()
	 * @return nombre de colonne du modele de table
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return entete.length;
	}

	/**
	 * cette méthode recupère les noms des colonnes du model de table
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 * @param  columnIndex  index
	 *            de la colonne
	 * @return entête de la table
	 */
	public String getColumnName(int columnIndex) {
		return entete[columnIndex];
	}

	/**
	 * cette méthode récupere les valeurs des différents attributs de chaque
	 * objet agence contenu dans la collection
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 * @param rowIndex
	 *            de la cellule
	 * @param columnIndex
	 *            de la colonne
	 * @return valeur du champs
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {

		case 0:
			// id
			return maListeAgences.get(rowIndex).getId();

		case 1:
			// nom
			return maListeAgences.get(rowIndex).getNom();

		case 2:
			// ville
			return maListeAgences.get(rowIndex).getVille();

		case 3:
			// Adresse
			return maListeAgences.get(rowIndex).getAdresse();

		case 4:
			// Activite1
			return maListeAgences.get(rowIndex).getActivite1();

		case 5:
			// Type agence
			return maListeAgences.get(rowIndex).getTypeAgence();

		case 6:
			// Responsable agence
			return maListeAgences.get(rowIndex).getResponsableAgence();

		case 7:
			// Horaires
			return maListeAgences.get(rowIndex).getHoraires();

		default:
			throw new IllegalArgumentException();

		}

	}

}
