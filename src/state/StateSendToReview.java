/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

/**
 *
 * @author sicov
 */
public class StateSendToReview implements State{

    @Override
    public String returnCurrentState() {
        return "State SEND TO REVIEW.";
    }
    
}
