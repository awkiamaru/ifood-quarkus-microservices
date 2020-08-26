package br.com.ifood.models;

import br.com.ifood.dto.PlateDTO;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import lombok.Data;

import java.math.BigDecimal;
import java.util.stream.StreamSupport;


@Data
public class Plate {

    public Long id;
    public String name;
    public String description;
    public Restaurant restaurant;
    public BigDecimal price;

    public static Multi<PlateDTO> findAll(PgPool pgPool) {
        Uni<RowSet<Row>> preparedQuery = pgPool.query("select * from plate").execute();
        return preparedQuery.onItem()
                            .transformToMulti(rows -> Multi.createFrom()
                                                            .items(() -> StreamSupport
                                                            .stream(rows.spliterator(), false)))
                            .onItem()
                            .transform(PlateDTO::from);
    }
}
