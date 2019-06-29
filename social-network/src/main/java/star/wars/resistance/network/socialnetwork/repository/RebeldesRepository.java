package star.wars.resistance.network.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import star.wars.resistance.network.socialnetwork.models.Rebelde;

@Repository
public interface RebeldesRepository extends JpaRepository<Rebelde, Long> {

    public Rebelde findByNome(String nome);
}
