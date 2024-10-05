import java.util.*;

interface Account {
    AccountType getAccountType();
    double getBalance();
    void credit(double amount);
    void debit(double amount);
    double calculateSavings();
}

enum AccountType {
    SAVINGS,
    CURRENT,
    DEPOSIT
}

class SavingsAccount implements Account {
    private String accountNumber;
    private double balance;

    public SavingsAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.SAVINGS;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void credit(double amount) {
        balance += amount;
    }

    @Override
    public void debit(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public double calculateSavings() {
        return balance * 0.0275; // Assuming 2.75% interest rate
    }
}

class CurrentAccount implements Account {
    private String accountNumber;
    private double balance;

    public CurrentAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.CURRENT;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void credit(double amount) {
        balance += amount;
    }

    @Override
    public void debit(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public double calculateSavings() {
        return 0; // No savings for current account
    }
}

class DepositAccount implements Account {
    private String accountNumber;
    private double balance;
    private int duration;

    public DepositAccount(String accountNumber, double balance, int duration) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.duration = duration;
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.DEPOSIT;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void credit(double amount) {
        balance += amount;
    }

    @Override
    public void debit(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public double calculateSavings() {
        return balance * 0.1 * duration; // Assuming 10% interest rate and duration in years
    }
}

class Customer extends SpareBank {
    private String name;
    private String dob;
    private String designation;
    private String address;
    private String cifNumber;
    private List<Account> accounts;

    public Customer(String name, String dob, String designation, String address, String cifNumber) {
        this.name = name;
        this.dob = dob;
        this.designation = designation;
        this.address = address;
        this.cifNumber = cifNumber;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public void showAccounts() {
        for (Account account : accounts) {
            System.out.println("Account Type: " + account.getAccountType());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Savings: " + account.calculateSavings());
            System.out.println();
        }
    }
}

class SpareBank {
    private String branchName;
    private String branchCode;
    private List<Customer> customers;

    public SpareBank(String branchName, String branchCode) {
        this.branchName = branchName;
        this.branchCode = branchCode;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}

public class Assign062022207 {
    public static void main(String[] args) {
        SpareBank bank = new SpareBank("ABC Bank", "123");

        Customer customer1 = new Customer("John Doe", "01/01/1990", "Manager", "123 Main St", "CIF123");
        SavingsAccount savingsAccount = new SavingsAccount("SAV123", 5000);
        CurrentAccount currentAccount = new CurrentAccount("CUR456", 10000);
        DepositAccount depositAccount = new DepositAccount("DEP789", 20000, 2);
        customer1.addAccount(savingsAccount);
        customer1.addAccount(currentAccount);
        customer1.addAccount(depositAccount);
        bank.addCustomer(customer1);

        Customer customer2 = new Customer("Jane Smith", "02/02/1995", "Engineer", "456 Elm St", "CIF456");
        SavingsAccount savingsAccount2 = new SavingsAccount("SAV789", 8000);
        customer2.addAccount(savingsAccount2);
        bank.addCustomer(customer2);

        List<Customer> customers = bank.getCustomers();
        for (Customer customer : customers) {
            //System.out.println("Customer: " + customer.getName());
            customer.showAccounts();
        }
    }
}