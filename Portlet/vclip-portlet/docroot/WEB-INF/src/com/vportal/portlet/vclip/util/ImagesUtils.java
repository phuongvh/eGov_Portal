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
package com.vportal.portlet.vclip.util;

/**
 * @author Administrator
 * @version 1.0.00, Mar 22, 2006
 */
public class ImagesUtils {

	// public static void deleteImage(String photoId) {
	// try {
	// ImageLocalServiceUtil.deleteImage(photoId);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// public static void saveOriginalImages(String largePhotoKey, byte[]
	// photoBytes) {
	//
	// if (photoBytes != null && Validator.isNotNull(largePhotoKey)) {
	// // Save Fullsize Image
	// ImageLocalUtil.put(largePhotoKey, photoBytes);
	// }
	// }
	//
	// public static boolean checkIsImage(String contentType) {
	//
	// if (Validator.isNull(contentType)) { return false; }
	//
	// if (contentType.indexOf("gif") == -1 && contentType.indexOf("jpg") == -1
	// && contentType.indexOf("jpeg") == -1
	// && contentType.indexOf("png") == -1) {
	// {
	// return false;
	// }
	// }
	// return true;
	// }
	//
	// public static void saveThumbImages(String thumbnailKey, BufferedImage
	// bufferedImage, String contentType,
	// int maxWidth, int maxHeight) {
	//
	// if (bufferedImage != null && Validator.isNotNull(thumbnailKey)) {
	//
	// // Create thumbnail
	// BufferedImage thumbnail = ImageUtil.scale(bufferedImage, maxHeight,
	// maxWidth);
	//
	// ByteArrayOutputStream baos = new ByteArrayOutputStream();
	//
	// try {
	// if (contentType.indexOf("gif") != -1) {
	// ImageUtil.encodeGIF(thumbnail, baos);
	// } else if (contentType.indexOf("jpg") != -1 ||
	// contentType.indexOf("jpeg") != -1) {
	// ImageIO.write(thumbnail, "jpeg", baos);
	// } else if (contentType.indexOf("png") != -1) {
	// ImageIO.write(thumbnail, "png", baos);
	// }
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// // Save thumbnail
	// ImageLocalUtil.put(thumbnailKey, baos.toByteArray());
	//
	// }
	//
	// }
	// public static String getRandPrefix() {
	//
	// Calendar c = Calendar.getInstance();
	//
	// String curTime = String.valueOf(c.getTimeInMillis());
	//
	// if (Validator.isNotNull(curTime) && curTime.length() > 23) {
	// curTime = curTime.substring(10, 23);
	// }
	//
	// return curTime;
	// }
}
