/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeprocessing;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ELCOT
 */
public class UpdateRecordController implements Initializable {
    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<Integer> rowchoice;
    @FXML
    private ChoiceBox<String> colchoice;
    @FXML
    private TextField updatedval;
    @FXML
    private Button up;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colchoice.getItems().addAll("id","name","quiz","a1","a2","exam","cumulativemark","grade");
        loaddata();
    }    
    @FXML
    private void updatebut(ActionEvent event) throws SQLException {
        Connection con;
        Statement st;
        try
        {
            con=GradeProcessing.getcon();
            st=con.createStatement();
            String q;
            if((colchoice.getValue().equals("name")) || (colchoice.getValue().equals("grade")))
            {
                q="update java2 set "+colchoice.getValue()+"='"+updatedval.getText()+"' where id="+rowchoice.getValue()+""; 
            }
            else
            {
                q="update java2 set "+colchoice.getValue()+"="+updatedval.getText()+" where id="+rowchoice.getValue()+"";
            }
            int num = st.executeUpdate(q);
            System.out.println(num+" row updated");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        Stage win=(Stage)((Node)event.getSource()).getScene().getWindow();
        win.close();
    }
    private void loaddata() {
        list.removeAll();
        Connection con;
        Statement st;
        ResultSet rs;
        try
        {
            con=GradeProcessing.getcon();
            st=con.createStatement();
            String q="select*from java2"; 
            rs = st.executeQuery(q);
            while(rs.next())
            {
                list.add(rs.getInt("id"));
            }
            rowchoice.getItems().addAll(list);
        }
        catch(NumberFormatException | SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }  
}
