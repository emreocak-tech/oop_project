public class CrisisNotification extends Notification{
    private String crisisLevel;
    private String recommendAction;
    public CrisisNotification(String crisisLevel,String recommendAction,String message,boolean isRead){
        super(message, isRead);
        this.crisisLevel=crisisLevel;
        this.recommendAction=recommendAction;
    }
    @Override
    public void send(){
        System.out.println("\uD83D\uDEA8");
    }
    public void escalate(){
        send();
    }

}
