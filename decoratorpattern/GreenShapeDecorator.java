package decoratorpattern;

public class GreenShapeDecorator extends ShapeDecorator {

    public GreenShapeDecorator(Shape decortaedShape) {
        super(decortaedShape);
	}

    @Override
    public void setColor() {
        System.out.println("Green border draw");
    }
}
