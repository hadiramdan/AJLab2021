package assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main  extends Application{

	@Override
	public void start(Stage primaryStage) {
		 File fileDirectory = new File("C:\\javafx\\users.txt");
		 //System.out.println(fileDirectory.getName());
		
		
		VBox mainBox = new VBox();
		mainBox.setPadding(new Insets(30, 30, 30, 30));
		
		HBox loginBox = new HBox();
		Label title  = new Label();
		title.setText("Login");
		title.setFont(Font.font ("Verdana", 20));
		loginBox.setPadding(new Insets(0, 0, 20, 0));
		loginBox.getChildren().add(title);
		
		HBox usernameBox = new HBox();
		TextField username = new TextField();
		Label usernameLabel = new Label();
		usernameLabel.setText("Username: ");
		usernameBox.setPadding(new Insets(0, 0, 5, 0));
		usernameBox.getChildren().addAll(usernameLabel, username);
		
		HBox passwordBox = new HBox();
		TextField password = new TextField();
		Label passwordLabel = new Label();
		passwordLabel.setText("Password: ");
		passwordBox.setPadding(new Insets(0, 0, 5, 0));
		passwordBox.getChildren().addAll(passwordLabel, password);
		
		HBox submitBox = new HBox();
		Button submitBtn = new Button();
		submitBtn.setText("Login");
		submitBox.setAlignment(Pos.CENTER);
		submitBox.getChildren().add(submitBtn);
		
		
		
		submitBtn.setOnAction(e -> {
			 try {
					Scanner scannerFile = new Scanner(fileDirectory);
					while(scannerFile.next() != username.getText()) {
						System.out.println("Wrong username.");
						scannerFile.next();
					}
					while(scannerFile.next() != password.getText()){
						System.out.println("Wrong password");
						scannerFile.next();
					}
					while(scannerFile.next() == username.getText() && scannerFile.next() == password.getText()){
						System.out.println("Successfully logged in");
						scannerFile.next();
					}
						System.out.println(scannerFile.next());
						scannerFile.nextLine();
					
				} catch (FileNotFoundException e1) {
					System.out.println("File not found");
				} 
		});
		
		
		mainBox.getChildren().addAll(loginBox, usernameBox, passwordBox, submitBox);
		Scene scene = new Scene(mainBox, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Assignment 4");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
