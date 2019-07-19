package com.atcong.Util;

public enum  enumPlaneStation {
    hgh("杭州"),dlc("大连"),bjs("北京");

    private final String sName;
    enumPlaneStation(String s) {
        this.sName = s;
    }

    public String getsName() {
        return sName;
    }

    public static String  getStationName(String routeName){
        String[] strings = routeName.split("-");
        for(enumPlaneStation e : enumPlaneStation.values()){
            if(strings[0].equals(e.getsName())){
                strings[0] = e.name();
            }
            if(strings[1].equals(e.getsName())){
                strings[1] = e.name();
            }
        }
        return strings[0] + "-" + strings[1];
    }
}
