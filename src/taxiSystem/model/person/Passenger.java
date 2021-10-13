package taxiSystem.model.person;

public class Passenger extends Person {

    private double accountBalance;

    public Passenger(String userName, String name, String family, String nationalCode, String phoneNumber, int age, double accountBalance) {
        super(userName, name, family, nationalCode, phoneNumber, age);
        this.accountBalance = accountBalance;
    }

    public Passenger(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Passenger() {


    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return
                "Passenger{" +
                        super.toString() + '\'' +
                        ",accountBalance=" + accountBalance +'\'' +
                        '}';
    }
}
