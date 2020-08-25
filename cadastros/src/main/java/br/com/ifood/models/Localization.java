package br.com.ifood.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "localization")
@Data
public class Localization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double latitude;

    private Double longitude;
}
