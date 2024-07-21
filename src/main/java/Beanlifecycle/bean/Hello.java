package Beanlifecycle.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Hello implements InitializingBean, DisposableBean {

//	public void init()
//	{
//		System.out.println("inside Hello init method");
//	}
//	
//	public void destroy()
//	{
//		System.out.println("inside Hello destroy method");
//	}

	public void sample()
	{
		System.out.println("inside Hello sample method");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("inside afterPropertiesSet init method");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("inside DisposableBean destroy method");
	}

}
