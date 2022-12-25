import java.util.*;

public class Main {


    public static void main(String[] args) {

        PhoneBook contacts = new PhoneBook();
        List<Contact> sortContacts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        fillingGroups(contacts, scanner);
        fillingContacts(contacts, scanner, sortContacts);

        contacts.printPhoneContactsByGroup();
        printPhoneContactsBySortNumber(sortContacts);
    }

    private static void fillingGroups(PhoneBook contacts, Scanner scanner) {
        String input;
        while (true) {
            System.out.println("Введите имя группы или введите \"end\"");
            input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            contacts.addGroup(input);
        }
    }

    private static void fillingContacts(PhoneBook contacts, Scanner scanner, List<Contact> sortContacts) {
        String input;
        while (true) {
            System.out.println("Введите имя и номер телефона или введите \"end\"");
            input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            final String[] contactData = input.split("\\s+");
            Contact contact = new Contact(contactData[0], contactData[1]);

            System.out.println("Введите название групп в который хотите добавить контакт");
            input = scanner.nextLine();
            final String[] groupNames = input.split("\\s+");
            contacts.addContact(contact, groupNames);
            addToSortContacts(contact, sortContacts);
        }
    }

    private static void addToSortContacts(Contact contact, List<Contact> sortContacts) {
        int value = Collections.binarySearch(sortContacts, contact);
        if (value < 0) {
            sortContacts.add(Math.abs(value) - 1, contact);
        }
    }

    private static void printPhoneContactsBySortNumber(List<Contact> sortContacts) {
        System.out.println("Отсортированный список:\n" +
                "- По номерам: ");
        for (Contact contact : sortContacts) {
            System.out.println("     " + contact);
        }
    }
}
