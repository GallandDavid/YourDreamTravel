package frubordeaux.domain.value_object;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date {
    @SerializedName("date")
    public LocalDateTime date;

    public Date(LocalDateTime date){
        this.date = date;
    }

    public String dateFormat(){
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return date.format(myFormatObj);
    }
}
