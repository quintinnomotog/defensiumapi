package br.com.quintinno.defensiumapi.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtility {

    public static final String DATA_FORMATO_DDMMAAAAHHMMSS = "dd/MM/yyyy HH:mm:ss";
    public static final String DATA_FORMATO_DDMMAAAA = "dd/MM/yyyy";

    private DateUtility() {
        throw new UnsupportedOperationException("Essa classe não permite instâncias!");
    }

    public static String getDataHoraFormatada(LocalDateTime localDateTime, String format) {
        return localDateTime.format(DateTimeFormatter.ofPattern(format));
    }

    public static LocalDateTime getDataHora() {
        return LocalDateTime.now();
    }

}
