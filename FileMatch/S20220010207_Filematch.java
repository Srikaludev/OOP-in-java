import java.io.*;
import java.util.*;

class AccountRecord {
    private int accountNumber;
    private double balance;
    private String name;

    public AccountRecord(int accountNumber, double balance, String name) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class TransactionRecord {
    private int accountNumber;
    private double amount;

    public TransactionRecord(int accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }
}
public class S20220010207_Filematch {

    public static void main(String[] args) throws IOException {
        File oldmastFile = new File("oldmast.txt");
        File transFile = new File("trans.txt");

        if (!oldmastFile.exists()) {
            System.err.println("Error: oldmast.txt file does not exist.");
            System.exit(1);
        }

        if (!transFile.exists()) {
            System.err.println("Error: trans.txt file not found.");
            System.exit(1);
        }

        HashMap<Integer, AccountRecord> masterRecords = new HashMap<>();
        try (Scanner masterScanner = new Scanner(new File("oldmast.txt"))){
            while (masterScanner.hasNext()) {
                int accountNumber = masterScanner.nextInt();
                String name = masterScanner.next();
                double balance = Double.parseDouble(masterScanner.next());
                masterRecords.put(accountNumber, new AccountRecord(accountNumber, balance, name));
            }
        }
        List<TransactionRecord> transactionRecords = new ArrayList<>();
        try (Scanner transScanner = new Scanner(new File("trans.txt"))) {
            while (transScanner.hasNext()) {
                int accountNumber = transScanner.nextInt();
                double amount = transScanner.nextDouble();
                transactionRecords.add(new TransactionRecord(accountNumber, amount));
            }
        } catch (InputMismatchException e) {
            System.err.println("Error: Data format mismatch in trans.txt.");
            System.exit(1);
        }
        Set<Integer> processedAccounts = new HashSet<>();
        List<String> unmatchedTransactions = new ArrayList<>();
        for (TransactionRecord transaction : transactionRecords) {
            int accountNumber = transaction.getAccountNumber();
            boolean foundMatch = false;

            if (!processedAccounts.contains(accountNumber)) {
                for (AccountRecord master : masterRecords.values()) {
                    if (master.getAccountNumber() == accountNumber) {
                        foundMatch = true;
                        master.setBalance(master.getBalance() + transaction.getAmount());
                        processedAccounts.add(accountNumber);
                        break;
                    }
                }

                if (!foundMatch) {
                    unmatchedTransactions.add("Unmatched transaction record for account number " + accountNumber);
                }
            }
        }
        try (PrintWriter newMasterWriter = new PrintWriter("newmast.txt")) {
            for (AccountRecord master : masterRecords.values()) {
                newMasterWriter.println(master.getAccountNumber());
                newMasterWriter.println(master.getName());
                newMasterWriter.println(master.getBalance());
            }
        } catch (IOException e) {
            System.err.println("Error writing to newmast.txt.");
            System.exit(1);
        }
        try (PrintWriter logWriter = new PrintWriter("log.txt")) {
            for (String unmatched : unmatchedTransactions) {
                logWriter.println(unmatched);
            }
        } catch (IOException e) {
            System.err.println("Error writing to log.txt.");
            System.exit(1);
        }
        System.out.println("Processed accounts: " + processedAccounts);
    }
}
