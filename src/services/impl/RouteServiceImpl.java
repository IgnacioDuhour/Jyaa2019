package services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.MessageDao;
import dao.RouteDao;
import dao.RouteDonationDao;
import factories.FactoryDaos;
import model.Message;
import model.Route;
import model.RouteDonation;
import services.RouteService;

public class RouteServiceImpl implements RouteService {

	EntityManager em;

	RouteDao routeDao = FactoryDaos.getRouteDao();
	RouteDonationDao routeDonationDao = FactoryDaos.getRouteDonationDao();
	MessageDao messageDao = FactoryDaos.getMessageDao();
	private List<Route> routes;

	public RouteServiceImpl() {
	}

	@Override
	public List<Route> getRoutes() {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		routeDao.setEntityManager(em);
		routes = routeDao.getRoutes();
		em.close();
		return routes;
	}

	@Override
	public List<RouteDonation> getRouteDonations(long id) {
		List<RouteDonation> donations;
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		routeDonationDao.setEntityManager(em);
		donations = routeDonationDao.getRouteDonations(id);
		em.close();
		return donations;
	}

	@Override
	public List<Message> getRouteMessages(long id) {
		List<Message> messages;
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		messageDao.setEntityManager(em);
		messages = messageDao.getAllMessages(id);
		em.close();
		return messages;
	}

	@Override
	public Route getRoute(long id) {
		Route route;
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		routeDao.setEntityManager(em);
		route = routeDao.findById(id);
		em.close();
		return route;
	}

	@Override
	public Route addMessage(long id, Message message) {
		Route route;
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		routeDao.setEntityManager(em);
		messageDao.setEntityManager(em);
		EntityTransaction et = em.getTransaction();
		et.begin();
		route = routeDao.findById(id);
		messageDao.save(message);
		route.addMessage(message);
		routeDao.update(route);
		et.commit();
		em.close();
		return route;
	}

	@Override
	public Route newRoute(Route route) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		routeDao.setEntityManager(em);
		routeDonationDao.setEntityManager(em);
		EntityTransaction et = em.getTransaction();
		et.begin();
		List<RouteDonation> donations = route.getDonations();
		for (RouteDonation routeDonation : donations) {
			routeDonationDao.save(routeDonation);
		}
		routeDao.save(route);
		et.commit();
		em.close();
		return route;
	}

	@Override
	public Route updateRoute(Route route) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		routeDao.setEntityManager(em);
		EntityTransaction et = em.getTransaction();
		et.begin();
		routeDao.update(route);
		et.commit();
		em.close();
		return route;
	}

	@Override
	public Route deleteRoute(long id) {
		em = FactoryDaos.getEntityManagerFactory().createEntityManager();
		routeDao.setEntityManager(em);
		EntityTransaction et = em.getTransaction();
		et.begin();
		Route route = routeDao.findById(id);
		route.setDeleted(true);
		routeDao.update(route);
		et.commit();
		em.close();
		return route;
	}

}
