package sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTest {
    private GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
    private LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);

    @Test
    void messageSenderRussian() {
        Mockito.when(geoService.byIp(GeoServiceImpl.MOSCOW_IP)).thenReturn(new Location("Новосибирск", Country.RUSSIA, "Новосибирская", 10));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> map = new HashMap<String, String>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.MOSCOW_IP);
        String text = "Добро пожаловать";
        String message = messageSender.send(map);
        Assertions.assertEquals(text, message);
    }

    @Test
    void messageSenderUsa() {
        Mockito.when(geoService.byIp(GeoServiceImpl.NEW_YORK_IP)).thenReturn(new Location("New York", Country.USA, "Washington Street", 100));
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> map = new HashMap<String, String>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.NEW_YORK_IP);
        String text = "Welcome";
        String message = messageSender.send(map);
        Assertions.assertEquals(text, message);
    }
}
