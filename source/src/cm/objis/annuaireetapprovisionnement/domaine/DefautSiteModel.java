/**
 * 
 */
package cm.objis.annuaireetapprovisionnement.domaine;

import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * cette classe permet de mettre en oeuvre le model de table d'affichage des
 * sites par défaut
 * 
 * @version 3.0
 * @author R. KOUANI
 * 
 */
public class DefautSiteModel extends AbstractTableModel {
	String[] entete = { "id_site", "Nom", "Ville", "Adresse",
			"Activité principale" };
	private List<Site> maListeSites;

	/**
	 * cette méthode est le constructeur de la classe
	 * 
	 * @param maListeSites la
	 *            collection des sites
	 */
	public DefautSiteModel(List<Site> maListeSites) {
		// TODO Auto-generated constructor stub
		this.maListeSites = maListeSites;
	}

	/**
	 * ceci est un getter
	 * 
	 * @return une liste de sites
	 */
	public List<Site> getMaListeSites() {
		return maListeSites;

	}

	/**
	 * ceci est un setter
	 */
	public void setMaListeSites() {
		this.maListeSites = maListeSites;
	}

	/**
	 * cette methode recupère la taille de la collection des sites
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 * @return taille de la collection
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return maListeSites.size();
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
	 * @param columnIndex index
	 *            de la colonne
	 * @return entête de la table
	 */
	public String getColumnName(int columnIndex) {
		return entete[columnIndex];
	}

	/**
	 * cette méthode récupere les valeurs des différents attributs de chaque
	 * objet site contenu dans la collection
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 * @param  rowIndex index
	 *            de la cellule
	 * @param  columnIndex, index
	 *            de la colonne
	 * @return valeur du champs
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {

		case 0:
			// id
			return maListeSites.get(rowIndex).getId();

		case 1:
			// nom
			return maListeSites.get(rowIndex).getNom();

		case 2:
			// ville
			return maListeSites.get(rowIndex).getVille();

		case 3:
			// Adresse
			return maListeSites.get(rowIndex).getAdresse();

		case 4:
			// Activité principale
			return maListeSites.get(rowIndex).getActivite1();

		default:
			throw new IllegalArgumentException();

		}

	}

}
