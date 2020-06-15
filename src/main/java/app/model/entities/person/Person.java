package app.model.entities.person;

public abstract class Person {
    protected String name = "";
    protected int age = 18;
    protected String login = "";
    protected String password ="";

    public Person()
    {

    }

    public Person(String name, int age)
    {
        setName(name);
        setAge(age);
        setLogin(name+age);
        setPassword(name+age);
    }

    public Person(String name, int age,String login, String password)
    {
        setName(name);
        setAge(age);
        setLogin(login);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean tryChangePassword(String oldPassword,String newPassword)
    {
        if(oldPassword == this.password)
        {
            this.password = newPassword;
            return true;
        }
        else
        {
            return false;
        }
    }

    public void setName(String name) {
        if(name!=null)
        {
            this.name = name;
        }
        else
        throw new IllegalArgumentException("Name is null");
    }

    public void setAge(int age) {
        if(!(age<=18&&age>100))
        {
            this.age = age;
        }
        else
            throw new IllegalArgumentException("Age is unavailable");
    }

    public void setLogin(String login) {
        if(login!=null)
        {
            this.login = login;
        }
        else

        throw new IllegalArgumentException("Login is null");
    }

    public void setPassword(String password) {
        if(password!=null)
        {
            this.password = password;
        }
        else
        throw new IllegalArgumentException("Password is null");
    }
}
