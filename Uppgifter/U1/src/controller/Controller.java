package controller;

//only imports what is strictly necessary from view-package
import model.Pastries;
import model.PerUnitItems;
import view.MainFrame;
import view.ButtonType;
import model.Cake;
import model.Order;
import java.util.ArrayList;



public class Controller {
    private MainFrame view;
    private ButtonType currentLeftMenu = ButtonType.NoChoice;
    private Pastries [] cakeMenuObject;
    private String [] cakeMenuString;
    private Pastries [] perUnitItemMenuObject;
    private String [] perUnitItemMenuString;
    private Cake Prinsesstårta;
    private Cake Gräddtårta;
    private Cake Chokladtårta;
    private PerUnitItems Vetebulle;
    private PerUnitItems Pepparkaka;
    private PerUnitItems Hallongrotta;
    private ArrayList<Order> orderHistory;
    private Order currentOrder;


    public Controller() {
        perUnitItemMenuObject = new Pastries[3];
        perUnitItemMenuString = new String[3];
        cakeMenuObject = new Pastries[3];
        cakeMenuString = new String[3];
        Prinsesstårta = new Cake("Prinsesstårta");
        Chokladtårta = new Cake("Chokladtårta");
        Gräddtårta = new Cake("Gräddtårta");
        Vetebulle = new PerUnitItems("Vetebulle");
        Pepparkaka = new PerUnitItems("Pepparkaka");
        Hallongrotta = new PerUnitItems("Hallongrotta");
        view = new MainFrame(1000, 500, this);
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();
        orderHistory = new ArrayList<>();
        currentOrder = new Order();
    }


    //This method is called by class MainFrame when a button in the GUI is pressed
    public void buttonPressed(ButtonType button){

        switch (button) {
            case Add:
                addItemToOrder(view.getSelectionLeftPanel());
                break;

            case Cake:
                setToCakeMenu();
                break;

            case PerUnitItem:
                setToPerUnitItemMenu();
                break;

            case OrderHistory:
                setToOrderHistoryMenu();
                break;

            case Order:
                placeOrder();
                break;

            case ViewOrder:
                viewSelectedOrder(view.getSelectionLeftPanel());
                break;
        }
    }

    public void addItemToOrder(int selectionIndex) {
        if (selectionIndex != -1){ // if something is selected in the left menu list
            switch (currentLeftMenu) {
                case Cake:
                    currentOrder.addToOrder(cakeMenuObject[selectionIndex]);
                    break;
                case PerUnitItem:
                    currentOrder.addToOrder(perUnitItemMenuObject[selectionIndex]);
                    break;
            }

            view.populateRightPanel(currentOrder.toStringArray());
            view.setTextCostLabelRightPanel("Total cost of order: " + currentOrder.getCost()); //set the text to show cost of current order
        }

    }

    public void viewSelectedOrder(int selectionIndex){

        if ((selectionIndex != -1) && currentLeftMenu==ButtonType.OrderHistory){
            view.populateRightPanel(orderHistory.get(selectionIndex).toStringArray()); //update left panel with order details - this takes a shortcut in updating the entire information in the panel not just adds to the end
            view.setTextCostLabelRightPanel("Total cost of order: " + currentOrder.getCost()); //set the text to show cost of current order

        }
    }

    public void setToCakeMenu() {
        currentLeftMenu = ButtonType.Cake;
        cakeMenuString[0] = Prinsesstårta.toString();
        cakeMenuString[1] = Chokladtårta.toString();
        cakeMenuString[2] = Gräddtårta.toString();

        cakeMenuObject[0] = Prinsesstårta;
        cakeMenuObject[1] = Chokladtårta;
        cakeMenuObject[2] = Gräddtårta;

        view.populateLeftPanel(cakeMenuString);
        view.populateRightPanel(currentOrder.toStringArray()); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
        view.setTextCostLabelRightPanel("Total cost of order: " + currentOrder.getCost()); //set the text to show cost of current order
        view.enableAllButtons();
        view.disableCakeMenuButton();
        view.disableViewSelectedOrderButton();
    }

    public void setToPerUnitItemMenu() {
        currentLeftMenu = ButtonType.PerUnitItem;
        perUnitItemMenuString[0] = Vetebulle.toString();
        perUnitItemMenuString[1] = Pepparkaka.toString();
        perUnitItemMenuString[2] = Hallongrotta.toString();

        perUnitItemMenuObject[0] = Vetebulle;
        perUnitItemMenuObject[1] = Pepparkaka;
        perUnitItemMenuObject[2] = Hallongrotta;

        view.populateLeftPanel(perUnitItemMenuString);
        view.populateRightPanel(currentOrder.toStringArray()); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
        view.setTextCostLabelRightPanel("Total cost of order: " + currentOrder.getCost()); //set the text to show cost of current order
        view.enableAllButtons();
        view.disablePerUnitItemMenuButton();
        view.disableViewSelectedOrderButton();
    }

    public void setToOrderHistoryMenu() {
        currentLeftMenu = ButtonType.OrderHistory;
        view.clearRightPanel();
        String[] orderHistoryString = new String[orderHistory.size()];
        for (int i = 0; i<orderHistory.size();i++){
            orderHistoryString[i] = "Order: " + (i+1) + " Price: " + orderHistory.get(i).getCost();
        }
        view.populateLeftPanel(orderHistoryString);

        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableOrderButton();
    }

    public void placeOrder() {

        orderHistory.add(currentOrder);
        currentOrder = new Order();

        view.clearRightPanel(); //Removes information from right panel in GUI
        view.setTextCostLabelRightPanel("TOTAL COST: 0");
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();
    }

}
