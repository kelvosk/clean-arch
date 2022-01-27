package br.com.ports.data.output;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ItemOutputPort {

    private Long id;

    private int quantidade;

    private String tipoDoItem;


}
