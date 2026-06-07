import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<RegularUser> regularUsers = new ArrayList<>();
    private static ArrayList<CrisisResource> crisisResources = new ArrayList<>();
    private static ArrayList<Notification> notifications = new ArrayList<>();
    private static User currentUser = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        regularUsers.add(new RegularUser("emre@example.com", "emre", "pass123", "Emre Ocak", "001"));
        regularUsers.add(new RegularUser("ahmet@example.com", "ahmet", "pass456", "Ahmet Taha", "002"));
        crisisResources.add(new CrisisResource("Mental Health Hotline", "+90 500 500 50 50", "24/7 crisis support", true));
        crisisResources.add(new CrisisResource("Local Support Center", "+90 400 400 40 40", "Counseling services", false));

        System.out.println("1=Regular User  2=Anonymous User");
        int choice = scanner.nextInt(); scanner.nextLine();

        if (choice == 1) {
            System.out.print("Username: "); String username = scanner.nextLine();
            System.out.print("Password: "); String password = scanner.nextLine();

            for (RegularUser user : regularUsers) {
                if (user.getUsername().equals(username) && user.authenticate(password)) {
                    currentUser = user; break;
                }
            }

            if (currentUser != null) {
                System.out.println("Welcome " + currentUser.getName() + "!");
                showRegularUserMenu();
            } else {
                System.out.println("Invalid username or password!");
            }

        } else if (choice == 2) {
            System.out.print("Username: "); String username = scanner.nextLine();
            System.out.print("Name: ");     String name = scanner.nextLine();
            System.out.print("ID: ");       String id = scanner.nextLine();

            currentUser = new AnonymousUser(true, username, "anon123", name, id);
            System.out.println("Welcome " + currentUser.getName() + "!");
            showAnonymousUserMenu();
        }

        scanner.close();
    }

    private static void showRegularUserMenu() {
        int choice;
        do {
            System.out.println("\n1=My Info  2=Crisis Resources  3=Notifications  4=Reminders  5=Export Data  6=Delete Account  0=Logout");
            choice = scanner.nextInt(); scanner.nextLine();
            switch (choice) {
                case 1: System.out.println(currentUser.toString()); break;
                case 2: showCrisisResources(); break;
                case 3: showNotifications(); break;
                case 4: showReminders(); break;
                case 5: System.out.println(((RegularUser) currentUser).exportData()); break;
                case 6: ((RegularUser) currentUser).deleteAccount(); currentUser = null; return;
                case 0: currentUser = null; break;
            }
        } while (choice != 0 && currentUser != null);
    }

    private static void showAnonymousUserMenu() {
        int choice;
        do {
            System.out.println("\n1=My Status  2=Crisis Resources  3=Notifications  4=Reminders  0=Exit");
            choice = scanner.nextInt(); scanner.nextLine();
            switch (choice) {
                case 1: System.out.println(currentUser.toString()); break;
                case 2: showCrisisResources(); break;
                case 3: showNotifications(); break;
                case 4: showReminders(); break;
                case 0: currentUser = null; break;
            }
        } while (choice != 0 && currentUser != null);
    }

    private static void showCrisisResources() {
        for (int i = 0; i < crisisResources.size(); i++) {
            CrisisResource r = crisisResources.get(i);
            System.out.println((i + 1) + ". " + r.getName() + " - " + r.getDescription() + " (24/7: " + r.getIs24Hours() + ")");
        }
        System.out.print("Select (0 to cancel): ");
        int choice = scanner.nextInt(); scanner.nextLine();

        if (choice > 0 && choice <= crisisResources.size()) {
            CrisisResource selected = crisisResources.get(choice - 1);
            System.out.println("1=Get Help Info  2=One Tap Call");
            int action = scanner.nextInt(); scanner.nextLine();
            if (action == 1) selected.getHelp();
            else if (action == 2) selected.oneTapCall();

            new CrisisNotification("HIGH", "Call emergency services", "Crisis detected", false).send();
        }
    }

    private static void showNotifications() {
        if (notifications.isEmpty()) { System.out.println("No notifications."); return; }
        for (Notification n : notifications) {
            System.out.println("- " + n.getMessage());
            n.markAsRead();
        }
    }

    private static void showReminders() {
        System.out.print("Create a reminder? (yes/no): ");
        if (!scanner.nextLine().equalsIgnoreCase("yes")) return;

        System.out.print("Message: ");  String message = scanner.nextLine();
        System.out.print("Type: ");     String type = scanner.nextLine();
        System.out.print("Interval (min): "); int interval = scanner.nextInt(); scanner.nextLine();

        ReminderNotification reminder = new ReminderNotification(type, interval, message, false);
        reminder.send();
        reminder.snooze();
        notifications.add(reminder);
    }
}