/**
 * 
 */
package cm.objis.annuaireetapprovisionnement.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author R. KOUANI classe permettant la mise en oeuvre du pool de connexion à
 *         la base de données MySQL
 * 
 */
public class MySQLconnection {
	// information d'accès à la base de données
	public static String url = "jdbc:mysql://localhost/annuaireetapprovisionnement";
	public static String login = "root";
	public static String passwd = "Constyk@mga";
	public static Connection connection;

	/**
	 * methode de connection elle ne prend rien en paramètre
	 * 
	 * @return une connection
	 */
	public static Connection getInstance() {
		if (connection == null) {

			try {
				connection = DriverManager.getConnection(url, login, passwd);
				System.out.println("connection réussie");
			} catch (SQLException e) {
				System.out.println("problème de connexion");
			}

		}

		return connection;

	}

}
