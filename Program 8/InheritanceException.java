class WrongAgeException extends Exception{
    public WrongAgeException(String s){
        super(s);
    }
}

class Father {
    int age;
    Father(int age) throws WrongAgeException{
        if(age<0){
            throw new WrongAgeException("Age cannot be negative");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

class Son extends Father {
    Son(int fatherAge, int sonAge) throws WrongAgeException {
        super(fatherAge); 
        if (sonAge < 0) {
            throw new WrongAgeException("Son's age cannot be negative");
        }
        if (sonAge >= fatherAge) {
            throw new WrongAgeException("Son's age cannot be greater than or equal to father's age");
        }
        this.age = sonAge; 
    }
}
public class InheritanceException {
    public static void main(String[] args) {
        try {
            Father f1 = new Father(50);
            Son s1 = new Son(50, 20);
            System.out.println("Test case passed");

            Father f2 = new Father(-1);
        } catch (WrongAgeException e) {
            System.out.println(e.getMessage());
        }

        try {
            Father f3 = new Father(50);
            Son s2 = new Son(50, 60);
        } catch (WrongAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
