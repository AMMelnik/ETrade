package com.edmodo.modelController;

import com.edmodo.model.Item;
import com.edmodo.model.User;

import java.util.List;

/**
 * Created by pc on 29.01.2017.
 */
public interface Recordable {
    void addRecord(User user);

    //List<Contact> listContact();
    void removeRecord(Integer id);

    void updateRecord(User user);

    void addRecord(Item item);

    void updateRecord(Item item);
}
