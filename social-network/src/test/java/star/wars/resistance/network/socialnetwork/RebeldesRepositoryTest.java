package star.wars.resistance.network.socialnetwork;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import star.wars.resistance.network.socialnetwork.models.Localizacao;
import star.wars.resistance.network.socialnetwork.models.Rebelde;
import star.wars.resistance.network.socialnetwork.repository.RebeldesRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest //TODO
public class RebeldesRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RebeldesRepository rebeldesRepository;

    @Test
    public void criaEVerificaNoRepositorio_Test() {

        Rebelde r = new Rebelde("Gilvando", 26);

        entityManager.persist(r);
        entityManager.flush();


        Rebelde rebelde = rebeldesRepository.findById(r.getId()).get();

        assertThat(r.getNome()).isEqualTo(rebelde.getNome());

    }

    @Test
    public void alteraLocalizacaoDoRebelde_Test() {

        Rebelde rebelde = new Rebelde("Gilvando", 26);

        entityManager.persist(rebelde);
        entityManager.flush();


        rebelde.setLocalizacao(new Localizacao( -1, 1, "Sistema Solar/Terra"));

        entityManager.persist(rebelde);
        entityManager.flush();

        Rebelde r = rebeldesRepository.findById(rebelde.getId()).get();

        assertThat(rebelde.getLocalizacao().getLocal()).isEqualTo(r.getLocalizacao().getLocal());

    }

}
