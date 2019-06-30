package star.wars.resistance.network.socialnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import star.wars.resistance.network.socialnetwork.models.Rebelde;
import star.wars.resistance.network.socialnetwork.service.RebeldesService;

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
}
