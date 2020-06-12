package cn.bdqn.tools;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate implements Converter<String, Date> {
    private String pattan;

    public StringToDate(String pattan) {
        this.pattan = pattan;
    }

    @Override
    public Date convert(String source) {
        SimpleDateFormat dateFormat=new SimpleDateFormat(pattan);
        try{
           return dateFormat.parse(source);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
