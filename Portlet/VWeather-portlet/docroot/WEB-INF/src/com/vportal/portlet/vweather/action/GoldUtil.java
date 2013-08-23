/**
 * Copyright (c) Vietsoftware, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.vportal.portlet.vweather.action;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;


public class GoldUtil {

	private static City cities [] ;
	
	public static City [] getAllCity(String fileURL) throws Exception{
		
		JAXBContext context = JAXBContext.newInstance(GoldXml.class);
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
        //parse the xml file!
		//System.out.println("111111111111111111111111111111111111111111111111111111111");
		URL url = new URL(fileURL);
		URLConnection urlConn = url.openConnection();
        InputStream is = urlConn.getInputStream();
        GoldXml root = (GoldXml) unmarshaller.unmarshal(is);
        //System.out.println("222222222222222222222222222222222222222222222222222222222");
//        System.out.println(root.getTitle());
//        System.out.println(root.getUrl());
//        System.out.println("Ratelist: " + root.getRateList().size());
        RateList rate = root.getRateList().get(0);
//        System.out.println("Updated: " + rate.getUpdated());
//        System.out.println("Unit: " + rate.getUnit());
//        System.out.println("City: " + rate.getCities().size());
        
        cities = new City[rate.getCities().size()];
        for(int i=0; i<cities.length; i++)
        	cities[i] = rate.getCities().get(i);
        
        return cities;
	}
	
}
