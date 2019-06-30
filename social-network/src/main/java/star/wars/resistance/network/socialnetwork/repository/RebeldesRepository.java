package star.wars.resistance.network.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import star.wars.resistance.network.socialnetwork.models.Rebelde;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface RebeldesRepository extends JpaRepository<Rebelde, Long>, CrudRepository<Rebelde, Long> {


}
