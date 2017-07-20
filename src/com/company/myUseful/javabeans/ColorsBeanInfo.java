package company.myUseful.javabeans;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Класс, который предоставляет информацию о Bean'e должен иметь имя ИмяБинаBeansInfo
 * SimpleBeanInfo - дает базовую реализацию интерфейса BeanInfo (самоанализ), поэтому от него удобно наследоваться и переопределить отдельные методы
 */
public class ColorsBeanInfo extends SimpleBeanInfo {
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor rectangular =
                    new PropertyDescriptor("rectangular", Colors.class);
            PropertyDescriptor pd[] = {rectangular};
            return pd;
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
