(function ($) {
	var methods = {
		res: {
			//字母或下划线开头和结尾，由下划线，字母数字组成@前部分，@后由字母或下划线开头和结尾，点号，后加两或三位字母
			email: /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/,
			
			//字母，下划线，数字，特殊字符 8-22位
			passwd: /^[\_\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{8,22}$/,
			
			//4-16位由数字、字母、下划线
			name: /^[a-zA-Z0-9\_]{4,16}$/
		},
		
		msgs: {
			email: '无效的邮箱名',
			passwd: '8-22位 字母，下划线，数字，特殊字符',
			name: '4-16位 由数字、字母、下划线'
		},
	
		init: function ( that, opt ) {
			//keep the element
			methods.el = that;
			
			methods.settings = $.extend( {
				success: function(el){
				},
				error: function(el, msg) {
				}
			}, opt );
			
			methods.bind();
		},
		
		bind: function () {
			var inputs = $(methods.el).find('input');
			for ( var i = 0; i < inputs.length; i++ ) {
				$(inputs[i]).blur( methods.check );
			}
		},
		
		check: function (e) {
			var _type = $(e.target).data('check');
			if ( typeof _type == 'undefined' ) return;
			
			if ( methods.res[_type].test( $(e.target).val() ) ) {
				methods.settings.success( $(e.target) );
			} else {
				methods.settings.error( $(e.target), methods.msgs[_type] );
			}
		}
	};
	
	//initialize the plugin
	$.fn.checkform = function (method) {
		return this.each( function() {
			if ( methods[method] ) {
				return methods[method].apply( this, Array.prototype.slice.call( arguments, 1 ));
			} else if ( typeof method === 'object' || !method ) {
				return methods.init( this, method );
			} else {
				$.error( 'Method ' + method + ' does not exist on jQuery.checkform' );
			}
		});
	};
})( jQuery );