package notifica.rest.datatables;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.spi.validation.ValidateRequest;

import notifica.business.NotificaBC;
import notifica.entity.Notifica;
import br.gov.frameworkdemoiselle.pagination.Pagination;
import br.gov.frameworkdemoiselle.pagination.PaginationContext;

@ValidateRequest
@Path("notifica/datatables")
@Produces(APPLICATION_JSON)
public class NotificaDataTablesService {

	@Inject
	private NotificaBC bc;

	@Inject
	private PaginationContext paginationContext;

	@GET
	public DataTablesResult<Notifica> findAllPaged(@QueryParam("sEcho") Integer echo,
			@QueryParam("iDisplayStart") Integer displayStart, @QueryParam("iDisplayLength") Integer displayLength)
			throws Exception {

		Pagination pagination = paginationContext.getPagination(Notifica.class, true);
		pagination.setPageSize(displayLength);
		pagination.setFirstResult(displayStart);

		List<Notifica> data = bc.findAll();
		Long count = (long) pagination.getTotalResults();

		DataTablesResult<Notifica> result = new DataTablesResult<Notifica>();
		result.setEcho(echo);
		result.setTotalRecords(count);
		result.setTotalDisplayRecords(count);
		result.setData(data);

		return result;
	}
}
