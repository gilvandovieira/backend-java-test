package star.wars.resistance.network.socialnetwork;

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

    @Test
    public void criaEVerificaNoRepositorio_Test() {

        Rebelde r = new Rebelde("Gilvando", 26);

        rebeldesService.novo(r);

        Rebelde rebelde = rebeldesService.rebelde(r.getId());

        assertThat(r.getNome()).isEqualTo(rebelde.getNome());

    }

    @Test
    public void alteraLocalizacaoDoRebelde_Test() {

        Rebelde rebelde = new Rebelde("Gilvando", 26);

        rebeldesService.novo(rebelde);

        Localizacao l = new Localizacao(-1, 1, "Sistema Solar/Terra");

        rebeldesService.atualizarLocalizacao(l, rebelde.getId());

        Rebelde r = rebeldesService.rebelde(rebelde.getId());

        assertThat(rebelde.getLocalizacao()).isEqualTo(null);
        assertThat(r.getLocalizacao().getLocal()).isEqualTo(l.getLocal());

    }


    @Test
    public void negociaItemComRebelde_Test(){
        Rebelde r1 = new Rebelde("Gilvando 1", 26);
        Rebelde r2 = new Rebelde("Gilvando 2", 26);

        r1.setItems(new Item(5l,5l,5l,5l));
        r2.setItems(new Item(7l,7l,7l,7l));

        rebeldesService.novo(r1);
        rebeldesService.novo(r2);


        rebeldesService.negociarItems(r2,r1,new Item(1l,0l,2l,3l));

        assertThat(r1.getItems().getAgua()).isEqualTo(6l);
        assertThat(r1.getItems().getArma()).isEqualTo(5l);
        assertThat(r1.getItems().getComida()).isEqualTo(7l);
        assertThat(r1.getItems().getMunicao()).isEqualTo(8l);
    }

    @Test
    public void totalDePontosDoRebelde(){
        Rebelde r1 = new Rebelde("Gilvando 1", 26);
        r1.setItems(new Item(5l,5l,5l,5l));
        rebeldesService.novo(r1);

        assertThat(rebeldesService.pontosDoRebelde(r1)).isEqualTo(50l);
    }

}
