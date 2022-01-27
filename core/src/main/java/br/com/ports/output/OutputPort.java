package br.com.ports.output;

import br.com.ports.data.input.HospitalInputPort;
import br.com.ports.data.output.HospitalOutputPort;

import java.util.List;


public interface OutputPort {
    HospitalOutputPort save(HospitalInputPort hospitalInputPort);
    List<HospitalOutputPort> list();
    void atualizarPercentualDeOcupacao(Long hospitalId, Float percentual);
}
