package com.sivalabs.buzz;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main
{

	public static void main(String[] args)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("siva:"+encoder.encode("siva"));
		System.out.println("admin:"+encoder.encode("admin"));
		
	}

}
