package star.wars.resistance.network.socialnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import star.wars.resistance.network.socialnetwork.models.Item;
import star.wars.resistance.network.socialnetwork.models.Localizacao;
import star.wars.resistance.network.socialnetwork.models.Rebelde;
import star.wars.resistance.network.socialnetwork.service.RebeldesService;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("rebeldes")
public class RebeldesController {

    @Autowired
    RebeldesService rebeldesService;

    @PostMapping
    public @ResponseBody
    Rebelde novoRebelde(@RequestBody Rebelde rebelde) {

        return rebeldesService.novo(rebelde);
    }

    @GetMapping
    public List<Rebelde> todosRebeldes() {
        return rebeldesService.todos();
    }


    @GetMapping("{id}")
    public Rebelde pegaRebelde(@PathVariable("id") Long id) {
        return rebeldesService.rebelde(id);
    }

    @PostMapping("{id}/nome")
    public @ResponseBody
    Rebelde atualizaNome(@PathVariable("id") Long id, @RequestBody LinkedHashMap<String, String> o) {

        Rebelde r = new Rebelde();
        r.setId(id);
        r.setNome(o.get("nome"));
        return this.rebeldesService.atualizaNome(r);

    }

    @PostMapping("{id}/genero")
    public @ResponseBody
    Rebelde atualizaGenero(@PathVariable("id") Long id, @RequestBody LinkedHashMap<String, String> o) {

        Rebelde r = new Rebelde();
        r.setId(id);
        r.setGenero(o.get("genero"));
        return this.rebeldesService.atualizaGenero(r);

    }

    @PostMapping("{id}/localizacao")
    public @ResponseBody
    Rebelde atualizaLocalizacao(@PathVariable("id") Long id, @RequestBody Localizacao localizacao) {
        Rebelde r = new Rebelde();
        r.setId(id);
        return this.rebeldesService.atualizarLocalizacao(localizacao, r);
    }

    @PostMapping("{id}/negocia/{rebelde}")
    public @ResponseBody
    Item novoNegocio(@PathVariable("id") Long id, @PathVariable("rebelde") Long rebelde, @RequestBody Item item) {

        this.rebeldesService.negociarItems(id, rebelde, item);


        return item;
    }
}
