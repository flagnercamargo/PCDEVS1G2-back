INSERT INTO `user`(`id_user`, `data_criacao`, `email`, `nome`, `senha`, `tel_cel`) VALUES (null,null,'rafael@dh.com.br','Rafael','123456','78 5698-9856')

INSERT INTO `categoria`(`id_categoria`, `data_criacao`, `nome_cat`) VALUES (1,null,'Gastronomia')
INSERT INTO `categoria`(`id_categoria`, `data_criacao`, `nome_cat`) VALUES (2,null,'Hospedagem')

INSERT INTO `subcategoria`(`id_subcat`, `data_criacao`, `nome_sub_cat`, `id_categoria`) VALUES (1,null,'Hotel',2)
INSERT INTO `subcategoria`(`id_subcat`, `data_criacao`, `nome_sub_cat`, `id_categoria`) VALUES (2,null,'Resort',2)

INSERT INTO `servico`(`id_servico`, `data_criacao`, `icon_servico`, `nome_servico`, `tipo_servico`) VALUES (1,null,'fa-wifi','Wi-Fi','Conveniência')
INSERT INTO `servico`(`id_servico`, `data_criacao`, `icon_servico`, `nome_servico`, `tipo_servico`) VALUES (2,null,'fa-wifi','Estacionamento','Conveniência')

INSERT INTO `servico_subcategoria`(`id_servico`, `id_subcategoria`) VALUES (1, 1)
INSERT INTO `servico_subcategoria`(`id_servico`, `id_subcategoria`) VALUES (2, 1)
INSERT INTO `servico_subcategoria`(`id_servico`, `id_subcategoria`) VALUES (2, 2)

INSERT INTO `estabelecimento`(`id_estab`, `cnpj`, `data_criacao`, `descr_negocio`, `email`, `bairro`, `cep`, `cidade`, `complemento`, `estado`, `logradouro`, `mapa`, `numero`, `referencia`, `foto_logomarca`, `horario_func`, `nome_fantasia`, `razao_social`, `site`, `status`, `tel_cel`, `tel_fixo`, `responsavel`, `id_subcat`) VALUES (1, '69.802.375/0001-20', null,'Hotel com infraestrutura para: cozinha, cozinha,  energia elétrica e estacionamento. Único camping pé na areia de Bertioga.','mamo@email.com','Albatroz','11250-216','Bertioga','','SP','Rua João Ramalho','','899','','','Seg-Sab:08:00 as 20:00 Dom::Fechado','Camping Bertioga','Hospedagem e Camping Bertioga ME','minhasite.com',1,'(13) 99999-9999','(13) 1222-2233','1','1')
INSERT INTO `estabelecimento`(`id_estab`, `cnpj`, `data_criacao`, `descr_negocio`, `email`, `bairro`, `cep`, `cidade`, `complemento`, `estado`, `logradouro`, `mapa`, `numero`, `referencia`, `foto_logomarca`, `horario_func`, `nome_fantasia`, `razao_social`, `site`, `status`, `tel_cel`, `tel_fixo`, `responsavel`, `id_subcat`) VALUES (2, '69.802.255/0001-20', null,'Resort com infraestrutura para: cozinha, cozinha,  energia elétrica e estacionamento. Único camping pé na areia de Bertioga.','mamona@email.com','Pelicano','11250-218','Maresias','','SP','Rua João Ramalho','','899','','','Seg-Sab:08:00 as 20:00 Dom::Fechado','Camping Bertioga','Hospedagem e Camping Bertioga ME','minhasite.com',1,'(13) 99999-9999','(13) 1222-2233','1','2')


INSERT INTO `estabelecimento_servico`(`id_estabelecimento`, `id_servico`) VALUES (1,1)
INSERT INTO `estabelecimento_servico`(`id_estabelecimento`, `id_servico`) VALUES (2,1)
INSERT INTO `estabelecimento_servico`(`id_estabelecimento`, `id_servico`) VALUES (2,2)