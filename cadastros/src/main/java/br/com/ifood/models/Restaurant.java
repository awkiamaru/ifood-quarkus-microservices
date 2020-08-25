package br.com.ifood.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "restaurant")
@Data
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
}
