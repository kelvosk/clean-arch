package br.com.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ItemRequest {

    private int quantidade;

    private Integer pontosDoItem;

    private String tipoItem;
}
