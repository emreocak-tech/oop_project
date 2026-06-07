public abstract class Notification {
    protected String message;
    protected boolean isRead;
    public Notification(String message,boolean isRead){
        this.message=message;
        this.isRead=isRead;
    }
    public String getMessage(){
        return message;
    }
    public boolean getIsRead(){
        return isRead;
    }
    public void markAsRead(){
        System.out.println("The message was read");
    }
    public abstract void send();
    
}
