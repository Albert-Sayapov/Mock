package geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceTest {
    private GeoServiceImpl geoService = new GeoServiceImpl();

    @Test
    void geoServiceTestRussian() {

        Country country = Country.RUSSIA;
        Country ipCountry = geoService.byIp(GeoServiceImpl.MOSCOW_IP).getCountry();
        Assertions.assertEquals(country, ipCountry);
    }

    @Test
    void geoServiceTestUsa() {
        Country country = Country.USA;
        Country ipCountry = geoService.byIp(GeoServiceImpl.NEW_YORK_IP).getCountry();
        Assertions.assertEquals(country, ipCountry);
    }
}
