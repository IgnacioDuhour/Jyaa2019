package controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Product;
import services.ProductService;
import services.impl.ProductServiceImpl;

/**
 * 
 * Controlador rest de productos
 *
 */
@Path("/Products")
public class ProductController {

	ProductService productService = new ProductServiceImpl();

	public ProductController() {
	}

	/**
	 * Listado de productos
	 * 
	 * @return listado de productos
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducts() {
		List<Product> products = productService.getProducts();
		return Response.ok().entity(products).build();
	}

	/**
	 * Recupera un producto a partir de un id
	 * 
	 * @param id
	 *            id del producto a recuperar
	 * @return producto recuperado
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct(@PathParam("id") long id) {
		Product product = productService.getProduct(id);
		return Response.ok().entity(product).build();
	}

	/**
	 * Crea un nuevo producto
	 * 
	 * @param product
	 *            producto a guardar
	 * @return producto guardado
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addProduct(Product product) {
		Product prod = productService.newProduct(product);
		return Response.ok().entity(prod).build();
	}

	/**
	 * Modifica los datos de un producto
	 * 
	 * @param product
	 *            producto a modificar
	 * @return producto modificado
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProduct(Product product) {
		Product prod = productService.updateProduct(product);
		return Response.ok().entity(prod).build();
	}

	/**
	 * Elimina el producto con el id recibido
	 * 
	 * @param id
	 *            id del producto a eliminar
	 * @return producto eliminado
	 */
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProduct(@PathParam("id") long id) {
		Product product = productService.deleteProduct(id);
		return Response.ok().entity(product).build();
	}

}