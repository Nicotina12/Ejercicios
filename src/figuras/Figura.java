package figuras;

public abstract class Figura implements Comparable <Figura>{
	public double area;
	
	public Figura (double area) {
		super();
		this.area = area;
		
	
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
 public int compareTo(Figura o) {
	 return Double.compare(this.getArea(), o.getArea());
 }
}
