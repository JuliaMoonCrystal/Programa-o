package Controle_de_gastos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javafx.collections.ObservableList;



public class GastosDaoImp implements GastosDAO {

private Connection c;
	
	public  GastosDaoImp() throws ClassNotFoundException, SQLException {
		IGenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}
	
	@Override
	public List<Users> pesquisarPorDia(Gastos gas) {
    
		return null;
	}

	public void inserirGastos(ObservableList<Gastos> lista) {
		
	}

}
