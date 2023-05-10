package komponenten.listen;

public class StadtTemperatur {

	private String stadt;
	private double temperatur;
	private double minTemperatur;
	private double maxTemperatur;
	
	public StadtTemperatur(String stadt,  double temperatur, double maxTemperatur, double minTemperatur) {
		super();
		this.maxTemperatur = maxTemperatur;
		this.minTemperatur = minTemperatur;
		this.stadt = stadt;
		this.temperatur = temperatur;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	public double getTemperatur() {
		return temperatur;
	}

	public void setTemperatur(double temperatur) {
		this.temperatur = temperatur;
	}

	public double getMinTemperatur() {
		return minTemperatur;
	}

	public void setMinTemperatur(double minTemperatur) {
		this.minTemperatur = minTemperatur;
	}

	public double getMaxTemperatur() {
		return maxTemperatur;
	}

	public void setMaxTemperatur(double maxTemperatur) {
		this.maxTemperatur = maxTemperatur;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return stadt + " " + temperatur;
	}
	
	
	
	
	
	
	
}
