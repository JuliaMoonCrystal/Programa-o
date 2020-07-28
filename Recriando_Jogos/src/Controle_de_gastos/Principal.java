package Controle_de_gastos;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Principal extends Application implements EventHandler<ActionEvent>{
   
	private MenuBar barraMenu = new MenuBar();
	
	private Menu mnuLancar_gastos = new Menu("Gastos");
	private Menu relatorios = new Menu("Relatórios");
	
	private MenuItem lancar_gastos = new MenuItem("Lancar Gastos");
	private MenuItem gerar_relatorios = new MenuItem("Relatorio de Gastos");
	
	private BorderPane panPrincipal = new BorderPane();
	
	private Map<MenuItem, BoundaryContent> telas = new HashMap<>();
	
	@Override
	public void start(Stage stage) throws Exception {
		panPrincipal.setTop(barraMenu);
		generateMenus();
		Scene scn = new Scene(panPrincipal, 800, 600);
		
		stage.setScene(scn);
		stage.setTitle("Controle de Gastos ");
		stage.show();
	}

	private void generateMenus() {
		//  barra de menus 
				barraMenu.getMenus().addAll(mnuLancar_gastos,relatorios);
				mnuLancar_gastos.getItems().addAll(lancar_gastos);
				relatorios.getItems().addAll(gerar_relatorios);
				
				
				// gerar as telas 
				telas.put(lancar_gastos, new lancar_gastos());
				telas.put(gerar_relatorios, new gerar_relatorios ());
				
				
				Set<MenuItem> keys = telas.keySet();
				for(MenuItem menu : keys) { 
					menu.addEventHandler(ActionEvent.ANY, this);
				}
			}
	
	// Ao clicar em um item uma tela é gerada
		@Override
		public void handle(ActionEvent event) {
				BoundaryContent tela = telas.get(event.getTarget());
				if (tela != null) { 
					panPrincipal.setCenter(tela.generateForm());				
				}			
		}
		public static void main(String[] args) {
			Principal.launch(args);
		}
	}
	

