package designpatterns.behavorial.state.trafficlight;

public class Plane implements Comparable<Plane>
{
    int planeId;
    int order;
    boolean isEmergency;

    public Plane(int planeId, int order, boolean isEmergency) {
        this.planeId = planeId;
        this.order = order;
        this.isEmergency = isEmergency;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "planeId=" + planeId +
                ", order=" + order +
                ", isEmergency=" + isEmergency +
                '}';
    }

    @Override
    public int compareTo(Plane o) {
        if(this.isEmergency && o.isEmergency) {
            if(this.order > o.order) {
                return 1;
            } else if(o.order > this.order) {
                return -1;
            } else {
                return 0;
            }
        } else if(this.isEmergency) {
            return -1;
        } else if(o.isEmergency) {
            return 1;
        } else {
            if (this.order > o.order) {
                return 1;
            } else if (o.order > this.order) {
                return -1;
            } else {
                return 0;
            }
        }
    }

//    @Override
//    public int compareTo(Plane o) {
//        //System.out.println(this + "\t" + o);
//        if(this.isEmergency && o.isEmergency) {
//            //System.out.println(this.order < o.order? this.order:o.order);
//            if(this.order < o.order) {
//                return Integer.MIN_VALUE + o.order;
//            } else {
//                return Integer.MIN_VALUE + this.order;
//            }
//        } else if(this.isEmergency) {
//            //System.out.println(2);
//            return Integer.MIN_VALUE + o.order;
//        } else if (o.isEmergency) {
//            return Integer.MIN_VALUE + this.order;
//        } else
//            System.out.println(this.order > o.order ? this.order:o.order);
//            return (this.order > o.order ? this.order:o.order);
//    }
}
