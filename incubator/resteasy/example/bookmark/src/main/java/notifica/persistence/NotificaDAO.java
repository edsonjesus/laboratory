package notifica.persistence;

import java.util.List;

import notifica.entity.Notifica;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class NotificaDAO extends JPACrud<Notifica, Long> {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Notifica> findAll() {
		return findByJPQL("select b from Notifica b order by b.nome");
	}
}
