package com.uceventtracker.eventtracker.dao;
import ch.qos.logback.core.joran.util.beans.BeanDescriptionFactory;
import retrofit2.Retrofit;
import javax.xml.*;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    private static String BASE_URL = "https://campuslink.uc.edu/events.rss";

    public static Retrofit getRetrofitInstance(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(JaxbConverterFactory())
                    .build();
        }
        return retrofit;
    }
}
