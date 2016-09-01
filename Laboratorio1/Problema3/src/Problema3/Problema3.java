

package Tiendadelibros2;
import java.util.ArrayList;
import java.util.Scanner;


public class Tiendadelibros2 {
    
    static Scanner in = new Scanner(System.in);
    
   static ArrayList<String> nombre_libro = new ArrayList<>();
   static ArrayList<String> codigo_libro = new ArrayList<>();
   static ArrayList<Integer> precio_libro = new ArrayList<>();
   static ArrayList<Integer> cantidad_libro = new ArrayList<>();
   static ArrayList<String> carrito_compras_codigo = new ArrayList<>();
   static ArrayList<Integer> carrito_compras_cantidad = new ArrayList<>();
    
    public static void main(String[] args) {

   nombre_libro.add("Serway");
   nombre_libro.add("Marx");
   nombre_libro.add("Tolkien");
   nombre_libro.add("Thonsom");
   
   
   codigo_libro.add("1234");
   codigo_libro.add("2345");
   codigo_libro.add("3456");
   codigo_libro.add("4567");
   
   precio_libro.add(150000);
   precio_libro.add(125000);
   precio_libro.add(200000);
   precio_libro.add(160000);
   
   cantidad_libro.add(5);
   cantidad_libro.add(7);
   cantidad_libro.add(10);
   cantidad_libro.add(4);

        String opcion;
        System.out.println("Por favor ingrese el numero de la opcion que deasea usar:");
        System.out.println("1.Catalogo   2.Total");

        opcion = in.next();
        
        if(opcion.equals("1")){
            catalogo();    
        }
        if(opcion.equals("2")){
            total();    
        }
    }

    public static void catalogo (){
        
        System.out.println("El catalogo disponible: ");
        
        for(int i=0;i<nombre_libro.size() ;i++){
            
            System.out.println("Nombre del libro:"+nombre_libro.get(i)
            +"   ISBN:"+codigo_libro.get(i)+"   Precio del libro:$"+precio_libro.get(i)+"   Cantidad:"+cantidad_libro.get(i));
                     
        }
       
        System.out.println("desea ingresar el carrito y/n");
        String opcion1 = in.next(); 
        if(opcion1.equals("y")){
             carrito();
             
        }else{
            System.out.println("Secion terminada");
            
        }
   
    }
    
    public static void carrito (){
        boolean existe_libro;
        int index;
        System.out.println("1) Vender 2)Borrar 3)Atras 4)Añadir libro");
        
        String opcion3;
        opcion3 = in.next();
        
        
         if(opcion3.equals("4")){
            añadir_libro();
            
        }  
        if(opcion3.equals("3")){
         System.out.println("Por favor ingrese el numero de la opcion que deasea usar:");
         System.out.println("1.Catalogo   2.Total");
        
        
        String opcion = in.next();
        
        if(opcion.equals("1")){
            catalogo();    
        }
        if(opcion.equals("2")){
            total();    
        }  
        
        }
        
        if(opcion3.equals("1")){
              System.out.println("El catalogo disponible: ");
        
        for(int i=0;i<nombre_libro.size() ;i++){
            
            System.out.println("Nombre del libro:"+nombre_libro.get(i)
            +"   ISBN:"+codigo_libro.get(i)+"   Precio del libro:$"+precio_libro.get(i)+"   Cantidad:"+cantidad_libro.get(i));
                     
        }
            System.out.println("Digita codigo del libro a vender");
            
            String codigo_venta=in.next();
            existe_libro=codigo_libro.contains(codigo_venta);
            
            if (existe_libro ){
            
                index=codigo_libro.indexOf(codigo_venta);
                
                
                if (cantidad_libro.get(index)==0){
                     System.out.println("No esta disponible el libro");
                     carrito();
                }
                
                if (carrito_compras_codigo.contains(codigo_venta)){
                   carrito_compras_cantidad.set(carrito_compras_codigo.indexOf(codigo_venta), carrito_compras_cantidad.get(carrito_compras_codigo.indexOf(codigo_venta))+1);

                }
                else{
                    carrito_compras_codigo.add(codigo_venta);
                    carrito_compras_cantidad.add(1);

                }
                
                cantidad_libro.set(index, cantidad_libro.get(index)-1);
                System.out.println("Libro "+nombre_libro.get(index)+" añadido al carrito");
                carrito();
            }
            
            else {
            System.out.println("No existe el libro");
            carrito();
            
            }
           
        }
        
        if(opcion3.equals("2")){
            System.out.println("Estos son los libros de su carrito");
            
             for(int i=0;i<carrito_compras_codigo.size();i++){
            
            System.out.println("Nombre del libro:"+nombre_libro.get(codigo_libro.indexOf(carrito_compras_codigo.get(i)))+"   Cantidad:"+carrito_compras_cantidad.get(i));
                      
        }
            
            System.out.println("Digite el codigo del libro que quiere borrar del carrito");
            
            String codigo_borrar=in.next();
            
            
            boolean existe_libro_borrar=carrito_compras_codigo.contains(codigo_borrar);
            
            if (existe_libro_borrar ){
                
             int index_borrar=   carrito_compras_codigo.indexOf(codigo_borrar);
             
            carrito_compras_cantidad.set(index_borrar, carrito_compras_cantidad.get(index_borrar)-1);
            
            if (carrito_compras_cantidad.get(index_borrar)==0){
                carrito_compras_cantidad.remove(index_borrar);
                carrito_compras_codigo.remove(index_borrar);
                     
            }
             
             carrito();
        }
            else {
                
         System.out.println("El libro no existe en el carrito de compras");
         carrito();
            }
 
    }
    }
    public static void total (){
        
        System.out.println("El total: ");
        int total=0;
        for(int i=0;i<carrito_compras_codigo.size();i++){
            
            System.out.println("Nombre del libro:"+nombre_libro.get(codigo_libro.indexOf(carrito_compras_codigo.get(i)))
                    +"   Cantidad:"+carrito_compras_cantidad.get(i)+
                    "   Subtotal:$"+precio_libro.get(codigo_libro.indexOf(carrito_compras_codigo.get(i)))+"   Total:$"+
                    (precio_libro.get(codigo_libro.indexOf(carrito_compras_codigo.get(i))))*carrito_compras_cantidad.get(i));
          total=total +
                    (precio_libro.get(codigo_libro.indexOf(carrito_compras_codigo.get(i))))*carrito_compras_cantidad.get(i);  
                      
        }
        System.out.println("Su total es:$"+total);
       
    }
    
    public static void añadir_libro (){
        boolean existe_codigo;
        int codido;
        System.out.println("Ingrese el codigo del libro: ");
        
        String codigo=in.next();
        existe_codigo=codigo_libro.contains(codigo);
        
         if (!existe_codigo){
            
                codigo_libro.add(codigo);
         
        System.out.println("Ingrese el nombre del libro: ");
        
        String nombre=in.next();
        nombre_libro.add(nombre);
        
        System.out.println("Ingrese el precio del libro: ");
        
        String precio=in.next();
        precio_libro.add(Integer.parseInt(precio));
        
        System.out.println("Ingrese la cantidad del libro: ");
        
        String cantidad=in.next();
        cantidad_libro.add(Integer.parseInt(cantidad));
        
        catalogo();
         }
         
         else {System.out.println("Ya exite un libro con ese codigo");}
      añadir_libro();
           
    }
    
}
