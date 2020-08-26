package br.com.ifood.dto;

import io.vertx.mutiny.sqlclient.Row;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlateDTO {

    public Long id;
    public String name;
    public String description;
    public BigDecimal price;

    public static PlateDTO from(Row row){
        PlateDTO plateDTO = new PlateDTO();
        plateDTO.setDescription(row.getString("description"));
        plateDTO.setName(row.getString("name"));
        plateDTO.setPrice(row.getBigDecimal("prive"));
        plateDTO.setId(row.getLong("id"));
        return plateDTO;
    }
}
