package Jzx;

public class Dog {
    private  String Name;
    private int age;
    private String type;

    public Dog(String type) {
        this.type =type;
    }

    public void SetName( String nm) {
        Name = nm;
    }
    public  void ShowProfile(){
        System.out.println(type+"名前"+Name+","+age+"です.");

    }

    public void SetAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
      Dog dog1 =new Dog("H");
      dog1.SetName("AAA");
      dog1.SetAge(12);
      dog1.ShowProfile();

    }
}


