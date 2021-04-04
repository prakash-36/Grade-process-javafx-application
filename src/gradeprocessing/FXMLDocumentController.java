/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeprocessing;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ELCOT
 */
public class FXMLDocumentController implements Initializable {
    Stage stage1=GradeProcessing.getstage();
    
    @FXML
    private Button insertbut;
    @FXML
    private Button updatebut;
    @FXML
    private Button searchbut;
    @FXML
    private TextField search;
    @FXML
    private TableColumn<Student, Integer> tid;
    @FXML
    private TableColumn<Student, String> tname;
    @FXML
    private TableColumn<Student, Integer> tquiz;
    @FXML
    private TableColumn<Student, Integer> ta1;
    @FXML
    private TableColumn<Student, Integer> ta2;
    @FXML
    private TableColumn<Student, Integer> texam;
    @FXML
    private TableColumn<Student, Integer> tmark;
    @FXML
    private TableView<Student> table;
    @FXML
    private TableColumn<Student, String> tgrade;
    
    /**
     * Initializes the controller class.
     */
    ObservableList<Student> list=FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loaddata();
        tid.setCellValueFactory(new PropertyValueFactory<>("tid"));
        tname.setCellValueFactory(new PropertyValueFactory<>("tname"));
        tquiz.setCellValueFactory(new PropertyValueFactory<>("tquiz"));
        ta1.setCellValueFactory(new PropertyValueFactory<>("ta1"));
        ta2.setCellValueFactory(new PropertyValueFactory<>("ta2"));
        texam.setCellValueFactory(new PropertyValueFactory<>("texam"));
        tmark.setCellValueFactory(new PropertyValueFactory<>("tmark"));
        tgrade.setCellValueFactory(new PropertyValueFactory<>("tgrade"));
    }    

    @FXML
    private void insert(ActionEvent event) throws IOException {
        Parent p1 = FXMLLoader.load(getClass().getResource("insertRecord.fxml"));
        Scene s=new Scene(p1);
        Stage stage2=new Stage();
        stage2.setScene(s);
        stage2.initModality(Modality.WINDOW_MODAL);
        stage2.initOwner(stage1);
        stage2.show();
    }

    @FXML
    private void update(ActionEvent event) throws IOException {
        Parent p2 = FXMLLoader.load(getClass().getResource("updateRecord.fxml"));
        Scene s1=new Scene(p2);
        Stage stage3=new Stage();
        stage3.setScene(s1);
        stage3.initModality(Modality.WINDOW_MODAL);
        stage3.initOwner(stage1);
        stage3.show();
    }

    @FXML
    private void onsearch(ActionEvent event) throws SQLException {
        table.getItems().clear();
        Connection con;
        Statement st;
        ResultSet rs;
        try
        {
            con=GradeProcessing.getcon();
            st=con.createStatement();
            String t=search.getText();
            String q="select*from java2 where id="+t; 
            rs = st.executeQuery(q);
            while(rs.next())
            {
                int a=rs.getInt("id");
                String b=rs.getString("name");
                int c=rs.getInt("quiz");
                int d=rs.getInt("a1");
                int e=rs.getInt("a2");
                int f=rs.getInt("exam");
                double g=rs.getDouble("cumulativemark");
                String h=rs.getString("grade");
                list.add(new Student(a,c,d,e,f,b,h,g));               
            }
            table.setItems(list);
        }
        catch(NumberFormatException | SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        }
    }
    //It will show existing values
    private void loaddata() {
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
                int a=rs.getInt("id");
                String b=rs.getString("name");
                int c=rs.getInt("quiz");
                int d=rs.getInt("a1");
                int e=rs.getInt("a2");
                int f=rs.getInt("exam");
                double g=rs.getDouble("cumulativemark");
                String h=rs.getString("grade");
                list.add(new Student(a,c,d,e,f,b,h,g));               
            }
            table.setItems(list);
        }
        catch(NumberFormatException | SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        }
    }
    //It will show original table
    @FXML
    private void showoriginal(MouseEvent event) {
        table.getItems().clear();
        search.setText("");
        loaddata();
    }

    
}
