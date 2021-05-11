INSERT INTO `user` (`id_user`, `data_criacao`, `email`, `nome`, `senha`, `tel_cel`) VALUES (NULL, NULL, 'fernando@casa.com', 'Fernando', '12345678', '11999994545');
INSERT INTO `user` (`id_user`, `data_criacao`, `email`, `nome`, `senha`, `tel_cel`) VALUES (NULL, NULL, 'carlos@casa.com', 'Carlos', '12345678', '11987654396');
INSERT INTO `user` (`id_user`, `data_criacao`, `email`, `nome`, `senha`, `tel_cel`) VALUES (NULL, NULL, 'flagner@casa.com', 'Flagner', '12345678', '41987654396');

INSERT INTO `categoria` (`id_categoria`, `data_criacao`, `nome_cat`) VALUES (1, NULL, 'Gastronomia');

INSERT INTO `sub_cat` (`id_subcat`, `data_criacao`, `nome_sub_cat`, `id_categoria`) VALUES (1, NULL, 'Bares/Lanches', 1);

INSERT INTO `servico` (`id_servico`, `data_criacao`, `icon_servico`, `nome_servico`, `tipo_servico`, `id_sub_cat`) VALUES (NULL, NULL, 'fa-wheelchair', 'Cadeirante', 'Acessibilidade', 1);
