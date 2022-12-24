package i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest {
    private LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

    @Test
    void localizationRussian() {
        String text = "Добро пожаловать";
        Assertions.assertEquals(text, localizationService.locale(Country.RUSSIA));
    }

    @Test
    void localizationUsa() {
        String text = "Welcome";
        Assertions.assertEquals(text, localizationService.locale(Country.USA));
    }
}
