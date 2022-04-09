package manager;

/**
 * Abstract class to represent a person.
 * 
 * @author mdixon
 *
 */
abstract class Person
{

	// TODO:Part1 - Add attributes
	/**
	 * Attributes that store the person's address, phone, name, email
	 */
	private String addr;
	private String phone;
	private String name;
	private String email;
	///////////////////////////////////////////////

	/**
	 * @return the home address of the person
	 */
	public String getAddr()
	{

		// TODO:Part1
		return addr;
	}

	/**
	 * @param addr the home address of the person
	 */
	public void setAddr(String addr)
	{
		this.addr = addr;
		// TODO:Part1
	}

	/**
	 * @return the phone number of the person
	 */
	public String getPhone()
	{

		// TODO:Part1
		return phone;
	}

	/**
	 * @param phone the phone number of the person
	 */
	public void setPhone(String phone)
	{
		this.phone = phone;
		// TODO:Part1
	}

	/**
	 * @return the email addr of the person
	 */
	public String getEmail()
	{

		// TODO:Part1
		return email;
	}

	/**
	 * @param email the email addr of the person
	 */
	public void setEmail(String email)
	{
		this.email = email;
		// TODO:Part1
	}

	/**
	 * @return the name of the person
	 */
	public String getName()
	{

		// TODO:Part1
		return name;
	}

	/**
	 * @param name the new name of the person
	 */
	public void setName(String name)
	{
		this.name = name;
		// TODO:Part1
	}

	///////////////////////////////////////////////

	/**
	 * Constructor
	 * 
	 * @param name the name of the person
	 */
	Person(String name)
	{
		this.name = name;
		// TODO:Part1 - Set name attribute
	}
}
