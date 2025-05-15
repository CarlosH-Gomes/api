package com.lanchonete.api.adapters.driven.entity;

import com.lanchonete.api.core.model.models.Enum.ProductCategory;
import com.lanchonete.api.core.model.models.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "products")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    private String name;
    private Double price;
    private String description;
    private Boolean active;


    public ProductEntity(Product product) {
        this.active = true;
        this.name = product.getName();
        this.category = product.getCategory();
        this.price = product.getPrice();
        this.description = product.getDescription();
    }

    public void updateProduct(Product product)
    {
        this.active = product.getActive();
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
    }

    public Product toProduct() {
        return new Product(this.id,this.name,this.active, this.category, this.price, this.description);
    }


}
