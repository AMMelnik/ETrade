package com.edmodo.viewController;

import com.edmodo.model.Item;
import com.edmodo.modelController.ItemRec;
import com.edmodo.modelController.UserRec;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    private TableView<String> myItems;
    @FXML
    private TableView<String> foundItems;

    private Item item;
    private ItemRec itemRec;

    @FXML
    void initialize() {
        //  welcome.setText(" Здравствуйте, " + userRec.getUserName());
    }

    @FXML
    void clickAddItemBth() {
        info.setText("");
        itemRec = new ItemRec();
        if (itemName.getText().equals("") || itemDescr.getText().equals("")) {
            info.setText("Укажите наименование и описание товара");
        } else {
            item = new Item(itemName.getText(), itemDescr.getText(), AccessContr.user);
            itemRec.addRecord(item);
            info.setText("Товар выставлен на торги");
        }
    }

    @FXML
    void clickSearchBtn() {

    }

}
