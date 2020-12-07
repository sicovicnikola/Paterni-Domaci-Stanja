/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import context.Paper;
import java.util.Scanner;
import state.State;
import state.StateAccept;
import state.StateCancel;
import state.StateReject;
import state.StateSendToReview;
import state.StateWritingPaper;

/**
 *
 * @author Dusan
 */
public class PaperReviewProcess {

    private final Paper paper;

    public PaperReviewProcess() {
        paper = new Paper();

    }

    @SuppressWarnings("empty-statement")
    public void reviewPaperProcess() {
        Scanner input = new Scanner(System.in);
        int choise;

        do {
            System.out.println("1.Get current state");
            System.out.println("2.Do something with paper in curent state");
            System.out.println("3.Exit application");
            System.out.println("Your choise is:");
            choise = input.nextInt();

            switch (choise) {
                case 1:
                    System.out.println("Paper current state: " + paper.getState().returnCurrentState());

                    break;
                case 2:

                    // ako je trenutno stanje 'Writing' tada se prikazuje sledeci meni
                    if (paper.getState() instanceof StateWritingPaper) {
                        int choise2;
                        System.out.println("-------------------------");
                        System.out.println("I still writing paper!!!");
                        System.out.println("-------------------------");

                        System.out.println("1.I want to write paper more.");
                        System.out.println("2.I will cancel writing.");
                        System.out.println("3.I want to send paper to review.");
                        System.out.println("Your choise is:");
                        choise2 = input.nextInt();

                        switch (choise2) {
                            case 1:
                                paper.setState(new StateWritingPaper());
                                break;
                            case 2:
                                paper.setState(new StateCancel());
                                break;
                            case 3:
                                paper.setState(new StateSendToReview());

                                break;
                        }
                        while (choise2 == Integer.MAX_VALUE);
                        break;
                    }
                    // ako je trenutno stanje 'Send to Review' prikazuje se sledeci meni
                    if (paper.getState() instanceof StateSendToReview) {
                        int choise3;
                        System.out.println("-------------------------");
                        System.out.println("Paper is under review!!!");
                        System.out.println("-------------------------");

                        System.out.println("1.I need to review paper more.");
                        System.out.println("2.I want to reject paper.");
                        System.out.println("3.I want to accept paper.");
                        System.out.println("4.I want to send paper for revision.");
                        System.out.println("Your choise is:");
                        choise3 = input.nextInt();

                        switch (choise3) {
                            case 1:
                                paper.setState(new StateSendToReview());

                                break;
                            case 2:
                                paper.setState(new StateReject());

                                break;
                            case 3:
                                paper.setState(new StateAccept());
                                break;
                            case 4:
                                paper.setState(new StateWritingPaper());
                                break;
                        }
                        while (choise3 == Integer.MAX_VALUE);
                        break;
                    }
                    //ako je trenutno stanje 'Accept' opcija 2 prikazuje 
                    if(paper.getState() instanceof StateAccept){
                        System.out.println("-------------------------");
                        System.out.println("Paper is accepted.");
                        System.out.println("-------------------------");
                        
                        break;
                    }
                    // ako je trenutno stanje 'Reject' opcija 2 prikazuje
                     if(paper.getState() instanceof StateReject){
                        System.out.println("-------------------------");
                        System.out.println("Paper is rejected.");
                        System.out.println("-------------------------");
                        
                        break;
                     }
                     
                    //ako je trenutno stanje 'Cancel' opcija 2 prikazuje  
                     if(paper.getState() instanceof StateCancel){
                        System.out.println("-------------------------");
                        System.out.println("Paper is canceled.");
                        System.out.println("-------------------------");
                        
                        break;
                     }
                    break;

                case 3:
                    break;

            }
        } while (choise != 3);

        input.close();
    }

}
