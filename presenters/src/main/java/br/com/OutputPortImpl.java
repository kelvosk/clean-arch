package br.com;

import br.com.domain.HospitalEntity;
import br.com.ports.data.input.HospitalInputPort;
import br.com.ports.data.output.HospitalOutputPort;
import br.com.ports.data.output.InventarioOutputPort;
import br.com.ports.output.OutputPort;
import br.com.repository.InventarioRepository;
import br.com.repository.RepositoryPresenter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OutputPortImpl implements OutputPort {

    private final RepositoryPresenter repositoryPresenter;
    private final InventarioRepository inventarioRepository;

    public OutputPortImpl(RepositoryPresenter repositoryPresenter, InventarioRepository inventarioRepository) {
        this.repositoryPresenter = repositoryPresenter;
        this.inventarioRepository = inventarioRepository;
    }

    @Override
    public HospitalOutputPort save(HospitalInputPort hospitalInputPort) {
      var entity = this.repositoryPresenter.save(HospitalEntity.converteHospitalEntity(hospitalInputPort));
      return HospitalEntity.converteHospitalOutputPort(entity);
    }

    @Override
    public List<HospitalOutputPort> list() {
        return this.repositoryPresenter
                .findAll()
                .stream()
                .map(HospitalEntity::converteHospitalOutputPort)
                .collect(Collectors.toList());
    }

    @Override
    public void atualizarPercentualDeOcupacao(Long hospitalId, Float percentual) {
       var hospitalEntity = this.repositoryPresenter.getById(hospitalId);
       var hospitalAtualizado = hospitalEntity.atualizaPercentualDeOcupacao(percentual);
       this.repositoryPresenter.save(hospitalEntity);
    }

    public List<InventarioOutputPort> listAllInventario(){
        this.inventarioRepository.findAll();
        return null;
    }
}
