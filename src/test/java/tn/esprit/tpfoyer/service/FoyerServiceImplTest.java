package tn.esprit.tpfoyer.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;

@ExtendWith(MockitoExtension.class)
public class FoyerServiceImplTest {

    @Mock
    private FoyerRepository foyerRepository;

    @InjectMocks
    private FoyerServiceImpl foyerService;

    private Foyer foyer;

    @BeforeEach
    void setUp() {
        foyer = new Foyer();
        foyer.setIdFoyer(1L);  // ← Assure-toi d'avoir le getter/setter généré
        foyer.setNomFoyer("Foyer A");
        foyer.setCapaciteFoyer(200);
    }

    @Test
    void testAddFoyer() {
        when(foyerRepository.save(foyer)).thenReturn(foyer);

        Foyer result = foyerService.addFoyer(foyer);  // ✅ nom de méthode corrigé

        assertNotNull(result);
        assertEquals("Foyer A", result.getNomFoyer());
        verify(foyerRepository).save(foyer);
    }

    @Test
    void testRetrieveFoyer() {
        when(foyerRepository.findById(1L)).thenReturn(Optional.of(foyer));

        Foyer result = foyerService.retrieveFoyer(1L);

        assertNotNull(result);
        assertEquals(200, result.getCapaciteFoyer());
        verify(foyerRepository).findById(1L);
    }

    @Test
    void testRemoveFoyer() {
        foyerService.removeFoyer(1L);  // ✅ nom corrigé

        verify(foyerRepository).deleteById(1L);
    }

    @Test
    void testModifyFoyer() {
        foyer.setCapaciteFoyer(300);
        when(foyerRepository.save(foyer)).thenReturn(foyer);

        Foyer result = foyerService.modifyFoyer(foyer);  // ✅ nom corrigé

        assertEquals(300, result.getCapaciteFoyer());
        verify(foyerRepository).save(foyer);
    }

    @Test
    void testRetrieveAllFoyers() {
        List<Foyer> foyers = Collections.singletonList(foyer);
        when(foyerRepository.findAll()).thenReturn(foyers);

        List<Foyer> result = foyerService.retrieveAllFoyers();

        assertEquals(1, result.size());
        verify(foyerRepository).findAll();
    }
}
