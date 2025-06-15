package br.com.quintinno.defensiumapi.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtility {

    public static final String DATA_FORMATO_DDMMAAAAHHMMSS = "dd/MM/yyyy HH:mm:ss";

    public static String getDataHoraFormatada(LocalDateTime localDateTime, String format) {
        return localDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }

}
