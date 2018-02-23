package cm.objis.annuaireetapprovisionnement.presentation.vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import cm.objis.annuaireetapprovisionnement.dao.Dao;
import cm.objis.annuaireetapprovisionnement.dao.IDao;
import cm.objis.annuaireetapprovisionnement.service.GestionSite;
import cm.objis.annuaireetapprovisionnement.service.IGestionSite;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.JCheckBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.UIManager;
import java.awt.event.MouseMotionAdapter;

public class AnnuaireEtApprovisionnement {

	private JFrame fAuthentification;
	private JTextField textFieldLogin;
	private JPasswordField passwordField;
	private IDao dao;
	private IGestionSite service;
	private JLabel lblMessage_1;
	private JCheckBox chckbxVue;
	private JButton btnConnexion;

	JFrame getfAuthentification() {
		return fAuthentification;
	}

	private void setfAuthentification(JFrame fAuthentification) {
		this.fAuthentification = fAuthentification;
	}

	/**
	 * classe principale de l'application
	 */
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnnuaireEtApprovisionnement window = new AnnuaireEtApprovisionnement();
					window.fAuthentification.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cette méthode permet de créer la fenêtre principale de l'application.
	 */
	public AnnuaireEtApprovisionnement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fAuthentification = new JFrame();
		fAuthentification.setResizable(false);
		fAuthentification.setIconImage(Toolkit.getDefaultToolkit().getImage(
				AnnuaireEtApprovisionnement.class
						.getResource("/main/resources/img/aut3.jpg")));
		fAuthentification.setTitle("Authentification");
		fAuthentification.setBounds(100, 100, 450, 300);
		fAuthentification.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fAuthentification.getContentPane().setLayout(null);

		JLabel lblTitre = new JLabel("GEREZ EFFICACEMENT VOS SITES");
		lblTitre.setForeground(new Color(0, 128, 128));
		lblTitre.setIcon(null);
		lblTitre.setBackground(new Color(0, 0, 255));
		lblTitre.setFont(new Font("Microsoft Uighur", Font.BOLD, 27));
		lblTitre.setBounds(58, 11, 352, 46);
		fAuthentification.getContentPane().add(lblTitre);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 220));
		panel.setForeground(new Color(176, 196, 222));
		panel.setBorder(new CompoundBorder());
		panel.setBounds(23, 42, 381, 223);
		fAuthentification.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(0, -13, 222, 212);
		panel.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(AnnuaireEtApprovisionnement.class
				.getResource("/main/resources/img/auth2.png")));

		JLabel lblLogin = new JLabel("LOGIN:");
		lblLogin.setBounds(112, 38, 61, 46);
		panel.add(lblLogin);
		lblLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 15));

		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(112, 84, 84, 50);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 15));

		textFieldLogin = new JTextField();
		textFieldLogin.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				textFieldLogin.setToolTipText("Votre login ici: objiscam ou ckroyl");
			}
		});

		textFieldLogin.setBounds(204, 48, 162, 31);
		panel.add(textFieldLogin);
		textFieldLogin.setColumns(10);

		passwordField = new JPasswordField();

		passwordField.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				passwordField.setToolTipText("Votre mot de passe ici: objis ou Royl");
			}
		});
		passwordField.setBounds(204, 96, 160, 31);
		panel.add(passwordField);

		btnConnexion = new JButton("ENTRER");
		btnConnexion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				loginEvents();
			}
		});
		btnConnexion.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnConnexion.setToolTipText("cliquer ici pour commencer!!");
			}
		});

		btnConnexion.setBounds(275, 189, 89, 23);
		panel.add(btnConnexion);
		btnConnexion.setFont(new Font("Trebuchet MS", Font.BOLD, 13));

		lblMessage_1 = new JLabel("Renseignez vos login et mot de passe");
		lblMessage_1.setBounds(122, 152, 259, 31);
		panel.add(lblMessage_1);
		lblMessage_1.setForeground(Color.PINK);

		chckbxVue = new JCheckBox("Visualiser");
		chckbxVue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxVue.isSelected()) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar((char) '*');
				}

			}
		});
		chckbxVue
				.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 11));
		chckbxVue.setBounds(301, 129, 97, 23);
		panel.add(chckbxVue);
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				loginEvents();
			}

		});
		dao = new Dao();
		service = new GestionSite(dao);

	}

	/**
	 * cette methode permet de mettre en oeuvre les actions exécutées lorsqu'on
	 * clique sur le bouton "Entrer" ou lorsqu'on appuie sur la touche "Entrer"
	 * du clavier
	 */
	public void loginEvents() {
		String login = textFieldLogin.getText();
		char[] motDePasse = passwordField.getPassword();
		String passWord = String.valueOf(motDePasse);

		int state = service.loginService(login, passWord);
		if (state >= 1) {

			fAuthentification.setVisible(false);
			Accueil frame = new Accueil();
			frame.setVisible(true);

		} else {
			if (textFieldLogin.getText().isEmpty()
					|| String.valueOf(passwordField.getPassword()).isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"vous n'avez pas renseigné toutes les données");
				textFieldLogin.setText(" votre login ici");
				passwordField.setText("votre mot de passe");

			} else {

				lblMessage_1
						.setText("login ou mot de passe invalide réessayer..");
				lblMessage_1.setForeground(Color.RED);
				textFieldLogin.setText(null);
				passwordField.setText(null);
			}
		}

	}

}
