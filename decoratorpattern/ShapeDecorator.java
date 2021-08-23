package decoratorpattern;

public abstract class ShapeDecorator implements Shape {

    Shape decortaedShape ;

    public ShapeDecorator (Shape decortaedShape) {
        this.decortaedShape = decortaedShape;
    }

    @Override
    public void draw() {
        decortaedShape.draw();
        setColor();
    }
    
    public abstract void setColor();
}
