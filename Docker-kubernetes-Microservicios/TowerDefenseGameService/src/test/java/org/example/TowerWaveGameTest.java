//package org.example;
//
//import org.example.TypeEnemy.BasicEnemy;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.Collections;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//public class TowerWaveGameTest {
//    @Mock
//    private Map mockMap;
//
//    @Mock
//    private Wave mockWave;
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
//    public void testStartWave_WithEnemies() {
//        when(mockWave.spawnEnemies(any(Map.class), any(Player.class))).thenReturn(Arrays.asList(new BasicEnemy()));
//        game.setWave(mockWave);
//        game.startWave();
//        // Verificar que los enemigos han sido generados y la oleada ha comenzado
//        assertFalse(game.getEnemies().isEmpty());
//    }
//
//    @Test
//    public void testStartWave_NoEnemies() {
//        when(mockWave.spawnEnemies(any(Map.class), any(Player.class))).thenReturn(Collections.emptyList());
//        game.setWave(mockWave);
//        game.startWave();
//        // Verificar que no se han generado enemigos
//        assertTrue(game.getEnemies().isEmpty());
//    }
//}
