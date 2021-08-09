package ru.netology.dao.dao;

import org.springframework.stereotype.Repository;
import ru.netology.dao.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DaoRepository {

    @PersistenceContext
    EntityManager entityManager;

    public DaoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<String> productsList(String name) {
//        Query query = entityManager.createQuery("SELECT customer.orders from Customer customer where lower(customer.name) = lower(:name)");
        Query query = entityManager.createQuery("Select o.productName from Order o where o.customer.name =: name");
        query.setParameter("name", name);
        return query.getResultList();
    }

}
