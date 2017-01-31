package com.edmodo.modelController;

import com.edmodo.model.Bid;
import com.edmodo.model.Item;
import com.edmodo.model.User;
import com.edmodo.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by pc on 30.01.2017.
 */
public class ItemRec extends RecordAbstact {

    public ItemRec() {
        super();
    }

    public List<Item> search(String itemSearch) {
        System.out.println("\nЧтение записей таблицы Item");

        String q = "SELECT i FROM Bid as b, Item as i WHERE b.item != i.id " +
                "and (i.name LIKE :itemSearch or i.description LIKE :itemSearch)";

        Session s = HibernateUtil.openSession();
        Query query = s.createQuery(q).setParameter("itemSearch", "%" + itemSearch + "%")
                .setParameter("itemSearch", "%" + itemSearch + "%");

        List<Item> items = query.list();
        s.close();

        if (items.size() > 0) {
            return items;
        } else return null;
    }
}
