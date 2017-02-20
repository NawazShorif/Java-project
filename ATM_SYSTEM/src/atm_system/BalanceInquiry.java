
package atm_system;

public class BalanceInquiry extends Transaction{
    public BalanceInquiry(int userAccountNumber,Screen atmScreen,BankDatabase atmBankDatabase)
    {
        super(userAccountNumber,atmScreen,atmBankDatabase);
    }
    @Override
    public void execute()
    {
        BankDatabase bankDatabase=getBankDatabase();
        Screen screen=getScreen();
        double availableBalance=bankDatabase.getAvailableBalance(getAccountNumber());
        double  totalBalence=bankDatabase.getTotalBalance(getAccountNumber());
        screen.displayMessageLine("\nBalance Information:");
        screen.displayMessage("-Available balance : ");
        screen.displayDollarAmount(availableBalance);
        screen.displayMessage("\n-Total balance:    ");
        screen.displayDollarAmount(totalBalence);
        screen.displayMessageLine("  ");
    }
    
}
