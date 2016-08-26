package org.jnaalisv.bookstore.web.config;

import org.jnaalisv.bookstore.infrastructure.config.PersistenceConfiguration;
import org.jnaalisv.bookstore.model.config.DomainConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {DomainConfiguration.class, PersistenceConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected String getServletName() {
        return "BookStoreServlet";
    }
}

