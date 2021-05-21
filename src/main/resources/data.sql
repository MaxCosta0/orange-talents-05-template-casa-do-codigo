INSERT INTO CATEGORIA(id, nome)
VALUES (1, "Terror");

INSERT INTO CATEGORIA(id, nome)
VALUES (2, "Misterio");

INSERT INTO AUTOR(id, data_criacao, descricao, email, nome)
VALUES (1, "2000/05/05", "descricao1", "autor@email.com", "Maxley");

INSERT INTO AUTOR(id, data_criacao, descricao, email, nome)
VALUES (2, "2000/05/05", "descricao2", "autor@gmail.com", "Max");

INSERT INTO LIVRO(id, titulo, resumo, sumario, preco, numero_paginas, isbn, data_Publicacao, categoria_id, autor_id)
VALUES (1, "titulo1", "resumo1", "sumario1", 30, 105, "9781305651906", "2021/07/07", 1, 1);

INSERT INTO LIVRO(id, titulo, resumo, sumario, preco, numero_paginas, isbn, data_Publicacao, categoria_id, autor_id)
VALUES (2, "titulo2", "resumo2", "sumario2", 30, 105, "9771305651906", "2021/07/07", 1, 1);

INSERT INTO LIVRO(id, titulo, resumo, sumario, preco, numero_paginas, isbn, data_Publicacao, categoria_id, autor_id)
VALUES (3, "titulo3", "resumo3", "sumario3", 30, 105, "9761305651906", "2021/07/07", 1, 1);

INSERT INTO LIVRO(id, titulo, resumo, sumario, preco, numero_paginas, isbn, data_Publicacao, categoria_id, autor_id)
VALUES (4, "titulo4", "resumo4", "sumario4", 30, 105, "9751305651906", "2021/07/07", 1, 1);

INSERT INTO PAIS(id, nome)
VALUES (1, "Pais1");

INSERT INTO PAIS(id, nome)
VALUES (2, "Pais2");

INSERT INTO ESTADO(id, nome, pais_id)
VALUES (1, "Estado1", 1);

INSERT INTO ESTADO(id, nome, pais_id)
VALUES (2, "Estado2", 1);