package star.wars.resistance.network.socialnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import star.wars.resistance.network.socialnetwork.models.Rebelde;
import star.wars.resistance.network.socialnetwork.repository.RebeldesRepository;

import java.util.List;

@Service
public class RebeldesService {

    @Autowired
    RebeldesRepository rebeldesRepository;


    public Rebelde novo(Rebelde rebelde){

        return rebeldesRepository.saveAndFlush(rebelde);
    }

    public List<Rebelde> todos(){
        return rebeldesRepository.findAll();
    }

    public Rebelde rebelde(Long id){
        return rebeldesRepository.findById(id).get();
    }

}
