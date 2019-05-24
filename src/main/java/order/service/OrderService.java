package order.service;

import order.model.OrderEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final SessionFactory factory;

    public OrderService(){
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void addOrder(OrderEntity order){
        Session session = factory.openSession();
        session.save(order);
        session.close();
    }

    public OrderEntity findById(String id) {
        Session session = factory.openSession();

        String getOrderQuery = "FROM order AS orders WHERE orders.id = :id";
        Query<OrderEntity> query = session.createQuery(getOrderQuery, OrderEntity.class);
        query.setParameter("id", id);

        OrderEntity order = query.getResultList().get(0);
        session.close();
        return order;
    }

    public void updateOrder(OrderEntity order){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(order);
        transaction.commit();
        session.close();
    }
}
