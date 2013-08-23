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

package com.vportal.portal.util;

import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.persistence.ImageUtil;

/**
 * @author 
 * @version 1.0.00, May 15, 2007
 */
public class ImageUtilExt extends ImageUtil {

	public static void saveOriginalImage(long largePhotoKey, byte[] photoBytes) {
		if (photoBytes != null && Validator.isNotNull(String.valueOf(largePhotoKey))) {
			try {
				ImageLocalServiceUtil.updateImage(largePhotoKey, photoBytes);
			} catch (Exception ce) {
				ce.printStackTrace();
			}
		}
	}

	public static void saveThumbnail(long thumbnailKey,
			BufferedImage bufferedImage, String contentType, int maxWidth,
			int maxHeight) {

		if (bufferedImage != null && Validator.isNotNull(String.valueOf(thumbnailKey))) {

			BufferedImage thumbnail = advancedScale(bufferedImage, maxHeight,
					maxWidth);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			try {
				if (contentType.indexOf("gif") != -1) {
		//			ImageUtil.encodeGIF(thumbnail, baos);

				} else if (contentType.indexOf("jpg") != -1
						|| contentType.indexOf("jpeg") != -1) {

					ImageIO.write(thumbnail, "jpeg", baos);

				} else if (contentType.indexOf("png") != -1) {

					ImageIO.write(thumbnail, "png", baos);

				}
				
				ImageLocalServiceUtil.updateImage(thumbnailKey, baos.toByteArray());
			} catch (Exception ex) {
				System.out.println(ex.toString());
			}
			
			
		}
	}

	public static void deleteImage(long photoKey) {
		try {
			com.liferay.portal.model.Image image = ImageLocalServiceUtil.getImage(photoKey);
			ImageLocalServiceUtil.deleteImage(image.getImageId());
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	public static boolean isImage(String contentType) {

		if (Validator.isNull(contentType)) {
			return false;
		}

		return !(contentType.indexOf("gif") == -1
				&& contentType.indexOf("jpg") == -1
				&& contentType.indexOf("jpeg") == -1 && contentType
				.indexOf("png") == -1);
	}

	public static BufferedImage advancedScale(BufferedImage src, int maxHeight,
			int maxWidth) {

		int imageHeight = src.getHeight();
		int imageWidth = src.getWidth();

		if (maxHeight == 0) {
			maxHeight = imageHeight;
		}

		if (maxWidth == 0) {
			maxWidth = imageWidth;
		}

		if ((imageHeight <= maxHeight) && (imageWidth <= maxWidth)) {
			return src;
		}

		double factor = 0.1;

		int heightDelta = imageHeight - maxHeight;
		int widthDelta = imageWidth - maxWidth;

		if (heightDelta > widthDelta) {
			factor = (double) maxHeight / imageHeight;
		} else {
			factor = (double) maxWidth / imageWidth;
		}

		RenderingHints qualityHints = new RenderingHints(
				RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		ParameterBlock paramBlock = new ParameterBlock();
		paramBlock.addSource(src);
		paramBlock.add(factor); // xscale
		paramBlock.add(factor); // yscale

		RenderedOp resizedImage = JAI.create("SubsampleAverage", paramBlock,
				qualityHints);

		return resizedImage.getAsBufferedImage();
	}
}
