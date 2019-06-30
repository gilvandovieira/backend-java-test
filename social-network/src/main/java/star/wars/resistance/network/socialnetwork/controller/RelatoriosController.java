package star.wars.resistance.network.socialnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import star.wars.resistance.network.socialnetwork.service.RebeldesService;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/relatorios")
public class RelatoriosController {

    @Autowired
    RebeldesService rebeldesService;

    @GetMapping("/porcentagem-de-traidores")
    public double porcentagemDeTraidores() {
        return this.rebeldesService.porcentagemDeTraidores();

    }

    @GetMapping("/porcentagem-de-rebeldes")
    public double porcentagemDeRebeldes() {
        return this.rebeldesService.porcentagemDeRebeldes();
    }

    @GetMapping("/medias")
    public LinkedHashMap<String, Double> medias() {
        LinkedHashMap<String, Double> medias = new LinkedHashMap<>();

        medias.put("agua", this.rebeldesService.mediaDeAgua());
        medias.put("arma", this.rebeldesService.mediaDeArma());
        medias.put("comida", this.rebeldesService.mediaDeComida());
        medias.put("municao", this.rebeldesService.mediaDeMunicao());

        return medias;

    }

    @GetMapping("pontos-perdidos")
    public Long pontosPerdidos() {
        return this.rebeldesService.pontosPerdidos();
    }

    public RelatoriosController() {
    }
}
