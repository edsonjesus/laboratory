$(function() {
	$("#new").focus();

	$(document).ready(function() {
		findAllOk();
	});

	$("form").submit(function(event) {
		event.preventDefault();
	});

	$("#new").click(function() {
		location.href = "notifica-edit.html";
	});

	$("#delete").click(function() {
		var ids = [];

		$("input:checked").each(function(index, value) {
			ids.push($(value).val());
		});

		if (ids.length == 0) {
			alert('Nenhum registro selecionado');
		} else if (confirm('Tem certeza que deseja apagar?')) {
			NotificaProxy.remove(ids, removeOk);
		}
	});
});

function findAllOk(data) {
	var oTable = $('#resultList').dataTable({
		"aoColumns" : [ {
			"aTargets" : [ 0 ],
			"mData" : "id",
			"mRender" : function(id) {
				return '<input id="remove-' + id + '" type="checkbox" value="' + id + '">';
			}
		}, {
			"aTargets" : [ 1 ],
			"mData" : "nome",
			"mRender" : function(data, type, full) {
				return '<a href="notifica-edit.html?id=' + full.id + '">' + full.nome + '</a>';
			}
		}, {
			"aTargets" : [ 2 ],
			"mData" : "email",
			"mRender" : function(email) {
				return '<a href="mailto:' + email + '">' + email + '</a>';
			}
		} ],
		"oLanguage" : {
			"sInfo" : "Mostrando _START_ a _END_ de _TOTAL_ registros",
			"sEmptyTable" : "Não há dados disponíveis na tabela",
			"sLengthMenu" : "Mostrar _MENU_ registros",
			"sInfoThousands" : "",
			"oPaginate" : {
				"sFirst" : "Primeiro",
				"sLast" : "Último",
				"sNext" : "Próximo",
				"sPrevious" : "Anterior"
			}
		},
		"bFilter" : false,
		"bRetrieve" : true,
		"sPaginationType" : "bs_full",
		"sAjaxSource" : 'api/notifica/datatables',
		"bServerSide" : true,
		"bSort" : false
	});
	oTable.fnClearTable();
}

function removeOk(data) {
	findAllOk();
}
