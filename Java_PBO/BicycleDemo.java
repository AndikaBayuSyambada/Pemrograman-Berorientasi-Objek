public class BicycleDemo {
    public static void main(String[] args) {
        //  membuat object
        Bicycle bike = new Bicycle();

        //  membuat atribut dan memberi nilai
        bike.speed=10;
        bike.gear=2;

        //  memanggil method dan menunjuk nilai parameter
        bike.speedUp(10);
        bike.changeGear(2);
    }
}
