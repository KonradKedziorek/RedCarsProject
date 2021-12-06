import Controllers.*;
import Models.Car;
import Models.Client;
import Models.Person;
import Models.Rent;
import com.googlecode.lanterna.screen.Screen;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

public class Main {
    public static void main(String[] args) throws IOException {

        CarController carController = new CarController();
        PriceListController priceListController = new PriceListController();
        PersonController personController = new PersonController();
        RentController rentController = new RentController();
        ClientController clientController = new ClientController();


        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Screen screen = null;

        try {
            screen = terminalFactory.createScreen();
            screen.startScreen();

            final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);

            final Window window = new BasicWindow("Red Cars inside system");
            final Window searchCarByIdWindow = new BasicWindow("Search car by Id");
            final Window searchCarByModelWindow = new BasicWindow("Search car by model");
            final Window searchCarByVINWindow = new BasicWindow("Search car by VIN");
            final Window searchCarByBrandWindow = new BasicWindow("Search car by brand");
            final Window printAllCarsWindow = new BasicWindow("All cars");
            final Window addCarWindow = new BasicWindow("Add car");
            final Window removeCarWindow = new BasicWindow("Remove car");
            final Window removeCarCheckWindow = new BasicWindow("Remove car");
            final Window searchPersonWindow = new BasicWindow("Search person");
            final Window addPersonWindow = new BasicWindow("Add person");
            final Window removePersonWindow = new BasicWindow("Remove person");
            final Window removePersonCheckWindow = new BasicWindow("Remove person");
            final Window searchRentByIdWindow = new BasicWindow("Search rent");
            final Window addRentWindow = new BasicWindow("Add rent");
            final Window removeRentWindow = new BasicWindow("Remove rent");
            final Window removeRentCheckWindow = new BasicWindow("Remove rent");
            final Window addClientWindow = new BasicWindow("Add client");
            final Window removeClientWindow = new BasicWindow("Remove client");
            final Window removeClientCheckWindow = new BasicWindow("Remove client");


            Panel contentPanel = new Panel(new GridLayout(2));
            Panel searchCarByIdPanel = new Panel();
            Panel searchCarByModelPanel = new Panel();
            Panel searchCarByVINPanel = new Panel();
            Panel searchCarByBrandPanel = new Panel();
            Panel printAllCarsPanel = new Panel();
            Panel addCarPanel = new Panel(new GridLayout(2));
            Panel removeCarPanel = new Panel();
            Panel removeCarCheckPanel= new Panel();
            Panel searchPersonPanel = new Panel();
            Panel addPersonPanel = new Panel(new GridLayout(2));
            Panel removePersonPanel = new Panel();
            Panel removePersonCheckPanel= new Panel();
            Panel searchRentByIdPanel = new Panel();
            Panel addRentPanel = new Panel(new GridLayout(2));
            Panel removeRentPanel = new Panel();
            Panel removeRentCheckPanel = new Panel();
            Panel addClientPanel = new Panel(new GridLayout(2));
            Panel removeClientPanel = new Panel();
            Panel removeClientCheckPanel = new Panel();



            GridLayout gridLayout = (GridLayout)contentPanel.getLayoutManager();
            gridLayout.setHorizontalSpacing(10);
            gridLayout.setVerticalSpacing(0);

            GridLayout gridLayoutAddCar = (GridLayout)addCarPanel.getLayoutManager();
            gridLayoutAddCar.setHorizontalSpacing(10);
            gridLayoutAddCar.setVerticalSpacing(1);

            GridLayout gridLayoutAddPerson = (GridLayout) addPersonPanel.getLayoutManager();
            gridLayoutAddPerson.setHorizontalSpacing(10);
            gridLayoutAddPerson.setVerticalSpacing(1);

            GridLayout gridLayoutAddRent = (GridLayout) addRentPanel.getLayoutManager();
            gridLayoutAddRent.setHorizontalSpacing(10);
            gridLayoutAddRent.setVerticalSpacing(1);

            GridLayout gridLayoutAddClient = (GridLayout) addClientPanel.getLayoutManager();
            gridLayoutAddClient.setHorizontalSpacing(10);
            gridLayoutAddClient.setVerticalSpacing(1);

/***************************************SEARCHING BY ID**************************************************************/

            Label searchCarByIdLabel = new Label("Search car by Id");
            contentPanel.addComponent(searchCarByIdLabel);

            contentPanel.addComponent(new Button("Search", () ->{
                TextBox input = new TextBox();
                searchCarByIdPanel
                        .addComponent(new Label("Enter Car's id:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", () ->{
                            List<Car> carList = carController.searchCarById(Long.parseLong(input.getText()));
                            if(carList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Car with id you searched:", "There is no cars with that id",MessageDialogButton.OK);
                            }else {
                                MessageDialog.showMessageDialog(textGUI, "Car with id you searched:", carList.toString(), MessageDialogButton.OK);
                            }
                        }
                        ))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(searchCarByIdWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(searchCarByIdWindow);
                searchCarByIdPanel.removeAllComponents();
            }));


/***************************************SEARCHING BY MODEL**************************************************************/



            Label searchCarByModelLabel = new Label("Search car by model");
            contentPanel.addComponent(searchCarByModelLabel);

            contentPanel.addComponent(new Button("Search", () ->{
                TextBox input = new TextBox();
                searchCarByModelPanel
                        .addComponent(new Label("Enter model:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", () ->{
                            List<Car> carList = carController.searchCarByModel(input.getText());
                            if(carList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Cars with model you searched:", "There are no cars with that id",MessageDialogButton.OK);
                            }else {
                                MessageDialog.showMessageDialog(textGUI, "Cars with model you searched:", carList.toString(), MessageDialogButton.OK);
                            }
                        }
                        ))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(searchCarByModelWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(searchCarByModelWindow);
                searchCarByModelPanel.removeAllComponents();
            }));


/***************************************SEARCHING BY VIN**************************************************************/


            Label searchCarByVINLabel = new Label("Search car by VIN");
            contentPanel.addComponent(searchCarByVINLabel);

            contentPanel.addComponent(new Button("Search", () ->{
                TextBox input = new TextBox();
                searchCarByVINPanel
                        .addComponent(new Label("Enter Car's VIN number:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", () ->{
                            List<Car> carList = carController.searchCarByVIN(input.getText());
                            if(carList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Cars with VIN number you searched:", "There are no cars with that VIN number",MessageDialogButton.OK);
                            }else {
                                MessageDialog.showMessageDialog(textGUI, "Cars with VIN number you searched:", carList.toString(), MessageDialogButton.OK);
                            }
                        }
                        ))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(searchCarByVINWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(searchCarByVINWindow);
                searchCarByVINPanel.removeAllComponents();
            }));




/***************************************SEARCHING BY BRAND**************************************************************/


            Label searchCarByBrandLabel = new Label("Search car by brand");
            contentPanel.addComponent(searchCarByBrandLabel);

            contentPanel.addComponent(new Button("Search", () ->{
                TextBox input = new TextBox();
                searchCarByBrandPanel
                        .addComponent(new Label("Enter Car's brand:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", () ->{
                            List<Car> carList = carController.searchCarByBrand(input.getText());
                            if(carList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Cars with brand you searched:", "There are no cars with that brand",MessageDialogButton.OK);
                            }else {
                                MessageDialog.showMessageDialog(textGUI, "Cars with brand you searched:", carList.toString(), MessageDialogButton.OK);
                            }
                        }
                        ))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(searchCarByBrandWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(searchCarByBrandWindow);
                searchCarByBrandPanel.removeAllComponents();
            }));



/***************************************PRINT ALL CARS***************************************************************************/


            Label printAllCarsLabel = new Label("Print all cars");
            contentPanel.addComponent(printAllCarsLabel);

            contentPanel.addComponent(new Button("Print", () ->{
                printAllCarsPanel
                        .addComponent(new Button("Print cars", () ->{
                            List<Car> carList = carController.searchAllCars();
                            if(carList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "All cars:", "There are no cars in database",MessageDialogButton.OK);
                            }else {
                                MessageDialog.showMessageDialog(textGUI, "All cars", carList.toString(), MessageDialogButton.OK);
                            }
                        }
                        ))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(printAllCarsWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(printAllCarsWindow);
                printAllCarsPanel.removeAllComponents();
            }));



/***************************************ADDING CAR**************************************************************/


            Label addCarLabel = new Label("Add Car");
            contentPanel.addComponent(addCarLabel);

            contentPanel.addComponent(new Button("Add Car", () ->{
                TextBox brandInput = new TextBox();
                TextBox modelInput = new TextBox();
                TextBox licensePlateInput = new TextBox();
                TextBox productionYearInput = new TextBox();
                TextBox mileageInput = new TextBox();
                TextBox fuelInput = new TextBox();
                TextBox VINInput = new TextBox();
                TextBox priceInput = new TextBox();
                addCarPanel
                        .addComponent(new Label("Enter Car's brand:"))
                        .addComponent(brandInput)
                        .addComponent(new Label("Enter Car's model:"))
                        .addComponent(modelInput)
                        .addComponent(new Label("Enter Car's license plate:"))
                        .addComponent(licensePlateInput)
                        .addComponent(new Label("Enter Car's productionYear:"))
                        .addComponent(productionYearInput)
                        .addComponent(new Label("Enter Car's mileage:"))
                        .addComponent(mileageInput)
                        .addComponent(new Label("Enter Car's type of fuel:"))
                        .addComponent(fuelInput)
                        .addComponent(new Label("Enter Car's VIN number:"))
                        .addComponent(VINInput)
                        .addComponent(new Label("Enter Car's price:"))
                        .addComponent(priceInput)
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(addCarWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)))
                        .addComponent(new Button("Add", () -> {
                    carController.addCar(brandInput.getText(),modelInput.getText(),licensePlateInput.getText(),Long.parseLong(productionYearInput.getText()),Long.parseLong(mileageInput.getText()),fuelInput.getText(),VINInput.getText(), priceListController.searchByPrice(Double.parseDouble(priceInput.getText())));
                    MessageDialog.showMessageDialog(textGUI, "Information", "Car was successfully added", MessageDialogButton.OK);
                }));
                textGUI.addWindowAndWait(addCarWindow);
                addCarPanel.removeAllComponents();
            }));



/***************************************REMOVING CAR**************************************************************/


            Label removeCarLabel = new Label("Remove Car");
            contentPanel.addComponent(removeCarLabel);

            contentPanel.addComponent(new Button("Remove Car", () ->{
                TextBox input = new TextBox();
                removeCarPanel
                        .addComponent(new Label("Enter Car's id:"))
                        .addComponent(input)
                        .addComponent(new Button("Remove", () -> {
                            removeCarCheckPanel
                                    .addComponent(new Label("Are You sure you want to delete this car permanently?"))
                                    .addComponent(new Button("Yes", ()->{
                                        List<Car> carList = carController.searchCarById(Long.parseLong(input.getText()));
                                        if(carList.isEmpty()){
                                            MessageDialog.showMessageDialog(textGUI, "Remove car", "There are no cars with that id",MessageDialogButton.OK);
                                        }else {
                                            carController.deleteCar(carList.get(0));
                                            MessageDialog.showMessageDialog(textGUI, "Remove car", "Car was successfully removed.", MessageDialogButton.OK);
                                        }
                                    }))
                                    .addComponent(new Button("No",()->{
                                        textGUI.removeWindow(removeCarCheckWindow).removeWindow(removeCarCheckWindow);
                                    }));
                            textGUI.addWindowAndWait(removeCarCheckWindow);
                            removeCarCheckPanel.removeAllComponents();
                        }))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(removeCarWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(removeCarWindow);
                removeCarPanel.removeAllComponents();
            }));




/***************************************SEARCH PERSON BY PESEL**************************************************************/


            Label searchPersonLabel = new Label("Search Person");
            contentPanel.addComponent(searchPersonLabel);

            contentPanel.addComponent(new Button("Search", () ->{
                TextBox input = new TextBox();
                searchPersonPanel
                        .addComponent(new Label("Enter Person pesel:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", () ->{
                            List<Person> personList = personController.searchPersonByPesel(input.getText());
                            if(personList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Person with pesel you searched:", "There is no persons with that pesel",MessageDialogButton.OK);
                            }else {
                                MessageDialog.showMessageDialog(textGUI, "Person with pesel you searched:", personList.toString(), MessageDialogButton.OK);
                            }
                        }
                        ))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(searchPersonWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(searchPersonWindow);
                searchPersonPanel.removeAllComponents();
            }));



/***************************************ADDING PERSON**************************************************************/


            Label addPersonLabel = new Label("Add Person");
            contentPanel.addComponent(addPersonLabel);

            contentPanel.addComponent(new Button("Add Person", () ->{
                TextBox peselInput = new TextBox();
                TextBox nameInput = new TextBox();
                TextBox surnameInput = new TextBox();
                TextBox emailInput = new TextBox();
                TextBox phoneNumberInput = new TextBox();
                addPersonPanel
                        .addComponent(new Label("Enter Person's pesel:"))
                        .addComponent(peselInput)
                        .addComponent(new Label("Enter Person's name:"))
                        .addComponent(nameInput)
                        .addComponent(new Label("Enter Person's surname:"))
                        .addComponent(surnameInput)
                        .addComponent(new Label("Enter Person's email:"))
                        .addComponent(emailInput)
                        .addComponent(new Label("Enter Person's phone number:"))
                        .addComponent(phoneNumberInput)
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(addPersonWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)))
                        .addComponent(new Button("Add", () -> {
                            personController.addPerson(peselInput.getText(),nameInput.getText(),surnameInput.getText(),emailInput.getText(),Long.parseLong(phoneNumberInput.getText()));
                            MessageDialog.showMessageDialog(textGUI, "Information", "Person was successfully added", MessageDialogButton.OK);
                        }));
                textGUI.addWindowAndWait(addPersonWindow);
                addPersonPanel.removeAllComponents();
            }));



/***************************************REMOVING PERSON**************************************************************/


            Label removePersonLabel = new Label("Remove Person");
            contentPanel.addComponent(removePersonLabel);

            contentPanel.addComponent(new Button("Remove Person", () ->{
                TextBox input = new TextBox();
                removePersonPanel
                        .addComponent(new Label("Enter Person's id:"))
                        .addComponent(input)
                        .addComponent(new Button("Remove", () -> {
                            removePersonCheckPanel
                                    .addComponent(new Label("Are You sure you want to delete this person permanently?"))
                                    .addComponent(new Button("Yes", ()->{
                                        List<Person> personList = personController.searchPersonById(Long.parseLong(input.getText()));
                                        if(personList.isEmpty()){
                                            MessageDialog.showMessageDialog(textGUI, "Remove person", "There are no persons with that id",MessageDialogButton.OK);
                                        }else {
                                            personController.deletePerson(personList.get(0));
                                            MessageDialog.showMessageDialog(textGUI, "Remove person", "Person was successfully removed.", MessageDialogButton.OK);
                                        }
                                    }))
                                    .addComponent(new Button("No",()->{
                                        textGUI.removeWindow(removePersonCheckWindow);
                                    }));
                            textGUI.addWindowAndWait(removePersonCheckWindow);
                            removePersonCheckPanel.removeAllComponents();
                        }))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(removePersonWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(removePersonWindow);
                removePersonPanel.removeAllComponents();
            }));




/***************************************SEARCH RENT BY ID**************************************************************/


            Label searchRentLabel = new Label("Search Rent");
            contentPanel.addComponent(searchRentLabel);

            contentPanel.addComponent(new Button("Search", () ->{
                TextBox input = new TextBox();
                searchRentByIdPanel
                        .addComponent(new Label("Enter rent id:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", () ->{
                            List<Rent> rentList = rentController.searchRentById(Long.parseLong(input.getText()));
                            if(rentList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Rent with id you searched:", "There is no rent with that id",MessageDialogButton.OK);
                            }else {
                                MessageDialog.showMessageDialog(textGUI, "Rent with id you searched:", rentList.toString(), MessageDialogButton.OK);
                            }
                        }
                        ))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(searchRentByIdWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(searchRentByIdWindow);
                searchRentByIdPanel.removeAllComponents();
            }));



/***************************************ADDING RENT**************************************************************/


            Label addRentLabel = new Label("Add Rent");
            contentPanel.addComponent(addRentLabel);

            contentPanel.addComponent(new Button("Add Rent", () ->{
                TextBox employeeIdInput = new TextBox();
                TextBox issueDateInput = new TextBox();
                TextBox returnDateInput = new TextBox();
                TextBox carInput = new TextBox();
                addRentPanel
                        .addComponent(new Label("Enter Employee's id:"))
                        .addComponent(employeeIdInput)
                        .addComponent(new Label("Enter issue Date:"))
                        .addComponent(issueDateInput)
                        .addComponent(new Label("Enter return Date:"))
                        .addComponent(returnDateInput)
                        .addComponent(new Label("Enter Car's id:"))
                        .addComponent(carInput)
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(addRentWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)))
                        .addComponent(new Button("Add", () -> {
                            rentController.addRent(Long.parseLong(employeeIdInput.getText()), LocalDate.parse(issueDateInput.getText()), LocalDate.parse(returnDateInput.getText()), carController.searchCarById2(Long.parseLong(carInput.getText())));
                            MessageDialog.showMessageDialog(textGUI, "Information", "Car was successfully added", MessageDialogButton.OK);
                        }));
                textGUI.addWindowAndWait(addRentWindow);
                addRentPanel.removeAllComponents();
            }));



/***************************************REMOVING RENT**************************************************************/


            Label removeRentLabel = new Label("Remove Rent");
            contentPanel.addComponent(removeRentLabel);

            contentPanel.addComponent(new Button("Remove Rent", () ->{
                TextBox input = new TextBox();
                removeRentPanel
                        .addComponent(new Label("Enter Rent's id:"))
                        .addComponent(input)
                        .addComponent(new Button("Remove", () -> {
                            removeRentCheckPanel
                                    .addComponent(new Label("Are You sure you want to delete this rent permanently?"))
                                    .addComponent(new Button("Yes", ()->{
                                        List<Rent> rentList = rentController.searchRentById(Long.parseLong(input.getText()));
                                        if(rentList.isEmpty()){
                                            MessageDialog.showMessageDialog(textGUI, "Remove rent", "There are no rents with that id",MessageDialogButton.OK);
                                        }else {
                                            rentController.deleteRent(rentList.get(0));
                                            MessageDialog.showMessageDialog(textGUI, "Remove rent", "Rent was successfully removed.", MessageDialogButton.OK);
                                        }
                                    }))
                                    .addComponent(new Button("No",()->{
                                        textGUI.removeWindow(removeRentCheckWindow);
                                    }));
                            textGUI.addWindowAndWait(removeRentCheckWindow);
                            removeRentCheckPanel.removeAllComponents();
                        }))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(removeRentWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(removeRentWindow);
                removeRentPanel.removeAllComponents();
            }));



/***************************************ADDING CLIENT**************************************************************/


            Label addClientLabel = new Label("Add Client");
            contentPanel.addComponent(addClientLabel);

            contentPanel.addComponent(new Button("Add Client", () ->{
                TextBox driverLicenseInput = new TextBox();
                TextBox personInput = new TextBox();
                TextBox rentInput = new TextBox();
                addClientPanel
                        .addComponent(new Label("Enter Client driver license number:"))
                        .addComponent(driverLicenseInput)
                        .addComponent(new Label("Enter Person's id:"))
                        .addComponent(personInput)
                        .addComponent(new Label("Enter Rent's id:"))
                        .addComponent(rentInput)
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(addClientWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)))
                        .addComponent(new Button("Add", () -> {
                            clientController.addClient(driverLicenseInput.getText(),personController.searchPersonById2(Long.parseLong(personInput.getText())), rentController.searchRentById2(Long.parseLong(rentInput.getText())));
                            MessageDialog.showMessageDialog(textGUI, "Information", "Client was successfully added", MessageDialogButton.OK);
                        }));
                textGUI.addWindowAndWait(addClientWindow);
                addClientPanel.removeAllComponents();
            }));


/***************************************REMOVING CLIENT**************************************************************/


            Label removeClientLabel = new Label("Remove Client");
            contentPanel.addComponent(removeClientLabel);

            contentPanel.addComponent(new Button("Remove Client", () ->{
                TextBox input = new TextBox();
                removeClientPanel
                        .addComponent(new Label("Enter Client's id:"))
                        .addComponent(input)
                        .addComponent(new Button("Remove", () -> {
                            removeClientCheckPanel
                                    .addComponent(new Label("Are You sure you want to delete this client permanently?"))
                                    .addComponent(new Button("Yes", ()->{
                                        List<Client> clientList = clientController.searchClientById(Long.parseLong(input.getText()));
                                        if(clientList.isEmpty()){
                                            MessageDialog.showMessageDialog(textGUI, "Remove client", "There are no clients with that id",MessageDialogButton.OK);
                                        }else {
                                            clientController.deleteClient(clientList.get(0));
                                            MessageDialog.showMessageDialog(textGUI, "Remove client", "Client was successfully removed.", MessageDialogButton.OK);
                                        }
                                    }))
                                    .addComponent(new Button("No",()->{
                                        textGUI.removeWindow(removeClientCheckWindow);
                                    }));
                            textGUI.addWindowAndWait(removeClientCheckWindow);
                            removeClientCheckPanel.removeAllComponents();
                        }))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(removeClientWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(removeClientWindow);
                removeClientPanel.removeAllComponents();
            }));



            contentPanel.addComponent(
                    new Button("Close", window::close).setLayoutData(
                            GridLayout.createHorizontallyEndAlignedLayoutData(2)));


            addCarWindow.setComponent(addCarPanel);
            searchCarByIdWindow.setComponent(searchCarByIdPanel);
            searchCarByModelWindow.setComponent(searchCarByModelPanel);
            searchCarByVINWindow.setComponent(searchCarByVINPanel);
            searchCarByBrandWindow.setComponent(searchCarByBrandPanel);
            printAllCarsWindow.setComponent(printAllCarsPanel);
            removeCarWindow.setComponent(removeCarPanel);
            removeCarCheckWindow.setComponent(removeCarCheckPanel);
            searchPersonWindow.setComponent(searchPersonPanel);
            addPersonWindow.setComponent(addPersonPanel);
            removePersonWindow.setComponent(removePersonPanel);
            removePersonCheckWindow.setComponent(removePersonCheckPanel);
            searchRentByIdWindow.setComponent(searchRentByIdPanel);
            addRentWindow.setComponent(addRentPanel);
            removeRentWindow.setComponent(removeRentPanel);
            removeRentCheckWindow.setComponent(removeRentCheckPanel);
            addClientWindow.setComponent(addClientPanel);
            removeClientWindow.setComponent(removeClientPanel);
            removeClientCheckWindow.setComponent(removeClientCheckPanel);

            window.setComponent(contentPanel);
            textGUI.addWindowAndWait(window);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(screen != null) {
                try {
                    screen.stopScreen();
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
