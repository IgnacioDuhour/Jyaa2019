package services;

import java.util.List;

import model.Message;
import model.Route;
import model.RouteDonation;

public interface RouteService {

	public List<Route> getRoutes();

	public List<RouteDonation> getRouteDonations(long id);

	public List<Message> getRouteMessages(long id);

	public Route getRoute(long id);

	public Route addMessage(long id, Message message);

	public Route newRoute(Route route);

	public Route updateRoute(Route route);

	public Route deleteRoute(long id);

}
