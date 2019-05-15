package cn.itcast.erp.action;
import cn.itcast.erp.biz.IOrdersBiz;
import cn.itcast.erp.entity.Emp;
import cn.itcast.erp.entity.Orderdetail;
import cn.itcast.erp.entity.Orders;
import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * 订单Action 
 * @author Administrator
 *
 */
public class OrdersAction extends BaseAction<Orders> {

	private IOrdersBiz ordersBiz;

	public void setOrdersBiz(IOrdersBiz ordersBiz) {
		this.ordersBiz = ordersBiz;
		super.setBaseBiz(this.ordersBiz);
	}

	public IOrdersBiz getOrdersBiz() {
		return ordersBiz;
	}

	//接受订单明细的json格式的字符串，数组形式的json字符串，里面的元素应该是每个订单明细
	private String json;

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	//添加
	public void add(){
		Emp emp = getLoginUser();
		if (null == emp){
			ajaxReturn(false,"亲，请重新登录！");
			return;
		}
		try {
			//获取订单明细
			Orders orders = getT();
			//设置订单创建者
			orders.setCreater(getLoginUser().getUuid());
			List<Orderdetail> orderdetails = JSON.parseArray(json, Orderdetail.class);
			//添加订单明细
			orders.setOrderDetails(orderdetails);
			ordersBiz.add(orders);
			ajaxReturn(true,"创建订单成功");
		}catch (Exception e){
			e.printStackTrace();
			ajaxReturn(false,"创建订单失败");
		}
	}
}
