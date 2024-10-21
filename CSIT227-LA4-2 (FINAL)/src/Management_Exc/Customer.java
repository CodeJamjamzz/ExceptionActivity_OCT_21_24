package Management_Exc;

public class Customer extends Person {

    public Customer(String name, int age) {
        super(name, age);
    }

    @Override
    public void performTask() {
        System.out.println(getName() + " is browsing through");
    }

    /**
     * TODO implementation
     * @param e employee to be spoken to
     * @return the dialogue of the customer
     */
    public String speak(Employee e) {

        if(e == null){
            return null;
        }

        if(e instanceof Developer && getAge() > e.getAge()){
            if( ((Developer)e).getProjectManager() == null){
                return "Oh, hello, "+ e.getName() +". Can you assist me?";
            }

            return "Can I see your manager " + ((Developer) e).getProjectManager().getName()+ "?";
        }


        return "Oh, hello, "+ e.getName() +". Can you assist me?";
    }
}
