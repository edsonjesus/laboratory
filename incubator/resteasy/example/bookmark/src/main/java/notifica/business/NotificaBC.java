package notifica.business;

import notifica.entity.Notifica;
import notifica.persistence.NotificaDAO;
import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@BusinessController
public class NotificaBC extends DelegateCrud<Notifica, Long, NotificaDAO> {

	private static final long serialVersionUID = 1L;

	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			insert(new Notifica("Juvenal Souza Filho", "juvenal.filho@cabrobro.com"));
			insert(new Notifica("Airmateia Araujo Salgado", "arimateia.salgado@cabrobro.com"));

			for (int i = 0; i < 1000; i++) {
				insert(new Notifica("Usuario Notifica " + i, i + "@cabrobro.com"));
			}
		}
	}
}
