package com.blaj.UserManagement.config;

import com.blaj.UserManagement.UserManagementApplication;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[0];
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[]{UserManagementApplication.class};
   }

   @Override
   protected String[] getServletMappings() {
      return new String[] {"/"};
   }
}
