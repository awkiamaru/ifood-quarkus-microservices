package br.com.ifood.models;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private String document;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Localization localization;
    @CreationTimestamp
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate createdDate;
    @UpdateTimestamp
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate updatedDate;

}
