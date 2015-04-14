package GPS;

public class SVY21Coordinate {
	private final double easting;
	private final double northing;
	
	public SVY21Coordinate(double northing, double easting) {
		super();
		this.northing = northing;
		this.easting = easting;
	}
	
	public LatLonCoordinate asLatLon() {
		return SVY21.computeLatLon(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SVY21Coordinate other = (SVY21Coordinate) obj;
		if (Double.doubleToLongBits(easting) != Double
				.doubleToLongBits(other.easting))
			return false;
		return Double.doubleToLongBits(northing) == Double
                        .doubleToLongBits(other.northing);
	}
	
	public double getEasting() {
		return easting;
	}
	
	public double getNorthing() {
		return northing;
	}
	
	@Override
	public String toString() {
		return "SVY21Coordinate [northing=" + northing + ", easting=" + easting
				+ "]";
	}
}