package br.com.ports.input;

import br.com.ports.data.input.HospitalInputPort;
import br.com.ports.data.output.HospitalOutputPort;

import java.util.List;


public interface InputPort {

    HospitalOutputPort save(HospitalInputPort hospitalInputPort);

    List<HospitalOutputPort> list();

    void atualizarPercentualDeOcupacao(Long hospitalId, Float percentual);
}
