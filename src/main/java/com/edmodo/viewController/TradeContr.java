package com.edmodo.viewController;

import com.edmodo.model.Bid;
import com.edmodo.model.Item;
import com.edmodo.model.User;
import com.edmodo.modelController.BidRec;
import com.edmodo.modelController.ItemRec;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

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
    private Bid bid;
    private BidRec bidRec;
    private ObservableList<Item> itemList = FXCollections.observableArrayList();


    @FXML
    void initialize() {
        welcome.setText(" Здравствуйте, " + AccessContr.user.getName());
    }

    @FXML
    void clickAddItemBth() {
        info.setText("");
        itemRec = new ItemRec();
        if (itemName.getText().isEmpty() || itemDescr.getText().isEmpty()) {
            info.setText("Укажите наименование и описание товара");
        } else {
            item = new Item(itemName.getText(), itemDescr.getText(), AccessContr.user);
            itemRec.addRecord(2, null, item, null);
            info.setText("Товар выставлен на торги");
        }
    }

    @FXML
    void clickSearchBtn() {
        itemList.removeAll();
        foundItems.getItems().clear();
        searchInfo.setText("");
        itemRec = new ItemRec();
        if (itemSearch.getText().isEmpty()) {
            searchInfo.setText("Укажите наименование/описание");
        } else {
            List<Item> selectedItems = itemRec.search(itemSearch.getText());
            if (selectedItems == null) {
                searchInfo.setText("Товар не найден");
            } else {
                itemList.addAll(selectedItems);
                nameItemColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
                descrItemColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));
                foundItems.setItems(itemList);
            }
        }
    }

    @FXML
    void clickExitBtn() {
        AccessContr.user = null;
        super.getMain().showAccessForm();
    }

    @FXML
    void clickBuyBtn() {
        foundItems.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    Item itemToBuy = newValue;
                    bid.setItem(itemToBuy);
                    bid.setUser(AccessContr.user);
                    bidRec.addRecord(3, null, null, bid);
                    info.setText("Товар приобретен");
                });
    }
}

