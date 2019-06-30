package star.wars.resistance.network.socialnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import star.wars.resistance.network.socialnetwork.models.Rebelde;
import star.wars.resistance.network.socialnetwork.repository.TraicaoRepository;

import java.util.Set;

@RestController
@RequestMapping("/relatorios")
public class RelatoriosController {

    @Autowired
    TraicaoRepository traicaoRepository;

    @GetMapping("/traidores")
    public Set<Rebelde> RebeldesTraidores(){
        return null;

    }

    public RelatoriosController() {
    }
}
