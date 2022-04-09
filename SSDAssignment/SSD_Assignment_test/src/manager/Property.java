package manager;

/**
 * An abstract class that represents all types of properties.
 * 
 * @author mdixon
 *
 */
abstract class Property
{

	// TODO:Part1 - Add attributes

	/**
	 * Address of the property
	 */
	public String address;
	/**
	 * tenant of the property
	 */
	private Tenant tenant = null;
	////////////////////////////////////

	/**
	 * 
	 * @return the property address.
	 */
	public String getAddress()
	{

		// TODO:Part1
		return address;
	}

	/**
	 * Sets the tenant of the property.
	 * 
	 * @param tenant the tenant of the property
	 */
	public void setTenant(Tenant tenant)
	{
		this.tenant = tenant;
		// TODO:Part3
	}

	/**
	 * Removes any tenant from the property.
	 */
	public void removeTenant()
	{
		tenant = null;
		// TODO:Part3
	}

	/**
	 * 
	 * @return true if the property has a tenant
	 */
	public boolean hasTenant()
	{
		if (tenant == null)
		{
			return false;

		} else
		{
			return true;
		}
		// TODO:Part3
	}

	/**
	 * Constructor
	 * 
	 * @param address the property address.
	 */
	Property(String address)
	{
		this.address = address;
		// TODO:Part1 - Set attribute
	}

}
