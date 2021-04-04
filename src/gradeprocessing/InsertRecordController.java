/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeprocessing;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ELCOT
 */
public class InsertRecordController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField quiz;
    @FXML
    private TextField a1;
    @FXML
    private TextField a2;
    @FXML
    private TextField exam;
    @FXML
    private Label mark;
    @FXML
    private Label grade;
    @FXML
    private Button insert;
    private Label quizlabel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void gradecal(MouseEvent event) {
        int a=Integer.parseInt(quiz.getText());
        int b=Integer.parseInt(a1.getText());
        int c=Integer.parseInt(a2.getText());
        int d=Integer.parseInt(exam.getText());
        Double cm=((a*0.05)+(b*0.15)+(c*0.2)+(d*0.6));
        mark.setText(cm.toString());
        if(cm>=85)
        {
            grade.setText("HD");
        }
        else if((cm<85) && (cm>=75))
        {
            grade.setText("DI");
        }
        else if((cm < 75) && (cm>=65))
        {
            grade.setText("CR");
        }
        else if((cm<65) && (cm>=50))
        {
            grade.setText("PS");
        }
        else
        {
            grade.setText("FI");
        }
    }
    @FXML
    private void insertbut(ActionEvent event) throws IOException,SQLException {
        int a=Integer.parseInt(id.getText());
        String b=name.getText();
        int c=Integer.parseInt(quiz.getText());
        int d=Integer.parseInt(a1.getText());
        int e=Integer.parseInt(a2.getText());
        int f=Integer.parseInt(exam.getText());
        double g = Double.parseDouble(mark.getText());
        String h=grade.getText();
        if((id.getText().length())>8)
        {
            System.out.println("id must be 8 digit number");
        }
        else if((d<0 || d>100) || (e<0 || e>100) || (g<0 || g>100))
        {
            System.out.println("A1,A2 and Exam must be between 1 to 100");
        }
        else{
        Connection con;
        Statement st;
        try
        {
            con=GradeProcessing.getcon();
            st=con.createStatement();
            String q="insert into java2 values("+a+",'"+b+"',"+c+","+d+","+e+","+f+","+g+",'"+h+"')";  
            int num = st.executeUpdate(q);
            System.out.println(num);
        }
        catch(NumberFormatException | SQLException e1)
        {
            System.out.println(e1.getMessage());
            System.out.println(e1.getCause());
        }
        Stage win=(Stage)((Node)event.getSource()).getScene().getWindow();
        win.close();
        }
    }   
}
