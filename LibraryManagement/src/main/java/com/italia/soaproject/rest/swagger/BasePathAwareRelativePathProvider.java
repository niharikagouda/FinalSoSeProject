package com.italia.soaproject.rest.swagger;

import springfox.documentation.spring.web.paths.AbstractPathProvider;

public class BasePathAwareRelativePathProvider extends AbstractPathProvider {
	
	private String basePath ="/LibraryManagement";
	
    public BasePathAwareRelativePathProvider() {
    }
    
    @Override
    protected String applicationPath() {
        return basePath;
    }
    
    @Override
    protected String getDocumentationPath() {
        return "/";
    }
   

}
