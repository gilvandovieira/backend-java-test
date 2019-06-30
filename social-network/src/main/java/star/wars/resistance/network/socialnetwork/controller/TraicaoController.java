package star.wars.resistance.network.socialnetwork.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import star.wars.resistance.network.socialnetwork.models.Traicao;
import star.wars.resistance.network.socialnetwork.service.TraicaoService;

import java.util.List;

@RestController
@RequestMapping("traicao")
public class TraicaoController {

    @Autowired
    TraicaoService traicaoService;


    @GetMapping
    public List<Traicao> todos() {
        return traicaoService.todos();
    }

    @PostMapping
    public @ResponseBody
    Traicao novo(@RequestBody Traicao traicao) {
        return traicaoService.novo(traicao);

    }

}
