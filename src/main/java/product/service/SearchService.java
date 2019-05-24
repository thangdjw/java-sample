package product.service;

import product.controller.FilterMapping;
import product.model.ProductEntity;
import product.model.ProductFilter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SearchService {

    private String identity;
    private ProductFilter filter;

    public SearchService(String identity, ProductFilter filter) {
        this.identity = identity;
        this.filter = filter;
    }

    public void applyCondition(Root<ProductEntity> root, CriteriaBuilder builder) {
        ArrayList<Predicate> whereClause = new ArrayList<>();
        applySearch(whereClause, root, builder);
        FilterMapping.applyFilter(whereClause, root, filter, builder);

        ArrayList<Order> orderClause = new ArrayList<>();
        applySort(orderClause, root, builder);
    }

    private void applySearch(List<Predicate> whereClause,
                             Root<ProductEntity> root,
                             CriteriaBuilder builder) {

        Predicate searchType;

        if (isBarcodeType(identity)) {
            // search by barcode
            searchType = builder.like(root.get("barcode"), identity);
        } else {
            // search by name
            searchType = builder.like(root.get("name"), "%" + identity + "%");
        }

        whereClause.add(searchType);
    }

    private void applySort(List<Order> orderCondition,
                           Root<ProductEntity> root,
                           CriteriaBuilder cb) {
        if (filter.getSort_name()) {
            orderCondition.add(cb.desc(root.get("name")));
        }

        if (filter.getSort_price()) {
            orderCondition.add(cb.desc(root.get("price")));
        }
    }

    private boolean isBarcodeType(String identity) {
        return identity.matches("\\d+");
    }
}
