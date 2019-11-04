package simulator;

import model.Location;
import model.Transition;
import utils.FileSaver;

import java.io.IOException;

public class Simulator {

    int steps;
    PetriNet petriNet = PetriNet.getInstance();

    public Simulator(int steps){
        this.steps = steps;
    }

    boolean checkInputTokens(Transition transition){
        boolean status = true;
        if(transition.getInput().size() == 0)
            return false;
        for(int i = 0; i < transition.getInput().size(); i++){
            Location location = petriNet.getLocationById(transition.getInput().get(i));
            if(location.getTokens() == 0)
                status = false;
        }
        return status;
    }

    void takeInputTokens(Transition transition){
        for(int i = 0; i < transition.getInput().size(); i++){
            Location location = petriNet.getLocationById(transition.getInput().get(i));
            if(location.decreaseTokens())
                System.out.println("Token token from "+location.getId());

            else
                System.out.println("Error ! No tokens in "+location.getId());
        }
        transition.addTempToken();
        System.out.println("Token added in "+transition.getId());
        transition.setDelay();
    }

    void putOutputTokens(Transition transition){
        if(transition.getDelay() == 0) {
            if (transition.decreaseTokens()) {
                System.out.println("Temp token taken from " + transition.getId());
                for (int i = 0; i < transition.getOutput().size(); i++) {
                    Location location = petriNet.getLocationById(transition.getOutput().get(i));
                    location.addToken();
                    System.out.println("Token added in " + location.getId());
                }
            } else {
                //System.out.println("No temp token in " + transition.getId());
            }
        } else {
            System.out.println(transition.getId()+" has delay: "+transition.getDelay());
        }
    }

    void checkAllTransitions(){
        for (int i = 0; i < petriNet.getTransitions().size(); i++) {

            Transition transition = petriNet.getTransitions().get(i);

            if(transition.getDelay() > 0){
                transition.decreaseDelay();
            }

            if(transition.getTempTokens() == 0) {
                if (true == checkInputTokens(transition)) {
                    System.out.println("Valid input for " + transition.getId());
                    takeInputTokens(transition);
                } else {
                    //System.out.println("No valid input for " + transition.getId());
                }
            } else
                System.out.println("Transition "+transition.getId()+" already activated");
        }
        for (int i = 0; i < petriNet.getTransitions().size(); i++) {
            Transition transition = petriNet.getTransitions().get(i);
            putOutputTokens(transition);
        }
    }

    public void simulatePetriNet(){
        for(int i = 0; i < steps; i++){
            printPnState();
            checkAllTransitions();
        }
    }

    void printPnState(){
        System.out.println();
        String output;
        petriNet.locations.forEach(location ->{
            System.out.print("| "+location.getId() + ": "+location.getTokens()+" ");
        });
        System.out.println();
        petriNet.transitions.forEach(transition -> System.out.print("| "+transition.getId()+" : "+transition.getTempTokens()+" "));
        System.out.println();
    }




}
