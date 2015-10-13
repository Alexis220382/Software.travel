package com.dao;

import com.entity.Formula;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivanovskiy Alexey on 13.10.2015.
 */
public class FormulaDAO {

    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();

    public List getFormula(){
        List formulas = session.createQuery("SELECT description FROM Formula").list();
        tx.commit();
        session.close();
        return formulas;
    }
}
