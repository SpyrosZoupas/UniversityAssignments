package manager;

/**
 * A type of {@link Property} which acts as a place of residence.
 * 
 * @author mdixon
 */
abstract class Domicile extends Property
{

	// TODO:Part1 - Add attributes
	/**
	 * The number of bedrooms in the Domicile
	 */
	private int bedrooms;
	/**
	 * Boolean that decides if {@link Domicile} is furnished. If it is true the Domicile is
	 * furnished, if it's false it is not furnished
	 */
	private boolean isFurnished;
	////////////////////////////////

	/**
	 * @return the number of bedrooms
	 */
	public int getBedrooms()
	{

		// TODO:Part1
		return bedrooms;
	}

	/**
	 * @return true if furnished
	 */
	public boolean isFurnished()
	{

		// TODO:Part1
		return isFurnished;
	}

	////////////////////////////////

	/**
	 * Constructor
	 * 
	 * @param addr     the address of the Domicile
	 * @param bedrooms the number of bedrooms
	 */
	Domicile(String addr, int bedrooms)
	{

		super(addr);
		this.bedrooms = bedrooms;
		// TODO:Part1 set attribute values
	}

}
