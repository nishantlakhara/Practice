package designpatterns.structural.adapter.duck;

public class Main {

    /**
     *

     * +--------------------+
     * |      Duck          |<------------------+
     * |--------------------|                   |
     * | + quack()          |                   |
     * | + fly()            |                   |
     * +--------------------+                   |
     *            ^                               |
     *            |                               |
     *    +---------------+            +-------------------+      +------------------+
     *    | MallardDuck   |            | TurkeyAdapter     |      | Turkey           |
     *    |---------------|            |-------------------|      |------------------|
     *    | + quack()     |            | + quack()         |      | + gobble()       |
     *    | + fly()       |            | - turkey: Turkey  |------| + fly()          |
     *    +---------------+            | + fly()           |      +------------------+
     *                                 +-------------------+
     */
    public static void main(String[] args) {
        Duck duck = new MallardDuck();

        Turkey turkey = new WildTurkey();

        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("Adaptee \"Turkey\" says ...");
        turkey.gobble();
        turkey.fly();

        System.out.println("Target interface \"Duck\" says ...");
        clientCallDuckGTargetInterfaceOnly(duck);

        System.out.println("Adapter \"Turkey adapter\" says ...");
        clientCallDuckGTargetInterfaceOnly(turkeyAdapter);
    }

    private static void clientCallDuckGTargetInterfaceOnly(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
