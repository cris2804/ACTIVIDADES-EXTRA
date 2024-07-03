package org.example;
import java.util.*;
public class GameService {
    private MapService mapService;  // Servicio para gestionar el mapa del juego
    private PlayerService playerService;  // Servicio para gestionar el estado del jugador
    private List<WaveService> waves;  // Lista de oleadas de enemigos

    // Constructor para  inicializar los servicios del mapa, jugador y la lista de oleadas
    public GameService() {
        this.mapService = new MapService();
        this.playerService = new PlayerService();
        this.waves = new ArrayList<>();
    }

    // Método para colocar una torre en la posición (x,y)   del mapa
    public void placeTower(TowerService tower, int x, int y) {
        mapService.placeTower(tower, x, y);
    }

    // Método para iniciar una nueva oleada de enemigos
    public void startWave() {
        WaveService wave = new WaveService();
        waves.add(wave);  // Añade la oleada a la lista de oleadas
        wave.start();  // Inicia la oleada
    }

    // Método para mostrar el estado actual del juego
    public void gameState() {
        System.out.println(mapService);  // Muestra el estado del mapa
        System.out.println("Puntuación: " + playerService.getScore());  // Muestra la puntuación del jugador
        System.out.println("Vida de la base: " + playerService.getBaseHealth());  // Muestra la vida de la base del jugador
    }
    public static void main(String[] args) {
        GameService game = new GameService();  // Inicializa un nuevo juego
        TowerService tower = new TowerService('T');  // Crea una nueva torre con el símbolo 'T'

        game.placeTower(tower, 2, 2);  // Coloca la torre en la posición (2, 2) del mapa
        game.startWave();  // Inicia una nueva oleada de enemigos
        game.gameState();  // Muestra el estado actual del juego
    }


}
