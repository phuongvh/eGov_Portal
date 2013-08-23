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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
//http://www.sjc.com.vn/xml/tygiavang.xml : gia vang
//http://vietcombank.com.vn/ExchangeRates/ExrateXML.aspx
//http://www.sjc.com.vn/?job=99&id=413&n=0
//http://jcavallotti.blogspot.com/2011/05/using-jax-b-to-parse-xml-files-without.html
public class WeatherUtil {

	
	
	// this
	public static String ConvertText(String fileURL) throws IOException {
		String contentString = "";
		InputStream in = null;
		try {
			URL url = new URL(fileURL);
			URLConnection urlConn = url.openConnection();

			// get the input stream
			in = urlConn.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String tmp = br.readLine();
			do {

				contentString += tmp + "\n";
				tmp = br.readLine();

			} while (tmp != null);

		} catch (Exception ex) {

		} finally {
			in.close();
		}
		//System.out.println("Content: " + contentString);
		return contentString;
	}

	public static String ConvertWeatherText(String fileURL) throws IOException {
		String contentString = "";
		InputStream in = null;
		try {
			URL url = new URL(fileURL);

			URLConnection urlConn = url.openConnection();

			String contentType = urlConn.getContentType();
			// get the input stream
			in = urlConn.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			char[] buffer = new char[1024];

			String tmp = br.readLine();
			do {

				contentString += tmp + "\n";

				tmp = br.readLine();

			} while (tmp != null);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			in.close();
		}
		//System.out.println("Content 2: " + contentString);
		return contentString;
	}
	

	
	
}
