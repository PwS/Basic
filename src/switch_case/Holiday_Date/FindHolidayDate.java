package switch_case.Holiday_Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FindHolidayDate {

    private static SimpleDateFormat formatPaymentDate = new SimpleDateFormat("yyyyMMdd");


    private static int getDayNumber(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    private static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }


    private static Date getResultPaymentAfterWorkingHour(Date paymentDate) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");

        String strDate = formatter.format(paymentDate);

        Date result = formatter.parse(strDate);


        return result;

    }

    public static void main(String[] args) throws ParseException {
        Date defaultValue = new Date();
        System.out.println(getResultPaymentAfterWorkingHour(defaultValue));
    }


}
