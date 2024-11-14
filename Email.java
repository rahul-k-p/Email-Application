import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String department;
    private int mailBoxCapacity = 10;
    final private int defaultLength = 8;
    private String alternateEmail;
    final private String companySuffix = "company.com";
    Scanner sc = new Scanner(System.in);

    //constructor to receive first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        //call a method asking for the department - return the department
        this.department = setDepartment();

        //call a method that returns random password
        this.password = randomPassword(defaultLength);
        System.out.println(this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department + "." + companySuffix;
        System.out.println(email);
    }

    //Ask for the department
    private String setDepartment(){
        System.out.print("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter code:");
        int deptChoice = sc.nextInt();
        if(deptChoice==1){return "sales";}
        else if(deptChoice==2){return "development";}
        else if(deptChoice==3){return "accountant";}
        else{return "";}
    }

    //Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for(int i =0;i<length;i++){
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set the mailbox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }

    //Set the alternate Email
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }

    //Change the password
    public void changePassword(String password){
        System.out.print("Enter previous password:");
        String oldPassword = sc.nextLine();
        if(oldPassword.equals(password)){
            this.password = password;
            System.out.println("Password changed successfully");
        }else{
            System.out.println("Wrong password");
        }

    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }
}