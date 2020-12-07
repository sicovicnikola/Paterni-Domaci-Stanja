/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import state.State;
import state.StateWritingPaper;


/**
 *
 * @author Dusan
 */
public class Paper {
    private State state;
    
    public Paper() {
        state = new StateWritingPaper();
        // pocetno stanje
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    
}
