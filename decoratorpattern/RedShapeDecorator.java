package decoratorpattern;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decortaedShape) {
        super(decortaedShape);
	}

	@Override
	public void setColor() {
        System.out.println("Red border draw");
    }
}
