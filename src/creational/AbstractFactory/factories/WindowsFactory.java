package creational.AbstractFactory.factories;

/**
 * Каждая конкретная фабрика знает и создаёт только продукты своей вариации.
 */

import creational.AbstractFactory.buttons.Button;
import creational.AbstractFactory.buttons.WindowsButton;
import creational.AbstractFactory.checkboxes.Checkbox;
import creational.AbstractFactory.checkboxes.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}