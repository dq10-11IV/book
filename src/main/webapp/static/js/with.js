$('example').hide();
(function ( $ ) {
	var methods = {
		settings: {
			selector: '[data-with]:not(example [data-with])',
			inst: '<inst></inst>'
		},
		
		map: {
			text: $.fn.text,
			val: $.fn.val,
			contain: function ( data ) {
				//find example, if failed, return
				if ( this.find( 'example' ).length == 0 ) return;
				
				//new instance of example and fill it
				var inst = $( methods.settings.inst ).append( $( this.find('example').html().trim() ) );
				
				for ( var item in data ) {
					inst.fill( data[item] );
					
					var newInst = $( inst.html().trim() ).removeAttr( 'data-with' );
					this.append( newInst );
				}
			}
		},
		
		fill: function ( that, data ) {
			//not empty or null
			if ( typeof data == 'undefined' || JSON.stringify( data ) == '{}' ) return that;
			
			methods.el = that;
			
			$( that ).find( methods.settings.selector ).each( function() {
				methods.fillself( this, data);
			} );
			
			return $(that);
		},
		
		fillself: function ( that, data ) {
			var params = $( that ).data( 'with' ).split( ';' );
			
			for ( var item in params ) {
				var method = methods.getmethod( params[item] );
				var arg = methods.getargument( params[item], data );
				
				methods.map[method].call( $( that ), arg );
			}
		},
		
		getmethod: function ( param ) {
			return param.split( ':' )[0].trim();
		},
		
		getargument: function ( param, data ) {
			var key = param.split( ':' ).slice( 1 );
			if ( key.length == 0 ) {
				return data;
			} else {
				return data[key[0].trim()];
			}
		}
	};
	
	$.fn.fill = function ( data ) {
		return this.each( function() {
			return methods.fill( this, data );
		});
	};
	
})( jQuery );

if ( typeof result !== 'undefined' ) {
	$( document ).fill( result )
}