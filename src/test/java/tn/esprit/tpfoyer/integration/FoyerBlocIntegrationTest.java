//package tn.esprit.tpfoyer.integration;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import tn.esprit.tpfoyer.entity.Bloc;
//import tn.esprit.tpfoyer.entity.Foyer;
//import tn.esprit.tpfoyer.repository.BlocRepository;
//import tn.esprit.tpfoyer.repository.FoyerRepository;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//public class FoyerBlocIntegrationTest {
//
//    @Autowired
//    FoyerRepository foyerRepository;
//
//    @Autowired
//    BlocRepository blocRepository;
//
//    @Test
//    public void testCreateBlocWithFoyer() {
//        // Création d’un foyer
//        Foyer foyer = new Foyer();
//        foyer.setNomFoyer("Foyer Esprit");
//        foyer.setCapaciteFoyer(500);
//        foyer = foyerRepository.saveAndFlush(foyer); // flush pour forcer la persistance
//
//        // Création d’un bloc et liaison avec le foyer
//        Bloc bloc = new Bloc();
//        bloc.setNomBloc("Bloc A");
//        bloc.setCapaciteBloc(100);
//        bloc.setFoyer(foyer);
//        bloc = blocRepository.saveAndFlush(bloc); // flush pour forcer la persistance
//
//        // Vérifications
//        Optional<Bloc> blocOptional = blocRepository.findById(bloc.getIdBloc());
//        assertThat(blocOptional).isPresent();
//
//        Bloc savedBloc = blocOptional.get();
//        assertThat(savedBloc.getFoyer()).isNotNull();
//        assertThat(savedBloc.getFoyer().getNomFoyer()).isEqualTo("Foyer Esprit");
//
//        Optional<Foyer> foyerOptional = foyerRepository.findById(foyer.getIdFoyer());
//        assertThat(foyerOptional).isPresent();
//    }
//}