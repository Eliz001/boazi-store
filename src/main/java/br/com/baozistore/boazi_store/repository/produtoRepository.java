
package br.com.baozistore.boazi_store.repository;

import br.com.baozistore.boazi_store.model.produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface produtoRepository extends JpaRepository<produto, Long> {

}
