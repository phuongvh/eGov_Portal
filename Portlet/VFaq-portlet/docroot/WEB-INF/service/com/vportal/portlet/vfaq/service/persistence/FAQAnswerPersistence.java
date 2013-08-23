/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.vportal.portlet.vfaq.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.vportal.portlet.vfaq.model.FAQAnswer;

/**
 * The persistence interface for the f a q answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucNN
 * @see FAQAnswerPersistenceImpl
 * @see FAQAnswerUtil
 * @generated
 */
public interface FAQAnswerPersistence extends BasePersistence<FAQAnswer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FAQAnswerUtil} to access the f a q answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the f a q answer in the entity cache if it is enabled.
	*
	* @param faqAnswer the f a q answer
	*/
	public void cacheResult(com.vportal.portlet.vfaq.model.FAQAnswer faqAnswer);

	/**
	* Caches the f a q answers in the entity cache if it is enabled.
	*
	* @param faqAnswers the f a q answers
	*/
	public void cacheResult(
		java.util.List<com.vportal.portlet.vfaq.model.FAQAnswer> faqAnswers);

	/**
	* Creates a new f a q answer with the primary key. Does not add the f a q answer to the database.
	*
	* @param id the primary key for the new f a q answer
	* @return the new f a q answer
	*/
	public com.vportal.portlet.vfaq.model.FAQAnswer create(long id);

	/**
	* Removes the f a q answer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the f a q answer
	* @return the f a q answer that was removed
	* @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a f a q answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQAnswer remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vfaq.NoSuchFAQAnswerException;

	public com.vportal.portlet.vfaq.model.FAQAnswer updateImpl(
		com.vportal.portlet.vfaq.model.FAQAnswer faqAnswer, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the f a q answer with the primary key or throws a {@link com.vportal.portlet.vfaq.NoSuchFAQAnswerException} if it could not be found.
	*
	* @param id the primary key of the f a q answer
	* @return the f a q answer
	* @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a f a q answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQAnswer findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vfaq.NoSuchFAQAnswerException;

	/**
	* Returns the f a q answer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the f a q answer
	* @return the f a q answer, or <code>null</code> if a f a q answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQAnswer fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the f a q answers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vfaq.model.FAQAnswer> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the f a q answers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of f a q answers
	* @param end the upper bound of the range of f a q answers (not inclusive)
	* @return the range of matching f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vfaq.model.FAQAnswer> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the f a q answers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of f a q answers
	* @param end the upper bound of the range of f a q answers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vfaq.model.FAQAnswer> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first f a q answer in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching f a q answer
	* @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a matching f a q answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQAnswer findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vfaq.NoSuchFAQAnswerException;

	/**
	* Returns the last f a q answer in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching f a q answer
	* @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a matching f a q answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQAnswer findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vfaq.NoSuchFAQAnswerException;

	/**
	* Returns the f a q answers before and after the current f a q answer in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current f a q answer
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next f a q answer
	* @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a f a q answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQAnswer[] findByUuid_PrevAndNext(
		long id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vfaq.NoSuchFAQAnswerException;

	/**
	* Returns all the f a q answers where language = &#63;.
	*
	* @param language the language
	* @return the matching f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vfaq.model.FAQAnswer> findByLanguage(
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the f a q answers where language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param language the language
	* @param start the lower bound of the range of f a q answers
	* @param end the upper bound of the range of f a q answers (not inclusive)
	* @return the range of matching f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vfaq.model.FAQAnswer> findByLanguage(
		java.lang.String language, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the f a q answers where language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param language the language
	* @param start the lower bound of the range of f a q answers
	* @param end the upper bound of the range of f a q answers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vfaq.model.FAQAnswer> findByLanguage(
		java.lang.String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first f a q answer in the ordered set where language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching f a q answer
	* @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a matching f a q answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQAnswer findByLanguage_First(
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vfaq.NoSuchFAQAnswerException;

	/**
	* Returns the last f a q answer in the ordered set where language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching f a q answer
	* @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a matching f a q answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQAnswer findByLanguage_Last(
		java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vfaq.NoSuchFAQAnswerException;

	/**
	* Returns the f a q answers before and after the current f a q answer in the ordered set where language = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current f a q answer
	* @param language the language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next f a q answer
	* @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a f a q answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQAnswer[] findByLanguage_PrevAndNext(
		long id, java.lang.String language,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vfaq.NoSuchFAQAnswerException;

	/**
	* Returns all the f a q answers where approved = &#63;.
	*
	* @param approved the approved
	* @return the matching f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vfaq.model.FAQAnswer> findByApproved(
		boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the f a q answers where approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param approved the approved
	* @param start the lower bound of the range of f a q answers
	* @param end the upper bound of the range of f a q answers (not inclusive)
	* @return the range of matching f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vfaq.model.FAQAnswer> findByApproved(
		boolean approved, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the f a q answers where approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param approved the approved
	* @param start the lower bound of the range of f a q answers
	* @param end the upper bound of the range of f a q answers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vfaq.model.FAQAnswer> findByApproved(
		boolean approved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first f a q answer in the ordered set where approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching f a q answer
	* @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a matching f a q answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQAnswer findByApproved_First(
		boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vfaq.NoSuchFAQAnswerException;

	/**
	* Returns the last f a q answer in the ordered set where approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching f a q answer
	* @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a matching f a q answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQAnswer findByApproved_Last(
		boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vfaq.NoSuchFAQAnswerException;

	/**
	* Returns the f a q answers before and after the current f a q answer in the ordered set where approved = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current f a q answer
	* @param approved the approved
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next f a q answer
	* @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a f a q answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQAnswer[] findByApproved_PrevAndNext(
		long id, boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vfaq.NoSuchFAQAnswerException;

	/**
	* Returns all the f a q answers where questionid = &#63;.
	*
	* @param questionid the questionid
	* @return the matching f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vfaq.model.FAQAnswer> findByQuestionId(
		long questionid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the f a q answers where questionid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param questionid the questionid
	* @param start the lower bound of the range of f a q answers
	* @param end the upper bound of the range of f a q answers (not inclusive)
	* @return the range of matching f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vfaq.model.FAQAnswer> findByQuestionId(
		long questionid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the f a q answers where questionid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param questionid the questionid
	* @param start the lower bound of the range of f a q answers
	* @param end the upper bound of the range of f a q answers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vfaq.model.FAQAnswer> findByQuestionId(
		long questionid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first f a q answer in the ordered set where questionid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param questionid the questionid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching f a q answer
	* @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a matching f a q answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQAnswer findByQuestionId_First(
		long questionid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vfaq.NoSuchFAQAnswerException;

	/**
	* Returns the last f a q answer in the ordered set where questionid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param questionid the questionid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching f a q answer
	* @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a matching f a q answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQAnswer findByQuestionId_Last(
		long questionid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vfaq.NoSuchFAQAnswerException;

	/**
	* Returns the f a q answers before and after the current f a q answer in the ordered set where questionid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current f a q answer
	* @param questionid the questionid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next f a q answer
	* @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a f a q answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQAnswer[] findByQuestionId_PrevAndNext(
		long id, long questionid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vfaq.NoSuchFAQAnswerException;

	/**
	* Returns all the f a q answers.
	*
	* @return the f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vfaq.model.FAQAnswer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the f a q answers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of f a q answers
	* @param end the upper bound of the range of f a q answers (not inclusive)
	* @return the range of f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vfaq.model.FAQAnswer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the f a q answers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of f a q answers
	* @param end the upper bound of the range of f a q answers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vfaq.model.FAQAnswer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the f a q answers where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the f a q answers where language = &#63; from the database.
	*
	* @param language the language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLanguage(java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the f a q answers where approved = &#63; from the database.
	*
	* @param approved the approved
	* @throws SystemException if a system exception occurred
	*/
	public void removeByApproved(boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the f a q answers where questionid = &#63; from the database.
	*
	* @param questionid the questionid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByQuestionId(long questionid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the f a q answers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of f a q answers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of f a q answers where language = &#63;.
	*
	* @param language the language
	* @return the number of matching f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public int countByLanguage(java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of f a q answers where approved = &#63;.
	*
	* @param approved the approved
	* @return the number of matching f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public int countByApproved(boolean approved)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of f a q answers where questionid = &#63;.
	*
	* @param questionid the questionid
	* @return the number of matching f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public int countByQuestionId(long questionid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of f a q answers.
	*
	* @return the number of f a q answers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}