package org.iscas.tj2.pyt.springboot_mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.iscas.tj2.pyt.springboot_mybatis.service.CoreServiceImplJHSBC;
import org.iscas.tj2.pyt.springboot_mybatis.util.MessageUtil;

public class testCoreService {

	
	public testCoreService() {
		// TODO Auto-generated constructor stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 CoreServiceImplJHSBC service = new CoreServiceImplJHSBC();
		 
		while(true){
			System.out.println("Please Input your order:");
			byte[] buffer = null;
			try {
				int num = System.in.read(buffer);
				String input = buffer.toString();
				
				if("quit" == input) {
					System.out.println("Bye.");
					break;
				}else
				{
		/*			HttpServletRequest request = new HttpServletRequest();
					request.getServletContext().addFilter("FromUserName", "mabel");
					request.getServletContext().addFilter("ToUserName", "pyt");
					request.getServletContext().addFilter("MsgType", MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					request.getServletContext().addFilter("Content", "help");
					System.out.println(service.processRequest(request));
	*/			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		

		}

	}

}
