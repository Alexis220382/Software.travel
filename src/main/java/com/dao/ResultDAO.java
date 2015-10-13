package com.dao;

import com.entity.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by Ivanovskiy Alexey on 13.10.2015.
 */
public class ResultDAO {

    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    Result result = new Result();

    public void save(String calculated){
        result.setResult(calculated);
        session.save(result);
        tx.commit();
        session.close();
    }
}
