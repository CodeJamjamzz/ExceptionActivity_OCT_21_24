package Management_Exc;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.*;

// FINAL
public class Main {

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param manager the manager to give the salary
     * @param employee the employee to receive the raise
     * @param salary the salary increase to be given
     * @throws ClassCastException when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException when given manager or employee does not exist in the list of persons
     */
    public static void giveRaise(List<Person> persons, String manager, String employee, double salary) throws ClassCastException, IllegalArgumentException, NoSuchElementException {

        Employee assignemployee = null;
        for(Person p: persons){
            if(p.getName().equals(employee)){
                if( !(p instanceof Employee) ){
                    throw new ClassCastException(p.getName() + " is not an employee");
                }
                assignemployee = (Employee) p;
            }
        }

        if(assignemployee == null){
            throw new NoSuchElementException(employee + " does not exist");
        }

        Manager assignManager = null;
        for(Person p2: persons){
            if(p2.getName().equals(manager)){
                if( !(p2 instanceof Manager)){
                    throw new ClassCastException(p2.getName() + " is not a manager");
                }

                assignManager = (Manager) p2;
            }
        }

        if(assignManager == null){
            throw new NoSuchElementException(manager + " does not exist");
        }

        assignManager.giveRaise(assignemployee, salary);
        return;
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param developer the developer to be assigned
     * @param manager the manager assigned to the dev
     * @throws ClassCastException when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) throws ClassCastException, NoSuchElementException, IllegalStateException, IllegalArgumentException {

        Manager assignmanager = null;
        int ctr = 0;
        for (Person p : persons) {
            if (p.getName().equals(manager)) {

                if (!(p instanceof Manager)) {
                    throw new ClassCastException(p.getName() + " is not a manager");
                }

                if (p instanceof Manager) {
                    assignmanager = (Manager) p;
                    break;
                }
            }

        }

        if (assignmanager == null) {
            throw new NoSuchElementException(manager + " does not exist");
        }

        Developer assigndeveloper = null;
        for (Person p2 : persons) {
            if (p2.getName().equals(developer)) {

                if (!(p2 instanceof Developer)) {
                    throw new ClassCastException(p2.getName() + " is not a developer");
                }

                if(((Developer) p2).getProjectManager() != null){
                    throw new IllegalStateException(((Developer)p2).getName() + " already has a manager: " + ((Developer)p2).getProjectManager().getName());
                }

                if (p2 instanceof Developer && ((Developer) p2).getProjectManager() == null) {
                    assigndeveloper = (Developer) p2;
                    break;
                }
            }

        }

        if (assigndeveloper == null) {
            throw new NoSuchElementException(developer + " does not exist");
        }

        assigndeveloper.setProjectManager(assignmanager);
        return;
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws ClassCastException when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) throws IllegalArgumentException, ClassCastException, NoSuchElementException {

        Customer assigncustomer = null;
        for(Person p: persons){
            if(p.getName().equals(customer)){

                if(!(p instanceof Customer)){
                    throw new ClassCastException(   p.getName() + " is not a customer");
                }

                if(p instanceof Customer){
                    assigncustomer = (Customer) p;
                    break;
                }
            }
        }

        if(assigncustomer == null){
            throw new NoSuchElementException(customer + " does not exist");
        }

        Employee assignemployee = null;
        for(Person p: persons){
            if(p.getName().equals(employee)){

                if(!(p instanceof Employee)){
                    throw new ClassCastException(p.getName() + " is not an employee");
                }

                if(p instanceof Employee){
                    assignemployee = (Employee) p;
                    break;
                }

            }
        }

        if(assignemployee == null){
            throw new NoSuchElementException(employee + " does not exist");
        }

        return assigncustomer.speak(assignemployee);
    }
}
