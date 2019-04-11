package com.xen.cap.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xen.cap.entity.Tag;

@Repository
public class TagDaoImpl implements TagDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Tag getTagByUin(String tagID) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("select t from Tag t where t.uin = :uin");
		theQuery.setParameter("uin", tagID);

		Tag tag = (Tag) theQuery.uniqueResult();
		if (tag == null)
			return null;

		return tag;
	}

}
