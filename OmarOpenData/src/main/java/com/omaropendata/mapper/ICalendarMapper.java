package com.omaropendata.mapper;


import java.util.Date;

import biweekly.ICalendar;
import biweekly.component.VEvent; 

import com.omaropendata.entity.Lecture;
import com.omaropendata.entity.Planning;


import javax.enterprise.context.ApplicationScoped;

/**
 * A mapper class used to convert Planning entities to ICalendar entities  
 */
@ApplicationScoped
public class ICalendarMapper {

	public ICalendarMapper() {
	}
	
	/**
	 * Convert a planning entity into an ICalendar entity
	 * @param planning the planning entity to encode, cannot be null
	 * @return the planning encoded as a ICalendar entity
	 */
	public ICalendar encodePlanningToICalendar(Planning planning) {
		
		ICalendar ical = new ICalendar();

		planning.getLectures().forEach((lecture) -> {
			ical.addEvent(this.transformLectureToEvent(lecture));
		});
		
		return ical;
	}

	/**
	 * Convert a lecture entity into an event object
	 * @param lecture the lecture entity to encode, cannot be null
	 * @return the lecture encoded as an Event entity
	 */
	public VEvent transformLectureToEvent(Lecture lecture) {
		VEvent event = new VEvent();
		Date start = lecture.getDate();
		event.setDateStart(start);
		event.setLocation(lecture.getRoom());
		event.setDescription(lecture.getCourse().getDescription());
		return event;
	}
	
}

