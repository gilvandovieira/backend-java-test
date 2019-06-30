package star.wars.resistance.network.socialnetwork;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import star.wars.resistance.network.socialnetwork.models.Rebelde;
import star.wars.resistance.network.socialnetwork.models.Traicao;
import star.wars.resistance.network.socialnetwork.repository.RebeldesRepository;
import star.wars.resistance.network.socialnetwork.repository.TraicaoRepository;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest //TODO
public class TraicaoReposiotoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TraicaoRepository traicaoRepository;

    @Autowired
    private RebeldesRepository rebeldesRepository;

    private Rebelde r1, r2, r3, r4;
    private Traicao t1, t2, t3, t4, t5, t6, t7, t8, t9;

    @Before
    public void setUp() {
        r1 = new Rebelde("Gilvando", 26);
        r2 = new Rebelde("Maria", 34);
        r3 = new Rebelde("Joao", 28);
        r4 = new Rebelde("Leia", 31);

        rebeldesRepository.saveAndFlush(r1);
        rebeldesRepository.saveAndFlush(r2);
        rebeldesRepository.saveAndFlush(r3);
        rebeldesRepository.saveAndFlush(r4);

        t1 = new Traicao(r1, r2);
        t2 = new Traicao(r1, r3);
        t3 = new Traicao(r1, r4);
        t4 = new Traicao(r2, r3);
        t5 = new Traicao(r2, r4);
        t6 = new Traicao(r3, r4);

        t7 = new Traicao(r2, r1);

        traicaoRepository.saveAndFlush(t1);
        traicaoRepository.saveAndFlush(t2);
        traicaoRepository.saveAndFlush(t3);
        traicaoRepository.saveAndFlush(t4);
        traicaoRepository.saveAndFlush(t5);
        traicaoRepository.saveAndFlush(t6);
        traicaoRepository.saveAndFlush(t7);
    }


    @Test
    public void pegaListaDeTraidores_Test() {
        Rebelde rebelde = rebeldesRepository.findAll().get(0);

        List<Traicao> rebeldes = traicaoRepository.findByTraido(rebelde);

        assertThat(rebeldes.size()).isEqualTo(3);

    }

    @Test
    public void contaQuantasTraicoes_Test() {

        Long contado = traicaoRepository.countByTraido(r1);

        assertThat(contado).isEqualTo(3l);

        contado = traicaoRepository.countByTraido(r2);

        assertThat(contado).isEqualTo(3l);

    }

    @Test
    public void pegaTodasTraicoesPorTraido_Test() {
        Set<Rebelde> traidores = traicaoRepository.getRebeldesComTraicoesMaiorQueTres();

        assertThat(traidores.contains(r1)).isEqualTo(true);

    }
}
