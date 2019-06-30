package star.wars.resistance.network.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import star.wars.resistance.network.socialnetwork.models.Rebelde;
import star.wars.resistance.network.socialnetwork.models.Traicao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


@Repository
public interface TraicaoRepository extends JpaRepository<Traicao, Long>, CrudRepository<Traicao, Long> {

//    @Autowired
//    RebeldesRepository rebeldesRepository = null;

    List<Traicao> findByTraido(Rebelde rebelde);

    Long countByTraido(Rebelde traido);

    default Map<Rebelde, Long> getListaDeTraicaoDoRebelde() {
        return findAll().stream().collect(Collectors.groupingBy(Traicao::getTraido, Collectors.counting()));
    }

    default Set<Rebelde> getRebeldesComTraicoesMaiorQueTres() {
        Map<Rebelde, Long> m = getListaDeTraicaoDoRebelde();

        Set<Rebelde> traidores = m.entrySet().stream().filter(e -> e.getValue().longValue() >= 3l).collect(Collectors.toMap(key -> key.getKey(), Function.identity())).keySet();

//        traidores.forEach(traidor -> {
//            if (!traidor.isTraidor()) {
//                traidor.setTraidor(true);
//                rebeldesRepository.saveAndFlush(traidor);
//            }
//        });

        return traidores;
    }
}
