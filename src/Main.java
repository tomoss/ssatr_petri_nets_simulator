import simulator.Simulator;
import utils.FileSaver;
import utils.JsonLoader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        int steps = 15;
        JsonLoader jsonLoader = new JsonLoader();

        if(jsonLoader.loadJson("src/files/no_delay.json")){

            System.out.println("JSON successfully loaded !");
            Simulator simulator = new Simulator(steps);
            simulator.simulatePetriNet();
            
        } else {
            System.out.println("JSON couldn't be loaded !");
        }

    }
}
