package Controller;
import view.MainFrame;

public class Controller {
    private MainFrame view;


    public Controller() {
        view = new MainFrame(1000, 500, this);
    }
}