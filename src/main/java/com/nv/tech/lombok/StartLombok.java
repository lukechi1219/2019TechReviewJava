package com.nv.tech.lombok;

import com.nv.tech.lombok.dto.Pojo;

/*
https://www.baeldung.com/lombok-ide
https://www.baeldung.com/lombok-builder
https://www.baeldung.com/lombok-builder-default-value
https://www.baeldung.com/intro-to-project-lombok

https://github.com/eugenp/tutorials/tree/master/lombok
https://github.com/eugenp/tutorials/tree/master/lombok-custom
 */
public class StartLombok {

	public static void main(String[] args) {
		Pojo pojo = new Pojo();
		pojo.setMyField(12);
		System.out.println(pojo.getMyField());
	}

}
