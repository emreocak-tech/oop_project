public abstract class User extends Person {
    private String username;
    private String password;
    public User(String username,String password,String name,String id){
        super(name, id);
        this.username=username;
        this.password=password;
    }
    public String getUsername(){
        return username;
    }
    public boolean checkPassword(String inputPassword){
        if(password.equals(inputPassword)){
            return true;
        }
        else{
            return false;
        }
    }
    public abstract boolean authenticate(String password);
    public String toString(){
        return super.toString() + " " + "Kullanıcı Adı :" + " " + getUsername();
    }
}
