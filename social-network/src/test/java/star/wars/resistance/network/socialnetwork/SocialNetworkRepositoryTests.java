package star.wars.resistance.network.socialnetwork;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import star.wars.resistance.network.socialnetwork.models.Rebelde;
import star.wars.resistance.network.socialnetwork.repository.RebeldesRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SocialNetworkRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RebeldesRepository rebeldesRepository;

    @Test
    public void criaEVerificaNoRepositorio_Test() {

        Rebelde r = new Rebelde("Gilvando", 26);

        entityManager.persist(r);
        entityManager.flush();


        Rebelde rebelde = rebeldesRepository.findByNome(r.getNome());

        assertThat(r.getNome()).isEqualTo(rebelde.getNome());

    }

    @Test
    public void alteraLocalizacaoDoRebelde_Test() {

        Rebelde rebelde = new Rebelde("Gilvando", 26);

        entityManager.persist(rebelde);
        entityManager.flush();


        rebelde.novaLocalizacao(-1, 1, "Sistema Solar/Terra");

        entityManager.persist(rebelde);
        entityManager.flush();

        Rebelde r = rebeldesRepository.findByNome("Gilvando");

        assertThat(rebelde.getLocal()).isEqualTo(r.getLocal());

    }

    @Test
    public void criaTresMarcadoresParaUmRebelde_Test() {
        Rebelde rebelde = new Rebelde("Gilvando", 26);
        Rebelde r1 = new Rebelde();
        Rebelde r2 = new Rebelde();
        Rebelde r3 = new Rebelde();


        entityManager.persist(rebelde);
        entityManager.persist(r1);
        entityManager.persist(r2);
        entityManager.persist(r3);
        entityManager.flush();

        rebelde.adicionarMarcador(r1);
        rebelde.adicionarMarcador(r2);
        rebelde.adicionarMarcador(r3);

        entityManager.persist(rebelde);
        entityManager.flush();

        assertThat(rebelde.isTraidor()).isEqualTo(true);


    }


}
