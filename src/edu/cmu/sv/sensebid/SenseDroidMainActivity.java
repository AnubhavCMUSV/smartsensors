package edu.cmu.sv.sensebid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gdata.util.ServiceException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SenseDroidMainActivity extends Activity {

	@Override
	public final void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		CalendarProvider calendarProvider = new CalendarProvider();
		ArrayList<Reservation> events = new ArrayList<Reservation>();
		try {
			// Get from UI
			String userName = "";
			String password = "";
			events = calendarProvider.readCalendarEvents(userName, password);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(events.toString());
		
		
		Intent i = new Intent(this, SensorDataPublisherService.class);
		startActivity(i);

		Intent j = new Intent(this, BidForTemperatureActivity.class);
		startActivity(j);
	}

}
