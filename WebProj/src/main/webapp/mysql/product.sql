CREATE TABLE IF NOT EXISTS product(
    p_id VARCHAR(10) NOT NULL,
    p_name VARCHAR(10),
    p_unitPrice INTEGER,
    p_description TEXT,
    p_category VARCHAR(20),
    p_manufacturer VARCHAR(20),
    p_unitsInStock LONG,
    p_condition VARCHAR(20),
    p_fileName VARCHAR(20),
    PRIMARY KEY (p_id)
) DEFAULT CHARSET=utf8;

ALTER TABLE product MODIFY COLUMN p_name VARCHAR(20);
