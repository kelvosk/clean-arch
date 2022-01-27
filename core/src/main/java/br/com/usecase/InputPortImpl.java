package br.com.usecase;

import br.com.ports.data.input.HospitalInputPort;
import br.com.ports.data.output.HospitalOutputPort;
import br.com.ports.input.InputPort;
import br.com.ports.output.OutputPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InputPortImpl implements InputPort {

    private final OutputPort outputPort;

    public InputPortImpl(OutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public HospitalOutputPort save(HospitalInputPort hospitalInputPort) {
        return this.outputPort.save(hospitalInputPort);
    }

    @Override
    public List<HospitalOutputPort> list() {
        return this.outputPort.list();
    }

    @Override
    public void atualizarPercentualDeOcupacao(Long hospitalId, Float percentual) {
        this.outputPort.atualizarPercentualDeOcupacao(hospitalId,percentual);
    }
}
