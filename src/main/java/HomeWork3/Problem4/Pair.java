package HomeWork3.Problem4;

public class Pair {
    Point b, g;

    public Pair(Point b, Point g) {
        this.b = b;
        this.g = g;
    }

    //This toString override is needed because if I don't this will return a format of "class name + @ + memory location".
    @Override
    public String toString()
    {
        return "B(" + b.x + "," + b.y + ") - G(" + g.x + "," + g.y + ")";
    }

}
