package com.virtualpairprogrammers.websockets;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONObject;

import com.virtualpairprogrammers.data.MenuDao;
import com.virtualpairprogrammers.data.MenuDaoFactory;
import com.virtualpairprogrammers.domain.Order;

@ServerEndpoint("/kitchenManagement")
public class KitchenDisplayWebsocket {

	
	@OnOpen
	public void open(Session session)
	{
		KitchenDisplaySessionHandler hanlder =
				 KitchenDisplaySessionHanlderFactory.getHandler();
		hanlder.addSession(session);
	}
	
	
	
	@OnClose
	public void close(Session session)
	{
		KitchenDisplaySessionHandler hanlder =
				 KitchenDisplaySessionHanlderFactory.getHandler();
		hanlder.removeSession(session);
	}
	
	@OnError
	public void onError(Throwable error) {
		throw new RuntimeException();
	}
	
	@OnMessage
	public void handnleMessage(String message, Session session)
	{
	
		JSONObject json = new JSONObject(message);
		long id = json.getLong("id");
		String status = json.getString("status");
		
		MenuDao menuDao = MenuDaoFactory.getMenuDao();
		menuDao.updateOrderStatus(id,status);
		
		Order order = menuDao.getOrder(id);
		KitchenDisplaySessionHandler handler = KitchenDisplaySessionHanlderFactory.getHandler();
		handler.amendOrder(order);
		
		
		
		
	}
	
	
	
	
	
}
