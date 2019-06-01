package creational.AbstractFactory.factories;
/**
 * Каждая конкретная фабрика знает и создаёт только продукты своей вариации.
 */


import creational.AbstractFactory.buttons.Button;
import creational.AbstractFactory.buttons.MacOSButton;
import creational.AbstractFactory.checkboxes.Checkbox;
import creational.AbstractFactory.checkboxes.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}