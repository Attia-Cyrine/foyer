package tn.esprit.tpfoyer.service;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlocServiceImpl implements IBlocService {

    private static final Logger log = LoggerFactory.getLogger(BlocServiceImpl.class);

    private final BlocRepository blocRepository;

    public BlocServiceImpl(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
    }

    @Scheduled(fixedRate = 30000) // Exécute toutes les 30 secondes
    public List<Bloc> retrieveAllBlocs() {
        List<Bloc> listB = blocRepository.findAll();
        log.info("Taille totale : {}", listB.size());
        for (Bloc b : listB) {
            log.info("Bloc : {}", b);
        }
        return listB;
    }

    @Transactional
    public List<Bloc> retrieveBlocsSelonCapacite(long c) {
        List<Bloc> listB = blocRepository.findAll();
        List<Bloc> listBselonC = new ArrayList<>();

        for (Bloc b : listB) {
            if (b.getCapaciteBloc() >= c) {
                listBselonC.add(b);
            }
        }

        return listBselonC;
    }

    @Transactional
    public Bloc retrieveBloc(Long blocId) {
        return blocRepository.findById(blocId).orElse(null);
    }

    public Bloc addBloc(Bloc c) {
        return blocRepository.save(c);
    }

    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    public void removeBloc(Long blocId) {
        blocRepository.deleteById(blocId);
    }

    public List<Bloc> trouverBlocsSansFoyer() {
        return blocRepository.findAllByFoyerIsNull();
    }

    public List<Bloc> trouverBlocsParNomEtCap(String nb, long c) {
        return blocRepository.findAllByNomBlocAndCapaciteBloc(nb, c);
    }
}
