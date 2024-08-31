package com.shibing.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity
public class Incident {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private Long id;


    private String title;


    private String description;
}