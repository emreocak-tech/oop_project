public class RegularUser extends User{
    private String email;
    public RegularUser(String email,String username,String password,String name,String id){
        super(username, password, name, id);
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    @Override
    public String getRole(){
        return "Regular User";
    }
    @Override
    public boolean authenticate(String password){
        boolean value=super.checkPassword(password);
        if(value==true){
            return true;
        }
        else{
            return false;
        }
    }
    public String exportData(){
        return "UserName :" + " " + super.getUsername() + " " + " , Name :" + " " + super.getName() + " " + " , Email :" + " " + getEmail();
    }
    public void deleteAccount(){
        System.out.println("The Account is being deleting :" + " " + super.getUsername());
    }
}
