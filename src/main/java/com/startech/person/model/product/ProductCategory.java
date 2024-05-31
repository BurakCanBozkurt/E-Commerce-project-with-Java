package com.startech.person.model.product;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_category", schema = "product")
public class ProductCategory {
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

    @ManyToOne()
    @RestResource(exported = false)
    @JoinColumn(name = "product_category_id", nullable = true)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private ProductCategory parentProductCategory;

    @NotNull
    @Column(nullable = false, length = 64)
    @Length(min = 1, max = 64)
    private String name;

    @NotNull
    @Column(nullable = false, length = 18, unique = true)
    @Length(min = 1, max = 18)
    private String code;

    @NotNull
    @Column(columnDefinition = "boolean default true", nullable = false )
    private Boolean active;
}
