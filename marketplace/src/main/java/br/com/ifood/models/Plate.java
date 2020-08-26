package br.com.ifood.models;

import br.com.ifood.dto.PlateDTO;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;
import lombok.Data;

import java.math.BigDecimal;
import java.util.stream.StreamSupport;


@Data
public class Plate {

    private Long id;
    private String name;
    private String description;
    private Restaurant restaurant;
    private BigDecimal price;

    public static Multi<PlateDTO> findAll(PgPool pgPool) {
        Uni<RowSet<Row>> preparedQuery = pgPool
                .query("select * from plate")
                .execute();
        return mapUniToMulti(preparedQuery);
    }

    public static Multi<PlateDTO> findAll(PgPool pgPool, Long restaurantId) {
        Uni<RowSet<Row>> preparedQuery = pgPool
                .preparedQuery("select * from plate WHERE plate.restaurant_id = $1 ORDER BY name ASC")
                .execute(Tuple.of(restaurantId));
        return mapUniToMulti(preparedQuery);
    }

    private static Multi<PlateDTO> mapUniToMulti(Uni<RowSet<Row>> preparedQuery) {
        return preparedQuery.onItem()
                .transformToMulti(rows -> Multi.createFrom()
                        .items(() -> StreamSupport
                                .stream(rows.spliterator(), false)))
                .onItem()
                .transform(PlateDTO::from);
    }
}
