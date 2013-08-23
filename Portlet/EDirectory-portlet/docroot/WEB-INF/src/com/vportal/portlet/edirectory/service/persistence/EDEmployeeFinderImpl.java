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
package com.vportal.portlet.edirectory.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.vportal.portlet.edirectory.model.EDDepartment;
import com.vportal.portlet.edirectory.model.EDEmployee;
import com.vportal.portlet.edirectory.model.impl.EDEmployeeImpl;
import com.vportal.portlet.edirectory.service.EDDepartmentLocalServiceUtil;

public class EDEmployeeFinderImpl extends EDEmployeePersistenceImpl implements
		EDEmployeeFinder {

	public static String FIND_BY_PARA = EDEmployeeFinder.class.getName()
			+ ".getEmployees";
	public static String COUNT_BY_PARA = EDEmployeeFinder.class.getName()
			+ ".countEmployees";

	// Customize find employee by name, deparment, function <hailn: 21/05/2013>

	public List findEmployeeByParam(long groupId, String language, String name,
			long departmentId, long functionId, int begin, int end)
			throws SystemException {

		Session session = null;

		try {

			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_PARA);
			StringBuffer query = new StringBuffer();
			query.append(sql);
			query.append(" WHERE ");
			query.append("(EDEmployee.groupId = ?)");
			query.append("AND (EDEmployee.languageId = ?)");

			if (Validator.isNotNull(name)) {
				query.append("AND");
				query.append("(LOWER(EDEmployee.name) LIKE LOWER(?)) ");
			}

			if (Validator.isNotNull(String.valueOf(departmentId))
					&& departmentId != 0) {
				query.append("AND ");
				query.append("(EDEmployee.departmentId = ?) ");
			}

			if (Validator.isNotNull(String.valueOf(functionId))
					&& functionId != 0) {
				query.append("AND");
				query.append("(EDFunctionEmployee.functionId = ?)");
			}

			query.append("ORDER BY ");
			query.append("EDEmployee.name");

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("EDEmployee", EDEmployeeImpl.class);

			// Truyen tham so vao cau query: tinh tu 0
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);

			if (Validator.isNotNull(name) && !name.isEmpty()) {
				q.setString(queryPos++, "%" + name + "%");
			}

			if (Validator.isNotNull(String.valueOf(departmentId))
					&& departmentId != 0) {
				q.setLong(queryPos++, departmentId);
			}

			if (Validator.isNotNull(String.valueOf(functionId))
					&& functionId != 0) {
				q.setLong(queryPos++, functionId);
			}

			return QueryUtil.list(q, getDialect(), begin, end);

			// return q.list();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

	}

	/**
	 * Method search emdployee by name, departmentId, functionId
	 */
	public List findEmployeeByParam(long groupId, String language, String name,
			long departmentId, long functionId) throws SystemException {

		Session session = null;

		try {

			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_PARA);
			StringBuffer query = new StringBuffer();
			query.append(sql);
			query.append(" WHERE ");
			query.append("(EDEmployee.groupId = ?)");
			query.append("AND (EDEmployee.languageId = ?)");

			if (Validator.isNotNull(name)) {
				query.append("AND");
				query.append("(LOWER(EDEmployee.name) LIKE LOWER(?)) ");
			}

			if (Validator.isNotNull(String.valueOf(departmentId))
					&& departmentId != 0) {
				query.append("AND ");
				query.append("(EDEmployee.departmentId = ?) ");
			}

			if (Validator.isNotNull(String.valueOf(functionId))
					&& functionId != 0) {
				query.append("AND");
				query.append("(EDFunctionEmployee.functionId = ?)");
			}

			query.append("ORDER BY ");
			query.append("EDEmployee.name");

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("EDEmployee", EDEmployeeImpl.class);

			// Truyen tham so vao cau query: tinh tu 0
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);

			if (Validator.isNotNull(name) && !name.isEmpty()) {
				q.setString(queryPos++, "%" + name + "%");
			}

			if (Validator.isNotNull(String.valueOf(departmentId))
					&& departmentId != 0) {
				q.setLong(queryPos++, departmentId);
			}

			if (Validator.isNotNull(String.valueOf(functionId))
					&& functionId != 0) {
				q.setLong(queryPos++, functionId);
			}

			return q.list();

			// return q.list();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

	}

	public int countEDEmployeByParam(long groupId, String language,
			String name, long departmentId, long functionId)
			throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_PARA);
			StringBuffer query = new StringBuffer();
			query.append(sql);

			query.append(" WHERE ");
			query.append("(EDEmployee.groupId = ?)");
			query.append("AND (EDEmployee.languageId = ?)");

			if (Validator.isNotNull(name)) {
				query.append("AND");
				query.append("(LOWER(EDEmployee.name) LIKE LOWER(?)) ");
			}

			if (Validator.isNotNull(String.valueOf(departmentId))
					&& departmentId != 0) {
				query.append("AND ");
				query.append("(EDEmployee.departmentId = ?) ");
			}

			if (Validator.isNotNull(String.valueOf(functionId))
					&& functionId != 0) {
				query.append("AND");
				query.append("(EDFunctionEmployee.functionId = ?)");
			}

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.LONG);

			// Truyen tham so vao cau query: tinh tu 0
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);

			if (Validator.isNotNull(name) && !name.isEmpty()) {
				q.setString(queryPos++, "%" + name + "%");
			}

			if (Validator.isNotNull(String.valueOf(departmentId))
					&& departmentId != 0) {
				q.setLong(queryPos++, departmentId);
			}

			if (Validator.isNotNull(String.valueOf(functionId))
					&& functionId != 0) {
				q.setLong(queryPos++, functionId);
			}

			Iterator ite = q.list().iterator();
			Long count = null;
			while (ite.hasNext()) {
				count = (Long) ite.next();
			}
			if (count == null)
				count = new Long(0);
			return count.intValue();

		} catch (Exception ex) {
			throw new SystemException(ex);
		} finally {
			closeSession(session);
		}

	}

	// End 21/05/2013

	public List findEmployeeByParam(long groupId, String language,
			long departmentId, String name) throws SystemException {
		Session session = null;
		// List<EDEmployee> employeeList = new ArrayList<EDEmployee>();
		try {

			session = openSession();
			String sql = "SELECT * FROM EDEmployee";
			StringBuffer query = new StringBuffer();
			query.append(sql);

			query.append(" WHERE ");

			if (Validator.isNull(groupId)) {
				return null;
			} else {
				query.append("(EDEmployee.groupId = ?) ");
			}

			if (Validator.isNull(language)) {
				return null;
			} else {
				query.append("AND ");
				query.append("(EDEmployee.languageId = ?) ");
			}

			if (Validator.isNotNull(departmentId)
					&& !Validator.equals(departmentId, 0)) {
				query.append("AND ");
				query.append("(EDEmployee.departmentId = ?) ");
			}

			if (Validator.isNotNull(name)) {
				query.append("AND ");
				query.append("LOWER(EDEmployee.name) LIKE LOWER(?) ");
			}

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("EDEmployee", EDEmployeeImpl.class);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);

			if (Validator.isNotNull(departmentId)
					&& !Validator.equals(departmentId, 0)) {
				q.setLong(queryPos++, departmentId);
			}

			if (Validator.isNotNull(name)) {
				q.setString(queryPos++, "%" + name + "%");
			}

			// System.out.println("DepID: " + departmentId);
			// System.out.println("Name: " + name);
			// System.out.println("SQL query: " + query);

			// employeeList = q.list();
			return q.list();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

	}

	@SuppressWarnings("unchecked")
	public List<EDEmployee> findEmployeeByParam(long groupId, String language,
			long departmentId, String name, int begin, int end)
			throws SystemException {
		Session session = null;

		try {

			session = openSession();
			String sql = "SELECT * FROM EDEmployee";
			StringBuffer query = new StringBuffer();
			query.append(sql);

			query.append(" WHERE ");
			if (Validator.isNull(String.valueOf(groupId))) {
				return null;
			} else {
				query.append("(EDEmployee.groupId = ?) ");
			}
			if (Validator.isNull(language)) {
				return null;
			} else {
				query.append(" AND ");
				query.append("(EDEmployee.languageId = ?) ");
			}

			if (Validator.isNotNull(String.valueOf(departmentId))
					&& !Validator.equals(departmentId, "0")) {
				query.append(" AND");
				query.append(" (EDEmployee.departmentId = ?) ");
			}

			if (Validator.isNotNull(name)) {
				query.append(" AND");
				query.append(" LOWER(EDEmployee.name) LIKE LOWER(?) ");
			}

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("EDEmployee", EDEmployeeImpl.class);
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, language);

			if (Validator.isNotNull(String.valueOf(departmentId))
					&& !Validator.equals(departmentId, "0")) {
				q.setLong(queryPos++, departmentId);
			}

			if (Validator.isNotNull(name)) {
				q.setString(queryPos++, "%" + name + "%");
			}

			return (List<EDEmployee>) QueryUtil.list(q, getDialect(), begin,
					end);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

	}

	/**
	 * Me thod search edmployee by departmetnId, name, phone, email
	 */
	public static String FIND_BY_DEPARTMENT_NAME_PHONE_EMAIL = EDEmployeeFinder.class
			.getName() + ".getEmployeesByDepartmentNamePhoneEmail";
	public static String COUNT_BY_DEPARTMENT_NAME_PHONE_EMAIL = EDEmployeeFinder.class
			.getName() + ".countEmployeesByDepartmentNamePhoneEmail";

	public List<EDEmployee> findEmployeeByParam(long groupId, String languageId,
			long departmentId, String name, String phone, String email)
			throws SystemException {

		Session session = null;

		try {

			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_DEPARTMENT_NAME_PHONE_EMAIL);
			StringBuffer query = new StringBuffer();
			query.append(sql);
			query.append("WHERE ");
			query.append("(EDEmployee.groupId = ? )");
			query.append("AND (EDEmployee.languageId = ?)");
			
			//System.out.println("GroupId: " + groupId);
			//System.out.println("LanguageId: " + languageId);
			//System.out.println("DepId: " + departmentId);
			long parent = 0;
			if(Validator.isNotNull(departmentId) && departmentId != 0){
				EDDepartment depSelected = EDDepartmentLocalServiceUtil.getEDDepartment(departmentId);
				parent = depSelected.getParent();
			}
//			EDDepartment depSelected = EDDepartmentLocalServiceUtil.getEDDepartment(departmentId);
//			long parent = depSelected.getParent();
			//System.out.println("Parent: " + parent);
			//Neu khong co don vi con thi tim tat ca cac nhan vien trong don vi da chon
			if (parent != 0 && departmentId != 0) {
//				query.append("AND ");
//				query.append("EDEmployee.departmentId = EDDepartment.id_ ");
				query.append("AND ");
				query.append("EDEmployee.departmentId = ? ");
			}else if(departmentId != 0){
				query.append("AND ");
				query.append("EDEmployee.departmentId in ( Select id_ From EDDepartment WHERE parent = ? ) ");
			}

			if (Validator.isNotNull(name)) {
				query.append("AND");
				query.append("(LOWER(EDEmployee.name) LIKE LOWER(?)) ");
			}

			if (Validator.isNotNull(phone)) {
				query.append("AND");
				query.append("((EDEmployee.homephone LIKE ?) ");
				query.append("OR");
				query.append("(EDEmployee.workphone LIKE ?) ");
				query.append("OR");
				query.append("(EDEmployee.mobilephone LIKE ?)) ");

			}

			if (Validator.isNotNull(email)) {
				query.append("AND");
				query.append("(LOWER(EDEmployee.email) LIKE LOWER(?)) ");
			}

			query.append("ORDER BY ");
			query.append("EDEmployee.name");

			//System.out.println("Query: " + query);
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity("EDEmployee", EDEmployeeImpl.class);

			// Truyen tham so vao cau query: tinh tu 0
			int queryPos = 0;

			q.setLong(queryPos++, groupId);
			q.setString(queryPos++, languageId);

			if (Validator.isNotNull(departmentId) && departmentId != 0) {
				q.setLong(queryPos++, departmentId);
			}

			if (Validator.isNotNull(name) && !name.isEmpty()) {
				q.setString(queryPos++, "%" + name + "%");
			}

			if (Validator.isNotNull(phone) && !phone.isEmpty()) {
				q.setString(queryPos++, "%" + phone + "%");
				q.setString(queryPos++, "%" + phone + "%");
				q.setString(queryPos++, "%" + phone + "%");
			}

			if (Validator.isNotNull(email) && !email.isEmpty()) {
				q.setString(queryPos++, "%" + email + "%");
			}

			return q.list();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

	}

}
