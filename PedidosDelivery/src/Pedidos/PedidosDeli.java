package Pedidos;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;


public class PedidosDeli {
	
	static boolean estienda = false;
	static String TiendaElegida = "1";
	static String agregadorEle = "PEDIDOSYA";
	static String numeroPedidoEsp = "111111";
	static String marcaELe = "BK";

	public static void esTienda (boolean tienda)
	{
		estienda = tienda;
	}
	
	public static void tiendaElegida (String tienda)
	{
		TiendaElegida = tienda;
	}
	
	
	public static void agregadorElegido (String agregador)
	{
		agregadorEle = agregador;
	}
	
	public static void marcaElegido (String marca)
	{
		marcaELe = marca;
	}
	
	
	public static Object[][] pedidosTablaPEYA () throws Exception {
		Conexion c = new Conexion();
		Connection conn = c.conexionDeli();
		String query = "";
		
		if (!estienda) {
		 query = "select top 30 marca,proveedor, numpedido, fechaingreso, fechasolicitada, fechapos, tienda, cliente, montopedido  from pedidos where marca = '"+marcaELe+"' and proveedor = '"+agregadorEle+"' order by fechaingreso desc";
		}
		else 
		{
			 query = "select top 30 marca,  proveedor, numpedido, fechaingreso, fechasolicitada, fechapos, tienda, cliente, montopedido  from pedidos where tienda = "+TiendaElegida+" and marca = '"+marcaELe+"' and proveedor = '"+agregadorEle+"' order by fechaingreso desc";
				}
				
		PreparedStatement pst = conn.prepareStatement(query);
		System.out.println(query);
		ResultSet rs = pst.executeQuery();
		
		Object[][] data = new Object [31][9];
		
		data [0][0] = "PROVEEDOR";  
		data [0][1] = "NUMERO PEDIDO"; 
		data [0][2] = "FECHA INGRESO"; 
		data [0][3] = "FECHA SOLICITADA"; 
		data [0][4] = "FECHA POS"; 
		data [0][5] = "TIENDA"; 
		data [0][6] = "CLIENTE"; 
		data [0][7] = "MONTO"; 
		data [0][8] = "Marca"; 
		 
		
		
		int count = 1;
				while (rs.next())
				{	
					String proveedor = rs.getString("proveedor");
					String numpedido = rs.getString("numpedido");
					String fechaingreso = rs.getString("fechaingreso");
					String fechasolicitada = rs.getString("fechasolicitada");
					String fechapos = rs.getString("fechapos");
					String tienda = rs.getString("tienda");
					String cliente = rs.getString("cliente");
					String montopedido = rs.getString("montopedido");
					String marca = rs.getString("marca");
					
					data [count][0] = proveedor;
					data [count][1] = numpedido;
					data [count][2] = fechaingreso;
					data [count][3] = fechasolicitada;
					data [count][4] = fechapos;
					data [count][5] = tienda;
					data [count][6] = cliente;
					data [count][7] = montopedido;
					data [count][8] = marca;
							
					
					
					count ++;
				}
				
				System.out.println(data[0][6]);
				
				
				return data;	
		}

	public static Object[][] PedidoEspecifico (String pedido) throws Exception
	{
		
		Conexion c = new Conexion();
		Connection conn = c.conexionDeli();
		
	
		numeroPedidoEsp = pedido;
		
		String pedidoparaDetalle = "";
		
		String query = "";
		
		if (agregadorEle == "PEDIDO YA" || agregadorEle == "RAPPI" || agregadorEle == "ORDERING" ) {
		query = "SELECT * FROM Pedidos where numpedido = '"+numeroPedidoEsp+"' and proveedor = '"+agregadorEle+"'";
		}
		else 
		{
			query = "SELECT * FROM Pedidos where numpedidoprov like '%"+numeroPedidoEsp+"' and proveedor = '"+agregadorEle+"'";
		}
		
		Object[][] data = new Object [31][9];
		
		data [0][0] = "PROVEEDOR";  
		data [0][1] = "NUMERO PEDIDO"; 
		data [0][2] = "FECHA INGRESO"; 
		data [0][3] = "NUM PEDIDO PROV"; 
		data [0][4] = "FECHA POS"; 
		data [0][5] = "TIENDA"; 
		data [0][6] = "CLIENTE"; 
		data [0][7] = "MONTO"; 
		data [0][8] = "DESCUENTO";
		
		PreparedStatement pst = conn.prepareStatement(query);
		System.out.println(query);
		ResultSet rs = pst.executeQuery();
		
		while (rs.next())
		{	
			String proveedor = rs.getString("proveedor");
			
			String numpedido = rs.getString("numpedido");
			pedidoparaDetalle =  numpedido;
			String fechaingreso = rs.getString("fechaingreso");
			String numeropedidoprov = rs.getString("numpedidoprov");
			String fechapos = rs.getString("fechapos");
			String tienda = rs.getString("tienda");
			String cliente = rs.getString("cliente");
			String montopedido = rs.getString("montopedido");
			String descuentovalor = rs.getString("descuentovalor");
			
			data [1][0] = proveedor;
			data [1][1] = numpedido;
			data [1][2] = fechaingreso;
			data [1][3] = numeropedidoprov;
			data [1][4] = fechapos;
			data [1][5] = tienda;
			data [1][6] = cliente;
			data [1][7] = montopedido;
			data [1][8] =  descuentovalor;
			
			
		}
		 
		
		data [3][0] = "MARCA";  
		data [3][1] = "PROVEEDOR"; 
		data [3][2] = "NUMERO DE PEDIDO"; 
		data [3][3] = "SKU"; 
		data [3][4] = "DESCRIPCION"; 
		data [3][5] = "ORDEN"; 
		data [3][6] = ""; 
		data [3][7] = ""; 
		 if (pedidoparaDetalle.isEmpty())
		 {
			 pedidoparaDetalle = "1111111111";
		 }
		String query2 = "SELECT * FROM pedidosdetalle where numpedido = '"+pedidoparaDetalle+"' and proveedor = '"+agregadorEle+"' order by orden";
		PreparedStatement pst2 = conn.prepareStatement(query2);
		System.out.println(query2);
		ResultSet rs2 = pst2.executeQuery();
		int count = 4;
		while (rs2.next())
		{	
			
			String marca = rs2.getString("marca");
			String proveedor = rs2.getString("proveedor");
			String numpedido = rs2.getString("numpedido");
			String sku = rs2.getString("codmicros");
			String descripcion = rs2.getString("descripcion");
			String orden = rs2.getString("orden");
			
			data [count][0] = marca;
			data [count][1] = proveedor;
			data [count][2] = numpedido;
			data [count][3] = sku;
			data [count][4] = descripcion;
			data [count][5] = orden;
			data [count][6] = "";
			data [count][7] = "";
			
			count ++;
		
		}
		
		return data;	
	}
}
