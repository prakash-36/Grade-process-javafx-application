/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeprocessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ELCOT
 */
public class GradeProcessing extends Application {
    public static Connection con;
    private static Stage primarystage;
    
    private void setstage(Stage stage)
    {
        GradeProcessing.primarystage=stage;
    }
    
    public static Stage getstage()
    {
        return GradeProcessing.primarystage;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        setstage(stage);
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Grade processing");
        stage.show();
    }
    public static Connection getcon()
    {
        return con;
    }

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        con=(Connection)DriverManager.getConnection("jdbc:derby://localhost:1527/gradeprocess","root","prakash");
        if(con!=null)
        {
            System.out.println("connection successfull");
        }
        else
        {
            System.out.println("connection successfull");
        }
        launch(args);
    }
    
}
