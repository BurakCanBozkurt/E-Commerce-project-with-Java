package com.startech.person.model.stock;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.startech.person.model.stock.parameter.Currency;
import com.startech.person.model.stock.parameter.MeasurementUnit;

import com.startech.person.model.stock.parameter.StockCategory;
import com.startech.person.model.stock.parameter.Storage;
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
@Table(name = "stock", schema = "stock")
public class Stock {
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
    @JoinColumn(name = "stock_category_id",nullable = true)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private StockCategory stockCategory;

    @ManyToOne()
    @RestResource(exported = false)
    @JoinColumn(name = "measurement_unit_id",nullable = true)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private MeasurementUnit measurementUnit;

    @ManyToOne()
    @RestResource(exported = false)
    @JoinColumn(name = "currency_id",nullable = true)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Currency currency;

    @ManyToOne()
    @RestResource(exported = false)
    @JoinColumn(name = "storage_id",nullable = true)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Storage storage;

    @Column(nullable = true, length = 64)
    @Length(min = 1, max = 64)
    private String brand;

    @NotNull
    @Column(nullable = false, length = 64)
    @Length(min = 1, max = 64)
    private String name;

    @NotNull
    @Column(nullable = false, length = 18, unique = true)
    @Length(min = 1, max = 18)
    private String code;

    @NotNull
    @Column(nullable = false)
    private float amount;

    @NotNull
    @Column(nullable = false)
    private float unitPrice;

    @NotNull
    @Column(nullable = false)
    private float totalPrice;

    @NotNull
    @Column(nullable = false, length = 1024)
    @Length(min = 1, max = 1024)
    private String explanation;

}
