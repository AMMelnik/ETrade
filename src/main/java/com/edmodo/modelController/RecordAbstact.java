package com.edmodo.modelController;

import com.edmodo.model.User;
import com.edmodo.util.HibernateUtil;
import org.hibernate.Session;

import javax.jws.soap.SOAPBinding;

/**
 * Created by pc on 29.01.2017.
 */
public class RecordAbstact implements Recordable {

    private RecordAbstact recordAbstact;

   /* public RecordAbstact(Object object) {
        recordAbstact = (RecordAbstact) object;
    }*/

    public RecordAbstact() {

    }

    @Override
    public void addRecord(User user) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        s.save(user);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void removeRecord(Integer id) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        recordAbstact = (RecordAbstact) s.load(RecordAbstact.class, id);
        s.delete(recordAbstact);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void updateContact(User user) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        s.update(user);
        s.getTransaction().commit();
        s.close();
    }
}
