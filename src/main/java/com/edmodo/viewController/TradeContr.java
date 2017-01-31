package com.edmodo.viewController;

import com.edmodo.model.Item;
import com.edmodo.model.User;
import com.edmodo.modelController.ItemRec;
import com.edmodo.modelController.UserRec;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by pc on 30.01.2017.
 */
public class TradeContr extends ObjController {

    @FXML
    private Label welcome;
    @FXML
    private Label info;
    @FXML
    private TextField itemName;
    @FXML
    private TextField itemDescr;
    @FXML
    private TextField itemSearch;
    @FXML
    private Label searchInfo;
    @FXML
    private TableView<Item> myItems;
    @FXML
    private TableColumn<Item, Integer> idItemColumn;
    @FXML
    private TableColumn<Item, String> nameItemColumn;
    @FXML
    private TableColumn<Item, String> descrItemColumn;
    @FXML
    private TableColumn<User, Integer> idUserColumn;
    @FXML
    private TableView<Item> foundItems;

    private Item item;
    private ItemRec itemRec;
    private ObservableList<Item> itemlist = FXCollections.observableArrayList();


    @FXML
    void initialize() {
        //  welcome.setText(" Здравствуйте, " + userRec.getUserName());
    }

    @FXML
    void clickAddItemBth() {
        info.setText("");
        itemRec = new ItemRec();
        //if (itemName.getText().equals("") || itemDescr.getText().equals("")) {
        if (itemName.getText().isEmpty() || itemDescr.getText().isEmpty()) {
            info.setText("Укажите наименование и описание товара");
        } else {
            item = new Item(itemName.getText(), itemDescr.getText(), AccessContr.user);
            itemRec.addRecord(item);
            info.setText("Товар выставлен на торги");
        }
    }

    @FXML
    void clickSearchBtn() {
        searchInfo.setText("");

                //.clearAndSelect(int row,TableColumn<S,?> column)
        itemlist.removeAll();
        nameItemColumn.setCellValueFactory(new PropertyValueFactory<Item, String>(""));
        descrItemColumn.setCellValueFactory(new PropertyValueFactory<Item, String>(""));
        foundItems.setItems(itemlist);
        itemRec = new ItemRec();
        if (itemSearch.getText().isEmpty()) {
            searchInfo.setText("Укажите наименование/описание");
        } else {
            item = itemRec.search(itemSearch.getText());
            itemlist.add(item);
            nameItemColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
            descrItemColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));
            foundItems.setItems(itemlist);
        }
    }

    @FXML
    void clickExitBtn() {
        ///////
    }

    @FXML
    void clickBuyBtn() {
        /////
    }

}
