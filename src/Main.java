import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Create by hieuduong on 11/18/17
 *
 * CSC 201 - Assignment 17
 * Problem 17.1:
 *
 * (Create a text file) Write a program to create a file named Exercise17_01.txt if
 * it does not exist. Append new data to it if it already exists. Write 100 integers
 * created randomly into the file using text I/O. Integers are separated by a space.
 */

public class Main extends Application {

    protected Text text;
    protected Label status = new Label("Status");

    @Override
    public void start(Stage primaryStage) {

        // Create a pane
        BorderPane pane = new BorderPane();

        // Place nodes in the pane
        pane.setTop(getHBox());
        pane.setBottom(getSecondHBox());

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Input/Output file"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * Create Hbox
     * @return
     */
    private HBox getHBox() {
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: silver");

        Button b1 = new Button("Write To File");
        Button b2 = new Button("Read From File");
        hBox.getChildren().addAll(b1, b2);
        hBox.setAlignment(Pos.CENTER);

        String fileName = "Exercise17_01.txt";
        b1.setOnAction(e -> writeToFile(fileName));
        b2.setOnAction(e -> readFromFile(fileName));
        return hBox;
    }

    /**
     * Create the second Hbox
     * @return
     */
    private HBox getSecondHBox(){
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));

        hBox.getChildren().addAll(status);
        hBox.setAlignment(Pos.CENTER);
        return hBox;
    }

    /**
     * Write to file method
     * @param fileName
     */
    private void writeToFile(String fileName) {
        try{
            FileOutputStream output = new FileOutputStream(fileName);
            for(int i=0; i<=100; i++){
                output.write(randomNumber());
            }
            status.setText("Write to file successful.");
        }
        catch (IOException ex){
            status.setText(ex.toString());
        }
    }

    /**
     * Read from file method
     * @param fileName
     */
    private void readFromFile(String fileName){
        try{
            FileInputStream input = new FileInputStream(fileName);
            int value;
            String outputString = "";
            while ((value=input.read())!= -1){
                outputString+=value+" ";
            }
            status.setText(outputString);
        }
        catch (IOException ex){
            status.setText(ex.toString());
        }
    }

    /**
     * Generate random number method
     * @return
     */
    private static int randomNumber(){
        int random = 0;
        random = ((int)(Math.random()*100))+1;
        return random;
    }
}
