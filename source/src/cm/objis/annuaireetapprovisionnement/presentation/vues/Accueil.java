package cm.objis.annuaireetapprovisionnement.presentation.vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/**
 * cette classe offre les possibilités permettant d'acceder aux fonctionnalités
 * principales de l'application
 * 
 * @version 3.0
 * @author R. KOUANI
 * 
 */
public class Accueil extends JFrame {

	private JPanel contentPane;
	private JMenuItem mntmDeconnexion;
	private JComboBox cbSiteType;
	private JButton btAddNewSite;
	private JButton btListSites;

	/**
	 * cette méthode et le constructeur de la classe et à ce titre, permet de
	 * créer la fenêtre d'accueil de l'application
	 */
	public Accueil() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				Accueil.class.getResource("/main/resources/img/sites.jpg")));
		setTitle("Accueil:Annuaire et Approvisionnement");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 376);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAdmin = new JMenu("Admin");
		mnAdmin.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		mnAdmin.setIcon(new ImageIcon(Accueil.class
				.getResource("/main/resources/img/adminico.jpg")));
		menuBar.add(mnAdmin);

		JMenuItem mntmUtilisateurs = new JMenuItem("Utilisateurs");
		mntmUtilisateurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "disponible bientôt");
			}
		});
		mntmUtilisateurs.setFont(new Font("Trebuchet MS", Font.BOLD
				| Font.ITALIC, 13));
		mntmUtilisateurs.setIcon(new ImageIcon(Accueil.class
				.getResource("/main/resources/img/usersico.png")));
		mnAdmin.add(mntmUtilisateurs);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		mnAdmin.add(separator);

		mntmDeconnexion = new JMenuItem("Deconnexion");
		mntmDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOut();

			}
		});
		mntmDeconnexion.setFont(new Font("Trebuchet MS", Font.BOLD
				| Font.ITALIC, 13));
		mntmDeconnexion.setIcon(new ImageIcon(Accueil.class
				.getResource("/main/resources/img/logoutico.jpg")));
		mnAdmin.add(mntmDeconnexion);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		mnAdmin.add(separator_1);

		JMenu mnTraitement = new JMenu("Traitement");
		mnTraitement.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		mnTraitement.setIcon(new ImageIcon(Accueil.class
				.getResource("/main/resources/img/traitementico.jpg")));
		menuBar.add(mnTraitement);

		JMenu mnGestion = new JMenu("Gestion");
		mnGestion
				.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		mnGestion.setIcon(new ImageIcon(Accueil.class
				.getResource("/main/resources/img/addico.jpg")));
		mnTraitement.add(mnGestion);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.BLACK);
		mnGestion.add(separator_4);

		JMenuItem mntmSiteParDfaut = new JMenuItem("Site par d\u00E9faut");
		mntmSiteParDfaut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageDefaultSite();
			}
		});
		mntmSiteParDfaut.setFont(new Font("Trebuchet MS", Font.BOLD
				| Font.ITALIC, 13));
		mnGestion.add(mntmSiteParDfaut);

		JSeparator separator_9 = new JSeparator();
		separator_9.setBackground(Color.BLACK);
		mnGestion.add(separator_9);

		JMenuItem mntmAgence = new JMenuItem("Agence");
		mntmAgence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageAgence();
			}
		});
		mntmAgence
				.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		mnGestion.add(mntmAgence);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBackground(Color.BLACK);
		mnGestion.add(separator_6);

		JMenuItem mntmLocal = new JMenuItem("Local");
		mntmLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageLocal();
			}
		});
		mntmLocal
				.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		mnGestion.add(mntmLocal);

		JSeparator separator_7 = new JSeparator();
		separator_7.setBackground(Color.BLACK);
		mnGestion.add(separator_7);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		mnTraitement.add(separator_2);

		JMenu mnReporting = new JMenu("Reporting");
		mnReporting.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC,
				13));
		mnReporting.setIcon(new ImageIcon(Accueil.class
				.getResource("/main/resources/img/listico.png")));
		mnTraitement.add(mnReporting);

		JSeparator separator_11 = new JSeparator();
		separator_11.setBackground(Color.BLACK);
		mnReporting.add(separator_11);

		JMenuItem mntmSiteParDfaut_1 = new JMenuItem("Site par d\u00E9faut");
		mntmSiteParDfaut_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Disponible bientôt");
			}
		});
		mntmSiteParDfaut_1.setFont(new Font("Trebuchet MS", Font.BOLD
				| Font.ITALIC, 13));
		mnReporting.add(mntmSiteParDfaut_1);

		JSeparator separator_10 = new JSeparator();
		separator_10.setBackground(Color.BLACK);
		mnReporting.add(separator_10);

		JMenuItem mntmAgence_1 = new JMenuItem("Agence");
		mntmAgence_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Disponible bientôt");
			}
		});
		mntmAgence_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC,
				13));
		mnReporting.add(mntmAgence_1);

		JSeparator separator_12 = new JSeparator();
		separator_12.setBackground(Color.BLACK);
		mnReporting.add(separator_12);

		JMenuItem mntmLocal_1 = new JMenuItem("Local");
		mntmLocal_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Disponible bientôt");
			}
		});
		mntmLocal_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC,
				13));
		mnReporting.add(mntmLocal_1);

		JSeparator separator_13 = new JSeparator();
		separator_13.setBackground(Color.BLACK);
		mnReporting.add(separator_13);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);
		mnTraitement.add(separator_3);

		JMenuItem menuItem_1 = new JMenuItem("");
		menuBar.add(menuItem_1);
		contentPane = new JPanel();
		contentPane
				.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btLogOut = new JButton("Se d\u00E9connecter");
		btLogOut.setToolTipText("cliquer ici pour vous d\u00E9connecter");
		btLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOut();

			}

		});

		btAddNewSite = new JButton("GESTION DE SITE");
		btAddNewSite.setToolTipText("cliquer ici pour gerer vos site");
		btAddNewSite.setBorder(new MatteBorder(3, 2, 3, 2, (Color) new Color(
				135, 206, 235)));
		btAddNewSite.setHorizontalAlignment(SwingConstants.LEFT);
		btAddNewSite.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btAddNewSite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choix = cbSiteType.getSelectedIndex();
				if (choix == 0) {
					manageDefaultSite();
				} else if (choix == 1) {
					manageAgence();

				} else {
					manageLocal();
				}

			}
		});
		btAddNewSite.setIcon(new ImageIcon(Accueil.class
				.getResource("/main/resources/img/add1.jpg")));
		btAddNewSite.setBounds(14, 85, 192, 69);
		contentPane.add(btAddNewSite);
		btLogOut.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(30,
				144, 255)));
		btLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btLogOut.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 10));
		btLogOut.setIcon(new ImageIcon(Accueil.class
				.getResource("/main/resources/img/logoutico.jpg")));
		btLogOut.setBounds(442, 8, 117, 26);
		contentPane.add(btLogOut);

		cbSiteType = new JComboBox();
		cbSiteType.setForeground(new Color(233, 150, 122));
		cbSiteType
				.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
		cbSiteType.setModel(new DefaultComboBoxModel(new String[] {
				"Site par d\u00E9faut", "Agence", "Local" }));
		cbSiteType.setSelectedIndex(0);
		cbSiteType.setBounds(143, 47, 137, 26);
		contentPane.add(cbSiteType);

		JLabel lblNewLabel = new JLabel("CHOISIR LE TYPE DE SITE ET LE MODULE");
		lblNewLabel.setBackground(new Color(119, 136, 153));
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 10, 346, 37);
		contentPane.add(lblNewLabel);

		JLabel lblTypeDeSite = new JLabel("TYPE DE SITE:");
		lblTypeDeSite.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC,
				14));
		lblTypeDeSite.setBounds(20, 48, 111, 24);
		contentPane.add(lblTypeDeSite);

		JLabel label = new JLabel("");
		label.setForeground(new Color(0, 100, 0));
		label.setIcon(new ImageIcon(Accueil.class
				.getResource("/main/resources/img/locale.jpg")));
		label.setBounds(206, 10, 353, 296);
		contentPane.add(label);

		btListSites = new JButton("REPORTING");
		btListSites
				.setToolTipText("cliquer ici pour g\u00E9n\u00E9rer le reporting de vos sites");
		btListSites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choix = cbSiteType.getSelectedIndex();
				if (choix == 0) {
					JOptionPane.showMessageDialog(null,
							"module en construction");
				} else if (choix == 1) {
					JOptionPane.showMessageDialog(null,
							"module en construction");
				}

				else {
					JOptionPane.showMessageDialog(null,
							"module en construction");
				}
			}
		});
		btListSites.setBorder(new MatteBorder(3, 2, 3, 2, (Color) new Color(32,
				178, 170)));
		btListSites.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btListSites.setHorizontalAlignment(SwingConstants.LEFT);
		btListSites.setIcon(new ImageIcon(Accueil.class
				.getResource("/main/resources/img/list1.png")));
		btListSites.setBounds(14, 181, 192, 69);
		contentPane.add(btListSites);
	}

	/**
	 * cette methode permet d'invoquer la fenêtre de gestion des sites par
	 * défaut
	 */
	public void manageDefaultSite() {
		this.setVisible(false);
		this.dispose();
		DefaultSiteForm frame1 = new DefaultSiteForm();
		frame1.setVisible(true);
	}

	/**
	 * cette methode permet d'invoquer la fenêtre de gestion des agences
	 */
	public void manageAgence() {
		this.setVisible(false);
		this.dispose();
		AgenceForm frame1 = new AgenceForm();
		frame1.setVisible(true);
	}

	/**
	 * cette methode permet d'invoquer la fenêtre de gestion des agences
	 */
	public void manageLocal() {
		this.setVisible(false);
		this.dispose();
		LocalForm frame2 = new LocalForm();
		frame2.setVisible(true);
	}

	/**
	 * cette methode permet de gérer la déconnexion
	 */
	public void logOut() {
		JOptionPane.showMessageDialog(null, " $$$ A bientôt $$$");
		closeThisWindow();
		AnnuaireEtApprovisionnement window = new AnnuaireEtApprovisionnement();
		window.getfAuthentification().setVisible(true);

	}

	/**
	 * cette methode permet de fermer la fenêtre d'accueil
	 */
	public void closeThisWindow() {
		this.setVisible(false);
		this.dispose();

	}
}
