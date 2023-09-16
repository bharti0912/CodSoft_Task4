import java.util.Scanner;
class Atm
{
  String name;
  private int pin;
  private double bal;
  Atm(String name, int pin, double bal)
  {
     this.name=name;
     this.pin=pin;
     this.bal=bal;
  }  
    public int getPin()
    {
    	return pin;
    }
    public void setBal(double bal)
    {
    	this.bal=bal;
    }
    public double getBal()
    {
    	return bal;
    }
}
class BankAccount
{
   public static void main(String [] args)
   {
   	Scanner sc= new Scanner(System.in);
   	System.out.println("Enter the Acountant Name : ");
   	String name=sc.nextLine();
    System.out.println("Enter Pin : ");
    int pin=sc.nextInt();
    System.out.println("Enter the amount to deposit :");
    double bal=sc.nextDouble();
   	Atm a= new Atm(name, pin, bal);
   	for( ; ; )
   	{
   		System.out.println("1.Withdrawing 2.Depositing 3.Checking Balance 4.Close ");
   		System.out.println("Enter Option : ");
   		int option=sc.nextInt();
   		switch(option)
   		{
   			case 1: System.out.println("*****Withdraw Amount*****");
   			        System.out.println("Enter the Amount to Withdraw : ");
   			        double wamt=sc.nextDouble();
   			        System.out.println("Enter Pin : ");
   			        int npin=sc.nextInt();
   			        if(npin==a.getPin())
   			        {
                       if(wamt<=a.getBal())
                       {
                       	double nwamt=a.getBal()-wamt;
                       	a.setBal(nwamt);
                        System.out.println("*****Withdrawing Ammount Successfully*****");
                       }
                       else
                       {
                       	System.out.println("******Insufficient Fund******");
                       }
   			        }
   			        else
   			        {
   			        	System.out.println("Enter Correct Pin");
   			        }
   			        break;
   			case 2: System.out.println("******Deposit Amount******");
   			        System.out.println("Enter the Amount to Deposit :");
   			        double amt=sc.nextDouble();
   			        double nbal=a.getBal()+amt;
   			        a.setBal(nbal);
                System.out.println("*****Deposit Amount Successfully*****");
                    break;
            case 3: System.out.println("******Checking Balance******");
                    System.out.println("Enter Pin : ");
                    int nnpin=sc.nextInt();
                    if(nnpin==a.getPin())
                    {
                    	System.out.println(a.getBal());
                    	System.out.println("******Available Balance******");
                    }
                    else
                    {
                    	System.out.println("Enter the Correct Pin ");
                    }
                    break;
            case 4: System.exit(0);
                    break;
            default : System.out.println("Enter Correct Option");
                      break;
   		}
   	}
   }
}