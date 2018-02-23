package cm.objis.annuaireetapprovisionnement.presentation.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
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
import cm.objis.annuaireetapprovisionnement.domaine.Local;
import cm.objis.annuaireetapprovisionnement.domaine.LocalModel;
import cm.objis.annuaireetapprovisionnement.service.GestionSite;
import cm.objis.annuaireetapprovisionnement.service.IGestionSite;

import javax.swing.UIManager;
import java.awt.Toolkit;

/**
 * cette classe offre les possibilités permettant de mettre en oeuvre les
 * fonctionnalités gestion des sites de type local (création, affichage,
 * suppression, modification)
 * 
 * @version 3.0
 * @author R. KOUANI
 * 
 */
public class LocalForm extends JFrame {

	private static IDao dao = new Dao();
	private static IGestionSite gestionsite = new GestionSite(dao);

	private JPanel contentPane;
	private JTextField textFieldNomLc;
	private JTextField textFieldVille;
	private JTextField textFieldAdresse;
	private JTextField textFieldActivite1;
	private JTextField textFieldTypeL;
	private JTextField textFieldResponsable;
	private JTextField textFieldSuperficie;
	private JPanel panelListe;
	private JScrollPane scrollPaneList;
	private JTable tableLocal;

	/**
	 * cette méthode et le constructeur de la classe et à ce titre, permet de
	 * créer la fenêtre offrant les fonctionnalités de gestion des sites de type
	 * local
	 */
	public LocalForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				LocalForm.class.getResource("/main/resources/img/locale.jpg")));
		setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 15));
		setTitle("Gestion des Locaux");
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
		btnAccueil.setIcon(new ImageIcon(LocalForm.class
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
		panelListe.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "LISTE DES LOCAUX",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64,
						64)));

		JButton btnListeS = new JButton("LISTER & RAFRAICHIR");
		btnListeS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LocalModel LCModel = new LocalModel(gestionsite
						.lectureServiceLocaux());

				tableLocal = new JTable(LCModel);
				scrollPaneList.setViewportView(tableLocal);

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
																		.addGap(6)
																		.addComponent(
																				formPanel,
																				GroupLayout.PREFERRED_SIZE,
																				285,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																btnAccueil))
										.addPreferredGap(
												ComponentPlacement.RELATED, 10,
												Short.MAX_VALUE)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(129)
																		.addComponent(
																				btnListeS,
																				GroupLayout.PREFERRED_SIZE,
																				145,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																panelListe,
																GroupLayout.DEFAULT_SIZE,
																413,
																Short.MAX_VALUE))
										.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
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
																355,
																GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnListeS,
																				GroupLayout.PREFERRED_SIZE,
																				21,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(
																				23,
																				Short.MAX_VALUE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnAccueil)))));
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

		JLabel lblNomLocal = new JLabel("Nom de l'Agence:");
		lblNomLocal.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC,
				12));

		textFieldNomLc = new JTextField();
		textFieldNomLc.setColumns(10);

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

		JLabel lblTypeDeLocal = new JLabel("Type de l'Agence:");
		lblTypeDeLocal.setFont(new Font("Trebuchet MS",
				Font.BOLD | Font.ITALIC, 12));

		textFieldTypeL = new JTextField();
		textFieldTypeL.setColumns(10);

		JLabel lblResponsable = new JLabel("Responsable:");
		lblResponsable.setFont(new Font("Trebuchet MS",
				Font.BOLD | Font.ITALIC, 12));

		textFieldResponsable = new JTextField();
		textFieldResponsable.setColumns(10);

		JLabel lblSuperficie = new JLabel("Superficie (en m2):");
		lblSuperficie.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC,
				12));

		textFieldSuperficie = new JTextField();
		textFieldSuperficie.setColumns(10);
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
																lblNomLocal)
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
																textFieldNomLc,
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
																lblTypeDeLocal)
														.addComponent(
																lblResponsable)
														.addComponent(
																lblSuperficie))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_formPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																textFieldSuperficie,
																GroupLayout.DEFAULT_SIZE,
																155,
																Short.MAX_VALUE)
														.addComponent(
																textFieldResponsable,
																GroupLayout.DEFAULT_SIZE,
																155,
																Short.MAX_VALUE)
														.addComponent(
																textFieldTypeL,
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
																lblNomLocal)
														.addComponent(
																textFieldNomLc,
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
																lblTypeDeLocal)
														.addComponent(
																textFieldTypeL,
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
																lblSuperficie)
														.addComponent(
																textFieldSuperficie,
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
	 * nouveau site de type local en base de données
	 */
	public void saveNewSite() {
		Local site1 = new Local();
		site1.setNom(textFieldNomLc.getText());
		site1.setVille(textFieldVille.getText());
		site1.setAdresse(textFieldAdresse.getText());
		site1.setActivite1(textFieldActivite1.getText());
		site1.setTypeLocal(textFieldTypeL.getText());
		site1.setResponsableLocal(textFieldResponsable.getText());
		site1.setSuperficieLocal(Integer.parseInt(textFieldSuperficie.getText()));

		if (textFieldNomLc.getText().isEmpty()
				|| textFieldVille.getText().isEmpty()
				|| textFieldAdresse.getText().isEmpty()
				|| textFieldTypeL.getText().isEmpty()
				|| textFieldResponsable.getText().isEmpty()
				|| textFieldSuperficie.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"vous n'avez pas renseigné toutes les données");
		} else {

			int state = gestionsite.enregistrerServiceSite(site1);
			if (state == 1) {
				JOptionPane.showMessageDialog(null,
						" Le Local " + site1.getNom() + " "
								+ " enregistré avec succès");
				textFieldNomLc.setText("");
				textFieldVille.setText("");
				textFieldAdresse.setText("");
				textFieldActivite1.setText("");
				textFieldTypeL.setText("");
				textFieldResponsable.setText("");
				textFieldSuperficie.setText("");

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
