package DataCreationFromModel;


import DataModel.StorePojo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.github.javafaker.Faker;

public class StoreDataCreator {
    public static StorePojo store = new StorePojo();
    public static Faker fake = new Faker();

    public StorePojo newOrderData()
    {
        store.setId(fake.number().numberBetween(1,10));
        store.setPetID(fake.idNumber().valid());
        store.setQuantity(fake.number().randomDigit());
        store.setShipDate("2021-07-24T12:19:04.605Z");
        store.setStatus("approved");
        store.setComplete(fake.bool().bool());
        return store;
    }

	public String getTodayDayAndHour() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'z'", Locale.US);
		return format.format(calendar.getTime());
	}
	
}
