public class ReminderNotification extends Notification{
    private String reminderType;
    private int repeatInterval;
    public ReminderNotification(String reminderType,int repeatInterval,String message,boolean isRead){
        super(message,isRead);
    }
    @Override
    public void send(){
        System.out.println("\uD83D\uDD14");
    }
    public String getReminderType(){
        return reminderType;
    }
    public int getRepeatInterval(){
        return repeatInterval;
    }
    public void snooze(){
        System.out.println("Hatırlatma" + " " + getRepeatInterval() + " " + "dakika ertelendi!");
    }
}
