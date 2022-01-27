package br.com.ports.data.input;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ItemInputPort {

    private Long id;

    private int quantidade;

    private String tipoDoItem;


}
