import entity.Accountant;
import entity.Student;
import entity.enums.Classes;
import entity.enums.Sex;
import interfaces.AccountantFacade;
import interfaces.StudentFacade;
import service.AccountantFacadeImpl;
import service.StudentFacadeImpl;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static void startAccountantMenu() {
        System.out.println("Menu logowania księgowego: ");
        System.out.println("1 - Zaloguj się");
        System.out.println("2 - Utwórz konto księgowego");
        System.out.println("0 - Wyjdź");
    }

    /*private static void loginAdminMenu() {     --- next feature
        System.out.println("Menu główne admina: ");
        System.out.println("1 - Dodaj księgowego");
        System.out.println("2 - Usuń księgowego");
        System.out.println("3 - Wyświetl listę księgowych");
        System.out.println("4 - Wyświetl liczbę księgowych");
        System.out.println("0 - Wyjdź");
    }*/

    private static void loginAccountantMenu() {
        System.out.println("Menu główne księgowego: ");
        System.out.println("1 - Dodaj studenta");
        System.out.println("2 - Usuń studenta");
        System.out.println("3 - Wyświetl listę studentów");
        System.out.println("4 - Wyświetl liczbę studentów");
        System.out.println("0 - Wyjdź");
    }

    private static Accountant createAccountant() {
        String name;
        String lastName;
        String login;
        String password;
        String eMail;
        System.out.println("Wypełnij dane księgowego:");
        System.out.print("Imię: ");
        name = scanner.next();
        System.out.print("Nazwisko: ");
        lastName = scanner.next();
        System.out.print("Login: ");
        login = scanner.next();
        System.out.print("Password: ");
        password = scanner.next();
        System.out.print("eMail: ");
        eMail = scanner.next();
        return new Accountant(name, lastName, login, password, eMail);
    }

    private static Student createStudent() {
        String name;
        String lastName;
        String pesel;
        Sex sex;
        Classes classes;
        String address;
        String phoneNumber;
        String eMail;
        int cost;
        int payment;
        System.out.println("Wypełnij dane studenta:");
        System.out.print("Imię: ");
        name = scanner.next();
        System.out.print("Nazwisko: ");
        lastName = scanner.next();
        System.out.print("Pesel: ");
        pesel = scanner.next();
        System.out.print("Płeć (KOBIETA,MĘŻCZYZNA): ");
        sex = Sex.valueOf(scanner.next());
        System.out.print("Zajęcia (MATEMATYKA, FIZYKA, BIOLOGIA, CHEMIA, SZTUKA): ");
        classes = Classes.valueOf(scanner.next());
        System.out.print("Adres: ");
        address = scanner.next();
        System.out.print("Numer telefonu: ");
        phoneNumber = scanner.next();
        System.out.print("eMail: ");
        eMail = scanner.next();
        System.out.print("Koszt zajęć: ");
        cost = scanner.nextInt();
        System.out.print("Ile opłacono?: ");
        payment = scanner.nextInt();
        return new Student(name, lastName, pesel, sex, classes, address, phoneNumber, eMail, cost, payment);
    }

    public static void main(String[] args) {
        AccountantFacade accountantFacade = AccountantFacadeImpl.getInstance();
        StudentFacade studentFacade = StudentFacadeImpl.getInstance();

        boolean apkOn = true;
        boolean logged = false;
        int operation;

        while (apkOn) {
            startAccountantMenu();
            operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    System.out.print("Podaj login: ");
                    String accountantLogin = scanner.next();
                    System.out.print("Podaj hasło: ");
                    String accountantPassword = scanner.next();
                    if (accountantFacade.logInAccountant(accountantLogin, accountantPassword)) {
                        logged = true;
                        System.out.println("Użytkownik zalogowany");
                    } else {
                        System.out.println("Błędne dane.");
                    }
                    break;
                case 2:
                    Accountant accountant = createAccountant();
                    accountantFacade.registerAccountant(accountant);
                    break;
                case 0:
                    apkOn = false;
                    break;
                default:
                    System.out.println("Nieznane polecenie.");
                    break;
            }
            while (logged) {
                loginAccountantMenu();
                operation = scanner.nextInt();
                switch (operation) {
                    case 1:
                        Student studentAdd = createStudent();
                        System.out.println(studentFacade.createStudent(studentAdd));
                        break;
                    case 0:
                        logged = false;
                        break;
                    default:
                        System.out.println("Nieznane polecenie.");
                        break;
                }
            }
        }
    }
}
