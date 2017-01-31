package com.edmodo.modelController;

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

    public Item search(String itemSearch) {
        System.out.println("\nЧтение записей таблицы");
        String q = "SELECT i FROM " + Item.class.getSimpleName() + " i WHERE i.name LIKE '%" + itemSearch +
                "%' or i.description LIKE '%" + itemSearch + "%' ";

        Session s = HibernateUtil.openSession();
        Query query = s.createQuery(q);

        List<Item> items = query.list();
        s.close();

        if (items.size() > 0) {
            return items.get(0);
        } else return null;
    }

}
