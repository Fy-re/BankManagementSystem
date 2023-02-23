import java.util.*;

class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private static double balance;

    public BankAccount(int accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Please try again.");
        }
    }

    public static double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}

class Bank {
    private static ArrayList<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<BankAccount>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account created successfully.");
    }

    public static void removeAccount(int accountNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber) {
                accounts.remove(i);
                System.out.println("Account removed successfully.");
                return;
            }
        }
        System.out.println("Account not found. Please try again.");
    }

    public BankAccount getAccount(int accountNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber) {
                return accounts.get(i);
            }
        }
        System.out.println("Account not found. Please try again.");
        return null;
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Create an account");
            System.out.println("2. Deposit funds");
            System.out.println("3. Withdraw funds");
            System.out.println("4. View balance");
            System.out.println("5. Remove account");
            System.out.println("6. Exit");

            int option = scanner.nextInt();

            if (option == 1) {
                System.out.println("Enter account number:");
                int accountNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter account holder name:");
                String accountHolderName = scanner.nextLine();
                BankAccount account = new BankAccount(accountNumber, accountHolderName);
                bank.addAccount(account);
            } else if (option == 2) {
                System.out.println("Enter account number:");
                int accountNumber = scanner.nextInt();
                BankAccount account = bank.getAccount(accountNumber);
                if (account != null) {
                    System.out.println("Enter amount to deposit:");
                    double amount = scanner.nextDouble();
                    account.deposit(amount);
                }
            } else if (option == 3) {
                System.out.println("Enter account number:");
                int accountNumber = scanner.nextInt();
                BankAccount account = bank.getAccount(accountNumber);
                if (account != null) {
                    System.out.println("Enter amount to withdraw:");
                    double amount = scanner.nextDouble();
                    account.withdraw(amount);
                }
            } else if (option == 4) {
                System.out.println("Enter account number:");
                int accountNumber = scanner.nextInt();
                BankAccount account = bank.getAccount(accountNumber);
                if (account != null) {
                    System.out.println("Current balance: " + BankAccount.getBalance());
                }
            } else if (option == 5) {
                System.out.println("Enter account number:");
                int accountNumber = scanner.nextInt();
                BankAccount account = bank.getAccount(accountNumber);
                if (account != null) {
                    Bank.removeAccount(accountNumber);
                }
            } else if (option == 6) {
                System.out.println("...Exiting System...");
                return;
            } else {
                System.out.println("Please select a valid option");
            }
        }
    }
}