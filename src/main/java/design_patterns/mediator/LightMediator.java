package design_patterns.mediator;

import java.util.ArrayList;
import java.util.List;

public class LightMediator {
    List<Light> lights = new ArrayList<>();

    public void register(Light light) {
        lights.add(light);
    }

    public void unregister(Light light) {
        lights.remove(this);
    }

    public void notifyStateChange(Light light) {
        for(Light curlight: lights) {
            if(!curlight.equals(light)) {
                curlight.turnOff();
            }
        }
    }
}
