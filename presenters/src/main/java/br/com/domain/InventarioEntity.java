package br.com.domain;


import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventarioEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer pontosDoInventario = 0;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "inventario_id")
    private List<Item> items;

    public void calcularPontos() {
        if (this.items == null) {
            return;
        }

        this.items.forEach(item -> {
            this.pontosDoInventario = item.getTipoDoItem().calculaPontosDoItem(item);
        });
    }

    public void adicionarItens(List<Item> items) {
        this.items.addAll(items);
    }

    public void adicionarItem(Item item) {
        this.items.add(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventarioEntity that = (InventarioEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(pontosDoInventario, that.pontosDoInventario) && Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pontosDoInventario, items);
    }
}
