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
	
//	public List<Gastos> updateGastosList(Disciplina disc,Avaliacao av) {
//		GastosDaoImp nDAO;
//		try {
//			nDAO = new GastosDaoImp();
//			lista.clear();
//		List<Gastos> listaGastos = nDAO.pesquisarPorDiscEAv(disc, av);
//		for (Gastos t : listaGastos) {
//				lista.add(t);
//			}
//		} catch (ClassNotFoundException | SQLException | DAOException e) {
//			e.printStackTrace();		
//		}
//		return lista;
//	}
//	
//	public void lancarNotas() {
//		GastosDaoImp nDAO;
//		try {
//			nDAO = new GastosDaoImp();
//			nDAO.inserirGastos(this.getLista());;
//		} catch (ClassNotFoundException | SQLException | DAOException e) {
//			e.printStackTrace();		
//		}
//	}
}
