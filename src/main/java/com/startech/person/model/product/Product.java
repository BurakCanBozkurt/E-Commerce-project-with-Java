package com.startech.person.model.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.startech.person.model.product.campaign.Campaign;
import com.startech.person.model.stock.Stock;
import com.startech.person.model.stock.parameter.Currency;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product", schema = "product")
public class Product {
    public Product(UUID id) {
        this.id = id;
    }
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, name = "created_at")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Asia/Istanbul")
    private Date createdAt;

    @Column(nullable = false, name = "updated_at")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Asia/Istanbul")
    private Date updatedAt;

    @NotNull
    @ManyToOne()
    @RestResource(exported = false)
    @JoinColumn(name = "stock_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Stock stock;

    @ManyToOne()
    @RestResource(exported = false)
    @JoinColumn(name = "campaign_id", nullable = true)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Campaign campaign;

    @ManyToOne()
    @RestResource(exported = false)
    @JoinColumn(name = "currency_id", nullable = true)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Currency currency;

    @ManyToOne()
    @RestResource(exported = false)
    @JoinColumn(name = "product_category_id", nullable = true)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private ProductCategory productCategory;

    @NotNull
    @Column(nullable = false, length = 64)
    @Length(min = 1, max = 64)
    private String title;

    @NotNull
    @Column(nullable = false, length = 18, unique = true)
    @Length(min = 1, max = 18)
    private String code;

    @NotNull
    @Column(nullable = false)
    private float price;

    @NotNull
    @Column(nullable = false, length = 1024)
    @Length(min = 1, max = 1024)
    private String explanation;

    @NotNull
    @Column(nullable = true)
    private Float discountRate;

    @NotNull
    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean active;

    @OneToMany(mappedBy = "product", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<ProductImage> images;
}
