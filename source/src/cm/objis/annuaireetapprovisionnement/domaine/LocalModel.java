/**
 * 
 */
package cm.objis.annuaireetapprovisionnement.domaine;

import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * cette classe permet de mettre en oeuvre le model de table d'affichage des
 * loca
 * 
 * @version 3.0
 * @author R. KOUANI
 * 
 */
public class LocalModel extends AbstractTableModel {
	private List<Local> maListeLocaux;
	String[] entete = { "id_LC", "Nom", "Ville", "Adresse",
			"Activité principale", "Type_LC", "Responsable", "Superficie" };

	/**
	 * ceci est le constructeur de la classe
	 * 
	 * @param maListeLocaux
	 *            liste des locaux
	 */
	public LocalModel(List<Local> maListeLocaux) {
		// TODO Auto-generated constructor stub
		this.maListeLocaux = maListeLocaux;
	}

	public LocalModel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ceci est un getter
	 * 
	 * @return collection de agences
	 */

	public List<Local> getMaListeLocaux() {
		return maListeLocaux;

	}

	/**
	 * ceci est un setter
	 */

	public void setMaListeLocaux() {
		this.maListeLocaux = maListeLocaux;
	}

	/**
	 * 
	 * cette methode recupère la taille de la collection des locaux
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 * @return taille de la collection
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return maListeLocaux.size();
	}

	/**
	 * cette méthode récupère le nombre de colonnes du modele de table
	 * 
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
	 * 
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 * @param 
	 *            columnIndex index  de la colonne
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
	 * @param  rowIndex
	 *            index de la cellule
	 * @param  columnIndex
	 *            index de la colonne
	 * @return valeur du champs
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

		switch (columnIndex) {

		case 0:
			// id
			return maListeLocaux.get(rowIndex).getId();

		case 1:
			// Nom
			return maListeLocaux.get(rowIndex).getNom();

		case 2:
			// Ville
			return maListeLocaux.get(rowIndex).getVille();

		case 3:
			// Adresse
			return maListeLocaux.get(rowIndex).getAdresse();

		case 4:
			// Activite1
			return maListeLocaux.get(rowIndex).getActivite1();

		case 5:
			// Type local
			return maListeLocaux.get(rowIndex).getTypeLocal();

		case 6:
			// Responsable local
			return maListeLocaux.get(rowIndex).getResponsableLocal();

		case 7:
			// Superficie local
			return maListeLocaux.get(rowIndex).getSuperficieLocal();

		default:
			throw new IllegalArgumentException();

		}

	}

}
