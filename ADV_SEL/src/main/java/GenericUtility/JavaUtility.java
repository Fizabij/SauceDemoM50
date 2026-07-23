package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaUtility {

	public String togetDate(){
		Date d = new Date();
		SimpleDateFormat sim= new SimpleDateFormat("dd-MM-yyyy");
		sim.format(d);
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String datereq =sim.format(cal.getTime());
		return datereq;
	}
	

}
