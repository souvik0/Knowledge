package factoryPattern;

public class HatchBack extends Car{

    public HatchBack(CarType model) {
        super(model);
    }

    public void construct() {
        System.out.println("Contructing Hatchback");
    }
}