package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
public class GameServiceTest {

    // mock de la clase MapService.
    @Mock
    private MapService mockMapService;

    //mock de la clase PlayerService.
    @Mock
    private PlayerService mockPlayerService;

    // Inyectamos los mocks en una instancia de la clase GameService.
    @InjectMocks
    private GameService gameService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks y las inyecciones de Mockito.
    }

    // Test para verificar que el método placeTower de GameService funciona correctamente.
    @Test
    public void testPlaceTower() {
        // mock de la clase TowerService.
        TowerService mockTower = mock(TowerService.class);
        // Llama al método placeTower de GameService con los parámetros mockTower, 2 y 2.
        gameService.placeTower(mockTower, 2, 2);
        // Verifica que el método placeTower del mock de MapService fue llamado con los parámetros mockTower, 2 y 2.
        verify(mockMapService).placeTower(mockTower, 2, 2);
    }
}
