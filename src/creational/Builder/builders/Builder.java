package creational.Builder.builders;

import creational.Builder.cars.Type;
import creational.Builder.components.Engine;
import creational.Builder.components.GPSNavigator;
import creational.Builder.components.Transmission;
import creational.Builder.components.TripComputer;

/**
 * Интерфейс Строителя объявляет все возможные этапы и шаги конфигурации
 * продукта.
 */
public interface Builder {
    void setType(Type type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}