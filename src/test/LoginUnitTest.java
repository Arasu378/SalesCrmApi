package test;

import static org.junit.Assert.assertEquals;
import model.LoginModel;

import org.junit.Test;

import response.ConnectionsResponse;
import response.LoginResponse;
import consumeclass.GetConnectionsByConnectionIdClass;
import consumeclass.LoginClass;

public class LoginUnitTest {
	@Test
	public void login(){
		LoginModel model=new LoginModel();
		model.setUserEmail("herculesthelegend@gmail.com");
		model.setPassword("12");
		LoginResponse response=LoginClass.login(model);
		String mess=response.getMessage();
		System.out.println("message: "+mess);
		assertEquals("login",response.getIsSuccess(),false);

		
	}
}
