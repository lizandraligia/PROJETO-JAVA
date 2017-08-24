package br.ufrpe.LsCine.gui;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;

import br.ufrpe.LsCine.negocio.Fachada;
import br.ufrpe.LsCine.negocio.beans.Filme;
import br.ufrpe.LsCine.negocio.beans.Ingresso;
import br.ufrpe.LsCine.negocio.beans.Sessao;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ComprarIngressoController{
	
private Fachada fachada = Fachada.getInstancia();
	
	@FXML JFXToggleButton Meia;
	@FXML Label labelFilme, labelSala, labelHora;
	@FXML JFXButton confirma;
	@FXML GridPane gridCadeiras;

	private Sessao sessao;
	int cadeira = -1;
	
	@FXML
	public void initialize() {
		
	}
	@FXML 
	public void handleMouseClick(MouseEvent arg0) throws IOException {

	}
	public void atualizarSessao() {
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 20; c++) {
				int number = 20 * r + c;
				if (sessao.getCadeira(number)){
					Button button = new Button();
					button.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
					button.setMinHeight(20);
					button.setMinWidth(20);
					button.setDisable(true);
					gridCadeiras.add(button, c, r);
				} 
				else{
					Button button = new Button();
					button.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
					button.setMinHeight(20);
					button.setMinWidth(20);
					button.setId(String.valueOf(number));
					button.setOnMouseClicked(new EventHandler<MouseEvent>(){
						
						@Override
						public void handle(MouseEvent event) {	
							cadeira = Integer.parseInt(button.getId());
							//labelErro.setText("Você selecionou a cadeira: " + cadeira);
							//labelValor.setText("R$" + valor);
							Meia.setDisable(false);
							valor();
							confirma.setDisable(false);
						}
					});
					gridCadeiras.add(button, c, r);
				}
			}
		}

	}	
	
	public void setSessao(Sessao selecionado) {
		this.sessao = selecionado;
		labelFilme.setText(this.sessao.getNome());
		labelSala.setText(this.sessao.getTipo());
		labelHora.setText(this.sessao.getHrinicio());
		atualizarSessao();
	}
	
	public void comprar(){		
		try{
			int x;
			if(Meia.isSelected()){
				x = 2;
			}else{
				x = 1;
			}
			//Sessao sessao = fachada.getInstancia().getCadastroSe().procurarID(Integer.parseInt(IDS.getText()));
			//int lugar = this.assento(Letra.getText(), Integer.parseInt(Num.getText()));
			
			int id = fachada.getInstancia().getCadastroI().listar().size();
			Sessao s = this.sessao;
			Ingresso ingresso = new Ingresso(x, this.valor(), s, cadeira, id);
			Fachada.getInstancia().getCadastroI().cadastrar(ingresso);
			s.setCadeira(cadeira);
			Fachada.getInstancia().getCadastroSe().getRepositorioSessao().alterar(s);
			if(s.getCadeira(cadeira)){
				Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
				Stage stage = (Stage) dialogoInfo.getDialogPane().getScene().getWindow();
				stage.getIcons().add(new Image(this.getClass().getResource("/br/ufrpe/LsCine/imagens/Logo.png").toString()));
	        	dialogoInfo.setTitle("Compra realizada com sucesso!");
	        	dialogoInfo.setHeaderText(null);
	        	dialogoInfo.setContentText(" Filme: " + sessao.getNome() + " Valor: R$" + ingresso.getValor());
	        	dialogoInfo.showAndWait();
				atualizarSessao();	
			}
			if(!s.getCadeira(cadeira)){
				Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
				Stage stage = (Stage) dialogoInfo.getDialogPane().getScene().getWindow();
				stage.getIcons().add(new Image(this.getClass().getResource("/br/ufrpe/LsCine/imagens/Logo.png").toString()));
	        	dialogoInfo.setTitle("L's Cine");
	        	dialogoInfo.setHeaderText("Cadeira ocupada!");
	        	dialogoInfo.setContentText(null);
	        	dialogoInfo.showAndWait();
				atualizarSessao();
			}
	
									
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public float valor(){
		Date dia = new Date();
		int d = dia.getDay();
		if(d == 1 || d == 2){
			return 24;
		}
		if(d == 3){
			return 20;
		}
		if(d == 4 || d == 5 || d == 6 || d == 0){
			return 27;
		}
		return 0;
	}

	public void voltar(){
		try{
			Telas.getInstance().getMenu();
			System.out.println("funfou");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void filme(){
		try{
			Telas.getInstance().getTelaFilmes();
			System.out.println("funfou");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void sala(){
		try{
			Telas.getInstance().getTelaSalas();
			System.out.println("funfou");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void sessao(){
		try{
			Telas.getInstance().getTelaSessao();
			System.out.println("funfou");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void financeiro(){
		try{
			Telas.getInstance().getFinanceiro();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
