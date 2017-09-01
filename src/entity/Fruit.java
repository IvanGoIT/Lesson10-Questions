package entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// https://stackoverflow.com/questions/5683728/convert-java-util-date-to-string
// https://github.com/alibaba/fastjson/wiki/FAQ(English-Version)

public class Fruit {
    public String name = "banana";
    @JSONField(format="MM/dd/yyyy") // аннотация для формата даты
    public Date date = new Date();
}
