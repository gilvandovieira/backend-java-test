package star.wars.resistance.network.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import star.wars.resistance.network.socialnetwork.models.Traicao;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface TraicaoRepository extends JpaRepository<Traicao, Long>, CrudRepository<Traicao, Long> {

    List<Traicao> findByTraido(Long rebelde);

    Long countByTraido(Long traido);

//    default Map<Rebelde, Long> getListaDeTraicaoDoRebelde() {
//        return findAll().stream().collect(Collectors.groupingBy(Traicao::getTraido, Collectors.counting()));
//    }

//    default Set<Rebelde> getRebeldesComTraicoesMaiorQueTres() {
//        Map<Rebelde, Long> m = getListaDeTraicaoDoRebelde();
//
//        Set<Rebelde> traidores = m.entrySet().stream().filter(e -> e.getValue().longValue() >= 3l).collect(Collectors.toMap(key -> key.getKey(), Function.identity())).keySet();
//
//        return traidores;
//    }
}
