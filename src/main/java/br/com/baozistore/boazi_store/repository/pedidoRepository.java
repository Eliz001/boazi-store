package br.com.baozistore.boazi_store.repository;

import br.com.baozistore.boazi_store.model.pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pedidoRepository extends JpaRepository<pedido, Long> {
}