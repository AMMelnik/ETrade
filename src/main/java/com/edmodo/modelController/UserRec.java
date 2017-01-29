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

    public boolean checkEmail(String emailToCheck) {
        System.out.println("\nЧтение записей таблицы");
        String q = "SELECT u FROM " + User.class.getSimpleName() + " u WHERE u.email ='" + emailToCheck + "'";

        Session s = HibernateUtil.openSession();
        Query query = s.createQuery(q);
//        query.setParameter("email", emailToCheck);
     //   @SuppressWarnings("unchecked")
        List<User> users = query.list();
        System.out.println("Список юзеров:\n" + users.toString());
        s.close();

       /* System.out.println("\nЧтение записей таблицы");
        String query = "select p from " + Person.class.getSimpleName() + " p";

        @SuppressWarnings("unchecked")
        List<Person> list = (List<Person>)session.createQuery(query).list();
        System.out.println(list);*/


        //  Query query = getCurrentSession().createQuery(q);
        //   query.setParameter("email", emailToCheck);
        return users.size() > 0;
    }
}
