package cm.objis.annuaireetapprovisionnement.presentation.vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import cm.objis.annuaireetapprovisionnement.dao.Dao;
import cm.objis.annuaireetapprovisionnement.dao.IDao;
import cm.objis.annuaireetapprovisionnement.domaine.DefautSiteModel;
import cm.objis.annuaireetapprovisionnement.domaine.Site;
import cm.objis.annuaireetapprovisionnement.service.GestionSite;
import cm.objis.annuaireetapprovisionnement.service.IGestionSite;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;

/**
 * cette classe offre les possibilités permettant de mettre en oeuvre les
 * fonctionnalités gestion des sites par défaut (création, affichage,
 * suppression, modification)
 * 
 * @version 3.0
 * @author R. KOUANI
 * 
 */
public class DefaultSiteForm extends JFrame {
	private static IDao dao = new Dao();
	private static IGestionSite gestionsite = new GestionSite(dao);

	private JPanel contentPane;
	private JTextField textFieldNomSt;
	private JTextField textFieldVilleS;
	private JTextField textFieldAdresse;
	private JTextField textFieldActivite1;
	private JPanel panelListe;
	private JTable tableSt;
	private JScrollPane scrollPaneLst;

	/**
	 * cette méthode et le constructeur de la classe et à ce titre, permet de
	 * créer la fenêtre offrant les fonctionnalités de gestion des sites par
	 * défaut
	 */
	public DefaultSiteForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				DefaultSiteForm.class
						.getResource("/main/resources/img/sites.jpg")));
		setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 15));
		setTitle("Gestion des sites par d\u00E9faut");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel formPanel = new JPanel();
		formPanel.setBackground(new Color(211, 211, 211));
		formPanel.setBorder(new TitledBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)),
				"Formulaire d'enregistrement ", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));

		JButton btnAccueil = new JButton("ACCUEIL");
		btnAccueil
				.setToolTipText("cliquer ici pour revenir \u00E0 la page d'accueil");
		btnAccueil.setHorizontalAlignment(SwingConstants.LEFT);
		btnAccueil.setIcon(new ImageIcon(DefaultSiteForm.class
				.getResource("/main/resources/img/icons8-Back.png")));
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPage();
			}
		});
		btnAccueil.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(32,
				178, 170)));
		btnAccueil.setFont(new Font("Trebuchet MS", Font.BOLD, 13));

		panelListe = new JPanel();
		panelListe.setBorder(new TitledBorder(null, "LISTE DES SITES",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));

		JButton btnListeS = new JButton("LISTER & RAFRAICHIR");
		btnListeS.setToolTipText("lister ou rafraichir la liste");
		btnListeS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefautSiteModel dSModel = new DefautSiteModel(gestionsite
						.lectureServiceSites());

				tableSt = new JTable(dSModel);
				scrollPaneLst.setViewportView(tableSt);

			}
		});
		btnListeS.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnListeS.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				formPanel,
																				GroupLayout.PREFERRED_SIZE,
																				285,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				panelListe,
																				GroupLayout.DEFAULT_SIZE,
																				411,
																				Short.MAX_VALUE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				btnAccueil,
																				GroupLayout.PREFERRED_SIZE,
																				92,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(410)
																		.addComponent(
																				btnListeS,
																				GroupLayout.PREFERRED_SIZE,
																				138,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(0)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane.createSequentialGroup()
										.addContainerGap(308, Short.MAX_VALUE)
										.addComponent(btnAccueil))
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(6)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																panelListe,
																GroupLayout.PREFERRED_SIZE,
																280,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																formPanel,
																GroupLayout.PREFERRED_SIZE,
																268,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(btnListeS,
												GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addGap(19)));
		panelListe.setLayout(new BorderLayout(0, 0));

		scrollPaneLst = new JScrollPane();
		panelListe.add(scrollPaneLst, BorderLayout.CENTER);

		tableSt = new JTable();
		scrollPaneLst.setViewportView(tableSt);

		JLabel lblTitre = new JLabel("VEUILLEZ RENSEIGNER LES INFORMATIONS");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Trebuchet MS", Font.BOLD, 13));

		JLabel lblNomDuSite = new JLabel("Nom du site:");
		lblNomDuSite.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC,
				12));

		textFieldNomSt = new JTextField();
		textFieldNomSt.setColumns(10);

		JLabel lblVille = new JLabel("Ville:");
		lblVille.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));

		textFieldVilleS = new JTextField();
		textFieldVilleS.setColumns(10);

		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse
				.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));

		textFieldAdresse = new JTextField();
		textFieldAdresse.setColumns(10);

		JLabel lblActivitDuSite = new JLabel("Activit\u00E9 du Site:");
		lblActivitDuSite.setFont(new Font("Trebuchet MS", Font.BOLD
				| Font.ITALIC, 12));

		textFieldActivite1 = new JTextField();
		textFieldActivite1.setColumns(10);

		JButton btnSaveSite = new JButton("ENREGISTRER");
		btnSaveSite.setToolTipText("cliquer pour sauvegarder ");
		btnSaveSite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveNewSite();
			}
		});
		btnSaveSite.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		btnSaveSite.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		GroupLayout gl_formPanel = new GroupLayout(formPanel);
		gl_formPanel.setHorizontalGroup(gl_formPanel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_formPanel
								.createSequentialGroup()
								.addGap(10)
								.addComponent(lblTitre,
										GroupLayout.PREFERRED_SIZE, 267,
										GroupLayout.PREFERRED_SIZE))
				.addGroup(
						gl_formPanel
								.createSequentialGroup()
								.addComponent(lblNomDuSite)
								.addGap(18)
								.addComponent(textFieldNomSt,
										GroupLayout.PREFERRED_SIZE, 149,
										GroupLayout.PREFERRED_SIZE))
				.addGroup(
						gl_formPanel
								.createSequentialGroup()
								.addComponent(lblVille)
								.addGap(60)
								.addComponent(textFieldVilleS,
										GroupLayout.PREFERRED_SIZE, 149,
										GroupLayout.PREFERRED_SIZE))
				.addGroup(
						gl_formPanel
								.createSequentialGroup()
								.addComponent(lblAdresse)
								.addGap(42)
								.addComponent(textFieldAdresse,
										GroupLayout.PREFERRED_SIZE, 149,
										GroupLayout.PREFERRED_SIZE))
				.addComponent(lblActivitDuSite)
				.addGroup(
						gl_formPanel
								.createSequentialGroup()
								.addGap(91)
								.addComponent(textFieldActivite1,
										GroupLayout.PREFERRED_SIZE, 149,
										GroupLayout.PREFERRED_SIZE))
				.addGroup(
						Alignment.TRAILING,
						gl_formPanel.createSequentialGroup().addGap(175)
								.addComponent(btnSaveSite)
								.addContainerGap(21, Short.MAX_VALUE)));
		gl_formPanel
				.setVerticalGroup(gl_formPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_formPanel
										.createSequentialGroup()
										.addGap(11)
										.addComponent(lblTitre,
												GroupLayout.PREFERRED_SIZE, 27,
												GroupLayout.PREFERRED_SIZE)
										.addGap(11)
										.addGroup(
												gl_formPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_formPanel
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				lblNomDuSite))
														.addComponent(
																textFieldNomSt,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_formPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_formPanel
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				lblVille))
														.addComponent(
																textFieldVilleS,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_formPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_formPanel
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				lblAdresse))
														.addComponent(
																textFieldAdresse,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_formPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_formPanel
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				lblActivitDuSite))
														.addComponent(
																textFieldActivite1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(btnSaveSite)
										.addContainerGap(22, Short.MAX_VALUE)));
		formPanel.setLayout(gl_formPanel);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * cette methode permet de gérer la création et l'enregistrement d'un
	 * nouveau site par défaut en base de données
	 */
	public void saveNewSite() {
		Site site1 = new Site();
		site1.setNom(textFieldNomSt.getText());
		site1.setVille(textFieldVilleS.getText());
		site1.setAdresse(textFieldAdresse.getText());
		site1.setActivite1(textFieldActivite1.getText());
		if (textFieldNomSt.getText().isEmpty()
				|| textFieldVilleS.getText().isEmpty()
				|| textFieldAdresse.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"vous n'avez pas renseigné toutes les données");
		} else {

			int state = gestionsite.enregistrerServiceSite(site1);
			if (state == 1) {
				JOptionPane.showMessageDialog(null,
						" Le Site " + site1.getNom() + " "
								+ " enregistré avec succès ");
				textFieldNomSt.setText("");
				textFieldVilleS.setText("");
				textFieldAdresse.setText("");
				textFieldActivite1.setText("");

			} else {
				JOptionPane.showMessageDialog(null, "echec d'enregistrement");

			}
		}
	}

	/**
	 * cette methode permet de revenir à la page d'accueil de l'application
	 */
	public void mainPage() {
		this.setVisible(false);
		this.dispose();
		Accueil frame = new Accueil();
		frame.setVisible(true);
	}
}
