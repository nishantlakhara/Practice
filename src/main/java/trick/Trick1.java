package trick;

public class Trick1 {
    public static void main(String[] args) {
        System.out.println(10+10+"HELLO"+10+10);
        System.out.println("HELLO"+10+10);
        System.out.println(10+10+"HELLO");

        int show = new Trick1().show();
        System.out.println(show);
    }

    int show(){
        try{
            return 1;
            //throw new RuntimeException();
        }catch(Exception e){
            return 2;
        }finally{
            return 3;
        }
    }


}
