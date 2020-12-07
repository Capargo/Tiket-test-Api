CREATE TABLE `estado` (
 `id` int(3) NOT NULL AUTO_INCREMENT,
 `nome` varchar(50) NOT NULL,
 `bandeira_url` varchar(500) NOT NULL,
 PRIMARY KEY(`id`)
) DEFAULT CHARSET=utf8;

CREATE TABLE `cidade` (
 `id` int(3) NOT NULL AUTO_INCREMENT,
 `estado_id` int(3) NOT NULL,
 `nome` varchar(50) NOT NULL,
 `populacao` int(10) NOT NULL,
 PRIMARY KEY (`id`),
 KEY `FK_estado_cidade_estado_id` (`estado_id`),
 CONSTRAINT `FK_estado_cidade_estado_id` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`id`)
) DEFAULT CHARSET=utf8;