package br.com.ifood.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "restaurant")
@Data
public class Restaurant extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private String document;
    private String name;

    @ManyToOne
    private Localization localization;
    @CreationTimestamp
    @JsonbDateFormat
    private Date createdDate;
    @UpdateTimestamp
    @JsonbDateFormat
    private Date updatedDate;
}
