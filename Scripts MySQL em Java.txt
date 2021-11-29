create database Banco_Mercado;
Use banco_mercado;

CREATE TABLE Venda (
    Cod_venda INT NOT NULL AUTO_INCREMENT,
    data_venda DATE,
    numeroNF VARCHAR(500),
    subtotal DOUBLE(10,2),
    total DOUBLE(10,2),
    PRIMARY KEY (Cod_venda)
);

INSERT INTO venda (cod_venda, data_venda, numeroNF, subtotal, total) VALUES (null, '2017-06-05', '51080701212344000127550010000000981364117781', '3.50', '3.50'),
																																		(null, '2019-06-04', '51080701212343000127550010000000981364117781', '3.50', '3.50'),
																																		(null, '2019-06-02', '51080701212343000127550011000000981364117781', '10.50', '10.50');


#select * from estoque;
CREATE TABLE Estoque (
    cod_estoque INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100),
    Quantidade INT(50),
    ValorUnitario DOUBLE(10,2),    
	qtdUnidade Double(10,2),
    tipoUnidade  VARCHAR(100),
    PRIMARY KEY (Cod_estoque)
);

#select * from estoque;
#select ValorUnitario from estoque where cod_estoque LIKE 1;

INSERT INTO estoque (cod_estoque, nome, quantidade, ValorUnitario, qtdUnidade, tipoUnidade) VALUES (null, "Coca-Cola", 3, 3.50, 0.6, "Litro"),
																																											  (null, "Arroz", 2, 10.50, 5, "Quilograma"),
																																											  (null, "Garrafa de Agua", 4, 1.50, 0.6, "Litro"),
																																											  (null, "Massa Spaguetti", 5, 2.70, 0.25, "Quilograma"),
																																											  (null, "Arroz", 7, 2.30, 1, "Quilograma"),
                                                                                                                                                                              (null, "Coca-Cola", 3, 9.50, 3.0, "Litro"),
                                                                                                                                                                              (null, "Arroz", 7, 7.30, 5, "Quilograma"),
                                                                                                                                                                              (null, "Feijão", 4, 2.50, 1, "Quilograma"),
																																											  (null, "Tomate", 5, 6.30, 1, "Quilograma"),
																																										      (null, "Batata", 9, 2.10, 1, "Quilograma");
          
CREATE TABLE Internacionalizacao (
    cod_inter INT NOT NULL AUTO_INCREMENT,
    moeda VARCHAR(100),
    PRIMARY KEY (cod_inter)
);

#select * from Internacionalizacao;
INSERT INTO Internacionalizacao(moeda) VALUES ("BRL");

CREATE TABLE ItemVenda (
    cod_itemvenda INT NOT NULL AUTO_INCREMENT,
    ValorUnitario DOUBLE(10,2),
    Quantidade INT(50),
    Total DOUBLE(10,2),
    cod_venda INT,
    cod_estoque INT,
    FOREIGN KEY (cod_venda)
        REFERENCES venda (cod_venda)
        ON UPDATE CASCADE ON DELETE SET NULL,
    FOREIGN KEY (cod_estoque)
        REFERENCES estoque (cod_estoque)
        ON UPDATE CASCADE ON DELETE SET NULL,
    PRIMARY KEY (cod_itemvenda)
);

INSERT INTO ItemVenda (cod_itemvenda, ValorUnitario, quantidade, Total, cod_venda, cod_estoque) VALUES (null, '3.50', 1, '3.50', 1, 1),
																									   (null, '3.50', 1, '3.50', 2, 1),
                                                                                                       (null, '10.50', 1, '10.50', 3, 5);
                                                                                                       
CREATE TABLE Compra (
    Cod_compra INT NOT NULL AUTO_INCREMENT,
    data_compra DATE,
    numeroNF VARCHAR(255),
    subtotal DOUBLE(10,2),
    total DOUBLE(10,2),
    PRIMARY KEY (cod_compra)
);

INSERT INTO compra (cod_compra, data_compra, numeroNF, subtotal, total) VALUES (null, '2017-06-02', '51086701212344000127550010000000981364117781', '2.50', '2.50'),
																			   (null, '2019-06-01', '51080701212143000127550010000000981364117781', '2.50', '2.50'),
																			   (null, '2019-06-01', '51080701212343008127550011000000981364117781', '8.50', '8.50');

CREATE TABLE ItemCompra (
    cod_itemcompra INT NOT NULL AUTO_INCREMENT,
    ValorUnitario DOUBLE(10,2),
    Quantidade INT(50),
    Total DOUBLE(10,2),
    cod_compra INT,
    cod_estoque INT,
    FOREIGN KEY (cod_compra)
        REFERENCES Compra (cod_compra)
        ON UPDATE CASCADE ON DELETE SET NULL,
    FOREIGN KEY (cod_estoque)
        REFERENCES estoque (cod_estoque)
        ON UPDATE CASCADE ON DELETE SET NULL,
    PRIMARY KEY (cod_itemcompra)
);

INSERT INTO ItemCompra (cod_itemCompra, ValorUnitario, quantidade, Total, cod_Compra, cod_estoque) VALUES (null, '2.50', 1, '2.50', 1, 1),
																										  (null, '2.50', 1, '2.50', 2, 1),
                                                                                                          (null, '8.50', 1, '8.50', 3, 5);