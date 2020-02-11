package org.easyspring.test.v4;

import org.easyspring.beans.factory.annotation.Autowired;
import org.easyspring.beans.factory.annotation.AutowiredFieldElement;
import org.easyspring.beans.factory.annotation.InjectionElement;
import org.easyspring.beans.factory.annotation.InjectionMetadata;
import org.easyspring.beans.factory.support.DefaultBeanFactory;
import org.easyspring.beans.factory.xml.XmlBeanDefinitionReader;
import org.easyspring.core.io.ClassPathResource;
import org.easyspring.core.io.Resource;
import org.easyspring.test.entity.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedList;
import static junit.framework.TestCase.*;

public class InjectionMetadataTest {

    @Test
    public void testInjection() throws NoSuchFieldException {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = new ClassPathResource("petstore-v4.xml");
        reader.loadBeanDefinition(resource);

        Person person = new Person();
        LinkedList<InjectionElement> elements = new LinkedList<InjectionElement>();

        Field field = Person.class.getDeclaredField("school");
        InjectionElement fieldElement = new AutowiredFieldElement(field, factory, new Autowired(){

            public Class<? extends Annotation> annotationType() {
                return Autowired.class;
            }

            public boolean required() {
                return true;
            }
        });
        elements.add(fieldElement);

        InjectionElement metadata = new InjectionMetadata(elements);
        metadata.inject(person);

        assertNotNull(person.getSchool());
    }
}
