//package org.example;
//import org.example.TypeTower.CannonTower;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.*;
//
//public class TowerDefenseeGameeTest {
//    @Mock
//    private Map mockMap;
//
//    @Mock
//    private Player mockPlayer;
//
//    private TowerDefenseGame game;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        game = new TowerDefenseGame(mockMap, mockPlayer);
//    }
//
//    @Test
//    public void testPlaceTower_ValidPosition() {
//        // Configurar mock para posición válida
//        when(mockMap.isValidPosition(3, 4)).thenReturn(true);
//        game.placeTower(new CannonTower(), 3, 4);
//        // Verificar que la torre se haya colocado
//        verify(mockMap).placeTower(any(Tower.class), eq(3), eq(4));
//    }
//
//    @Test
//    public void testPlaceTower_InvalidPosition() {
//        // Configurar mock para posición inválida
//        when(mockMap.isValidPosition(3, 4)).thenReturn(false);
//        game.placeTower(new CannonTower(), 3, 4);
//        // Verificar que la torre no se haya colocado
//        verify(mockMap, never()).placeTower(any(Tower.class), eq(3), eq(4));
//    }
//}
