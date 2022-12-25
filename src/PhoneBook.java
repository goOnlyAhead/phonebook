import java.util.*;

public class PhoneBook {

    private Map<String, List<Contact>> storage = new HashMap<>();

    public boolean addGroup(String groupName) {
        if (storage.containsKey(groupName))
            return false;
        storage.put(groupName, new ArrayList<>());
        return true;
    }

    public boolean addContact(Contact contact, String[] groupNames) {
        for (String groupName : groupNames) {
            if (!storage.containsKey(groupName))
                return false;
            final List<Contact> groupContactList = storage.get(groupName);
            groupContactList.add(contact);
        }
        return true;
    }

    public void printPhoneContactsByGroup() {
        System.out.println("Телефоный справочник:\n" +
                "Список по группам: ");
        for (String key : storage.keySet()) {
            if (!storage.get(key).isEmpty()) {
                System.out.println("- " + key + ":");
                for (Contact contact : storage.get(key)) {
                    System.out.println("     " + contact);
                }
            }
        }
        System.out.println("----------");
    }
}

