package com.edmodo.modelController;

import com.edmodo.model.User;
import com.edmodo.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;


/**
 * Created by pc on 29.01.2017.
 */
public class UserRec extends RecordAbstact {

   /* public UserRec(User user) {
        super(user);
    }*/

    public UserRec() {

    }

    public int checkEmail(String emailToCheck) {
        System.out.println("\nЧтение записей таблицы");
        String q = "SELECT u FROM " + User.class.getSimpleName() + " u WHERE u.email ='" + emailToCheck + "'";

        Session s = HibernateUtil.openSession();
        Query query = s.createQuery(q);

        List<User> users = query.list();
        s.close();

        return users.get(0).getId();
    }

    public User checkAccount(String emailToCheck, String passToCheck) {
        System.out.println("\nЧтение записей таблицы");
        String q = "SELECT u FROM " + User.class.getSimpleName() + " u WHERE u.password ='" + passToCheck + "' " +
                "and u.email ='" + emailToCheck + "'";

        Session s = HibernateUtil.openSession();
        Query query = s.createQuery(q);

        List<User> users = query.list();
        s.close();

        if (users.size() == 1) {
            return users.get(0);
        } else return null;
    }
}
