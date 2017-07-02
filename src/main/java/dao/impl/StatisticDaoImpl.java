package dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.StatisticDao;
import model.Book;
import model.Statistic;

public class StatisticDaoImpl 
	extends HibernateDaoSupport
	implements StatisticDao
{

	public List<Statistic> allByBook() {
		String hql = "select oi.bookid as criteria,sum(oi.amount) as number,sum(oi.orderitemPrice) as amount "
				+ "from (select id as orderid from orders where enddate!=\"null\") o "
				+ "natural join (select orderid, bookid, amount,orderitemPrice from orderitems) oi group by oi.bookid";
		SQLQuery query = getSession().createSQLQuery(hql); 
		query.addScalar("criteria",StandardBasicTypes.STRING);
		query.addScalar("number",StandardBasicTypes.INTEGER);
		query.addScalar("amount",StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(Statistic.class));  
		return query.list();
	}

	public List<Statistic> allByStartDate() {
		String hql = "select o.date as criteria,sum(oi.amount) as number,sum(oi.orderitemPrice) as amount "
				+ "from (select id as orderid, date from orders where enddate!=\"null\") o "
				+ "natural join (select orderid, bookid, amount,orderitemPrice from orderitems) oi group by o.date";
		SQLQuery query = getSession().createSQLQuery(hql); 
		query.addScalar("criteria",StandardBasicTypes.STRING);
		query.addScalar("number",StandardBasicTypes.INTEGER);
		query.addScalar("amount",StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(Statistic.class));  
		return query.list();
	}

	public List<Statistic> allByEndDate() {
		String hql = "select o.enddate as criteria,sum(oi.amount) as number,sum(oi.orderitemPrice) as amount "
				+ "from (select id as orderid, enddate from orders where enddate!=\"null\") o "
				+ "natural join (select orderid, bookid, amount,orderitemPrice from orderitems) oi group by o.enddate";
		SQLQuery query = getSession().createSQLQuery(hql); 
		query.addScalar("criteria",StandardBasicTypes.STRING);
		query.addScalar("number",StandardBasicTypes.INTEGER);
		query.addScalar("amount",StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(Statistic.class));  
		return query.list();
	}

	public List<Statistic> allByUser() {
		String hql = "select o.userid as criteria,sum(oi.amount) as number,sum(oi.orderitemPrice) as amount "
				+ "from (select id as orderid, userid from orders where enddate!=\"null\") o "
				+ "natural join (select orderid, bookid, amount,orderitemPrice from orderitems) oi group by o.userid";
		SQLQuery query = getSession().createSQLQuery(hql); 
		query.addScalar("criteria",StandardBasicTypes.STRING);
		query.addScalar("number",StandardBasicTypes.INTEGER);
		query.addScalar("amount",StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(Statistic.class));  
		return query.list();
	}

	public List<Statistic> allByCategory() {
		String hql = "select b.category as criteria,sum(oi.amount) as number,sum(oi.orderitemPrice) as amount "
				+ "from (select id as orderid from orders where enddate!=\"null\") o "
				+ "natural join (select orderid, bookid, amount,orderitemPrice from orderitems) oi natural join books b group by b.category";
		SQLQuery query = getSession().createSQLQuery(hql); 
		query.addScalar("criteria",StandardBasicTypes.STRING);
		query.addScalar("number",StandardBasicTypes.INTEGER);
		query.addScalar("amount",StandardBasicTypes.INTEGER);
		query.setResultTransformer(Transformers.aliasToBean(Statistic.class));  
		return query.list();
	}

}
