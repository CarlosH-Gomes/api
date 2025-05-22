package com.lanchonete.api.adapters.domains.produto;

import com.lanchonete.api.core.model.models.Enum.ProductCategory;

public class FilterProductDTO {
    private ProductCategory category;

    public FilterProductDTO(ProductCategory category) {
        this.category = category;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
