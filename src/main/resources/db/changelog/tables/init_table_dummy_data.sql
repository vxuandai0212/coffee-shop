CREATE TABLE categories (
  id               INT          PRIMARY KEY generated always as identity,
  name             VARCHAR(200) NOT NULL,
  is_valid         BOOLEAN      NOT NULL    DEFAULT true
);

CREATE TABLE items (
  id               INT          PRIMARY KEY generated always as identity,
  name             VARCHAR(200) NOT NULL,
  category_id      INT          NOT NULL,
  prepare_time     SMALLINT     NOT NULL,
  image_url        VARCHAR(250),
  is_valid         BOOLEAN      NOT NULL    DEFAULT true
);

CREATE TABLE shop_item (
  id               INT             PRIMARY KEY generated always as identity,
  item_id          INT             NOT NULL,
  price            NUMERIC(10, 2)  NOT NULL,
  shop_id          INT             NOT NULL,
  is_valid         BOOLEAN         NOT NULL    DEFAULT true
);

CREATE TABLE shops (
  id               INT             PRIMARY KEY generated always as identity,
  location         VARCHAR(250)    NOT NULL,
  contact          VARCHAR(20)     NOT NULL,
  open_time        VARCHAR(20)     NOT NULL,
  close_time       VARCHAR(20)     NOT NULL,
  is_valid         BOOLEAN         NOT NULL    DEFAULT true
);

CREATE TABLE queues (
  id               INT             PRIMARY KEY generated always as identity,
  max_size         SMALLINT        NOT NULL,
  shop_id          INT             NOT NULL,
  is_valid         BOOLEAN         NOT NULL    DEFAULT true
);

CREATE TABLE orders (
  id               INT             PRIMARY KEY generated always as identity,
  customer_id      INT             NOT NULL,
  queue_id         INT             NOT NULL,
  status           VARCHAR(20)     NOT NULL,
  created_at       TIMESTAMP       NOT NULL   DEFAULT now(),
  updated_at       TIMESTAMP       NOT NULL   DEFAULT now()
);

CREATE TABLE order_detail (
  id               INT             PRIMARY KEY generated always as identity,
  shop_item_id     INT             NOT NULL,
  quantity         SMALLINT        NOT NULL,
  order_id         INT             NOT NULL
);

CREATE TABLE users (
  id               INT             PRIMARY KEY generated always as identity,
  phone            VARCHAR(20)     NOT NULL,
  password         VARCHAR(200)    NOT NULL,
  name             VARCHAR(100)    NOT NULL,
  home_address     VARCHAR(200),
  work_address     VARCHAR(200),
  role             VARCHAR(20)
);

INSERT INTO users (phone, password, name)
VALUES
('11111111','$2a$10$VcdzH8Q.o4KEo6df.XesdOmXdXQwT5ugNQvu1Pl0390rmfOeA1bhS','admin'), --12345678
('22222222','$2a$10$VcdzH8Q.o4KEo6df.XesdOmXdXQwT5ugNQvu1Pl0390rmfOeA1bhS','operator'),
('33333333','$2a$10$VcdzH8Q.o4KEo6df.XesdOmXdXQwT5ugNQvu1Pl0390rmfOeA1bhS','customer-1'),
('44444444','$2a$10$VcdzH8Q.o4KEo6df.XesdOmXdXQwT5ugNQvu1Pl0390rmfOeA1bhS','customer-2');

INSERT INTO categories (name)
VALUES
('Food'),
('Drink')
;

INSERT INTO items (name, category_id, prepare_time)
VALUES
('Noodles', 1, 10),
('Orange juice', 2, 5)
;

INSERT INTO shop_item (item_id, price, shop_id)
VALUES
(1, 5.5, 1),
(2, 2, 1)
;

INSERT INTO shops (location, contact, open_time, close_time)
VALUES
('Tran Thai Tong street', '112233', '9AM', '5PM');

INSERT INTO queues (max_size, shop_id)
VALUES
(10, 1),
(20, 1);

INSERT INTO orders (customer_id, queue_id, status)
VALUES
(3, 1, 'WAITING'),
(4, 2, 'WAITING');

INSERT INTO order_detail (shop_item_id, quantity, order_id)
VALUES
(1, 2, 1),
(2, 4, 2);
