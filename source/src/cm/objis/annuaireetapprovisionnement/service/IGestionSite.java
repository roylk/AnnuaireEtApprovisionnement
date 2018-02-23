package cm.objis.annuaireetapprovisionnement.service;

import java.util.List;

import cm.objis.annuaireetapprovisionnement.domaine.Agence;
import cm.objis.annuaireetapprovisionnement.domaine.Local;
import cm.objis.annuaireetapprovisionnement.domaine.Site;

/**
 * Cette interface contient des signature des méthodes métiers offrant les
 * fonctionnalités de gestion des Sites(agence, local)
 * 
 * @author R. KOUANI
 * @version 3.0
 * 
 */
public interface IGestionSite {
	public void afficherSite(Site site);

	public void enregistrerSite(Site site);

	public void supprimerSite(Site site);

	public void modifierSite(Site site);

	public void afficherSite(Agence agence);

	public void afficherSite(Local local);

	public List<Site> lectureServiceSites();

	public int enregistrerServiceSite(Site site);

	public int enregistrerServiceSite(Agence site);

	public int enregistrerServiceSite(Local site);

	public List<Agence> lectureServiceAgences();

	public List<Local> lectureServiceLocaux();

	public int loginService(String login, String passWord);

}
