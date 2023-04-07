class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
       String[] login = loginTime.split(":");
       String[] logout = logoutTime.split(":");

       int timeStart = Integer.parseInt(login[0])*60+ Integer.parseInt(login[1]);
       int timeEnd = Integer.parseInt(logout[0])*60+ Integer.parseInt(logout[1]);

       if (timeEnd< timeStart) timeEnd+=24*60;

       if (timeStart%15!=0) timeStart+=(15-timeStart%15);

       return (timeEnd-timeStart)/15;
    }
    // 09:31 should be converted to 9:45 but we have already added 1 minute from 31 so we add (15-timeStart%15)
}


