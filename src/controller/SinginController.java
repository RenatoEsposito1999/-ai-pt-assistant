package src.controller;

import src.view.SinginView;

public class SinginController {
    private SinginView singinView;
    private NavigationController navigationController;

    public SinginController(NavigationController navigationController){
        this.navigationController = navigationController;
        this.singinView = new SinginView();
        initialize();
    }

    private void initialize(){
        // logica della registrazione quindi prnedere i dati
        // chiamare il service questo istanzierà il model e infine il controller questo aggiorna la view.
    }

    public SinginView getView(){
        return this.singinView;
    }
}
