package interviews;

public class Test {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        Test3 test3 = new Test3();

        test2.setAge(50);
        test3.age = 500;
    }
}

class Test2 {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Test3 {
    public int age;
}

//Photo 3
//Dad -1
//Priyanka -1
//Aadhar
//Birth
//7000
//Email id



