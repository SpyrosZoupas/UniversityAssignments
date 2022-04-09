package manager;

/**
 * A type of {@link Property} that acts as an Office
 * 
 * @author spiro
 *
 */
public class Office extends Property implements SecuredAccess
{

	/**
	 * The stored security code.
	 */
	private String storedCode = "1234"; // TODO:Part2

	/**
	 * Attribute that counts incorrect attempts and stores them
	 */
	public int incorrectAttempts = 0;

	// TODO:Part2 add attribute to store number of incorrect attempts

	//////////////////////////////////////////////////////

	@Override
	public void setCode(String code)
	{
		this.storedCode = code;
		incorrectAttempts = 0;
		// TODO:Part2
	}

	@Override
	public boolean checkCode(String code)
	{

		if (isLockedOut() || !code.equals(storedCode))
		{
			// is locked out, or codes do not match
			++incorrectAttempts;
			return false;
			// TODO:Part2 - increment attempts, then return false
		}

		// not locked, and codes match
		incorrectAttempts = 0;
		return true;
	}

	@Override
	public void resetToDefault()
	{
		this.storedCode = "1234";
		incorrectAttempts = 0;
		// TODO:Part2
	}

	@Override
	public boolean isLockedOut()
	{
		if (incorrectAttempts > 5)
		{
			return true;
		} else
		{
			return false;

		}
		// TODO:Part2 - check attempts again limit, return true if limit exceeded
	}

	@Override
	public int getIncorrectAttempts()
	{

		// TODO:Part2
		return incorrectAttempts;
	}

	//////////////////////////////////////////////////////
	/**
	 * Constructor
	 * 
	 * @param address the address of the Office
	 */
	public Office(String address)
	{

		super(address);
	}

}
