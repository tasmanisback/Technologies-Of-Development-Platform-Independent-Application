package app.model.entities.requisiiton.date;

public class Date {
    private int year = 2000;
    private int month = 1;
    private int day = 1;

    public Date(int year, int month, int day)
    {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public Date(String date)
    {
        StringBuilder str = new StringBuilder();
        char[]date1 = date.toCharArray();
        for(int start = 0, pos = 0; start<date1.length; ++start)
        {
            if(date1[start] =='-'|| start+1==date1.length)
            {
                if(pos == 0)
                {
                    year = Integer.parseInt(str.toString());
                    str.delete(0,start);
                    pos=1;
                }
                else
                {
                    if(pos==1)
                    {
                        month = Integer.parseInt(str.toString());
                        str.delete(0,start);
                        pos=2;
                    }
                    else
                    {
                        day = Integer.parseInt(str.toString());
                        str.delete(0,start);
                    }
                }
            }
            str.append(date1[start]);
        }
    }


    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        if(month>=1&&month<=12)
            this.month = month;
        else throw new IllegalArgumentException("Month is unavailable");
    }

    public void setDay(int day) {
        if(day>=1&&day<=31)
            this.day = day;
        else throw new IllegalArgumentException("Day is unavailable");
    }

    public void setYear(int year) {
        if(year<2021&&year>=1900)
            this.year = year;
        else throw new IllegalArgumentException("Day is unavailable");
    }

    @Override
    public String toString() {
        String str = "" + year  + month + "-" + day;
        return str;
    }
}
