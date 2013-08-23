package com.vportal.portlet.vcontact.util;

import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;

import com.liferay.portal.kernel.util.Validator;
import com.vportal.portlet.vcontact.model.VContact;

public class VContactUtil {
	public static String dateParser(Date date) {
		if (date == null) {
			return "";
		}
		Calendar cal = Calendar.getInstance();
		String dateStr = "";
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		dateStr = day + "/" + month + "/" + year;
		return dateStr;
	}

	/**
	 * Ham chuyen 1 xau sang ngay thang
	 * 
	 * @param date
	 *            Xau chua ngay thang, co dang: dd/MM/yyyy
	 * @return Doi tuong ngay thang
	 */
	public static Date dateParser(String date) {
		try {
			SimpleDateFormat result = new SimpleDateFormat("dd/MM/yyyy");
			Date newDate = result.parse(date);
			return newDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List sortByName(List employees) {
		VContact temp = null;
		VContact tempA = null;
		VContact tempB = null;

		Vector vctA = null;
		Vector vctB = null;

		for (int i = 0; i < employees.size() - 1; i++) {
			for (int j = i + 1; j < employees.size(); j++) {

				tempA = (VContact) employees.get(i);
				tempB = (VContact) employees.get(j);

				vctA = splitName(tempA.getGuestName());
				vctB = splitName(tempB.getGuestName());

				int compare = compareName(vctA, vctB);

				if (compare > 0) {
					temp = tempA;
					employees.set(i, tempB);
					employees.set(j, temp);
				}
			}
		}
		return employees;
	}

	private static int compareName(Vector source, Vector target) {
		Collator collator = Collator.getInstance(new Locale("vi", "VN"));
		int totalS = source.size() - 1;
		int totalT = target.size() - 1;
		String nameS = "";
		String nameT = "";
		int compare = 0;
		for (int s = totalS, t = totalT; (s > -1) && (t > -1); s--, t--) {
			nameS = (String) source.get(s);
			nameT = (String) target.get(t);
			compare = collator.compare(nameS, nameT);
			// compare = nameS.compareTo(nameT);
			if (compare > 0) {
				return 1;
			} else if (compare < 0) {
				return -1;
			} else {
				continue;
			}
		}
		if (totalS > totalT) {
			return 1;
		} else if (totalS < totalT) {
			return -1;
		} else {
			return 0;
		}
	}

	private static Vector splitName(String name) {
		if (Validator.isNull(name) || name.equals("")) {
			return null;
		}

		StringTokenizer st = new StringTokenizer(name, " ");
		Vector vctTemp = new Vector();
		while (st.hasMoreTokens()) {
			vctTemp.add(st.nextToken());
		}
		return vctTemp;
	}

	

	/**
	 * ham tim kiem group trong 1 tree dua theo group_id
	 * 
	 * @param tree
	 *            cay K-phan
	 * @param groupId
	 *            group_id cua group can tim
	 * @return tra ve group neu tim thay va tra ve null neu khong tim thay
	 */
	private static VContact findByGroupId(List tree, long groupId) {
		for (int i = 0; i < tree.size(); i++) {
			VContact node = (VContact) tree.get(i);
			if (node.getId() == groupId) {
				return node;
			}
		}
		return null;
	}

	/**
	 * Dinh dang hien thi giua parent-child. Cac group la child se thut vao so
	 * voi group la cha 1 don vi bang " - "
	 * 
	 * @param tree
	 *            danh sach group cha va con, da sap xep thu tu
	 * @return tra ve 1 danh sach da duoc dinh dang
	 */
	
	/**
	 * @reference com.vportal.portlet.newsadmin.utils.NewsUtils
	 * @return
	 */
	public static String getRandPrefix() {

		Calendar c = Calendar.getInstance();

		String curTime = String.valueOf(c.getTimeInMillis());

		if (Validator.isNotNull(curTime) && curTime.length() > 23) {
			curTime = curTime.substring(10, 23);
		}

		return curTime;
	}

	/**
	 * @reference com.vportal.portlet.newsadmin.utils.ImagesUtils
	 * @param contentType
	 * @return
	 */
	public static boolean checkIsImage(String contentType) {

		if (Validator.isNull(contentType)) {
			return false;
		}

		if (contentType.indexOf("gif") == -1
				&& contentType.indexOf("jpg") == -1
				&& contentType.indexOf("jpeg") == -1
				&& contentType.indexOf("png") == -1) {
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * @reference com.vportal.portlet.newsadmin.utils.ImagesUtils
	 * @param largePhotoKey
	 * @param photoBytes
	 */
	public static void saveOriginalImages(String largePhotoKey,
			byte[] photoBytes) {

		if (photoBytes != null && Validator.isNotNull(largePhotoKey)) {
			// Save Fullsize Image
			// ImageLocalUtil.put(largePhotoKey, photoBytes);
		}
	}
}
