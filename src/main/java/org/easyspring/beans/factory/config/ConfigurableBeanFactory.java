package org.easyspring.beans.factory.config;

import org.easyspring.beans.factory.BeanFactory;

public interface ConfigurableBeanFactory extends BeanFactory {
    void setClassLoader(ClassLoader classLoader);
    ClassLoader getClassLoader();
}