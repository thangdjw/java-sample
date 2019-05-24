package product.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import product.model.ProductEntity;
import product.model.ProductFilter;

import javax.persistence.criteria.*;
import java.util.List;

@Service
public class ProductService {
    private SessionFactory factory;

    public ProductService() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public ProductEntity findById(String id){
        Session curSession = factory.openSession();
        CriteriaBuilder queryBuilder = curSession.getCriteriaBuilder();

        CriteriaQuery<ProductEntity> query = queryBuilder.createQuery(ProductEntity.class);
        Root<ProductEntity> root = query.from(ProductEntity.class);
        query.select(root).where(queryBuilder.equal(root.get("id"), id));
        curSession.close();
        return curSession.createQuery(query).getResultList().get(0);
    }

    public List<ProductEntity> findProduct(String identity, ProductFilter filter) {
        Session curSession = factory.openSession();
        CriteriaBuilder queryBuilder = curSession.getCriteriaBuilder();

        CriteriaQuery<ProductEntity> query = queryBuilder.createQuery(ProductEntity.class);
        Root<ProductEntity> root = query.from(ProductEntity.class);
        query.select(root);

        new SearchService(identity, filter).applyCondition(root, queryBuilder);

        curSession.close();
        return curSession.createQuery(query).getResultList();

    }

    public void addProduct(ProductEntity product) {
        Session curSession = factory.openSession();
        Transaction transaction = curSession.beginTransaction();
        curSession.save(product);
        transaction.commit();
        curSession.close();
    }

    public void updateProduct(ProductEntity product) {
        Session curSession = factory.openSession();
        Transaction transaction = curSession.beginTransaction();
        curSession.merge(product);
        transaction.commit();
        curSession.close();
    }


}
