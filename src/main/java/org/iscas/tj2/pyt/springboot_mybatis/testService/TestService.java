package org.iscas.tj2.pyt.springboot_mybatis.testService;

import java.io.IOException;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service
public class TestService implements ITestService {

	public TestService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String processRequest(HttpServletRequest request) {
		return "hello pyt, this is response for \"test\", springboot_mybatis is running!";
	}

}
