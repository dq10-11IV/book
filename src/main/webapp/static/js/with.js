function dataWith( result ) {
	var data = result.data;
	
	$('[data-with]').each ( function () {
		var wth = $(this).data('with').split(':');
		
		fillWith( this, wth );
	});
	
	function fillWith( el, wth ) {
		var fuc = wth[0].trim(); var par = wth[1].trim(); var val = data[par];

		if ( typeof val !== 'undefined') {
			$.fn[fuc].call( $(el), val );
		}
	}
};