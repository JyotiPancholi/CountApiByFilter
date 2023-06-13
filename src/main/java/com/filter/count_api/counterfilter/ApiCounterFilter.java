package com.filter.count_api.counterfilter;

import java.io.IOException;
import java.nio.file.attribute.FileAttribute;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.filter.count_api.entity.ApiCounterEntity;
import com.filter.count_api.repository.ApiCounterRepository;

@Component
public class ApiCounterFilter implements Filter {

	@Autowired
	private ApiCounterRepository repo;

	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
	{
        HttpServletRequest httpRequest = (HttpServletRequest) request;
       
        	ApiCounterEntity counterEntity =  repo.findByApiName(httpRequest.getRequestURI());
        	if(counterEntity!=null) {
	            counterEntity.setCount(counterEntity.getCount() + 1);
        	}else {
        		counterEntity=new ApiCounterEntity();
        		counterEntity.setApiName(httpRequest.getRequestURI());
        		counterEntity.setCount(1);
        	}
        	repo.save(counterEntity);
      
        chain.doFilter(request, response);
    }

}
