

var filters = angular.module('catalogo.filters',[]);

filters.filter('tamanho', function() {
    return function humanFileSize(bytes) {
        var thresh = 1024;
        if(bytes < thresh) return bytes + ' B';
        var units = ['kB','MB','GB','TB','PB','EB','ZB','YB'];
        var u = -1;
        do {
            bytes /= thresh;
            ++u;
        } while(bytes >= thresh);
        return bytes.toFixed(1)+' '+units[u];
    };
  });

filters.filter('tipoArquivo', function() {    
	var tipos = {};
	var path = "images/filetypes/";
	tipos['image']=path+"doc.png";
	tipos['doc']=path+"doc.png";
	tipos['xls']=path+"xls.png";
	tipos['zip']=path+"zip.png";
	tipos['pdf']=path+"pdf.png";
	tipos['unknow']=path+"unknow.png";
	
	return function(tipo){	
		var url = tipos['unknow'];
		if(tipo.indexOf('image')>-1){
			url = tipos['image'];
		}else if(tipo.indexOf('doc')>-1){
			url = tipos['doc'];
		}else if(tipo.indexOf('odt')>-1){
			url = tipos['odt'];
		}else if(tipo.indexOf('xls')>-1){
			url = tipos['xls'];
		}else if(tipo.indexOf('zip')>-1){
			url = tipos['zip'];
		} else if(tipo.indexOf('rar')>-1){
			url = tipos['zip'];
		} else if(tipo.indexOf('tar')>-1){
			url = tipos['zip'];
		} else if(tipo.indexOf('gz')>-1){
			url = tipos['zip'];
		} else if(tipo.indexOf('pdf')>-1){
			url = tipos['pdf'];
		}  		
		return url;		
	};
  });


var operacoes = {
		CRIAR: {icone: "fa fa-plus", badge: "info"}, 
		ATUALIZAR: {icone: "fa fa-save", badge: "primary"}, 
		APROVAR: {icone: "fa fa-thumbs-o-up", badge: "success"}, 
		REPROVAR: {icone: "fa fa-thumbs-o-down", badge: "danger"}, 
		FINALIZAR: {icone: "fa fa-check", badge: "warning"}, 
		EXCLUIR: {icone: "fa fa-warning", badge: "danger"}
};

filters.filter('operacaoIcone', function() {    
		return function(operacao){
			return operacoes[operacao].icone;
		};	
  });

filters.filter('operacaoClass', function() {    
	return function(operacao){
		return operacoes[operacao].badge;
	};	
  });

filters.filter('nomeFase', function() {    
	var nomes = {
			'ANALISE':'Análise',
			'PROSPECCAO': 'Prospecção',
			'INTERNALIZACAO':'Internalização',
			'SUSTENTACAO':'Sustentação', 
			'DECLINIO': 'Declínio'
	};		
	return function(fase){	
		if(!isNaN(parseFloat(fase)) && isFinite(fase)){
			return nomes[Object.keys(nomes)[fase-1]];
		}
		return nomes[fase];		
	};
  });


filters.filter('iconeFase', function() {    
	var url = {
			'ANALISE':'images/fases/analise.png',
			'PROSPECCAO': 'images/fases/prospeccao.png',
			'INTERNALIZACAO':'images/fases/internalizacao.png',
			'SUSTENTACAO':'images/fases/sustentacao.png', 
			'DECLINIO': 'images/fases/declinio.png'
	};
	return function(fase){	
		return url[fase];		
	};
  });

filters.filter('faseUrl', function() {    
	var url = {
			'ANALISE':'analise/edit',
			'PROSPECCAO': 'prospeccao/edit',
			'INTERNALIZACAO':'internalizacao/edit',
			'SUSTENTACAO':'sustentacao/edit', 
			'DECLINIO': 'declinio/edit'
	};
	return function(fase){	
		return url[fase];		
	};
  });

filters.filter('startFrom', function() {	
    return function(input, start) {
    	if(!input) return input;
        start = +start; //parse to int
        return input.slice(start);
    };
});

filters.filter('range', function() {
	  return function(input, total) {
	    total = parseInt(total);
	    for (var i=0; i<total; i++)
	      input.push(i);
	    return input;
	  };
	});

filters.filter('version', function(version) {
    return function(text) {
        return String(text).replace(/\%VERSION\%/mg, version);
      };
});
