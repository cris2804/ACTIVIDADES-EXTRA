package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
public class TowerDefenseGameTest {
    @Mock
    private Map mockMap;
    @Mock
    private Player mockPlayer;
    @InjectMocks
    private TowerDefenseGame game;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testPlaceTower() {
        Tower mockTower = mock(Tower.class);
        game.placeTower(mockTower, 2, 2);
        verify(mockMap).placeTower(mockTower, 2, 2);
    }
}

//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.*;

//public class TowerDefenseGameTest {
//    private TowerDefenseGame game;
//    private Map map;
//    private Player player;
//    private Wave wave;
//
//    @BeforeEach
//    public void setUp() {
//        map = Mockito.mock(Map.class);
//        player = Mockito.mock(Player.class);
//        wave = Mockito.mock(Wave.class);
//        game = new TowerDefenseGame();
//    }
//
//    @Test
//    public void testStartGame() {
//        wave.start();
//        game.startWave();
//        verify(wave).start();
//    }
//}

