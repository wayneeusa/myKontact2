
//import com.opencsv.CSVReader;
import com.opencsv.CSVReader;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;


//import java.util.List;
//for Open CSV

public class myKontact2 {

    public static final Scanner input = new Scanner(System.in);
    static int choice = 0;
    String selection = "";
    static ArrayList<Person> list = new ArrayList<Person>();
    static ArrayList<Person> searchResults = new ArrayList<Person>();
    static String longString;
    static String addressToEmail = "";
    static String first = "";
    static String last = "";
    static String email = "";
    static String phone = "";
    static String notes = "";
    static String fileName = "";
    static String path = "";
    // TODO add more variables


    public static void main(String[] args) {

        input.useDelimiter("\\n");

        System.out.println("Welcome to your Kontact Manager \n"
                + "What would you like to do?");

     /*   SwingGraphics window = new SwingGraphics();

        window.setTitle("Kontact Manager");
        window.setSize(300,200);
        // window.setLocation(width, height);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);*/


        printMenu();  //Menu 1

        runSwitch(); //Selects option and sends to methods


        input.close();

    }

    public static void clearConsole() {
        final String operatingSystem = System.getProperty("os.name");

        try {

            if (operatingSystem.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException ex) {
            System.out.println("\n\n\n\n\n\n");
        }
    }

    public static void printMenu() {

        do {
            System.out.println("1) Import from Evernote \n"
                    + "2) Import from Yandex \n"
                    + "3) Import from DataBase \n"
                    + "4) Begin a new file \n"
                    + "5) Quit");

            if (input.hasNextInt()) {

                choice = input.nextInt();


            } else {
                choice = 0;

                clearConsole();

                System.out.println("Please enter again");
                input.next(); //this is important
            }
        }

        while (choice != 1 && choice != 2 && choice != 3 && choice
                != 4 && choice != 5);

        System.out.println("Choice was: " + choice);


    }

    public static void runSwitch() {

        switch (choice) {
            case 1:
                option1();
                break;
            case 2:
                option2();
                break;
            case 3:
                option3();
                break;
            case 4:
                option4();
                break;
            case 5:
                System.out.println("See you later!");
                System.exit(0);
                break;

        }

    }

    //Import from Evernote
    static void option1() {

        list.clear();


        try {
            //Buffer Reader example:
            // http://www.java2s.com/Code/Java/File-Input-Output/Readeachlineinacommaseparatedfileintoanarray.htm

            BufferedReader reader = new BufferedReader(new FileReader("/home/wayne/Documents/snippets/Kontacts.txt"));

            String line = null;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                first = values[0];
                last = values[1];
                email = values[2];
                phone = values[3];
                notes = values[4];

                list.add(new Person(first, last, email,
                        phone, notes));

            }

            reader.close();
        } catch (IOException exio) {
            System.out.println("IO Exception:");
        }


        //Below code worked fine except after charAt(0) and compareTo didn't work
		/*CSVReader reader = new CSVReader(new FileReader(
				"/home/wayne/Documents/snippets/Kontacts.txt"));
		
		//ParseCSVFile parseCSVFile = new ParseCSVFile();
		
		String [] nextLine; 
        
        while ((nextLine = reader.readNext()) != null) {
            
            for(int i = 0;i< nextLine.length-1; i++){
            	
            	switch(i) {
            	case 0: first = nextLine[i];
            	break;
            	case 1: last = nextLine[i];
            	break;
            	case 2: email = nextLine[i];
            	break;
            	case 3: phone = nextLine[i];
            	break;
            	case 4: notes = nextLine[i];
            	break;
            	default: System.out.println("Hiccup");           	
            	}
                 	
         
            }
            list.add(new Person(first, last, email, phone, notes));
            
        }
        reader.close();
		} catch (IOException exc) {System.out.println("IO exception");
		};*/


        menu2();

    }

    //Import from Yandex Folder
    static void option2() {

        list.clear();
        String first = "";
        String last = "";
        String email = "";
        String phone = "";
        String notes = "";

        try {
            //CSVReader reader = null;
            CSVReader reader = new CSVReader(new FileReader(
                    "/home/wayne/Yandex.Disk/Documents/Kontacts.txt"));

            //ParseCSVFile parseCSVFile = new ParseCSVFile();

            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {

                for (int i = 0; i < nextLine.length - 1; i++) {

                    switch (i) {
                        case 0:
                            first = nextLine[i];
                            break;
                        case 1:
                            last = nextLine[i];
                            break;
                        case 2:
                            email = nextLine[i];
                            break;
                        case 3:
                            phone = nextLine[i];
                            break;
                        case 4:
                            notes = nextLine[i];
                            break;
                        default:
                            System.out.println("Hiccup");
                    }


                }
                list.add(new Person(first, last, email, phone, notes));

            }
            reader.close();
        } catch (IOException exc) {
            System.out.println("IO exception");
        }
        ;

        menu2();

    }

    //Import from Database
    static void option3() {

    }

    //Begin a new file
    static void option4() {

        addContact();

    }

    static void addContact() {


        System.out.println("Enter person's first name:");
        String first = input.next();


        System.out.println("Enter last name:");
        String last = input.next();

        System.out.println("Enter email address:");
        String email = input.next();

        System.out.println("Enter phone (0 to skip):");
        String phone = input.next();

        System.out.println("Enter notes (0 to skip):");
        String notes = input.next();
        input.nextLine();


        list.add(new Person(first, last, email, phone, notes));

        menu2();

    }

    static void menu2() {

        do {

            System.out.println("What would you like to do?");
            System.out.println("1) Save List to Evernote \n"
                    + "2) Save List to Yandex \n"
                    + "3) Add another Contact \n"
                    + "4) Search contacts \n"
                    + "5) List Contacts \n"
                    + "6) Easy-Read List  \n"
                    + "7) Alphabetize List \n"
                    + "8) Super Menu \n"
                    + "9) Quit");

            if (input.hasNextInt()) {
                choice = input.nextInt();

            } else {
                choice = 0;
                input.next();
                System.out.println("Enter again");
            }
            ;
        }

        while (choice != 1 && choice != 2 && choice != 3 && choice
                != 4 && choice != 5 && choice != 6 &&
                choice != 7 && choice != 8 && choice != 9);

        switch (choice) {

            case 1:
                saveToEvernote();//Save to snippets
                break;
            case 2:
                saveToYandex(); // Save to Yandex Disk
                break;
            case 3:
                addContact();
                break;
            case 4:
                searchContacts();// Search Contacts
                break;
            // Print List
            case 5:
                for (Person p : list) {
                    System.out.println(p.getFirstName() + " " + p.getLastName() +
                            " " + p.getEmail() + " " + p.getPhone() + " " + p.getNotes());

                }
                System.out.println();
                System.out.println();
                menu2();
                break;
            case 6:
                for (Person p : list) {
                    System.out.println(p.getFirstName() + "  " + p.getLastName() +
                            "     " + p.getEmail() + "\n" + p.getPhone() + "\n" + p.getNotes() + "\n\n");

                }
                System.out.println();
                System.out.println();
                menu2();

                break;

            case 7:
                alphabetizeList();//Alphabetize
                break;

            case 8:
                superMenu();
                break;
            case 9:
                System.out.println("Thanks and Good-bye!");
                System.exit(0);

        }

    }

    static void saveToEvernote() {

        longString = "";
        for (Person c : list) {

            longString = longString + c.getFirstName() + ", "
                    + c.getLastName() + ", " + c.getEmail() + ", " + c.getPhone() +
                    ", " + c.getNotes() + "," + "\n";

        }

        try {

            PrintWriter pw = new PrintWriter(new File("/home/wayne/"
                    + "Documents/snippets/Kontacts.txt"));

            pw.printf(longString);

            pw.close();

        } catch (IOException ex) {
            System.out.println("Could not write "
                    + "to file");
        }
        ;

        menu2();
    }

    static void saveToYandex() {

        longString = "";
        for (Person c : list) {

            longString = longString + c.getFirstName() + ", "
                    + c.getLastName() + ", " + c.getEmail() + ", " + c.getPhone() +
                    ", " + c.getNotes() + "," + "\n";

        }

        try {

            PrintWriter pw = new PrintWriter(new File("/home/wayne/"
                    + "Yandex.Disk/Documents/Kontacts.txt"));

            pw.printf(longString);

            pw.close();

        } catch (IOException ex) {
            System.out.println("Could not write "
                    + "to file");
        }
        ;

        menu2();
    }

    static void searchContacts() {

        searchResults.clear();

        System.out.println();
        System.out.println("Enter a search term:");

        String term = input.next().toUpperCase();

        for (Person p : list) {

            if (p.getFirstName().contains(term) ||
                    p.getLastName().contains(term)
                    || p.getEmail().contains(term)
                    ) {

                searchResults.add(p);
            }
        }
        for (Person c : searchResults) {

            System.out.println();

            if (searchResults != null) {
                System.out.println(c.getFirstName() + " " +
                        c.getLastName() + " " + c.getEmail() + " " +
                        c.getPhone() + " " + c.getNotes());
            }
        }
        addressToEmail = "";
        if (searchResults.size() > 0) {
            addressToEmail = searchResults.get(0).getEmail();
        }
        menu3();
    }

    static void alphabetizeList() {

        do {

            System.out.println("1) Order by Last Name \n"
                    + "2) Order by First Name");

            if (input.hasNextInt()) {

                choice = input.nextInt();

                System.out.println(choice);

            } else {
                System.out.println("Please try again");


            }
        } while (choice != 1 && choice != 2);


        if (choice == 1) {

            //Trim white space on names and make names UpperCase in List
            for (int i = 0; i < list.size(); i++) {

                String firstName = list.get(i).getFirstName().toUpperCase().trim();
                String secondName = list.get(i).getLastName().toUpperCase().trim();

                list.get(i).setFirstName(firstName);
                list.get(i).setLastName(secondName);

            }


            String a;
            String b;
            Person c;
            Person d;

            for (int i = 0; i < list.size(); i++) {

                for (int j = 0; j < list.size() - i - 1; j++) {

                    a = list.get(j).getLastName().toUpperCase().trim();
                    b = list.get(j + 1).getLastName().toUpperCase().trim();

                    c = list.get(j);
                    d = list.get(j + 1);

                    if (a.compareTo(b) > 0) {
                        //  System.out.println(a + " is > " + b);
                        Person temp = d;  // was d
                        list.set(j + 1, c);
                        list.set(j, temp);

                    }
                }

            }
            for (Person per : list) {
                System.out.println(per);
            }
            menu2();
            //Else Alphabetize by FIRST name
        } else {

            //Trim white space on names and make names UpperCase in List
            for (int i = 0; i < list.size(); i++) {

                String firstName = list.get(i).getFirstName().toUpperCase().trim();
                String secondName = list.get(i).getLastName().toUpperCase().trim();

                list.get(i).setFirstName(firstName);
                list.get(i).setLastName(secondName);

            }

            String a;
            String b;
            Person c;
            Person d;

            for (int i = 0; i < list.size(); i++) {

                for (int j = 0; j < list.size() - i - 1; j++) {

                    a = list.get(j).getFirstName().toUpperCase().trim();
                    b = list.get(j + 1).getFirstName().toUpperCase().trim();

                    c = list.get(j);
                    d = list.get(j + 1);

                    if (a.compareTo(b) > 0) {
                        //  System.out.println(a + " is > " + b);
                        Person temp = d;  // was d
                        list.set(j + 1, c);
                        list.set(j, temp);

                    }
                }

            }
            for (Person per : list) {
                System.out.println(per);
            }
            menu2();


        }
    }


    static void menu3() {
        // TODO Menu 3
        do {

            System.out.println("Choose something to do: \n\n"
                    + "1) Delete first result \n"
                    + "2) Edit first result \n"
                    + "3) Email first result \n"
                    + "4) Search Again \n"
                    + "5) Previous menu \n"
                    + "6) Quit");

            if (input.hasNextInt()) {
                choice = input.nextInt();

            } else {
                choice = 0;
                input.next();
                System.out.println("Enter again");
            }
            ;
        } while (choice != 1 && choice != 2 && choice != 3 && choice
                != 4 && choice != 5 && choice != 6);


        switch (choice) {

            case 1: //list.remove(0); --Find result from search in list
                removeContact();
                menu2();
                break;
            case 2:     //Firgure out how to edit the contact
                menu2();
                break;
            case 3:

                emailContact(addressToEmail);//Figure out how to email the contact
                break;
            case 4:
                searchContacts();
                break;
            case 5:
                menu2();
                break;
            case 6:
                System.out.println("Thanks and Good-Bye");
                System.exit(0);
                break;
        }

    }

    static void emailContact(String address) {

        String strToMail = "mailto:" + address + "?subject=What's-Up";


        try {
            Desktop desktop;
            if (Desktop.isDesktopSupported()
                    && (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.MAIL)) {
                URI mailto = new URI(strToMail);
                desktop.mail(mailto);
            } else {

                System.out.println("MailTo not working on this system");
            }
        } catch (IOException exio) {
            System.out.println("IO Exception");
        } catch (URISyntaxException exuri) {
            System.out.println("URI exception");
        }
        ;

        menu2();
    }

    static void removeContact() {

        if (searchResults.size() > 0) {

            String first = searchResults.get(0).getFirstName();
            String last = searchResults.get(0).getLastName();

            for (int i = 0; i < list.size(); i++) {

                if (list.get(i).getFirstName() == first
                        && list.get(i).getLastName() == last) {

                    list.remove(i);

                }


            }

        }
        menu2();

    }

    static void superMenu() {
        //TODO superMenu

        do {

            System.out.println("Choose something to do: \n\n"
                    + "1) Save to Yandex with different filename \n"
                    + "2) Save to absolute path \n"
                    + "3) Import from Yandex with different filename\n"
                    + "4) Import from different filename \n");

            if (input.hasNextInt()) {
                choice = input.nextInt();

            } else {
                choice = 0;
                input.next();
                System.out.println("Enter again");
            }
            ;
        } while (choice != 1 && choice != 2 && choice != 3 && choice != 4);

        switch (choice) {

            case 1:
                saveAnywhere("Yandex");
                break;
            case 2:
                saveAnywhere("anywhere");
                break;
            case 3:
                importFromAnywhere("Yandex");//
                break;
            case 4:
                importFromAnywhere("anywhere");
                break;

        }

        menu2();


    }

    static void saveAnywhere(String where) {
        // TODO saveAnywhere

        if (where == "Yandex") {

            System.out.println("Enter filename for Yandex Documents folder:\n" +
                    "(Without extension)");
            fileName = input.next();
            input.nextLine();
            path = "/home/wayne/Yandex.Disk/Documents/";
        } else if (where == "anywhere") {

            System.out.println("Enter absolute path: \n" +
                    "(Without Extension)");
            path = input.next();
            input.nextLine();
            fileName = "";
        }

        longString = "";
        for (Person c : list) {

            longString = longString + c.getFirstName() + ", "
                    + c.getLastName() + ", " + c.getEmail() + ", " + c.getPhone() +
                    ", " + c.getNotes() + "," + "\n";
        }

        try {

            PrintWriter pw = new PrintWriter(new File(path + fileName + ".txt"));

            pw.printf(longString);

            System.out.println("Saved to " + path + fileName + ".txt");
            pw.close();

        } catch (IOException ex) {
            System.out.println("Could not write "
                    + "to file");
        }
        ;

        menu2();


    }
    //TODO import from anywhere

    static void importFromAnywhere(String where) {

        if (where == "Yandex") {

            path = "/home/wayne/Yandex.Disk/Documents/";

            System.out.println("Enter filename without extension:");
            fileName = input.next();
            input.nextLine();

        }

        if (where == "anywhere") {

            System.out.println("Enter absolute file path:");
            path = input.next();
            input.nextLine();
            fileName = "";

        }

        list.clear();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(path + fileName + ".txt"));

            String line = null;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                first = values[0];
                last = values[1];
                email = values[2];
                phone = values[3];
                notes = values[4];

                list.add(new Person(first, last, email,
                        phone, notes));

            }
            reader.close();

        } catch (IOException exio) {
            System.out.println("IO Exception:");

        }


    }

}


