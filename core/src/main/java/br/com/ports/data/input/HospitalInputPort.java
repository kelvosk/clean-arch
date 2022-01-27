package br.com.ports.data.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HospitalInputPort {

    private String nome;
    private String cnpj;
    private String endereco;
    private Float percentualDeOcupacapo;
    private LocalizacaoInputPort localizacao;
    private InventarioInputPort inventarioInputPort;

}
