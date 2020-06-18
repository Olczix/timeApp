package com.ola.timeApp;

// This class represents a JSON Object created basing on Http response.
public class JsonObject {

    private String abbreviation;
    private String client_ip;
    private String datetime;
    private int day_of_week;
    private int day_of_year;
    private boolean dst;
    private String dst_from;
    private  int dst_offset;
    private String dst_until;
    private int raw_offset;
    private String timezone;
    private int unixtime;
    private String utc_datetime;
    private String utc_offset;
    private int week_number;

    JsonObject (String abbreviation, String client_ip, String datetime, int day_of_week, int day_of_year, boolean dst, String dst_from, int dst_offset, String dst_until, int raw_offset, String timezone, int unixtime, String utc_datetime, String utc_offset, int week_number) {
        this.abbreviation = abbreviation;
        this.client_ip = client_ip;
        this.datetime = datetime;
        this.day_of_week = day_of_week;
        this.day_of_year = day_of_year;
        this.dst = dst;
        this.dst_from = dst_from;
        this.dst_offset = dst_offset;
        this.dst_until = dst_until;
        this.raw_offset = raw_offset;
        this.timezone = timezone;
        this.unixtime = unixtime;
        this.utc_datetime = utc_datetime;
        this.utc_offset = utc_offset;
        this.week_number = week_number;
    }

    public String getDatetime() { return datetime; }
    public String getTimezone() { return timezone; }

}
