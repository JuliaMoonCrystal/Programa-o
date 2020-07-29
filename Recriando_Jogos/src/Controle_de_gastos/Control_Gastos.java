package Controle_de_gastos;

import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Control_Gastos {
	private ObservableList<Gastos> lista = FXCollections.observableArrayList();
	
	public ObservableList<Gastos> getLista() {
		return lista;
	}
	
//	public void lancar_Gastos() {
//		GastosDaoImp nDAO;
//		try {
//			nDAO = new GastosDaoImp();
//			nDAO.inserirGastos(this.getLista());;
//		} catch (ClassNotFoundException | SQLException | DAOException e) {
//			e.printStackTrace();		
//		}
//	}
}
