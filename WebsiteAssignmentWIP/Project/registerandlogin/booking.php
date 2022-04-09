<h1>Booking</h1>
<form action="insertBooking.php" method="post">
  <?php
  $mindate = date("d-m-Y");
  ?>
  <label>Booking Date</label>
  <input type="date" required id="date" name="date" value="<?=date("d-m-Y")?>">

  <label>Timeslot</label>
  <select name="time">
    <option value="AM">AM</option>
    <option value="PM">PM</option>
  </select>

  <input type="submit" value="Submit"/>
</form>