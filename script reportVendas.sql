select * from aumbanco.tb_vendas 
inner join aumbanco.tb_produtos_venda 
inner join aumbanco.tb_cliente_fornecedor
where tb_vendas.id_cliente=tb_cliente_fornecedor.id tb_vendas.id_venda=tb_produtos_venda.id_venda;