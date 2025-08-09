package com.wipro.annymousTest;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.function.Consumer;

public class PrintingCurrentTime {

	public static void main(String[] args) 
	{
		Consumer<ZoneId> printTime = (zone) -> {
            ZonedDateTime zdt = ZonedDateTime.now(zone);
            System.out.println(zone + "-->" + zdt);
        };

        printTime.accept(ZoneId.of("Europe/London"));
	}
}
