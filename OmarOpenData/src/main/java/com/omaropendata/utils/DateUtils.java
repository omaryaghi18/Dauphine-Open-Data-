package com.omaropendata.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Omar YAGHI.
 */

@ApplicationScoped
@Embeddable
public class DateUtils  implements Serializable{

    private static final Logger LOGGER = Logger.getLogger(DateUtils.class.getName());

    /**
     *  return date with a specific format (formatOpt)
     *  if formatOpt is null (optional) we return with a specific format : dd/MM/yyyy HH:mm
     * @param date
     * @param formatOpt
     * @return
     * @throws DateTimeException
     */
    public static String transformDate(Date date, Optional<String> formatOpt) throws DateTimeException {
        String format = formatOpt.isPresent() ? formatOpt.get() : "dd/MM/yyyy HH:mm";
        SimpleDateFormat dateFormat ;
        try{
            dateFormat  = new SimpleDateFormat(format);
        }
        catch(IllegalArgumentException illegal){
            throw illegal;
        }

        return dateFormat.format(date);
    }
}

