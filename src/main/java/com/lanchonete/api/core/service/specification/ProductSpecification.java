package com.lanchonete.api.core.service.specification;

import com.lanchonete.api.adapters.domains.produto.FilterProductDTO;
import com.lanchonete.api.adapters.driven.entity.ProductEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import static org.springframework.data.jpa.domain.Specification.where;

@Component
public class ProductSpecification extends BaseSpecification<ProductEntity, FilterProductDTO> {

    private static final String ATTR_CATEGORY = "category";

    @Override
    public Specification<ProductEntity> getFilter(FilterProductDTO filter) {
        return (root, query, cb) ->
                where(attributeEquals(ATTR_CATEGORY, filter.getCategory()))
                .toPredicate(root, query, cb);
    }

    private Specification<ProductEntity> attributeEquals(String attribute, Object value) {
        return (root, query, cb) -> {
            if (value == null) {
                return null;
            }
            return cb.equal(
                    root.get(attribute),
                    value
            );
        };
    }
}
