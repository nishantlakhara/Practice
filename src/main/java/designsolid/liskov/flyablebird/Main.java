package designsolid.liskov.flyablebird;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // An objet can be replaced by a sub-object without breaking the program,
    // as what holds for T-objects holds for S-objects is what must be understood.
    public static void main(String[] args) {

        List<Bird> birds = new ArrayList<>();
        birds.add(new Duck());
        birds.add(new Ostrich());

        for(Bird bird: birds) {
            bird.fly();
        }
        // Ostrich cannot fly.

        // Solution: Create an interface FlyingBird and implement where ever required.
        // Because every Bird cannot fly. Remove fly from Bird class.
    }
}
