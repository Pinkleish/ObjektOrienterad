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
    private Pastries [] cakeMenuObject;
    private String [] cakeMenuString;
    private Pastries [] perUnitItemMenuObject;// for test purposes only
    private String [] perUnitItemMenuString;
    private String [] orderHistoryMenuString; // for test purposes only
    private Pastries [] currentOrderArray; // for test purposes only
    private String [] currentOrderArrayString;
    private double costCurrentOrder = 0; // for test purposes only
    private int nbrOfOrders = 0; // for test purposes only
    private Cake Prinsesstårta;
    private Cake Gräddtårta;
    private Cake Chokladtårta;
    private PerUnitItems Vetebulle;
    private PerUnitItems Pepparkaka;
    private PerUnitItems Hallongrotta;
    private Pastries [][] orderHistoryArray;
    int number = 0;
    private String [][] orderHistoryArrayString;


    public Controller() {
        perUnitItemMenuObject = new Pastries[3];
        perUnitItemMenuString = new String[3];
        cakeMenuObject = new Pastries[3];
        cakeMenuString = new String[3];
        currentOrderArray = new Pastries[10];
        currentOrderArrayString = new String[10];
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
        orderHistoryMenuString = new String[10];
        orderHistoryArray = new Pastries[10][10];
        orderHistoryArrayString = new String[10][10];



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
                    currentOrderArray[nbrOfOrders] = cakeMenuObject[selectionIndex]; //for test purposes - needs to be replaced with solution of finding chosen menu item matching architecture for model
                    if (cakeMenuObject[selectionIndex] != null){
                        if (currentOrderArrayString[nbrOfOrders] == null) {
                            currentOrderArrayString[nbrOfOrders] = currentOrderArray[nbrOfOrders].toString();
                        }
                    }
                    break;
                case PerUnitItem:
                    currentOrderArray[nbrOfOrders] = perUnitItemMenuObject[selectionIndex]; //see comment for case above
                            if (perUnitItemMenuObject[selectionIndex] != null){
                                if (currentOrderArrayString[nbrOfOrders] == null) {
                                    currentOrderArrayString[nbrOfOrders] = currentOrderArray[nbrOfOrders].toString();
                            }
                        }

                    break;
            }
            costCurrentOrder = costCurrentOrder + currentOrderArray[nbrOfOrders].getCost();
            view.populateRightPanel(currentOrderArrayString);
            view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
            nbrOfOrders++;
        }


    }

    public void viewSelectedOrder(int selectionIndex){
        System.out.println("Index selection left panel: " + selectionIndex); //for test purposes  - remove when not needed

        if ((selectionIndex != -1) && currentLeftMenu==ButtonType.OrderHistory){
            for (int i = 0; i<orderHistoryArray[selectionIndex].length;i++){
                if (orderHistoryArray[selectionIndex][i] != null){
                    costCurrentOrder = costCurrentOrder + orderHistoryArray[selectionIndex][i].getCost();
                }
                else {
                    break;
                }
            }
            //for test purposes - replace with calculation of cost when how orders are handled is implemented in model
            view.populateRightPanel(orderHistoryArrayString[selectionIndex]); //update left panel with order details - this takes a shortcut in updating the entire information in the panel not just adds to the end
            view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order

        }
        costCurrentOrder = 0;
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
        view.populateRightPanel(currentOrderArrayString); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
        view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
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
        view.populateRightPanel(currentOrderArrayString); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
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
        nbrOfOrders = 0;
        orderHistoryArray[number] = new Pastries[currentOrderArray.length];
        for (int i = 0; i<currentOrderArray.length;i++){
            orderHistoryArray[number][i] = currentOrderArray[i];
        }
        orderHistoryArrayString[number] = currentOrderArrayString;
        orderHistoryMenuString[number] = "Order: " + (number+1) + " Price: " + costCurrentOrder;

        currentOrderArray = new Pastries[10];
        currentOrderArrayString = new String[10];
        costCurrentOrder = 0;
        number++;

        view.clearRightPanel(); //Removes information from right panel in GUI
        view.setTextCostLabelRightPanel("TOTAL COST: 0");
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();
    }
    for (int i = 0; i<INPUT_ARRAY.length;i++){
        if (INPUT_ARRAY[i] == null){
            FYLL LISTAN;
            return;
        }
        else{
            NEW_ARRAY = (INPUT_ARRAY.length)*2;
            for (int j = 0; j < INPUT_ARRAY.length;j++){
                NEW_ARRAY[j] = INPUT_ARRAY[j];
                return;
            }
            INPUT_ARRAY = NEW_ARRAY;
        }
    }
}
