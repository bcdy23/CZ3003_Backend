package GPS;

public class LatLonCoordinate {
	private final double latitude;
	private final double longitude;
	
	public LatLonCoordinate(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public SVY21Coordinate asSVY21() {
		return SVY21.computeSVY21(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LatLonCoordinate other = (LatLonCoordinate) obj;
		if (Double.doubleToLongBits(latitude) != Double
				.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double
				.doubleToLongBits(other.longitude))
			return false;
		return true;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	@Override
	public String toString() {
		return "LatLonCoordinate [latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
}