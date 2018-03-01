/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Class that acts as a controller between the UI and the XML Parser
 * @author daniel
 */
public class XMLParserFXMLDocumentController implements Initializable {
    
    @FXML
    private Stage stage;
    
    @FXML
    private Label fileNameLabel;
    
    @FXML
    private TreeView<String> XMLTree;
    
    @FXML
    private VBox XMLTreeContainer;
    
    /**
     * Method that prompts the user for an XML file, calls the static parser
     * method in the Parser class, receives a TreeView object, and updates the UI
     * @param event 
     */
    @FXML
    private void fileButtonHandler (ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open XML File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
        
        File XMLFile = fileChooser.showOpenDialog(stage);
        fileNameLabel.setText(XMLFile.getName());
        System.out.println(XMLFile.getPath());
        TreeItem<String> root = Parser.parser(XMLFile);
        
        if(root != null) {
            XMLTreeContainer.getChildren().remove(XMLTree);
            XMLTree = new TreeView<>(root);
            XMLTreeContainer.getChildren().add(XMLTree);
        } else {
            System.out.println("XML Root is null.");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
}
