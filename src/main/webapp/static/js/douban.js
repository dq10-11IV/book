function douban () {
	var $ = jQuery;
	var settings = {
		book: {
			url: 'http://api.douban.com/book/subject/isbn/',
			urlSuffix: '?alt=xd&callback=?',
			atrributes: [
				'title', 'author', 'summary', 'price', 'publisher', 'author-intro'
			]
		}
	}
	
	var methods = {
		urlIsbn: function( isbn ) {
			return settings.book.url + isbn + settings.book.urlSuffix;
		},
		
		//book
		book: function( book ) {
			var data = {};
			var attrs = book["db:attribute"]
			
			data.title = book.title["$t"];
			for ( var attr in  attrs) {
				var key = attrs[attr]["@name"];
				var val = attrs[attr]["$t"];
				data[key] = val;
			}
			return data;
		}
	}
	
	this.askBookByIsbn = function ( isbn ) {
		var data = {};
		$.getJSON( methods.urlIsbn( isbn ), function ( book ) {
			$.extend( data, methods.book( book ) );
		});
		return data;
	}
}