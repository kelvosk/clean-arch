package br.com.domain;

import br.com.ports.data.input.HospitalInputPort;
import br.com.ports.data.output.HospitalOutputPort;
import br.com.ports.data.output.InventarioOutputPort;
import br.com.ports.data.output.LocalizacaoOutputPort;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HospitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cnpj;

    private String endereco;

    private float percentualOcupacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn ( name = "localizacao_ID" )
    private LocalizacaoEntity localizacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn ( name = "inventario_ID")
    private InventarioEntity inventario;

    public float atualizaPercentualDeOcupacao(Float percentual){
        return this.percentualOcupacao = percentual;
    }


    public static HospitalEntity converteHospitalEntity(HospitalInputPort inputPort) {

        LocalizacaoEntity localizacao = LocalizacaoEntity.builder()
                .latitude(inputPort.getLocalizacao().getLatitude())
                .longitude(inputPort.getLocalizacao().getLongitude())
                .build();

        InventarioEntity inventarioEntity = InventarioEntity.builder()
                .items(Item.converterInputPortEmItem(inputPort.getInventarioInputPort().getItems()))
                .build();

        inventarioEntity.calcularPontos();

        return HospitalEntity.builder()
                .nome(inputPort.getNome())
                .cnpj(inputPort.getCnpj())
                .endereco(inputPort.getEndereco())
                .percentualOcupacao(inputPort.getPercentualDeOcupacapo())
                .localizacao(localizacao)
                .inventario(inventarioEntity)
                .build();

    }

    public static HospitalOutputPort converteHospitalOutputPort(HospitalEntity hospitalEntity) {

        LocalizacaoOutputPort localizacaoOutputPort = LocalizacaoOutputPort.builder()
                .id(hospitalEntity.id)
                .latitude(hospitalEntity.getLocalizacao().getLatitude())
                .longitude(hospitalEntity.getLocalizacao().getLongitude())
                .build();

        InventarioOutputPort inventarioOutputPort = InventarioOutputPort.builder()
                .pontosDoInventario(hospitalEntity.getInventario().getPontosDoInventario())
                .items(Item.converterEntityEmOutputPort(hospitalEntity.getInventario().getItems()))
                .build();

        return HospitalOutputPort.builder()
                .id(hospitalEntity.id)
                .nome(hospitalEntity.getNome())
                .cnpj(hospitalEntity.getCnpj())
                .endereco(hospitalEntity.getEndereco())
                .percentualDeOcupacapo(hospitalEntity.percentualOcupacao)
                .localizacaoOutputPort(localizacaoOutputPort)
                .inventarioOutputPort(inventarioOutputPort)
                .build();
    }
}
