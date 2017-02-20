package atm_system;

public class Withdrawal extends Transaction
{
    private int amount;
    private final static int CANCELED=6;
    private Keypad keypad;
    private CashDispenser cashDispenser;
    public Withdrawal(int userAccountNumber,Screen atmScreen,BankDatabase atmBankDatabase,Keypad atmKeypad,CashDispenser atmCashDispenser)
    {
    super(userAccountNumber,atmScreen,atmBankDatabase);
    keypad=atmKeypad;
    cashDispenser=atmCashDispenser;
    }
    @Override
    public void execute()
    {
        boolean cashDispensed=false;
        double availableBalance;
        BankDatabase bankDatabase=getBankDatabase();
        Screen screen=getScreen();
        do{
            amount=displayMenuOfAmounts();
            if(amount!=CANCELED)
            {
                availableBalance=bankDatabase.getAvailableBalance(getAccountNumber());
                if(amount<=availableBalance)
                {
                    if(cashDispenser.isSufficientCashAvailable(amount))
                    {
                        bankDatabase.debit(getAccountNumber(), amount);
                        cashDispenser.dispenserCash(amount);
                        cashDispensed=true;
                        screen.displayMessageLine("\n Your cash has been "+ "diapensed.Please take your cash now.");
                        
                        
                    }
                    else
                    {
                        screen.displayMessageLine("\n Insufficient cash avialable in the ATM."+"\n\nPlease chose a smaller amount.");
                        
                    }
                }
                else
                {
                    screen.displayMessageLine("\nInsufficient funds in your account." +"\\n\\nPlease choose a smaller amount.");
                }
                
            }
            else
            {
                screen.displayMessageLine("\\nCanceling transaction...");
                return;
            }
        }while(!cashDispensed);
        
        
    }
    private int displayMenuOfAmounts()
    {
        int userChoice=0;
        Screen screen=getScreen();
        int[] amounts={0,20,40,60,100,200};
        while(userChoice==0)
        {
            screen.displayMessageLine("\nWithdrawal Menu:");
            screen.displayMessageLine("1-$20");
            screen.displayMessageLine("2-$40");
            screen.displayMessageLine("3-$60");
            screen.displayMessageLine("4-$100");
            screen.displayMessageLine("5-$200");
            screen.displayMessageLine("6-Cancel transaction");
            screen.displayMessageLine("\n Choose a withdrawal amount: ");
            int input=keypad.getInput();
            switch(input)
            {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    userChoice=amounts[input];
                    break;
                case CANCELED:
                    userChoice=CANCELED;
                    break;
                default:
                    screen.displayMessageLine("\nInvalid selection. Try again...");
                    
                    
            } 
            
        }
        return userChoice;
    }
    
    
    
}
