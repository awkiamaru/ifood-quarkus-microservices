package br.com.ifood.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "localization")
public class Localization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double latitude;

    private Double longitude;
}
