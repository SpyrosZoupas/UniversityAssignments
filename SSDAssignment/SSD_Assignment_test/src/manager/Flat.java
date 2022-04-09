package manager;

/**
 * A represent a Flat type {@link Domicile}.
 * 
 * @author mdixon
 */
public class Flat extends Domicile
{

	// TODO:Part1 - Add attributes
	/*
	 * The number of occupants in the flat
	 */
	private int occupants;
	///////////////////////////////////////////////

	/**
	 * Sets the number of occupants within the flat.
	 * 
	 * @param occupants the number of occupants within the flat.
	 */
	public void setOccupants(int occupants)
	{
		this.occupants = occupants;
		// TODO:Part1
	}

	/**
	 * Gets the number of occupants within the flat.
	 * 
	 * @return the number of occupants within the flat.
	 */
	public int getOccupants()
	{

		// TODO:Part1
		return occupants;
	}

	/**
	 * Constructor
	 * 
	 * @param addr     the address of the flat
	 * @param bedrooms the number of bedrooms
	 */
	public Flat(String addr, int bedrooms)
	{

		super(addr, bedrooms);
	}
}
