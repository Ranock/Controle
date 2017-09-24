package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConverterUtil {
	public static Date converterString(String date) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyy");
		Date data = new Date();
	try {
		data = df.parse(date);
	}catch(Exception e) {
		e.printStackTrace();
		data = null;
	}
		return data;
	}
}
