package manager;

/**
 * Represents a Room within a {@link Hotel}.
 * 
 * @author mdixon
 *
 */
public class Room implements SecuredAccess
{

	/**
	 * The room number within the hotel.
	 */
	private int roomNumber;

	/**
	 * Attribute that stores the code required for accessing the room
	 */
	public String storedCode = "9999";

	// TODO:Part2 add attribute to store access code
	/**
	 * Current guest living in the room
	 */
	private Guest guest = null;
	// TODO:Part3 add attribute to store current Guest (occupant)

	////////////////////////////////

	@Override
	public void setCode(String code)
	{
		this.storedCode = code;
		// TODO:Part2
	}

	@Override
	public boolean checkCode(String code)
	{
		if (isLockedOut() || !code.equals(storedCode))
		{

			return false;
		}

		// TODO:Part2

		return true;
	}

	@Override
	public void resetToDefault()
	{
		this.storedCode = "9999";
		// TODO:Part2
	}

	@Override
	public boolean isLockedOut()
	{

		return false;
	}

	@Override
	public int getIncorrectAttempts()
	{

		// TODO:Part2
		return 0;
	}

	/**
	 * @return the roomNum
	 */
	public int getRoomNum()
	{

		// TODO:Part1
		return roomNumber;
	}

	/**
	 * @param roomNum the roomNum to set
	 */
	public void setRoomNum(int roomNum)
	{
		this.roomNumber = roomNum;
		// TODO:Part1
	}

	/**
	 * Sets the occupant of the room.
	 * 
	 * @param guest the guest which is to occupy the room
	 */
	public void setOccupant(Guest guest)
	{
		this.guest = guest;
		// TODO:Part3
	}

	/**
	 * Removes any occupant from the room.
	 */
	public void removeOccupant()
	{
		this.guest = null;
		// TODO:Part3
	}

	/**
	 * 
	 * @return true if the room has an occupant
	 */
	public boolean hasOccupant()
	{
		// TODO:Part3
		if (guest == null)
		{
			return false;
		} else
		{
			return true;
		}
	}

	////////////////////////////////

	/**
	 * Constructor.
	 * 
	 * @param roomNum the room number
	 */
	public Room(int roomNum)
	{
		this.roomNumber = roomNum;
		// TODO:Part1 - set the roomNum attribute
	}

}
