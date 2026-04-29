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

