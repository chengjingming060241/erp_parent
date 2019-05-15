package cn.itcast.erp.dao.impl;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import cn.itcast.erp.dao.IOrdersDao;
import cn.itcast.erp.entity.Orders;
/**
 * 订单数据访问类
 * @author Administrator
 *
 */
public class OrdersDao extends BaseDao<Orders> implements IOrdersDao {

	/**
	 * 构建查询条件
	 * @param
	 * @param
	 * @param param
	 * @return
	 */
	public DetachedCriteria getDetachedCriteria(Orders orders1,Orders orders2,Object param){
		DetachedCriteria dc=DetachedCriteria.forClass(Orders.class);
		if(orders1!=null){
			if(null != orders1.getType() && orders1.getType().trim().length()>0){
				dc.add(Restrictions.like("type", orders1.getType(), MatchMode.ANYWHERE));
			}
			if(null != orders1.getState() && orders1.getState().trim().length()>0){
				dc.add(Restrictions.like("state", orders1.getState(), MatchMode.ANYWHERE));
			}

		}
		return dc;
	}

}
