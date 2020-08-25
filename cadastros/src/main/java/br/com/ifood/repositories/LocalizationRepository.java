package br.com.ifood.repositories;

import br.com.ifood.models.Localization;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LocalizationRepository implements PanacheRepository<Localization> {
}
