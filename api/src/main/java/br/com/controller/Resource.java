package br.com.controller;

import br.com.ports.input.InputPort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Resource {

    private final InputPort inputPort;

    public Resource(InputPort inputPort) {
        this.inputPort = inputPort;
    }


}
