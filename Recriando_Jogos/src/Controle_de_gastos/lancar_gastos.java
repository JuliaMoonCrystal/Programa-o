package Controle_de_gastos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class lancar_gastos implements BoundaryContent, EventHandler<ActionEvent> {

	public  Control_Gastos controlNotas = new Control_Gastos();
	public  Gastos gast =new Gastos(0, 0, 0, 0, null);
	
	private ComboBox<Users> comboUsers = new ComboBox<>();
	
	private Label lblLuz = new Label("Conta de luz : ");
	private Label lblAgua = new Label("Conta de Água : ");
	private Label lblGas = new Label("Valor do Gás : ");
	private Label lblOutros = new Label("Gastos com outras coisas : ");
	
	TextField txtLuz= new TextField();
	TextField txtAgua= new TextField();
	TextField txtGas= new TextField();
	TextField txtOutros= new TextField();
	
	
	private Label lblUsers = new Label("Usuario : ");
	private Label lblData = new Label("Data : ");
	
	TextField txtDia= new TextField();
	private SimpleDateFormat sdt= new SimpleDateFormat("dd/mm/yy");
	
	
	private Button btnLancar_Gastos = new Button("Adicionar");
	
	private GridPane panGrid;
	private BorderPane Principal;

	private TableView tabela = new TableView();


	public lancar_gastos() {
		Principal = new BorderPane();
		panGrid = new GridPane();

		Principal.setStyle("-fx-padding: 10px");
       // Aqui o usuario pode colocar o valor da conta de Luz//
		panGrid.add(lblLuz, 0, 0);
		panGrid.add(txtLuz, 1, 0);
		
		// Aqui o usuario pode colocar o valor da conta de Agua//		
		panGrid.add(lblAgua, 0, 1);
		panGrid.add(txtAgua, 1, 1);
		
		// Aqui o usuario pode colocar o valor da conta de Gas//
		panGrid.add(lblGas, 0, 2);
		panGrid.add(txtGas, 1, 2);

		// Aqui o usuario pode colocar o valor de outras coisas//
		panGrid.add(lblOutros, 0, 3);
		panGrid.add(txtOutros, 1, 3);
		
		panGrid.add(lblUsers, 2, 0);
		panGrid.add(comboUsers, 3, 0);

		
		panGrid.add(lblData, 4, 0);
		panGrid.add(txtDia, 5, 0);

		panGrid.add(btnLancar_Gastos, 5, 1);

		panGrid.setHgap(10);
		panGrid.setVgap(10);


		Principal.setCenter(panGrid);
		Principal.setBottom(tabela);
		addTableColluns();
		 	
	}
	
	//aqui estamos adicionando as colunas na tabela//
	public void addTableColluns() {
		TableColumn<Gastos,String> columLuz= new TableColumn("Luz");
		columLuz.setCellValueFactory(new PropertyValueFactory<Gastos,String>("Luz"));
		
		TableColumn<Gastos,String> columAgua= new TableColumn("Água");
		columLuz.setCellValueFactory(new PropertyValueFactory<Gastos,String>("Água"));
		
		TableColumn<Gastos,String> columGas= new TableColumn("Gás");
		columLuz.setCellValueFactory(new PropertyValueFactory<Gastos,String>("Gás"));
		
		TableColumn<Gastos,String> columOutros= new TableColumn("Outras despesas");
		columLuz.setCellValueFactory(new PropertyValueFactory<Gastos,String>("Outras despesas"));
		
		TableColumn<Gastos,Date> columData= new TableColumn("Data");
		columLuz.setCellValueFactory(new PropertyValueFactory<Gastos,String>("Data"));
	  
		tabela.getColumns().addAll(columLuz,columAgua,columGas,columOutros,columData);
		
	}

	public Pane generateForm() {
		return Principal;
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnLancar_Gastos) {
			//this.Control_Gastos.lancar_Gastos();
			JOptionPane.showMessageDialog(null, "Gastos inseridas com Sucesso");
		}
		
	}

}
