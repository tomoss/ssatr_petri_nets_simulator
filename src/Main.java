import simulator.Simulator;
import utils.JsonLoader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        int steps = 15;
        JsonLoader jsonLoader = new JsonLoader();

        if(jsonLoader.loadJson("src/files/input.json")){

            System.out.println("JSON successfully loaded !");
            try {
                Simulator simulator = new Simulator("src/files/output.txt");
                simulator.setSteps(steps);
                simulator.simulatePetriNet();
                simulator.closeFile();

            } catch (IOException e) {
                e.printStackTrace();
            }


        } else {
            System.out.println("JSON couldn't be loaded !");
        }

    }
}
