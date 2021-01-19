select * from aumbanco.tb_vendas 
inner join aumbanco.tb_produtos_venda as pv 
inner join tb_produtos as prod
where pv.id_venda=tb_vendas.id_venda and pv.id_produto=prod.id_prod;