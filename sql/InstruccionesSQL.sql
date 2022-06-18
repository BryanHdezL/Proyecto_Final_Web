SELECT producto.nombre_producto, SUM(1) as cantidad
    FROM venta JOIN producto ON venta.id_producto = producto.id_producto
    GROUP BY producto.id_producto
    ORDER BY cantidad DESC LIMIT 10;
    
SELECT producto.nombre_producto, SUM(1) as cantidad
    FROM venta JOIN producto ON venta.id_producto = producto.id_producto
    WHERE fecha_venta BETWEEN '21-01-01' AND '21-04-28'
    GROUP BY producto.id_producto
    ORDER BY cantidad DESC LIMIT 10;
    
SELECT producto.nombre_producto, SUM(1) as cantidad
    FROM venta JOIN producto JOIN categoria ON venta.id_producto = producto.id_producto and categoria.id_categoria = producto.id_categoria
    where categoria.nombre_categoria = 'TECNOLOGIA'
    GROUP BY producto.id_producto
    ORDER BY cantidad DESC LIMIT 5;