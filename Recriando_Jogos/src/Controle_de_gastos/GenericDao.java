package Controle_de_gastos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Controle_de_gastos.IGenericDao;

public class GenericDao implements IGenericDao {

	private Connection c;

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=av2_av3labBD;namedPipes=true",
				"tempesta","gamamori");
		System.out.println("Conexão OK");
		return c;
	}
}
