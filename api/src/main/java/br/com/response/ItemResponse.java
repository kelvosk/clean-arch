package br.com.response;

import br.com.ports.data.output.ItemOutputPort;
import lombok.*;

import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ItemResponse {

    private Long id;
    private Integer quantidade;
    private String tipoDoItem;

    public static List<ItemResponse> converterItemOutputPortEmItemResponse(List<ItemOutputPort> items){
        List<ItemResponse> item = new ArrayList<>();
        items.forEach(x -> {
            ItemResponse itemResponse = ItemResponse.builder()
                    .id(x.getId())
                    .tipoDoItem(x.getTipoDoItem())
                    .quantidade(x.getQuantidade())
                    .build();
            item.add(itemResponse);
        });
            return item;
    }

}
