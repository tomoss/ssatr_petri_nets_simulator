package simulator;

import model.Location;
import model.Transition;

import java.util.ArrayList;
import java.util.List;

public class PetriNet {

    private PetriNet(){};

    private static PetriNet instance = new PetriNet();

    public static PetriNet getInstance() {
        return instance;
    }

    List<Location> locations = new ArrayList<Location>();
    List<Transition> transitions = new ArrayList<Transition>();

    public void addLocation(Location location){
        locations.add(location);
    }

    public void addTransition(Transition transition){
        transitions.add(transition);
    }

}
