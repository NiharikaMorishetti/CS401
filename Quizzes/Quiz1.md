##Quiz1

#### 1.Fill the blanks

The discipline devoted to the **design**, **production**, and **maintenance** of computer programs that are developed **on time** and **within cost estimates**, using tools that help to **manage the size and complexity** of the resulting software products.

#### 2.The Software Life Cycle?


1.**Problem Analysis**
2.**Requirements elicitation**
3.**High and low level design**
4.**Implementation**
5.**Testing and Verification**
6.**Delivery**
7.**Operation**
8.**Maintenance**


#### 3.Goals of Quality Software?

```
1.**It works**
2.**It can be modified without excessive time and effort**
3.**It is reusable**
4.**It is completed on time and within budget**
```

#### 4.

```
    package ch01.dates;
    public class Date
    {
        protected int year;
        protected int month;
        protected int day;
        public static final int MINYEAR = 1583;
        
        // Constructor
        public Date(int newMonth,
                        int newDay,
                        int newYear)
        {
            month = newMonth;
            day = newDay;
            year = newYear;
        }
        
        // Observers
        public int getYear()
        {
            return year;
        }
    }
```