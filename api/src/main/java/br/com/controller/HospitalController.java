package br.com.controller;


import br.com.ports.input.InputPort;
import br.com.request.HospitalRequest;
import br.com.response.HospitalResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hospitais")
public class HospitalController {

    private final InputPort inputPort;

    public HospitalController(InputPort inputPort) {
        this.inputPort = inputPort;
    }

    @PostMapping
    public HospitalResponse criarHospital(@RequestBody HospitalRequest request) {
       var response = this.inputPort.save(request.convertHospitalInputPort(request));
       return HospitalResponse.converteHospitalOutputPortHospitalResponse(response);
    }

    @GetMapping
    public List<HospitalResponse> hospitais(){
        return this.inputPort
                .list()
                .stream()
                .map(HospitalResponse::converteHospitalOutputPortHospitalResponse)
                .collect(Collectors.toList());
    }

    @PutMapping("/atualizar-ocupacao/{id}")
    public void atualizaPercentualOcupacao(@PathVariable("id") Long id, @RequestParam("percentual") Float percentual) {
        this.inputPort.atualizarPercentualDeOcupacao(id, percentual);
    }
}
