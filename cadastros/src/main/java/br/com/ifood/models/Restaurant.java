package br.com.ifood.models;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private String document;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Localization localization;
    @CreationTimestamp
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate createdDate;
    @UpdateTimestamp
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate updatedDate;

    public Long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Localization getLocalization() {
        return localization;
    }

    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }
}
