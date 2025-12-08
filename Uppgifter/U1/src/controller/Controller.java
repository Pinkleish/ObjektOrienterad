package controller;

//only imports what is strictly necessary from view-package
import model.Pastries;
import model.PerUnitItems;
import view.MainFrame;
import view.ButtonType;
import model.Cake;
import model.PerUnitItems;


public class Controller {
    private MainFrame view;
    private ButtonType currentLeftMenu = ButtonType.NoChoice;
    private String [] cakeMenuString; // for test purposes only
    private String [] perUnitItemMenuString; // for test purposes only
    private String [] orderHistoryMenuString; // for test purposes only
    private String [] order1Simulation; // for test purposes only
    private String [] currentOrderArray; // for test purposes only
    private double costCurrentOrder = 0; // for test purposes only
    private int nbrOfOrders = 0; // for test purposes only
    private Cake Prinsesstårta;
    private Cake Gräddtårta;
    private Cake Chokladtårta;
    private PerUnitItems Vetebulle;
    private PerUnitItems Pepparkaka;
    private PerUnitItems Hallongrotta;


    public Controller() {
        Prinsesstårta = new Cake("Prinsesstårta");
        Chokladtårta = new Cake("Chokladtårta");
        Gräddtårta = new Cake("Gräddtårta");
        Vetebulle = new PerUnitItems("Vetebulle");
        Pepparkaka = new PerUnitItems("Pepparkaka");
        Hallongrotta = new PerUnitItems("Hallongrotta");
        view = new MainFrame(1000, 500, this);
        loadStringTestValues(); //for test purposes - remove when not needed more
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();



    }

    //This method is only used for test purposes - remove when no longer needed
    private void loadStringTestValues() {
        cakeMenuString = new String[10];
        perUnitItemMenuString = new String[10];
        orderHistoryMenuString = new String[10];
        order1Simulation = new String[10];
        currentOrderArray = new String[10];

        cakeMenuString[0] = Prinsesstårta.getName() + Prinsesstårta.getSize() + Prinsesstårta.getFilling1() + Prinsesstårta.getFilling2() + Prinsesstårta.getTopping() + Prinsesstårta.getCost();
        cakeMenuString[1] = Chokladtårta.getName() + Chokladtårta.getSize() + Chokladtårta.getFilling1() + Chokladtårta.getFilling2() + Chokladtårta.getTopping() + Chokladtårta.getCost();
        cakeMenuString[2] = Gräddtårta.getName() + Gräddtårta.getSize() + Gräddtårta.getFilling1() + Gräddtårta.getFilling2() + Gräddtårta.getTopping() + Gräddtårta.getCost();
        //cakeMenuString[3] = "tårta3, storlek: 12 bitar,topping1, topping3, Pris3";

        perUnitItemMenuString[0] = Vetebulle.getName() + " " + Vetebulle.getCost();
        perUnitItemMenuString[1] = Pepparkaka.getName() + " " + Pepparkaka.getCost();
        perUnitItemMenuString[2] = Hallongrotta.getName() + " " + Hallongrotta.getCost();

        orderHistoryMenuString[0] = "order1: kostnad:" + order1Simulation[0].getCost(); // OBS !! Behöver en polymorfisk lista för order & en lista som visar ordern i sträng
        orderHistoryMenuString[1] = "order2: kostand:200";

        order1Simulation[0] = Vetebulle.getName();
        order1Simulation[1] = Hallongrotta.getName();
        order1Simulation[2] = Prinsesstårta.getName();
        order1Simulation[3] = Chokladtårta.getName();

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
        System.out.println("Index selection left panel: " + selectionIndex); //for test purposes  - remove when not needed

        if (selectionIndex != -1){ // if something is selected in the left menu list
            switch (currentLeftMenu) { //This might need to change depending on architecture
                case Cake:
                    currentOrderArray[nbrOfOrders] = cakeMenuString[selectionIndex].toString(); //for test purposes - needs to be replaced with solution of finding chosen menu item matching architecture for model
                    break;
                case PerUnitItem:
                    currentOrderArray[nbrOfOrders] = perUnitItemMenuString[selectionIndex].toString(); //see comment for case above
                    break;
            }
            nbrOfOrders++; //for test purposes - need to be removed or changed when model for handling orders is implemented
            costCurrentOrder = costCurrentOrder + 100; //for test purposes - replace with calculation of cost when how orders are handled is implemented in model
            view.populateRightPanel(currentOrderArray); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
            view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
        }

    }

    public void viewSelectedOrder(int selectionIndex){
        System.out.println("Index selection left panel: " + selectionIndex); //for test purposes  - remove when not needed

        if ((selectionIndex != -1) && currentLeftMenu==ButtonType.OrderHistory){
            costCurrentOrder = 100; //for test purposes - replace with calculation of cost when how orders are handled is implemented in model
            view.populateRightPanel(order1Simulation); //update left panel with order details - this takes a shortcut in updating the entire information in the panel not just adds to the end
            view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
        }
    }

    public void setToCakeMenu() {
        currentLeftMenu = ButtonType.Cake;
        view.populateLeftPanel(cakeMenuString);
        view.populateRightPanel(currentOrderArray); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
        view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
        view.enableAllButtons();
        view.disableCakeMenuButton();
        view.disableViewSelectedOrderButton();
    }

    public void setToPerUnitItemMenu() {
        currentLeftMenu = ButtonType.PerUnitItem;
        view.populateLeftPanel(perUnitItemMenuString);
        view.populateRightPanel(currentOrderArray); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
        view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
        view.enableAllButtons();
        view.disablePerUnitItemMenuButton();
        view.disableViewSelectedOrderButton();
    }

    public void setToOrderHistoryMenu() {
        currentLeftMenu = ButtonType.OrderHistory;
        view.clearRightPanel();
        view.populateLeftPanel(orderHistoryMenuString);
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableOrderButton();
    }

    public void placeOrder() {
        System.out.println("Pressed Order to create a new order"); //for test purposes - remove when not needed more
        currentOrderArray = new String[10];  // for test purposes - remove when not needed more
        costCurrentOrder = 0;
        view.clearRightPanel(); //Removes information from right panel in GUI
        view.setTextCostLabelRightPanel("TOTAL COST: 0");
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();
    }


}
