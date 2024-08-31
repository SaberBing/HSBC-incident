package com.shibing.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@Table(name = "Incident",uniqueConstraints = { @UniqueConstraint(columnNames = { "title","local_date"}, name = "dish_uniq_title_date_idx") })
public class Incident extends BaseEntity{


    @Column(name = "title", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 128)
    private String title;

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String description;

    @Column(name = "local_date", nullable = false)
    @NotNull
    private LocalDate localDate;

    public Incident(Integer id, String title, String description, LocalDate date) {
        super(id);
        this.title = title;
        this.description = description;
        this.localDate = date;
    }
}