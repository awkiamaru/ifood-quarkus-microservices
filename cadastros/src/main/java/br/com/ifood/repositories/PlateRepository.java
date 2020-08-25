package br.com.ifood.repositories;

import br.com.ifood.models.Plate;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlateRepository implements PanacheRepository<Plate> {
}
