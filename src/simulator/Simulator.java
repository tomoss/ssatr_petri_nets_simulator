package simulator;

public class Simulator {

    int steps;
    PetriNet petriNet = PetriNet.getInstance();


    public Simulator(int steps){
        this.steps = steps;
    }
}
