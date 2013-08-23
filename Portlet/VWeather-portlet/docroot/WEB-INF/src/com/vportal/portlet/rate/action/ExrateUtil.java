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

package com.vportal.portlet.rate.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

//http://viralpatel.net/blogs/java-xml-xpath-tutorial-parse-xml/
public class ExrateUtil {
	
	private static String dateUpdated;
	private static String source;
	private static String [] code = new String[18] ;
	private static String [] name = new String[18] ;
	private static String [] buy = new String[18] ;
	private static String [] transfer = new String[18] ;
	private static String [] sell = new String[18] ;
	
//	public static List<Exrate> getRate(String fileURL) throws Exception {
//		JAXBContext context = JAXBContext.newInstance(ExrateList.class);
//		
//		Unmarshaller unmarshaller = context.createUnmarshaller();
//		URL url = new URL(fileURL);
//		URLConnection urlConn = url.openConnection();
//        InputStream is = urlConn.getInputStream();
//       //InputStream is = ExrateUtil.class.getResourceAsStream(fileURL);
//        ExrateList root = (ExrateList) unmarshaller.unmarshal(is);
//		dateUpdated = root.getDatetime();
//		source = root.getSource();
//		
//		System.out.println("Size: " + root.getExrates().size());
//		if(root.getExrates().get(0) != null)
//			System.out.println(" ====== NOT NULL ======== : " + root.getExrates().get(0).getCurrencyCode());
//		return root.getExrates();
//	}
	
	public static void process(String rate,int lines){
		String temp [] = rate.split("\"");
		code[lines-5] = temp[1];
		name[lines-5] = temp[3];
		buy[lines-5] = temp[5];
		transfer[lines-5] = temp[7];
		sell[lines-5] = temp[9];
	}
	
	public static void ConvertText(String fileURL) throws IOException {
		String contentString = "";
		InputStream in = null;
		try {
			URL url = new URL(fileURL);
			URLConnection urlConn = url.openConnection();

			// get the input stream
			in = urlConn.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String tmp = br.readLine();
			int lines = 1;
			do {
				//System.out.println(tmp);
				if(lines >=5 && lines < 23)
					process(tmp,lines);
				//contentString += tmp;
				tmp = br.readLine();
				lines++;
			} while (tmp != null);

		} catch (Exception ex) {

		} finally {
			in.close();
		}
		//System.out.println("Content: " + contentString);
		
	}
	
	
	
	public static String[] getCode() {
		return code;
	}

	public static String[] getName() {
		return name;
	}

	public static String[] getBuy() {
		return buy;
	}

	public static String[] getTransfer() {
		return transfer;
	}

	public static String[] getSell() {
		return sell;
	}

	public static String getDateUpdated(){
		return dateUpdated;
	}
	
	public static String getSource(){
		return source;
	}
	
}
