import simulator.Simulator;
import utils.JsonLoader;

public class Main {

    public static void main(String[] args) {

        int steps = 10;
        JsonLoader jsonLoader = new JsonLoader();

        if(jsonLoader.loadJson("src/files/input.json")){

            System.out.println("JSON successfully loaded !");
            Simulator simulator = new Simulator(steps);
            simulator.simulatePetriNet();

        } else {
            System.out.println("JSON couldn't be loaded !");
        }

    }
}
