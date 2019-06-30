package star.wars.resistance.network.socialnetwork;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import star.wars.resistance.network.socialnetwork.models.Item;
import star.wars.resistance.network.socialnetwork.models.Localizacao;
import star.wars.resistance.network.socialnetwork.models.Rebelde;
import star.wars.resistance.network.socialnetwork.service.RebeldesService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RebeldesServiceTest {

    @Autowired
    private RebeldesService rebeldesService;

    Rebelde r1, r2, r3;
    Localizacao l;

    @Before
    public void setUp() {

        r1 = new Rebelde("Gilvando 1", 26);
        r2 = new Rebelde("Gilvando 2", 26);
        r3 = new Rebelde();

        rebeldesService.novo(r1);
        rebeldesService.novo(r2);
        rebeldesService.novo(r3);

        r1.setItems(new Item(5l, 5l, 5l, 5l));
        r2.setItems(new Item(7l, 7l, 7l, 7l));
        r3.setItems(new Item(6l, 6l, 6l, 6l));

        rebeldesService.atualiza(r1);
        rebeldesService.atualiza(r2);
        rebeldesService.atualiza(r3);

        l = new Localizacao(-1, 1, "Sistema Solar/Terra");

        rebeldesService.atualizarLocalizacao(l, r1);

        rebeldesService.toggleTraidor(r3);
    }

    @Test
    public void criaEVerificaNoRepositorio_Test() {

        Rebelde rebelde = rebeldesService.rebelde(r1.getId());

        assertThat(r1.getNome()).isEqualTo(rebelde.getNome());

    }

    @Test
    public void alteraLocalizacaoDoRebelde_Test() {

        assertThat(r1.getLocalizacao().getLocal()).isEqualTo(l.getLocal());

    }


    @Test
    public void negociaItemComRebelde_Test() {

        rebeldesService.negociarItems(r2, r1, new Item(1l, 0l, 2l, 3l));

        assertThat(r1.getItems().getAgua()).isEqualTo(6l);
        assertThat(r1.getItems().getArma()).isEqualTo(5l);
        assertThat(r1.getItems().getComida()).isEqualTo(7l);
        assertThat(r1.getItems().getMunicao()).isEqualTo(8l);
    }

    @Test
    public void totalDePontosDoRebelde() {

        assertThat(rebeldesService.pontosDoRebelde(r1)).isEqualTo(50l);
    }


    @Test
    public void porcentagemDeTraidores_Test() {

        assertThat(rebeldesService.porcentagemDeTraidores()).isBetween(0.3, 0.4);
    }

    @Test
    public void porcentagemDeRebeldes_Test() {

        assertThat(rebeldesService.porcentagemDeRebeldes()).isBetween(0.6, 0.7);
    }

    @Test
    public void mediaDasAguas_Test() {

        assertThat(rebeldesService.mediaDeAgua()).isBetween(5.9, 6.1);

    }

    @Test
    public void mediaDasArmas_Test() {

        assertThat(rebeldesService.mediaDeArma()).isBetween(5.9, 6.1);

    }

    @Test
    public void mediaDasComidas_Test() {

        assertThat(rebeldesService.mediaDeComida()).isBetween(5.9, 6.1);

    }

    @Test
    public void mediaDasMunicao_Test() {

        assertThat(rebeldesService.mediaDeMunicao()).isBetween(5.9, 6.1);

    }
}
