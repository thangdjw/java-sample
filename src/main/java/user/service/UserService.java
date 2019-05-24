package user.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import user.error.UserNotFoundException;
import user.model.UserEntity;

import java.util.List;

@Service
public class UserService {

    private final SessionFactory factory;

    public UserService(){
        factory = new Configuration().configure().buildSessionFactory();
    }


    public UserEntity getUser(String id) throws UserNotFoundException {

        Session session = factory.openSession();
        String getUserQuery = "FROM UserEntity as users WHERE users.id = :id AND users.isActive = 1";
        Query<UserEntity> query = session.createQuery(getUserQuery, UserEntity.class);
        query.setParameter("id", id);
        List<UserEntity> matchedUser = query.list();
        session.close();
        if(matchedUser==null) throw new UserNotFoundException(id);
        return matchedUser.get(0);
    }

    public void addUser(UserEntity user) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void updateUser(UserEntity user) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(user);
        transaction.commit();
        session.close();
    }

    public boolean deleteUser(String id) {
        Session session = factory.openSession();
        UserEntity anonymousUser = new UserEntity();
        anonymousUser.setId(id);
        anonymousUser.setActive(false);
        Transaction transaction = session.beginTransaction();
        session.merge(anonymousUser);
        transaction.commit();
        session.close();
        return true;
    }
}
