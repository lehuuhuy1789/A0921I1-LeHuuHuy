package ss6_inheritance_in_java.bai_tap.lop_point_va_moveablepoint;

public class MoveablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;
    public MoveablePoint(){

    }
    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public float[] getSpeed(){
        float[]array={xSpeed,ySpeed};
        return array;
    }

    @Override
    public String toString() {
        return super.toString() +
                "(speed){xs="+getxSpeed()+", ys="+getySpeed()+"}";
    }
    public MoveablePoint move(){
        float x = getX();
        float y = getY();
        x += xSpeed; // ? :
        y += ySpeed;
        setX(x);
        setY(y);
//        setX(getX() + this.xSpeed);
//        setY(getY() + this.ySpeed);
        System.out.println("đây là this: " + this); // obj hiện tại
        return this; //?
    }
}
