package user_views;

import java.util.Scanner;

import office_manager.OfficeManager;
import user_views.UserView.NotLoggedInException;

public class PatientView extends UserView {

	// implements the abstract method from userview
	// basically just a wrapper for addNewPatient
	// and obviously provides a way for the user to input a new userName
	@Override
	protected boolean createNewUser() {
    	Scanner scanner = null;
    	try {
    		// scan for user inputs 
    		scanner = new Scanner(System.in);
    		System.out.print("Please enter a new Username: ");
    		String userName = scanner.nextLine();
    		System.out.print("Please enter your first name: ");
    		String name = scanner.nextLine();
    		System.out.print("Please enter you surname: ");
    		String surname = scanner.nextLine();
    		System.out.print("Please enter your birth date: ");
    		String birthDate = scanner.nextLine();
    		OfficeManager officeManager = getOfficeManager();
    		// addNewPatient isnt implemented yet. it should be implemented in OfficeManager
    		if(officeManager.addNewPatient(userName, name, surname, birthDate)) { 
    			return true;
    		}
    		else {
    			return false;
    		}
    	} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    	finally {
            if (scanner != null) {
                scanner.close();
            }
    	}
	}

	// displays the patients options, could be more if we need more
	@Override
	protected void displayOptions() {
		System.out.println("Welcome! What would you like to do today?");
		System.out.println("Enter 1 to view your upcoming schedule");
		System.out.println("Enter 2 to book a new appointement");
		System.out.println("Enter 3 to cancel or reschedule an existing appointment");
		System.out.println("Enter 4 to logout");
	}

	// executes the option that the user selects. again the userView functions that will be called 
	// basically just provide an interface between the user and the underlying officeManager functions
	@Override
	protected boolean executeSelectedOption(int optionNumber) {
		switch (optionNumber) {
	    case 1:
	    	// this.viewSchedule();
	        break;
	    case 2:
	    	// this.bookAppointment();
	        break;
	    case 3:
	    	// this.cancelOrReschedulApp();
	    	break;
	    case 4:
	    	// this.logout
	    default:
	    	return false;
		}
		return true;
	}

	
}
