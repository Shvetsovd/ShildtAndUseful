package company.useful.javabeans;

import java.beans.*;

/**
 * Created by OPER on 11.07.2017.
 */
public class IntrospectorDemo {
    public static void main(String[] args) {

        try {
            //Получить class
            Class<?> c = Class.forName("company.useful.javabeans.Colors");

            //получить beanInfo класса
            BeanInfo beanInfo = Introspector.getBeanInfo(c);

            //вывести в консоль все свойства и события по BeanInfo
            //Свойства
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            System.out.println("Доступные свойства: ");
            for (PropertyDescriptor pd : propertyDescriptors) {
                System.out.println(pd.getName());
            }

            //События
            System.out.println("\nСобытия: ");
            EventSetDescriptor[] events = beanInfo.getEventSetDescriptors();
            for (EventSetDescriptor e : events) {
                System.out.println(e.getName());
            }
        } catch (ClassNotFoundException | IntrospectionException e) {
            e.printStackTrace();
        }


    }
}
