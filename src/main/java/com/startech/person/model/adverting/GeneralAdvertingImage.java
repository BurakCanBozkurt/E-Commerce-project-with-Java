package com.startech.person.model.adverting;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Date;
import java.util.UUID;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "adverting_image", schema = "person")
public class GeneralAdvertingImage {
    public GeneralAdvertingImage(Date createdAt, Date updatedAt, GeneralAdverting generalAdverting, String path) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.generalAdverting = generalAdverting;
        this.path = path;
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
    @JoinColumn(name = "generalAdverting_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private GeneralAdverting generalAdverting;

    @Column(name = "path")
    private String path;
}
