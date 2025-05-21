CREATE TABLE clients (
                         id bigint NOT NULL AUTO_INCREMENT,
                         cpf varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         email varchar(155) COLLATE utf8mb4_unicode_ci NOT NULL,
                         name varchar(155) COLLATE utf8mb4_unicode_ci NOT NULL,
                         phone varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         created_at datetime(6) DEFAULT NULL,
                         updated_at datetime(6) DEFAULT NULL,
                         PRIMARY KEY (id),
                         UNIQUE KEY (email),
                         UNIQUE KEY (cpf)
);