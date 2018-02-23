package cm.objis.annuaireetapprovisionnement.presentation.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import cm.objis.annuaireetapprovisionnement.dao.Dao;
import cm.objis.annuaireetapprovisionnement.dao.IDao;
import cm.objis.annuaireetapprovisionnement.domaine.Agence;
import cm.objis.annuaireetapprovisionnement.domaine.AgenceModel;
import cm.objis.annuaireetapprovisionnement.domaine.DefautSiteModel;
import cm.objis.annuaireetapprovisionnement.domaine.Site;
import cm.objis.annuaireetapprovisionnement.service.GestionSite;
import cm.objis.annuaireetapprovisionnement.service.IGestionSite;

import javax.swing.ImageIcon;
import java.awt.Toolkit;

/**
 * cette classe offre les possibilités permettant de mettre en oeuvre les
 * fonctionnalités gestion des sites de type agence (création, affichage,
 * suppression, modification)
 * 
 * @version 3.0
 * @author R. KOUANI
 */
public class AgenceForm extends JFrame {

	private static IDao dao = new Dao();
	private static IGestionSite gestionsite = new GestionSite(dao);

	private JPanel contentPane;
	private JTextField textFieldNomAg;
	private JTextField textFieldVille;
	private JTextField textFieldAdresse;
	private JTextField textFieldActivite1;
	private JTextField textFieldTypeA;
	private JTextField textFieldResponsable;
	private JTextField textFieldHoraires;
	private JPanel panelListe;
	private JScrollPane scrollPaneList;
	private JTable tableAgence;

	/**
	 * cette méthode et le constructeur de la classe et à ce titre, permet de
	 * créer la fenêtre offrant les fonctionnalités de gestion des sites de type
	 * agence
	 */
	public AgenceForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgenceForm.class.getResource("/main/resources/img/agence.jpg")));
		setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 15));
		setTitle("Gestion des agences");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel formPanel = new JPanel();
		formPanel.setBackground(new Color(211, 211, 211));
		formPanel.setBorder(new TitledBorder(new TitledBorder(null, "",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)), "Formulaire d'enregistrement ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JButton btnAccueil = new JButton("ACCUEIL");
		btnAccueil.setHorizontalAlignment(SwingConstants.LEFT);
		btnAccueil.setIcon(new ImageIcon(AgenceForm.class
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
		panelListe.setBorder(new TitledBorder(null, "LISTE DES AGENCES",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));

		JButton btnListeS = new JButton("LISTER & RAFRAICHIR");
		btnListeS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AgenceModel AGModel = new AgenceModel(gestionsite
						.lectureServiceAgences());

				tableAgence = new JTable(AGModel);
				scrollPaneList.setViewportView(tableAgence);

			}
		});
		btnListeS.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnListeS.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(formPanel, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(129)
									.addComponent(btnListeS, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
								.addComponent(panelListe, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)))
						.addComponent(btnAccueil))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelListe, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnListeS, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(5, Short.MAX_VALUE)
							.addComponent(formPanel, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(btnAccueil, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
		);
		panelListe.setLayout(new BorderLayout(0, 0));

		scrollPaneList = new JScrollPane();

		panelListe.add(scrollPaneList, BorderLayout.CENTER);

		JLabel lblTitre = new JLabel("VEUILLEZ RENSEIGNER LES INFORMATIONS");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Trebuchet MS", Font.BOLD, 13));

		JButton btnSaveSite = new JButton("ENREGISTRER");
		btnSaveSite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveNewSite();
			}
		});
		btnSaveSite.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		btnSaveSite.setFont(new Font("Trebuchet MS", Font.BOLD, 12));

		JLabel lblNomAgence = new JLabel("Nom de l'Agence:");
		lblNomAgence.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC,
				12));

		textFieldNomAg = new JTextField();
		textFieldNomAg.setColumns(10);

		JLabel lblVille = new JLabel("Ville:");
		lblVille.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));

		textFieldVille = new JTextField();
		textFieldVille.setColumns(10);

		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse
				.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));

		textFieldAdresse = new JTextField();
		textFieldAdresse.setColumns(10);

		JLabel lblActivit = new JLabel("Activit\u00E9:");
		lblActivit
				.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));

		textFieldActivite1 = new JTextField();
		textFieldActivite1.setColumns(10);

		JLabel lblTypeDeLagence = new JLabel("Type de l'Agence:");
		lblTypeDeLagence.setFont(new Font("Trebuchet MS", Font.BOLD
				| Font.ITALIC, 12));

		textFieldTypeA = new JTextField();
		textFieldTypeA.setColumns(10);

		JLabel lblResponsable = new JLabel("Responsable:");
		lblResponsable.setFont(new Font("Trebuchet MS",
				Font.BOLD | Font.ITALIC, 12));

		textFieldResponsable = new JTextField();
		textFieldResponsable.setColumns(10);

		JLabel lblHoraires = new JLabel("Horaires:");
		lblHoraires.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC,
				12));

		textFieldHoraires = new JTextField();
		textFieldHoraires.setColumns(10);
		GroupLayout gl_formPanel = new GroupLayout(formPanel);
		gl_formPanel
				.setHorizontalGroup(gl_formPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_formPanel
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblTitre,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE).addGap(5))
						.addGroup(
								gl_formPanel
										.createSequentialGroup()
										.addGroup(
												gl_formPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblNomAgence)
														.addComponent(lblVille)
														.addComponent(
																lblAdresse)
														.addComponent(
																lblActivit))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_formPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																textFieldActivite1,
																GroupLayout.DEFAULT_SIZE,
																153,
																Short.MAX_VALUE)
														.addComponent(
																textFieldVille,
																GroupLayout.DEFAULT_SIZE,
																153,
																Short.MAX_VALUE)
														.addComponent(
																textFieldNomAg,
																GroupLayout.DEFAULT_SIZE,
																153,
																Short.MAX_VALUE)
														.addComponent(
																textFieldAdresse,
																GroupLayout.DEFAULT_SIZE,
																153,
																Short.MAX_VALUE))
										.addContainerGap())
						.addGroup(
								gl_formPanel
										.createSequentialGroup()
										.addGroup(
												gl_formPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblTypeDeLagence)
														.addComponent(
																lblResponsable)
														.addComponent(
																lblHoraires))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_formPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																textFieldHoraires,
																GroupLayout.DEFAULT_SIZE,
																155,
																Short.MAX_VALUE)
														.addComponent(
																textFieldResponsable,
																GroupLayout.DEFAULT_SIZE,
																155,
																Short.MAX_VALUE)
														.addComponent(
																textFieldTypeA,
																GroupLayout.DEFAULT_SIZE,
																155,
																Short.MAX_VALUE))
										.addContainerGap())
						.addGroup(
								Alignment.TRAILING,
								gl_formPanel.createSequentialGroup()
										.addContainerGap(181, Short.MAX_VALUE)
										.addComponent(btnSaveSite)
										.addContainerGap()));
		gl_formPanel
				.setVerticalGroup(gl_formPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_formPanel
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblTitre,
												GroupLayout.PREFERRED_SIZE, 27,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_formPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNomAgence)
														.addComponent(
																textFieldNomAg,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_formPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblVille)
														.addComponent(
																textFieldVille,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_formPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblAdresse)
														.addComponent(
																textFieldAdresse,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_formPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblActivit)
														.addComponent(
																textFieldActivite1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_formPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblTypeDeLagence)
														.addComponent(
																textFieldTypeA,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_formPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblResponsable)
														.addComponent(
																textFieldResponsable,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_formPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblHoraires)
														.addComponent(
																textFieldHoraires,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED, 14,
												Short.MAX_VALUE)
										.addComponent(btnSaveSite)));
		formPanel.setLayout(gl_formPanel);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * cette methode permet de gérer la création et l'enregistrement d'un
	 * nouveau site de type agence en base de données
	 */
	public void saveNewSite() {
		Agence site1 = new Agence();
		site1.setNom(textFieldNomAg.getText());
		site1.setVille(textFieldVille.getText());
		site1.setAdresse(textFieldAdresse.getText());
		site1.setActivite1(textFieldActivite1.getText());
		site1.setTypeAgence(textFieldTypeA.getText());
		site1.setResponsableAgence(textFieldResponsable.getText());
		site1.setHoraires(textFieldHoraires.getText());

		if (textFieldNomAg.getText().isEmpty()
				|| textFieldVille.getText().isEmpty()
				|| textFieldAdresse.getText().isEmpty()
				|| textFieldTypeA.getText().isEmpty()
				|| textFieldResponsable.getText().isEmpty()
				|| textFieldHoraires.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"vous n'avez pas renseigné toutes les données");
		} else {

			int state = gestionsite.enregistrerServiceSite(site1);
			if (state == 1) {
				JOptionPane.showMessageDialog(null,
						"L'Agence " + site1.getNom() + " "
								+ " enregistré avec succès");
				textFieldNomAg.setText("");
				textFieldVille.setText("");
				textFieldAdresse.setText("");
				textFieldActivite1.setText("");
				textFieldTypeA.setText("");
				textFieldResponsable.setText("");
				textFieldHoraires.setText("");

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
