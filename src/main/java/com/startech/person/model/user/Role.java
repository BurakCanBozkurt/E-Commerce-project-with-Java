package com.startech.person.model.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.UUID;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles", schema = "person")
public class Role {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotNull
    @Column(nullable = false, length = 64)
    @Length(min = 1, max = 64)
    private String name;

}
