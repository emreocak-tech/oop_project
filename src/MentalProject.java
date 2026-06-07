package com.mycompany.mentalproject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;


public class MentalProject {  
    
    private static ArrayList<RegularUser> regularUsers = new ArrayList<>();
    private static ArrayList<CrisisResource> crisisResources = new ArrayList<>();
    private static ArrayList<Notification> notifications = new ArrayList<>();
    private static User currentUser = null;
    private static Scanner sc = new Scanner(System.in);

    private static Journal appJournal = new Journal();
    private static HabitGoal waterGoal = new HabitGoal("Günlük Su", 5, "Su İçme");
    
    
    static Map<String, Command> commandsMap = new HashMap<>(Map.ofEntries(
        Map.entry("get-advice", new Advices()),
        Map.entry("log-feeling", new Feelings()),
        Map.entry("start-breathing-exercise", new BreathingExercise())
    ));  
    
    public static void main(String[] args) {
        regularUsers.add(new RegularUser("emre@example.com", "emre", "pass123", "Emre Ocak", "001"));
        regularUsers.add(new RegularUser("ahmet@example.com", "ahmet", "pass456", "Ahmet Taha", "002"));
        crisisResources.add(new CrisisResource("Mental Health Hotline", "+90 500 500 50 50", "24/7 crisis support", true));
        crisisResources.add(new CrisisResource("Local Support Center", "+90 400 400 40 40", "Counseling services", false));

        System.out.println("=========================================");
        System.out.println("   MENTAL TAKİP SİSTEMİ BAŞLATILDI V2.0  ");
        System.out.println("=========================================\n");
        System.out.println("1=Regular User  2=Anonymous User");
        System.out.print("Seçim: ");
        int choice = sc.nextInt(); sc.nextLine();

        if (choice == 1) {
            System.out.print("Username: "); String username = sc.nextLine();
            System.out.print("Password: "); String password = sc.nextLine();

            for (RegularUser user : regularUsers) {
                if (user.getUsername().equals(username) && user.authenticate(password)) {
                    currentUser = user; break;
                }
            }

            if (currentUser != null) {
                System.out.println("\n✅ Hoş geldin " + currentUser.getName() + "!");
                showRegularUserMenu();
            } else {
                System.out.println("❌ Invalid username or password!");
            }

        } else if (choice == 2) {
            System.out.print("Username: "); String username = sc.nextLine();
            System.out.print("Name: ");     String name = sc.nextLine();
            System.out.print("ID: ");       String id = sc.nextLine();

            currentUser = new AnonymousUser(true, username, "anon123", name, id);
            System.out.println("\n✅ Hoş geldin " + currentUser.getName() + "!");
            showAnonymousUserMenu();
        }
        
        while(true){
            String command = sc.nextLine();
            if (command.equals("exit")) break;
            String[] parts = command.split(" ");
            
            if (commandsMap.containsKey(parts[0])) {
                commandsMap.get(parts[0]).execute(parts.length > 1 ? Arrays.copyOfRange(parts, 1, parts.length) : null);
            } else {
                System.out.println("Unknown command: " + parts[0]);
            }
        }
    }

    
    private static void showRegularUserMenu() {
        int choice;
        do {
            System.out.println("\n--- ANA MENÜ ---");
            System.out.println("1=My Info         2=Crisis Resources   3=Notifications    4=Reminders");
            System.out.println("5=Add Journal     6=Read Journal       7=Drink Water      8=Log Feeling");
            System.out.println("9=Get Advice      10=Breathing Ex.     11=Export Data     12=Delete Account");
            System.out.println("0=Logout");
            System.out.print("Select: ");
            choice = sc.nextInt(); sc.nextLine();
            
            switch (choice) {
                case 1: System.out.println(currentUser.toString()); break;
                case 2: showCrisisResources(); break;
                case 3: showNotifications(); break;
                case 4: showReminders(); break;
                case 5: 
                    System.out.print("📝 Bugünün günlük notunu gir: ");
                    String note = sc.nextLine();
                    String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    appJournal.addEntry(date, note);
                    break;
                case 6: 
                    appJournal.showAllEntries(); 
                    break;
                case 7: 
                    waterGoal.incrementProgress();
                    if (waterGoal.isComplete()) {
                        System.out.println("🎉 Tebrikler! Günlük su hedefini tamamladın!");
                    }
                    break;
                case 8:
                    System.out.print("🧠 Şu an nasıl hissediyorsun?: ");
                    String feel = sc.nextLine();
                    commandsMap.get("log-feeling").execute(new String[]{feel}); 
                    break;
                case 9:
                    commandsMap.get("get-advice").execute(null);
                    break;
                case 10:
                    commandsMap.get("start-breathing-exercise").execute(null);
                    break;
                case 11: System.out.println(((RegularUser) currentUser).exportData()); break;
                case 12: ((RegularUser) currentUser).deleteAccount(); currentUser = null; return;
                case 0: currentUser = null; System.out.println("Çıkış yapıldı."); break;
                default: System.out.println("Geçersiz seçim!");
            }
        } while (choice != 0 && currentUser != null);
    }

    private static void showAnonymousUserMenu() {
        int choice;
        do {
            System.out.println("\n--- ANONİM MENÜ ---");
            System.out.println("1=My Status       2=Crisis Resources   3=Notifications");
            System.out.println("4=Reminders       5=Drink Water        6=Log Feeling");
            System.out.println("7=Get Advice      8=Breathing Ex.      0=Exit");
            System.out.print("Select: ");
            choice = sc.nextInt(); sc.nextLine();
            
            switch (choice) {
                case 1: System.out.println(currentUser.toString()); break;
                case 2: showCrisisResources(); break;
                case 3: showNotifications(); break;
                case 4: showReminders(); break;
                case 5: 
                    waterGoal.incrementProgress();
                    if (waterGoal.isComplete()) {
                        System.out.println("🎉 Tebrikler! Günlük su hedefini tamamladın!");
                    }
                    break;
                case 6:
                    System.out.print("🧠 Şu an nasıl hissediyorsun?: ");
                    String feel = sc.nextLine();
                    commandsMap.get("log-feeling").execute(new String[]{feel});
                    break;
                case 7:
                    commandsMap.get("get-advice").execute(null);
                    break;
                case 8:
                    commandsMap.get("start-breathing-exercise").execute(null);
                    break;
                case 0: currentUser = null; System.out.println("Çıkış yapıldı."); break;
                default: System.out.println("Geçersiz seçim!");
            }
        } while (choice != 0 && currentUser != null);
    }

    private static void showCrisisResources() {
        for (int i = 0; i < crisisResources.size(); i++) {
            CrisisResource r = crisisResources.get(i);
            System.out.println((i + 1) + ". " + r.getName() + " - " + r.getDescription() + " (24/7: " + r.getIs24Hours() + ")");
        }
        System.out.print("Select (0 to cancel): ");
        int choice = sc.nextInt(); sc.nextLine();

        if (choice > 0 && choice <= crisisResources.size()) {
            CrisisResource selected = crisisResources.get(choice - 1);
            System.out.println("1=Get Help Info  2=One Tap Call");
            int action = sc.nextInt(); sc.nextLine();
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
        if (!sc.nextLine().equalsIgnoreCase("yes")) return;

        System.out.print("Message: ");  String message = sc.nextLine();
        System.out.print("Type: ");     String type = sc.nextLine();
        System.out.print("Interval (min): "); int interval = sc.nextInt(); sc.nextLine();

        ReminderNotification reminder = new ReminderNotification(type, interval, message, false);
        reminder.send();
        reminder.snooze();
        notifications.add(reminder);
    }


}




