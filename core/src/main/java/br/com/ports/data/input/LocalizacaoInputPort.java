package br.com.ports.data.input;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocalizacaoInputPort {

    private String latitude;
    private String longitude;
}
