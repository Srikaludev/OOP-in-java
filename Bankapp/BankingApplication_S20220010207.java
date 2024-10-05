package Assign;

class Account {
    int accNum;
    String acc_name;
    String pwd;
    int balance;
}

class BankingApplication {
    Account account1;
    Account account2;

    public BankingApplication() {
        account1 = new Account();
        account2 = new Account();
    }

    void createAccount(int accNum, String acc_name, String pwd, int balance) {
        account1.accNum = accNum;
        account1.acc_name = acc_name;
        account1.pwd = pwd;
        account1.balance = balance;
        System.out.println("Account created successfully.");
    }

    void checkBalance() {
        System.out.println("Account balance: " + account1.balance);
    }

    int credit(int amt) {
        account1.balance += amt;
        return account1.balance;
    }

    int debit(int amount) {
        if (account1.balance >= amount) {
            account1.balance -= amount;
        } else {
            System.out.println("Requested debit amount exceeds balance.");
        }
        return account1.balance;
    }

    boolean login(int num, String pw) {
        if (account1.accNum == num && account1.pwd.equals(pw)) {
            System.out.println("Account login successful.");
            return true;
        } else {
            System.out.println("Login has failed.");
            return false;
        }
    }
    public static void main(String[] args) {
        BankingApplication bankApp = new BankingApplication();

        bankApp.createAccount(12345, "User1", "pass123", 1000);
        boolean stat =bankApp.login(12345, "pass123");
        if(stat==true){
                bankApp.checkBalance();
                 bankApp.credit(200);
             bankApp.debit(100);
            
        }
        else{
            System.out.println("Login failed,check credentials");
        }
        bankApp.createAccount(67890, "User2", "pass456", 500);
        boolean stat2=bankApp.login(67890, "wrongpass");   
        if(stat2==true){
            bankApp.checkBalance();
            bankApp.credit(200);
            bankApp.debit(100);
            } 
        else{
            System.out.println("Login failed,check credentials");
        }
    }
}
