package Assignment2Lab;


import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class registration extends Application{

	
	@Override
	public void start(Stage primaryStage) {
		
		VBox mainContainer = new VBox();
		
		mainContainer.setPadding(new Insets(10,10,10,10));
		
		Label labelName = new Label("Name:");
		labelName.setPrefWidth(60);
		TextField textName = new TextField ();
		textName.setPrefWidth(300);
		HBox hbName = new HBox();
		hbName.getChildren().addAll(labelName, textName);
		hbName.setSpacing(40);
		hbName.setPadding(new Insets(0,0,10,0));
		mainContainer.getChildren().add(hbName);
		
		Label labelEmail = new Label("Email:");
		labelEmail.setPrefWidth(60);
		TextField textEmail = new TextField ();
		textEmail.setPrefWidth(300);
		HBox hbEmail = new HBox();
		hbEmail.getChildren().addAll(labelEmail, textEmail);
		hbEmail.setSpacing(40);
		hbEmail.setPadding(new Insets(0,0,10,0));
		mainContainer.getChildren().add(hbEmail);
		
		Label labelPhone = new Label("Phone:");
		labelPhone.setPrefWidth(60);
		TextField textPhone = new TextField ();
		textPhone.setPrefWidth(300);
		HBox hbPhone = new HBox();
		hbPhone.getChildren().addAll(labelPhone, textPhone);
		hbPhone.setSpacing(40);
		hbPhone.setPadding(new Insets(0,0,10,0));
		mainContainer.getChildren().add(hbPhone);
		
		Label labelPassword = new Label("Password:");
		labelPassword.setPrefWidth(60);
		TextField textPassword = new TextField ();
		textPassword.setPrefWidth(300);
		HBox hbPassword = new HBox();
		hbPassword.getChildren().addAll(labelPassword, textPassword);
		hbPassword.setSpacing(40);
		hbPassword.setPadding(new Insets(0,0,10,0));
		mainContainer.getChildren().add(hbPassword);

		Label labelConfirm = new Label("Confirm:");
		labelConfirm.setPrefWidth(60);
		TextField textConfirm = new TextField ();
		textConfirm.setPrefWidth(300);
		HBox hbConfirm = new HBox();
		hbConfirm.getChildren().addAll(labelConfirm, textConfirm);
		hbConfirm.setSpacing(40);
		hbConfirm.setPadding(new Insets(0,0,10,0));
		mainContainer.getChildren().add(hbConfirm);
		
		Label labelCombo = new Label("Country:");
		labelCombo.setPrefWidth(60);
		ComboBox comboBox = new ComboBox();
		comboBox.getItems().add("Lebanon");
		comboBox.getItems().add("USA");
		comboBox.getItems().add("UK");
		comboBox.setPromptText("Select...");
		HBox hbCombo = new HBox();
		hbCombo.getChildren().addAll(labelCombo, comboBox );
		hbCombo.setSpacing(40);
		hbCombo.setPadding(new Insets(0,0,10,0));
		mainContainer.getChildren().add(hbCombo);
		
		ToggleGroup group = new ToggleGroup();
		Label labelGender = new Label("Gender:");
		labelGender.setPrefWidth(60);
		RadioButton button1 = new RadioButton("Male");
		button1.setToggleGroup(group);
		button1.setSelected(true);
		RadioButton button2 = new RadioButton("Female");
		button2.setToggleGroup(group);
		HBox hbRadio = new HBox();
		hbRadio.getChildren().addAll(labelGender, button1, button2);
		hbRadio.setSpacing(40);
		hbRadio.setPadding(new Insets(0,0,10,0));
		mainContainer.getChildren().add(hbRadio);
		
		
		Label labelLanguage = new Label("Language:");
		labelLanguage.setPrefWidth(60);
		CheckBox checkBox1 = new CheckBox("Arabic");
		CheckBox checkBox2 = new CheckBox("English");
		CheckBox checkBox3 = new CheckBox("Spanish");
		HBox hbLangauge = new HBox();
		hbLangauge.getChildren().addAll(labelLanguage, checkBox1, checkBox2, checkBox3);
		hbLangauge.setSpacing(40);
		hbLangauge.setPadding(new Insets(0,0,10,0));
		mainContainer.getChildren().add(hbLangauge);
		
		
		Label labelTextarea = new Label("About You:");
		labelTextarea.setPrefWidth(60);
		labelTextarea.setPadding(new Insets(50,0,10,0));
		TextArea area = new TextArea();
		area.setText("Your Biogrraphy...");
	    area.setPrefColumnCount(15);
	    area.setPrefHeight(120);
	    area.setPrefWidth(300);
	    HBox hbTextArea = new HBox();
	    hbTextArea.getChildren().addAll(labelTextarea, area);
	    hbTextArea.setSpacing(40);
	    hbTextArea.setPadding(new Insets(0,0,10,0));
		mainContainer.getChildren().add(hbTextArea);
		
		
		Button btn = new Button("Register");
		btn.setPrefWidth(410);
		HBox hbBtn = new HBox();
		hbBtn.getChildren().addAll(btn);
		hbBtn.setSpacing(40);
		hbBtn.setPadding(new Insets(0,0,10,0));
		mainContainer.getChildren().add(hbBtn);
		
		Label labelError = new Label();
		HBox hberror = new HBox();
		hberror.getChildren().add(labelError);
		mainContainer.getChildren().add(hberror);
		
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	final Pattern pattern = Pattern.compile("[a-zA-Z]");
		    	TextFormatter<?> formatter = new TextFormatter<>(change -> {
		    	    if (pattern.matcher(change.getControlNewText()).matches()) {
		    	        
		    	        return change;
		    	    } else {
		    	        
		    	        return null;
		    	    }
		    	});
		    	TextField textField = new TextField();
		    	textField.setTextFormatter(formatter);
		    }
		});

		
		Scene scene = new Scene(mainContainer, 420, 600);
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Assignment 2");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
