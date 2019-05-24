package product.controller;

import product.model.ProductEntity;
import product.model.ProductFilter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.util.List;

public class FilterMapping {

    private static Predicate getFilterConditionMapping(String field,
                                                ProductFilter filter,
                                                Root<ProductEntity> root,
                                                CriteriaBuilder builder) {
        switch (field) {
            case "filter_name":
                return builder.equal(
                        root.get("name"),
                        filter.getFilter_name());
            case "filter_owner":
                return builder.equal(
                        root.get("owner"),
                        filter.getFilter_owner());
            case "filter_lt_price":
                return builder.lessThanOrEqualTo(
                        root.get("price"),
                        filter.getFilter_lt_price());
            case "filter_gt_price":
                return builder.greaterThanOrEqualTo(
                        root.get("price"),
                        filter.getFilter_gt_price());
            case "filter_producer":
                return builder.equal(
                        root.get("producer"),
                        filter.getFilter_producer());
            case "filter_species":
                return builder.equal(
                        root.get("species"),
                        filter.getFilter_species());
        }
        return null;
    }

    public static void applyFilter(List<Predicate> whereCondition,
                                   Root<ProductEntity> root,
                                   ProductFilter filter,
                                   CriteriaBuilder builder) {

        Field[] fields = ProductEntity.class.getFields();
        for (Field field : fields) {
            Predicate conditionMapping = getFilterConditionMapping(
                    field.getName(),
                    filter,
                    root,
                    builder);
            whereCondition.add(conditionMapping);
        }
    }
}
