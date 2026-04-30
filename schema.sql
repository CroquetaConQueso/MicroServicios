CREATE DATABASE micro_servicios;

CREATE TABLE IF NOT EXISTS products (
    id_producto SERIAL PRIMARY KEY,
    nombre_producto VARCHAR(50) NOT NULL,
    precio_producto NUMERIC(10,2) NOT NULL,
    creado_en TIMESTAMP,
    cantidad INTEGER NOT NULL DEFAULT 0,
    descripcion TEXT,
    codigo_producto VARCHAR(53) NOT NULL UNIQUE
);


CREATE TABLE lotes (
    id_lote SERIAL PRIMARY KEY,
    product_id BIGINT NOT NULL,
    cantidad INTEGER NOT NULL,
    codigo_lote VARCHAR(100) NOT NULL UNIQUE,
    destinatario VARCHAR(100) NOT NULL
);


INSERT INTO products (
    nombre_producto,
    precio_producto,
    creado_en,
    cantidad,
    descripcion,
    codigo_producto
) VALUES
('Teclado mecánico', 49.99, NOW(), 25, 'Teclado mecánico con switches azules', gen_random_uuid()::text),
('Ratón inalámbrico', 19.99, NOW(), 40, 'Ratón ergonómico inalámbrico', gen_random_uuid()::text),
('Monitor 24 pulgadas', 129.99, NOW(), 15, 'Monitor Full HD de 24 pulgadas', gen_random_uuid()::text),
('Portátil oficina', 699.99, NOW(), 8, 'Portátil para tareas de oficina y estudio', gen_random_uuid()::text),
('Auriculares gaming', 39.99, NOW(), 30, 'Auriculares con micrófono integrado', gen_random_uuid()::text),
('Webcam HD', 29.99, NOW(), 20, 'Cámara web HD para videollamadas', gen_random_uuid()::text),
('Disco SSD 1TB', 89.99, NOW(), 18, 'Unidad SSD SATA de 1TB', gen_random_uuid()::text),
('Memoria RAM 16GB', 59.99, NOW(), 22, 'Módulo de memoria DDR4 de 16GB', gen_random_uuid()::text),
('Fuente 650W', 74.99, NOW(), 12, 'Fuente de alimentación 80 Plus de 650W', gen_random_uuid()::text),
('Caja ATX', 54.99, NOW(), 10, 'Caja ATX con ventilación frontal', gen_random_uuid()::text),
('Placa base B550', 119.99, NOW(), 7, 'Placa base compatible con procesadores Ryzen', gen_random_uuid()::text),
('Procesador Ryzen 5', 169.99, NOW(), 9, 'Procesador AMD Ryzen 5 para escritorio', gen_random_uuid()::text),
('Tarjeta RTX 4060', 329.99, NOW(), 5, 'Tarjeta gráfica NVIDIA RTX 4060', gen_random_uuid()::text),
('Cable HDMI', 8.99, NOW(), 60, 'Cable HDMI de 2 metros', gen_random_uuid()::text),
('Hub USB-C', 24.99, NOW(), 35, 'Hub USB-C con múltiples puertos', gen_random_uuid()::text),
('Silla ergonómica', 149.99, NOW(), 6, 'Silla ergonómica para escritorio', gen_random_uuid()::text),
('Mesa escritorio', 199.99, NOW(), 4, 'Mesa amplia para oficina o estudio', gen_random_uuid()::text),
('Router WiFi 6', 89.99, NOW(), 14, 'Router compatible con WiFi 6', gen_random_uuid()::text),
('Impresora multifunción', 109.99, NOW(), 11, 'Impresora con escáner integrado', gen_random_uuid()::text),
('Alfombrilla XL', 14.99, NOW(), 50, 'Alfombrilla grande para teclado y ratón', gen_random_uuid()::text);