package br.com.domain;

import br.com.ports.data.input.ItemInputPort;
import br.com.ports.data.output.ItemOutputPort;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Item {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantidade;

    private Integer pontosDoItem;

    private TipoDoItem tipoDoItem;

    public static List<Item> converterInputPortEmItem(List<ItemInputPort> itemsInputPort){
        List<Item> item = new ArrayList<>();
        itemsInputPort.forEach(x -> {
            var items = Item.builder()
                    .id(x.getId())
                    .tipoDoItem(TipoDoItem.valueOf(x.getTipoDoItem()))
                    .quantidade(x.getQuantidade())
                    .build();
            item.add(items);
        });
        return item;
    }

    public static List<ItemOutputPort> converterEntityEmOutputPort(List<Item> itemsEntity){
        List<ItemOutputPort> item = new ArrayList<>();

        for(Item i : itemsEntity) {

            item.add(ItemOutputPort.builder()
                    .id(i.getId())
                    .tipoDoItem(i.getTipoDoItem().getDescricao())
                    .quantidade(i.getQuantidade())
                    .build());
        }

//            itemsEntity.forEach(x -> {
//                ItemOutputPort itemOutputPort = ItemOutputPort.builder()
//                        .id(x.getId())
//                        .tipoDoItem(x.getTipoDoItem().getDescricao())
//                        .quantidade(x.getQuantidade())
//                        .build();
//                item.add(itemOutputPort);
//            });
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quantidade == item.quantidade && Objects.equals(id, item.id) && Objects.equals(pontosDoItem, item.pontosDoItem) && tipoDoItem == item.tipoDoItem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantidade, pontosDoItem, tipoDoItem);
    }
}
